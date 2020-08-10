package com.rich.rich.service;

import com.rich.rich.bean.QueryImage;
import com.rich.rich.mapper.QueryImagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryImagesService {

    @Autowired
    QueryImagesMapper queryImagesMapper;

    public String insertQueryImages(QueryImage queryImage) {
        queryImagesMapper.insertQueryImages(queryImage);
        return "提交成功";
    }
}
