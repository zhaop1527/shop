package com.baili.service;

import com.baili.pojo.TbCart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface TbCartService extends IService<TbCart> {
    //添加购物车信息
    int addCart(TbCart tbCart);
    //根据用户查询购物车信息
    List<TbCart> selectByUserId(int userId);
    //删除用户单个的购物车中的商品信息
    int deleteByUserId(int userId,int goodsId);
    //修改单个商品数量
    int updateNum(TbCart tbCart);

}


