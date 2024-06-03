package priv.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.backend.entity.PageBean;
import priv.backend.entity.RestBean;
import priv.backend.entity.dto.Merchandise;
import priv.backend.service.MerchandiseService;
import priv.backend.utils.ReturnUtils;

@RestController
@RequestMapping("/merchandise")
public class MerchandiseController {
    private final MerchandiseService merchandiseService;

    @Autowired
    public MerchandiseController(MerchandiseService merchandiseService) {
        this.merchandiseService = merchandiseService;
    }


    @GetMapping("/list")
    public RestBean<Object> getAllUser(PageBean pageBean) { // 需要返回数据
        return ReturnUtils.messageData(merchandiseService::getAllMerchandises, pageBean); //请求携带分页参数，响应请求需要携带数据返回的
    }

    @PostMapping("/add")
    public RestBean<Void> addUser(@RequestBody Merchandise merchandise) {
        return ReturnUtils.message(merchandiseService::addMerchandise, merchandise);
    }

    @PutMapping("/update")
    public RestBean<Void> updateUser(@RequestBody Merchandise merchandise) {
        return ReturnUtils.message(merchandiseService::updateMerchandise, merchandise);
    }

    @DeleteMapping("/delete/{id}")
    public RestBean<Void> deleteUser(@PathVariable("id") Integer id) {
        return ReturnUtils.message(merchandiseService::deleteMerchandiseById, id);
    }

    @GetMapping("/{id}")
    public RestBean<Object> getUser(@PathVariable("id") Integer id) {
        return ReturnUtils.messageData(merchandiseService::getMerchandiseById, id);
    }

    @GetMapping("getAll")
    public RestBean<Object> getMerchandises() {
        return ReturnUtils.messageData(merchandiseService::getMerchandises);
    }

    @PostMapping("/search")
    public RestBean<Object> searchMerchandise(@RequestBody Merchandise merchandise) {
        return ReturnUtils.messageData(() -> merchandiseService.searchMerchandises(merchandise));
    }
}
