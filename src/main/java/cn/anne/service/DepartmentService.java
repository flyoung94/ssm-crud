package cn.anne.service;

import cn.anne.dao.DepartmentMapper;
import cn.anne.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService{

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findDepts() {
        return departmentMapper.selectByExample(null);
    }
}
