package com.imnu.eeas.dao;

import com.imnu.eeas.pojo.EnergyMon;
import com.imnu.eeas.pojo.exemple.EnergyMonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnergyMonMapper {
    int countByExample(EnergyMonExample example);

    int deleteByExample(EnergyMonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EnergyMon record);

    int insertSelective(EnergyMon record);

    List<EnergyMon> selectByExample(EnergyMonExample example);

    EnergyMon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EnergyMon record, @Param("example") EnergyMonExample example);

    int updateByExample(@Param("record") EnergyMon record, @Param("example") EnergyMonExample example);

    int updateByPrimaryKeySelective(EnergyMon record);

    int updateByPrimaryKey(EnergyMon record);
}
