package co.edu.vo;


public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String addr;
	
	//getter setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return pwd;
	}
	public void setPasswd(String passwd) {
		this.pwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
