package com.example.onlinerent.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class User implements UserDetails {
    private Integer id;
    private String name;
    private String phone;
    private String telephone;
    private String address;
    private String username;
    private String password;
    private String userface;
    private String remark;
    private Boolean enabled;
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserface() {
        return userface;
    }
    public void setUserface(String userface) {
        this.userface = userface;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    /**
     * 返回用户的角色或者权限
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    /**
     * 返回用户密码
     * @return
     */
    @Override
    public String getPassword() {
        return password;
    }
    /**
     * 返回用户名
     * @return
     */
    @Override
    public String getUsername() {
//        注意事项：
//        1. 返回用户状态的方法，除了 isEnabled 方法之外，其他的都是 true。
//        2. getEnabled 方法记得删除。
//        3. 属性类型统一都使用包装类型。
//        4. 记得修改 getUsername 和 getPassword 两个方法的返回值。
        return username;
    }
    /**
     * 账户是否没有过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /**
     * 账户是否没有被锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /**
     * 密码是否没有过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /**
     * 账户是否可用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
