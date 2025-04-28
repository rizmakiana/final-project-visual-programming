package com.unindra.repository;

import com.unindra.entity.Admin;

public interface AdminRepository {
    
    Admin findByUsername(String username);
}
