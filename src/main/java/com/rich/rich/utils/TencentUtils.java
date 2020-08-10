package com.rich.rich.utils;

import com.alibaba.fastjson.JSONObject;
import com.rich.rich.config.TencentConstants;
import com.rich.rich.config.WxCpProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class TencentUtils {

    @Autowired
    WxCpProperties wxCpProperties;

    private String sendPostRequest(String url) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        try {
            URL postUrl = new URL(url);
            //打开和url之间的连接
            HttpURLConnection urlConnection = (HttpURLConnection) postUrl.openConnection();
            //发送post请求必须设置如下两行
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            //设置请求方式
            urlConnection.setRequestMethod("POST");
            //设置是否使用缓存
            urlConnection.setUseCaches(false);
            urlConnection.setInstanceFollowRedirects(true);
            //设置数据返回形式
            urlConnection.setRequestProperty("Content-Type", "application/json");
            // 接受数据
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = null;
            while((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return stringBuffer.toString();
    }

    public String getToken() {
        String url = TencentConstants.GET_TOKEN_URL +
                    TencentConstants.QUERY +
                    TencentConstants.GET_TOKEN_URL_PARAM_COPRID +
                    TencentConstants.EQUAL +
                    TencentConstants.CORPID +
                    TencentConstants.AND +
                    TencentConstants.GET_TOKEN_URL_PARAM_CORPSECRET +
                    TencentConstants.EQUAL +
                    TencentConstants.CORPSECRET;
        String jsonTokeString = sendPostRequest(url);
        JSONObject jsonObject = JSONObject.parseObject(jsonTokeString);
        String errCode = jsonObject.getString(TencentConstants.GET_TOKEN_RETURN_ERRCODE);
        if(TencentConstants.GET_JSAPITICKET_RETURN_SUCCESS_CODE.equals(errCode)) {
            return jsonObject.getString(TencentConstants.GET_TOKEN_RETURN_TOKEN);
        }
        return null;
    }

    public String getJSSDKTicket(String token) {
        String url = TencentConstants.GET_JSAPITICKET_URL +
                    TencentConstants.QUERY +
                    TencentConstants.GET_JSAPITICKET_URL_PARAM_TOKEN +
                    TencentConstants.EQUAL +
                    token;
        String jsonTicketString = sendPostRequest(url);
        JSONObject jsonObject = JSONObject.parseObject(jsonTicketString);
        String errCode = jsonObject.getString(TencentConstants.GET_JSAPITICKET_RETURN_ERRCODE);
        if(TencentConstants.GET_JSAPITICKET_RETURN_SUCCESS_CODE.equals(errCode)) {
            return TencentConstants.GET_JSAPITICKET_RETURN_TICKET;
        }
        return null;
    }

    public String getSignature(String url, String ticket) {
        JSONObject jsonObject = new JSONObject();
        String noncestr = UUID.randomUUID().toString().replace("-", "");
        String timestamp = (long)System.currentTimeMillis()/1000 + "";
        String sign = TencentConstants.GET_JSAPITICKET_URL_PARAM_TICKET +
                    ticket +
                    TencentConstants.AND +
                    TencentConstants.GET_JSAPITICKET_URL_PARAM_NONCESTR +
                    noncestr +
                    TencentConstants.AND +
                    TencentConstants.GET_JSAPITICKET_URL_PARAM_TIMESTAMP +
                    timestamp +
                    TencentConstants.GET_JSAPITICKET_URL_PARAM_URL +
                    url;
        String signature = null;
        try {
            //指定sha1算法
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(sign.getBytes());
            //获取字节数组
            byte[] messageDigest = digest.digest();
            //创建数组，存储十六进制数
            StringBuffer hexString = new StringBuffer();
            //字节数组转换为十六进制数
            for(int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if(shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            signature = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        jsonObject.put(TencentConstants.GET_JSAPITICKET_RETURN_SIGNATURE, signature);
        jsonObject.put(TencentConstants.GET_JSAPITICKET_URL_PARAM_NONCESTR, noncestr);
        jsonObject.put(TencentConstants.GET_JSAPITICKET_URL_PARAM_TIMESTAMP, timestamp);
        return jsonObject.toJSONString();
    }


}
