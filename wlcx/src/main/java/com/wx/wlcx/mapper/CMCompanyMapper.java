package com.wx.wlcx.mapper;

import com.wx.wlcx.model.CMCompany;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CMCompanyMapper {
    int deleteByPrimaryKey(String coid);

    int insert(CMCompany record);

    int insertSelective(CMCompany record);

    CMCompany selectByPrimaryKey(String coid);

    int updateByPrimaryKeySelective(CMCompany record);

    int updateByPrimaryKey(CMCompany record);

    List<CMCompany> findCompany(@Param("keyword") String keyword, @Param("arName") String arName, @Param("arCode") String arCode);

    CMCompany findCompanyDetail(String coId);
}