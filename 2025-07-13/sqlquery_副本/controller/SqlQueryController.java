package com.lzyy.api.datacenter.modules.sqlquery.controller;

import com.lzyy.api.datacenter.common.utils.SqlValidationUtils;
import com.lzyy.api.datacenter.modules.sqlquery.service.SqlQueryService;
import com.magixbox.core.common.entity.ResultData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 通用 SQL 查询接口控制器。
 *
 * 示例：
 *   GET /datacenterservice/query/starrocks?sql=SELECT%20*%20FROM%20db.tbl%20LIMIT%201
 *   GET /datacenterservice/query/datacenter?sql=SELECT%20column%20FROM%20db.tbl%20LIMIT%201
 */
@RestController
@RequestMapping("/query")
@RequiredArgsConstructor
public class SqlQueryController {

    private final SqlQueryService sqlQueryService;

    @GetMapping("/{dsKey}")
    public ResultData<List<Map<String, Object>>> query(
            @PathVariable String dsKey,
            @RequestParam("sql") String sql) {
        // 额外快速校验，早期失败响应
        SqlValidationUtils.validateSelectOnly(sql);
        return ResultData.success(sqlQueryService.query(dsKey, sql));
    }
}
