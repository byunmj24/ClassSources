	package am.vo;

public class EmpVO {
	//자원을 가져오기 위해 대상이 되는 테이블(emp)의
	//필요한 컬럼들을 현재 객체의 멤버로 선언한다.
	//(empno, ename, sal, deptno) getter/setter자동생성(LomBok)
	private String empno, ename, sal, deptno;

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	
}
