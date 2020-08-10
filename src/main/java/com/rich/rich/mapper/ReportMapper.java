package com.rich.rich.mapper;

import com.rich.rich.bean.Query;
import com.rich.rich.bean.QueryImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Mapper
@Repository
public interface ReportMapper {

    @Select("select * from qy_queryimage where date=#{date}")
    public QueryImage selectQueryImage(String date);

    @Select("select * from qy_query where date between #{startTime} and #{endTime}")
    public List<Query> selectQueryOrder(@Param("startTime") String startTime, @Param("endTime") String endTime);
}
