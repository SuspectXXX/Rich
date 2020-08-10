package com.rich.rich.service;

import com.rich.rich.bean.Query;
import com.rich.rich.mapper.QueryOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryOrderService {

    @Autowired
    QueryOrderMapper queryOrderMapper;

    public String insertQuery(Query query) {
        queryOrderMapper.insertQueryOrder(query);
        return "提交成功";
    }
}
