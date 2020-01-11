package com.yzf.example.entity;

import java.io.Serializable;

/**
 * (SysPermission)实体类
 *
 * @author Administrator
 * @since 2020-01-06 16:46:32
 */
public class SysPermission implements Serializable {

    private static final long serialVersionUID = -36254301984849315L;

        
    private Integer id;

    //名称    
    private String name;

    //资源类型，[menu|button]    
    private String resourceType;

    //资源路径    
    private String url;

    //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view    
    private String permission;

    //父编号    
    private Long parentId;

    //父编号列表    
    private String parentIds;

    //是否可用    
    private Integer available;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

}