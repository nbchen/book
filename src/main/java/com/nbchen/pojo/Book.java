package com.nbchen.pojo;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 图书类
public class Book implements Serializable {
    private int id; // id
    private String name; // 名称
    private BigDecimal price; // 价格
    private String author; // 作者
    private Integer sales; // 销量
    private Integer stock; // 库存
    @Builder.Default
    private String imgPath = "static/img/default.jpg"; // 图书默认地址
}
