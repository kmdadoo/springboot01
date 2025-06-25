package com.edu.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.springboot.jpa.Member;
import com.edu.springboot.jpa.MemberService;

@Controller
public class MainController
{
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@Autowired
	MemberService memberService;
	
	//이름을 Like로 검색
	@GetMapping("/selectByNameLike.do")
	public String selectByNameLike(@RequestParam("name") String pname, 
			@RequestParam("page") String page, Model model)
	{
		System.out.println("selectMembers3(검색어) : " + pname);
		System.out.println("selectMembers3(페이지) : " + page);
		
		//뒤에만 %있음
		String name = pname + "%";
		//id를 내림차순 정렬
		Sort sort = Sort.by(Sort.Order.desc("id"));
		int pageNum = Integer.parseInt(page) - 1;
		
		//pageNum에 해당하는 게시물을 한페이지에 5개로 설정하고 정렬을 적용.  
		Pageable pageable = PageRequest.ofSize(5).withPage(pageNum).withSort(sort);
		//앞에서의 설정값과 검색어를 기반으로 쿼리문 실행. 반환된 결과에서 여러가지 정보를 얻어올 수 있음. 
		Page<Member> result = memberService.selectNameLike(name, pageable);
		//레코드를 List로 인출 
		List<Member> content = result.getContent();
		//레코드 갯수
		long totalElements = result.getTotalElements();
		//전체 페이지수
		int totalPages = result.getTotalPages();
		//페이지 당 레코드 수
		int size = result.getSize();
		//현재 페이지 번호. 0부터 시작이므로 1을 더해줌 
		int pageNumber = result.getNumber() + 1;
		//컨텐츠의 갯수
		int numberOfElements = result.getNumberOfElements();
		
		//위 모든 정보를 Model에 저장 
		model.addAttribute("members", content);
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("size", size);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("numberOfElements", numberOfElements);
		
		return "member_list";
	}
}
