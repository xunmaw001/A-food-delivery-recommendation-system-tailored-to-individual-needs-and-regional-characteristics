package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.entity.OrdersEntity;
import com.service.OrdersService;

import com.entity.CaidanliebiaoEntity;
import com.entity.view.CaidanliebiaoView;

import com.service.CaidanliebiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 菜单列表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-26 14:26:59
 */
@RestController
@RequestMapping("/caidanliebiao")
public class CaidanliebiaoController {
    @Autowired
    private CaidanliebiaoService caidanliebiaoService;


    @Autowired
    private StoreupService storeupService;

    @Autowired
    private OrdersService ordersService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaidanliebiaoEntity caidanliebiao, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			caidanliebiao.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CaidanliebiaoEntity> ew = new EntityWrapper<CaidanliebiaoEntity>();
		PageUtils page = caidanliebiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caidanliebiao), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CaidanliebiaoEntity caidanliebiao, 
		HttpServletRequest request){
        EntityWrapper<CaidanliebiaoEntity> ew = new EntityWrapper<CaidanliebiaoEntity>();
		PageUtils page = caidanliebiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caidanliebiao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaidanliebiaoEntity caidanliebiao){
       	EntityWrapper<CaidanliebiaoEntity> ew = new EntityWrapper<CaidanliebiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caidanliebiao, "caidanliebiao")); 
        return R.ok().put("data", caidanliebiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaidanliebiaoEntity caidanliebiao){
        EntityWrapper< CaidanliebiaoEntity> ew = new EntityWrapper< CaidanliebiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caidanliebiao, "caidanliebiao")); 
		CaidanliebiaoView caidanliebiaoView =  caidanliebiaoService.selectView(ew);
		return R.ok("查询菜单列表成功").put("data", caidanliebiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaidanliebiaoEntity caidanliebiao = caidanliebiaoService.selectById(id);
		caidanliebiao.setClicktime(new Date());
		caidanliebiaoService.updateById(caidanliebiao);
        return R.ok().put("data", caidanliebiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaidanliebiaoEntity caidanliebiao = caidanliebiaoService.selectById(id);
		caidanliebiao.setClicktime(new Date());
		caidanliebiaoService.updateById(caidanliebiao);
        return R.ok().put("data", caidanliebiao);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        CaidanliebiaoEntity caidanliebiao = caidanliebiaoService.selectById(id);
        if(type.equals("1")) {
        	caidanliebiao.setThumbsupnum(caidanliebiao.getThumbsupnum()+1);
        } else {
        	caidanliebiao.setCrazilynum(caidanliebiao.getCrazilynum()+1);
        }
        caidanliebiaoService.updateById(caidanliebiao);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CaidanliebiaoEntity caidanliebiao, HttpServletRequest request){
    	caidanliebiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(caidanliebiao);

        caidanliebiaoService.insert(caidanliebiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CaidanliebiaoEntity caidanliebiao, HttpServletRequest request){
    	caidanliebiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(caidanliebiao);

        caidanliebiaoService.insert(caidanliebiao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CaidanliebiaoEntity caidanliebiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caidanliebiao);
        caidanliebiaoService.updateById(caidanliebiao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caidanliebiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<CaidanliebiaoEntity> wrapper = new EntityWrapper<CaidanliebiaoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			wrapper.eq("shangjiazhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = caidanliebiaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,CaidanliebiaoEntity caidanliebiao, HttpServletRequest request,String pre){
        EntityWrapper<CaidanliebiaoEntity> ew = new EntityWrapper<CaidanliebiaoEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        
        params.put("order", "desc");
		PageUtils page = caidanliebiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caidanliebiao), params), params));
        return R.ok().put("data", page);
    }


	/**
     * 协同算法（按用户购买推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,CaidanliebiaoEntity caidanliebiao, HttpServletRequest request){
    	String userId = request.getSession().getAttribute("userId").toString();
    	String goodtypeColumn = "caixifenlei";
    	List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>().eq("userid", userId).eq("tablename", "caidanliebiao").orderBy("addtime", false));
        List<String> goodtypes = new ArrayList<String>();
    	Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
    	List<CaidanliebiaoEntity> caidanliebiaoList = new ArrayList<CaidanliebiaoEntity>();
	//去重
    	List<OrdersEntity> ordersDist = new ArrayList<OrdersEntity>();
    	for(OrdersEntity o1 : orders) {
    		boolean addFlag = true;
    		for(OrdersEntity o2 : ordersDist) {
    			if(o1.getGoodid()==o2.getGoodid() || o1.getGoodtype().equals(o2.getGoodtype())) {
    				addFlag = false;
    				break;
    			}
    		}
    		if(addFlag) ordersDist.add(o1);
    	}
        if(ordersDist!=null && ordersDist.size()>0) {
        	for(OrdersEntity o : ordersDist) {
        		caidanliebiaoList.addAll(caidanliebiaoService.selectList(new EntityWrapper<CaidanliebiaoEntity>().eq(goodtypeColumn, o.getGoodtype())));
        	}
        }
    	EntityWrapper<CaidanliebiaoEntity> ew = new EntityWrapper<CaidanliebiaoEntity>();
	params.put("sort", "id");
	params.put("order", "desc");
	PageUtils page = caidanliebiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caidanliebiao), params), params));
        List<CaidanliebiaoEntity> pageList = (List<CaidanliebiaoEntity>)page.getList();
        if(caidanliebiaoList.size()<limit) {
        	int toAddNum = (limit-caidanliebiaoList.size())<=pageList.size()?(limit-caidanliebiaoList.size()):pageList.size();
            for(CaidanliebiaoEntity o1 : pageList) {
                boolean addFlag = true;
                for(CaidanliebiaoEntity o2 : caidanliebiaoList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    caidanliebiaoList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        }
        page.setList(caidanliebiaoList);
	return R.ok().put("data", page);
    }





}
