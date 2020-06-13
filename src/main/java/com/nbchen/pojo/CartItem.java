package com.nbchen.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 购物车的商品
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {
    private Integer id;
    private String name; // 商品名称
    private Integer count; // 数量
    private BigDecimal price; // 单价
    private BigDecimal totalPrice; // 总价
}
