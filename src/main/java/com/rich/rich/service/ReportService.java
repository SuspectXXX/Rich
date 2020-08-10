package com.rich.rich.service;

import com.rich.rich.bean.Query;
import com.rich.rich.bean.QueryImage;
import com.rich.rich.bean.Querys;
import com.rich.rich.bean.User;
import com.rich.rich.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Service
public class ReportService {

    @Autowired
    ReportMapper reportMapper;

    @Autowired
    QueryUserService queryUserService;

    public QueryImage selectQueryImage(String date) {
        QueryImage queryImage = reportMapper.selectQueryImage(date);
        return queryImage;
    }

    public List<Querys> selectQueryOrder(String startTime, String endTime) {
        List<Query> queryOrder = reportMapper.selectQueryOrder(startTime, endTime);
//        System.out.println(queryOrder.get(0).getDate());
        List<Querys> querysList = new ArrayList<>();
        String paths = "";
        int index = 0;
        for (Query query : queryOrder) {
            Querys querys = new Querys();
            querys.setPower(query.getPower());
            querys.setTempure(query.getTempure());
            paths = query.getPowerImagePath();
            index = paths.lastIndexOf(";");
            querys.setPowerImagePath(paths.substring(0, index).split(";"));
            paths = query.getTempureImagePath();
            index = paths.lastIndexOf(";");
            querys.setTempureImagePath(paths.substring(0, index).split(";"));
            querys.setDate(query.getDate());
            User user = queryUserService.queryUser(query.getuId());
            querys.setName(user.getName());
            querysList.add(querys);
        }
        return querysList;
    }
}
