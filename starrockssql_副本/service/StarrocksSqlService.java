package com.lzyy.api.datacenter.modules.starrockssql.service;

import java.util.List;
import java.util.Map;

/**
 * StarRocks 查询业务接口
 */
public interface StarrocksSqlService {
    /**
     * 执行 StarRocks SQL，返回 List<Map> 形式的结果集
     *
     * @param sql StarRocks 查询语句
     * @return 查询结果
     */
    List<Map<String, Object>> query(String sql);
}
