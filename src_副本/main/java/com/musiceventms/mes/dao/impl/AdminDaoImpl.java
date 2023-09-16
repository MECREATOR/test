package com.musiceventms.mes.dao.impl;

import com.musiceventms.mes.dao.AdminDao;
import com.musiceventms.mes.model.Admin;
import com.musiceventms.mes.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin findByUsername(String username) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from admin where username = '"+username+"'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String telephone = resultSet.getString(5);
                return new Admin(id, username, password, name, telephone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return null;
    }
}
