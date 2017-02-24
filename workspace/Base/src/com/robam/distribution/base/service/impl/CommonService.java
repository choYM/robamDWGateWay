package com.robam.distribution.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.ICommonService;
/**
 * 页面的公共服务
 * @author gelf
 *
 */
public class CommonService implements ICommonService {
	
	@Autowired
	private Dao dao;
	
	/**
	 * 获取州别信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getContinent() throws Exception {
		Map<String,Object> param = new HashMap<String,Object>();
		
		param.put("status_code", "Y");//状态码
		param.put("language", "CN");
		
		List data = this.dao.query("dao.CommonSettingMapper.getContinent", param);
		
		return this.getResult(data);
	}
	/**
	 * 判断州别是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeContinent(Map<String, Object> param) throws Exception {

		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List<Integer> data = this.dao.query("dao.CommonSettingMapper.judgeContinent", param);
		
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.get(0) > 0){
			result.put("successValue", true);
			result.put("description", "州别信息合法");
		}else{
			result.put("successValue", false);
			result.put("description", "州别信息不合法");
		}
		
		return result;
	}

	/**
	 * 获取国家信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getCountry(Map<String,Object> param) throws Exception {
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List data = this.dao.query("dao.CommonSettingMapper.getCountry", param);
		
		return this.getResult(data);
	}
	
	/**
	 * 判断国家信息是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeCountry(Map<String, Object> param) throws Exception {
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List<Integer> data = this.dao.query("dao.CommonSettingMapper.judgeCountry", param);
		
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.get(0) > 0){
			result.put("successValue", true);
			result.put("description", "国家信息合法");
		}else{
			result.put("successValue", false);
			result.put("description", "国家信息不合法");
		}
		
		return result;
	}

	/**
	 * 获取省信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getProvince(Map<String,Object> param) throws Exception {
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List data = this.dao.query("dao.CommonSettingMapper.getProvince", param);
		
		return this.getResult(data);
	}
	
	/**
	 * 判断省别信息是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeProvince(Map<String, Object> param) throws Exception {
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List<Integer> data = this.dao.query("dao.CommonSettingMapper.judgeProvince", param);
		
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.get(0) > 0){
			result.put("successValue", true);
			result.put("description", "省别信息合法");
		}else{
			result.put("successValue", false);
			result.put("description", "省别信息不合法");
		}
		
		return result;
	}
	

	/**
	 * 获取城市信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getCity(Map<String,Object> param) throws Exception {
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List data = this.dao.query("dao.CommonSettingMapper.getCity", param);
		
		return this.getResult(data);
	}

	/**
	 * 判断城市信息是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeCity(Map<String, Object> param) throws Exception {

		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List<Integer> data = this.dao.query("dao.CommonSettingMapper.judgeCity", param);
		
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.get(0) > 0){
			result.put("successValue", true);
			result.put("description", "城市信息合法");
		}else{
			result.put("successValue", false);
			result.put("description", "城市信息不合法");
		}
		
		return result;
	}
	
	/**
	 * 获取县区信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getCounty(Map<String,Object> param) throws Exception {
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List data = this.dao.query("dao.CommonSettingMapper.getCounty", param);

		return this.getResult(data);
	}
	
	/**
	 * 判断县区是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeCounty(Map<String, Object> param) throws Exception {
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List<Integer> data = this.dao.query("dao.CommonSettingMapper.judgeCounty", param);
		
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.get(0) > 0){
			result.put("successValue", true);
			result.put("description", "县区信息合法");
		}else{
			result.put("successValue", false);
			result.put("description", "县区信息不合法");
		}
		
		return result;
	}

	/**
	 * 获取街道信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getStreet(Map<String,Object> param) throws Exception {
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List data = this.dao.query("dao.CommonSettingMapper.getStreet", param);
		
		return this.getResult(data);
	}
	
	/**
	 * 获取邮政编号
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getPostcode(Map<String,Object> param) throws Exception {
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List data = this.dao.query("dao.CommonSettingMapper.getPostcode", param);
		
		return this.getResult(data);
	}
	
	/**
	 * 判断邮政编号是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgePostcode(Map<String, Object> param) throws Exception {

		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List<Integer> data = this.dao.query("dao.CommonSettingMapper.judgePostcode", param);
		
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.get(0) > 0){
			result.put("successValue", true);
			result.put("description", "邮政信息合法");
		}else{
			result.put("successValue", false);
			result.put("description", "邮政信息不合法");
		}
		
		return result;
	}
	
	
	/**
	 * 获取时区
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getTimeZone() throws Exception {
		Map<String,Object> param = new HashMap<String,Object>();
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List data = this.dao.query("dao.CommonSettingMapper.getTimeZone", param);
		
		return this.getResult(data);
	}
	
	/**
	 * 判断时区是否正确
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeTimeZone(Map<String, Object> param) throws Exception {
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List<Integer> data = this.dao.query("dao.CommonSettingMapper.judgeTimeZone", param);
		
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.get(0) > 0){
			result.put("successValue", true);
			result.put("description", "时区信息合法");
		}else{
			result.put("successValue", false);
			result.put("description", "时区信息不合法");
		}
		
		return result;
		
	}

	
	/**
	 * 获取门店或商品其他属性列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getAttributeList(Map<String, Object> param) throws Exception {
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List data = this.dao.query("dao.CommonSettingMapper.getAttributeList", param);
		
		return this.getResult(data);
		
	}
	
	/**
	 * 判断门店或商品其他属性是否合法
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeAttribute(Map<String, Object> param) throws Exception {
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List<Integer> data = this.dao.query("dao.CommonSettingMapper.judgeAttribute", param);
		
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.get(0) > 0){
			result.put("successValue", true);
			result.put("description", "其他属性信息合法");
		}else{
			result.put("successValue", false);
			result.put("description", "其他属性信息不合法");
		}
		
		return result;
	}
	/**
	 * 获取币种列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getCurrencyList(Map<String, Object> param) throws Exception {
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "zh_CN");//语言别
		
		List data = this.dao.query("dao.CommonSettingMapper.getCurrencyList", param);
		
		return this.getResult(data);
	}
	
	/**
	 * 判断币种是否合法
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeCurrency(Map<String, Object> param) throws Exception {
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List<Integer> data = this.dao.query("dao.CommonSettingMapper.judgeCurrency", param);
		
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.get(0) > 0){
			result.put("successValue", true);
			result.put("description", "币种信息合法");
		}else{
			result.put("successValue", false);
			result.put("description", "币种信息不合法");
		}
		
		return result;
	}
	
	/**
	 * 获取参照表列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getReferenceTableList(Map<String, Object> param) throws Exception {
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List data = this.dao.query("dao.CommonSettingMapper.getReferenceTableList", param);
		
		return this.getResult(data);
	}
	
	/**
	 * 判断参照表是否合法
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeReferenceTable(Map<String, Object> param) throws Exception {
		
		param.put("status_code", "Y");//状态码
		
		param.put("language", "CN");//语言别
		
		List<Integer> data = this.dao.query("dao.CommonSettingMapper.judgeReferenceTable", param);
		
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.get(0) > 0){
			result.put("successValue", true);
			result.put("description", "参照表信息合法");
		}else{
			result.put("successValue", false);
			result.put("description", "参照表信息不合法");
		}
		
		return result;
	}
	

	/**
	 * 将执行的结果封装成标准输出
	 * @param data
	 * @return
	 */
	private Object getResult(List data){
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.size() >= 0){
			result.put("successValue", true);
			result.put("description", "执行成功");
			result.put("data", data);
		}
		return result;
	}
	
	/**
	 * 获取账套列表
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	@Override
	public Object getBookSetList(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		List data = this.dao.query("dao.CommonSettingMapper.getBookSetList", param);
		result.put("data", data);
		result.put("successValue", true);
		result.put("description", "获取账套列表 成功");
		return result;
	}
	
	/**
	 * 获取缴款优惠条件列表
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	@Override
	public Object getPaymentPreconditionList(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "CN");
		List data = this.dao.query("dao.CommonSettingMapper.getPaymentPreconditionList", param);
		result.put("data", data);
		result.put("successValue", true);
		result.put("description", "获取缴款优惠条件列表 成功");
		return result;
	}
	
	/**
	 * 获取惯用多账期类型列表
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	@Override
	public Object getMltiAccountSetList(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "CN");
		List data = this.dao.query("dao.CommonSettingMapper.getMltiAccountSetList", param);
		result.put("data", data);
		result.put("successValue", true);
		result.put("description", "获取惯用多账期类型列表 成功");
		return result;
	}
	
	/**
	 * 获取归属法人
	 * @return
	 * @throws Exception
	 * @author liaogz
	 */
	@Override
	public Object getLegalPerson() throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		List data = this.dao.query("dao.CommonSettingMapper.getLegalPerson", null);
		result.put("data", data);
		result.put("successValue", true);
		result.put("description", "获取归属法人列表 成功");
		return result;
	}
	
	/**
     * 获取所属责任中心
     * @return
     * @throws Exception
     * @author liaogz
     */
	@Override
	public Object getResponsibilityCenter() throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		List data = this.dao.query("dao.CommonSettingMapper.getResponsibilityCenter", null);
		result.put("data", data);
		result.put("successValue", true);
		result.put("description", "获取所属责任中心列表 成功");
		return result;
	}
	
	/**
     * 获取部门主管
     * @return
     * @throws Exception
     * @author liaogz
     */
	@Override
	public Object getEmployee(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		List data = this.dao.query("dao.CommonSettingMapper.getEmployee", param);
		result.put("data", data);
		result.put("successValue", true);
		result.put("description", "获取部门主管列表 成功");
		return result;
	}
	
	/**
     * 获取归属部门
     * @return
     * @throws Exception
     * @author liaogz
     */
	@Override
	public Object getDepartment() throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		List data = this.dao.query("dao.CommonSettingMapper.getDepartment", null);
		result.put("data", data);
		result.put("successValue", true);
		result.put("description", "获取归属部门列表 成功");
		return result;
	}
	
	/**
     * 获取归属组织
     * @return
     * @throws Exception
     * @author liaogz
     */
	@Override
	public Object getBelongedOrganization(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		List data = this.dao.query("dao.CommonSettingMapper.getBelongedOrganization", null);
		result.put("data", data);
		result.put("successValue", true);
		result.put("description", "获取归属组织列表 成功");
		return result;
	}
	
	/**
     * 银行
     * @return
     * @throws Exception
     * @author liaogz
     */
	@Override
	public Object getBank() throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		List data = this.dao.query("dao.CommonSettingMapper.getBank", null);
		result.put("data", data);
		result.put("successValue", true);
		result.put("description", "银行列表 成功");
		return result;
	}
	
	/**
     * 获取单据别
     * @return
     * @throws Exception
     * @author liaogz
     */
	@Override
	public Object getDocumentSet() throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		List data = this.dao.query("dao.CommonSettingMapper.getDocumentSet", null);
		result.put("data", data);
		result.put("successValue", true);
		result.put("description", "获取单据别列表 成功");
		return result;
	}
	
	 /**
     * 获取税别编号
     * @return
     * @throws Exception
     * @author liaogz
     */
	@Override
	public Object getTaxCode() throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		List data = this.dao.query("dao.CommonSettingMapper.getTaxCode", null);
		result.put("data", data);
		result.put("successValue", true);
		result.put("description", "获取单据别列表 成功");
		return result;
	}
	
	
}
