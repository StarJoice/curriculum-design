package priv.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.backend.entity.PageBean;
import priv.backend.entity.dto.Merchandise;

public interface MerchandiseService extends IService<Merchandise> {
    /**
     * 获取所有商品信息
     *
     * @param pageBean 分页
     * @return 分页数据
     */
    Object getAllMerchandises(PageBean pageBean);

    /**
     * 添加商品信息
     *
     * @param merchandise 商品信息
     * @return 是否成功
     */
    String addMerchandise(Merchandise merchandise);

    /**
     * 更新商品信息
     *
     * @param merchandise 商品信息
     * @return 是否成功
     */
    String updateMerchandise(Merchandise merchandise);

    /**
     * 删除商品信息
     *
     * @param id 商品id
     * @return 是否成功
     */
    String deleteMerchandiseById(Integer id);

    /**
     * 根据id获取商品信息
     *
     * @param id 商品id
     * @return 商品信息
     */
    Object getMerchandiseById(Integer id);


    Object getMerchandises();

    Object searchMerchandises(Merchandise merchandise);
}
