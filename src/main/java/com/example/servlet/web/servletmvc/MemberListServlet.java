package com.example.servlet.web.servletmvc;

import com.example.servlet.domain.member.Member;
import com.example.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/servlet-mvc/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var members = memberRepository.findAll();

        request.setAttribute("members", members);

        var viewPath = "/WEB-INF/views/members.jsp";
        var dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
