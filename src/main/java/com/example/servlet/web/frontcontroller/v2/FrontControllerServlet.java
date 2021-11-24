package com.example.servlet.web.frontcontroller.v2;

import com.example.servlet.web.frontcontroller.MyView;
import com.example.servlet.web.frontcontroller.v2.controller.MemberFormController;
import com.example.servlet.web.frontcontroller.v2.controller.MemberListController;
import com.example.servlet.web.frontcontroller.v2.controller.MemberSaveController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServlet extends HttpServlet {

    private Map<String, Controller> controllerMap = new HashMap<>();

    public FrontControllerServlet() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormController());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveController());
        controllerMap.put("/front-controller/v2/members", new MemberListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var requestURI = request.getRequestURI();
        var controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        var view = controller.process(request, response);
        view.render(request, response);
    }
}
