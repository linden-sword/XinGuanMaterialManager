package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.TbDepartment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * (TbDepartment)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:36
 */
@Mapper
public interface TbDepartmentMapper {
//12、系统部⻔接⼝ : Department Controller POST /api/department/add 添加部⻔
//    DELETE /api/department/delete/{id} 删除部⻔
//    GET /api/department/edit/{id} 编辑部⻔
//    POST /api/department/excel 导出excel
//        GET /api/department/findAll 所有部⻔
//        GET /api/department/findDeanList 部⻔主任
//     GET /api/department/findDepartmentList 部⻔列表
//    PUT /api/department/update/{id} 更新部⻔
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbDepartment edit(long id);

    /**
     * 查询所有
     * @param tbDepartment
     * @return
     */
    List<TbDepartment> findDepartmentList(TbDepartment tbDepartment);
    List<TbDepartment> findAll();

    /**
     * 新增数据
     *
     * @param tbDepartment 实例对象
     * @return 影响行数
     */
    int add(TbDepartment tbDepartment);


    /**
     * 修改数据
     *
     * @param tbDepartment 实例对象
     * @return 影响行数
     */
    int update(TbDepartment tbDepartment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(long id);

}

