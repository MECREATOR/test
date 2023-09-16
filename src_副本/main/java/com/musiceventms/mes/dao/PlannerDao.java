package com.musiceventms.mes.dao;

import com.musiceventms.mes.model.Planner;

import java.util.List;

public interface PlannerDao {
    public List<Planner> list();
    public List<Planner> search(String key, String value);
    public Integer save(Planner planner);
    public Integer update(Planner planner);
    public Integer delete(Integer id);
}
