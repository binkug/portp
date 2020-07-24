package naver.binkug.portfolio.domain;

import java.util.Date;

import lombok.Data;

@Data
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
	
	
}
