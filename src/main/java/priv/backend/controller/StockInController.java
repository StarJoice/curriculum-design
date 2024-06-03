package priv.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.backend.entity.PageBean;
import priv.backend.entity.RestBean;
import priv.backend.entity.dto.StockIn;
import priv.backend.service.StockInService;
import priv.backend.utils.ReturnUtils;

@RestController
@RequestMapping("/stockIn")
public class StockInController {
    private final StockInService stockInService;

    @Autowired
    public StockInController(StockInService stockInService) {
        this.stockInService = stockInService;
    }

    @GetMapping("/list")
    public RestBean<Object> getAllStockIn(PageBean pageBean) {
        return ReturnUtils.messageData(stockInService::getAllStockIn, pageBean);
    }

    @GetMapping("/{id}")
    public RestBean<Object> getStockInById(@PathVariable("id") int id) {
        return ReturnUtils.messageData(stockInService::getStockInById, id);
    }

    @PostMapping("/add")
    public RestBean<Void> addStockIn(@RequestBody StockIn stockIn) {
        return ReturnUtils.message(stockInService::addStockIn, stockIn);
    }

    @PutMapping("/update")
    public RestBean<Void> updateStockIn(@RequestBody StockIn stockIn) {
        return ReturnUtils.message(stockInService::updateStockIn, stockIn);
    }

    @DeleteMapping("/delete/{id}")
    public RestBean<Void> deleteStockIn(@PathVariable("id") int id) {
        return ReturnUtils.message(stockInService::deleteStockIn, id);
    }

    @PostMapping("/search")
    public RestBean<Object> queryStockIn(@RequestBody StockIn stockIn) {
        return ReturnUtils.messageData(stockInService::queryStockIn, stockIn);
    }


}

