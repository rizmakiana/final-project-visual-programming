package com.unindra.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.unindra.entity.Admin;
import com.unindra.util.AppContext;

public class AdminRepositoryImpl implements AdminRepository{

    private DataSource dataSource;

    public AdminRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Admin findByUsername(String username) {
        Admin admin = new Admin();
        String sql = "SELECT * FROM admin WHERE username = ?";
    
        try (Connection connection = AppContext.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);) {

                statement.setString(1, username);

                
                try (ResultSet set = statement.executeQuery()) {
                    
                    while (set.next()) {
                        admin.setUsername(set.getString(1));
                        admin.setPassword(set.getString(2));
                    }

                    return admin;
                } catch (Exception e) {
                    throw new RuntimeException("Username atau password salah");
                }
            
        } catch (Exception e) {
            throw new RuntimeException("Username atau password salah");
        }
    }


    
}
