package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "add", urlPatterns = {"/add"}, loadOnStartup = 4)
public class AddServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ItemStore.add(request.getParameter("name"),Float.parseFloat(request.getParameter("price")));
        response.sendRedirect("/");
    }
}