package com.musiceventms.mes.service.impl;

import com.musiceventms.mes.dao.AdminDao;
import com.musiceventms.mes.dao.impl.AdminDaoImpl;
import com.musiceventms.mes.dto.AdminDto;
import com.musiceventms.mes.model.Admin;
import com.musiceventms.mes.service.AdminService;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public AdminDto login(String username, String password) {
        //1. search username in the database
        //2. if return is null, username is not correct
        //3. if return isn't null, determine whether the password is correct
        Admin admin = this.adminDao.findByUsername(username);
        AdminDto adminDto = new AdminDto();
        if(admin == null){
            adminDto.setCode(-1);
        } else {
            if(!admin.getPassword().equals(password)){
                adminDto.setCode(-2);
            }else {
                adminDto.setCode(0);
                adminDto.setAdmin(admin);
            }
        }
        return adminDto;
    }
}
