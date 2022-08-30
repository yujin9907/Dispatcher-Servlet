package site.metacoding.ds;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doProcess 요청됨");
		String httpMethod = req.getMethod();
		System.out.println(httpMethod);
		
		String identifier = req.getRequestURI(); // uri로 넘긴 데이터를 파싱해줌 => 라우팅을 직접할 수 있음
		System.out.println(identifier);
		
		// usercontroller와 협업, 즉, 디스패처 서블릿의 원론적인 역할은, 주소를 파싱해서 컨트룰러 때려주는 것.
		userController c = new userController();
		// 구현1	번
//		if(identifier.equals("/join")) {
//			c.join();
//		} else if (identifier.equals("/login")) {
//			c.login();
//		} else {
//			System.out.println("잘못");
//		}
		// 즉, 이런 요청을 파싱하고 컨트룰러를 실행시키는 로직을 각각의 컨트룰 메서드에서 처리할 수 있지만, 공통되는 부분으로 빼서 디스패처서블릿을 구현할 수 있음.
		
		//구현2번 런타임시 찾을 수 있도록 어노테이션 리플렉션
		// Method[] methodList = userController.class.getDeclaredMethods();//  이렇게 하면 여기서 사용하는 유저 클래스는 new 가 된 게 아니기 때문에
		Method[] methodList = c.getClass().getDeclaredMethods();// 런타임시 클래스를 분석하는 것. => 런타임시 클래스를 분석하는 리플렉션 기법, 어노테이션의 밸류값을 찾는 게 목적
		//foreach 사용
		for (Method method : methodList) {
//			System.out.println(method.getName());
			Annotation annotation = method.getDeclaredAnnotation(RequestMapping.class); // repuest매핑 어노테이션이 걸려 있는지
			RequestMapping requestMapping = (RequestMapping) annotation; // 제네릭 안 쓰고 다운캐스팅함
			
			try {
//				System.out.println(requestMapping.value());
				if(identifier.equals(requestMapping.value())) {
					method.invoke(c);
				}
			} catch (Exception e) {
				System.out.println(method.getName()+"어노테이션 없음");
			}
			
		} // 런타임시 찾을 수 있었음 이 코드를 실행하면서 찾음, 즉 컴파일시 찾음으로 컨트룰러를 나중에 몇개를 만들든 상관업떰
		
	}
}
