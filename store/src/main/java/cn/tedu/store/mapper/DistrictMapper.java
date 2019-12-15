package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;

@Mapper
public interface DistrictMapper {
	List<District> findByParent(String parent);
	
	District findByCode(String code);
	
	List<Address> findByUid(Integer uid);
	
	Address findByAid(Integer aid);

	Integer updateNonDefault(Integer uid);

	Integer updateDefault(Integer aid);
}
