package com.example.servlet.web.frontcontroller.v3.controller;

import com.example.servlet.domain.member.Member;
import com.example.servlet.domain.member.MemberRepository;
import com.example.servlet.web.frontcontroller.ModelView;
import com.example.servlet.web.frontcontroller.v3.Controller;

import java.util.List;
import java.util.Map;

public class MemberListController implements Controller {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> parameterMap) {
        var members = memberRepository.findAll();
        var modelView = new ModelView("members");
        modelView.getModel().put("members", members);

        return modelView;
    }
}
