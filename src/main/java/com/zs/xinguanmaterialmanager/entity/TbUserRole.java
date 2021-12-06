package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;

/**
 * 用户角色关联表(TbUserRole)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:47
 */
public class TbUserRole implements Serializable {
    private static final long serialVersionUID = -62904669582062368L;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 角色ID
     */
    private Long roleId;

    private Integer id;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

