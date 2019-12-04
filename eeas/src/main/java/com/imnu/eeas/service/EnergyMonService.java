package com.imnu.eeas.service;

import com.imnu.eeas.pojo.EnergyMon;

import java.util.List;

/**
 * @Author hxc
 * @Date 2019/11/29 18:36
 */
public interface EnergyMonService {

    // 根据ID查询
    EnergyMon findEnergyMonById(Integer id);

    // 批量查询
    List<EnergyMon> findEnergyMonsById(List<Integer> ids);

    // 新增用户
    Integer createNewEnergyMon(EnergyMon energyMon);

    //根据id删除
    void deleteEnergyMonById(Integer id);

    //批量删除
    void deleteEnergyMonsById(List<Integer> ids);

    //修改
    void updateEnergyMonById(EnergyMon energyMon);
}
