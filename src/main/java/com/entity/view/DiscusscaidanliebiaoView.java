package com.entity.view;

import com.entity.DiscusscaidanliebiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 菜单列表评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-26 14:26:59
 */
@TableName("discusscaidanliebiao")
public class DiscusscaidanliebiaoView  extends DiscusscaidanliebiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusscaidanliebiaoView(){
	}
 
 	public DiscusscaidanliebiaoView(DiscusscaidanliebiaoEntity discusscaidanliebiaoEntity){
 	try {
			BeanUtils.copyProperties(this, discusscaidanliebiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
