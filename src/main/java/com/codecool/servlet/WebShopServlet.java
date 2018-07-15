package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "webshop", urlPatterns = {"/"}, loadOnStartup = 1)
public class WebShopServlet extends HttpServlet {

    public ItemStore shopItems = new ItemStore();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        StringBuffer myItemsBuffer = new StringBuffer();
        myItemsBuffer.append("<ul>");
        for (Item item: ItemStore.items) {
            myItemsBuffer.append("<li>");
            myItemsBuffer.append(item.id + " ");
            myItemsBuffer.append(item.name + " ");
            myItemsBuffer.append(item.price + " ");
            myItemsBuffer.append("<a href=\"/add?name="+ item.name+ "&price="+ item.price + "\">");
            myItemsBuffer.append("Add</a>");
        }
        myItemsBuffer.append("</ul>");


        PrintWriter out = response.getWriter();
        String title = "Web Shop";

        out.println(
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<div>" +myItemsBuffer.toString() + "</div>" +
                "<a href=\"/shoppingCart\"><button type=\"button\">ShoppingCart</button></a>"+
                "</body></html>"
        );
    }
}
