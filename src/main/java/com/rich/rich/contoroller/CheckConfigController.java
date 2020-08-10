package com.rich.rich.contoroller;

import com.alibaba.fastjson.JSONObject;
import com.rich.rich.utils.TencentUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@ResponseBody
public class CheckConfigController {

    @RequestMapping("/getSignature")
    public String getSignature(HttpServletRequest request) {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("signature", UUID.randomUUID().toString().replace("-", ""));
//        return jsonObject.toJSONString();
        String token = "";
        HttpSession session = request.getSession();
        String url = request.getRequestURL().toString();
        TencentUtils tencentUtils = new TencentUtils();
        if(session.getAttribute("token") == null || (System.currentTimeMillis()/1000 - (long)session.getAttribute("time") > 7200)) {
            token = tencentUtils.getToken();
            session.setAttribute("token", token);
            session.setAttribute("time", System.currentTimeMillis()/1000);
        } else {
            token = (String)session.getAttribute("token");
        }
        String jssdkTicket = tencentUtils.getJSSDKTicket(token);
        String signature = tencentUtils.getSignature(url, jssdkTicket);
        System.out.println(signature);
        return signature;
    }
}
