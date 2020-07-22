package naver.binkug.portfolio.domain;

import java.util.Date;

public class Activity {
	private int activity_num; //게시판 번호
	private String user_email; //유저 이메일
	private String activity_subject; //활동 제목
	private String activity_type; //활동 타입
	private Date activity_start_date_local; //활동 시작 시간
	private Date activity_elapsed_time; //활동 경과 시간
	private String activity_content;  //활동 내용
	private Double activity_distance; //활동거리
	private int activity_intensity; //활동 강도
	private String activity_image; //활동 이미지
	private int activity_elev_gain; //활동고도
	public int getActivity_num() {
		return activity_num;
	}
	public void setActivity_num(int activity_num) {
		this.activity_num = activity_num;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getActivity_subject() {
		return activity_subject;
	}
	public void setActivity_subject(String activity_subject) {
		this.activity_subject = activity_subject;
	}
	public String getActivity_type() {
		return activity_type;
	}
	public void setActivity_type(String activity_type) {
		this.activity_type = activity_type;
	}
	public Date getActivity_start_date_local() {
		return activity_start_date_local;
	}
	public void setActivity_start_date_local(Date activity_start_date_local) {
		this.activity_start_date_local = activity_start_date_local;
	}
	public Date getActivity_elapsed_time() {
		return activity_elapsed_time;
	}
	public void setActivity_elapsed_time(Date activity_elapsed_time) {
		this.activity_elapsed_time = activity_elapsed_time;
	}
	public String getActivity_content() {
		return activity_content;
	}
	public void setActivity_content(String activity_content) {
		this.activity_content = activity_content;
	}
	public Double getActivity_distance() {
		return activity_distance;
	}
	public void setActivity_distance(Double activity_distance) {
		this.activity_distance = activity_distance;
	}
	public int getActivity_intensity() {
		return activity_intensity;
	}
	public void setActivity_intensity(int activity_intensity) {
		this.activity_intensity = activity_intensity;
	}
	public String getActivity_image() {
		return activity_image;
	}
	public void setActivity_image(String activity_image) {
		this.activity_image = activity_image;
	}
	public int getActivity_elev_gain() {
		return activity_elev_gain;
	}
	public void setActivity_elev_gain(int activity_elev_gain) {
		this.activity_elev_gain = activity_elev_gain;
	}
	@Override
	public String toString() {
		return "Activity [activity_num=" + activity_num + ", user_email=" + user_email + ", activity_subject="
				+ activity_subject + ", activity_type=" + activity_type + ", activity_start_date_local="
				+ activity_start_date_local + ", activity_elapsed_time=" + activity_elapsed_time + ", activity_content="
				+ activity_content + ", activity_distance=" + activity_distance + ", activity_intensity="
				+ activity_intensity + ", activity_image=" + activity_image + ", activity_elev_gain="
				+ activity_elev_gain + "]";
	}
	
}
