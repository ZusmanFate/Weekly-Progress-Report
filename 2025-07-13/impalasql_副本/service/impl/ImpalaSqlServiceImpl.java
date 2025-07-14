package com.lzyy.api.datacenter.modules.impalasql.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.lzyy.api.datacenter.modules.impalasql.service.ImpalaSqlService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.lzyy.api.datacenter.common.utils.SqlValidationUtils;

/**
 * Impala 查询实现。
 *
 * 使用动态数据源注解，直接复用 yml 中定义的 "datacenter" 数据源。
 */
@Service
@DS("datacenter")
@RequiredArgsConstructor
public class ImpalaSqlServiceImpl implements ImpalaSqlService {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> query(String sql) {
        SqlValidationUtils.validateSelectOnly(sql);
        return jdbcTemplate.queryForList(sql);
    }
}
