package priv.backend.entity.vo.response;

import lombok.Data;

@Data
public class RespStockInVO {
    private Integer id; // 入库单id
    private String code;// 商品编码
    private RespClientVO client; // 客户信息
    private RespMerchandiseVO merchandise; // 商品信息
    private Integer amount; // 入库数量
    private double price ; // 入库单价
    private double money; // 入库金额
    private String stockInDate; // 入库日期
    private RespEmployeeVO employee; // 入库员工信息
}
