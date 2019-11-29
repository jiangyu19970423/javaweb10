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
import java.util.SortedMap;

@WebServlet("/province")
public class ProvinceServlet extends HttpServlet {
    private AreaService areaService = new AreaService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        List<Area> areas = areaService.listAll();
        for (Area area : areas) {
            System.out.println(area.getId() + area.getName());
        }

        String string = JSON.toJSONString(areas);
        PrintWriter out = resp.getWriter();
        out.append(string);


    }
}
