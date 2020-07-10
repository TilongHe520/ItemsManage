package com.service;

import com.pojo.Items;
import com.pojo.PageBean;

import java.util.List;

public interface PageService {
    List<Items> queryAllItems();
    int selectCount();
    PageBean<Items> findByPage(int currentPage);

}
