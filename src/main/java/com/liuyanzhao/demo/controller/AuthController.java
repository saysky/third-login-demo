package com.liuyanzhao.demo.controller;

import com.liuyanzhao.demo.dto.BindUserDTO;
import com.liuyanzhao.demo.entity.User;
import com.liuyanzhao.demo.service.GithubAuthService;
import com.liuyanzhao.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 言曌
 * @date 2018/8/8 下午11:22
 */
@RestController
public class AuthController {

    @Autowired
    private GithubAuthService githubAuthService;

    //第三方授权后会回调此方法，并将code传过来
    @GetMapping("/oauth/github/callback")
    public Response<BindUserDTO> auth(@RequestParam(value = "code") String code) throws Exception {
        //2、根据code获取token,根据openId判断用户是否已经绑定过
        String accessToken = null;
        BindUserDTO userInfo = null;
        try {
            accessToken = githubAuthService.getAccessToken(code);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<BindUserDTO>(500,"授权失败");
        }
        userInfo = githubAuthService.getUserInfo(accessToken);
        return new Response<BindUserDTO>(200,"授权成功",userInfo);
    }
}
