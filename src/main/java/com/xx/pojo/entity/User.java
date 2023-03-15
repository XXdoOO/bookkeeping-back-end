package com.xx.pojo.entity;

import lombok.Data;

@Data
public class User extends BaseEntity{
    private String openid;
    private String sessionKey;
}
