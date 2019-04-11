package com.example.controller;


import com.example.model.AjaxResult;
import com.example.model.Seckill;
import com.example.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by liulq on 2018-12-11 .
 */
@RestController
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    //商品列表
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public AjaxResult list(Model model){
        List<Seckill> list=seckillService.getSeckillList();
        return AjaxResult.ok(list);
    }

}
