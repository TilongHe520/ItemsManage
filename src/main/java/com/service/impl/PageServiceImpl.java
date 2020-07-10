package com.service.impl;

import com.dao.PageDao;
import com.pojo.Items;
import com.pojo.PageBean;
import com.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageDao pageDao;
    @Override
    public List<Items> queryAllItems() {
        return pageDao.queryAllItems();
    }

    @Override
    public int selectCount() {
        return pageDao.selectCount();
    }

    @Override
    public PageBean<Items> findByPage(int currentPage) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Items> pageBean = new PageBean<Items>();

        pageBean.setCurrentPage(currentPage);

        int pageSize=5;
        pageBean.setPageSize(pageSize);

        int totalCount =pageDao.selectCount();
        pageBean.setTotalCount(totalCount);

        double tc = totalCount;
        Double num = Math.ceil(tc/pageSize);
        pageBean.setTotalpage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size",pageBean.getPageSize());

        List<Items> lists =pageDao.findByPage(map);
        pageBean.setLists(lists);
        return pageBean;
    }
}
