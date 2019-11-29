package service;

import dao.AreaDao;
import entity.Area;

import java.util.List;

public class AreaService {
    private AreaDao areaDao= new AreaDao();

    public List<Area> listAll(){
        return areaDao.listAll();
    }
    public List<Area> listAll(Integer pid){
        return areaDao.listAll(pid);
    }
}
