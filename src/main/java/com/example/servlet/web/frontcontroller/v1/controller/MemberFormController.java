package com.example.servlet.web.frontcontroller.v1.controller;


import com.example.servlet.web.frontcontroller.v1.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormController implements Controller {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var viewPath = "/WEB-INF/views/new-form.jsp";
        var dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
