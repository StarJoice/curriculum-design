package priv.backend.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.backend.entity.PageBean;
import priv.backend.entity.dto.Merchandise;
import priv.backend.mapper.MerchandiseMapper;
import priv.backend.service.MerchandiseService;

@Service
public class MerchandiseServiceImpl extends ServiceImpl<MerchandiseMapper, Merchandise> implements MerchandiseService {
    private final MerchandiseMapper mapper;

    @Autowired
    public MerchandiseServiceImpl(MerchandiseMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Object getAllMerchandises(PageBean pageBean) {
        // 分页
        if (pageBean.getIsItPaginated()) {
            Page<Merchandise> page = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());
            // 查询所有
            return mapper.selectPage(page, new QueryWrapper<>());
        }
        // 不分页
        return this.list();
    }

    @Override
    public String addMerchandise(Merchandise merchandise) {
        if (merchandise == null) {
            return "商品信息不能为空";
        }
        if (!this.save(merchandise)) {
            return "添加失败";
        }

        // 业务结束，添加成功
        return null;
    }


    @Override
    public String updateMerchandise(Merchandise merchandise) {
        if (merchandise == null) {
            return "商品信息不能为空";
        }
        if (!this.updateById(merchandise)) {
            return "更新失败";
        }

        // 业务结束，更新成功
        return null;
    }

    @Override
    public String deleteMerchandiseById(Integer id) {
        if (id == null) {
            return "商品id不能为空";
        }
        if (!this.removeById(id)) {
            return "删除失败";
        }
        // 业务结束，删除成功
        return null;
    }


    @Override
    public Object getMerchandiseById(Integer id) {
        if (id == null) {
            return "必填项为空";
        }
        return mapper.selectById(id);
    }

    @Override
    public Object getMerchandises() {
        return this.list();
    }

    @Override
    public Object searchMerchandises(Merchandise merchandise) {
        QueryWrapper<Merchandise> queryWrapper = new QueryWrapper<>();

        // 只在 code 非空且非空字符串时添加到查询条件中
        if (merchandise.getCode() != null && !merchandise.getCode().trim().isEmpty()) {
            queryWrapper.eq("code", merchandise.getCode().trim());
        }

        // 只在 name 非空且非空字符串时添加到查询条件中
        if (merchandise.getName() != null && !merchandise.getName().trim().isEmpty()) {
            queryWrapper.like("name", "%" + merchandise.getName().trim() + "%");
        }
        return mapper.selectList(queryWrapper);
    }
}


