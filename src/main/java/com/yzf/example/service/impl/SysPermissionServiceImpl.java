package com.yzf.example.service.impl;

import com.yzf.example.entity.SysPermission;
import com.yzf.example.entity.Page;
import com.yzf.example.dao.DaoSupport;
import com.yzf.example.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysPermission)表服务实现类
 *
 * @author Administrator
 * @since 2020-01-06 16:53:15
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {
    
    @Resource(name = "daoSupport")
    private DaoSupport dao;

    @Override
    public List<SysPermission> getAllPermission(Integer roleId) {
        try {
            return (List<SysPermission>)dao.findForList("SysPermissionMapper.getAllPermission",roleId);
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
            return (int)dao.findForObject("SysPermissionMapper.queryCountAfterLimit", null);
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
            return (int)dao.findForObject("SysPermissionMapper.count", null);
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
    public SysPermission queryById(Integer id) {
        try {
            return (SysPermission)dao.findForObject("SysPermissionMapper.queryById", id);
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
    public List<SysPermission> queryAllByLimit(Page page) {
        try {
            return (List<SysPermission>)dao.findForList("SysPermissionMapper.queryAllByLimit", page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;       
    }

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SysPermission sysPermission) {        
        try {
            return (int)dao.save("SysPermissionMapper.insert", sysPermission);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SysPermission sysPermission) {        
        try {
            return (int)dao.update("SysPermissionMapper.update", sysPermission);
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
            return (int)dao.delete("SysPermissionMapper.delById", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}