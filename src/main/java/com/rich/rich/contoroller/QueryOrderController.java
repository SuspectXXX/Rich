package com.rich.rich.contoroller;

import com.rich.rich.bean.Query;
import com.rich.rich.mapper.QueryOrderMapper;
import com.rich.rich.service.QueryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
@ResponseBody
public class QueryOrderController {

    @Autowired
    QueryOrderService queryOrderService;

    @RequestMapping("/insertQO")
    public String insertQO(@RequestParam String power, @RequestParam String tempure, @RequestParam String content) {
        System.out.println(power + "--" + tempure);
        Query order = new Query();
        if(Integer.valueOf(power) == 1) {
            order.setPower("正常");
        } else {
            order.setPower("异常");
        }
        if(Integer.valueOf(tempure) == 1) {
            order.setTempure("正常");
        } else {
            order.setTempure("异常");
        }
        order.setDate(new Date());
        order.setuId(1);
        String msg = queryOrderService.insertQuery(order);
        return msg;
    }
}
