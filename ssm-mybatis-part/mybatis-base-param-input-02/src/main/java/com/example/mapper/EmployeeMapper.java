package com.example.mapper;

import com.example.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    Employee queryById(Integer id);

    //int返回值用于接受受影响的行数
    int insertEmployee(Employee employee);

    //根据工资查询员工信息
    List<Employee> queryBySalary(Double salary);

    //根据员工姓名和工资查询员工信息
    List<Employee> queryByNameAndSalary(@Param("param1") String name, @Param("param2") Double salary);

    //插入员工数据，传入的是一个map(name=员工的名字,salary=员工的薪水)
    //mapper接口中不允许重载！！！ 方法名重复了  id名重复了！
    int insertEmpMap(Map data);

    //员工插入
    int insertEmp(Employee employee);
}
