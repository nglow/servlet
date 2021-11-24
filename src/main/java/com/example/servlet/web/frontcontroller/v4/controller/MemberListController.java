package com.example.servlet.web.frontcontroller.v4.controller;

import com.example.servlet.domain.member.MemberRepository;
import com.example.servlet.web.frontcontroller.ModelView;
import com.example.servlet.web.frontcontroller.v4.Controller;

import java.util.Map;

public class MemberListController implements Controller {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> parameterMap, Map<String, Object> model) {
        var members = memberRepository.findAll();
        model.put("members", members);

        return "members";
    }
}
