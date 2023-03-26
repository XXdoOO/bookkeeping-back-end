package com.xx.pojo.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User extends BaseEntity {
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private String openid;
    private String sessionKey;
    private String avatar;
    private String nickname;
}
