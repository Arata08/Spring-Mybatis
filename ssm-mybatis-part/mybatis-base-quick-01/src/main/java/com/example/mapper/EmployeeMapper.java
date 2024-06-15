package com.example.mapper;


import com.example.pojo.Employee;

/**
 * description: 规定数据库方法即可
 *
 * @author UserName
 */
public interface EmployeeMapper {

    //根据id查询员工信息
    Employee queryById(Integer id);

    int deleteById(Integer id);

    int insertEmployee();
}
