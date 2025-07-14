package com.lzyy.api.datacenter.modules.impalasql.controller;

import com.lzyy.api.datacenter.modules.impalasql.service.ImpalaSqlService;
import com.magixbox.core.common.entity.ResultData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Impala SQL 查询 Demo 控制器
 * 
 * 访问示例：GET http://localhost:8080/datacenterservice/impala/query?sql=SELECT%20*%20FROM%20ads.ads_erp_pur_contract_confirm_df%20LIMIT%201
 */
@RestController
@RequestMapping("/impala")
@RequiredArgsConstructor
public class ImpalaSqlController {

    private final ImpalaSqlService impalaSqlService;

    /**
     * 执行 Impala SQL 并返回结果
     *
     * @param sql 任意合法 Impala 查询语句
     */
    @GetMapping("/query")
    public ResultData<List<Map<String, Object>>> query(@RequestParam("sql") String sql) {
        List<Map<String, Object>> list = impalaSqlService.query(sql);
        return ResultData.success(list);
    }
}
