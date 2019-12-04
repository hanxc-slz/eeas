package com.imnu.eeas.service.impl;

import com.imnu.eeas.dao.CensusMapper;
import com.imnu.eeas.pojo.Census;
import com.imnu.eeas.pojo.exemple.CensusExample;
import com.imnu.eeas.service.CensusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author hxc
 * @Date 2019/11/29 18:37
 */
@Service
public class CensusServiceImp implements CensusService {
    @Autowired
    private CensusMapper censusMapper;

    @Override
    public Census findCensusById(Integer id) {
        return censusMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Census> findCensussById(List<Integer> ids) {
        CensusExample censusExample = new CensusExample();
        censusExample.createCriteria().andIdIn(ids);
        return censusMapper.selectByExample(censusExample);
    }

    @Override
    public Integer createNewCensus(Census census) {
        Census cen = new Census();
        BeanUtils.copyProperties(census, cen);
        censusMapper.insertSelective(cen);
        return cen.getId();
    }

    @Override
    public void deleteCensusById(Integer id) {
        censusMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteCensussById(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        CensusExample censusExample = new CensusExample();
        censusExample.createCriteria().andIdIn(ids);
        censusMapper.deleteByExample(censusExample);
    }

    @Override
    public void updateCensusById(Census census) {
        Census cen = new Census();
        BeanUtils.copyProperties(census, cen);
        int result = censusMapper.updateByPrimaryKeySelective(cen);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}
