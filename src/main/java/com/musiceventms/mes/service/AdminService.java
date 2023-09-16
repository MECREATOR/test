package com.musiceventms.mes.service;

import com.musiceventms.mes.dto.AdminDto;

public interface AdminService {
    public AdminDto login(String username, String password);
}
