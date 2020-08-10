package com.rich.rich.contoroller;

import com.rich.rich.config.WxCpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    WxCpProperties wxCpProperties;

    @RequestMapping({"/","/index"})
    public String index () {

//        System.out.println(wxCpProperties.getCorpId());
//        System.out.println(wxCpProperties.getAddConfigs());
//        return wxCpProperties.getCorpId();
        return "index";
    }

    @RequestMapping("/myReport")
    public String report (HttpServletRequest request, HttpServletResponse response) {
//        System.out.println(url);

        return "report";
    }
}
