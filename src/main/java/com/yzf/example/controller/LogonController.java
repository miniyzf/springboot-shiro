package com.yzf.example.controller;

import com.yzf.example.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

/**
 * UserInfoController
 *
 * @author Administrator
 * @date 2020/1/6
 */
@Controller
public class LogonController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String defaultLogin() {
        return "login";
    }

//    @RequiresPermissions("index")
    @RequestMapping(value = {"/","/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/doLogin1", method = RequestMethod.POST)
    public ModelAndView login1(String username, String password, Boolean rememberMe) {
        System.out.println("-->>-->> " + password);
        ModelAndView mav = new ModelAndView("/login");
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
//            char[] password1 = token.getPassword();
//            String s = password1.toString();
            subject.login(token);
            rememberMe = rememberMe == null ? false : rememberMe;
            token.setRememberMe(rememberMe);


        } catch (UnknownAccountException uae) {
            mav.addObject("msg", "未知账户");
        } catch (IncorrectCredentialsException ice) {
            mav.addObject("msg", "密码不正确");
        } catch (LockedAccountException lae) {
            mav.addObject("msg", "账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            mav.addObject("msg", "用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            mav.addObject("msg", "用户名或密码不正确！");
        }
        if (subject.isAuthenticated()) {
            // TODO something

            mav.setViewName("/index");
            mav.addObject("msg","登陆成功>>>>>>");
        } else {
            mav.addObject("msg","登陆失败>>>>>>>");
            token.clear();
        }
        System.out.println(mav.getModel().get("msg").toString());
        System.out.println(subject.isAuthenticated());
        return mav;
    }
    @RequestMapping(value = "/doLogin2", method = RequestMethod.POST)
    public @ResponseBody String login2(String username, String password, Boolean rememberMe) {
        System.out.println("-->>-->> " + password);
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        String msg = "";
        // 执行认证登陆
        try {
//            char[] password1 = token.getPassword();
//            String s = password1.toString();
            subject.login(token);
            rememberMe = rememberMe == null ? false : rememberMe;
            token.setRememberMe(rememberMe);


            if (subject.isAuthenticated()) {
                // TODO something

                msg = "登陆成功>>>>>>";
                System.out.println(msg);
                return ResultUtil.success("",msg);
            } else {
                msg = "登陆失败>>>>>>>";
                token.clear();
            }
        } catch (UnknownAccountException uae) {
            msg = "未知账户";
        } catch (IncorrectCredentialsException ice) {
            msg = "密码不正确";
        } catch (LockedAccountException lae) {
            msg = "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            msg = "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            msg = "用户名或密码不正确！";
        }
        System.out.println(msg);
        return ResultUtil.error(msg);
    }
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String login(String username, String password, Boolean rememberMe, Model model) {
        System.out.println("-->>-->> " + password);
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        String msg = "";
        // 执行认证登陆
        try {
//            char[] password1 = token.getPassword();
//            String s = password1.toString();

            rememberMe = rememberMe == null ? false : rememberMe;
            token.setRememberMe(rememberMe);
            subject.login(token);

        } catch (AuthenticationException ae) {
            model.addAttribute("msg","用户名或密码不正确");
            token.clear();
            return "login";
        }
        return "index";
    }

    /*//退出系统(不会被调用)
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        System.out.println("退出系统");
        return "redirect:/login";
    }*/


    /**
     * 注册密码加密 同 MyShiroRealm:SimpleAuthenticationInfo、ShiroConfig:hashedCredentialsMatcher()
     * @param username
     * @param pwd
     * @return
     */
    public static String MD5Pwd(String username, String pwd, String salt) {
        // 加密算法MD5
        // salt盐 username + salt
        // 迭代次数 2
        String md5Pwd = new SimpleHash("MD5", pwd,
                ByteSource.Util.bytes(username + salt), 2).toHex();
        return md5Pwd;
    }

    public static void main(String[] args) {
        String salt = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(salt);
        String up = MD5Pwd("admin","123456",salt);
        System.out.println(up);
    }
}
