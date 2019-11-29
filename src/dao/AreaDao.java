package dao;

import entity.Area;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcTemplateUtil;

import java.util.List;

public class AreaDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcTemplateUtil.getDataSource());

    public List<Area> listAll() {
        String sql = "select * from sys_area where type=1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Area.class));
    }

    public List<Area> listAll(Integer pid){
        String sql="select * from  sys_area where p_id=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Area.class),pid);
    }
}
