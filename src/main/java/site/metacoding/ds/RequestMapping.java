package site.metacoding.ds;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// int[] arr = {1,2,3}; 배열임 중괄호는

@Target({ElementType.METHOD})// @target으로 변수(필드), 클래스, 메서드 어디에 붙일 어노테이션인지 결정할 수 있음
@Retention(RetentionPolicy.RUNTIME) // 실행 시점을 결정, runtime 런타임시 동작, source 컴파일시
public @interface RequestMapping {
	String value(); // value 메서드는 고정, 키값 // 디폴트 다른 이름으로 만들면 안 됨.
	// 어노테이션 사용시()안에 값을 받기 위해 생성해 놓는 거 // 이게 있어야 값을 넣을 수 있음.
}
\