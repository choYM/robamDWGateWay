package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.digiwin.DWPaginationQueryResult;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.model.BasOrganization;
import com.robam.distribution.base.model.OrgAddress;
import com.robam.distribution.base.service.IOrganizationBasedService;

/**
 * drp_bas_m12 组织基础资料维护作业
 * @author YangJian
 * @since 2017-02-14
 *
 */
 
public class OrganizationBasedService implements IOrganizationBasedService {
	@Autowired
	private Dao dao;
	
	/**
	 * 获取组织基础详细资料
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	@Override
	public Object getOrganizationBasedDetail(Map<String, Object> param)
			throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language", "CN");
		List<BasOrganization> data = this.dao.query("dao.BaseBasOrganizationSettingMapper.getOrganizationBasedDetail", param);
		List<BasOrganization> contact = this.dao.query("dao.BaseBasOrganizationSettingMapper.selectAllContact",param);
		for (BasOrganization bas : data) {
			bas.setInformation_list(contact);
		}
		profile.put("successValue", true);
		profile.put("description", "获取组织基础详细资料");
		profile.put("data", data);
		return profile;
	}

	/**
	 * 修改组织基础资料
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	@Override
	public Object modifyOrganizationBasedDetail(Map<String, Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language", "CN");
		param.put("last_modified_date", new Date());
		this.dao.query("dao.BaseBasOrganizationSettingMapper.modifyOrganizationBasedDetail", param);
		profile.put("successValue", true);
		profile.put("description", "修改组织基础资料");
		return profile;
	}

	/**
	 * 新增通讯方式
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	@Override
	public Object addOrganizationBasedContact(BasOrganization param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.setLanguage("CN");
		List<String> list = this.dao.query("dao.BaseBasOrganizationSettingMapper.queryMaxContactId", param);
		String type = param.getCommunication_type();
		String content = param.getCommunication_content();
		String brief = param.getBrief_description();
		List<BasOrganization> org = this.dao.query("dao.BaseBasOrganizationSettingMapper.getOrganizationBasedDetail", param);
		param = org.get(0);
		String information_id = String.valueOf(Integer.parseInt(list.get(0).split("\\.")[0]));
		param.setCommunication_no(information_id);
		param.setCommunication_content(content);
		param.setCommunication_type(type);
		param.setBrief_description(brief);
		param.setLanguage("CN");
		param.setStatus_code("Y");
		Date date = new Date();
		param.setLast_modified_date(date);
		param.setData_created_date(date);
		this.dao.query("dao.BaseBasOrganizationSettingMapper.addOrganizationBasedContact", param);
		profile.put("successValue", true);
		profile.put("description", "新增通讯方式");
		return profile;
	}

	/**
	 * 修改通讯方式
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	@Override
	public Object modifyOrganizationBasedContact(Map<String, Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language", "CN");
		param.put("last_modified_date", new Date());
		this.dao.query("dao.BaseBasOrganizationSettingMapper.modifyOrganizationBasedContact", param);
		profile.put("successValue", true);
		profile.put("description", "修改通讯方式");
		return profile;
	}

	/**
	 * 删除通讯方式
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	@Override
	public Object deleteOrganizationBasedContact(Map<String, Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language", "CN");
		this.dao.query("dao.BaseBasOrganizationSettingMapper.deleteOrganizationBasedContact", param);
		profile.put("successValue", true);
		profile.put("description", "删除通讯方式");
		return profile;
	}
	
	/**
	 * 
	 * @param param查询条件
	 * @param startPage开始页码
	 * @param pageSize每页多少笔数据
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getOrganizationBasedList(Map<String, Object> param, int startPage, int pageSize)
			throws Exception {
		param.put("language", "CN");
		DWPaginationQueryResult data = this.dao.executePagination("dao.BaseBasOrganizationSettingMapper.selectOrganizationCount", "dao.BaseBasOrganizationSettingMapper.selectOrganizationLimit", param, startPage, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successValue", true);
		map.put("description", "查询数据");
		map.put("data", data);
		return map;
	}
    
	/**
	 * 新增组织资料和地址资料
	 */
	@Override
	public Map<String, Object> addOrganization(BasOrganization param) throws Exception {
		List<BasOrganization> information_list = param.getInformation_list();
		int countorg=0;
		int countaddress=0;
		for (int i = 0; i < information_list.size(); i++) {
			param.setCommunication_type(information_list.get(i).getCommunication_type());
			param.setCommunication_content(information_list.get(i).getCommunication_content());
			param.setBrief_description(information_list.get(i).getBrief_description());
			param.setIs_main_communication(information_list.get(i).getIs_main_communication());
			param.setStatus_code("Y");
			param.setLanguage("CN");
			List<Map<String, Long>> id = this.dao.query("dao.BaseBasOrganizationSettingMapper.selectId", param);
			Map<String, Long> firstRow = id.get(0);
			long totalCount = firstRow.entrySet().iterator().next().getValue();
			if (totalCount == 0) {
				param.setCommunication_no("1");
			}else {
				List<String> informationid = this.dao.query("dao.BaseBasOrganizationSettingMapper.selectinformationid", param);
				int y=Integer.parseInt(informationid.get(0)) +1;
				String information_id = String.valueOf(y);
				param.setCommunication_no(information_id);
			}
			Date date = new Date();
			param.setLast_modified_date(date);
			param.setData_created_date(date);
			countorg += this.dao.insert("dao.BaseBasOrganizationSettingMapper.addOrganization", param);
		}
		OrgAddress mainaddress = new OrgAddress();
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
		List<OrgAddress> contact_address_list = param.getContact_address_list();
		contact_address_list.add(mainaddress);
		if (contact_address_list != null) {
			for (int x = 0; x < contact_address_list.size(); x++) {
				contact_address_list.get(x).setOrganization(param.getOrganization());
				contact_address_list.get(x).setLanguage("CN");
				contact_address_list.get(x).setStatus_code("Y");
				List<Map<String, Long>> addressid = this.dao.query("dao.BaseOrgAddressMapper.selectidfromaddress", contact_address_list.get(x));
				Map<String, Long> firstid = addressid.get(0);
				long total = firstid.entrySet().iterator().next().getValue();
				if (total == 0) {
					contact_address_list.get(x).setAddress_no("1");
				}else {
					List<String> c = this.dao.query("dao.BaseOrgAddressMapper.selectmaxaddressid", contact_address_list.get(x));
					int id = Integer.parseInt(c.get(0)) + 1;
					String a = String.valueOf(id);
					contact_address_list.get(x).setAddress_no(a);
				}
				Date date = new Date();
				param.setLast_modified_date(date);
				param.setData_created_date(date);
				countaddress += this.dao.insert("dao.BaseOrgAddressMapper.addOrganizationAddress", contact_address_list.get(x));
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (countorg>0 && countaddress>0) {
			map.put("successValue", true);
			map.put("description", "数据插入成功");
		}else {
			map.put("successValue", false);
			map.put("description", "数据插入失败");
		}
		return map;
	}

	
	/**
	 * 删除组织资料
	 */
	@Override
	@Transactional
	public Map<String, Object> deleteOrganization(List<Map<String,Object>> param) throws Exception {
		Map<String, Object> deleteInfo = new HashMap<String, Object>();
		deleteInfo.put("language", "CN");
		deleteInfo.put("list", param);
		this.dao.query("dao.BaseBasOrganizationSettingMapper.deleteAddress", deleteInfo);
		this.dao.query("dao.BaseBasOrganizationSettingMapper.deleteOrganization", deleteInfo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successValue", true);
		map.put("description", "删除资料成功");
		return map;
	}

	
	/**
	 * 审核组织资料
	 */
	@Override
	public Map<String, Object> auditOrganization(List<Map<String,Object>> param, String status_code) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> deleteInfo = new HashMap<String, Object>();
		deleteInfo.put("status_code", status_code);
		deleteInfo.put("language", "CN");
		deleteInfo.put("organization", param);
		deleteInfo.put("last_modified_date", new Date());
		this.dao.query("dao.BaseBasOrganizationSettingMapper.auditOrganization", deleteInfo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successValue", true);
		map.put("description", "审核成功");
		return map;
	}
	
	/**
	 * 获取其他地址服务
	 * @param param
	 * @return 
	 * @throws Exception
	 * @author gejc
	 */
	@Override
	public Object getOrganizationAddress(Map<String, Object> param)
			throws Exception {
		if(param!=null){
			param.put("language", "CN");
		}
		List<Object> list=this.dao.query("dao.BaseOrgAddressMapper.getOrganizationAddress", param);
		boolean flag=list!=null;
		String str=flag?"成功":"失败";
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("data", list);
		profile.put("successValue", flag);
		profile.put("description", "查询数据"+str);
		return profile; 
	}

	/**
	 * 修改其他地址服务
	 * @param param
	 * @return 
	 * @throws Exception
	 * @author gejc
	 */
	@Override
	public Object modifyOrganizationAddress(Map<String, Object> param)
			throws Exception {
		Map<String,Object> profile=new HashMap<String,Object>();
		if(param!=null){
			param.put("language", "CN");
			param.put("last_modified_date", new Date());
			this.dao.query("dao.BaseOrgAddressMapper.modifyOrganizationAddress", param);
			profile.put("successValue", true);
			profile.put("description", "修改数据成功");
		}
		return profile;
	}

	/**
	 * 删除其他地址服务
	 * @param param
	 * @return 
	 * @throws Exception
	 * @author gejc
	 */
	@Override
	public Object deleteOrganizationAddress(Map<String, Object> param)
			throws Exception {
		Map<String,Object> profile=new HashMap<String,Object>();
		if(param!=null){
			param.put("language", "CN");
			this.dao.query("dao.BaseOrgAddressMapper.deleteOrganizationAddress", param);
			profile.put("successValue", true);
			profile.put("description", "删除数据成功");
		}
		return profile;
	}

	/**
	 * 新增其他地址服务
	 * @param param
	 * @return 
	 * @throws Exception
	 * @author gejc
	 */
	@Override
	public Object addOrganizationAddress(Map<String, Object> param)
			throws Exception {
		Map<String,Object> profile=new HashMap<String,Object>();
		if(param!=null){
			param.put("language", "CN");
			List<Object> item=this.dao.query("dao.BaseOrgAddressMapper.getMaxId",param );
			if(item!=null&&item.get(0)!=null){
				String str;
				if(item.get(0).toString().contains(".")){
					str=item.get(0).toString().split("\\.")[0];
				}else{
					str=item.get(0).toString();
				}
				param.put("address_no", str);
			}else{
				param.put("address_no", "1");
			}
			Date date = new Date();
			param.put("last_modified_date", date);
			param.put("data_created_date",date);
			this.dao.query("dao.BaseOrgAddressMapper.addOrganizationAddress",param);
			profile.put("successValue", true);
			profile.put("description","新增地址成功");
		}
		return profile;
	}
}
