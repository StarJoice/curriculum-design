package priv.backend.entity.dto;

import lombok.Data;

/**
 * StockOrder DTO 订货单实体类
 */
@Data
public class StockOrder {
    private Integer id;
    private String code; // 订货单编号
    private Integer clientId; // 客户ID --> 对应客户表
    private Integer merchandiseId; // 商品ID --> 对应商品表
    private Integer orderedQuantity; // 订货数量
    private String orderTime; // 订货时间
    private Integer handleOperatorId; // 处理人ID --> 对应用户表

}

