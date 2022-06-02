package com.yedam.java.ch1003;
/*
 * 입출금 잔액조회 하는 클래스
 * 만든 BalanceInsufficientException 예외를 처리하도록
 */
public class Account {
	private long balance;
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {	//입금
		balance += money;
	}
	
	//예외 처리하도록 메소드에도 throws 붙여야함 (강제성)
	public long withDraw(int money) throws BalanceInsufficientException {	//출금	
		if(balance < money) {	//잔액이 적을 때 예외 발생시킬것. 
			throw new BalanceInsufficientException("잔고부족 > "
								+(money-balance)+"원 부족합니다.");
		}
		               
		balance -= money; 		//예외 발생시 뒷부분은 실행 x
		return balance;
	}
}
