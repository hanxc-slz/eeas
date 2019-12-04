package com.imnu.eeas.service;

import com.imnu.eeas.pojo.EnergyYear;

import java.util.List;

/**
 * @Author hxc
 * @Date 2019/11/29 18:36
 */
public interface EnergyYearService {

    // 根据ID查询
    EnergyYear findEnergyYearById(Integer id);

    // 批量查询
    List<EnergyYear> findEnergyYearsById(List<Integer> ids);

    // 新增用户每年用电总计
    Integer createNewEnergyYear(EnergyYear energyYear);

    //根据id删除
    void deleteEnergyYearById(Integer id);

    //批量删除
    void deleteEnergyYearsById(List<Integer> ids);

    //修改
    void updateEnergyYearById(EnergyYear energyYear);
}
