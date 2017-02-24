package com.robam.distribution.sys.model;

public interface LoginInfoMapper {
  
    LoginInfo selectByUserId(String id);
    
}