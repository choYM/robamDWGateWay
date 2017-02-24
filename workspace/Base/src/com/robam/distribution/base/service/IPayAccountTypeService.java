package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * drp_bas_f01 应付帐务类型维护服务接口
 * @author gelf
 * @since 2017-02-14
 *
 */
public interface IPayAccountTypeService extends DWService {
	/**
	 * 根据预设条件查询应付账务类型列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	Object getPayAccountTypeList(Map<String,Object> param,int startPage,int pageSize) throws Exception;
	
	/**
	 * 修改应付账务类型
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object modifyPayAccountType(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除应付账务类型
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object deletePayAccountType(List<Map<String,Object>> param) throws Exception;
		
	/**
	 * 审核应付账务类型
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	Object auditPayAccountType(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 新增应付账务类型
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object addPayAccountType(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断应付账务类型是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object judgePayAccountType(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据主键获取应付账务类型资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object getPayAccountType(Map<String,Object> param) throws Exception;
}
