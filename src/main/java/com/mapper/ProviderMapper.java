package com.mapper;

import com.pojo.Provider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Provider record);

    int insertSelective(Provider record);

    Provider selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Provider record);

    int updateBySelective(Provider record);


    int updateByPrimaryKey(Provider record);


    List<Provider> selectByCodeName(Provider record);
}