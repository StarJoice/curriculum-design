package priv.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import priv.backend.entity.dto.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
