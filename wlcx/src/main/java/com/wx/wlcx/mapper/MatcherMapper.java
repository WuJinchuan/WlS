package com.wx.wlcx.mapper;

import com.wx.wlcx.po.CMMatcher;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatcherMapper {

    @Select("select * from CM_Matcher")
    @Results({
                @Result(property = "coid", column = "COID"),
                @Result(property = "crIdx", column = "CR_Idx"),
                @Result(property = "crMode", column = "CR_Mode"),
            @Result(property = "ctMode", column = "CT_Mode"),
            @Result(property = "crFate", column = "CR_Fate"),
            @Result(property = "rgCode", column = "RG_Code"),
            @Result(property = "rgName", column = "RG_Name"),
            @Result(property = "arCode", column = "AR_Code"),
            @Result(property = "arName", column = "AR_Name"),
            @Result(property = "cmCode", column = "CM_Code"),
            @Result(property = "cmName", column = "CM_Name"),
            @Result(property = "crAddr", column = "CR_Addr"),
            @Result(property = "crStyle", column = "CR_Style"),
            @Result(property = "crGrade", column = "CR_Grade")
            })
    List<CMMatcher> getAll();
}
