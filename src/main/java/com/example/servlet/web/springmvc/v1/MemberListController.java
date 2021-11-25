package com.example.servlet.web.springmvc.v1;

import com.example.servlet.domain.member.MemberRepository;
import com.example.servlet.web.frontcontroller.ModelView;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MemberListController {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process() {
        var members = memberRepository.findAll();
        var modelView = new ModelAndView("members");
//        modelView.getModel().put("members", members);
        modelView.addObject("members", members);
        return modelView;
    }
}
