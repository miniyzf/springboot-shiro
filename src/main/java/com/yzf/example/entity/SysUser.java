package com.yzf.example.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * SysUser
 *
 * @author Administrator
 * @date 2020/1/6
 */
@Data
public class SysUser implements Serializable {
    private Integer uid;
    private String username;//帐号
    private String name;//名称（昵称或者真实姓名，不同系统不同定义）
    private String password; //密码;
    private String salt;//加密密码的盐
    private Byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.

    private List<SysRole> roleList;// 一个用户具有多个角色

    @Override
    public String toString() {
        return "{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", roleList=" + roleList +
                '}';
    }
}
