package com.edu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.springboot.mybatis.ISearchRadius;

@Controller
public class MainController 
{
	//Mybatis 사용을 위한 자동주입 
	@Autowired
	ISearchRadius dao;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	//구글맵 연동을 위한 API 키(구글 클라우드 콘솔에서 발급)
	private static final String apiKey = "AIzaSyDk7yQTzqQDom7eiy8uX9CwgsKhojgZ0dA";
	
	//내 위치의 위도, 경도 알아내기 
	@GetMapping("/01GeoLocation.do")
	public String geoFunc1(Model model)
	{
		model.addAttribute("apiKey", apiKey);
		return "01GeoLocation";
	}
	
	//구글맵 연동하기 
	@GetMapping("/02GoogleMap.do")
	public String geoFunc2(Model model)
	{
		model.addAttribute("apiKey", apiKey);
		return "02GoogleMap";
	}
	
	//구글맵에 내위치 출력하기
	@GetMapping("/03MyLocation.do")
	public String geoFunc3(Model model)
	{
		model.addAttribute("apiKey", apiKey);
		return "03MyLocation";
	}
}
 