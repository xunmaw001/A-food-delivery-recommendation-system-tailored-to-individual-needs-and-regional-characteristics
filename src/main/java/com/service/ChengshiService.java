package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChengshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChengshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChengshiView;


/**
 * 城市
 *
 * @author 
 * @email 
 * @date 2022-03-26 14:26:59
 */
public interface ChengshiService extends IService<ChengshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChengshiVO> selectListVO(Wrapper<ChengshiEntity> wrapper);
   	
   	ChengshiVO selectVO(@Param("ew") Wrapper<ChengshiEntity> wrapper);
   	
   	List<ChengshiView> selectListView(Wrapper<ChengshiEntity> wrapper);
   	
   	ChengshiView selectView(@Param("ew") Wrapper<ChengshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChengshiEntity> wrapper);
   	

}

