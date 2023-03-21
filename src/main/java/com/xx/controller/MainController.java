package com.xx.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xx.pojo.dto.RecordDTO;
import com.xx.pojo.entity.Book;
import com.xx.pojo.entity.Record;
import com.xx.service.BookService;
import com.xx.service.RecordService;
import com.xx.service.UserService;
import com.xx.util.BaseUserInfo;
import com.xx.util.MyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private BookService bookService;

    @GetMapping("login")
    public MyResponse login(@RequestParam String openid, @RequestParam String sessionKey) {
        String login = userService.login(openid, sessionKey);
        return login == null ? error() : success(login);
    }

    @PostMapping("record")
    public MyResponse saveRecord(@Validated @RequestBody Record record) {
        return recordService.saveOrUpdate(record) ? success() : error();
    }

    @GetMapping("record")
    public MyResponse getRecord(RecordDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return success(new PageInfo<>(recordService.getRecord(dto)));
    }

    @DeleteMapping("record/{id}")
    public MyResponse removeRecord(@PathVariable Long id) {
        return recordService.removeById(id) ? success() : error();
    }

    @GetMapping("book")
    public MyResponse getBook() {
        return success(bookService.list(new LambdaQueryWrapper<Book>().
                eq(Book::getCreateBy, BaseUserInfo.get().getId())));
    }

    @PostMapping("book")
    public MyResponse saveBook(@Validated @RequestBody Book book) {
        book.setCreateBy(BaseUserInfo.get().getId());
        return bookService.saveOrUpdate(book) ? success() : error();
    }

    @DeleteMapping("book/{id}")
    public MyResponse removeBook(@PathVariable Long id) {
        return bookService.removeById(id) ? success() : error();
    }
}
