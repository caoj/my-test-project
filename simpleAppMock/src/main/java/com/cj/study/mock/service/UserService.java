package com.cj.study.mock.service;

import com.cj.study.mock.dao.UserDao;
import com.cj.study.mock.entity.OrgInfo;
import com.cj.study.mock.entity.UserInfo;
import com.cj.study.mock.utils.ParseUtil;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserService 简介
 *
 * @author caojun44
 * @date 2024-03-04
 **/
@Service
@Setter
public class UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private UserOrgService userOrgService;

    @Value("${user.open:false}")
    private boolean open;

    public String queryUserInfo(String code) {
        return userDao.queryUserName(code);
    }

    public String[] queryAllUserName() {
        return userDao.queryAllUserName();
    }

    public OrgInfo queryUserOrgInfo(String name) {
        if(!open){
            return null;
        }
        String code = userDao.queryUserCode(name);
        return userOrgService.queryUserOrgInfo(code);
    }

    public void save(List<UserInfo> userInfos) {

        for (UserInfo userInfo : userInfos) {
            userDao.save(userInfo);
        }
    }

    private boolean saveUserInfo(UserInfo userInfo) {
        return userDao.save(userInfo);
    }

    public String queryOneLevelOrg(String code) {
        return ParseUtil.parse(code)[0];
    }
}
