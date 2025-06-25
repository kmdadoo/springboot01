package com.edu.springboot.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberService
{
	//DAO 역할의 빈 자동주입
	@Autowired
	private MemberRepository memberRepository;
	
	//이름을 like로 검색
//	public List<Member> selectNameLike(String search, Pageable pageable)
//	{
//		List<Member> member = memberRepository.findByNameLike(search, pageable);
//		return member;
//	}
	// 페이징 사용
	public Page<Member> selectNameLike(String search, Pageable pageable)
	{
		Page<Member> member = memberRepository.findByNameLike(search, pageable);
		return member;
	}
}
