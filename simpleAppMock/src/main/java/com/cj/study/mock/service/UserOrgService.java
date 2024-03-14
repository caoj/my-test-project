package com.cj.study.mock.service;

import com.cj.study.mock.entity.OrgInfo;
import com.cj.study.mock.utils.ParseUtil;
import org.springframework.stereotype.Service;

/**
 * UserOrgService 简介
 *
 * @author caojun44
 * @date 2024-03-13
 **/
@Service
public class UserOrgService {
    public OrgInfo queryUserOrgInfo(String code){
        return null;
    }

    public String[] queryOrgCodes(String allCodes){
        return ParseUtil.parse(allCodes);
    }

    private String queryLevel1OrgCode(String code){
        OrgInfo orgInfo = queryUserOrgInfo(code);
        String level1Code = orgInfo.getCode();
        if(orgInfo.getLevel() > 1){
            String[] allCodes = ParseUtil.parse(orgInfo.getAllCodes());
            level1Code = allCodes[0];
        }
        return level1Code;
    }
}
