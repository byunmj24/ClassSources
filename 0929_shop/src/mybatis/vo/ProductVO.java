package mybatis.vo;

public class ProductVO {
	private String num, //기본키
				   category, //카테고리
				   p_num, //제품번호
				   p_name, //제품명
	               p_company, //제조회사
	               p_image_s, //작은 이미지(제품 목록창에서 사용)
	               p_image_l, //큰 이미지(제품 상세보기에서 사용)
	               p_content, //제품 설명
	               p_date; //등록일
	               
	private int p_price, //단가
				p_saleprice, //세일가격
				quant, //수량
				totalPrice; // 세일가격 * 수량	
//sql문을 기반으로 하되 필요한 것이 있으면 quant와 totalPrice처럼 새롭게 만들 수 있다. 

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getP_num() {
		return p_num;
	}

	public void setP_num(String p_num) {
		this.p_num = p_num;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_company() {
		return p_company;
	}

	public void setP_company(String p_company) {
		this.p_company = p_company;
	}

	public String getP_image_s() {
		return p_image_s;
	}

	public void setP_image_s(String p_image_s) {
		this.p_image_s = p_image_s;
	}

	public String getP_image_l() {
		return p_image_l;
	}

	public void setP_image_l(String p_image_l) {
		this.p_image_l = p_image_l;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public String getP_date() {
		return p_date;
	}

	public void setP_date(String p_date) {
		this.p_date = p_date;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_saleprice() {
		return p_saleprice;
	}

	public void setP_saleprice(int p_saleprice) {
		this.p_saleprice = p_saleprice;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
		//수량이 변경될 때 자동적으로 총액도 다시 구해져야 한다.
		//(수량*세일가격)
		setTotalPrice(quant*p_saleprice);
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	//할인율 구하는 기능
	public String getPercent() {
		float per=(p_price-p_saleprice)*100/p_price;
		int value=(int)per; //소수점 이하 절삭!
		return String.valueOf(value); //value+"" 라는 방식으로 하지마!!
	}
	
}