package com.musiceventms.mes.dao;

import com.musiceventms.mes.model.Customer;
import com.musiceventms.mes.model.Planner;

import java.util.List;

public interface CustomerDao {
    public List<Customer> list();
    public List<Customer> search(String key, String value);
    public Integer save(Customer customer);
    public Integer update(Customer customer);
    public Integer delete(Integer id);
}
