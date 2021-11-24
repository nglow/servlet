package com.example.servlet.web.frontcontroller.v4.controller;

import com.example.servlet.web.frontcontroller.ModelView;
import com.example.servlet.web.frontcontroller.v4.Controller;

import java.util.Map;

public class MemberFormController implements Controller {

    @Override
    public String process(Map<String, String> parameterMap, Map<String, Object> model) {
        return "new-form";
    }
}
