package naver.binkug.portfolio.domain;

import java.util.Date;

public class User {

	private String user_email;
	private String user_password;
	private String user_gender;
	private String user_name;
	private Double user_kg;
	private Date user_birthday;
	private String user_image;
	private Integer islogin;
	private Integer isremove;
	private Date logindate;
	private Date joindate;
	private Integer isemail;
	
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Double getUser_kg() {
		return user_kg;
	}
	public void setUser_kg(Double user_kg) {
		this.user_kg = user_kg;
	}
	public Date getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(Date user_birthday) {
		this.user_birthday = user_birthday;
	}
	public String getUser_image() {
		return user_image;
	}
	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}
	public Integer getIslogin() {
		return islogin;
	}
	public void setIslogin(Integer islogin) {
		this.islogin = islogin;
	}
	public Integer getIsremove() {
		return isremove;
	}
	public void setIsremove(Integer isremove) {
		this.isremove = isremove;
	}
	public Date getLogindate() {
		return logindate;
	}
	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public Integer getIsemail() {
		return isemail;
	}
	public void setIsemail(Integer isemail) {
		this.isemail = isemail;
	}
	
	@Override
	public String toString() {
		return "User [user_email=" + user_email + ", user_password=" + user_password + ", user_gender=" + user_gender
				+ ", user_name=" + user_name + ", user_kg=" + user_kg + ", user_birthday=" + user_birthday
				+ ", user_image=" + user_image + ", islogin=" + islogin + ", isremove=" + isremove + ", logindate="
				+ logindate + ", joindate=" + joindate + ", isemail=" + isemail + "]";
	}
	

}
