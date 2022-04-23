package com.hrms.controller;

import com.hrms.bean.Department;
import com.hrms.service.DepartmentService;
import com.hrms.utils.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/hrms/dept")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    /**
     * 增加部门
     * @return
     */
    @RequestMapping(value = "/addDept",  method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg addDept(Department department){
        int res = departmentService.addDept(department);
        if(res != 1){
            return JsonMsg.fail().addInfo("add_dept_error", "添加异常");
        }
        return JsonMsg.success();
    }

    /**
     * 根据id更新部门
     * @return
     */
    @RequestMapping(value =  "/updateDeptById/{deptId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg updateDeptById(@PathVariable("deptId") Integer deptId, Department department){
        int res = 0;
        if(department != null){
            res = departmentService.updateDeptById(department);
        }
        if(res == 1){
            return JsonMsg.success();
        }
        return JsonMsg.fail().addInfo("update_dept_error", "部门更新异常");
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "/deleteDept/{deptId}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonMsg deleteDept(@PathVariable("deptId") Integer deptId){
        int res = 0;
        if(deptId>0){
            res = departmentService.deleteDeptById(deptId);
        }
        if(res == 1){
            return JsonMsg.success();
        }
        return JsonMsg.fail().addInfo("del_dept_error", "删除部门失败");
    }

    /**
     * 查询部门信息总页码数
     * @return
     */
    @RequestMapping(value = "/getTotalPages", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getTotalPages(){
        int limit = 5;
        int totalItems = departmentService.getDeptCount();
        int temp = totalItems/limit;
        int totalPages = (totalItems % limit == 0) ? temp : temp+1;

        return JsonMsg.success().addInfo("totalPages", totalPages);
    }

    /**
     * 根据id查询部门
     */
    @RequestMapping("/getDeptById/{deptId}")
    @ResponseBody
    public JsonMsg getDeptById(@PathVariable("deptId") Integer deptId){
        Department department = departmentService.getDeptById(deptId);
        if(department != null){
            return JsonMsg.success().addInfo("department", department);
        }
        return JsonMsg.fail().addInfo("get_dept_error", "获取异常");
    }

    /**
     * 分页查询，返回指定页码对应的数据
     */
    @RequestMapping("/getDeptList")
    public ModelAndView getDeptList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo){
        ModelAndView mv = new ModelAndView("departmentPage");
        //每页显示的记录行数
        int limit = 5;
        int offset = (pageNo-1)*limit;
        List<Department> departments = departmentService.getDeptList(offset, limit);

        //总记录数
        int totalItems = departmentService.getDeptCount();

        //总页数
        int temp = totalItems/limit;
        int totalPages = (totalItems%limit == 0) ? temp : temp + 1;

        int curPageNo = pageNo;
        mv.addObject("departments", departments)
                .addObject("totalItems",totalItems)
                .addObject("totalPages", totalPages)
                .addObject("curPageNo", pageNo);
        return mv;
    }

    /**
     * 查询部门名称
     * @return
     */
    @RequestMapping(value = "/getDeptName", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getDeptName(){
        List<Department> departmentList = departmentService.getDeptName();
        if(departmentList != null){
            return JsonMsg.success().addInfo("departmentList", departmentList);
        }
        return JsonMsg.fail();
    }

}
