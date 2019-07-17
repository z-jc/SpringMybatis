package com.example.demo.dao;

import com.example.demo.bean.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author ZJC
 * @Date 2019\3\15 0015 17:12
 * @Version 1.0
 **/
@Service
public class UserDao extends BaseDao {

    /**
     * 根据id查询用户信息，得到一条记录结果
     *
     * @param id
     * @throws IOException
     */
    @Test
    public void findUserByIdTest(int id) throws IOException {
        SqlSession sqlSession = this.getSession();
        UserInfo user = sqlSession.selectOne("test.findUserById", id);
        if (user == null) {
            System.err.println("数据库中未存在第" + id + "条数据");
            return;
        }
        System.err.println("ID为" + id + "的数据是:" + user.toString());
        //释放资源
        sqlSession.close();
    }

    /**
     * 根据id查询用户信息，得到一条记录结果
     *
     * @param name
     * @throws IOException
     */
    @Test
    public UserInfo findUserByNameTest(String name) throws IOException {
        SqlSession sqlSession = this.getSession();
        UserInfo user = sqlSession.selectOne("test.findUserByName", name);
        if (user == null) {
            System.err.println("数据库中未存在这个用户的数据");
            return user;
        }
        System.err.println("name为" + name + "的数据是:" + user.toString());
        //释放资源
        sqlSession.close();
        return user;
    }

    /**
     * 查询数据库所有数据
     *
     * @throws IOException
     */
    @Test
    public void findAllUser() throws IOException {
        SqlSession sqlSession = this.getSession();
        List<UserInfo> userList = sqlSession.selectList("test.findAllUser");
        if (userList == null) {
            System.err.println("数据库中未存在此条数据");
            return;
        }
        System.err.println("数据库所有数据为:" + userList.toString());
        sqlSession.close();
    }

    /**
     * 根据ID修改name的值
     *
     * @param id
     */
    public UserInfo updateUserInfoName(int id, String userName, String password) throws IOException {
        SqlSession sqlSession = this.getSession();
        UserInfo user = new UserInfo();
        user.setId(id);
        user.setUser_name(userName);
        user.setPassword(password);
        sqlSession.insert("test.updateUserInfoName", user);
        sqlSession.commit();
        sqlSession.close();
        System.err.println("修改成功");
        return user;
    }

    /**
     * 添加用户信息
     *
     * @param info
     * @throws IOException
     */
    public int insertUserInfo(UserInfo info) throws IOException {
        SqlSession sqlSession = this.getSession();
        int index = sqlSession.insert("test.insertUserInfo", info);
        sqlSession.commit();
        System.err.println("添加成功");
        sqlSession.close();
        return index;
    }

    /**
     * 根据id删除用户信息
     *
     * @param id
     * @throws IOException
     */
    public void deleteUserInfo(int id) throws IOException {
        SqlSession sqlSession = this.getSession();
        sqlSession.delete("test.deleteUserInfo", id);
        sqlSession.commit();
        sqlSession.close();
        System.err.println("删除成功");
    }
}