package com.portfolio.sellf.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@Controller
@RequestMapping("/")
public class IndexController {

  @Value("${sellf.web.url}")
  private String SELLF_WEB_URL;

    /**
   * <pre>
   * 테스트
   *
   * @author 한승현
   * @date 2022/01/13
   **/
  @RequestMapping(value = {"", "/"}) 
  public String mainPage() {
    System.out.println("mainPage입니다.");
    return "/index";
  }

    /**
   * <pre>
   * 테스트
   *
   * @author 한승현
   * @date 2022/01/13
   **/
  @RequestMapping(value = {"/about"}) 
  public String aboutPage() {
    System.out.println("aboutPage입니다.");
    return "/about-me";
  }
}