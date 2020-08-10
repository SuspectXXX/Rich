package com.rich.rich.mapper;

import com.rich.rich.bean.QueryImage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QueryImagesMapper {

    @Insert("insert into qy_queryimage(content, imagePath, date) values(#{content}, #{imagePath}, #{date})")
    public void insertQueryImages(QueryImage queryImage);
}
