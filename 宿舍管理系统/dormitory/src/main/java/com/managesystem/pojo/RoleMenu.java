package com.managesystem.pojo;

public class RoleMenu {
    private Integer id;

    private String userCode;

    private Integer menuId;

    public RoleMenu(Integer id, String userCode, Integer menuId) {
        this.id = id;
        this.userCode = userCode;
        this.menuId = menuId;
    }

    public RoleMenu() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}