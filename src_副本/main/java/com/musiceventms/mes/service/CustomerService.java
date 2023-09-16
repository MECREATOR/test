package com.musiceventms.mes.service;

import com.musiceventms.mes.model.Customer;
import com.musiceventms.mes.model.Planner;

import java.util.List;

public interface CustomerService {
    public List<Customer> list();
    public List<Customer> search(String key, String value);
    public void save(Customer customer);
    public void update(Customer customer);
    public void delete(Integer id);
}
