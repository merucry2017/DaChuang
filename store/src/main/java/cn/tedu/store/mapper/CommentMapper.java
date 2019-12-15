package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import cn.tedu.store.entity.Comment;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;

@Mapper
public interface CommentMapper {
	Integer insert(Comment comm);

	/*
	Integer updatePassword(
		    @Param("uid") Integer uid, 
		    @Param("password") String password, 
		    @Param("modifiedUser") String modifiedUser, 
		    @Param("modifiedTime") Date modifiedTime);
*/
	Comment findByUid(Integer uid);
	
	List<Comment> findByBid(Integer bid);
/*
	Integer updateInfo(User user);

	Integer updateAvatar(
		    @Param("uid") Integer uid, 
		    @Param("avatar") String avatar, 
		    @Param("modifiedUser") String modifiedUser, 
		    @Param("modifiedTime") Date modifiedTime);
	
	*/
	
	
}
