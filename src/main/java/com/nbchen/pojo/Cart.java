package com.nbchen.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车
 */
public class Cart {
    /**
     * key 是商品编号,value是商品信息
     */
    private Map<Integer, CartItem> items = new LinkedHashMap<>(); // 购物车商品

    /**
     * 总商品数量,商品总数量和总价没必要定义全局,直接在方法里计算号返回即可。
     * @return
     */
    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> cartItemEntry : items.entrySet()) {
            totalCount += cartItemEntry.getValue().getCount();
        }
        return totalCount;
    }

    /**
     * 总商品金额
     * @return
     */
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> cartItemEntry : items.entrySet()) {
            totalPrice = totalPrice.add(cartItemEntry.getValue().getPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    /**
     * 添加商品项
     *
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        // 先查看购物车中是否已经添加过此商品，
        // 如果已添加，则数量累加，总金额更新，
        // 如果没有添加过，直接放到 集合中即可
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            // 之前没有添加过
            items.put(cartItem.getId(), cartItem);
        } else {
            // 已经添加过
            item.setCount(item.getCount() + 1); // 数量累加
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount()))); // 更新总金额
        }
    }

    /**
     * 删除商品项
     *
     * @param id
     */
    public void deletetem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    /**
     * 修改商品项
     *
     * @param id
     * @param count
     */
    public void updateItem(Integer id, Integer count) {
        // 先查看购物车中是否有此商品。
        // 如果有，修改商品数量，更新总金额
        CartItem item = items.get(id);
        if (item != null) {
            item.setCount(count); // 修改商品数量
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount()))); // 更新总金额
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalPrice=" + getTotalPrice() +
                ",totalCount=" + getTotalCount() +
                ",items=" + items +
                '}';
    }
}
