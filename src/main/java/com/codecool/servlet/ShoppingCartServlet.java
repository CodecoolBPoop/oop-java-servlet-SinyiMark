package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "shoppingcart", urlPatterns = {"/shoppingCart"}, loadOnStartup = 2)
public class ShoppingCartServlet extends HttpServlet {
    float sumPrice = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sumPrice = 0;
        StringBuffer myItemsBuffer = new StringBuffer();
        myItemsBuffer.append("<ul>");
        for (Item item: ItemStore.shoppingCart) {
            sumPrice = sumPrice + item.price;
            myItemsBuffer.append("<li>");
            myItemsBuffer.append(item.name + " ");
            myItemsBuffer.append(item.price + " ");
            myItemsBuffer.append("<a href=\"/remove?name="+ item.name + "\">");
            myItemsBuffer.append("Remove</a>");
        }
        myItemsBuffer.append("</ul>");
        PrintWriter out = response.getWriter();
        String title = "Shoppingcart";

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<div>" +myItemsBuffer.toString() + "</div>" +
                        "<div> Sum of Price: " + sumPrice + "  </div>" +
                        "<a href=\"/\"><button type=\"button\">Back To Main Page</button></a>"+
                        "</body></html>"
        );
    }
}
