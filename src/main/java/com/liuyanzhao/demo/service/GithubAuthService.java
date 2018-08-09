package com.liuyanzhao.demo.service;

import com.liuyanzhao.demo.dto.BindUserDTO;

/**
 * @author 言曌
 * @date 2018/5/15 下午11:28
 */

public interface GithubAuthService extends AuthService {

    BindUserDTO getUserInfo(String accessToken);

}
