package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.CaidanliebiaoDao;
import com.entity.CaidanliebiaoEntity;
import com.service.CaidanliebiaoService;
import com.entity.vo.CaidanliebiaoVO;
import com.entity.view.CaidanliebiaoView;

@Service("caidanliebiaoService")
public class CaidanliebiaoServiceImpl extends ServiceImpl<CaidanliebiaoDao, CaidanliebiaoEntity> implements CaidanliebiaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CaidanliebiaoEntity> page = this.selectPage(
                new Query<CaidanliebiaoEntity>(params).getPage(),
                new EntityWrapper<CaidanliebiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CaidanliebiaoEntity> wrapper) {
		  Page<CaidanliebiaoView> page =new Query<CaidanliebiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CaidanliebiaoVO> selectListVO(Wrapper<CaidanliebiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CaidanliebiaoVO selectVO(Wrapper<CaidanliebiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CaidanliebiaoView> selectListView(Wrapper<CaidanliebiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CaidanliebiaoView selectView(Wrapper<CaidanliebiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
