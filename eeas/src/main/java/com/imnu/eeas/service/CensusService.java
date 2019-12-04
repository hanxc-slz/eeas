package com.imnu.eeas.service;

import com.imnu.eeas.pojo.Census;

import java.util.List;

/**
 * @Author hxc
 * @Date 2019/11/29 18:35
 */
public interface CensusService {

    // 根据ID查询
    Census findCensusById(Integer id);

    // 批量查询
    List<Census> findCensussById(List<Integer> ids);

    // 新增用户
    Integer createNewCensus(Census census);

    //根据id删除
    void deleteCensusById(Integer id);

    //批量删除
    void deleteCensussById(List<Integer> ids);

    //修改
    void updateCensusById(Census census);
}
