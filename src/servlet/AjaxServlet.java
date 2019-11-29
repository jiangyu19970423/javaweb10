package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       PrintWriter out = resp.getWriter();
//        out.append("无敌");
        String phone = req.getParameter("phone");
        if ("120".equals(phone)){
            out.append("500");
        }else {
            out.append("200");
        }

    }
}
