package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * drp_bas_s02 商品品牌 服务模块
 * @author gelf
 * @since 2017-02-14
 */
public interface IBrandService extends DWService {
	/**
	 * 根据预设条件查询商品品牌列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	Object getBrandList(Map<String,Object> param,int startPage,int pageSize) throws Exception;
	
	/**
	 * 修改商品品牌
	 * @param param
	 * @return
	 */
	Object modifyBrand(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除商品品牌
	 * @param param
	 * @return
	 */
	Object deleteBrand(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 审核商品品牌
	 * @param param
	 * @param status_code
	 * @return
	 */
	Object auditBrand(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 新增商品品牌
	 * @param param
	 * @return
	 */
	Object addBrand(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断商品品牌是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object judgeBrand(Map<String,Object> param) throws Exception; 
	
	/**
	 * 根据主键查询商品品牌
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object getBrand(Map<String,Object> param) throws Exception;
}
