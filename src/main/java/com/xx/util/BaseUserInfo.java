package com.xx.util;

import com.xx.pojo.entity.User;

public class BaseUserInfo {

    private static final ThreadLocal<User> THREAD_LOCAL = new ThreadLocal<>();

    public static void set(User user) {
        THREAD_LOCAL.set(user);
    }

    public static User get() {
        return THREAD_LOCAL.get();
    }
}