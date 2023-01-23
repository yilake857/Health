package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.pojo.Setmeal;

import java.util.List;
import java.util.Map;

public interface SetmealService {
    public void add(Setmeal setmeal, Integer[] checkgroupIds);

    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);
    public List<Setmeal> findAll();
    public Setmeal findById(int id);
    public void delete(Integer id);
    public List<Map<String,Object>> findSetmealCount();
}
