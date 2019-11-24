package com.example.test.dao;

import com.example.test.pojo.Book;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BookMapper
{
    @Select("select * from book where name = #{name}")
    @Results({
            @Result(property = "id", column = "id" , id = true, jdbcType = JdbcType.INTEGER),
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "price", column = "price", jdbcType = JdbcType.DOUBLE)
    })
    List<Book> getListByName(String name);
    @Insert("insert into book (name, price) values (#{name}, #{price})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insertByBook(Book book);
}
