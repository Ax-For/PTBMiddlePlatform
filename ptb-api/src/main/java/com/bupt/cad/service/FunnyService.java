package com.bupt.cad.service;

import com.alibaba.fastjson.JSONArray;
import com.bupt.cad.apis.FunnyApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author dongyafei
 * @description
 * @date 2023/2/4/004
 */

@Service
public class FunnyService {

    @Autowired
    private FunnyApiClient funnyApiClient;

    public JSONArray wantWords(String text) {
        return funnyApiClient.wantWords(text);
    }
}
