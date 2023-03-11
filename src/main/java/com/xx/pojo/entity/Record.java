package com.xx.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Record extends BaseEntity{
    private Boolean pay;
    private Integer type;
    private Float amount;
    private Date time;
}
