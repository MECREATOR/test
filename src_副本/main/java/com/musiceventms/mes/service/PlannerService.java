package com.musiceventms.mes.service;

import com.musiceventms.mes.model.Planner;

import java.util.List;

public interface PlannerService {
    public List<Planner> list();
    public List<Planner> search(String key, String value);
    public void save(Planner planner);
    public void update(Planner planner);
    public void delete(Integer id);
}
