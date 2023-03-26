package com.xx.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xx.util.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Record extends BaseEntity {
    @NotNull(groups = ValidationGroups.Insert.class)
    private Long bookId;

    @TableField("is_pay")
    @NotNull(groups = ValidationGroups.Insert.class)
    private Boolean pay;

    @NotNull
    private Integer type;

    @NotNull
    private Float amount;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @NotNull
    private Date time;

    private String remark;
}
