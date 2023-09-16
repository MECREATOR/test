package com.musiceventms.mes.service.impl;

import com.musiceventms.mes.dao.CustomerDao;
import com.musiceventms.mes.dao.impl.CustomerDaoImpl;
import com.musiceventms.mes.model.Customer;
import com.musiceventms.mes.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public List<Customer> list() {return  this.customerDao.list();}

    @Override
    public List<Customer> search(String key, String value) {
        if(value.equals(""))return this.customerDao.list();
        return this.customerDao.search(key, value);
    }

    @Override
    public void save(Customer customer) {
        Integer save = this.customerDao.save(customer);
        if(save != 1) throw new RuntimeException("Customer creation failure!");
    }

    @Override
    public void update(Customer customer) {
        Integer update = this.customerDao.update(customer);
        if(update != 1) throw new RuntimeException("Customer edit failure!");

    }

    @Override
    public void delete(Integer id) {
        Integer delete = this.customerDao.delete(id);
        if(delete != 1) throw new RuntimeException("Customer deletion failure!");
    }
}
