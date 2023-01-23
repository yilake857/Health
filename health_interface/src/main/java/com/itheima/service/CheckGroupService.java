package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {
     void add(CheckGroup checkGroup,Integer[] checkitemIds);
     public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);
     CheckGroup findById(Integer id);
     List<Integer> findCheckItemIdsByCheckGroupId(Integer id);
     public void edit(CheckGroup checkGroup,Integer[] checkitemIds);
     void delete(Integer id);
     List<CheckGroup> findAll();

}
