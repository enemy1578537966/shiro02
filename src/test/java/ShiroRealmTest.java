import cn.juechuang.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class ShiroRealmTest {
    //注入安全管理器
    @Autowired
    SecurityManager securityManager;

    @Test
    public void realmDemo(){
        //设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        String username="admin";
        String password="123456";
        //令牌
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //登陆
        subject.login(token);
        //查看权限
        System.out.println(subject.hasRole("系统管理员"));
        System.out.println(subject.isPermitted("sys:user"));
        //登出
        subject.logout();
    }
}