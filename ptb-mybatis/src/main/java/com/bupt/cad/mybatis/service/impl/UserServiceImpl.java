package com.bupt.cad.mybatis.service.impl;

import com.bupt.cad.mybatis.domain.User;
import com.bupt.cad.mybatis.mapper.UserMapper;
import com.bupt.cad.mybatis.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author cad
 * @since 2023-02-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
