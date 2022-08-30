package site.metacoding.ds;

public class userController {
	@RequestMapping("/join")
	public void join() {
		System.out.println("join 호출됨");
	}
	@RequestMapping("/login")
	public void login() {
		System.out.println("login 호출됨");
	}
	public void joinForm() {
		System.out.println("joinform 호출됨");
	}
}
