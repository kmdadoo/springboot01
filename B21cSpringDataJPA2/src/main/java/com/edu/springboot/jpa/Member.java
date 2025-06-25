package com.edu.springboot.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
// 접근 제어자(access modifier)를 protected로 설정
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity(name = "JPAMEMBER02")
public class Member
{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
}
