package com.edu.springboot.jpa;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity(name = "jpaboard")
public class BoardEntity
{
	@Id
	@SequenceGenerator(
			name = "mySequence",
			sequenceName = "jpaboard_seq",
			initialValue = 1,
			allocationSize = 1)
	@GeneratedValue(generator = "mySequence")
	private Long idx;	//일련번호
	private String name;	//이름
	private String title;	//제목
	private String contents;	//내용
	private String pass;	//비밀번호
	private Long hits; 	//조회수
	
	// 열에 대한 기본값을 설정합니다 Oracle sysdate 사용
	@Column(columnDefinition = "DATE DEFAULT SYSDATE") 
	private LocalDateTime postdate;	//작성일
	
	// 엔티티가 데이터베이스에 처음 저장(영구화)되기 직전에 자동으로 실행
	@PrePersist
	protected void onPrePersist()
	{
		//작성일 : 현재시각으로 설정
		this.postdate = LocalDateTime.now();
		//조회수 : 0으로 설정
		if (this.hits == null)
		{
			this.hits = 0L;
		}
	}
}
