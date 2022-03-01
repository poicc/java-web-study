package com.soft2176.web.exercise.service;

import com.soft2176.web.exercise.entity.User;
import com.soft2176.web.exercise.mapper.UserMapper;
import com.soft2176.web.exercise.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @description: 用户服务类
 * @author: crq
 * @create: 2022-02-28 16:08
 **/
public class UserService {
    /**
     * 获取SqlSessionFactory对象
     */
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

    public User login(String username, String password) {
        //获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取userMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = mapper.findUser(username, password);
        //释放资源
        sqlSession.close();
        return user;
    }

    /**
     * 注册方法
     *
     * @param user 注册用户对象
     * @return 是否成功
     */

    public boolean register(User user) {
        //1. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //2. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3. 判断用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());
        if (u == null) {
            // 用户名不存在，注册
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u == null;
    }

}
