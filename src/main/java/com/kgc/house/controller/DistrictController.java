package com.kgc.house.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.District;
import com.kgc.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("/getDistrict")
    @ResponseBody
    public Map<String,Object> getDistrict(Integer page, Integer rows){
         //调用业务
        PageInfo<District> pageInfo = districtService.getDistrictByPage(page, rows);
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    @RequestMapping("/addDistrict")
    @ResponseBody
    public String addDistrict(District district){
        int temp = districtService.addDistrict(district);
        return "{\"result\":"+temp+"}";
    }
    @RequestMapping("/upDistrict")
    @ResponseBody
    public String updateDistrict(District district){
        int temp=districtService.updateDistrict(district);
        return "{\"w\":"+temp+"}";
    }
    @RequestMapping("/deletDistrict")
    @ResponseBody
    public String deletDistrict(Integer id){
        int temp= districtService.deletDistrict(id);
        return "{\"w\":"+temp+"}";
    }
}
