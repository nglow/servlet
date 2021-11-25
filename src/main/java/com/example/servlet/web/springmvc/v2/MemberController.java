package com.example.servlet.web.springmvc.v2;

import com.example.servlet.domain.member.Member;
import com.example.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("memberControllerV3")
@RequestMapping("/springmvc/v2/members")
public class MemberController {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView createMember() {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView saveMember(HttpServletRequest request, HttpServletResponse response) {
        var username = request.getParameter("username");
        var age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        var modelView = new ModelAndView("save-result");
//        modelView.getModel().put("member", member);
        modelView.addObject("member", member);
        return modelView;
    }

    @RequestMapping
    public ModelAndView retrieveMembers() {
        var members = memberRepository.findAll();
        var modelView = new ModelAndView("members");
//        modelView.getModel().put("members", members);
        modelView.addObject("members", members);
        return modelView;
    }
}
