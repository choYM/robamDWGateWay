package com.robam.distribution.base.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.digiwin.DWPaginationQueryResult;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.model.Address;
import com.robam.distribution.base.model.StoresDataAccess;
import com.robam.distribution.base.service.ISiteService;

/**
 * drp_org_a01 门店申请资料维护作业
 * @author nj
 * @since 2017-02-14
 **/
 
public class SiteService implements ISiteService{
	@Autowired
	private Dao dao;

	@Override
	public Object getSiteList(int startPage,int pageSize,Map<String,Object> param) throws Exception {
		Map<String,Object> profile=new HashMap<String,Object>();
		param.put("language","C");
		DWPaginationQueryResult data=this.dao.executePagination("dao.BaseStoresDataAcccessSettingMapper.selectCount", "dao.BaseStoresDataAcccessSettingMapper.selectLimit", param, startPage, pageSize);
		boolean flag=data!=null;
		String str=flag?"成功":"失败";
		profile.put("data", data);
		profile.put("successValue", flag);
		profile.put("description", "查询数据"+str);
		return profile;
	}

	@Override
	public Object addSite(StoresDataAccess param) throws Exception {
		Map<String,Object> profile=new HashMap<String,Object>();
		List<StoresDataAccess> information_list = param.getInformation_list();
		for (int i = 0; i < information_list.size(); i++) {
			param.setCommunication_type(information_list.get(i).getCommunication_type());
			param.setCommunication_content(information_list.get(i).getCommunication_content());
			param.setBrief_description(information_list.get(i).getBrief_description());
			param.setIs_main_communication(information_list.get(i).getIs_main_communication());
			param.setStatus_code("N");
			param.setLanguage("C");
			List<Object> all = this.dao.query("dao.BaseStoresDataAcccessSettingMapper.selectall", param);
			if (!all.isEmpty()) {
				List<String> informationid = this.dao.query("dao.BaseStoresDataAcccessSettingMapper.selectinformationid", param);
				int y=Integer.parseInt(informationid.get(0)) +1;
				String information_id = String.valueOf(y);
				param.setCommunication_no(information_id);
			}else {
				param.setCommunication_no("1");
			}
			this.dao.query("dao.BaseStoresDataAcccessSettingMapper.addSite", param);
		}
		Address mainaddress = new Address();
		mainaddress.setPostcode(param.getPostcode());
		mainaddress.setCountry_region(param.getCountry_region());
		mainaddress.setCountry_region_name(param.getCountry_region_name());
		mainaddress.setProvince(param.getProvince());
		mainaddress.setProvince_name(param.getProvince_name());
		mainaddress.setCity(param.getCity());
		mainaddress.setCity_name(param.getCity_name());
		mainaddress.setCounty_district(param.getCounty_district());
		mainaddress.setCounty_district_name(param.getCounty_district_name());
		mainaddress.setDetailed_address(param.getDetailed_address());
		mainaddress.setAddress_type("2");
		mainaddress.setPrimary_address("Y");
		List<Address> contact_address_list = param.getContact_address_list();
		contact_address_list.add(mainaddress);
		if (contact_address_list != null) {
			for (int x = 0; x < contact_address_list.size(); x++) {
				contact_address_list.get(x).setRequisition_no(param.getRequisition_no());
				contact_address_list.get(x).setStatus_code("Y");
				List<Object> queryaddress = this.dao.query("dao.BaseStoresAddressSettingMapper.selectidfromaddress",contact_address_list.get(x));
				if (!queryaddress.isEmpty()) {
					List<String> addressId = this.dao.query("dao.BaseStoresAddressSettingMapper.selectmaxaddressid", contact_address_list.get(x));
					int id=Integer.parseInt(addressId.get(0)) +1;
					String a = String.valueOf(id);
					contact_address_list.get(x).setAddress_no(a);
				}else {
					contact_address_list.get(x).setAddress_no("1");
				}
				this.dao.query("dao.BaseStoresAddressSettingMapper.addAddress", contact_address_list.get(x));
			}
		}
		boolean success=true;
		if(!success) throw new IllegalAccessError("defeat!!!");
		profile.put("successValue",success);
		return profile;
	}


	@Override
	public Object auditSite(List<Map<String,Object>> param) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> deleteInfo = new HashMap<String,Object>();
		deleteInfo.put("confirmedby", "User");
		deleteInfo.put("confirmeddate", new Date());
		deleteInfo.put("site", param);
		this.dao.query("dao.BaseStoresDataAcccessSettingMapper.auditSite", deleteInfo);
		Map<String, Object> profile = new HashMap<String, Object>();
		boolean success=true;
		if(!success) throw new IllegalAccessError("defeat!!!");
		profile.put("successValue",success);
		return profile;
	}

	@Override
	public Object deleteSite(List<Map<String,Object>> param) throws Exception {
		Map<String,Object> deleteInfo = new HashMap<String,Object>();
		deleteInfo.put("language", "C");
		deleteInfo.put("list", param);
		this.dao.query("dao.BaseStoresDataAcccessSettingMapper.deleteSite", deleteInfo);
		Map<String, Object> profile = new HashMap<String, Object>();
		boolean success=true;
		if(!success) throw new IllegalAccessError("defeat!!!");
		profile.put("successValue",success);
		return profile;
	}
	//金驰
	@Override
	public Object addAddress(Address address) throws Exception {
		List<Object> item=this.dao.query("dao.BaseStoresAddressSettingMapper.getMaxId",address);
		if(item!=null&&item.get(0)!=null){
			String str;
			if(item.get(0).toString().contains(".")){
				str=item.get(0).toString().split("\\.")[0];
			}else{
				str=item.get(0).toString();
			}
			address.setAddress_no(str);
		}else{
			address.setAddress_no("1");
		}
		Map<String, Object> profile = new HashMap<String, Object>();
		this.dao.query("dao.BaseStoresAddressSettingMapper.addAddress",address);
		profile.put("serviceName","--新增地址服务--");
		profile.put("successValue", true);
		profile.put("description","新增地址成功");
		return profile;                                                                                                
	}
	
	@Override
	public Object getAddress(Address address) throws Exception {
		Map<String,Object> profile=new HashMap<String, Object>();
		List<Address> list=this.dao.query("dao.BaseStoresAddressSettingMapper.getAddress",address);
		profile.put("serviceName","---获取地址详情服务---");
		boolean flag=list!=null;
		String str=flag?"成功":"失败";
		profile.put("successValue", flag);
		profile.put("description","获取地址"+str);
		profile.put("data",list);	
		return profile;
	}
	
	@Override
	public Object modifyAddress(Address address) throws Exception {
		Map<String,Object> profile=new HashMap<String, Object>();
		this.dao.query("dao.BaseStoresAddressSettingMapper.updateAddress",address);
		profile.put("serviceName","---修改地址服务---");
		profile.put("successValue",true);
		profile.put("description","修改地址成功");
		return profile;
	}
	@Override
	public Object deleteAddress(Address address) throws Exception {
		Map<String,Object> profile=new HashMap<String, Object>();
		this.dao.query("dao.BaseStoresAddressSettingMapper.deleteAddress",address);
		profile.put("serviceName","---删除地址服务---");
		profile.put("successValue", true);
		profile.put("description","删除地址成功");
		return profile;
	}
	//杨建
	/**
	 * 说明 : 查询门店基础资料
	 * 		根据申请单号查询详情
	 * 服务名 : getBaseSiteInfo
	 * @Param REQUEST_NO
	 */
	@Override
	public Object getBaseSiteInfo(StoresDataAccess param) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		boolean successValue = false;
		param.setLanguage("C");
		List<StoresDataAccess> list =this.dao.query("dao.BaseStoresDataAcccessSettingMapper.getBaseSiteInfo", param);
		List<StoresDataAccess> contact = this.dao.query("dao.BaseStoresDataAcccessSettingMapper.getSiteAllContact", param);
		for (StoresDataAccess storesDataAccess : list) {
			storesDataAccess.setInformation_list(contact);
		}
		if(list!=null){
			successValue = true;
		}
		profile.put("successValue", successValue);
		profile.put("description", "根据申请单号和語言別查询门店基础资料");
		profile.put("data", list);
		return profile;
	}

	/**
	 * 说明 : 修改门店基础资料
	 * 服务名 : updateBaseSiteInfo
	 * @Param : StoresDataAccess
	 */
	@Override
	public Object modifyBaseSiteInfo(StoresDataAccess param) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		param.setLanguage("C");
		this.dao.query("dao.BaseStoresDataAcccessSettingMapper.updateBaseSiteInfo",param);
		List<Address> list=this.dao.query("dao.BaseStoresAddressSettingMapper.getAddress",param);
		if (list!=null) {
			for (Address address : list) {
				if ("Y".equals(address.getPrimary_address())) {
					if ("2".equals(address.getAddress_type())) { 
						this.dao.query("dao.BaseStoresAddressSettingMapper.updateAddress",address);
					}
				}
			}
		}
		profile.put("successValue",true);
		profile.put("description", "根据申请单号和語言別修改门店基础资料");
		return profile;
	}

	/**
	 * 说明 : 修改门店其他资料 ，暫時去除此服務
	 * 服务名 : updateOtherInformation
	 * @param : StoresDataAccess
	 */
	@Override
	public Object modifyOtherInformation(StoresDataAccess param) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		param.setLanguage("C");
		this.dao.query("dao.BaseStoresDataAcccessSettingMapper.updateOtherInformation", param);
		profile.put("successValue", true);
		profile.put("description", "根据申请单号和語言別修改门店其他资料");
		return profile;
	}


	/**
	 * 说明 : 修改门店其他属性
	 * 服务名 : updateOtherAttribute
	 * @param : StoresDataAccess
	 */
	@Override
	public Object modifyOtherAttribute(StoresDataAccess param) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		param.setLanguage("C");
		this.dao.query("dao.BaseStoresDataAcccessSettingMapper.updateOtherAttribute", param);
		profile.put("successValue", true);
		profile.put("description", "根据申请单号和語言別修改门店其他屬性");
		return profile;
	}
	
	/**
	 * 说明 : 新增通讯方式
	 * 服务名 : addContact
	 * @param : StoresDataAccess
	 */
	@Override
	public Object addContact(StoresDataAccess param) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		param.setLanguage("C");
		List<String> list = this.dao.query("dao.BaseStoresDataAcccessSettingMapper.queryMaxId", param);
		String type = param.getCommunication_type();
		String content = param.getCommunication_content();
		String brief = param.getBrief_description();
		String ismain = param.getIs_main_communication();
		List<StoresDataAccess> storesData= this.dao.query("dao.BaseStoresDataAcccessSettingMapper.queryAll", param);
		param = storesData.get(0);
		Integer informationId = (Integer.parseInt(list.get(0).split("\\.")[0]));
		param.setCommunication_no(String.valueOf(informationId));
		param.setCommunication_type(type);
		param.setCommunication_content(content);
		param.setBrief_description(brief);
		if ("Y".equals(param.getIs_main_communication())) {
			ismain = "N";
		}else{
			ismain = "Y";
		}
		param.setIs_main_communication(ismain);
		this.dao.query("dao.BaseStoresDataAcccessSettingMapper.addContact", param);
		profile.put("successValue", true);
		profile.put("description", "门店新增通訊方式");
		return profile;
	}

	/**
	 * 说明 : 修改通讯方式
	 * 服务名 : updateContact
	 * @param : StoresDataAccess
	 */
	@Override
	public Object modifyContact(StoresDataAccess param) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		param.setLanguage("C");
		this.dao.query("dao.BaseStoresDataAcccessSettingMapper.updateContact", param);
		profile.put("successValue",true);
		profile.put("description", "修改成功");
		return profile;
	}

	/**
	 * 说明：删除通讯方式
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object deleteContact(StoresDataAccess param) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		param.setLanguage("C");
		this.dao.query("dao.BaseStoresDataAcccessSettingMapper.deleteContact", param);
		profile.put("successValue",true);
		profile.put("description", "删除通讯方式成功");
		return profile;
	}
}
