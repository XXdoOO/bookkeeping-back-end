package com.xx.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class BaseVO {
    private Long id;
    private Date createTime;
}
