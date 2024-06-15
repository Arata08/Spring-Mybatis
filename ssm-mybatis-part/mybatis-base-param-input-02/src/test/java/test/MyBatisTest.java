package test;

import com.example.mapper.EmployeeMapper;
import com.example.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//Author:UserName
//2024/3/29 14:31创建
public class MyBatisTest {
    @Test
    public void test() throws IOException {
        //读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(ips);
        //openSession自动开启事务,不会自动提交 !
        //openSession(true)自动开启事务,自动提交事务!  不需要sqlSession.commit();
        SqlSession session = sf.openSession(true);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setEmpSalary(8888.0);
        employee.setEmpName("艾米莉亚");

        System.out.println(employee.getEmpId());

        System.out.println("----------------------");
        int rows =  mapper.insertEmp(employee);
        System.out.println("rows = " + rows);
        System.out.println(employee.getEmpId());
        session.close();
    }
}
