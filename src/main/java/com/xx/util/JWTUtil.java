package com.xx.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.xx.pojo.entity.User;

import java.util.Calendar;

public class JWTUtil {
    private static String sessionKey;

    public static String getToken(User u) {
        Calendar instance = Calendar.getInstance();
        //默认令牌过期时间7天
        instance.add(Calendar.DATE, 7);

        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("id", u.getId());

        sessionKey = u.getSessionKey();
        return builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(u.getSessionKey()));
    }

    /**
     * 验证token合法性 成功返回token
     */
    public static DecodedJWT verify(String token) throws Exception {
        if (StringUtils.isEmpty(token)) {
            throw new Exception("token不能为空");
        }

        JWTVerifier build = JWT.require(Algorithm.HMAC256(sessionKey)).build();
        return build.verify(token);
    }
}
