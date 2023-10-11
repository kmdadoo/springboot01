package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.jdbc.MyUserDao;

@Controller	// 컴포넌트
public class MyController 
{
	@Autowired
	// 오라클 접속 정보로 new 된 것이 들어옴.
    private MyUserDao userDao;

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "JdbcTEmplate 사용하기";
    }

    //@GetMapping("/user")	// 잘 안씀
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userlistPage(Model model) {  // heap에 있는 빈 model
		// DAO클래스의 list()메서드를 호출하여 회원목록을  userlist로 반환한 후
		// Medel객체에 젖아하고 View를 반환한다
		model.addAttribute("users", userDao.list());
        return "userlist";
    }

}
