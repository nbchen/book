package com.nbchen.test;

import com.nbchen.pojo.Cart;
import com.nbchen.pojo.CartItem;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 购物车测试类
 */
@Slf4j
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(CartItem.builder().id(1).name("java从入门到精通").count(1).price(new BigDecimal(1000)).totalPrice(new BigDecimal(1000)).build());
        cart.addItem(CartItem.builder().id(2).name("java从入门到精通").count(1).price(new BigDecimal(1000)).totalPrice(new BigDecimal(1000)).build());
        cart.addItem(CartItem.builder().id(3).name("数据结构及算法").count(1).price(new BigDecimal(100)).totalPrice(new BigDecimal(100)).build());
        log.info("购物车: {}" , cart);
    }

    @Test
    public void deletetem() {

        Cart cart = new Cart();
        cart.addItem(CartItem.builder().id(1).name("java从入门到精通").count(1).price(new BigDecimal(1000)).totalPrice(new BigDecimal(1000)).build());
        cart.addItem(CartItem.builder().id(2).name("java从入门到精通").count(1).price(new BigDecimal(1000)).totalPrice(new BigDecimal(1000)).build());
        cart.addItem(CartItem.builder().id(3).name("数据结构及算法").count(1).price(new BigDecimal(100)).totalPrice(new BigDecimal(100)).build());
        log.info("购物车: {}" , cart);

        cart.deletetem(1);
        log.info("购物车: {}" , cart);

    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(CartItem.builder().id(1).name("java从入门到精通").count(1).price(new BigDecimal(1000)).totalPrice(new BigDecimal(1000)).build());
        cart.addItem(CartItem.builder().id(2).name("java从入门到精通").count(1).price(new BigDecimal(1000)).totalPrice(new BigDecimal(1000)).build());
        cart.addItem(CartItem.builder().id(3).name("数据结构及算法").count(1).price(new BigDecimal(100)).totalPrice(new BigDecimal(100)).build());
        log.info("购物车: {}" , cart);

        cart.clear();
        log.info("购物车: {}" , cart);
    }

    @Test
    public void updateItem() {
        Cart cart = new Cart();
        cart.addItem(CartItem.builder().id(1).name("java从入门到精通").count(1).price(new BigDecimal(1000)).totalPrice(new BigDecimal(1000)).build());
        cart.addItem(CartItem.builder().id(2).name("java从入门到精通").count(1).price(new BigDecimal(1000)).totalPrice(new BigDecimal(1000)).build());
        cart.addItem(CartItem.builder().id(3).name("数据结构及算法").count(1).price(new BigDecimal(100)).totalPrice(new BigDecimal(100)).build());
        log.info("购物车: {}" , cart);

        cart.updateItem(1,2);
        log.info("购物车: {}" , cart);
    }
}