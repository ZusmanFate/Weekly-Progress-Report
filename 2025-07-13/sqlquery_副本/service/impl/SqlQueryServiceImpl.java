package com.lzyy.api.datacenter.modules.sqlquery.service.impl;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.lzyy.api.datacenter.common.utils.SqlValidationUtils;
import com.lzyy.api.datacenter.modules.sqlquery.service.SqlQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通用 SQL 查询实现。
 * <p>
 * 通过动态数据源上下文切换到指定数据源，然后执行查询。仅允许 SELECT 语句。
 */
@Service
@RequiredArgsConstructor
public class SqlQueryServiceImpl implements SqlQueryService {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> query(String dsKey, String sql) {
        // 校验 SQL
        SqlValidationUtils.validateSelectOnly(sql);

        // 切换数据源
        DynamicDataSourceContextHolder.push(dsKey);
        try {
            return jdbcTemplate.queryForList(sql);
        } finally {
            DynamicDataSourceContextHolder.clear();
        }
    }
}
