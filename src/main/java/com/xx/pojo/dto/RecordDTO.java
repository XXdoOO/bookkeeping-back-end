package com.xx.pojo.dto;

import com.xx.pojo.entity.Record;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class RecordDTO extends BaseDTO {
    private Long bookId;
    private Boolean pay;
    private Integer type;
    private Date startTime;
    private Date endTime;
}
