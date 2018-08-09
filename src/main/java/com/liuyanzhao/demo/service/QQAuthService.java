package com.liuyanzhao.demo.service;

/**
 * @author 言曌
 * @date 2018/5/9 下午3:00
 */

public interface QQAuthService extends AuthService {

    Object getUserInfo(String accessToken, String openId) throws Exception;

}
