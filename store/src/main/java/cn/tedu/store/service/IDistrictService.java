package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;

public interface IDistrictService {
	List<District> getByParent(String parent);
	
	/**
	 * 根据代号获取省/市/区的信息
	 * @param code 省/市/区的代号
	 * @return 匹配的省/市/区的信息，如果没有匹配的信息，则返回null
	 */
	District getByCode(String code);
	
	List<Address> getByUid(Integer uid);
	
	Address findByAid(Integer aid);

	Integer updateNonDefault(Integer uid);

	Integer updateDefault(Integer aid);
}
