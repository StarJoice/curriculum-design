package priv.backend.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.backend.entity.PageBean;
import priv.backend.entity.dto.StockIn;
import priv.backend.mapper.StockInMapper;
import priv.backend.service.StockInService;

@Service
public class StockInServiceImpl extends ServiceImpl<StockInMapper, StockIn> implements StockInService {
    private final StockInMapper mapper;

    @Autowired
    public StockInServiceImpl(StockInMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Object getAllStockIn(PageBean pageBean) {
        // 分页
        if (pageBean.getIsItPaginated()) {
            Page<StockIn> page = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());
            // 查询所有

            return mapper.getAllStockIn(page);
        }
        // 不分页 描述一下需求
        return this.list();
    }

    @Override
    public Object getStockInById(Integer id) {
        if (id == null) {
            return "必填项为空";
        }
        // 查询用户并返回
        return mapper.selectById(id);

    }


    @Override
    public String addStockIn(StockIn stockIn) {
        if (stockIn == null) {
            return "必填项为空";
        }
        if (!this.save(stockIn)) {
            return "新增失败";
        }
        return null;
    }

    @Override
    public String updateStockIn(StockIn stockIn) {
        if (stockIn == null) {

            return "必填项为空";
        }
        if (!this.updateById(stockIn)) {
            return "更新失败";
        }
        return null;
    }

    @Override
    public String deleteStockIn(Integer id) {
        if (id == null) {
            return "必填项为空";
        }
        if (!this.removeById(id)) {
            return "删除失败";
        }
        return null;
    }

    @Override
    public Object queryStockIn(StockIn stockIn) {
//        QueryWrapper<StockIn> queryWrapper = new QueryWrapper<>();
//
//        if (stockIn.getCode() != null && !stockIn.getCode().trim().isEmpty()) {
//            queryWrapper.eq("code", stockIn.getCode());
//        }
//        if (stockIn.getClientId() != null) {
//            queryWrapper.eq("client_id", stockIn.getClientId());
//        }
//        if (stockIn.getMerchandiseId() != null) {
//            queryWrapper.eq("merchandise_id", stockIn.getMerchandiseId());
//        }
//        if (stockIn.getStockInDate() != null && !stockIn.getStockInDate().trim().isEmpty()) {
//            queryWrapper.eq("stock_in_date", stockIn.getStockInDate());
//        }
//        if (stockIn.getEmployeeId() != null) {
//            queryWrapper.eq("employee_id", stockIn.getEmployeeId());
//        }

//        return list(queryWrapper);
        if (stockIn.getStockInDate() == null || stockIn.getStockInDate().isEmpty()) {
            stockIn.setStockInDate(null);
        }
        if (stockIn.getCode() == null || stockIn.getCode().isEmpty()) {
            stockIn.setCode(null);
        }

        return mapper.queryStockIn(stockIn);
    }
}

