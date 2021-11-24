package com.example.servlet.web.frontcontroller.v4.controller;

import com.example.servlet.domain.member.Member;
import com.example.servlet.domain.member.MemberRepository;
import com.example.servlet.web.frontcontroller.v4.Controller;

import java.util.Map;

public class MemberSaveController implements Controller {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> parameterMap, Map<String, Object> model) {
        var username = parameterMap.get("username");
        var age = Integer.parseInt(parameterMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.put("member", member);
        return "save-result";
    }
}
