package com.xx.util;

import com.xx.pojo.entity.User;

public class BaseUserInfo {

    private static final ThreadLocal<User> THREAD_LOCAL = new ThreadLocal<>();

    public static User getLocalUser() {
        User user = THREAD_LOCAL.get();
        if (user == null) {
            user = new User();
            THREAD_LOCAL.set(user);
        }
        return user;
    }

    public static void set(User user) {
        THREAD_LOCAL.set(user);
    }

    public static User get() {
        return getLocalUser();
    }
}