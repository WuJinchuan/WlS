package com.wx.wlcx.controller;

import com.wx.wlcx.model.CMCompany;
import com.wx.wlcx.resource.CompaniesListResource;
import com.wx.wlcx.resource.CompanyResource;
import com.wx.wlcx.service.CompanyService;
import com.wx.wlcx.utils.JsonResult;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("查询公司信息")//用来说明当前 controller 的作用
public class CompanyManagerController {
    private final static Logger logger = LoggerFactory.getLogger(CompanyManagerController.class);
    @Autowired
    private CompanyService companyService;


    @GetMapping("/search/{pageNum}/{pageSize}/company")
    //api 具体描述
    @ApiOperation(value = "根据关键字或者区域查询多个公司", notes = "pageSize 为零时查询所有", tags = {"公司查询"}, httpMethod = "GET")
    //参数描述
    //@ApiImplicitParam(value = "pageNum", defaultValue = "不能为空", required = true)
    //多个参数时
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "pageNum", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "pageSize", value = "页面大小", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "keyword", value = "公司名称关键字", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "arCode", value = "区域编号", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "arName", value = "区域名字", dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 404, message = "page not found")
    })
    public ResponseEntity<JsonResult> findCompany(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
                                                  @RequestParam(value = "keyword", required = false) String keyword,
                                                  @RequestParam(value = "arCode", required = false) String arCode,
                                                  @RequestParam(value = "arName", required = false)  String arName){
    logger.info(String.format("get one page company, pageSize: %d, page: %d", pageNum, pageSize));
        JsonResult r = new JsonResult();
        try {
            verifyParames(keyword, arCode, arName);
            List<CMCompany> cmCompanies = companyService.findCompany(pageNum, pageSize, keyword, arCode, arName);
            r.setResult(new CompaniesListResource(cmCompanies));
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    private void verifyParames(String keyword, String arCode, String arName) throws Exception {
        if (StringUtils.isEmpty(keyword) && StringUtils.isEmpty(arCode) && StringUtils.isEmpty(arName)) {
            logger.error("keyword, arCode and arName is all null!!!");
            throw new Exception("params error!!");
        }
    }

    @GetMapping("/company/detail")
    //api 具体描述
    @ApiOperation(value = "根据id查询公司具体信息", notes = "查询公司所有信息及送货地址", tags = {"公司查询"}, httpMethod = "GET")
    //参数描述
    @ApiImplicitParam(value = "coid", defaultValue = "不能为空", required = true)
    @ApiResponses({
            @ApiResponse(code = 404, message = "page not found"),
            @ApiResponse(code = 400, message = "内部参数异常")
    })
    public ResponseEntity<JsonResult> findCompanyDetail(@RequestParam(value = "coid") String coid){
        logger.info("findCompanyDetail");
        JsonResult r = new JsonResult();
        try {
            CMCompany cmCompany = companyService.findCompany(coid);
            r.setResult(new CompanyResource(cmCompany));
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
