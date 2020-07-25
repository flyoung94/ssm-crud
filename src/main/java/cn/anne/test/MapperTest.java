package cn.anne.test;

import cn.anne.dao.DepartmentMapper;
import cn.anne.dao.EmployeeMapper;
import cn.anne.domain.Department;
import cn.anne.domain.Employee;
import cn.anne.service.IDepartmentService;
import cn.anne.service.IEmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Resource(name = "employeeService")
    IEmployeeService employeeService;

    @Resource(name="departmentService")
    IDepartmentService departmentService;

    @Test
    public void mapperTest(){
        System.out.println(departmentMapper);

//        Department department = new Department(2,"测试部");
//        departmentMapper.insertSelective(department);
       // employeeMapper.insertSelective(new Employee(2,"Marry","F","Marry@anne.cn",2));
      /*  EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i=0;i<=90;i++){
            String  uuid = UUID.randomUUID().toString().substring(0,5) + i;
            employeeMapper.insertSelective(new Employee(null,uuid,"M",uuid+"@anne.cn",1));
        }*/
      List<Employee> employees = employeeMapper.selectByExampleWithDept(null);
     // List<Employee> employees = employeeService.findAll();
      for (Employee employee:employees){
          System.out.println(employee);
      }


    List<Department> departments = departmentService.findDepts();
    // List<Employee> employees = employeeService.findAll();
      for(Department department:  departments){
        System.out.println(department);
    }
}
}
