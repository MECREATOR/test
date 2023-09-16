package com.musiceventms.mes.service.impl;

import com.musiceventms.mes.dao.PlannerDao;
import com.musiceventms.mes.dao.impl.PlannerDaoImpl;
import com.musiceventms.mes.model.Planner;
import com.musiceventms.mes.service.PlannerService;

import java.util.List;

public class PlannerServiceImpl implements PlannerService {
    private PlannerDao plannerDao = new PlannerDaoImpl();

    @Override
    public List<Planner> list() {
        return this.plannerDao.list();
    }

    @Override
    public List<Planner> search(String key, String value) {
        if(value.equals(""))return this.plannerDao.list();
        return this.plannerDao.search(key, value);
    }

    @Override
    public void save(Planner planner) {
        Integer save = this.plannerDao.save(planner);
        if(save != 1) throw new RuntimeException("Planner creation failure!");
    }

    @Override
    public void update(Planner planner) {
        Integer update = this.plannerDao.update(planner);
        if(update != 1) throw new RuntimeException("Planner edit failure!");
    }

    @Override
    public void delete(Integer id) {
        Integer delete = this.plannerDao.delete(id);
        if(delete != 1) throw new RuntimeException("Planner deletion failure!");
    }
}
