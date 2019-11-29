package servlet;

import com.alibaba.fastjson.JSON;
import entity.Area;
import service.AreaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/region")
public class RegionServlet extends HttpServlet {
    private AreaService areaService = new AreaService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        String id = req.getParameter("id");
        List<Area> areas = areaService.listAll(Integer.valueOf(id));
        String string = JSON.toJSONString(areas);
        out.append(string);


    }
}
