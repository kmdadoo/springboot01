package com.edu.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService
{
	//DAO 역할의 빈 자동주입
	@Autowired
	private MemberRepository dao;
	
	//입력
	public Member insert(Member member)
	{
		Member resultMember = dao.save(member);
		return resultMember;
	}
	
	//개별조회
	public Optional<Member> select(Long id)
	{
		Optional<Member> member = dao.findById(id);
		return member;
	}
	
	//전체조회
	public List<Member> selectAll()
	{
		return dao.findAll();
	}
	
	//삭제
	public void delete(Long id)
	{
		dao.deleteById(id);
	}
	
	//수정
	public Member update(Member member)
	{
		/*
		insert와 완전히 동일하다. 동일한 키값이 있으면 업데이트, 없으면 인서트 처리된다. 
		 */
		Member resultMember = dao.save(member);
		return resultMember;
	}
}
