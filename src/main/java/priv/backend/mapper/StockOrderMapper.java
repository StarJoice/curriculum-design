package priv.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import priv.backend.entity.dto.StockOrder;
import priv.backend.entity.vo.response.RespStockOrderVO;

import java.util.List;

public interface StockOrderMapper extends BaseMapper<StockOrder> {
    /**
     * 分页查询所有库存订单 并查询外键对应表单详细信息
     *
     * @param page 分页对象
     * @return 分页数据
     */
    Page<RespStockOrderVO> getAllStockOrder(Page<StockOrder> page);

    List<RespStockOrderVO> queryStockOrder(StockOrder stockOrder);
}
