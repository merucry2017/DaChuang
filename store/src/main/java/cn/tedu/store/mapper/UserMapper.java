package cn.tedu.store.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;

@Mapper
public interface UserMapper {
	Integer insert(User user);

	User findByUsername(String username);
	
	Integer updatePassword(
		    @Param("uid") Integer uid, 
		    @Param("password") String password, 
		    @Param("modifiedUser") String modifiedUser, 
		    @Param("modifiedTime") Date modifiedTime);

	User findByUid(Integer uid);

	Integer updateInfo(User user);

	Integer updateAvatar(
		    @Param("uid") Integer uid, 
		    @Param("avatar") String avatar, 
		    @Param("modifiedUser") String modifiedUser, 
		    @Param("modifiedTime") Date modifiedTime);
	
	
	
	
}
