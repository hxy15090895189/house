package com.kgc.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.District;
import com.kgc.house.entity.DistrictExample;
import com.kgc.house.mapper.DistrictMapper;
import com.kgc.house.mapper.StreetMapper;
import com.kgc.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;
    @Override
    public PageInfo<District> getDistrictByPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        //调用dao层查询
        //定义持久化操作查询方法
        //使用selectByExample查询（带条件查询非常有用）
         DistrictExample example = new DistrictExample();
        //DistrictExample.Criteria c = example.createCriteria();
        //添加条件
        List<District> list = districtMapper.selectByExample(example);
        PageInfo<District> pageInfo = new PageInfo<District>(list);
        return pageInfo;
    }

    @Override
    public int addDistrict(District district) {
        return districtMapper.insertSelective(district);
    }

    @Override
    public int updateDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

    @Transactional
    public int deletDistrict(Integer id) {
        try {
            //删除街道（先是删除外键）
            streetMapper.deleltStreetByDid(id);
            //删除区域（后删除主键）
            districtMapper.deleteByPrimaryKey(id);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

}
