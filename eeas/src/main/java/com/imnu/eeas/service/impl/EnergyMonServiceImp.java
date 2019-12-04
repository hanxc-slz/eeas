package com.imnu.eeas.service.impl;

import com.imnu.eeas.dao.EnergyMonMapper;
import com.imnu.eeas.pojo.EnergyMon;
import com.imnu.eeas.pojo.exemple.EnergyMonExample;
import com.imnu.eeas.service.EnergyMonService;
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
public class EnergyMonServiceImp implements EnergyMonService {
    @Autowired
    private EnergyMonMapper energyMonMapper;

    @Override
    public EnergyMon findEnergyMonById(Integer id) {
        return energyMonMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<EnergyMon> findEnergyMonsById(List<Integer> ids) {
        EnergyMonExample energyMonExample = new EnergyMonExample();
        energyMonExample.createCriteria().andIdIn(ids);
        return energyMonMapper.selectByExample(energyMonExample);
    }

    @Override
    public Integer createNewEnergyMon(EnergyMon energyMon) {
        EnergyMon eMon = new EnergyMon();
        BeanUtils.copyProperties(energyMon, eMon);
        energyMonMapper.insertSelective(eMon);
        return eMon.getId();
    }

    @Override
    public void deleteEnergyMonById(Integer id) {
        energyMonMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteEnergyMonsById(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        EnergyMonExample energyMonExample = new EnergyMonExample();
        energyMonExample.createCriteria().andIdIn(ids);
        energyMonMapper.deleteByExample(energyMonExample);
    }

    @Override
    public void updateEnergyMonById(EnergyMon energyMon) {
        EnergyMon eMon = new EnergyMon();
        BeanUtils.copyProperties(energyMon, eMon);
        int result = energyMonMapper.updateByPrimaryKeySelective(eMon);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}
