package com.imnu.eeas.dao;

import com.imnu.eeas.pojo.Census;
import com.imnu.eeas.pojo.exemple.CensusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CensusMapper {
    int countByExample(CensusExample example);

    int deleteByExample(CensusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Census record);

    int insertSelective(Census record);

    List<Census> selectByExample(CensusExample example);

    Census selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Census record, @Param("example") CensusExample example);

    int updateByExample(@Param("record") Census record, @Param("example") CensusExample example);

    int updateByPrimaryKeySelective(Census record);

    int updateByPrimaryKey(Census record);
}
