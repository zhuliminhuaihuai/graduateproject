package com.managesystem.service.Impl;

import com.google.common.collect.Lists;
import com.managesystem.common.Const;
import com.managesystem.common.ServerResponse;
import com.managesystem.dao.MenuMapper;
import com.managesystem.dao.RoleMenuMapper;
import com.managesystem.pojo.Menu;
import com.managesystem.pojo.User;
import com.managesystem.service.IMenuService;
import com.managesystem.vo.MenuVo;
import com.managesystem.vo.PermissionsChildrenMenuVo;
import com.managesystem.vo.PermissionsMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {


    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;


    //根据不同的角色显示不同的左测功能菜单
    public ServerResponse<List<MenuVo>> getMenuList(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        int role = user.getUserRole();
        if(role==1){
            List<Menu> motherMenuList = menuMapper.getMotherMenuList();
            List<Menu> childrenMenuList = menuMapper.getChildenMenuList();
            List<MenuVo> menuVoList = Lists.newArrayList();
            for (int i = 0; i < motherMenuList.size(); i++) {
                MenuVo menuVo = new MenuVo();//一个完整的菜单栏
                Menu motherMenu = motherMenuList.get(i);
                List<MenuVo> motherTOChildrenMenuList = Lists.newArrayList();//该母菜单下的子菜单集合
                menuVo.setTitle(motherMenu.getName());
                menuVo.setIcon(motherMenu.getIcon());
                menuVo.setHref(motherMenu.getUrl());
                menuVo.setSpread(false);
                for (int j = 0; j < childrenMenuList.size(); j++) {
                    if (childrenMenuList.get(j).getParentid().equals(motherMenu.getId())) {
                        MenuVo childrenMenuVo = new MenuVo();//子菜单的vo
                        Menu childrenMenu = childrenMenuList.get(j);
                        childrenMenuVo.setTitle(childrenMenu.getName());
                        childrenMenuVo.setIcon(childrenMenu.getIcon());
                        childrenMenuVo.setHref(childrenMenu.getUrl());
                        childrenMenuVo.setSpread(false);
                        motherTOChildrenMenuList.add(childrenMenuVo);
                    }
                }
                menuVo.setChildren(motherTOChildrenMenuList);
                menuVoList.add(menuVo);
            }
            return ServerResponse.createBySuccess("成功找到菜单！", menuVoList);
        }else {
            String userCode = user.getUserCode();
            List<Integer> menuIDList = roleMenuMapper.getMenuIdList(userCode);
            List<MenuVo> menuVoList = Lists.newArrayList();
            if(menuIDList.size()>0){
                List<Menu> motherMenuList = menuMapper.getMotherMenuListByIdList(menuIDList);
                List<Menu> childrenMenuList = menuMapper.getChildenMenuListByIdList(menuIDList);
                for (int i = 0; i < motherMenuList.size(); i++) {
                    MenuVo menuVo = new MenuVo();//一个完整的菜单栏
                    Menu motherMenu = motherMenuList.get(i);
                    List<MenuVo> motherTOChildrenMenuList = Lists.newArrayList();//该母菜单下的子菜单集合
                    menuVo.setTitle(motherMenu.getName());
                    menuVo.setIcon(motherMenu.getIcon());
                    menuVo.setHref(motherMenu.getUrl());
                    menuVo.setSpread(false);
                    for (int j = 0; j < childrenMenuList.size(); j++) {
                        if (childrenMenuList.get(j).getParentid().equals(motherMenu.getId())) {
                            MenuVo childrenMenuVo = new MenuVo();//子菜单的vo
                            Menu childrenMenu = childrenMenuList.get(j);
                            childrenMenuVo.setTitle(childrenMenu.getName());
                            childrenMenuVo.setIcon(childrenMenu.getIcon());
                            childrenMenuVo.setHref(childrenMenu.getUrl());
                            childrenMenuVo.setSpread(false);
                            motherTOChildrenMenuList.add(childrenMenuVo);
                        }
                    }
                    menuVo.setChildren(motherTOChildrenMenuList);
                    menuVoList.add(menuVo);
                }
                return ServerResponse.createBySuccess("成功找到菜单！", menuVoList);
            }
            return ServerResponse.createBySuccess(menuVoList);
        }
    }

    //设置用户权限的菜单栏
    public List<PermissionsMenuVo> getPermissionsMenuList() {

        List<Menu> motherMenuList = menuMapper.getMotherMenuList();
        List<Menu> childrenMenuList = menuMapper.getChildenMenuList();
        List<PermissionsMenuVo> permissionsMenuVoList = Lists.newArrayList();
        for (int i = 0; i < motherMenuList.size(); i++) {
            PermissionsMenuVo permissionsMenuVo = new PermissionsMenuVo();//一个完整的菜单栏
            Menu motherMenu = motherMenuList.get(i);
            List<PermissionsChildrenMenuVo> permissionsChildrenMenuVoList = Lists.newArrayList();//该母菜单下的子菜单集合
            permissionsMenuVo.setValue(motherMenu.getId().toString());
            permissionsMenuVo.setTitle(motherMenu.getName());
            permissionsMenuVo.setChecked(false);
            permissionsMenuVo.setDisabled(false);
            for (int j = 0; j < childrenMenuList.size(); j++) {
                if (childrenMenuList.get(j).getParentid().equals(motherMenu.getId())) {
                    PermissionsChildrenMenuVo permissionsChildrenMenuVo = new PermissionsChildrenMenuVo();//子菜单的vo
                    Menu childrenMenu = childrenMenuList.get(j);
                    permissionsChildrenMenuVo.setValue(childrenMenu.getId().toString());
                    permissionsChildrenMenuVo.setTitle(childrenMenu.getName());
                    permissionsChildrenMenuVo.setChecked(false);
                    permissionsChildrenMenuVo.setDisabled(false);
                    permissionsChildrenMenuVo.setData(Lists.<PermissionsChildrenMenuVo>newArrayList());
                    permissionsChildrenMenuVoList.add(permissionsChildrenMenuVo);
                }
            }
            permissionsMenuVo.setData(permissionsChildrenMenuVoList);
            permissionsMenuVoList.add(permissionsMenuVo);
        }
        return permissionsMenuVoList;

    }

    //取出该用户获得的权限菜单列表
    public List<PermissionsMenuVo> getUserHavePermissionsList(String userCode) {

        List<Integer> menuIDList = roleMenuMapper.getMenuIdList(userCode);
        List<Menu> motherMenuList = menuMapper.getMotherMenuList();
        List<Menu> childrenMenuList = menuMapper.getChildenMenuList();
        List<PermissionsMenuVo> permissionsMenuVoList = Lists.newArrayList();
        for (int i = 0; i < motherMenuList.size(); i++) {
            PermissionsMenuVo permissionsMenuVo = new PermissionsMenuVo();//一个完整的菜单栏
            Menu motherMenu = motherMenuList.get(i);
            List<PermissionsChildrenMenuVo> permissionsChildrenMenuVoList = Lists.newArrayList();//该母菜单下的子菜单集合
            permissionsMenuVo.setValue(motherMenu.getId().toString());
            permissionsMenuVo.setTitle(motherMenu.getName());
            for (Integer id:menuIDList) {
                if (id.equals(motherMenu.getId())) {
                    permissionsMenuVo.setChecked(true);
                }
            }
            permissionsMenuVo.setDisabled(false);
            for (int j = 0; j < childrenMenuList.size(); j++) {
                if (childrenMenuList.get(j).getParentid().equals(motherMenu.getId())) {
                    permissionsMenuVo.setChecked(true);
                    PermissionsChildrenMenuVo permissionsChildrenMenuVo = new PermissionsChildrenMenuVo();//子菜单的vo
                    Menu childrenMenu = childrenMenuList.get(j);
                    permissionsChildrenMenuVo.setValue(childrenMenu.getId().toString());
                    permissionsChildrenMenuVo.setTitle(childrenMenu.getName());
                    for (Integer id:menuIDList) {
                        if (id.equals(childrenMenu.getId())) {
                            permissionsChildrenMenuVo.setChecked(true);
                        }
                    }
                    permissionsChildrenMenuVo.setDisabled(false);
                    permissionsChildrenMenuVo.setData(Lists.<PermissionsChildrenMenuVo>newArrayList());
                    permissionsChildrenMenuVoList.add(permissionsChildrenMenuVo);
                }
            }
            permissionsMenuVo.setData(permissionsChildrenMenuVoList);
            permissionsMenuVoList.add(permissionsMenuVo);
        }
        return permissionsMenuVoList;
    }


}
