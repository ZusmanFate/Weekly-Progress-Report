package com.lzyy.api.datacenter.modules.impalasql.service;

import java.util.List;
import java.util.Map;

/**
 * Impala 查询业务接口
 */
public interface ImpalaSqlService {

    /**
     * 执行 Impala SQL，返回 List<Map> 形式的结果集
     *
     * @param sql Impala 查询语句
     * @return 查询结果
     */
    List<Map<String, Object>> query(String sql);
}
