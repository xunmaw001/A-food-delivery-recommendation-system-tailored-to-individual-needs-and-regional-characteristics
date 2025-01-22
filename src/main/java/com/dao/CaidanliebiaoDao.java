package com.dao;

import com.entity.CaidanliebiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CaidanliebiaoVO;
import com.entity.view.CaidanliebiaoView;


/**
 * 菜单列表
 * 
 * @author 
 * @email 
 * @date 2022-03-26 14:26:59
 */
public interface CaidanliebiaoDao extends BaseMapper<CaidanliebiaoEntity> {
	
	List<CaidanliebiaoVO> selectListVO(@Param("ew") Wrapper<CaidanliebiaoEntity> wrapper);
	
	CaidanliebiaoVO selectVO(@Param("ew") Wrapper<CaidanliebiaoEntity> wrapper);
	
	List<CaidanliebiaoView> selectListView(@Param("ew") Wrapper<CaidanliebiaoEntity> wrapper);

	List<CaidanliebiaoView> selectListView(Pagination page,@Param("ew") Wrapper<CaidanliebiaoEntity> wrapper);
	
	CaidanliebiaoView selectView(@Param("ew") Wrapper<CaidanliebiaoEntity> wrapper);
	

}
