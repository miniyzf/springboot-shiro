package com.yzf.example.service.impl;

import com.yzf.example.entity.SysRole;
import com.yzf.example.entity.Page;
import com.yzf.example.dao.DaoSupport;
import com.yzf.example.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysRole)表服务实现类
 *
 * @author Administrator
 * @since 2020-01-06 17:28:01
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    
    @Resource(name = "daoSupport")
    private DaoSupport dao;

    @Override
    public List<SysRole> getAllRole(Integer uid) {
        try {
            return (List<SysRole>)dao.findForList("SysRoleMapper.getAllRole",uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 分页查询后执行，获取总记录数
     *
     * @return 总记录数
     */
    @Override
    public int queryCountAfterLimit() {
        try {
            return (int)dao.findForObject("SysRoleMapper.queryCountAfterLimit", null);
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
            return (int)dao.findForObject("SysRoleMapper.count", null);
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
    public SysRole queryById(Integer id) {
        try {
            return (SysRole)dao.findForObject("SysRoleMapper.queryById", id);
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
    public List<SysRole> queryAllByLimit(Page page) {
        try {
            return (List<SysRole>)dao.findForList("SysRoleMapper.queryAllByLimit", page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;       
    }

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SysRole sysRole) {        
        try {
            return (int)dao.save("SysRoleMapper.insert", sysRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SysRole sysRole) {        
        try {
            return (int)dao.update("SysRoleMapper.update", sysRole);
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
            return (int)dao.delete("SysRoleMapper.delById", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}