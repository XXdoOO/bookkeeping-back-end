package com.xx.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.xx.util.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Date createTime;
}
