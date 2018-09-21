package com.pear.controller;

import com.pear.model.ListSample;
import com.pear.service.DataService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private DataService dataService;
    /**
     * 以下函数的注释,不增加注解了,将在下面统一做描述
     */


    @ApiOperation(value = "登陆",notes="登陆")
    @ApiImplicitParam(dataType = "String",name = "username",value = "用户信息",required = true)
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> login(@RequestBody String username){
        ApiResponse result = new ApiResponse();
        result.setCode(1);
        result.setData(new HashMap<String,Object>(){
            {put("token",username);}
        });
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "注销",notes="注销")
    @RequestMapping(value = "/user/logout",method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> logout(){
        ApiResponse result = new ApiResponse();
        result.setCode(1);
        result.setData(new HashMap<String,Object>(){
            {put("token","1212");}
        });
        return ResponseEntity.ok(result);
    }


    @ApiOperation(value = "获取token",notes="注意事项")
    @ApiImplicitParam(name = "token",value = "用户id",dataType = "String",paramType = "path")
    @RequestMapping(value = "/user/info/{token}",method = RequestMethod.OPTIONS)
    public String testGet(@PathVariable String token){
        return token;
    }

    @ApiOperation(value = "获取token2",notes="注意事项2")
    @RequestMapping(value = "/user/info",method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getUserInfo(
            @ApiParam(required = false, name = "token", value = "名称模糊查询") String token){
        ApiResponse result = new ApiResponse();
        result.setCode(1);
        result.setData(new HashMap<String,Object>(){
            {put("token",token);}
            {put("name","Tester1");}
            {put("avatar","https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_86d58ae1.png");}
            {put("token",token);}
            {put("roles",new String[] {
                    "Admin","Sam","Mimi"
            });
            }
        });
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "table 列表",notes="注意事项2")
    @RequestMapping(value = "/table/list",method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getTable(
            @ApiParam(required = false, name = "token", value = "名称模糊查询") String token){
        ApiResponse result = new ApiResponse();
        result.setCode(1);
        List<ListSample> list = dataService.getListSample();
        result.setData(new HashMap<String,Object>(){
            {put("items",list);}
        });
//        result.setData(new HashMap<String,Object>(){
//            {put("items",Arrays.asList(
//                    new ListSample(0L,"sdf","sdf","published",24323,"2018-12-12"),
//                    new ListSample(1L,"论资本","Acker","draft",12,"2018-01-12"),
//                    new ListSample(2L,"illy Cafe","Lebron","deleted",2,"2018-02-12")));}
//        });
        return ResponseEntity.ok(result);
    }


    @ApiIgnore
    public String testIgnore(){
        return "success";
    }
}
