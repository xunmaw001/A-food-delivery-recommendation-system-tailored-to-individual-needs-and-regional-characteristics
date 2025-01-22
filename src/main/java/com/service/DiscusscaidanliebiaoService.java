package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusscaidanliebiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusscaidanliebiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusscaidanliebiaoView;


/**
 * 菜单列表评论表
 *
 * @author 
 * @email 
 * @date 2022-03-26 14:26:59
 */
public interface DiscusscaidanliebiaoService extends IService<DiscusscaidanliebiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusscaidanliebiaoVO> selectListVO(Wrapper<DiscusscaidanliebiaoEntity> wrapper);
   	
   	DiscusscaidanliebiaoVO selectVO(@Param("ew") Wrapper<DiscusscaidanliebiaoEntity> wrapper);
   	
   	List<DiscusscaidanliebiaoView> selectListView(Wrapper<DiscusscaidanliebiaoEntity> wrapper);
   	
   	DiscusscaidanliebiaoView selectView(@Param("ew") Wrapper<DiscusscaidanliebiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusscaidanliebiaoEntity> wrapper);
   	

}

