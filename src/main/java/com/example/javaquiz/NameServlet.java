package com.example.javaquiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "nameServlet", value = "/major-family-name")
public class NameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String str = req.getParameter("names");
        String names[] = str.replace(" ","").split(",");
        String first[] = new String[names.length];
        int count[] = new int[names.length];
        int max = 0;
        int idx = 0;

        for (int i = 0; i < names.length; i++) {
            first[i] = names[i].split("")[0];
        }
        for (int i = 0; i < names.length; i++) {
            for (int j = i+1; j < names.length; j++) {
                if (first[i].equals(first[j])){
                    count[i] += 1;
                }
            }
        }

        for (int i = 0; i < count.length; i++) {
            if(count[i] > max || (count[i] == max && first[i].charAt(0) < first[idx].charAt(0))){
                max = count[i];
                idx = i;
            }
        }
        out.println(first[idx] + "씨가 가장 많습니다.");
    }
}
