package com.managesystem.pojo;

public class Role {
    private Integer id;

    private String name;

    private Integer status;

    private Integer sort;

    private String createTime;

    private Integer createId;

    private Integer isadmin;

    private String parentid;

    private Integer roletype;

    private String usercode;

    private String remark;

    public Role(Integer id, String name, Integer status, Integer sort, String createTime, Integer createId, Integer isadmin, String parentid, Integer roletype, String usercode, String remark) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.sort = sort;
        this.createTime = createTime;
        this.createId = createId;
        this.isadmin = isadmin;
        this.parentid = parentid;
        this.roletype = roletype;
        this.usercode = usercode;
        this.remark = remark;
    }

    public Role() {
        super();
    }

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public Integer getRoletype() {
        return roletype;
    }

    public void setRoletype(Integer roletype) {
        this.roletype = roletype;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}