package com.yzf.example.service.impl;

import com.yzf.example.entity.SysPermission;
import com.yzf.example.entity.SysRole;
import com.yzf.example.entity.SysUser;
import com.yzf.example.entity.Page;
import com.yzf.example.dao.DaoSupport;
import com.yzf.example.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author Administrator
 * @since 2020-01-06 17:25:19
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    
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
            return (int)dao.findForObject("SysUserMapper.queryCountAfterLimit", null);
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
            return (int)dao.findForObject("SysUserMapper.count", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Integer uid) {
        try {
            return (SysUser)dao.findForObject("SysUserMapper.queryById", uid);
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
    public List<SysUser> queryAllByLimit(Page page) {
        try {
            return (List<SysUser>)dao.findForList("SysUserMapper.queryAllByLimit", page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;       
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SysUser sysUser) {        
        try {
            return (int)dao.save("SysUserMapper.insert", sysUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SysUser sysUser) {        
        try {
            return (int)dao.update("SysUserMapper.update", sysUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    @Override
    public int delById(Integer uid) {
        try {
            return (int)dao.delete("SysUserMapper.delById", uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public SysUser findByUsername(String username) {
        try {
            return (SysUser)dao.findForObject("SysUserMapper.findByUsername", username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}