package com.baili.service.impl;
import com.alibaba.fastjson.JSON;
import com.baili.dao.TbCartMapper;
import com.baili.pojo.TbCart;
import com.baili.service.TbCartService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TbCartServiceImpl extends ServiceImpl<TbCartMapper, TbCart> implements TbCartService  {


    @Autowired
    private TbCartMapper tbCartMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private Object object = new Object();


    @Override
    public int addCart(TbCart tbCart) {

        return tbCartMapper.insert(tbCart);
    }

    @Override
    public List<TbCart> selectByUserId(int userId) {
        synchronized (object) {
            if (stringRedisTemplate.opsForValue().get("cart" + userId) != null) {
                String cart = (String) stringRedisTemplate.opsForValue().get("cart" + userId);
                return JSON.parseArray(cart, TbCart.class);
            } else {
                QueryWrapper<TbCart> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("user_id", userId);
                List<TbCart> tbCarts = tbCartMapper.selectList(queryWrapper);
                stringRedisTemplate.opsForValue().set("cart" + userId, JSON.toJSONString(tbCarts));
                return tbCarts;

            }
        }
    }

    @Override
    public int deleteByUserId(int userId,int goodsId) {
        synchronized (object) {
            QueryWrapper<TbCart> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("goods_id", goodsId);
            queryWrapper.eq("user_id", userId);
            String cart = stringRedisTemplate.opsForValue().get("cart" + userId);
            List<TbCart> tbCarts = JSON.parseArray(cart, TbCart.class);
            for (TbCart car : tbCarts) {
                int i = 0;
                i++;
                if (car.getGoodsId() == goodsId){
                    tbCarts.remove(i);
                    break;
                }
            }
            return tbCartMapper.delete(queryWrapper);
        }
    }

    @Override
    public int updateNum(TbCart tbCart) {
        synchronized (object) {
            Integer userId = tbCart.getUserId();
            Integer goodsId = tbCart.getGoodsId();
            String cart = stringRedisTemplate.opsForValue().get("cart" + userId);
            List<TbCart> tbCarts = JSON.parseArray(cart, TbCart.class);
            for (TbCart car : tbCarts) {
                int i = 0;
                i++;
                if (car.getGoodsId() == goodsId){
                    tbCarts.set(i,tbCart);
                    break;
                }
            }
            QueryWrapper<TbCart> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", tbCart.getUserId());

            return tbCartMapper.update(tbCart, queryWrapper);
        }
    }


}
