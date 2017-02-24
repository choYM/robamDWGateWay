package com.robam.distribution.base.service;
import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * drp_bas_f02 交易对象付款方式维护作业
 * @author gejc
 * @since 2017-02-16
 */
public interface ITransPaymentMethodService extends DWService {
	public Object getTransPaymentMethodList(Map<String,Object> param,int startPage,int pageSize) throws Exception;
	public Object modifyTransPaymentMethod(Map<String,Object> param) throws Exception;
	public Object deleteTransPaymentMethod(List<Map<String,Object>> param) throws Exception;
	public Object auditTransPaymentMethod(List<Map<String,Object>> param, String status_code) throws Exception;
	public Object addTransPaymentMethod(Map<String,Object> param) throws Exception;
	public Object judgeTransPaymentMethod(Map<String,Object> param) throws Exception;
	public Object getTransPaymentMethod(Map<String,Object> param) throws Exception;
}
