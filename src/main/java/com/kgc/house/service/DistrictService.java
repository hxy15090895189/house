package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.District;

public interface DistrictService {

    //查询区域带分页
    PageInfo<District> getDistrictByPage(Integer page,Integer pageSize);
    //添加
    public int addDistrict(District district);
    //修改
    public int updateDistrict(District district);
    //删除
    public  int deletDistrict(Integer id);
}
