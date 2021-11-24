package com.example.servlet.web.frontcontroller.v3.controller;

import com.example.servlet.web.frontcontroller.ModelView;
import com.example.servlet.web.frontcontroller.v3.Controller;

import java.util.Map;

public class MemberFormController implements Controller {

    @Override
    public ModelView process(Map<String, String> parameterMap) {
        return new ModelView("new-form");
    }
}
