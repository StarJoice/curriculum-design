package priv.backend.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.backend.entity.PageBean;
import priv.backend.entity.dto.Client;
import priv.backend.mapper.ClientMapper;
import priv.backend.service.ClientService;

@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService {
    private final ClientMapper mapper;

    @Autowired
    public ClientServiceImpl(ClientMapper clientMapper) {
        this.mapper = clientMapper;
    }

    @Override
    public Object getAllClients(PageBean pageBean) {
        // 分页
        if (pageBean.getIsItPaginated()) {
            Page<Client> page = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());
            // 查询所有
            return mapper.selectPage(page, new QueryWrapper<>());
        }
        // 不分页
        return this.list();
    }

    @Override
    public Object getClientById(Integer id) {
        if (id == null) {
            return "必填信息为空";
        }

        // 查询
        return mapper.selectById(id);
    }

    @Override
    public String addClient(Client client) {
        if (client == null) {
            return "必填信息为空";
        }
        if (!this.save(client)) {
            return "新增失败";
        }
        return null;
    }

    @Override
    public String updateClient(Client client) {
        if (client == null) {
            return "必填信息为空";
        }
        if (!this.updateById(client)) {
            return "更新失败";
        }
        return null;

    }

    @Override
    public String deleteClient(Integer id) {
        if (id == null) {
            return "必填信息为空";
        }
        if (!this.removeById(id)) {
            return "删除失败";
        }
        return null;
    }

    @Override
    public Object getClients() {
        return this.list();
    }

    @Override
    public Object SearchClients(Client client) {
        QueryWrapper<Client> queryWrapper = new QueryWrapper<>();

        // 只在 code 非空且非空字符串时添加到查询条件中
        if (client.getCode() != null && !client.getCode().trim().isEmpty()) {
            queryWrapper.eq("code", client.getCode().trim());
        }

        // 只在 name 非空且非空字符串时添加到查询条件中
        if (client.getName() != null && !client.getName().trim().isEmpty()) {
            queryWrapper.like("name", "%" + client.getName().trim() + "%");
        }
        return mapper.selectList(queryWrapper);
    }


}




