package shop.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.ProductVO;

public class Cart {
/*
	카트의 기능 분석
	 1) 제품(ProductVO)을 담을(저장) 수 있는 공간 : List<ProductVO>
	 2) 1)에 제품을 저장하는 기능
	 3) 1)에 제품을 삭제하는 기능
	 4) 1)에 있는 모든 제품들을 배열로 반환하는 기능
	 5) 1)에서 특정제품을 검색하는 기능 : 삭제하기 전에 검색한 후 삭제해야 한다.
	 6) 5)에서 검색된 제품의 수량을 변경하는 기능
	 7) 총액 계산
	 
	위 분석에 따른 필요한 멤버변수들(속성)
		- List<ProductVO>
		- int totalPrice(이건 없어도 될것 같다...각 제품(ProductVO)들 안에 totalPrice가 있기 때문이다.)
	 	
	카트의 기능
		- searchProduct : 제품 검색 기능
		- addProduct : 제품 추가 기능
		- delProduct : 제품 삭제 기능
		- changeCount : 수량 변경 기능
		- getList : 배열로 반환하는 기능
*/
	private List<ProductVO> list; //저장공간
	
	public Cart(){
		list = new ArrayList<ProductVO>();
	}
	
	//카트에서 특정 제품(ProductVO)을 검색하여 반환하는 기능(Method)
	public ProductVO searchProduct(String pnum) {
		/*
		for(ProductVO vo : list) { //for(int=i=0; i<list.size() ; i++){
			if(vo.getP_num().equals(pnum)) {
				return vo;
			}
		}
		return null;
		*/
		//검색 속도를 높이기 위해 반복자를 사용!(ArrayList뿐만 아니라 다른 Collection에도 다 사용가능)
		//index 접근(배열, collection)은 첫번째부터 원하는 위치까지 찾아나간다. 커질수록 반복문이 느려짐 > 많은 양의 데이터라면 Iterator 사용
		//반복자(Iterator)는 커서가 움직이면서 위치 찾고 값을 반환
		Iterator<ProductVO> it = list.iterator();
		while(it.hasNext()) {//현재 반복자(커서)의 위치에서 바로 다음칸에 요수가 있다면 true! 아니면 false!
				//hasNext() : 다음 칸에 값이 있으면 true 반환, 커서 이동X
			ProductVO vo = it.next();//반복자가 다음칸으로 이동하여 그곳에 있는 자원을 vo에 저장해준다.
							//next() : 다음 칸으로 이동 후 그 값을 반환
			if(vo.getP_num().equals(pnum)) {
				return vo;
			}
		}//while의 끝
		return null;
	}
	
	//카트에 저장된 모든 제품들을 하나의 배열로 반환하는 기능
	public ProductVO[] getList() {
		ProductVO[] ar = null;
		if(list != null && list.size() > 0) {
			ar = new ProductVO[list.size()];
			list.toArray(ar);
		}
		return ar;
	}
	
	//카트에서 특정 제품을 검색하여 삭제하는 기능
	public boolean delProduct(String pnum) {
		boolean value = false;
		ProductVO vo = searchProduct(pnum);
		if(vo != null) {
			list.remove(vo);//list에서 삭제!
			value = true;
		}
		return value;
	}
	
	//제품을 카트에 저장하는 기능
	public void addProduct(ShopBean sb, String pnum) {
		//현재 인자로 넘어온 선택된 제품번호가 이미 카트에 저장된 제품일 수도 있기 때문에
		//먼저 카트에서 검색부터 한다.
		ProductVO vo = searchProduct(pnum);
		if(vo != null) {//이미 카트에 저장된 제품이다.
			//기존 저장된 제품의 수량을 먼저 얻어낸다.
			int q = vo.getQuant();//vo의 수량을 얻어낸다.
			vo.setQuant(q+1);//vo가 기억하고 있는 수량을 1을 더해 다시 저장한다.
			return;//제어권을 호출한 곳으로 반환한다. 즉, 함수의 수행을 더이상 하지 않는다.
		}
		
		//vo가 null을 가진 경우!(같은 제품이 카트에 없는 경우)
		//선택한 제품을 진열대에서 가져오기 위해 진열대 객체의 p_num이라는 멤버변수의 값을
		//인자로 넘어온 pnum으로 변경한다.
		sb.setP_num(pnum);//1
		vo = sb.getProduct();//2, 진열대에서 원하는 제품을 가져왔다.
		
		//가져온 제품의 수량을 지정한다.
		vo.setQuant(1);
		
		list.add(vo);//3, 카트에 저장
	}
	
	//카트에서 원하는 제품을 검색한 후 수량만 변경하는 기능
	public void changeCount(String pnum, int q) {
		ProductVO vo = searchProduct(pnum);//카트에서 검색!
		if(vo != null) {
			vo.setQuant(q);//수량 변경과 함께 안에 있는 totalPrice도 조정된다.
		}
	}
}
