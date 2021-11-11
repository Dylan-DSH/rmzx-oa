package com.rmzx.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rmzx.oa.entity.Node;
import com.rmzx.oa.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    public List<Node> selectNodeByUserId(Long userId);

}
