package com.example.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
* 아래 2개의 annotation을 붙인것관 같이 동작한다. (RequestMappingHandlerMapping & RequestMappingHandlerAdapter 활용)
* */
@Controller
//@Component
//@RequestMapping
public class MemberFormController {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
