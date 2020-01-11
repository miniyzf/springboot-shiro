package com.yzf.example.service;

import com.yzf.example.entity.SysPermission;
import com.yzf.example.entity.SysRole;
import com.yzf.example.entity.SysUser;
import com.yzf.example.entity.Page;
import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author Administrator
 * @since 2020-01-06 17:25:19
 */
public interface SysUserService {

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
     * @param uid 主键
     * @return 实例对象
     */
    SysUser queryById(Integer uid);

    /**
     * 查询多条数据
     *
     * @param page [offset,limit]
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(Page page);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    int insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    int update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    int delById(Integer uid);


    SysUser findByUsername(String username);

}