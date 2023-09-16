package com.musiceventms.mes.dao.impl;

import com.musiceventms.mes.dao.PlannerDao;
import com.musiceventms.mes.model.Planner;
import com.musiceventms.mes.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlannerDaoImpl implements PlannerDao {
    @Override
    public List<Planner> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from planner";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Planner> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String telephone = resultSet.getString(5);
                list.add(new Planner(id, username, password, name, telephone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<Planner> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from planner where "+key+" like '%"+value+"%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Planner> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String telephone = resultSet.getString(5);
                list.add(new Planner(id, username, password, name, telephone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public Integer save(Planner planner) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into planner(username,password,name,telephone) values(?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, planner.getUsername());
            statement.setString(2, planner.getPassword());
            statement.setString(3, planner.getName());
            statement.setString(4, planner.getTelephone());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public Integer update(Planner planner) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update planner set username = ?,password = ?,name = ?,telephone = ? where id = ?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, planner.getUsername());
            statement.setString(2, planner.getPassword());
            statement.setString(3, planner.getName());
            statement.setString(4, planner.getTelephone());
            statement.setInt(5, planner.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public Integer delete(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from planner where id = "+id;
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }
}
