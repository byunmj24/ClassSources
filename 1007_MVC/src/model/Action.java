package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//현재 인터페이스는 앞으로 만들어질 모든 Action객체들을 통칭하기 위해 필요하다.
public interface Action {
	String execute(HttpServletRequest request, HttpServletResponse response);
	//인터페이스는 추상메서드만 올수있다! 추상클래스와는 다르다 추상클래스는 일반메서드와 추상메서드가 다 올 수 있으므로 abstract로 구분해준다.
	//접근제어자도 생략한다. public - protected - default - private
	//인터페이스에 있는 추상메서드를 재정의 할때는 무조건 public으로 접근제한을 명시해야 한다.
}
