package cn.anne.service;

import cn.anne.domain.Department;
import cn.anne.domain.Employee;

import java.util.List;

public interface IEmployeeService {
    public  List<Employee> findAll();
    public void saveEmp(Employee employee);
}
