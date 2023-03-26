package com.xx.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xx.mapper.BookMapper;
import com.xx.mapper.RecordMapper;
import com.xx.pojo.entity.Book;
import com.xx.pojo.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService extends BaseService<BookMapper, Book> {
    @Autowired
    private RecordMapper recordMapper;

    public boolean removeById(Long id) {
        recordMapper.delete(new LambdaQueryWrapper<Record>().
                eq(Record::getBookId, id));
        return super.removeById(id);
    }
}
