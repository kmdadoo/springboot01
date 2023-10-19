package com.study.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>
{
	// 제네릭 타입 : long이 아니라 Lomg으로 작성
	// 기본적인 Create, Read, Update, Delete 자동으로 생성
	
	// findBy 뒤에 컬럼명을 붙여주면 이를 이용한 검색이 가능하다.
	Optional<Member> findByName(String keyword);
	Optional<Member> findByEmail(String keyword);
	
	// 다양한 확장이 가능하다.
	List<Member> findByNameLike(String keyword);
	List<Member> findByNameLikeOrderByNameDesc(String keyword);
	List<Member> findByNameLikeOrderByNameAscEmailDesc(String keyword);
	
	List<Member> findByNameLike(String keyword, Sort sort);
}
