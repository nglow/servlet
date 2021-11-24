package com.example.servlet.web.frontcontroller.v5;

import com.example.servlet.web.frontcontroller.MyView;
import com.example.servlet.web.frontcontroller.v3.controller.MemberFormController;
import com.example.servlet.web.frontcontroller.v3.controller.MemberListController;
import com.example.servlet.web.frontcontroller.v3.controller.MemberSaveController;
import com.example.servlet.web.frontcontroller.v5.adapter.HandlerAdapterV3;
import com.example.servlet.web.frontcontroller.v5.adapter.HandlerAdapterV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServlet extends HttpServlet {

    private final Map<String, Object> handlerMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServlet() {
        initializeHandlerMap();
        initializeHandlerAdapters();
    }

    private void initializeHandlerAdapters() {
        handlerAdapters.add(new HandlerAdapterV3());
        handlerAdapters.add(new HandlerAdapterV4());
    }

    private void initializeHandlerMap() {
        handlerMap.put("/front-controller/v5/v3/members/new-form", new MemberFormController());
        handlerMap.put("/front-controller/v5/v3/members/save", new MemberSaveController());
        handlerMap.put("/front-controller/v5/v3/members", new MemberListController());

        handlerMap.put("/front-controller/v5/v4/members/new-form", new com.example.servlet.web.frontcontroller.v4.controller.MemberFormController());
        handlerMap.put("/front-controller/v5/v4/members/save", new com.example.servlet.web.frontcontroller.v4.controller.MemberSaveController());
        handlerMap.put("/front-controller/v5/v4/members", new com.example.servlet.web.frontcontroller.v4.controller.MemberListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var handler = getHandler(request);
        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        var adapter = getAdapterMatchedTo(handler);
        var modelView = adapter.handle(request, response, handler);

        MyView view = viewResolver(modelView.getViewName());

        view.render(modelView.getModel(), request, response);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private MyHandlerAdapter getAdapterMatchedTo(Object handler) {
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)) return adapter;
        }
        throw new IllegalArgumentException("Can't find adapter matched to handler transmitted");
    }

    private Object getHandler(HttpServletRequest request) {
        var requestURI = request.getRequestURI();
        return handlerMap.get(requestURI);
    }
}
