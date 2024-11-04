package com.example.mybatis;

import com.example.mapper.EmployeeMapper;
import com.example.pojo.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

//Author:UserName
//在2024/3/31 14:21创建
public class MybatisTest {
    private SqlSession sqlSession;

    @BeforeEach  //每次走测试方法之前 先走的初始化方法
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);//开启自动提交
    }


    //使用分页插件
    @Test
    public void test_01(){

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        //调用之前,先设置分页数据 (当前是第几页,每页显示多少个! )
        PageHelper.startPage(1,2);  // 1 2

        // TODO: 注意不能将两条查询装到一个分页区
        List<Employee> list =   mapper.queryList();
        //将查询数据封装到一个PageInfo的分页实体类 (一共有多少页,一共有多少条等等)
        PageInfo<Employee> pageInfo = new PageInfo<>(list);

        //pageInfo获取分页的数据

        //当前页的数据
        List<Employee> list1 = pageInfo.getList();
        System.out.println("list1 = " + list1);
        //获取总页数
        int pages = pageInfo.getPages();
        System.out.println("pages = " + pages);
        //总条数
        long total = pageInfo.getTotal();
        System.out.println("total = " + total);
        int pageNum = pageInfo.getPageNum();
        System.out.println("pageNum = " + pageNum);
        int pageSize = pageInfo.getPageSize();
        System.out.println("pageSize = " + pageSize);

    }

    @Test
    public void test_02(){
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        // 批量查询
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<Employee> employees = mapper.queryBatch(ids);
        System.out.println("Query Batch: " + employees);
    }

    @Test
    public void test_03(){
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 批量删除
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        int deleteCount = mapper.deleteBatch(ids);
        System.out.println("Delete Count: " + deleteCount);
    }

    @Test
    public void test_04() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 批量插入
        List<Employee> insertList = new ArrayList<>();
        insertList.add(new Employee(5, "Alice", 5000.0));
        insertList.add(new Employee(6, "Bob", 6000.0));
        int insertCount = mapper.insertBatch(insertList);
        System.out.println("Insert Count: " + insertCount);
    }

    @Test
    public void test_05() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 批量更新
        List<Employee> updateList = new ArrayList<>();
        updateList.add(new Employee(3, "Alice Updated", 5500.0));
        updateList.add(new Employee(4, "Bob Updated", 6500.0));
        int updateCount = mapper.updateBatch(updateList);
        System.out.println("Update Count: " + updateCount);
    }

    @AfterEach //每次走测试方法之后调用的方法!
    public void clean(){
        sqlSession.close();
    }
}
