package com.managesystem.pojo;

public class Menu {
    private Integer id;

    private Integer parentid;

    private String name;

    private String icon;

    private String urlkey;

    private String url;

    private Integer status;

    private Integer type;

    private Integer sort;

    private Integer level;

    private String createTime;

    private Integer createId;

    private String officeCode;

    public Menu(Integer id, Integer parentid, String name, String icon, String urlkey, String url, Integer status, Integer type, Integer sort, Integer level, String createTime, Integer createId, String officeCode) {
        this.id = id;
        this.parentid = parentid;
        this.name = name;
        this.icon = icon;
        this.urlkey = urlkey;
        this.url = url;
        this.status = status;
        this.type = type;
        this.sort = sort;
        this.level = level;
        this.createTime = createTime;
        this.createId = createId;
        this.officeCode = officeCode;
    }

    public Menu() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getUrlkey() {
        return urlkey;
    }

    public void setUrlkey(String urlkey) {
        this.urlkey = urlkey == null ? null : urlkey.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode == null ? null : officeCode.trim();
    }
}