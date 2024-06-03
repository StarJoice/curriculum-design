package priv.backend.entity.dto;

import lombok.Data;

/**
 * StockIn DTO 进货单 实体类
 */
@Data
public class StockIn {
    private Integer id;
    private String code; // 商品编码
    private Integer clientId;// 客户id --> 对应客户表
    private Integer merchandiseId; // 商品id --> 对应商品表
    private Integer amount; // 进货数量
    private double price; // 进货单价
    private double money; // 进货金额
    private String stockInDate; // 进货日期
    private Integer employeeId; // 进货员id --> 对应员工表
}
