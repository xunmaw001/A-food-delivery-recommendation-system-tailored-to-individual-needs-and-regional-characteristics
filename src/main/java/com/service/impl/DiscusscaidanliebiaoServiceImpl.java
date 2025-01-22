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


import com.dao.DiscusscaidanliebiaoDao;
import com.entity.DiscusscaidanliebiaoEntity;
import com.service.DiscusscaidanliebiaoService;
import com.entity.vo.DiscusscaidanliebiaoVO;
import com.entity.view.DiscusscaidanliebiaoView;

@Service("discusscaidanliebiaoService")
public class DiscusscaidanliebiaoServiceImpl extends ServiceImpl<DiscusscaidanliebiaoDao, DiscusscaidanliebiaoEntity> implements DiscusscaidanliebiaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusscaidanliebiaoEntity> page = this.selectPage(
                new Query<DiscusscaidanliebiaoEntity>(params).getPage(),
                new EntityWrapper<DiscusscaidanliebiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusscaidanliebiaoEntity> wrapper) {
		  Page<DiscusscaidanliebiaoView> page =new Query<DiscusscaidanliebiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusscaidanliebiaoVO> selectListVO(Wrapper<DiscusscaidanliebiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusscaidanliebiaoVO selectVO(Wrapper<DiscusscaidanliebiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusscaidanliebiaoView> selectListView(Wrapper<DiscusscaidanliebiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusscaidanliebiaoView selectView(Wrapper<DiscusscaidanliebiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
