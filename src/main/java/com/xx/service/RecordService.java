package com.xx.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xx.mapper.RecordMapper;
import com.xx.pojo.dto.RecordDTO;
import com.xx.pojo.entity.Record;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RecordService extends BaseService<RecordMapper, Record> {
    public List<Record> getRecord(RecordDTO dto) {
        return this.baseMapper.selectList(new LambdaQueryWrapper<Record>().
                eq(Objects.isNull(dto.getBookId()), Record::getBookId, dto.getBookId()).
                eq(Objects.isNull(dto.getPay()), Record::getPay, dto.getPay()).
                eq(Objects.isNull(dto.getType()), Record::getType, dto.getType()).
                ge(Objects.isNull(dto.getStartTime()), Record::getTime, dto.getStartTime()).
                le(Objects.isNull(dto.getEndTime()), Record::getTime, dto.getEndTime())
        );
    }
}
