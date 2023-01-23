package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;

@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImp implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;

    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();

        PageHelper.startPage(currentPage,pageSize);
        Page<CheckItem> checkItems = checkItemDao.selectByCondition(queryString);
        long total = checkItems.getTotal();
        List<CheckItem> result = checkItems.getResult();

        return new PageResult(total,checkItems);
    }

    public void deleteById(Integer id) {
        long countByCheckItemId = checkItemDao.findCountByCheckItemId(id);
        if(countByCheckItemId > 0){
            new RuntimeException();
        }
        checkItemDao.deleteById(id);
    }

    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }

    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }

    @Override
    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }
}
