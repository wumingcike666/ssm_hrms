package com.hrms.mapper;

import com.hrms.bean.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {

    /**
     * 新增
     */
    int insertDept(@Param("department") Department department);

    /**
     * 删除
     */
    int deleteDeptById(Integer deptId);

    /**
     * 根据id修改
     * @param dept
     * @return
     */
    int updateDeptById(Department dept);

    /**
     * 查询
     * @return
     */
    List<Department> selectDeptList();

    Department selectOneById(Integer deptId);

    Department selectOneByLeader(String  deptLeader);

    Department selectOneByName(String deptName);

    List<Department> selectDeptsByLimitAndOffset(Integer offset, Integer limit);

    int checkDeptsExistsByNameAndleader(String deptName, String LeaderName);

    int countDepts();
}
