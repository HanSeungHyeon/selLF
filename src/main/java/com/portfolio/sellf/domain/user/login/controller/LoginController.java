package com.portfolio.sellf.domain.user.login.controller;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portfolio.sellf.domain.user.join.vo.UserVo;
import com.portfolio.sellf.domain.user.login.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

  @Autowired
  private LoginService loginService;

    /**
   * <pre>
   * 로그인 메인페이지
   *
   * @author 한승현
   * @date 2023/11/29
   **/
  @RequestMapping(value = {"", "/"}) 
  public String loginMainPage() {
    return "/user/login";
  }
  
    /**
   * <pre>
   * 회원가입
   *
   * @author 한승현
   * @date 2023/11/30
   **/
  @ResponseBody
  @PostMapping("/login.do") 
  public int login(UserVo user, HttpServletRequest httpServletRequest) {
    int flag = -1;
    UserVo result = loginService.tryLogin(user);
    if(result != null) {
      loginService.successLogin(user);
      httpServletRequest.getSession().invalidate();
      HttpSession session = httpServletRequest.getSession(true);
      session.setAttribute("user", result);
      session.setAttribute("role", result.getUserRole());
      session.setMaxInactiveInterval(3600);
      flag = 1;
    }
    return flag;
  }
}