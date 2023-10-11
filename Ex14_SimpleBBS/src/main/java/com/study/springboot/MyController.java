package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.ISimpleBbsDao;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {

	@Autowired
	ISimpleBbsDao dao;	// 인터페이스 데이타 사용

    @RequestMapping("/")
    public String root() throws Exception{
        // JdbcTemplate : SimpleBBS
		return "redirect:list"; // /list로 보냄
    }

	@RequestMapping("/list")  // 프론트 컨트롤러
    public String userlistPage(Model model) {
		model.addAttribute("list", dao.listDao());
        return "list";
    }

	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		String sId = request.getParameter("id");
		model.addAttribute("dto", dao.viewDao(sId));
		return "view";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		// 파라미터가 몇개 안 될때 다 쓰는것이 좋음.
		dao.writeDao(request.getParameter("writer"),
				     request.getParameter("title"),
				     request.getParameter("content"));
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		dao.deleteDao(request.getParameter("id"));
		return "redirect:list";
	}

}
