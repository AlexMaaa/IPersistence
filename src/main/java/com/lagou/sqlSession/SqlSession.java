package com.lagou.sqlSession;

import java.util.List;

public interface SqlSession {

    //查询所有
    public <E> List<E> selectList(String statementid,Object... params) throws Exception;

    //根据条件查询单个
    public <T> T selectOne(String statementid,Object... params) throws Exception;

    Integer update(String statementid,Object... params) throws Exception;

    Integer insert(String statementid,Object... params) throws Exception;

    Integer delete(String statementid,Object... params) throws Exception;

    //为Dao接口生成代理实现类
    public <T> T getMapper(Class<?> mapperClass);


    <T> T getMapperUpdate(Class<?> mapperClass);

    <T> T getMapperInsert(Class<?> mapperClass);

    <T> T getMapperDelete(Class<?> mapperClass);
}
