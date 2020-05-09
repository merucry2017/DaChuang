package com.library.smart_library.mapper;

import com.library.smart_library.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface UserMapper {

    /**
     * 插入用户
     * @param user
     * @return
     */
    Integer insert(User user);

    /**
     * 通过用户名找用户
     * @param usernmae
     * @return
     */
    User findByUsername(String usernmae);

    /**
     * 修改密码
     * @param uid
     * @param password
     * @param modifiedTime
     * @return
     */
    Integer updatePassword(
            @Param("uid") Integer uid,
            @Param("password") String password,
            @Param("modifiedTime") Date modifiedTime);

    /**
     * 通过uid找用户
     * @param uid
     * @return
     */
    User findByUid(Integer uid);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Integer updateInfo(User user);


}
