package com.example.servlet.web.frontcontoller.v1.controller;

import com.example.servlet.domain.member.MemberRepository;
import com.example.servlet.web.frontcontoller.v1.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberListController implements Controller {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var members = memberRepository.findAll();

        request.setAttribute("members", members);

        var viewPath = "/WEB-INF/views/members.jsp";
        var dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
