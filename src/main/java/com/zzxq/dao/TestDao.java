package com.zzxq.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDao {

    public void insert(String cno, String cname);
}
