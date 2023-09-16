package com.musiceventms.mes.dao;

import com.musiceventms.mes.model.Admin;

public interface AdminDao {
    public Admin findByUsername(String username);
}
