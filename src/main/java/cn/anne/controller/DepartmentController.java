package cn.anne.controller;

import cn.anne.domain.Department;
import cn.anne.service.DepartmentService;
import cn.anne.service.IDepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DepartmentController {

    @Resource(name="departmentService")
    private IDepartmentService departmentService;

    @RequestMapping(path = "/depts")
    @ResponseBody
    public List<Department> getDepts(){
       List<Department> departments = departmentService.findDepts();

       return departments;
    }
}
