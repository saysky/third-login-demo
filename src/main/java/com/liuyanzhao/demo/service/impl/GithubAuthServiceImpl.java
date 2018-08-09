package com.liuyanzhao.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.liuyanzhao.demo.service.GithubAuthService;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 言曌
 * @date 2018/5/15 下午11:31
 */
@Service
public class GithubAuthServiceImpl extends DefaultAuthServiceImpl implements GithubAuthService {

    private static final String AUTHORIZE_URL = "https://github.com/login/oauth/authorize?client_id=%s&redirect_uri=%s&state=%s";
    private static final String ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token?client_id=%s&client_secret=%s&code=%s&redirect_uri=%s&state=%s";
    private static final String USER_INFO_URL = "https://api.github.com/user?access_token=%s";


    // 下面的属性可以通过配置读取
    //回调地址
    private static final String CALLBACK_URL = "http://demo.com/oauth/github/callback";
    //Client ID
    private static final String API_KEY = "5691b18506fd77eed25a";
    //Client Secret
    private static final String API_SECRET = "3aa3fb771214366dce96fa8ea0c773b25e6dc5dd";
    //state，随便填，但要一致
    private static final String GITHUB_STATE = "randomString";

    //此处是获取key-value类型的参数
    private Map<String, String> getParam(String string) {
        Map<String, String> map = new HashMap();
        String[] kvArray = string.split("&");
        for (int i = 0; i < kvArray.length; i++) {
            String[] kv = kvArray[i].split("=");
            if(kv.length == 2) {
                map.put(kv[0], kv[1]);
            } else if(kv.length == 1) {
                map.put(kv[0],"");
            }
        }
        return map;
    }

    @Override
    public String getAccessToken(String code) throws Exception {
        String url = String.format(ACCESS_TOKEN_URL, API_KEY, API_SECRET, code, CALLBACK_URL,GITHUB_STATE);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        URI uri = builder.build().encode().toUri();

        String resp = getRestTemplate().getForObject(uri, String.class);
        if (resp.contains("access_token")) {
            Map<String, String> map = getParam(resp);
            String access_token = map.get("access_token");
            return access_token;
        } else {
            Map<String, String> map = getParam(resp);
            String error = map.get("error");
            throw new Exception(error);
        }
    }

    @Override
    public String getOpenId(String accessToken) {
        return null;
    }

    @Override
    public String refreshToken(String code) {
        return null;
    }

    @Override
    public String getAuthorizationUrl() throws UnsupportedEncodingException {
        return String.format(AUTHORIZE_URL,API_KEY,CALLBACK_URL,GITHUB_STATE);
    }

    @Override
    public Object getUserInfo(String accessToken) {
        String url = String.format(USER_INFO_URL, accessToken);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        URI uri = builder.build().encode().toUri();

        String resp = getRestTemplate().getForObject(uri, String.class);
        JSONObject data = JSONObject.parseObject(resp);
        return data;
    }
}
