package com.lzyy.api.datacenter.modules.starrockssql.controller;

import com.lzyy.api.datacenter.modules.starrockssql.service.StarrocksSqlService;
import com.magixbox.core.common.entity.ResultData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * StarRocks SQL 查询 Demo 控制器
 *
 * 示例：GET http://localhost:8080/datacenterservice/starrocks/query?sql=SELECT%20*%20FROM%20db.table%20LIMIT%201
 */
@RestController
@RequestMapping("/starrocks")
@RequiredArgsConstructor
public class StarrocksSqlController {

    private final StarrocksSqlService starrocksSqlService;

    /**
     * 执行 StarRocks SQL 并返回结果
     *
     * @param sql 任意合法 StarRocks 查询语句
     */
    @GetMapping("/query")
    public ResultData<List<Map<String, Object>>> query(@RequestParam("sql") String sql) {
        List<Map<String, Object>> list = starrocksSqlService.query(sql);
        return ResultData.success(list);
    }
}
