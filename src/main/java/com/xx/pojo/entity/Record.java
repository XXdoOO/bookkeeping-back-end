package com.xx.pojo.entity;

import com.xx.util.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Record extends BaseEntity {
    @NotNull(groups = ValidationGroups.Insert.class)
    private Long bookId;

    @NotNull(groups = ValidationGroups.Insert.class)
    private Boolean pay;

    @NotNull
    private Integer type;

    @NotNull
    private Float amount;

    @NotNull
    private Date time;
}
