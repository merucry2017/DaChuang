package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.tedu.store.entity.Goods;
@Mapper
public interface GoodsMapper {

	List<Goods> findHotGoods();
	
	Goods findById(Long id);

}
