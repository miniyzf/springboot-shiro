package com.yzf.example.service;

import com.yzf.example.entity.SysPermission;
import com.yzf.example.entity.Page;
import java.util.List;

/**
 * (SysPermission)表服务接口
 *
 * @author Administrator
 * @since 2020-01-06 16:53:15
 */
public interface SysPermissionService {
    /**
     *
     * @param roleId
     * @return
     */
    List<SysPermission> getAllPermission(Integer roleId);

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
    SysPermission queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param page [offset,limit]
     * @return 对象列表
     */
    List<SysPermission> queryAllByLimit(Page page);

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    int insert(SysPermission sysPermission);

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    int update(SysPermission sysPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int delById(Integer id);

}