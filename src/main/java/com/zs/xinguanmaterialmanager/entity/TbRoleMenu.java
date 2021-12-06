package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;

/**
 * 角色菜单关联表(TbRoleMenu)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:44
 */
public class TbRoleMenu implements Serializable {
    private static final long serialVersionUID = 212087723275217163L;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单/按钮ID
     */
    private Long menuId;

    private Integer id;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

