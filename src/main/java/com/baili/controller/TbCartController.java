package com.baili.controller;

import com.baili.pojo.TbCart;
import com.baili.service.TbCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tbCart")
public class TbCartController {

    @Autowired
    private TbCartService tbCartService;

    @RequestMapping("addCart")
    public String addCart(TbCart tbCart){
        if(tbCart != null) {
            int i = tbCartService.addCart(tbCart);
            if(i == 1){
                return "success";
            }
            return "failure";
        }
        return null;
    }

    @RequestMapping("selectByUserId")
    public List<TbCart> selectByUserId(int userId){
        if (userId != 0){
            List<TbCart> tbCarts = tbCartService.selectByUserId(userId);
            return tbCarts;
        }
        return null;
    }

    @RequestMapping("deleteByGoodsId")
    public String deleteByGoodsId(int userId,int goodsId){
        if (userId != 0 && goodsId != 0){
            int i = tbCartService.deleteByUserId(userId, goodsId);
            if (i == 1){
                return "success";
            }else {
                return "failure";
            }
        }
        return null;
    }

    @RequestMapping("updateNum")
    public String updateNum(TbCart tbCart){
        if (tbCart != null){
            int i = tbCartService.updateNum(tbCart);
            if (i == 1){
                return "success";
            }else {
                return "failure";
            }
        }
        return null;
    }
}
