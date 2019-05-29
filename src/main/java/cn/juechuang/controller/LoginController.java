package cn.juechuang.controller;

import cn.juechuang.util.MD5Util;
import cn.juechuang.util.ResultMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String index1 () {
        return "login";
    }


    @PostMapping("/login")
    @ResponseBody
    public ResultMap login(String username,String password){
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //密文
        password= MD5Util.md5(password, "juechuang");
        //令牌验证
        UsernamePasswordToken token=new UsernamePasswordToken(username, password);
        subject.login(token);
        return ResultMap.ok("");
    }

    /**
     * 跳转到index页面
     */
    @GetMapping("index")
    public String index(){
        return "index";
    }
    /**
     * 登出
     */
    @GetMapping("/loginout")
    public String loginout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }
}
