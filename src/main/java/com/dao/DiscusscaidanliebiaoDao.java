package com.dao;

import com.entity.DiscusscaidanliebiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusscaidanliebiaoVO;
import com.entity.view.DiscusscaidanliebiaoView;


/**
 * 菜单列表评论表
 * 
 * @author 
 * @email 
 * @date 2022-03-26 14:26:59
 */
public interface DiscusscaidanliebiaoDao extends BaseMapper<DiscusscaidanliebiaoEntity> {
	
	List<DiscusscaidanliebiaoVO> selectListVO(@Param("ew") Wrapper<DiscusscaidanliebiaoEntity> wrapper);
	
	DiscusscaidanliebiaoVO selectVO(@Param("ew") Wrapper<DiscusscaidanliebiaoEntity> wrapper);
	
	List<DiscusscaidanliebiaoView> selectListView(@Param("ew") Wrapper<DiscusscaidanliebiaoEntity> wrapper);

	List<DiscusscaidanliebiaoView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusscaidanliebiaoEntity> wrapper);
	
	DiscusscaidanliebiaoView selectView(@Param("ew") Wrapper<DiscusscaidanliebiaoEntity> wrapper);
	

}
