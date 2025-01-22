package com.dao;

import com.entity.ChengshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChengshiVO;
import com.entity.view.ChengshiView;


/**
 * 城市
 * 
 * @author 
 * @email 
 * @date 2022-03-26 14:26:59
 */
public interface ChengshiDao extends BaseMapper<ChengshiEntity> {
	
	List<ChengshiVO> selectListVO(@Param("ew") Wrapper<ChengshiEntity> wrapper);
	
	ChengshiVO selectVO(@Param("ew") Wrapper<ChengshiEntity> wrapper);
	
	List<ChengshiView> selectListView(@Param("ew") Wrapper<ChengshiEntity> wrapper);

	List<ChengshiView> selectListView(Pagination page,@Param("ew") Wrapper<ChengshiEntity> wrapper);
	
	ChengshiView selectView(@Param("ew") Wrapper<ChengshiEntity> wrapper);
	

}
