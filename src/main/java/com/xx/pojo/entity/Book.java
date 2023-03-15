package com.xx.pojo.entity;

import com.xx.util.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Book extends BaseEntity {
    @NotNull(groups = ValidationGroups.Insert.class)
    private String name;

    @NotNull(groups = ValidationGroups.Insert.class)
    private String description;

    @NotNull(groups = ValidationGroups.Insert.class)
    private String img;

    @NotNull(groups = ValidationGroups.Insert.class)
    private Float budget;

    private Long createBy;
}
