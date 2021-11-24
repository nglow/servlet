package com.example.servlet.web.frontcontroller.v4;

import com.example.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface Controller {

    /**
     * @param parameterMap
     * @param model
     * @return viewName
     */
    String process(Map<String, String> parameterMap, Map<String, Object> model);
}
