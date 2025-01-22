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


import com.dao.ChengshiDao;
import com.entity.ChengshiEntity;
import com.service.ChengshiService;
import com.entity.vo.ChengshiVO;
import com.entity.view.ChengshiView;

@Service("chengshiService")
public class ChengshiServiceImpl extends ServiceImpl<ChengshiDao, ChengshiEntity> implements ChengshiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChengshiEntity> page = this.selectPage(
                new Query<ChengshiEntity>(params).getPage(),
                new EntityWrapper<ChengshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChengshiEntity> wrapper) {
		  Page<ChengshiView> page =new Query<ChengshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChengshiVO> selectListVO(Wrapper<ChengshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChengshiVO selectVO(Wrapper<ChengshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChengshiView> selectListView(Wrapper<ChengshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChengshiView selectView(Wrapper<ChengshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
