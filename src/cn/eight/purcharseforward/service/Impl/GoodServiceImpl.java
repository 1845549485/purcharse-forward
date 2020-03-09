package cn.eight.purcharseforward.service.Impl;

import cn.eight.purcharseforward.dao.GoodDao;
import cn.eight.purcharseforward.pojo.Good;
import cn.eight.purcharseforward.service.GoodService;

import java.util.List;

public class GoodServiceImpl implements GoodService {
    private GoodDao goodDao=new GoodDao();
    @Override
    public boolean addGood(Good good) {
        return goodDao.insertGood(good);
    }

    @Override
    public List<Good> findGoodByCriteria(Good good) {
        return goodDao.queryGoodByCriteria(good);
    }

    @Override
    public List<Good> findGoodAll(int pageNow, int pageSize) {
        return goodDao.queryGoodAll(pageNow, pageSize);
    }

    @Override
    public int findTotalRecord() {
        return goodDao.queryTotalRecord();
    }

    @Override
    public boolean modifyGood(Good good) {
        return goodDao.updateGood(good);
    }

    @Override
    public boolean removeGood(int id) {
        return goodDao.deleteGood(id);
    }
}
