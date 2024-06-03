package priv.backend.entity.dto;

import lombok.Data;

/**
 * Merchandise DTO 商品信息实体类
 */
@Data
public class Merchandise {
    private Integer id;
    private String code; // 商品编码
    private String name; // 商品名称
    private double price; // 商品价格
}
