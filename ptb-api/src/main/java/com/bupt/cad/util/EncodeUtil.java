package com.bupt.cad.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.TreeMap;

/**
 * @author dongyafei
 * @description
 * @date 2023/2/4/004
 */
public class EncodeUtil {

    private static final String ALGORITHM = "HmacSHA256";

    public static String encodeString(String appKey, String appSecret, String timestamp, String version, String xReqNonce) {
        // 将所有请求参数按照key字典序进行排序
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("appKey", appKey);
        treeMap.put("appSecret", appSecret);
        treeMap.put("timestamp", timestamp);
        treeMap.put("version", version);
        treeMap.put("xReqNonce", xReqNonce);

        // 按顺序合并Value值
        StringBuilder mergeStr = new StringBuilder();
        treeMap.entrySet().stream().forEach(entry -> mergeStr.append(entry.getValue()));
        System.out.println("mergeStr = " + mergeStr);

        // 编码
        String encodedStr = URLEncoder.encode(mergeStr.toString(), StandardCharsets.UTF_8);
        System.out.println("encodedStr = " + encodedStr);

        try {
            Mac mac = Mac.getInstance(ALGORITHM);
            SecretKeySpec signKey = new SecretKeySpec(appSecret.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            mac.init(signKey);
            byte[] signData = mac.doFinal(encodedStr.getBytes(StandardCharsets.UTF_8));
            byte[] resultBytes = Base64.getEncoder().encode(signData);
            String signResult = new String(resultBytes, StandardCharsets.UTF_8);
            System.out.println("signResult = " + signResult);
            return signResult;
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String appKey = "NURDNkVCMDY3MzJBNDM3RjlGNDFFRjM2NjNCMUE0RTY=";
        String appSecret = "9sbAv4xfdcN7lzVr3PugRg==";
        String timestamp = "1544252223384";
        String version = "1.0.0";
        String xReqNonce = "97972162d1b14076b19ff75a9ba431d9";

        encodeString(appKey, appSecret, timestamp, version, xReqNonce);
    }
}
