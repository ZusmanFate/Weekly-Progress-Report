package com.lzyy.api.datacenter.modules.starrockssql.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.lzyy.api.datacenter.modules.starrockssql.service.StarrocksSqlService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.lzyy.api.datacenter.common.utils.SqlValidationUtils;

/**
 * StarRocks 查询实现。
 *
 * 使用动态数据源注解，复用 yml 中定义的 "starrocks" 数据源。
 */
@Service
@DS("starrocks")
@RequiredArgsConstructor
public class StarrocksSqlServiceImpl implements StarrocksSqlService {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> query(String sql) {
        // 白名单校验：仅允许 SELECT 查询
        SqlValidationUtils.validateSelectOnly(sql);
        return jdbcTemplate.queryForList(sql);
    }
}
