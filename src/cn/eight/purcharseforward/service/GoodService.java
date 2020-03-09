package cn.eight.purcharseforward.service;

import cn.eight.purcharseforward.pojo.Good;

import java.util.List;

public interface GoodService {
    boolean addGood(Good good);
    //查询方法返回的是一个集合
    List<Good> findGoodByCriteria(Good good);
    //不带good，因为该查询不带条件
    List<Good> findGoodAll(int pageNow,int pageSize);
    int findTotalRecord();
    boolean modifyGood(Good good);
    boolean removeGood(int id);
}
