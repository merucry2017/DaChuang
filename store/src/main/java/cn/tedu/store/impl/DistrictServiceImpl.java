package cn.tedu.store.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.DistrictMapper;
import cn.tedu.store.service.IDistrictService;

@Service
public class DistrictServiceImpl implements IDistrictService {

    @Autowired
    private DistrictMapper distrctMapper;

    @Override
    public List<District> getByParent(String parent) {
        return findByParent(parent);
    }

    /**
     * 获取所有省/某省所有市/某市所有区的列表
     * @param parent 获取省列表时，使用86；获取市列表时，使用省的代号；获取区列表时，使用市的代号
     * @return 所有省/某省所有市/某市所有区的列表
     */
    private List<District> findByParent(String parent) {
        return distrctMapper.findByParent(parent);
    }
    
    @Override
    public District getByCode(String code) {
        return findByCode(code);
    }

    /**
     * 根据代号获取省/市/区的信息
     * @param code 省/市/区的代号
     * @return 匹配的省/市/区的信息，如果没有匹配的信息，则返回null
     */
    private District findByCode(String code) {
        return distrctMapper.findByCode(code);
    }

	@Override
	public List<Address> getByUid(Integer uid) {
		// TODO Auto-generated method stub
		return distrctMapper.findByUid(uid);
	}

	@Override
	public Address findByAid(Integer aid) {
		// TODO Auto-generated method stub
		return distrctMapper.findByAid(aid);
	}

	@Override
	public Integer updateNonDefault(Integer uid) {
		// TODO Auto-generated method stub
		return distrctMapper.updateDefault(uid);
	}

	@Override
	public Integer updateDefault(Integer aid) {
		// TODO Auto-generated method stub
		return distrctMapper.updateDefault(aid);
	}

}