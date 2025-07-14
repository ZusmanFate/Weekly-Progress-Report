package com.lzyy.api.datacenter.modules.sqlquery.service;

import java.util.List;
import java.util.Map;

/**
 * 通用 SQL 查询接口。
 * <p>
 * 通过传入数据源标识(dsKey)与 SQL 语句，返回查询结果。
 * 目前仅允许 SELECT 查询，请参见实现类中的校验逻辑。
 */
public interface SqlQueryService {

    /**
     * 在指定数据源上执行查询。
     *
     * @param dsKey yml 中配置的动态数据源名称，例如 "datacenter"、"starrocks"
     * @param sql   仅支持 SELECT / WITH 语句
     * @return 结果集
     */
    List<Map<String, Object>> query(String dsKey, String sql);
}
