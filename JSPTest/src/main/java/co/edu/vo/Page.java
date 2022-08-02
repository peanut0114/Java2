package co.edu.vo;

public class Page {
	private int startPage;	//첫번째 페이지 150페이지(11~20) 블럭개념인듯
	private int endPage;	//마지막 페이지
	private boolean prev;	//이전페이지가 있는지
	private boolean next;	//다음페이지가 있는지
	
	private int total;		//전체건수
	private Criteria cri;	//페이지 정보는 담고있는 클래스 (현페이지, 페이지안의 게시물 수)
	
	//생성자
	public Page(Criteria cri, int total){
		this.cri = cri;
		this.total = total;
		//ceil : 올림 (현재 17페이지라면 20이 됨)
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;	//11~17~20
		this.startPage = this.endPage - 9;	
		//실제 끝페이지는 데이터 건수를 지군으로 
		int realEnd = (int)(Math.ceil(total*1.0/cri.getAmount()));	//175건/10=> 18페이지	
		
		if(this.endPage > realEnd){
			this.endPage = realEnd;
		}
		this.prev = this.startPage >1;
		this.next = this.endPage < realEnd;
	}

	//getter setter
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
}
