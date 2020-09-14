package am.vo;

public class EmpVO {
	//대상이 되는 테이블에서 원하는 컬럼과 동일한 이름으로
	//멤버변수를 선언한다.(사번:empno, 이름:ename, 직종:job)
	
	private String empno, ename, job;

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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
}
