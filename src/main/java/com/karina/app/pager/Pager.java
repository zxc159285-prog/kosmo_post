package com.karina.app.pager;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pager {

	// 현재 페이지번호
	private Long page;
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 현재페이지에 null이 들어가있으면 안되므로 게터생성
	public Long getPage() {
		if (page == null || page < 1) {
			this.page = 1L;
		}
		return page;
	}
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 리스트에서 ?에들어갈 멤버변수계산
	// 한페이지에 몇개씩 볼것인가 널이면 에러가 나기떄문에 getter메서드를 새로 만들어서 넣어준다
	private Long perPage;
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	//per page getter메서드 
	//setter는 집어넣는거니까 리턴타입이 void이고 매개변수를넣어줘야한다

	public Long getPerPage() {
		if (perPage == null || perPage < 1) {
			this.perPage = 5L;
		}
		return perPage;
	}
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

	// offset번호(블록의 시작번호) 몇개 건너뛸것인가
	private Long startNum;
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	public void makeStartNum() {
		this.startNum = (this.getPage() - 1) * this.getPerPage();

	}

	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	private Long start;
	private long end;
	//이전블럭유무
	private boolean pre=true; //true면 이전블록이 존재
	//다음블럭유무
	private boolean next=true;//true면 다음블록이 존재
	
	//블록출력하기
	public void makePageNum(Long totalCount) {
		//1.총 페이지수 구하기
		Long totalPage=(long)(Math.ceil((double)totalCount/this.getPerPage()));
		
		//2.총 블럭수 구하기 위에거랑 다른방법, 편한거쓰면됨
		Long perBlock=5L; //한블럭당 출력할 번호갯수
		Long totalBlock = totalPage/perBlock;
		if (totalPage%5 != 0) {
			totalBlock++;
		}
		//3.페이지번호로 현재 블럭번호 구하기 현재블럭번호를알아야 시작번호와 끝번호를 구할수있기때문에 여기 잘모르겠음
		Long curBlock= this.getPage()/perBlock;
		if(this.page%perBlock != 0) {
			curBlock++;
		}
		
		//4.위에서구한 현재블록번호로 시작번호와 끝번호구하기
		start= (curBlock-1)*perBlock+1;		
		end=curBlock*perBlock;
		
		//5.현재 블럭번호가 total블럭과 같다면 end페이지 번호를 다시수정
		if(curBlock==totalBlock) {
			end=totalPage;	
			next=false;//다음블럭유무
		}
		
		//6.이전블럭 유무
		
		if(curBlock<2) {
			pre=false;
		}
	}
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		//검색어
		private String search="";
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ	
		//검색어가 아무것도 없을경우
		
			
		
		//검색컬럼 //v1:title v2:contents v3:writer에서
		private String kind;
		
}
