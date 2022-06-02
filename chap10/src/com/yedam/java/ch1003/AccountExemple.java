package com.yedam.java.ch1003;

public class AccountExemple {

	public static void main(String[] args) {

		Account account = new Account(); //계좌생성
		
		account.deposit(1000);
		System.out.println("예금액 : "+account.getBalance());
		
		try {
			account.withDraw(30000);
		} catch (BalanceInsufficientException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());	//메세지만 끌고오기 가능
		}
	}

}
