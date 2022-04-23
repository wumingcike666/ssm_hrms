package com.hrms.controller;


import com.hrms.bean.Employee;
import com.hrms.service.EmployeeService;
import com.hrms.utils.JsonMsg;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/hrms/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * 根据id查询员工
     * @param empId
     * @return
     */
    @RequestMapping(value = "/getEmpById/{empId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getEmpById(@PathVariable("empId") Integer empId){
        Employee employee = employeeService.getEmpById(empId);
        if(employee != null){
            return JsonMsg.success().addInfo("employee", employee);
        }
        return JsonMsg.fail();
    }

    /**
     * 新增员工
     * @return
     */
    @RequestMapping(value = "/addEmp", method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg addEmp(Employee employee){
        int res = employeeService.addEmp(employee);
        if(res == 1){
            return JsonMsg.success();
        }else{
            return JsonMsg.fail();
        }
    }

    /**
     * 员工删除操作
     * @return
     */
    @RequestMapping(value = "/deleteEmp/{empId}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonMsg deleteEmp(@PathVariable("empId") Integer empId){
        int res = 0;
        if(empId > 0){
            res = employeeService.deleteEmpById(empId);
        }
        if(res == 1){
            return JsonMsg.success();
        }
        return JsonMsg.fail().addInfo("emp_del_error", "删除异常");
    }

    /**
     * 更改员工信息
     * @return
     */
    @RequestMapping(value = "/updateEmp/{empId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg updateEmp(@PathVariable("empId") Integer empId,  Employee employee){
        int res = employeeService.updateEmpById(empId, employee);
        if(res == 1){
            return JsonMsg.success();
        }else{
            return JsonMsg.fail().addInfo("emp_update_error", "更改异常");
        }
    }

    /**
     * 新增记录后，查询最新的页数
     * @return
     */
    @RequestMapping("/getTotalPage")
    @ResponseBody
    public String getTotalPage(){
        int res = employeeService.getEmpCount();
        System.out.println(res);
        System.out.println("获取成功！");
        return "test";
    }

    /**
     * 查询输入的员工姓名是否重复
     * @param
     * @return
     */
     @RequestMapping(value = "/checkEmpExists", method = RequestMethod.GET)
     @ResponseBody
     public JsonMsg checkEmpExists(String empName){
        //对输入的姓名和邮箱的格式进行验证
        String regName = "(^[a-zA-Z0-9_-]{3,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
        if(!empName.matches(regName)){
            return JsonMsg.fail().addInfo("name_reg_error", "输入的姓名为2-5位中文或6-16位英文和数字的组合");
        }
        Employee employee = employeeService.getEmpByName(empName);
        if(employee != null){
            return JsonMsg.fail().addInfo("name_reg_error", "用户名重复");
        }else{
            return JsonMsg.success();
        }
     }

     @RequestMapping("/getEmpList")
     public ModelAndView getEmp(@RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo){
         ModelAndView mv = new ModelAndView("employeePage");
         int limit = 5;
         int offset = (pageNo-1)*limit;
         //获取指定页数包含的信息
         List<Employee> employees = employeeService.getEmpList(offset, limit);

         //获取总的记录数
         int totalItems = employeeService.getEmpCount();
         //获取总的页数
         int temp = totalItems/limit;
         int totalPages = (totalItems % limit == 0) ? temp : temp+1;

         //当前页数
         int curPage = pageNo;

         //将上述查询结果放到Model中， 在jsp页面中可以进行展示
         mv.addObject("employees", employees)
                 .addObject("totalItems", totalItems)
                 .addObject("totalPages", totalPages)
                 .addObject("curPage", curPage);
         return mv;
     }

}
