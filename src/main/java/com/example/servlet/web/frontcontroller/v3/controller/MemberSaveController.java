package com.example.servlet.web.frontcontroller.v3.controller;

import com.example.servlet.domain.member.Member;
import com.example.servlet.domain.member.MemberRepository;
import com.example.servlet.web.frontcontroller.ModelView;
import com.example.servlet.web.frontcontroller.v3.Controller;

import java.util.Map;

public class MemberSaveController implements Controller {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> parameterMap) {
        var username = parameterMap.get("username");
        var age = Integer.parseInt(parameterMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        var modelView = new ModelView("save-result");
        modelView.getModel().put("member", member);

        return modelView;
    }
}
