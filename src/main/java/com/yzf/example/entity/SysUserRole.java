package com.yzf.example.entity;

import java.io.Serializable;

/**
 * (SysUserRole)实体类
 *
 * @author Administrator
 * @since 2020-01-06 17:38:21
 */
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 568435347019713920L;

    //自增主键    
    private Integer id;

    //sysUser uid    
    private Integer uid;

    //sysRole id    
    private Integer roleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}