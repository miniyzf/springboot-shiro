package com.yzf.example.entity;

import lombok.Data;

import java.util.List;

/**
 * SysRole
 *
 * @author Administrator
 * @date 2020/1/6
 */
@Data
public class SysRole {

    private Integer id; // 编号
    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:
    private String description; // 角色描述,UI界面显示使用
    private Boolean available; // 是否可用,如果不可用将不会添加给用户

    //角色 -- 权限关系：多对多关系;
    private List<SysPermission> permissions;

    // 用户 - 角色关系定义;
    private List<SysUser> userInfos;// 一个角色对应多个用户

}
