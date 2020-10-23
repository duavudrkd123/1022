package co.micol.board.vo;

import java.sql.Date;

public class MemberVO {
	private String id;
	private String name;
	private String password;
	private String address;
	private String tel;
	private String author;
	private Date enterdate;

	public MemberVO() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getEnterdate() {
		return enterdate;
	}

	public void setEnterdate(Date enterdate) {
		this.enterdate = enterdate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
//이렇게 가지고 있는게 빈이다~~~
//빈이라는 단어를 안쓰고 보호객체라고 한다.
//보호객체 하나 만들었습니다
// 똑같은 방식으로 하나더 만들어 주어야된다.