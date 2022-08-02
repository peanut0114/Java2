package co.edu.vo;

public class Criteria {
	private int pageNum;
	private int amount;
	
	//생성자
	public Criteria() {
		this(1,10);	//아래의 생성자를 호출함 (페이지번호 1, 한 페이지의 양 10)
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//toString
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + "]";
	}

	//getter setter
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
}
