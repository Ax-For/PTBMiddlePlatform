package com.bupt.cad.apis;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;

/**
 * @author dongyafei
 * @description
 * @date 2023/2/4/004
 */
public interface FunnyApiClient {

    // 反向查词
    @Get("https://wantwords.net/ChineseRD/?m=ZhZh&f=1")
    JSONArray wantWords(@Query("q") String text);


    // 据意查句
    @Get("https://wantquotes.net/api/semantic/?type=古&unionid=onapP551hi_prcxTVX6Cm91sHpBk&secret='pL;aB(cawCD{ph^;I>VClr,`$s^x_,WLaWZUP[R:RmZDQ:!")
    JSONObject wantQuotes(@Query("query") String text);

    // 一言
    @Get("https://v1.hitokoto.cn/")
    JSONObject oneSentence(@Query("c") String category);
}
