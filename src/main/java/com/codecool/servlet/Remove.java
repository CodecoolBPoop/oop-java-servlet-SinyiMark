package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "remove", urlPatterns = {"/remove"}, loadOnStartup = 4)
public class Remove extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ItemStore.remove(request.getParameter("name"));
        response.sendRedirect("/shoppingCart");
    }
}

