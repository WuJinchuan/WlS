package com.wx.wlcx.mapper;

import com.wx.wlcx.model.CMCompany;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CMCompanyMapper {
    int deleteByPrimaryKey(@Param("cpid") String cpid, String coid);

    int insert(CMCompany record);

    int insertSelective(CMCompany record);

    CMCompany selectByPrimaryKey(@Param("cpid") String cpid, @Param("coId") String coid);

    int updateByPrimaryKeySelective(@Param("cpid") String cpid, @Param("record")  CMCompany record);

    int updateByPrimaryKey(@Param("cpid") String cpid, @Param("record") CMCompany record);

    List<CMCompany> findCompany(@Param("cpid") String cpid, @Param("keyword") String keyword, @Param("arCode") String arCode, @Param("arName") String arName);

    CMCompany findCompanyDetail(@Param("cpid") String cpid, @Param("coId") String coId);
}