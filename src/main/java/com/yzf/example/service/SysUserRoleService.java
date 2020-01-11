package com.yzf.example.service;

import com.yzf.example.entity.SysRole;
import com.yzf.example.entity.SysUserRole;
import com.yzf.example.entity.Page;
import java.util.List;

/**
 * (SysUserRole)表服务接口
 *
 * @author Administrator
 * @since 2020-01-06 17:36:12
 */
public interface SysUserRoleService {

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
    SysUserRole queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param page [offset,limit]
     * @return 对象列表
     */
    List<SysUserRole> queryAllByLimit(Page page);

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    int insert(SysUserRole sysUserRole);

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    int update(SysUserRole sysUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int delById(Integer id);

}