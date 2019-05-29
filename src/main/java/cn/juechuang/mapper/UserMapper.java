package cn.juechuang.mapper;

import cn.juechuang.model.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.Set;

public interface UserMapper extends Mapper<User> {
    /**
     * 获取登录用户所有的角色名称的集合
     */
    public Set<String> getUserRoleSet(Integer userId);

    /**
     * 获取登录用户所有的权限名称的集合
     */
    public Set<String> getUserPermissionSet(Integer userId);

}