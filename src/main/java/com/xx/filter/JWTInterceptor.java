package com.xx.filter;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.xx.pojo.entity.User;
import com.xx.util.BaseUserInfo;
import com.xx.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            response.sendRedirect("/notLogin");
        }
        try {
            DecodedJWT verify = JWTUtil.verify(token);

            User user = new User();
            user.setId(verify.getClaim("id").asLong());
            BaseUserInfo.set(user);
        } catch (SignatureVerificationException e) {
            log.error("无效签名！ 错误 ->", e);
            response.sendRedirect("/notLogin");
        } catch (TokenExpiredException e) {
            log.error("token过期！ 错误 ->", e);
            response.sendRedirect("/notLogin");
        } catch (AlgorithmMismatchException e) {
            log.error("token算法不一致！ 错误 ->", e);
            response.sendRedirect("/notLogin");
        } catch (Exception e) {
            log.error("token无效！ 错误 ->", e);
            response.sendRedirect("/notLogin");
        }
        return true;
    }
}