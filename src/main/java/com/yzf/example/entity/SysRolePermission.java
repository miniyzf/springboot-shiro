package com.yzf.example.entity;

import java.io.Serializable;

/**
 * (SysRolePermission)实体类
 *
 * @author Administrator
 * @since 2020-01-06 17:38:14
 */
public class SysRolePermission implements Serializable {

    private static final long serialVersionUID = 186873084626212262L;

    //自增    
    private Integer id;

    //sysRole id    
    private Integer roleId;

    //sysPermission id    
    private Integer permissionId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

}