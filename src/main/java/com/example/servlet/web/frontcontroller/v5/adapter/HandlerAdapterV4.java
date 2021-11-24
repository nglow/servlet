package com.example.servlet.web.frontcontroller.v5.adapter;

import com.example.servlet.web.frontcontroller.ModelView;
import com.example.servlet.web.frontcontroller.v4.Controller;
import com.example.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HandlerAdapterV4 implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof Controller);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        var controller =  (Controller) handler;

        var parameterMap = createParameterMap(request);
        var model = new HashMap<String, Object>();

        var viewName = controller.process(parameterMap, model);
        var modelView = new ModelView(viewName);
        modelView.setModel(model);

        return modelView;
    }

    private Map<String, String> createParameterMap(HttpServletRequest request) {
        Map<String, String> parameterMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(parameterName -> parameterMap.put(parameterName, request.getParameter(parameterName)));
        return parameterMap;
    }
}
