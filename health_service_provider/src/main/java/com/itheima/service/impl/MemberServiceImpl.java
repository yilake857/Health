package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.MemberDao;
import com.itheima.pojo.Member;
import com.itheima.service.CheckItemService;
import com.itheima.service.MemberService;
import com.itheima.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(interfaceClass = MemberService.class)
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;
    //根据手机号查询会员
    public Member findByTelephone(String telephone) {
        return memberDao.findByTelephone(telephone);
    }

    public List<Integer> findMemberCountByMonths(List<String> months) {
        List<Integer> list = new ArrayList<>();
        for(String month:  months){
            System.out.println(month);
            Integer integer = memberDao.findMemberCountBeforeDate(month);
            list.add(integer);
        }

        return list;
    }

    //新增会员
    public void add(Member member) {
        if(member.getPassword() != null){
            member.setPassword(MD5Utils.md5(member.getPassword()));
        }
        memberDao.add(member);
    }
}
