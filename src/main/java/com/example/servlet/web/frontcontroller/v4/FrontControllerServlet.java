package com.example.servlet.web.frontcontroller.v4;

import com.example.servlet.web.frontcontroller.MyView;
import com.example.servlet.web.frontcontroller.v4.controller.MemberFormController;
import com.example.servlet.web.frontcontroller.v4.controller.MemberListController;
import com.example.servlet.web.frontcontroller.v4.controller.MemberSaveController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServlet extends HttpServlet {

    private final Map<String, Controller> controllerMap = new HashMap<>();

    public FrontControllerServlet() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormController());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveController());
        controllerMap.put("/front-controller/v4/members", new MemberListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var requestURI = request.getRequestURI();
        var controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // paramMap
        Map<String, String> parameterMap = createParameterMap(request);
        Map<String, Object> model = new HashMap<>();
        var viewName = controller.process(parameterMap, model);

        MyView view = viewResolver(viewName);

        view.render(model, request, response);
    }

    private MyView viewResolver(String viewName) {
        var view = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        return view;
    }

    private Map<String, String> createParameterMap(HttpServletRequest request) {
        Map<String, String> parameterMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(parameterName -> parameterMap.put(parameterName, request.getParameter(parameterName)));
        return parameterMap;
    }
}
