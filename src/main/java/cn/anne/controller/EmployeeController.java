package cn.anne.controller;

import cn.anne.domain.Department;
import cn.anne.domain.Employee;
import cn.anne.service.IEmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Resource(name="employeeService")
    private IEmployeeService employeeService;

    @RequestMapping(path = "/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){

        PageHelper.startPage(pn,6);
        List<Employee> employees = employeeService.findAll();
        PageInfo page = new PageInfo(employees,6);
        model.addAttribute("pageInfo",page);
        return "list";
    }

    @RequestMapping(path="/saveEmp")
    @ResponseBody
    public Map<String,String> saveEMp(Employee employee){
        employeeService.saveEmp(employee);

        Map<String,String> res = new HashMap<String, String>();
        res.put("res","success");
        return res;
    }

}
