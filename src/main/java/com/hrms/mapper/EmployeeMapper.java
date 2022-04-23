package com.hrms.mapper;

import com.hrms.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 删除
     */
    int deleteOneById(Integer empId);

    /**
     * 修改
     * @param empId
     * @return
     */
    int updateOneById(@Param("empId") Integer empId, @Param("employee")  Employee employee);

    /**
     * 增加
     * @param employee
     * @return
     */
    int insertOne(Employee employee);

    Employee selectOneById(Integer empId);

    Employee selectOneByName(String empName);

    //查询带有部门信息的Employee
    Employee selectWithDeptById(Integer empId);

    /**
     *
     * @param offset 返回记录的最大行数
     * @param limit 返回记录行的偏移量
     * @return 比如offset=10,  limit = 5的时候，就会数据库第11行开始返回5条查询结果记录， 即范围（offset+1， offset+limit）
     */
    List<Employee> selectByLimitAndOffsert(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 查询记录总数
     * @return
     */
    int countEmps();
}
