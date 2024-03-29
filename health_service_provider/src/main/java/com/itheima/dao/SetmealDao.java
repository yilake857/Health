package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.Setmeal;

import java.util.List;
import java.util.Map;

public interface SetmealDao {
    public void add(Setmeal setmeal);
    public void setSetmealAndCheckGroup(Map<String, Integer> map);
    public Page<Setmeal> selectByCondition(String queryString);
    public List<Setmeal> findAll();
    public Setmeal findById(int id);
    public void delete(int id);
    public void deleteAssociation(int id);
    public List<Map<String,Object>> findSetmealCount();
}
