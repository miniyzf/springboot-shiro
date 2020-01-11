package com.yzf.example.service.impl;

import com.yzf.example.entity.SysRolePermission;
import com.yzf.example.entity.Page;
import com.yzf.example.dao.DaoSupport;
import com.yzf.example.service.SysRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysRolePermission)表服务实现类
 *
 * @author Administrator
 * @since 2020-01-06 17:36:27
 */
@Service("sysRolePermissionService")
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
    
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
            return (int)dao.findForObject("SysRolePermissionMapper.queryCountAfterLimit", null);
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
            return (int)dao.findForObject("SysRolePermissionMapper.count", null);
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
    public SysRolePermission queryById(Integer id) {
        try {
            return (SysRolePermission)dao.findForObject("SysRolePermissionMapper.queryById", id);
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
    public List<SysRolePermission> queryAllByLimit(Page page) {
        try {
            return (List<SysRolePermission>)dao.findForList("SysRolePermissionMapper.queryAllByLimit", page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;       
    }

    /**
     * 新增数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SysRolePermission sysRolePermission) {        
        try {
            return (int)dao.save("SysRolePermissionMapper.insert", sysRolePermission);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 修改数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SysRolePermission sysRolePermission) {        
        try {
            return (int)dao.update("SysRolePermissionMapper.update", sysRolePermission);
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
            return (int)dao.delete("SysRolePermissionMapper.delById", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}