package com.example.sqlsessiondemo.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/12/10
 */
@Service
public class OptBdShardCfgService {

    @Autowired
    SqlSessionFactory factory;

    public List<Map> queryBdShardCfgsLimite(int shardGrp) {
        //xml文件中的namespace+语句对应的ID
        String sqlid="com.example.sqlsessiondemo.dao.OptBdShardCfgMapper.selectByShardGrp";
        SqlSession session=factory.openSession();
        List<Map> list=session.selectList(sqlid, shardGrp);
        return list;
    }

}
