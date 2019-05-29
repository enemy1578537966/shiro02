package cn.juechuang.service;

import cn.juechuang.model.User;

import java.util.Set;

public interface UserService {
    /**
     * 登陆
     */
    public User login(String username, String password);
    /**
     * 获取登录用户所有的角色名称的集合
     *
     * @param userId
     * @return
     */
    public Set<String> getUserRoleSet(Integer userId);

    /**
     * 获取登录用户所有的权限名称的集合
     *
     * @param userId
     * @return
     */
    public Set<String> getUserPermissionSet(Integer userId);
}