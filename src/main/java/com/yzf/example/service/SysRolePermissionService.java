package com.yzf.example.service;

import com.yzf.example.entity.SysPermission;
import com.yzf.example.entity.SysRolePermission;
import com.yzf.example.entity.Page;
import java.util.List;

/**
 * (SysRolePermission)表服务接口
 *
 * @author Administrator
 * @since 2020-01-06 17:36:27
 */
public interface SysRolePermissionService {

    /**
     * 分页查询后执行，获取总记录数
     *
     * @return 总记录数
     */
    int queryCountAfterLimit();

    /**
     * 总记录数
     *
     * @return 总记录数
     */
    int count();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRolePermission queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param page [offset,limit]
     * @return 对象列表
     */
    List<SysRolePermission> queryAllByLimit(Page page);

    /**
     * 新增数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    int insert(SysRolePermission sysRolePermission);

    /**
     * 修改数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    int update(SysRolePermission sysRolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int delById(Integer id);

}