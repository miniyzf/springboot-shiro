package com.yzf.example.service.impl;

import com.yzf.example.entity.SysRole;
import com.yzf.example.entity.SysUserRole;
import com.yzf.example.entity.Page;
import com.yzf.example.dao.DaoSupport;
import com.yzf.example.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUserRole)表服务实现类
 *
 * @author Administrator
 * @since 2020-01-06 17:36:12
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
    
    @Resource(name = "daoSupport")
    private DaoSupport dao;

    /**
     * 分页查询后执行，获取总记录数
     *
     * @return 总记录数
     */
    @Override
    public int queryCountAfterLimit() {
        try {
            return (int)dao.findForObject("SysUserRoleMapper.queryCountAfterLimit", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 总记录数
     *
     * @return 总记录数
     */
    @Override
    public int count() {
        try {
            return (int)dao.findForObject("SysUserRoleMapper.count", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUserRole queryById(Integer id) {
        try {
            return (SysUserRole)dao.findForObject("SysUserRoleMapper.queryById", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询多条数据
     *
     * @param page [offset,limit]
     * @return 对象列表
     */
    @Override
    public List<SysUserRole> queryAllByLimit(Page page) {
        try {
            return (List<SysUserRole>)dao.findForList("SysUserRoleMapper.queryAllByLimit", page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;       
    }

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SysUserRole sysUserRole) {        
        try {
            return (int)dao.save("SysUserRoleMapper.insert", sysUserRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SysUserRole sysUserRole) {        
        try {
            return (int)dao.update("SysUserRoleMapper.update", sysUserRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int delById(Integer id) {
        try {
            return (int)dao.delete("SysUserRoleMapper.delById", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}