package com.liuyanzhao.demo.controller;

import com.liuyanzhao.demo.service.GithubAuthService;
import com.liuyanzhao.demo.service.QQAuthService;
import com.liuyanzhao.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.dc.pr.PRError;


/**
 * @author 言曌
 * @date 2018/8/8 下午11:22
 */
@RestController
public class AuthController {

    @Autowired
    private GithubAuthService githubAuthService;

    @Autowired
    private QQAuthService qqAuthService;


    @GetMapping("/oauth/github/callback")
    public Response<Object> authGithub(@RequestParam(value = "code") String code) {
        Object userInfo = null;
        try {
            //1、根据code获得accessToken
           String accessToken = githubAuthService.getAccessToken(code);
            //2、根据accessToken获得userInfo
            userInfo = githubAuthService.getUserInfo(accessToken);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<Object>(500, "授权失败：" + e.getMessage());
        }
        return new Response<Object>(200, "授权成功", userInfo);
    }

    @GetMapping("/oauth/qq/callback")
    public Response<Object> authQQ(@RequestParam(value = "code") String code) {
        Object userInfo = null;
        try {
            //1、根据code获得accessToken
            String accessToken = qqAuthService.getAccessToken(code);
            //2、根据accessToken获得openId
            String openId = qqAuthService.getOpenId(accessToken);
            //3、根据accessToken和openId获得userInfo
            userInfo = qqAuthService.getUserInfo(accessToken, openId);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<Object>(500, "授权失败：" + e.getMessage());
        }
        return new Response<Object>(200, "授权成功", userInfo);
    }
}
