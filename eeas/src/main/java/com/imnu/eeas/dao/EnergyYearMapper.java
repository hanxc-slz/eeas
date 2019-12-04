package com.imnu.eeas.dao;

import com.imnu.eeas.pojo.EnergyYear;
import com.imnu.eeas.pojo.exemple.EnergyYearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnergyYearMapper {
    int countByExample(EnergyYearExample example);

    int deleteByExample(EnergyYearExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EnergyYear record);

    int insertSelective(EnergyYear record);

    List<EnergyYear> selectByExample(EnergyYearExample example);

    EnergyYear selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EnergyYear record, @Param("example") EnergyYearExample example);

    int updateByExample(@Param("record") EnergyYear record, @Param("example") EnergyYearExample example);

    int updateByPrimaryKeySelective(EnergyYear record);

    int updateByPrimaryKey(EnergyYear record);
}
