package com.example.sqlsessiondemo.controller;
import	java.util.Map;

import com.example.sqlsessiondemo.service.OptBdShardCfgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/12/10
 */
@RestController
public class OptBdShardCfgController {

    @Autowired
    OptBdShardCfgService optBdShardCfgService;

    @GetMapping("selectByShardGrp/{shardGrp}")
    public List<Map> selectByShardGrp(@PathVariable int shardGrp){
        return optBdShardCfgService.queryBdShardCfgsLimite(shardGrp);
    }
}
