package io.github.wuwei01.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.wuwei01.entity.User;
import io.github.wuwei01.mapper.UserMapper;
import io.github.wuwei01.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuwei
 * @since 2021年5月19日16:36:12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
