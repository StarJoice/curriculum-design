package priv.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import priv.backend.entity.dto.StockIn;
import priv.backend.entity.vo.response.RespStockInVO;

import java.util.List;

public interface StockInMapper extends BaseMapper<StockIn> {
    /**
     * 分页查询入库单 同时 查询外键对应的表单并返回详细信息
     *
     * @param page 分页对象
     * @return 分页数据
     */
    Page<RespStockInVO> getAllStockIn(Page<StockIn> page);

    /**
     * 分页查询入库单 同时 查询外键对应的表单并返回详细信息
     *
     * @return 分页数据
     */
    List<RespStockInVO> queryStockIn(StockIn stockIn);
}
