package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CaidanliebiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CaidanliebiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CaidanliebiaoView;


/**
 * 菜单列表
 *
 * @author 
 * @email 
 * @date 2022-03-26 14:26:59
 */
public interface CaidanliebiaoService extends IService<CaidanliebiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaidanliebiaoVO> selectListVO(Wrapper<CaidanliebiaoEntity> wrapper);
   	
   	CaidanliebiaoVO selectVO(@Param("ew") Wrapper<CaidanliebiaoEntity> wrapper);
   	
   	List<CaidanliebiaoView> selectListView(Wrapper<CaidanliebiaoEntity> wrapper);
   	
   	CaidanliebiaoView selectView(@Param("ew") Wrapper<CaidanliebiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaidanliebiaoEntity> wrapper);
   	

}

