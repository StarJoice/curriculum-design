package priv.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.backend.entity.PageBean;
import priv.backend.entity.dto.Client;

public interface ClientService extends IService<Client> {
    /**
     * 获取所有客户信息
     *
     * @param pageBean 分页信息
     * @return 分页数据
     */
    Object getAllClients(PageBean pageBean);

    /**
     * 根据id获取客户信息
     *
     * @param id 客户id
     * @return 客户信息
     */
    Object getClientById(Integer id);

    /**
     * 添加客户信息
     *
     * @param client 客户信息
     * @return 成功或失败信息
     */
    String addClient(Client client);

    /**
     * 删除客户信息
     *
     * @param id 客户id
     * @return 成功或失败信息
     */
    String deleteClient(Integer id);

    /**
     * 更新客户信息
     *
     * @param client 客户信息
     * @return 成功或失败信息
     */
    String updateClient(Client client);

    Object getClients();

    /**
     * 根据 客户编号 或者 客户姓名 查询 数据
     *
     * @param client 客户（某些信息）
     * @return 数据
     */
    Object SearchClients(Client client);
}
