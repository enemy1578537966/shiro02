package cn.juechuang.service.impl;

import cn.juechuang.mapper.UserMapper;
import cn.juechuang.model.User;
import cn.juechuang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserMapper mapper;


    public User login(String username, String password) {
        User param = new User();
        param.setUsername(username);
        param.setPassword(password);

        User user = mapper.selectOne(param);
        return user;
    }

    /**
     * 获取登录用户所有的角色名称的集合
     *
     * @param userId
     * @return
     */

    public Set<String> getUserRoleSet(Integer userId) {
        return mapper.getUserRoleSet(userId);
    }
    /**
     * 获取登录用户所有的权限名称的集合
     * @param userId
     * @return
     */

    public Set<String> getUserPermissionSet(Integer userId) {
        return mapper.getUserPermissionSet(userId);
    }
}