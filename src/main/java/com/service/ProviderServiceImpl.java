package com.service;

import com.mapper.ProviderMapper;
import com.pojo.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("providerService")
public class ProviderServiceImpl implements ProviderService{
    @Autowired
    @Qualifier("providerMapper")
    private ProviderMapper providerMapper;

    public void setProviderMapper(ProviderMapper providerMapper) {
        this.providerMapper = providerMapper;
    }

    public ProviderMapper getProviderMapper() {
        return providerMapper;
    }

    @Override
    public List<Provider> selectByCodeName(Provider record) {
        return providerMapper.selectByCodeName(record);
    }
}
