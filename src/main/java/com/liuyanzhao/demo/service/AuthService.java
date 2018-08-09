package com.liuyanzhao.demo.service;


import java.io.UnsupportedEncodingException;

/**
 * @author 言曌
 * @date 2018/5/9 下午3:00
 */

public interface AuthService {

    String getAccessToken(String code) throws Exception;

    String getOpenId(String accessToken) throws Exception;

    String refreshToken(String code);

    String getAuthorizationUrl() throws UnsupportedEncodingException;

}
