package com.xx.service;

import com.xx.mapper.BookMapper;
import com.xx.pojo.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService extends BaseService<BookMapper, Book> {
}
