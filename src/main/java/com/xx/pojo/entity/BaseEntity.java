package com.xx.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Date createTime;
}
