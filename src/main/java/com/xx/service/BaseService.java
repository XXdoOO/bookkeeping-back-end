package com.xx.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {
    @Autowired
    protected M baseMapper;
}