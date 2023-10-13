package com.study.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.ISimpleBbsDao;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {

	@Autowired
	ISimpleBbsDao dao;

    @RequestMapping("/")
    public String root() throws Exception{
        // MyBatis : SimpleBBS
		return "redirect:list";
    }

	@RequestMapping("/list")
    public String userlistPage(Model model) {
		model.addAttribute("list", dao.listDao());
		
		// nTotalCount => 카운터 한 값을 받음.
		int nTotalCount = dao.articleCount();
		System.out.println("Count : " + nTotalCount);
				
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
		String sName = request.getParameter("writer");
		String sTitle = request.getParameter("title");
		String sContent =request.getParameter("content");
		
		// HashMap은 이름이 여러개인 값를 넣을 때. Map에 파라미터를 저장한다.
		Map<String, String> map = new HashMap<String, String>();
		map.put("item1", sName);
		map.put("item2", sTitle);
		map.put("item3", sContent);
		
		int nResult = dao.writeDao(map);
		System.out.println("Write : " + nResult);
				
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		String sID = request.getParameter("id");
		int nResult = dao.deleteDao(sID);
		System.out.println("Delete : " + nResult);
		
		return "redirect:list";
	}
}