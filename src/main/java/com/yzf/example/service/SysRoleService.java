package com.yzf.example.service;

import com.yzf.example.entity.SysRole;
import com.yzf.example.entity.Page;
import java.util.List;

/**
 * (SysRole)表服务接口
 *
 * @author Administrator
 * @since 2020-01-06 17:28:01
 */
public interface SysRoleService {
    /**
     *
     * @param uid
     * @return
     */
    List<SysRole> getAllRole(Integer uid);

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
    SysRole queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param page [offset,limit]
     * @return 对象列表
     */
    List<SysRole> queryAllByLimit(Page page);

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    int insert(SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    int update(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int delById(Integer id);

}