package com.imnu.eeas.service.impl;

import com.imnu.eeas.dao.EnergyYearMapper;
import com.imnu.eeas.pojo.EnergyYear;
import com.imnu.eeas.pojo.exemple.EnergyYearExample;
import com.imnu.eeas.service.EnergyYearService;
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
public class EnergyYearServiceImp implements EnergyYearService {
    @Autowired
    private EnergyYearMapper energyYearMapper;

    @Override
    public EnergyYear findEnergyYearById(Integer id) {
        return energyYearMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<EnergyYear> findEnergyYearsById(List<Integer> ids) {
        EnergyYearExample energyYearExample = new EnergyYearExample();
        energyYearExample.createCriteria().andIdIn(ids);
        return energyYearMapper.selectByExample(energyYearExample);
    }

    @Override
    public Integer createNewEnergyYear(EnergyYear energyYear) {
        EnergyYear eYear = new EnergyYear();
        BeanUtils.copyProperties(energyYear, eYear);
        energyYearMapper.insertSelective(eYear);
        return eYear.getId();
    }

    @Override
    public void deleteEnergyYearById(Integer id) {
        energyYearMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteEnergyYearsById(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        EnergyYearExample energyYearExample = new EnergyYearExample();
        energyYearExample.createCriteria().andIdIn(ids);
        energyYearMapper.deleteByExample(energyYearExample);
    }

    @Override
    public void updateEnergyYearById(EnergyYear energyYear) {
        EnergyYear eYear = new EnergyYear();
        BeanUtils.copyProperties(energyYear, eYear);
        int result = energyYearMapper.updateByPrimaryKeySelective(eYear);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}
