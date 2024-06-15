package com.mapper;

import com.example.pojo.TEmp;

/**
* @author UserName
* @description 针对表【t_emp】的数据库操作Mapper
* @createDate 2024-03-31 14:48:44
* @Entity com.example.pojo.TEmp
*/
public interface TEmpMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TEmp record);

    int insertSelective(TEmp record);

    TEmp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TEmp record);

    int updateByPrimaryKey(TEmp record);

}
