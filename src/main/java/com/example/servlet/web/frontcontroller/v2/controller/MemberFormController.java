package com.example.servlet.web.frontcontroller.v2.controller;

import com.example.servlet.web.frontcontroller.MyView;
import com.example.servlet.web.frontcontroller.v2.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormController implements Controller {

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
