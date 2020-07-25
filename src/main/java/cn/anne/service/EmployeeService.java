package cn.anne.service;

import cn.anne.dao.DepartmentMapper;
import cn.anne.dao.EmployeeMapper;
import cn.anne.domain.Department;
import cn.anne.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> findAll() {
        return employeeMapper.selectByExampleWithDept(null);
    }

    public void saveEmp(Employee employee){
        employeeMapper.insertSelective(employee);
    }
}
