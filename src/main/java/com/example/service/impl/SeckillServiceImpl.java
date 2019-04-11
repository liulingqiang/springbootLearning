package com.example.service.impl;


import com.example.dao.SeckillDao;
import com.example.dao.SuccessKilledDao;
import com.example.model.Seckill;
import com.example.service.SeckillService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by liulq on 2018-12-11 .
 */
@Slf4j
@Service
public class SeckillServiceImpl implements SeckillService {
    @Autowired
    SeckillDao seckillDao;


    @Override
    public List<Seckill> getSeckillList() {
        List<Seckill> seckillList =  seckillDao.selectList(null);
        return seckillList;
    }




}
