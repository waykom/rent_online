package com.example.onlinerent.service;

import com.example.onlinerent.config.Constants;
import com.example.onlinerent.mapper.UserMapper;
import com.example.onlinerent.model.Residence;
import com.example.onlinerent.model.RespBean;
import com.example.onlinerent.model.RespPageBean;
import com.example.onlinerent.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    /**
     * 当前端用户登录的时候，会自动调用这个方法，这个方法就是根据用户名去查询用户对
     象。
     *
     * @param username 这个参数就是用户在浏览器上登录的时候，输入的用户名
     * @return 返回值则是根据用户名从数据库查询出来的用户对象
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        User u = userMapper.loadUserByUsername(username);
        if (u == null) {
//说明用户名不存在
            throw new UsernameNotFoundException("用户名不存在");
        }
        return u;
    }

    public RespPageBean getUserByPage(Integer page, Integer size, String name) {
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setTotal(userMapper.getTotal(name));
        respPageBean.setData(userMapper.getUserByPage((page-1)*size,size,name));
        return respPageBean;
    }

    public RespBean addUser(User user) {
        String username = user.getUsername();
        User userByUserName = userMapper.getUserByUserName(username);
        System.out.println(userByUserName);
        if (userByUserName == null) {
            user.setEnabled(Constants.ENABLED);
            int result = userMapper.addUser(user);
            return result == 1 ? RespBean.ok("添加成功") : RespBean.error("添加失败");
        } else {
            return RespBean.error("用户已存在，添加失败");
        }
    }

    public RespBean deleteUserById(Integer id) {
        User u = userMapper.getUserById(id);
        if (u == null) {
            //说明这个小区已经被删除了
            return RespBean.error("用户不存在，删除失败");
        }
        int result = userMapper.deleteUserById(id);
        return result == 1 ? RespBean.ok("删除成功") : RespBean.error("删除失败");
    }

    public RespBean updateUser(User user) {
        int result = userMapper.updateUser(user);
        return result==1?RespBean.ok("更新成功"):RespBean.error("更新失败");
    }
}
