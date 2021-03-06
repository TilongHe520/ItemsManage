package com.service.impl;

import com.dao.ItemsDao;
import com.pojo.Items;
import com.pojo.PageBean;
import com.service.ItemsService;
import com.util.ExcelUtils;
import com.util.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ItemsServiceImpl implements ItemsService {

    private static final Logger logger = LoggerFactory.getLogger(ItemsServiceImpl.class);

    @Autowired
    private ItemsDao itemsDao;

    @Override
    public List<Items> findAllItems() {

        return itemsDao.findAllItems();
    }

    @Override
    public int save(Items items) {

        return itemsDao.insert(items);
    }

    @Override
    public int update(Items items) {

        return itemsDao.update(items);
    }

    @Override
    public int delete(Integer id) {
        return itemsDao.delete(id);
    }

    @Override
    public Items findById(Integer id) {
        return itemsDao.findById(id);
    }

    @Override
    public int selectCount() {
        return itemsDao.selectCount();
    }

    @Override
    public PageBean<Items> findByPage(int currentPage) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Items> pageBean = new PageBean<Items>();

        pageBean.setCurrentPage(currentPage);

        int pageSize=5;
        pageBean.setPageSize(pageSize);

        int totalCount =itemsDao.selectCount();
        pageBean.setTotalCount(totalCount);

        double tc = totalCount;
        Double num = Math.ceil(tc/pageSize);
        pageBean.setTotalpage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size",pageBean.getPageSize());

        List<Items> lists =itemsDao.findByPage(map);
        pageBean.setLists(lists);
        return pageBean;
    }

    @Override
    public File exportItems() {
        List<Items> itemsList = itemsDao.findAllItems();
        try {
            File file = ExcelUtils.exportExcel(itemsList, RequestUtils.getRequest().getSession().getServletContext().getRealPath(File.separator) +
                            UUID.randomUUID().toString() + ".xls",
                    new String[]{"id", "名称", "价格", "描述", "图片","创建时间","总量","余量"}, "updateTime");
            return file;
        } catch (IOException e) {
            logger.error(e.getMessage(),e.toString());
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(),e.toString());
        }
        return null;
    }
}
