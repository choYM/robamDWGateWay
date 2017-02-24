package com.robam.distribution.base.service;

import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * 页面的公共服务
 * 地址服务-州别、国家、省别、城市、县区、街道
 * @author liufei
 *
 */
public interface ICommonService extends DWService{
	/**
	 * 获取州别信息
	 * @return
	 * @throws Exception
	 */
	Object getContinent() throws Exception;
	
	/**
	 * 判断州别是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object judgeContinent(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取国家信息
	 * @return
	 * @throws Exception
	 */
	Object getCountry(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断国家信息是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object judgeCountry(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取省信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object getProvince(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断省别信息是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object judgeProvince(Map<String,Object> param) throws Exception;
	
	
	/**
	 * 获取城市信息
	 * @return
	 * @throws Exception
	 */
	Object getCity(Map<String,Object> param) throws Exception;
	
	
	/**
	 * 判断城市信息是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object judgeCity(Map<String,Object> param) throws Exception;
	
	
	/**
	 * 获取县区信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object getCounty(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断县区是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object judgeCounty(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取街道信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object getStreet(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取邮政编号
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object getPostcode(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断邮政编号是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object judgePostcode(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取时区
	 * @return
	 * @throws Exception
	 */
	Object getTimeZone() throws Exception;
	
	/**
	 * 判断时区是否正确
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object judgeTimeZone(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取门店或商品其他属性列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object getAttributeList(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断门店或商品其他属性是否合法
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object judgeAttribute(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取币种列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object getCurrencyList(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断币种是否合法
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object judgeCurrency(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取参照表列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object getReferenceTableList(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断参照表是否合法
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object judgeReferenceTable(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取账套列表
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	Object getBookSetList(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取缴款优惠条件列表
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	Object getPaymentPreconditionList(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取惯用多账期类型列表
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	Object getMltiAccountSetList(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取归属法人
	 * @return
	 * @throws Exception
	 * @author liaogz
	 */
    Object getLegalPerson() throws Exception;
    
    /**
     * 获取所属责任中心
     * @return
     * @throws Exception
     * @author liaogz
     */
    public Object getResponsibilityCenter() throws Exception;
	
    /**
     * 获取部门主管
     * @return
     * @throws Exception
     * @author liaogz
     */
    public Object getEmployee(Map<String, Object> param) throws Exception;
    
    /**
     * 获取归属部门
     * @return
     * @throws Exception
     * @author liaogz
     */
    public Object getDepartment() throws Exception;
    
    /**
     * 获取归属组织
     * @return
     * @throws Exception
     * @author liaogz
     */
    public Object getBelongedOrganization(Map<String, Object> param) throws Exception;
   
    /**
     * 银行
     * @return
     * @throws Exception
     * @author liaogz
     */
    public Object getBank() throws Exception;
    
    /**
     * 获取单据别
     * @return
     * @throws Exception
     * @author liaogz
     */
    public Object getDocumentSet() throws Exception;
    
    /**
     * 获取税别编号
     * @return
     * @throws Exception
     * @author liaogz
     */
    public Object getTaxCode() throws Exception;
}
