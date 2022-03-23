package com.zzl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzl.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BookDao extends BaseMapper<Book> {

    @Select("select * from book where id = #{id}")
    Book getById(Integer id);


}
