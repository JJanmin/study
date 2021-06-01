package spring.dto;

import java.sql.Timestamp;

public class MemberDto {
	private String num;
	private String name;
	private String id;
	private String hp;
	private Timestamp gaipday;
	private String pass;
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public Timestamp getGaipday() {
		return gaipday;
	}
	public void setGaipday(Timestamp gaipday) {
		this.gaipday = gaipday;
	}
	
	
	
}
