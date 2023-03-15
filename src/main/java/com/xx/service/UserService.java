package com.xx.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xx.mapper.UserMapper;
import com.xx.pojo.entity.User;
import com.xx.util.BaseUserInfo;
import com.xx.util.JWTUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserMapper, User> {
    public String login(String openid, String sessionKey) {
        boolean exists = this.baseMapper.exists(new LambdaQueryWrapper<User>().eq(User::getOpenid, openid));

        if (exists) {
            User user = new User();
            user.setOpenid(openid);
            user.setSessionKey(sessionKey);

            BaseUserInfo.set(user);
            return JWTUtil.getToken(user);
        } else {
            return null;
        }
    }
}
