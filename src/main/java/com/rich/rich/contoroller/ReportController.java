package com.rich.rich.contoroller;

import com.alibaba.fastjson.JSONObject;
import com.rich.rich.bean.Query;
import com.rich.rich.bean.QueryImage;
import com.rich.rich.bean.Querys;
import com.rich.rich.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
@ResponseBody
public class ReportController {

    @Autowired
    ReportService reportService;

    @RequestMapping("/queryReport")
    public String report(@RequestParam String startTime, @RequestParam String endTime, Map<String, Object> map) {
        JSONObject json = new JSONObject();
        List<Querys> querysList = reportService.selectQueryOrder(startTime, endTime);
//        json.put("querys", queryOrder);
//        for (Querys q : querysList) {
//            System.out.println(q);
//        }
//        map.put("querys", querysList);
//        map.put("s", 123);
        json.put("querysList", querysList);
//        System.out.println(startTime);
//        System.out.println(endTime);
        return json.toJSONString();
    }
}
