package com.rich.rich.mapper;

import com.rich.rich.bean.Query;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface QueryOrderMapper {
    @Select("select * from qy_query where id=#{id}")
    public Query getQueryOrderById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into qy_queryorder(power,tempure,date,u_id) values(#{power},#{tempure},#{date},#{u_id})")
    public void insertQueryOrder(Query query);
}
