package com.bovane.service;

import org.apache.ibatis.annotations.Param;

public interface UserService {
    public boolean login(@Param("name") String name, @Param("password") String password);
}
