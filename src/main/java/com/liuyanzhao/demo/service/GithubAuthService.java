package com.liuyanzhao.demo.service;

/**
 * @author 言曌
 * @date 2018/5/15 下午11:28
 */

public interface GithubAuthService extends AuthService {

    Object getUserInfo(String accessToken);

}
