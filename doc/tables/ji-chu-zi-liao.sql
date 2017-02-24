# 分销系统：基础资料表


# 001 洲别维护作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-11
# 

DROP TABLE IF EXISTS BAS_CONTINENT;
 
CREATE TABLE BAS_CONTINENT(
CONTINENT						VARCHAR(10),        /* 洲别编号		*/
DATA_OWNER						VARCHAR(20),        /* 资料所有者	*/
DATA_OWNED_DEPARTMENT			VARCHAR(10),    	/* 资料所属部门 */
DATA_CREATED_BY					VARCHAR(20),        /* 资料建立者	*/
DATA_CREATED_DEPARTMENT			VARCHAR(10),    	/* 资料建立部门 */
DATA_CREATED_DATE				TIMESTAMP,          /* 资料创建日	*/
DATA_MODIFIED_BY				VARCHAR(20),        /* 资料修改者	*/
LAST_MODIFIED_DATE				TIMESTAMP,          /* 最近修改日	*/
STATUS_CODE						VARCHAR(10),        /* 状态代码	    */
LANGUAGE						VARCHAR(10),        /* 语言别		*/
CONTINENT_NAME					VARCHAR(80),        /* 洲别名称	    */

PRIMARY KEY (CONTINENT,LANGUAGE)
);





# 002 国别维护作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-11
# 

DROP TABLE IF EXISTS BAS_COUNTRY;

CREATE TABLE BAS_COUNTRY(
STATUS_CODE						VARCHAR(10),			/* 状态码		 */  
COUNTRY_REGION					VARCHAR(10),      		/* 国家地区编号  */
CONTINENT						VARCHAR(10),			/* 所在洲别		 */							
INTERNATIONAL_PHONE_CODE		VARCHAR(10),			/* 国际电话编号	 */									
DATA_OWNER						VARCHAR(20),          	/* 资料所有者	 */
DATA_OWNED_DEPARTMENT			VARCHAR(10),      		/* 资料所属部门  */
DATA_CREATED_BY					VARCHAR(20),          	/* 资料建立者	 */
DATA_CREATED_DEPARTMENT			VARCHAR(10),      		/* 资料建立部门  */
DATA_CREATED_DATE				TIMESTAMP,           	/* 资料创建日	 */
DATA_MODIFIED_BY				VARCHAR(20),          	/* 资料修改者	 */
LAST_MODIFIED_DATE				TIMESTAMP,           	/* 最近修改日	 */
TIME_ZONE_NO					VARCHAR(10),          	/* 时区		     */
LANGUAGE						VARCHAR(10),          	/* 语言别		 */
COUNTRY_REGION_NAME				VARCHAR(80),      		/* 国家地区名称  */
CONTINENT_NAME					VARCHAR(80),          	/* 洲别名称	     */
TIME_ZONE_SIMPLENO				VARCHAR(10),          	/* 时区简码	     */
REPRESENTATIONAL_CITY			VARCHAR(80),          	/* 代表城市	     */

PRIMARY KEY (COUNTRY_REGION,LANGUAGE)
);





# 003 省别维护作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-11
# 

DROP TABLE IF EXISTS BAS_PROVINCE;

CREATE TABLE BAS_PROVINCE(
STATUS_CODE						VARCHAR(10),	     /* 状态码			*/		
COUNTRY_REGION					VARCHAR(10),   		 /* 所在国家地区    */
PROVINCE						VARCHAR(10),       	 /* 省别编号	    */
DATA_OWNER						VARCHAR(20),         /* 资料所有者	    */
DATA_OWNED_DEPARTMENT			VARCHAR(10),   	     /* 资料所属部门    */
DATA_CREATED_BY					VARCHAR(20),         /* 资料建立者	    */
DATA_CREATED_DEPARTMENT			VARCHAR(10),         /* 资料建立部门    */
DATA_CREATED_DATE				TIMESTAMP,           /* 资料创建日	    */
DATA_MODIFIED_BY				VARCHAR(20),         /* 资料修改者	    */
LAST_MODIFIED_DATE				TIMESTAMP,           /* 最近修改日	    */
LANGUAGE						VARCHAR(10),         /* 语言别		    */
COUNTRY_REGION_NAME				VARCHAR(80),         /* 国家地区名称    */
PROVINCE_NAME					VARCHAR(80),         /* 省别名称	    */

PRIMARY KEY (COUNTRY_REGION,PROVINCE,LANGUAGE)
);





# 004 市别维护作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-11
# 

DROP TABLE IF EXISTS BAS_CITY;

CREATE TABLE BAS_CITY(
STATUS_CODE					VARCHAR(10),	    /* 状态码		  */		
COUNTRY_REGION				VARCHAR(10),    	/* 所在国家地区   */
PROVINCE					VARCHAR(10),        /* 省别编号	      */
CITY						VARCHAR(10),        /* 城市编号	      */
DATA_OWNER					VARCHAR(20),        /* 资料所有者	  */
DATA_OWNED_DEPARTMENT		VARCHAR(10),    	/* 资料所属部门   */
DATA_CREATED_BY				VARCHAR(20),        /* 资料建立者	  */
DATA_CREATED_DEPARTMENT		VARCHAR(10),    	/* 资料建立部门   */
DATA_CREATED_DATE			TIMESTAMP,          /* 资料创建日	  */
DATA_MODIFIED_BY			VARCHAR(20),        /* 资料修改者	  */
LAST_MODIFIED_DATE			TIMESTAMP,          /* 最近修改日	  */
LANGUAGE					VARCHAR(10),        /* 语言别	Y	  */
COUNTRY_REGION_NAME			VARCHAR(80),    	/* 国家地区名称   */
PROVINCE_NAME				VARCHAR(80),        /* 省别名称	      */
CITY_NAME					VARCHAR(80),        /* 城市名称	      */

PRIMARY KEY (COUNTRY_REGION,PROVINCE,CITY,LANGUAGE)
);





# 005 县/行政区域维护作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-11		
# 

DROP TABLE IF EXISTS BAS_COUNTY_DISTRICT;	
 
CREATE TABLE BAS_COUNTY_DISTRICT(
STATUS_CODE						VARCHAR(10),		/* 状态码		*/	
COUNTRY_REGION					VARCHAR(10),    	/* 国家地区编号 */
PROVINCE						VARCHAR(10),        /* 省别编号	    */
CITY							VARCHAR(10),        /* 城市编号	    */
COUNTY_DISTRICT					VARCHAR(10),        /* 县区编号	    */
DATA_OWNER						VARCHAR(20),        /* 资料所有者	*/
DATA_OWNED_DEPARTMENT			VARCHAR(10),    	/* 资料所属部门 */
DATA_CREATED_BY					VARCHAR(20),        /* 资料建立者	*/
DATA_CREATED_DEPARTMENT			VARCHAR(10),    	/* 资料建立部门 */
DATA_CREATED_DATE				TIMESTAMP,          /* 资料创建日	*/
DATA_MODIFIED_BY				VARCHAR(20),        /* 资料修改者	*/
LAST_MODIFIED_DATE				TIMESTAMP,          /* 最近修改日	*/
LANGUAGE						VARCHAR(10),        /* 语言别		*/
COUNTRY_REGION_NAME				VARCHAR(80),        /* 国家地区名称 */
PROVINCE_NAME					VARCHAR(80),        /* 省别名称	    */
CITY_NAME						VARCHAR(80),        /* 城市名称	    */
COUNTY_DISTRICT_NAME			VARCHAR(80),        /* 县区名称	    */

PRIMARY KEY (COUNTRY_REGION,PROVINCE,CITY,COUNTY_DISTRICT,LANGUAGE)
);





# 006 街道维护作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-11
# 

DROP TABLE IF EXISTS BAS_STREET;

CREATE TABLE BAS_STREET( 
STATUS_CODE					VARCHAR(10),         /* 状态码		  */
COUNTRY_REGION				VARCHAR(10),     	 /* 国家地区编号  */
PROVINCE					VARCHAR(10),         /* 省别编号	  */
CITY						VARCHAR(10),         /* 城市编号	  */
COUNTY_DISTRICT				VARCHAR(10),         /* 县区编号	  */
STREET						VARCHAR(10),         /* 街道编号	  */
DATA_OWNER					VARCHAR(20),         /* 资料所有者	  */
DATA_OWNED_DEPARTMENT		VARCHAR(10),     	 /* 资料所属部门  */
DATA_CREATED_BY				VARCHAR(20),         /* 资料建立者	  */
DATA_CREATED_DEPARTMENT		VARCHAR(10),         /* 资料建立部门  */
DATA_CREATED_DATE			TIMESTAMP,           /* 资料创建日	  */
DATA_MODIFIED_BY			VARCHAR(20),         /* 资料修改者	  */
LAST_MODIFIED_DATE			TIMESTAMP,           /* 最近修改日	  */
LANGUAGE					VARCHAR(10),         /* 语言别		  */
COUNTRY_REGION_NAME			VARCHAR(80),         /* 国家地区名称  */
PROVINCE_NAME				VARCHAR(80),         /* 省别名称	  */
CITY_NAME					VARCHAR(80),         /* 城市名称	  */
COUNTY_DISTRICT_NAME		VARCHAR(80),         /* 县区名称	  */
STREET_NAME					VARCHAR(80),         /* 街道名称	  */

PRIMARY KEY (COUNTRY_REGION,PROVINCE,CITY,COUNTY_DISTRICT,STREET,LANGUAGE)
);





# 007 邮政编码维护作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-11
# 

DROP TABLE IF EXISTS BAS_POSTCODE;

CREATE TABLE BAS_POSTCODE(
STATUS_CODE						VARCHAR(10),         /* 状态码		  */
COUNTRY_REGION					VARCHAR(10),     	 /* 国家地区编号  */
POSTCODE						VARCHAR(12),         /* 邮政编号	  */
PROVINCE						VARCHAR(10),         /* 省别编号	  */
CITY							VARCHAR(10),         /* 城市编号	  */
COUNTY_DISTRICT					VARCHAR(10),         /* 县区编号	  */
DATA_OWNER						VARCHAR(20),         /* 资料所有者	  */
DATA_OWNED_DEPARTMENT			VARCHAR(10),     	 /* 资料所属部门  */
DATA_CREATED_BY					VARCHAR(20),         /* 资料建立者	  */
DATA_CREATED_DEPARTMENT			VARCHAR(10),     	 /* 资料建立部门  */
DATA_CREATED_DATE				TIMESTAMP,           /* 资料创建日	  */
DATA_MODIFIED_BY				VARCHAR(20),         /* 资料修改者	  */
LAST_MODIFIED_DATE				TIMESTAMP,           /* 最近修改日	  */
OTHER_ADDRESS					VARCHAR(255),        /* 其他地址	  */
SERIAL_NO						DECIMAL(10,0),       /* 序号		  */
LANGUAGE						VARCHAR(10),         /* 语言别		  */
COUNTRY_REGION_NAME				VARCHAR(80),         /* 国家说明	  */
PROVINCE_NAME					VARCHAR(80),         /* 省别名称	  */
CITY_NAME						VARCHAR(80),         /* 城市名称	  */
COUNTY_DISTRICT_NAME			VARCHAR(80),         /* 县区名称	  */
POSTCODE_DESCRIPTION					VARCHAR(80),     	 /* 邮政编号说明  */

PRIMARY KEY (COUNTRY_REGION,SERIAL_NO,LANGUAGE)
);





# 008 组织基础资料维护作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-11
# 

DROP TABLE IF EXISTS BAS_ORGANIZATION;

CREATE TABLE BAS_ORGANIZATION(
STATUS_CODE							VARCHAR(10),		/* 状态码	*/
ORG_CODE							VARCHAR(10),		/* 组织编号	*/
BUSINESS_REGISTRATION_NO_			VARCHAR(20),		/* 税号	*/
ORG_SIMPLE_CODE						VARCHAR(5),			/* 组织简号	*/
LISTED_COMPANY_NO					VARCHAR(10),		/* 上市柜公司编号	*/
OFFICE_CALENDAR_CATEGORY			VARCHAR(10),		/* 办公行事历对应类别	*/
EXCLUSIVE_NATIONAL_FUNCTIONS		VARCHAR(10),		/* 专属国家地区功能	*/
CONTACT_PERSON_ID					VARCHAR(20),		/* 联络对象识别码	*/
DATE_DISPLAY_FORMAT					VARCHAR(10),		/* 日期显示格式	*/
DATA_OWNER							VARCHAR(20),		/* 资料所有者	*/
DATA_OWNER_DEPT						VARCHAR(10),		/* 资料所属部门	*/
DATA_CREATED_BY						VARCHAR(20),		/* 資料录入者	*/
DEPARTMENT							VARCHAR(10),		/* 资料录入部门	*/
DATA_CREATED_DATE					TIMESTAMP,			/* 资料创建日	*/
MODIFIED_BY							VARCHAR(20),		/* 资料更改者	*/
LAST_MODIFIED_DATE					TIMESTAMP,			/* 最近更改日	*/
MAIN_CURRENCY_NO					VARCHAR(10),		/* 主币种编号	*/
LEGAL_ENTITY_ATTRIBUTION			VARCHAR(10),		/* 法人归属	*/
TIME_ZONE_NO						VARCHAR(10),		/* 时区	*/
BUSINESS_REGISTRATION_NO			VARCHAR(20),		/* 工商登记号	*/
CORPORATION_REPRESENTATIVE			VARCHAR(80),		/* 法人代表	*/
REGISTER_CAPITAL					VARCHAR(80),		/* 注册资本	*/
LEGAL_ENTITY						VARCHAR(10),		/* 法人否	*/
NUMBER_AMOUNT_DISPLAY_FORMAT		VARCHAR(10),		/* 数字/金额显示格式	*/
CUSTOMER_VENDOR_NO					VARCHAR(10),		/* 据点对应客户/供应商编号	*/
STORES_STATE						VARCHAR(10),		/* 门店状态	*/
INDUSTRY_TYPE						VARCHAR(10),		/* 业态	*/
OPENING_DATE						DATE,				/* 开业日期	*/
CLOSED_SHOP_DATE					DATE,				/* 闭店日期	*/
STORE_AREA							DECIMAL(20,6),		/* 门店面积	*/
SALES_AREA							VARCHAR(10),		/* 销售片区域	*/
OTHER_ATTR1							VARCHAR(10),		/* 其它属性1	*/
OTHER_ATTR2							VARCHAR(10),		/* 其它属性2	*/
OTHER_ATTR3							VARCHAR(10),		/* 其它属性3	*/
OTHER_ATTR4							VARCHAR(10),		/* 其它属性4	*/
OTHER_ATTR5							VARCHAR(10),		/* 其它属性5	*/
OTHER_ATTR6							VARCHAR(10),		/* 其它属性6	*/
OTHER_ATTR7							VARCHAR(10),		/* 其它属性7	*/
OTHER_ATTR8							VARCHAR(10),		/* 其它属性8	*/
OTHER_ATTR9							VARCHAR(10),		/* 其它属性9	*/
OTHER_ATTR10						VARCHAR(10),		/* 其它属性10	*/
APPLICATION_ORG						VARCHAR(10),		/* 应用组织	*/
IS_OPERATING_ORG					VARCHAR(1),			/* 营运据点	*/
IS_DEPARTMENT_ORG					VARCHAR(1),			/* 部门组织	*/
IS_SALES_ORG						VARCHAR(1),			/* 销售组织	*/
IS_PURCHASE_ORG						VARCHAR(1),			/* 采购组织	*/
IS_LOGISTICS_ORG					VARCHAR(1),			/* 物流组织	*/
IS_SETTLING_ORG						VARCHAR(1),			/* 结算组织	*/
IS_MARKETING_CENTER					VARCHAR(1),			/* 营销中心	*/
IS_DISTRIBUTION_CENTER				VARCHAR(1),			/* 配送中心	*/
IS_PURCHASE_CENTER					VARCHAR(1),			/* 采购中心	*/
IS_STORE							VARCHAR(1),			/* 门店	*/
IS_HEADQUARTERS						VARCHAR(1),			/* 总部	*/
IS_AGENCY_COMPANY					VARCHAR(1),			/* 代理公司	*/
IS_CITY_COMPANY						VARCHAR(1),			/* 城市公司	*/
IS_SHOP								VARCHAR(1),			/* 店铺	*/
IS_OFFICE							VARCHAR(1),			/* 办事处	*/
PROVINCE							VARCHAR(10),		/* 省份	*/
CITY								VARCHAR(10),		/* 城市	*/
COUNTY								VARCHAR(10),		/* 县区	*/
STREET								VARCHAR(10),		/* 街道	*/
DETAILED_ADDRESS					VARCHAR(255),		/* 详细地址	*/
POSTCODE							VARCHAR(10),		/* 邮政编码	*/
THE_CONTACT							VARCHAR(80),		/* 联系人	*/
CONTACT_NO							VARCHAR(80),		/* 联系电话	*/
MOBILE_NO							VARCHAR(80),		/* 手机号	*/
Email								VARCHAR(80),		/* Email	*/
COUNTER_QTY							DECIMAL(5),			/* 展柜数量	*/
REFERENCE_TABLE_NO					VARCHAR(10),		/* 基础资料参考表	*/
ORG_TYPE							VARCHAR(10),		/* 门店类型	*/
STORE_TYPE							VARCHAR(10),		/* 店铺类型	*/
TRADING_TYPE						VARCHAR(10),		/* 交易类型	*/
PLADFORM_CODE						VARCHAR(10),		/* 平台编号	*/
PLADFORM_NAME						VARCHAR(255),		/* 平台名称	*/
IS_OPENED_INVOICE					VARCHAR(1),			/* 未出货可开发票	*/
CORRESPONDING_COUSTOMER_CODE		VARCHAR(10),		/* 对应客户编号	*/
BELONGED_CHANNEL_CODE				VARCHAR(10),		/* 所属渠道编号	*/
BELONGED_ORG_CODE					VARCHAR(10),		/* 所属组织	*/
DELIVERY_ORG						VARCHAR(10),		/* 发货组织	*/
INCOME_ATTRIBUTABLE_ORG				VARCHAR(10),		/* 收入归属组织	*/
IS_AUTO_CONFIRM						VARCHAR(1),			/* 自动审单	*/
LANGUAGE							VARCHAR(10),			/* 语言别	*/
ORG_SHORT_NAME						VARCHAR(500),		/* 简称	*/
ORG_LONG_NAME						VARCHAR(500),		/* 对外全称	*/
HOME_ORGANIZATION_NAME				VARCHAR(255),		/* 归属组织名称	*/
CHANNEL_NAME						VARCHAR(255),		/* 归属渠道名称	*/
SALES_AREA_NAME						VARCHAR(255),		/* 归属片区名称	*/
NATION_NAME							VARCHAR(255),		/* 国家地区名称	*/
PROVINCE_NAME						VARCHAR(255),		/* 省份名称	*/
CITY_NAME							VARCHAR(255),		/* 城市名称	*/
COUNTY_NAME							VARCHAR(255),		/* 县区名称	*/
STREET_NAME							VARCHAR(255),		/* 街道名称	*/
LEGAL_NAME							VARCHAR(255),		/* 归属法人名称	*/
TIME_ZONE_NAME						VARCHAR(255),		/* 时区名称	*/
REFERENCE_TABLE_NAME				VARCHAR(255),		/* 基础资料参照表名称	*/
MAIN_CURRENCY_NAME					VARCHAR(255),		/* 主币别名称	*/
CUSTOMER_VENDOR_NAME				VARCHAR(255),		/* 门店对应客户/供应商名称	*/
OTHER_ATTR1_NAME					VARCHAR(255),		/* 其他属性一名称	*/
OTHER_ATTR2_NAME					VARCHAR(255),		/* 其他属性二名称	*/
OTHER_ATTR3_NAME					VARCHAR(255),		/* 其他属性三名称	*/
OTHER_ATTR4_NAME					VARCHAR(255),		/* 其他属性四名称	*/
OTHER_ATTR5_NAME					VARCHAR(255),		/* 其他属性五名称	*/
OTHER_ATTR6_NAME					VARCHAR(255),		/* 其他属性六名称	*/
OTHER_ATTR7_NAME					VARCHAR(255),		/* 其他属性七名称	*/
OTHER_ATTR8_NAME					VARCHAR(255),		/* 其他属性八名称	*/
OTHER_ATTR9_NAME					VARCHAR(255),		/* 其他属性九名称	*/
OTHER_ATTR10_NAME					VARCHAR(255),		/* 其他属性十名称	*/

PRIMARY KEY (ORG_CODE,LANGUAGE)
);





# 009 组织/门店层级建立
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS ORGANIZATION_HIERARCHY;

CREATE TABLE ORGANIZATION_HIERARCHY(
STATUS_CODE							VARCHAR(10),		/* 状态码	*/
APPLICATION_NO						VARCHAR(10),		/* 申请编号	*/
APPLICATION_DATE					DATE,				/* 申请日期	*/
CHANGE_TYPE							VARCHAR(10),		/* 变更类型	*/
ORG_TPE								VARCHAR(10),		/* 组织类型	*/
TOP_ORG_CODE						VARCHAR(10),		/* 最上层组织	*/
VERSION								VARCHAR(10),		/* 版本	*/
VALID_DATE							DATE,				/* 生效日期	*/
INVALID_DATE						DATE,				/* 失效日期	*/
DATA_OWNER							VARCHAR(20),		/* 资料所有者	*/
DATA_OWN_DEPARTMENT					VARCHAR(10),		/* 资料所属部门	*/
DATA_INPUTER						VARCHAR(20),		/* 資料录入者	*/
DATA_INPUT_DEPARTMENT				VARCHAR(10),		/* 资料录入部门	*/
DATA_CREATE_DATE					TIMESTAMP,			/* 资料创建日	*/
DATA_MODIFICATOR					VARCHAR(20),		/* 资料更改者	*/
RECENTLY_MODIFY_DATE				TIMESTAMP,			/* 最近更改日	*/
DATA_CONFIRMED_BY					VARCHAR(20),		/* 资料审核者	*/
DATA_CONFIRMED_DATE					TIMESTAMP,			/* 数据审核日	*/
TOP_ORG_NAME						VARCHAR(255),		/* 最上层组织名称	*/

PRIMARY KEY (APPLICATION_NO)
);





# 010 组织结构查询
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS ORGANIZATION_HIERARCHY_LINE1;
 
CREATE TABLE ORGANIZATION_HIERARCHY_LINE1(
ORG_TYPE							VARCHAR(10),		/* 组织类型	*/
TOP_ORG_CODE						VARCHAR(10),		/* 最上层组织	*/
VERSION								VARCHAR(10),		/* 版本	*/
ORG_CODE							VARCHAR(10),		/* 组织编号	*/
HIGHER_ORG_CODE						VARCHAR(10),		/* 上级组织编号	*/
VALID_DATE							DATE,				/* 生效日期	*/
INVALID_DATE						DATE,				/* 失效日期	*/
APPLICATION_NO						VARCHAR(10),		/* 申请编号	*/
TOP_ORG_NAME						VARCHAR(255),		/* 最上层组织名称	*/
ORG_NAME							VARCHAR(255),		/* 组织名称	*/
HIGHER_ORG_NAME						VARCHAR(255),		/* 上级组织名称	*/

PRIMARY KEY (ORG_TYPE,TOP_ORG_CODE,VERSION,ORG_CODE,HIGHER_ORG_CODE)
);





# 011 币别维护作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS BAS_CURRENCY;

CREATE TABLE BAS_CURRENCY(
STATUS_CODE						varchar(10),          /* 状态码		   */
CURRENCY						varchar(10),          /* 币种编号	   */
COUNTRY_REGION					varchar(12),          /* 国家地区	   */
MINIMUM_DENOMINATION			varchar(10),          /* 最小面额	   */
CURRENCY_SYMBOL					varchar(10),          /* 货币符号	   */
DATA_OWNER						varchar(20),          /* 资料所有者	   */
DATA_OWNED_DEPARTMENT			varchar(10),      	  /* 资料所属部门  */
DATA_CREATED_BY					varchar(20),          /* 资料建立者	   */
DATA_CREATED_DEPARTMENT			varchar(10),      	  /* 资料建立部门  */
DATA_CREATED_DATE				TIMESTAMP,       	  /* 资料创建日	   */
DATA_MODIFIED_BY				varchar(20),          /* 资料修改者	   */
LAST_MODIFIED_DATE				TIMESTAMP,            /* 最近修改日	   */
LANGUAGE					    varchar(10),          /* 语言别		   */
CURRENCY_DESCRIPTION			varchar(80),          /* 币种说明	   */
COUNTRY_REGION_NAME				varchar(80),          /* 国家地区名称  */

PRIMARY KEY (CURRENCY,LANGUAGE)
);





# 012 使用币种资料档
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS BAS_CURRENCY_USED;

CREATE TABLE BAS_CURRENCY_USED(
DATA_OWNER							varchar(20),			/* 资料所有者			*/		
DATA_OWNED_DEPARTMENT				varchar(10),            /* 资料所属部门		    */
DATA_CREATED_BY						varchar(20),            /* 资料建立者			*/
DATA_CREATED_DEPARTMENT				varchar(10),            /* 资料建立部门		    */
DATA_CREATED_DATE					TIMESTAMP,              /* 资料创建日			*/
DATA_MODIFIED_BY					varchar(20),            /* 资料修改者			*/
LAST_MODIFIED_DATE					TIMESTAMP,              /* 最近修改日			*/
STATUS_CODE							varchar(10),            /* 状态码				*/
REFERENCE_TABLE_NO					varchar(5 ),            /* 参照表编号			*/
CURRENCY_USED						varchar(10),            /* 使用币种			    */
PRICE_DECIMAL						DECIMAL(10,0),          /* 单价小数字数		    */
AMOUNT_DECIMAL						DECIMAL(10,0),          /* 金额小数字数		    */
EXCHANGE_RATE_ACCURACY				DECIMAL(10,0),          /* 汇率计算精度		    */
COST_PRICE_DECIMAL					DECIMAL(10,0),          /* 成本单价小数字数	    */
COST_AMOUNT_DECIMAL					DECIMAL(10,0),          /* 成本金额小数字数	    */
LANGUAGE							varchar(10),            /* 语言别				*/
CURRENCY_USED_DESCRIPTION			varchar(80),            /* 使用币种说明		    */
REFERENCE_TABLE_DESCRIPTION			varchar(80),            /* 参照表说明			*/

PRIMARY KEY (REFERENCE_TABLE_NO,CURRENCY_USED,LANGUAGE)
);





# 013 日汇率数据维护
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS BAS_DAILY_EXCHRATE;

CREATE TABLE BAS_DAILY_EXCHRATE(
REFERENCE_TABLE_NO							varchar(5),				/* 参照表编号			*/	
BASE_CURRENCY								varchar(10),            /* 基础币种		        */
DATE										date,                   /* 日期			        */
DEFAULT_CROSS_EXCHRATE						varchar(1),             /* 自动默认交叉汇率     */
DATA_OWNER									varchar(20),            /* 资料所有者		    */
DATA_OWNED_DEPARTMENT						varchar(10),            /* 资料所属部门	        */
DATA_CREATED_BY								varchar(20),            /* 资料建立者		    */
DATA_CREATED_DEPARTMENT						varchar(10),            /* 资料建立部门	        */
DATA_CREATED_DATE							TIMESTAMP,              /* 资料创建日		    */
DATA_MODIFIED_BY							varchar(20),            /* 资料修改者		    */
LAST_MODIFIED_DATE							TIMESTAMP,              /* 最近修改日		    */
STATUS_CODE									varchar(10),            /* 状态码			    */
TRANSACTION_CURRENCY						varchar(10),            /* 交易币种		        */
BANK_BUYING_EXCHRATE						DECIMAL(20,10),         /* 银行买入汇率	        */
BANK_SELLING_EXCHRATE						DECIMAL(20,10),         /* 银行卖出汇率	        */
BANK_AVERAGE_EXCHRATE						DECIMAL(20,10),         /* 银行中价汇率	        */
CUSTOMS_BUYING_EXCHRATE						DECIMAL(20,10),         /* 海关买入汇率	        */
CUSTOMS_SELLING_EXCHRATE					DECIMAL(20,10),         /* 海关卖出汇率	        */
UPDATE_TIME									TIMESTAMP,              /* 更新时间		        */
UPDATE_MODE									varchar(10),            /* 更新方式		        */
TRANSACTION_CURRENCY_LOT					DECIMAL(20,6),          /* 交易货币批量	        */
EXCHRATE_INPUT_MODE							varchar(10),            /* 汇率录入方式	        */
REFERENCE_TABLE_DESCRIPTION					varchar(80),            /* 参照表说明		    */
LANGUAGE									varchar(1),             /* 语言别			    */
BASE_CURRENCY_DESCRIPTION					varchar(80),            /* 基础币种说明	        */
TRANSACTION_CURRENCY_DESCRIPTION			varchar(80),            /* 交易币种说明	        */

PRIMARY KEY (REFERENCE_TABLE_NO,BASE_CURRENCY,DATE,TRANSACTION_CURRENCY,LANGUAGE)
);





# 014 月汇率数据维护
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS BAS_MONTHLY_EXCHRATE;  

CREATE TABLE BAS_MONTHLY_EXCHRATE(		
REFERENCE_TABLE_NO						varchar(5),				/* 参照表编号		*/		
TRANSACTION_CURRENCY					varchar(10),            /* 交易币种		    */
BASE_CURRENCY							varchar(10),            /* 基础币种		    */
PERIOD									varchar(10),            /* 年月			    */
BANK_BUYING_EXCHRATE					DECIMAL(20,10),         /* 银行买入汇率	    */
BANK_SELLING_EXCHRATE					DECIMAL(20,10),         /* 银行卖出汇率	    */
BANK_AVERAGE_EXCHRATE					DECIMAL(20,10),         /* 银行中价汇率	    */
CUSTOMS_BUYING_EXCHRATE					DECIMAL(20,10),         /* 海关买入汇率	    */
CUSTOMS_SELLING_EXCHRATE				DECIMAL(20,10),         /* 海关卖出汇率	    */
CLOSING_FOREIGN_EXCHRATE				DECIMAL(20,10),         /* 外汇收盘汇率	    */
REEVALUATION_EXCHANGE_RATE				DECIMAL(20,10),         /* 重评价汇率		*/
UPDATE_TIME								TIMESTAMP,              /* 更新时间		    */
UPDATE_MODE								varchar(10),            /* 更新方式		    */
TRANSACTION_CURRENCY_LOT				DECIMAL(20,6),          /* 交易货币批量	    */
EXCHRATE_INPUT_MODE						varchar(10),            /* 汇率录入方式	    */
DATA_OWNER								varchar(20),            /* 资料所有者		*/
DATA_OWNED_DEPARTMENT					varchar(10),            /* 资料所属部门	    */
DATA_CREATED_BY							varchar(20),            /* 资料建立者		*/
DATA_CREATED_DEPARTMENT					varchar(10),            /* 资料建立部门	    */
DATA_CREATED_DATE						TIMESTAMP,              /* 资料创建日		*/
DATA_MODIFIED_BY						varchar(20),            /* 资料修改者		*/
LAST_MODIFIED_DATE						TIMESTAMP,              /* 最近修改日		*/
STATUS_CODE								varchar(10),            /* 状态码			*/
LANGUAGE								varchar(10),            /* 语言别			*/
TRANSACTION_CURRENCY_DESCRIPTION		varchar(80),            /* 交易币种说明	    */
BASE_CURRENCY_DESCRIPTION				varchar(80),            /* 基础币种说明	    */
REFERENCE_TABLE_DESCRIPTION				varchar(80),            /* 参照表说明		*/

PRIMARY KEY (REFERENCE_TABLE_NO,TRANSACTION_CURRENCY,BASE_CURRENCY,PERIOD,LANGUAGE)
);





# 015 单位资料维护档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS BAS_UNIT;

CREATE TABLE BAS_UNIT(			
STATUS_CODE					varchar(10),			/* 状态码			*/				
UNIT						varchar(10),            /* 单位编号	        */
DECIMAL_NUMBER				DECIMAL(5,0),           /* 小数字数	        */
UNIT_TYPE					varchar(10),            /* 单位类型	        */
ROUNDING_TYPE				varchar(10),			/* 舍入类型		    */
AREA_UNIT					varchar(10),            /* 面积单位	        */
VOLUME_UNIT					varchar(10),            /* 体积单位	        */
DATA_OWNER					varchar(20),            /* 资料所有者	    */
DATA_OWNED_DEPARTMENT		varchar(10),            /* 资料所属部门     */
DATA_CREATED_BY				varchar(20),            /* 资料建立者	    */
DATA_CREATED_DEPARTMENT		varchar(10),            /* 资料建立部门     */
DATA_CREATED_DATE			TIMESTAMP,              /* 资料创建日	    */
DATA_MODIFIED_BY			varchar(20),            /* 资料修改者	    */
LAST_MODIFIED_DATE			TIMESTAMP,              /* 最近修改日	    */
LANGUAGE					varchar(10),            /* 语言别		    */
UNIT_DESCRIPTION			varchar(80),            /* 单位说明	        */

PRIMARY KEY (UNIT,LANGUAGE)
);





# 016 单位转换率资料维护档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS UNIT_CONVERSION_RATE;

CREATE TABLE UNIT_CONVERSION_RATE(			
STATUS_CODE							varchar(10),			/* 状态码			*/				
SOURCE_UNIT							varchar(10),            /* 来源单位		    */
SOURCE_QUANTITY						DECIMAL(20,6),          /* 来源数量		    */
DESTINATION_UNIT					varchar(10),            /* 目的单位		    */
DESTINATION_QUANTITY				DECIMAL(20,6),          /* 目的数量		    */
DATA_OWNER							varchar(20),            /* 资料所有者		*/
DATA_OWNED_DEPARTMENT				varchar(10),            /* 资料所属部门	    */
DATA_CREATED_BY						varchar(20),            /* 资料建立者		*/
DATA_CREATED_DEPARTMENT				varchar(10),            /* 资料建立部门	    */
DATA_CREATED_DATE					TIMESTAMP,              /* 资料创建日		*/
DATA_MODIFIED_BY					varchar(20),            /* 资料修改者		*/
LAST_MODIFIED_DATE					TIMESTAMP,              /* 最近修改日		*/
LANGUAGE							varchar(10),            /* 语言别			*/
SOURCE_UNIT_DESCRIPTION				varchar(80),            /* 来源单位说明	    */
DESTINATION_UNIT_DESCRIPTION		varchar(80),            /* 目的单位说明	    */

PRIMARY KEY (SOURCE_UNIT,DESTINATION_UNIT,LANGUAGE)
);





# 017 日历维护作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS BAS_CALENDAR;

CREATE TABLE BAS_CALENDAR(			
STATUS_CODE				VARCHAR(10),            /* 状态码		*/
DATE					DATE,            		/* 日期		    */
WHAT_DAY				VARCHAR(10),            /* 星期		    */
LUNAR_CALENDAR_DATE		VARCHAR(40),        	/* 农历日期	    */
CLASS1					VARCHAR(10),            /* 分类一		*/
CLASS2					VARCHAR(10),            /* 分类二		*/
CLASS3					VARCHAR(10),            /* 分类三		*/
CLASS4					VARCHAR(10),            /* 分类四		*/
CLASS5					VARCHAR(10),            /* 分类五		*/
PERIOD					DECIMAL(5,0),           /* 期别		    */
QUARTER					DECIMAL(5,0),           /* 季别		    */
WEEK					DECIMAL(5,0),           /* 周别		    */
MONTH					DECIMAL(5,0),           /* 月份		    */
MONTH_WEEK				DECIMAL(5,0),           /* 月周		    */
DATA_OWNER				VARCHAR(20),        	/* 资料所有者	*/
DATA_OWNER_DEPT			VARCHAR(10),    		/* 资料所有部门 */
DATA_CREATED_BY			VARCHAR(20),        	/* 资料录入者	*/
DEPARTMENT				VARCHAR(10),    		/* 资料录入部门 */
DATA_CREATED_DATE	    TIMESTAMP,         		/* 资料创建日	*/
MODIFIED_BY				VARCHAR(20),        	/* 资料更改者	*/
LAST_MODIFIED_DATE		TIMESTAMP,         		/* 最近更改日	*/

PRIMARY KEY (DATE)
);





# 018 行事历假日设置作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS BAS_HOLIDAY_CALENDAR;

CREATE TABLE BAS_HOLIDAY_CALENDAR(			
CALENDAR_REFERENCE_TABLE		VARCHAR(5),      	  /* 行事历参照表号	*/
DATE							DATE,      			  /* 日期			*/
LEAVE_TYPE_NO					VARCHAR(10),      	  /* 休假类型编码	*/
REASON_DESCRIPTION				VARCHAR(80),          /* 原因说明		*/
CLASS1							VARCHAR(10),          /* 分类一			*/
CLASS2							VARCHAR(10),          /* 分类二			*/
CLASS3							VARCHAR(10),          /* 分类三			*/
CLASS4							VARCHAR(10),          /* 分类四			*/
CLASS5							VARCHAR(10),          /* 分类五			*/
STATUS_CODE							VARCHAR(10),          /* 状态码			*/
DATA_OWNER						VARCHAR(20),          /* 资料所有者		*/
DATA_OWN_DEPARTMENT				VARCHAR(10),          /* 资料所有部门	*/
DATA_INPUTER					VARCHAR(20),          /* 资料录入者		*/
DATA_INPUT_DEPARTMENT			VARCHAR(10),          /* 资料录入部门	*/
DATA_CREATE_DATE				TIMESTAMP,            /* 资料创建日		*/
DATA_MODIFICATOR				VARCHAR(20),          /* 资料更改者		*/
RECENTLY_MODIFY_DATE			TIMESTAMP,            /* 最近更改日		*/
YEAR							DECIMAL(5,0),         /* 年度			*/
LANGUAGE						VARCHAR(10),          /* 語言別			*/
LEAVE_TYPE_DESCRIPTION			VARCHAR(255),         /* 休假类型说明	*/
REFERENCE_TABLE_DESCRIPTION		VARCHAR(255),         /* 参照表说明		*/

PRIMARY KEY (CALENDAR_REFERENCE_TABLE,DATE,YEAR,LANGUAGE)
);





# 019 行事历维护作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS BAS_CALENDAR_EVENT;

CREATE TABLE BAS_CALENDAR_EVENT(			                 
STATUS_CODE								VARCHAR(10),     	 /* 状态码			*/
CALENDAR_REFERENCE_TABLE			VARCHAR(5),      	 /* 行事历参照表号	*/
CALENDAR_TYPE						VARCHAR(10),     	 /* 行事历类别		*/
DATE								DATE,     			 /* 日期			*/
LEAVE_TYPE_NO						VARCHAR(10),     	 /* 休假类型编码	*/
RESON_NAME							VARCHAR(80),         /* 原因说明		*/
PERIOD								DECIMAL(5,0),        /* 期别			*/
QUARTER								DECIMAL(5,0),        /* 季别			*/
WEEK								DECIMAL(5,0),        /* 周别			*/
WORK_HOURS							DECIMAL(15,3),       /* 上班时数		*/
CLASS1								VARCHAR(10),         /* 分类一			*/
CLASS2								VARCHAR(10),         /* 分类二			*/
CLASS3								VARCHAR(10),         /* 分类三			*/
CLASS4								VARCHAR(10),         /* 分类四			*/
CLASS5								VARCHAR(10),         /* 分类五			*/
YEAR								DECIMAL(5,0),        /* 年度			*/
DATA_OWNER							VARCHAR(20),         /* 资料所有者		*/
DATA_OWN_DEPARTMENT					VARCHAR(10),     	 /* 资料所有部门	*/
DATA_INPUTER						VARCHAR(20),         /* 资料录入者		*/
DATA_INPUT_DEPARTMENT				VARCHAR(10),         /* 资料录入部门	*/
DATA_CREATE_DATE					TIMESTAMP,           /* 资料创建日		*/
DATA_MODIFICATOR					VARCHAR(20),         /* 资料更改者		*/
RECENTLY_MODIFY_DATE				TIMESTAMP,           /* 最近更改日		*/
MONTH								DECIMAL(5,0),        /* 月份			*/
MONTH_WEEK							DECIMAL(5,0),        /* 月周			*/
LANGUAGE							VARCHAR(10),         /* 語言別			*/
LEAVE_TYPE_DESCRIPTION				VARCHAR(255),    		 /* 休假类型说明	*/
REFERENCE_TABLE_DESCRIPTION			VARCHAR(255),          /* 参照表说明		*/

PRIMARY KEY (CALENDAR_REFERENCE_TABLE,CALENDAR_TYPE,DATE,YEAR,LANGUAGE)
);





# 020 单一税别设置作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS BAS_SINGLE_TAX;

CREATE TABLE BAS_SINGLE_TAX(			                 
DATA_OWNER							varchar(20),               /* 资料所有者								*/					
DATA_OWNED_DEPARTMENT				varchar(10),               /* 资料所属部门						        */
DATA_CREATED_BY						varchar(20),               /* 资料建立者							    */
DATA_CREATED_DEPARTMENT				varchar(10),               /* 资料建立部门						        */
DATA_CREATED_DATE					TIMESTAMP,                 /* 资料创建日							    */
DATA_MODIFIED_BY					varchar(20),               /* 资料修改者							    */
LAST_MODIFIED_DATE					TIMESTAMP,                 /* 最近修改日							    */
STATUS_CODE							varchar(10),               /* 状态码								    */
REFERENCE_TABLE_NO					varchar(5 ),               /* 参照表编号							    */
TAX_CODE							varchar(10),               /* 税种编号							        */
TAX_PROPERTY						varchar(10),               /* 税种性质							        */
IS_TAX								varchar(1),                /* 含税否								    */
TAX_RATE							DECIMAL(5,2),              /* 税率								        */
FORMULA_NO							varchar(10),               /* 公式编号							        */
TAX_TYPE							varchar(1),                /* 课税种类：1.应税 2.零税率 3.免税	        */
TAX_APPLICATION						varchar(1),                /* 税种应用：1.正常税率,2.依料件设置	        */
PRINT_INVOICE_VAT					varchar(10),               /* 并增值税打印发票					        */
FIXED_TAX							DECIMAL(20,6),             /* 固定税额							        */
LANGUAGE							varchar(10),               /* 语言别								    */
TAX_DESCRIPTION						varchar(80),               /* 税种说明							        */
REFERENCE_TABLE_DESCRIPTION			varchar(80),               /* 参照表说明							    */

PRIMARY KEY (REFERENCE_TABLE_NO,TAX_CODE,LANGUAGE)
);





# 021 收款条件维护档
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS BAS_COLLECTION_TERM;   

CREATE TABLE BAS_COLLECTION_TERM(			                 
DATA_OWNER								varchar(20),			/* 资料所有者				*/				
DATA_OWNED_DEPARTMENT					varchar(10),            /* 资料所属部门			    */
DATA_CREATED_BY							varchar(20),            /* 资料建立者				*/
DATA_CREATED_DEPARTMENT					varchar(10),            /* 资料建立部门			    */
DATA_CREATED_DATE						TIMESTAMP,              /* 资料创建日				*/
DATA_MODIFIED_BY						varchar(20),            /* 资料修改者				*/
LAST_MODIFIED_DATE						TIMESTAMP,              /* 最近修改日				*/
STATUS_CODE								varchar(10),            /* 状态码					*/
COLLECTION_TERM							varchar(10),            /* 收款条件编号			    */
PAYMENT_TYPE_PROPERTY					varchar(10),            /* 款别性质				    */
PAYMENT_FAVORABLE_TERM					varchar(10),            /* 惯用缴款优惠条件		    */
IS_DEPOSIT_RECEIVED						varchar(1),             /* 订金收取否				*/
IS_TRANSACTION_PAID						varchar(1),             /* 现付交易否				*/
PAYABLE_STARTING_STANDARD				varchar(10),            /* 应收付款起算基准		    */
RECEIVABLE_PAYMENT_SEASON				DECIMAL(5,0),           /* 应收付款日加(季)		    */
RECEIVABLE_PAYMENT_MONTH				DECIMAL(5,0),           /* 应收付款日加(月)		    */
RECEIVABLE_PAYMENT_DAY					DECIMAL(5,0),           /* 应收付款日加(日)		    */
ACCOUNT_STARTING_STANDARD				varchar(10),            /* 账款兑现起算基准		    */
ACCOUNT_REDEEM_SEASON					DECIMAL(5,0),           /* 账款兑现日加(季)		    */
ACCOUNT_REDEEM_MONTH					DECIMAL(5,0),           /* 账款兑现日加(月)		    */
ACCOUNT_REDEEM_DATE						DECIMAL(5,0),           /* 账款兑现日加(日)		    */
MULTIPLE_ACCTPERIOD_TYPE				varchar(10),            /* 惯用多账期类型　		    */
FINAL_PAYMENT_TYPE						varchar(1),             /* 尾款性质				    */
LANGUAGE								varchar(10),            /* 语言别					*/
COLLECTION_TERM_DESCRIPTION				varchar(80),            /* 收款条件说明			    */
PAYMENT_FAVORABLETERM_DESCRIPTION		varchar(80),            /* 惯用缴款优惠条件说明	    */
MULTIPLE_ACCTPERIOD_DISCRIPTION			varchar(80),        	/* 惯用多账期说明			*/
FINALPAYMENT_TYPE_DISCRIPTION			varchar(80),        	/* 尾款性质说明			    */

PRIMARY KEY (COLLECTION_TERM,LANGUAGE)
);





# 022 付款条件维护档
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS BAS_PAYMENT_TERM;  

CREATE TABLE BAS_PAYMENT_TERM(			                 
DATA_OWNER							varchar(20),			/* 资料所有者				*/				
DATA_OWNED_DEPARTMENT				varchar(10),            /* 资料所属部门			    */
DATA_CREATED_BY						varchar(20),            /* 资料建立者				*/
DATA_CREATED_DEPARTMENT				varchar(10),            /* 资料建立部门			    */
DATA_CREATED_DATE					TIMESTAMP,              /* 资料创建日				*/
DATA_MODIFIED_BY					varchar(20),            /* 资料修改者				*/
LAST_MODIFIED_DATE					TIMESTAMP,              /* 最近修改日				*/
STATUS_CODE							varchar(10),            /* 状态码					*/
PAYMENT_TERM						varchar(10),            /* 付款条件编号			    */
PAYMENT_TYPE						varchar(10),            /* 款别性质				    */
PAYMENT_FAVORABLE_TERM				varchar(10),            /* 惯用缴款优惠条件		    */
IS_DEPOSIT_RECEIVED					varchar(1),             /* 订金收取否				*/
IS_TRANSACTION_PAID					varchar(1),             /* 现付交易否				*/
PAYABLE_STARTING_STANDARD			varchar(10),            /* 应付付款起算基准		    */
RECEIVABLE_PAYMENT_SEASON			DECIMAL(5,0),           /* 应付付款日加(季)		    */
RECEIVABLE_PAYMENT_MONTH			DECIMAL(5,0),           /* 应付付款日加(月)		    */
RECEIVABLE_PAYMENT_DAY				DECIMAL(5,0),           /* 应付付款日加(日)		    */
ACCOUNT_STARTING_STANDARD			varchar(10),            /* 账款兑现起算基准		    */
ACCOUNT_REDEEM_SEASON				DECIMAL(5,0),           /* 账款兑现日加(季)		    */
ACCOUNT_REDEEM_MONTH				DECIMAL(5,0),           /* 账款兑现日加(月)		    */
ACCOUNT_REDEEM_DATE					DECIMAL(5,0),           /* 账款兑现日加(日)		    */
MULTI_ACCOUNT_TYPE					varchar(10),            /* 惯用多账期类型　		    */
DOWN_PAYMENT_TYPE					varchar(1),             /* 尾款性质				    */
LANGUAGE							varchar(10),            /* 语言别					*/
PAYMENT_TERM_DESCRIPTION			varchar(80),            /* 付款条件说明			    */
PAYMENT_FAVORABLETERM_DESCRIPTION	varchar(80),            /* 惯用缴款优惠条件说明	    */
MULTI_ACCOUNT_DESCRIPTION			varchar(80),            /* 惯用多账期说明			*/

PRIMARY KEY (PAYMENT_TERM,LANGUAGE)
);





# 023 应用分类码维护 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS BAS_APPLICATION_CATEGORY;  

CREATE TABLE BAS_APPLICATION_CATEGORY(			                 
STATUS_CODE				varchar(10),				  /* 状态码			    */
ACC						varchar(7),                   /* 应用分类		    */
ACC_CODE				varchar(10),                  /* 应用分类码		    */
UPPER_ACC_CODE			varchar(10),              	  /* 上层应用分类码	    */
REFERENCE_FIELD1		varchar(40),                  /* 参考字段一		    */
REFERENCE_FIELD2		varchar(40),                  /* 参考字段二		    */
REFERENCE_FIELD3		varchar(40),                  /* 参考字段三		    */
REFERENCE_FIELD4		varchar(40),                  /* 参考字段四		    */
REFERENCE_FIELD5		varchar(40),                  /* 参考字段五		    */
REFERENCE_FIELD6		varchar(40),                  /* 参考字段六		    */
REFERENCE_FIELD7		varchar(40),                  /* 参考字段七		    */
REFERENCE_FIELD8		varchar(40),                  /* 参考字段八		    */
REFERENCE_FIELD9		varchar(40),                  /* 参考字段九		    */
REFERENCE_FIELD10		varchar(40),                  /* 参考字段十		    */
REFERENCE_FIELD11		varchar(40),              	  /* 参考字段十一	    */
REFERENCE_FIELD12		varchar(40),                  /* 参考字段十二	    */
REFERENCE_FIELD13		varchar(40),                  /* 参考字段十三	    */
REFERENCE_FIELD14		varchar(40),                  /* 参考字段十四	    */
REFERENCE_FIELD15		varchar(40),                  /* 参考字段十五	    */
REFERENCE_FIELD16		varchar(40),                  /* 参考字段十六	    */
REFERENCE_FIELD17		varchar(40),                  /* 参考字段十七	    */
REFERENCE_FIELD18		varchar(40),                  /* 参考字段十八	    */
REFERENCE_FIELD19		varchar(40),                  /* 参考字段十九	    */
REFERENCE_FIELD20		varchar(40),                  /* 参考字段二十	    */
DATA_OWNER				varchar(20),                  /* 资料所有者			*/
DATA_OWNED_DEPARTMENT	varchar(10),                  /* 资料所属部门		*/
DATA_CREATED_BY			varchar(20),                  /* 资料建立者			*/
DATA_CREATED_DEPARTMENT	varchar(10),                  /* 资料建立部门		*/
DATA_CREATED_DATE		TIMESTAMP,                    /* 资料创建日			*/
DATA_MODIFIED_BY		varchar(20),                  /* 资料修改者			*/
LAST_MODIFIED_DATE		TIMESTAMP,                    /* 最近修改日			*/
LANGUAGE				varchar(10),                  /* 语言别				*/
ACC_DESCRIPTION			varchar(80),                  /* 应用分类码说明		*/
UPPER_ACC_DESCRIPTION	varchar(80),                  /* 上层应用分类码说明	*/

PRIMARY KEY (ACC,ACC_CODE,LANGUAGE)
);





# 024 参照表资料维护档   
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS BAS_REFERENCE_TABLE ;

CREATE TABLE BAS_REFERENCE_TABLE(			                  
STATUS_CODE									varchar(1),				/* 状态码			*/				
REFERENCE_TABLE_NO							varchar(5),             /* 参照表编号	    */
DATA_OWNER									varchar(20),            /* 资料所有者	    */
DATA_OWNED_DEPARTMENT						varchar(10),            /* 资料所属部门     */
DATA_CREATED_BY								varchar(20),            /* 资料建立者	    */
DATA_CREATED_DEPARTMENT						varchar(10),            /* 资料建立部门     */
DATA_CREATED_DATE							TIMESTAMP,              /* 资料创建日	    */
DATA_MODIFIED_BY							varchar(20),            /* 资料修改者	    */
LAST_MODIFIED_DATE							TIMESTAMP,              /* 最近修改日	    */
LANGUAGE									varchar(10),            /* 语言别		    */
REFERENCE_TABLE_DESCRIPTION					varchar(80),            /* 参照表说明	    */

PRIMARY KEY (REFERENCE_TABLE_NO,LANGUAGE)
);





# 025 组织/门店资料申请档
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-15
# 

DROP TABLE IF EXISTS  BAS_ORGANIZATION_REQUISITION;

CREATE TABLE  BAS_ORGANIZATION_REQUISITION(
OPERATION_ORGANIZATION						varchar(10),         /* 营运组织	            */		
APPLICATION_ORGANIZATION					varchar(10),         /* 应用组织			    */
REQUISITION_NO								varchar(20),         /* 申请单号			    */
REQUISITION_DATE							date,                /* 申请日期			    */
REQUISITION_TYPE							varchar(10),         /* 申请类别			    */
APPLICANT									varchar(20),         /* 申请人员			    */
REQUESTED_DEPARTMENT						varchar(10),         /* 申请部门			    */
ORGANIZATION								varchar(10),         /* 组织编号			    */
ORGANIZATION_FUNCTION						varchar(10),         /* 组织职能			    */
ORGANIZATION_SIMPLE_CODE					varchar(5),          /* 组织简码			    */
IS_LEGAL_PERSON								varchar(1),          /* 法人否				    */
LEGAL_PERSON								varchar(10),         /* 归属法人			    */
COUNTRY_REGION								varchar(10),         /* 所属国家地区		    */
TAX_CODE									varchar(20),         /* 税号				    */
LISTED_COMPANY_NO							varchar(10),         /* 上市公司编号		    */
BUSINESS_REGISTRATION_NO					varchar(20),         /* 工商登记号			    */
LEGAL_REPRESENTATIVE						varchar(80),         /* 法人代表			    */
REGISTER_CAPITAL							varchar(80),         /* 注册资本			    */
EXCLUSIVE_NATIONAL_FUNCTIONS				varchar(10),         /* 专属国家地区功能	    */
MAIN_CURRENCY_NO							varchar(10),         /* 主币种编号			    */
TIME_ZONE_NO								varchar(10),         /* 时区				    */
DATE_DISPLAY_FORMAT							varchar(10),         /* 日期显示格式		    */
NUMBER_AMOUNT_FORMAT						varchar(10),         /* 数字/金额显示格式	    */
REFERENCE_TABLE_NO							varchar(10),         /* 参照表编号			    */
CUSTOMER_VENDOR_NO							varchar(10),         /* 客户/供货商编号		    */
STORE_STATE									varchar(10),         /* 门店状态			    */
INDUSTRY_TYPE								varchar(10),         /* 业态				    */
OPENING_DATE								date,                /* 开业日期			    */
CLOSING_DATE								date,                /* 闭店日期			    */
STORE_AREA									DECIMAL(20,6),       /* 门店面积			    */
COUNTER_QUANTITY							DECIMAL(5),          /* 展柜数量			    */
SALES_AREA									varchar(10),         /* 销售片区			    */
BELONGED_CHANNEL							varchar(10),         /* 归属渠道			    */
BELONGED_ORGANIZATION						varchar(10),         /* 归属组织			    */
PROVINCE									varchar(10),         /* 省别				    */
CITY										varchar(10),         /* 城市				    */
COUNTY_DISTRICT								varchar(10),         /* 县区				    */
STREET										varchar(10),         /* 街道				    */
DETAILED_ADDRESS							varchar(255),        /* 详细地址			    */
POSTCODE									varchar(10),         /* 邮政编号			    */
CONTACT										varchar(80),         /* 联系人				    */
CONTACT_NO									varchar(80),         /* 联系电话			    */
MOBILE_NO									varchar(80),         /* 手机号				    */
EMAIL										varchar(80),         /* 电子邮箱			    */
OTHER_ATTRIBUTE1							varchar(10),         /* 其他属性1			    */
OTHER_ATTRIBUTE2							varchar(10),         /* 其他属性2			    */
OTHER_ATTRIBUTE3							varchar(10),         /* 其他属性3			    */
OTHER_ATTRIBUTE4							varchar(10),         /* 其他属性4			    */
OTHER_ATTRIBUTE5							varchar(10),         /* 其他属性5			    */
OTHER_ATTRIBUTE6							varchar(10),         /* 其他属性6			    */
OTHER_ATTRIBUTE7							varchar(10),         /* 其他属性7			    */
OTHER_ATTRIBUTE8							varchar(10),         /* 其他属性8			    */
OTHER_ATTRIBUTE9							varchar(10),         /* 其他属性9			    */
OTHER_ATTRIBUTE10							varchar(10),         /* 其他属性10			    */
STATUS_CODE									varchar(10),         /* 状态码				    */
DATA_OWNER									varchar(20),         /* 资料所有者			    */
DATA_OWNED_DEPARTMENT						varchar(10),         /* 资料所属部门		    */
DATA_CREATED_BY								varchar(20),         /* 资料建立者			    */
DATA_CREATED_DEPARTMENT						varchar(10),         /* 资料建立部门		    */
DATA_CREATED_DATE							TIMESTAMP,           /* 资料创建日			    */
DATA_MODIFIED_BY							varchar(20),         /* 资料修改者			    */
LAST_MODIFIED_DATE							TIMESTAMP,           /* 最近修改日			    */
DATA_CONFIRMED_BY							varchar(20),         /* 资料审核者			    */
DATA_CONFIRMED_DATE							TIMESTAMP,           /* 资料审核日			    */
VALID										varchar(1 ),         /* 资料有效码			    */
LANGUAGE									varchar(10),         /* 语言别				    */
ORGANIZATION_NAME							varchar(80),         /* 组织名称			    */
ORGANIZATION_FULL_NAME						varchar(80),         /* 组织全称			    */
OPERATION_ORGANIZATION_NAME					varchar(80),         /* 营运组织名称		    */
APPLICANT_NAME								varchar(80),         /* 申请人员姓名		    */
REQUESTED_DEPARTMENT_NAME					varchar(80),         /* 申请部门名称		    */
APPLICATION_ORGANIZATION_NAME				varchar(80),         /* 应用组织名称		    */
BELONGED_ORGANIZATION_NAME					varchar(80),         /* 归属组织名称		    */
BELONGED_CHANNEL_NAME						varchar(80),         /* 归属渠道名称		    */
SALES_AREA_NAME								varchar(80),         /* 销售片区名称		    */
COUNTRY_REGION_NAME							varchar(80),         /* 国家地区名称		    */
PROVINCE_NAME								varchar(80),         /* 省别名称			    */
CITY_NAME									varchar(80),         /* 城市名称			    */
COUNTY_DISTRICT_NAME						varchar(80),         /* 县区名称			    */
STREET_NAME									varchar(80),         /* 街道名称			    */
LEGAL_PERSON_NAME							varchar(80),         /* 归属法人名称		    */
TIME_ZONE_DESCRIPTION						varchar(255),        /* 时区说明			    */
REFERENCE_TABLE_DESCRIPTION					varchar(80),         /* 参照表说明			    */
MAIN_CURRENCY_DESCRIPTION					varchar(80),         /* 主币种说明			    */
CUSTOMER_VENDOR_NAME						varchar(80),         /* 客户/供货商名称		    */
OTHER_ATTRIBUTE1_DESCRIPTION				varchar(80),         /* 其他属性一说明		    */
OTHER_ATTRIBUTE2_DESCRIPTION				varchar(80),         /* 其他属性二说明		    */
OTHER_ATTRIBUTE3_DESCRIPTION				varchar(80),         /* 其他属性三说明		    */
OTHER_ATTRIBUTE4_DESCRIPTION				varchar(80),         /* 其他属性四说明		    */
OTHER_ATTRIBUTE5_DESCRIPTION				varchar(80),         /* 其他属性五说明		    */
OTHER_ATTRIBUTE6_DESCRIPTION				varchar(80),         /* 其他属性六说明		    */
OTHER_ATTRIBUTE7_DESCRIPTION				varchar(80),         /* 其他属性七说明		    */
OTHER_ATTRIBUTE8_DESCRIPTION				varchar(80),         /* 其他属性八说明		    */
OTHER_ATTRIBUTE9_DESCRIPTION				varchar(80),         /* 其他属性九说明		    */
OTHER_ATTRIBUTE10_DESCRIPTION				varchar(80),         /* 其他属性十说明		    */
COMMUNICATION_NO							varchar(20),         /* 通信方式编号		    */
IS_MAIN_COMMUNICATION						varchar(1),          /* 主要通信方式		    */
COMMUNICATION_TYPE							varchar(10),         /* 通信类型			    */
BRIEF_DESCRIPTION							varchar(80),         /* 简要说明			    */
COMMUNICATION_CONTENT						varchar(255),        /* 通信内容			    */

PRIMARY KEY (REQUISITION_NO,COMMUNICATION_NO)
);





# 026 组织/门店申请地址档
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-15
# 

DROP TABLE IF EXISTS  BAS_ORGREQUISITION_ADDRESS;     

CREATE TABLE  BAS_ORGREQUISITION_ADDRESS(
STATUS_CODE						varchar(10),        /*状态码		        */			
ADDRESS_NO						varchar(20),		/*联络地址编号	*/		
ADDRESS_TYPE					varchar(10),		/*地址类型（默认2）		*/	
BRIEF_DESCRIPTION				varchar(80),        /*简要说明				*/
COUNTRY_REGION					varchar(10),        /*国家地区				*/
POSTCODE						varchar(12),        /*邮政编号				*/
PROVINCE						varchar(10),        /*省别					*/
CITY							varchar(10),        /*城市					*/
COUNTY_DISTRICT					varchar(10),        /*县区					*/
STREET							varchar(10),        /*街道					*/
DETAILED_ADDRESS				varchar(255),		/*详细地址				*/	
LANGUAGE						varchar(10),        /*语言别				*/	
COUNTRY_REGION_NAME				varchar(80),        /*国家地区名称			*/
PROVINCE_NAME					varchar(80),        /*省别名称				*/
CITY_NAME						varchar(80),        /*城市名称				*/
COUNTY_DISTRICT_NAME			varchar(80),        /*县区名称				*/
STREET_NAME						varchar(80),		/*街道名称				*/		
REQUISITION_NO					varchar(20),        /*申请单号				*/
PRIMARY_ADDRESS					varchar(255),   	/* 主要联络地址   */
DATA_OWNER						varchar(20),    	/* 资料所有者	  */
DATA_OWNED_DEPARTMENT			varchar(10),    	/* 资料所属部门   */
DATA_CREATED_BY					varchar(20),    	/* 资料建立者	  */
DATA_CREATED_DEPARTMENT			varchar(10),    	/* 资料建立部门   */
DATA_CREATED_DATE				TIMESTAMP,      	/* 资料创建日	  */
DATA_MODIFIED_BY				varchar(20),     	/* 资料修改者	  */
LAST_MODIFIED_DATE				TIMESTAMP,      	/* 最近修改日	  */
IS_PRIMARY_ADDRESS				varchar(1),         /* 主要联络地址	    */

PRIMARY KEY (ADDRESS_NO,REQUISITION_NO)
);





# 027 组织/门店基础资料档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-15
# 

DROP TABLE IF EXISTS BAS_ORGANIZATION;

CREATE TABLE BAS_ORGANIZATION(
STATUS_CODE								varchar(10),          /*状态码	            */          			
ORGANIZATION							varchar(10),          /*组织编号			*/
ORGANIZATION_FUNCTION					varchar(10),          /*组织职能			*/
ORGANIZATION_SIMPLE_CODE				varchar(5),           /*组织简码			*/
IS_LEGAL_PERSON							varchar(1),           /*法人否				*/
LEGAL_PERSON							varchar(10),          /*法人归属			*/
COUNTRY_REGION							varchar(10),          /*所属国家地区		*/
TAX_CODE								varchar(20),          /*税号				*/
LISTED_COMPANY_NO						varchar(10),          /*上市公司编号		*/
BUSINESS_REGISTRATION_NO				varchar(20),          /*工商登记号			*/
LEGAL_REPRESENTATIVE					varchar(80),          /*法人代表			*/
REGISTER_CAPITAL						varchar(80),          /*注册资本			*/
EXCLUSIVE_NATIONAL_FUNCTIONS			varchar(10),          /*专属国家地区功能	*/
MAIN_CURRENCY_NO						varchar(10),          /*主币种编号			*/
TIME_ZONE_NO							varchar(10),          /*时区				*/
DATE_DISPLAY_FORMAT						varchar(10),          /*日期显示格式		*/
NUMBER_AMOUNT_FORMAT					varchar(10),          /*数字/金额显示格式	*/
REFERENCE_TABLE_NO						varchar(10),          /*参照表编号			*/
CUSTOMER_VENDOR_NO						varchar(10),          /*客户/供货商编号		*/
STORE_STATE								varchar(10),          /*门店状态			*/
INDUSTRY_TYPE							varchar(10),          /*业态				*/
OPENING_DATE							date,                 /*开业日期			*/
CLOSING_DATE							date,                 /*闭店日期			*/
STORE_AREA								DECIMAL(20,6),        /*门店面积			*/
COUNTER_QUANTITY						DECIMAL(5),           /*展柜数量			*/
SALES_AREA								varchar(10),          /*销售片区			*/
BELONGED_CHANNEL_NO						varchar(10),          /*归属渠道编号		*/
BELONGED_ORGANIZATION					varchar(10),          /*归属组织			*/
PROVINCE								varchar(10),          /*省别				*/
CITY									varchar(10),          /*城市				*/
COUNTY_DISTRICT							varchar(10),          /*县区				*/
STREET									varchar(10),          /*街道				*/
DETAILED_ADDRESS						varchar(255),         /*详细地址			*/
POSTCODE								varchar(10),          /*邮政编号			*/
CONTACT									varchar(80),          /*联系人				*/
CONTACT_NO								varchar(80),          /*联系电话			*/
MOBILE_NO								varchar(80),          /*手机号				*/
EMAIL									varchar(80),          /*电子邮箱			*/
PLADFORM_NO								varchar(10),          /*平台编号			*/
PLADFORM_NAME							varchar(80),          /*平台名称			*/
IS_OPENED_INVOICE						varchar(1),           /*未出货可开发票		*/
INCOME_ORGANIZATION						varchar(10),          /*收入归属组织		*/
IS_AUTO_CONFIRM							varchar(1),           /*自动审核否			*/
OTHER_ATTRIBUTE1						varchar(10),          /*其他属性1			*/
OTHER_ATTRIBUTE2						varchar(10),          /*其他属性2			*/
OTHER_ATTRIBUTE3						varchar(10),          /*其他属性3			*/
OTHER_ATTRIBUTE4						varchar(10),          /*其他属性4			*/
OTHER_ATTRIBUTE5						varchar(10),          /*其他属性5			*/
OTHER_ATTRIBUTE6						varchar(10),          /*其他属性6			*/
OTHER_ATTRIBUTE7						varchar(10),          /*其他属性7			*/
OTHER_ATTRIBUTE8						varchar(10),          /*其他属性8			*/
OTHER_ATTRIBUTE9						varchar(10),          /*其他属性9			*/
OTHER_ATTRIBUTE10						varchar(10),          /*其他属性10			*/
APPLICATION_ORGANIZATION				varchar(10),          /*应用组织			*/
DATA_OWNER								varchar(20),          /*资料所有者			*/
DATA_OWNED_DEPARTMENT					varchar(10),          /*资料所属部门		*/
DATA_CREATED_BY							varchar(20),          /*资料建立者			*/
DATA_CREATED_DEPARTMENT					varchar(10),          /*资料建立部门		*/
DATA_CREATED_DATE						TIMESTAMP,            /*资料创建日			*/
DATA_MODIFIED_BY						varchar(20),          /*资料修改者			*/
LAST_MODIFIED_DATE						TIMESTAMP,            /*最近修改日			*/
LANGUAGE								varchar(10),          /*语言别				*/
ORGANIZATION_NAME						varchar(80),          /*组织名称			*/
ORGANIZATION_FULL_NAME					varchar(80),          /*组织全称			*/
BELONGED_ORGANIZATION_NAME				varchar(80),          /*归属组织名称		*/
INCOME_ORGANIZATION_NAME				varchar(80),          /*收入归属组织名称	*/
APPLICATION_ORGANIZATION_NAME			varchar(80),          /*应用组织名称		*/
BELONGED_CHANNEL_NAME					varchar(80),          /*归属渠道名称		*/
SALES_AREA_NAME							varchar(80),          /*销售片区名称		*/
COUNTRY_REGION_NAME						varchar(80),          /*国家地区名称		*/
PROVINCE_NAME							varchar(80),          /*省别名称			*/
CITY_NAME								varchar(80),          /*城市名称			*/
COUNTY_DISTRICT_NAME					varchar(80),          /*县区名称			*/
STREET_NAME								varchar(80),          /*街道名称			*/
LEGAL_PERSON_NAME						varchar(80),          /*归属法人名称		*/
TIME_ZONE_DESCRIPTION					varchar(255),         /*时区说明			*/
REFERENCE_TABLE_DESCRIPTION				varchar(80),          /*参照表说明			*/
MAIN_CURRENCY_DESCRIPTION				varchar(80),          /*主币种说明			*/
CUSTOMER_VENDOR_NAME					varchar(80),          /*客户/供货商名称		*/
OTHER_ATTRIBUTE1_DESCRIPTION			varchar(80),          /*其他属性一说明		*/
OTHER_ATTRIBUTE2_DESCRIPTION			varchar(80),          /*其他属性二说明		*/
OTHER_ATTRIBUTE3_DESCRIPTION			varchar(80),          /*其他属性三说明		*/
OTHER_ATTRIBUTE4_DESCRIPTION			varchar(80),          /*其他属性四说明		*/
OTHER_ATTRIBUTE5_DESCRIPTION			varchar(80),          /*其他属性五说明		*/
OTHER_ATTRIBUTE6_DESCRIPTION			varchar(80),          /*其他属性六说明		*/
OTHER_ATTRIBUTE7_DESCRIPTION			varchar(80),          /*其他属性七说明		*/
OTHER_ATTRIBUTE8_DESCRIPTION			varchar(80),          /*其他属性八说明		*/
OTHER_ATTRIBUTE9_DESCRIPTION			varchar(80),          /*其他属性九说明		*/
OTHER_ATTRIBUTE10_DESCRIPTION			varchar(80),          /*其他属性十说明		*/
COMMUNICATION_NO						varchar(20),          /*通信方式编号		*/
IS_MAIN_COMMUNICATION					varchar(1),           /*主要通信方式		*/
COMMUNICATION_TYPE						varchar(10),          /*通信类型			*/
BRIEF_DESCRIPTION						varchar(80),          /*简要说明			*/
COMMUNICATION_CONTENT					varchar(255),         /*通信内容			*/

PRIMARY KEY (ORGANIZATION,LANGUAGE,COMMUNICATION_NO)
);




# 028 组织/门店地址资料档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-15
# 

DROP TABLE IF EXISTS BAS_ORGANIZATION_ADDRESS;

CREATE TABLE BAS_ORGANIZATION_ADDRESS(
STATUS_CODE							varchar(10),              /*状态码					*/				
ADDRESS_NO							varchar(20),			  /*联络地址编号	*/
ADDRESS_TYPE						varchar(10),			  /*地址类型（默认2）		*/
BRIEF_DESCRIPTION					varchar(80),              /*简要说明				*/
COUNTRY_REGION						varchar(10),              /*国家地区				*/
POSTCODE							varchar(12),              /*邮政编号				*/
PROVINCE							varchar(10),              /*省别					*/
CITY								varchar(10),              /*城市					*/
COUNTY_DISTRICT						varchar(10),              /*县区					*/
STREET								varchar(10),              /*街道					*/
DETAILED_ADDRESS					varchar(255),             /*详细地址				*/
DATA_OWNER							varchar(20),              /*资料所有者				*/
DATA_OWNED_DEPARTMENT				varchar(10),              /*资料所属部门			*/
DATA_CREATED_BY						varchar(20),              /*资料建立者				*/
DATA_CREATED_DEPARTMENT				varchar(10),              /*资料建立部门			*/
DATA_CREATED_DATE					TIMESTAMP,                /*资料创建日				*/
DATA_MODIFIED_BY					varchar(20),              /*资料修改者				*/
LAST_MODIFIED_DATE					TIMESTAMP,			      /*最近修改日				*/
LANGUAGE							varchar(10),              /*语言别					*/
COUNTRY_REGION_NAME					varchar(80),              /*国家地区名称			*/
PROVINCE_NAME						varchar(80),              /*省别名称				*/
CITY_NAME							varchar(80),              /*城市名称				*/
COUNTY_DISTRICT_NAME				varchar(80),              /*县区名称				*/
STREET_NAME							varchar(80),              /*街道名称				*/
ORGANIZATION_NAME					varchar(80),              /*组织名称				*/
ORGANIZATION						varchar(10),              /*组织编号				*/
IS_PRIMARY_ADDRESS					varchar(1),         	  /* 主要联络地址	    */

PRIMARY KEY (ADDRESS_NO,LANGUAGE,ORGANIZATION)
);




# 029 组织层级建立申请档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-15
# 

DROP TABLE IF EXISTS BAS_ORGHIERARCHY_REQUISITION;

CREATE TABLE BAS_ORGHIERARCHY_REQUISITION(
STATUS_CODE							varchar(10),      /*状态码			 */				
OPERATION_ORGANIZATION				varchar(10),      /*营运组织		 */
REQUISITION_NO						varchar(10),      /*申请单号		 */
REQUISITION_DATE					date,             /*申请日期		 */
REQUISITION_TYPE					varchar(10),      /*申请类型		 */
TOP_ORGANIZATION					varchar(10),      /*最上层组织		 */
VERSION								varchar(10),      /*版本			 */
VALID_DATE							date,             /*生效日期		 */
INVALID_DATE						date,             /*失效日期		 */
DATA_OWNER							varchar(20),      /*资料所有者		 */
DATA_OWNED_DEPARTMENT				varchar(10),      /*资料所属部门	 */
DATA_CREATED_BY						varchar(20),      /*资料建立者		 */
DATA_CREATED_DEPARTMENT				varchar(10),      /*资料建立部门	 */
DATA_CREATED_DATE					TIMESTAMP,        /*资料创建日		 */
DATA_MODIFIED_BY					varchar(20),      /*资料修改者		 */
LAST_MODIFIED_DATE					TIMESTAMP,        /*最近修改日		 */
DATA_CONFIRMED_BY					varchar(20),      /*资料审核者		 */
DATA_CONFIRMED_DATE					TIMESTAMP,        /*资料审核日		 */
LANGUAGE							varchar(10),      /*语言别			 */
OPERATION_ORGANIZATION_NAME			varchar(80),      /*营运组织名称	 */
TOP_ORGANIZATION_NAME				varchar(80),      /*最上层组织名称	 */

PRIMARY KEY (REQUISITION_NO)
);




# 030 组层级建立明细档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-15
# 

DROP TABLE IF EXISTS BAS_ORGHIERARCHY_DETAIL;

CREATE TABLE BAS_ORGHIERARCHY_DETAIL(
TOP_ORGANIZATION				varchar(10),     /*最上层组织		*/
VERSION							varchar(10),     /*版本			    */
ORGANIZATION					varchar(10),     /*组织编号		    */
HIGHER_ORGANIZATION				varchar(10),     /*上级组织编号	    */
VALID_DATE						date,            /*生效日期		    */
INVALID_DATE					date,            /*失效日期		    */
REQUISITION_NO					varchar(10),     /*申请单号		    */
LANGUAGE						varchar(10),     /*语言别			*/
TOP_ORGANIZATION_NAME			varchar(80),     /*最上层组织名称	*/
ORGANIZATION_NAME				varchar(80),     /*组织名称		    */
HIGHER_ORGANIZATION_NAME		varchar(80),     /*上级组织名称	    */

PRIMARY KEY (TOP_ORGANIZATION,VERSION,ORGANIZATION,HIGHER_ORGANIZATION,REQUISITION_NO)
);




# 031 组织层级档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-15
# 

DROP TABLE IF EXISTS BAS_ORGANIZATION_HIERARCHY;

CREATE TABLE BAS_ORGANIZATION_HIERARCHY(
TOP_ORGANIZATION				varchar(10),     /*最上层组织		*/
VERSION							varchar(10),     /*版本			    */
ORGANIZATION					varchar(10),     /*组织编号		    */
HIGHER_ORGANIZATION				varchar(10),     /*上级组织编号	    */
VALID_DATE						date,            /*生效日期		    */
INVALID_DATE					date,            /*失效日期		    */
REQUISITION_NO					varchar(10),     /*申请单号		    */
LANGUAGE						varchar(10),     /*语言别			*/
TOP_ORGANIZATION_NAME			varchar(80),     /*最上层组织名称	*/
ORGANIZATION_NAME				varchar(80),     /*组织名称		    */
HIGHER_ORGANIZATION_NAME		varchar(80),     /*上级组织名称	    */

PRIMARY KEY (TOP_ORGANIZATION,VERSION,ORGANIZATION,HIGHER_ORGANIZATION)
);




# 032 员工基础资料档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-17
# 

DROP TABLE IF EXISTS BAS_EMPLOYEE;

CREATE TABLE BAS_EMPLOYEE( 
STATUS_CODE								varchar(10),	    /* 状态码		            */												
EMPLOYEE_NO								varchar(20),        /* 员工编号				    */
ROLE_TYPE								varchar(1),			/* 职能：1.员工，2.导购员	*/			
BELONGED_DEPARTMENT						varchar(10),        /* 归属部门				    */
BELONGED_ORGANIZATION					varchar(10),        /* 归属组织				    */
BELONGED_STORE							varchar(10),        /* 归属门店				    */
JOB_TITLE								varchar(10),        /* 职称					    */
BANK_POSTOFFICE_NO						varchar(15),        /* 银行行号/邮局局号		*/
ACCOUNT_NO								varchar(30),        /* 账号					    */
DATA_OWNER								varchar(20),        /* 资料所有者				*/
DATA_OWNED_DEPARTMENT					varchar(10),        /* 资料所属部门			    */
DATA_CREATED_BY							varchar(20),        /* 资料建立者				*/
DATA_CREATED_DEPARTMENT					varchar(10),        /* 资料建立部门			    */
DATA_CREATED_DATE						TIMESTAMP,          /* 资料创建日				*/
DATA_MODIFIED_BY						varchar(20),        /* 资料修改者				*/
LAST_MODIFIED_DATE						TIMESTAMP,          /* 最近修改日				*/
SURNAME									varchar(80),        /* 姓氏					    */
MIDDLE_NAME								varchar(80),        /* 中间名					*/
GIVEN_NAME								varchar(80),        /* 名字					    */
EMPLOYEE_NAME							varchar(80),        /* 员工姓名				    */
PREFERENCE_NAME							varchar(80),        /* 参考名					*/
NICKNAME								varchar(80),		/* 昵称						*/					
IS_AGENT_MECHANISM						varchar(1 ),        /* 是否启用代理人机制		*/
AGENT_EMPLYEE_NO						varchar(20),        /* 代理人员工编号			*/
SUPERVISOR_EMPLYEE_NO					varchar(20),        /* 直属主管员工编号		    */
CONTACT_NO								varchar(20),        /* 联系电话				    */
MOBILE_NO								varchar(20),        /* 手机					    */
EMAIL									varchar(80),        /* E-MAIL					*/
COUNTRY_REGION							varchar(10),        /* 所属国家地区			    */
PROVINCE								varchar(10),        /* 省别					    */
CITY									varchar(10),        /* 城市					    */
COUNTY_DISTRICT							varchar(10),        /* 县区					    */
STREET									varchar(10),        /* 街道					    */
DETAILED_ADDRESS						varchar(255),       /* 详细地址				    */
POSTCODE								varchar(10),        /* 邮政编号				    */
LANGUAGE								varchar(10),        /* 语言别					*/
BELONGED_DEPARTMENT_NAME				varchar(80),        /* 归属部门名称			    */
BELONGED_ORGANIZATION_NAME				varchar(80),        /* 归属组织名称			    */
BELONGED_STORE_NAME						varchar(80),        /* 归属门店名称			    */
JOB_TITLE_NAME							varchar(80),        /* 职称名称				    */
AGENT_EMPLYEE_NAME						varchar(80),        /* 代理人员工姓名			*/
SUPERVISOR_EMPLYEE_NAME					varchar(80),        /* 直属主管员工姓名		    */
COUNTRY_REGION_NAME						varchar(80),        /* 国家地区名称			    */
PROVINCE_NAME							varchar(80),        /* 省别名称				    */
CITY_NAME								varchar(80),        /* 城市名称				    */
COUNTY_DISTRICT_NAME					varchar(80),        /* 县区名称				    */
STREET_NAME								varchar(80),        /* 街道名称				    */

PRIMARY KEY (EMPLOYEE_NO,LANGUAGE)
);





# 033 员工地址档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-17
# 

DROP TABLE IF EXISTS BAS_EMPLOYEE_ADDRESS;

CREATE TABLE BAS_EMPLOYEE_ADDRESS( 
STATUS_CODE								varchar(10),       /* 状态码	    */		
EMPLYEE_NO								varchar(20),       /* 员工编号		*/
ADDRESS_NO								varchar(20),       /* 地址编号		*/
ADDRESS_TYPE							varchar(10),       /* 地址类型		*/
IS_PRAMARY_ADDRESS						varchar(1),        /* 主要联络地址	*/
COUNTRY_REGION							varchar(10),       /* 所属国家地区	*/
PROVINCE								varchar(10),       /* 省别			*/
CITY									varchar(10),       /* 城市			*/
COUNTY_DISTRICT							varchar(10),       /* 县区			*/
STREET									varchar(10),       /* 街道			*/
POSTCODE								varchar(12),       /* 邮政编号		*/
DETAILED_ADDRESS						varchar(255),       /* 详细地址		*/
DATA_OWNER								varchar(20),       /* 资料所有者	*/	
DATA_OWNED_DEPARTMENT					varchar(10),       /* 资料所属部门	*/
DATA_CREATED_BY							varchar(20),       /* 资料建立者	*/	
DATA_CREATED_DEPARTMENT					varchar(10),       /* 资料建立部门	*/
DATA_CREATED_DATE						TIMESTAMP,         /* 资料创建日	*/	
DATA_MODIFIED_BY						varchar(20),       /* 资料修改者	*/	
LAST_MODIFIED_DATE						TIMESTAMP,         /* 最近修改日	*/	
LANGUAGE								varchar(10),       /* 语言别		*/	
COUNTRY_REGION_NAME						varchar(80),       /* 国家地区名称	*/
PROVINCE_NAME							varchar(80),       /* 省别名称		*/
CITY_NAME								varchar(80),       /* 城市名称		*/
COUNTY_DISTRICT_NAME					varchar(80),       /* 县区名称		*/
STREET_NAME								varchar(80),       /* 街道名称		*/

PRIMARY KEY (EMPLYEE_NO,ADDRESS_NO,LANGUAGE)
);





# 034 员工通讯方式档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-17
# 

DROP TABLE IF EXISTS BAS_EMPLOYEE_COMMUNICATION;

CREATE TABLE BAS_EMPLOYEE_COMMUNICATION( 
STATUS_CODE									varchar(10),       /* 状态码				*/		
EMPLYEE_NO									varchar(20),       /* 员工编号		        */
COMMUNICATION_NO							varchar(20),       /* 通信方式编号	        */
COMMUNICATION_TYPE							varchar(10),       /* 通信类型		        */
BRIEF_DESCRIPTION							varchar(80),       /* 简要说明		        */
COMMUNICATION_CONTENT						varchar(255),      /* 通信内容		        */
IS_PRIMARY_COMMUNICATION					varchar(1),        /* 主要通讯方式否	    */
DATA_OWNER									varchar(20),       /* 资料所有者		    */
DATA_OWNED_DEPARTMENT						varchar(10),       /* 资料所属部门	        */
DATA_CREATED_BY								varchar(20),       /* 资料建立者		    */
DATA_CREATED_DEPARTMENT						varchar(10),       /* 资料建立部门	        */
DATA_CREATED_DATE							TIMESTAMP,         /* 资料创建日		    */
DATA_MODIFIED_BY							varchar(20),       /* 资料修改者		    */
LAST_MODIFIED_DATE							TIMESTAMP,         /* 最近修改日		    */
LANGUAGE									varchar(10),       /* 语言别			    */
EMPLOYEE_NAME								varchar(80),       /* 员工名称		        */

PRIMARY KEY (EMPLYEE_NO,COMMUNICATION_NO,LANGUAGE)
);





# 035 品类资料档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-17
# 

DROP TABLE IF EXISTS BAS_PRODUCT_CATEGORY;

CREATE TABLE BAS_PRODUCT_CATEGORY( 
STATUS_CODE							varchar(10),         /* 状态码				*/		
SETTING_ORGANIZATION				varchar(10),         /* 制定组织		    */
CATEGORY_NO							varchar(10),         /* 品类编号		    */
CATEGORY_TYPE						varchar(10),         /* 品类类型		    */
UPPER_CATEGORY						varchar(10),         /* 上层品类		    */
CATEGORY_LEVEL						DECIMAL(5,0),        /* 层级			    */
TOTAL_LOWER_CATEGORY				DECIMAL(5,0),        /* 下级品类数		    */
BELONG_TOP_CATEGORY					varchar(10),		 /* 所属一级品类		*/						
DATA_OWNER							varchar(20),         /* 资料所有者		    */
DATA_OWNED_DEPARTMENT				varchar(10),         /* 资料所属部门	    */
DATA_CREATED_BY						varchar(20),         /* 资料建立者		    */
DATA_CREATED_DEPARTMENT				varchar(10),         /* 资料建立部门	    */
DATA_CREATED_DATE					TIMESTAMP,           /* 资料创建日		    */
DATA_MODIFIED_BY					varchar(20),         /* 资料修改者		    */
LAST_MODIFIED_DATE					TIMESTAMP,           /* 最近修改日		    */
LANGUAGE							varchar(10),         /* 语言别			    */
CATEGORY_DESCRIPTION				varchar(80),         /* 品类说明		    */
UPPER_CATEGORY_DESCRIPTION			varchar(80),         /* 上层品类说明	    */
TOP_CATEGORY_DESCRIPTION			varchar(80),         /* 所属一级品类说明    */
SETTING_ORGANIZATION_NAME			varchar(80),         /* 制定组织名称	    */

PRIMARY KEY (CATEGORY_NO,LANGUAGE)
);





# 036 发票类型档 
# v0.1
# 创建者：陈松
#
# 历史：
# 创建于 2017-02-21
# 

DROP TABLE IF EXISTS BAS_INVOICE_TYPE;

CREATE TABLE BAS_INVOICE_TYPE(
DATA_OWNER									varchar(20),        /*资料所有者				*/		
DATA_OWNED_DEPARTMENT						varchar(10),        /*资料所属部门		        */
DATA_CREATED_BY								varchar(20),        /*资料建立者			    */
DATA_CREATED_DEPARTMENT						varchar(10),        /*资料建立部门		        */
DATA_CREATED_DATE							TIMESTAMP,          /*资料创建日			    */
DATA_MODIFIED_BY							varchar(20),        /*资料修改者			    */
LAST_MODIFIED_DATE							TIMESTAMP,          /*最近修改日			    */
STATUS_CODE									varchar(10),        /*状态码				    */
TRANSACTION_TAX_AREA						varchar(10),        /*交易税区			        */
INVOICE_TYPE								varchar(2),         /*发票类型			        */
INVOICE_INPUT_OUTPUT						varchar(1),         /*发票归属进销项		    */
MEDIA_DECLARATION_FORMAT					varchar(10),        /*媒体申报格式		        */
TAX_PRINCIPLE								varchar(1),         /*计税原则			        */
INVOICE_DETAILED_AMOUNT						DECIMAL(5,0),       /*发票明细笔数		        */
TOLERANCE_AMOUNT							varchar(10),        /*容差额				    */
INVOICE_COPIES								varchar(10),        /*发票联数			        */
DISCOUNT_TYPE								varchar(255),       /*对应折单类型		        */
IS_MUTIPLE_RATE								varchar(1),         /*允许多税率否		        */
NUMBER_OF_INVOICE							DECIMAL(5,0),       /*发票张数			        */
IS_DIFTAXNO_TRANSFERRABLE					varchar(1),         /*不同税务编号可调拨否      */
LANGUAGE									varchar(10),        /*語言別				    */
INVOICE_TYPE_DISCRIPTION					varchar(80),        /*发票类型说明		        */
TRANSACTION_TAX_DISCRIPTION					varchar(80),        /*交易税区说明		        */

PRIMARY KEY (TRANSACTION_TAX_AREA,INVOICE_TYPE,LANGUAGE)
);





# 037 银行资料档 
# v0.1
# 创建者：陈松
#
# 历史：
# 创建于 2017-02-21
# 

DROP TABLE IF EXISTS BAS_BANK;

CREATE TABLE BAS_BANK(
STATUS_CODE						varchar(10),		/*状态码				*/				
BANK_BRANCH_NO					varchar(15),        /*银行网点编号		    */
BANK_TYPE						varchar(1),         /*银行类型			    */
SWIFT_CODE						varchar(15),        /*SWIFT码				*/
BANK_HOLIDAY_LIST				varchar(10),        /*银行节假日表		    */
CONTACT_NAME					varchar(40),        /*联络人姓名			*/
ADDRESS_NO						varchar(20),        /*联络地址			    */
COMMUNICATION_NO				varchar(20),        /*通信方式			    */
COUNTRY_REGION					varchar(10),        /*所属国家地区		    */
IBAN							varchar(40),        /*IBAN				    */
BANK_NO							varchar(15),        /*银行编号			    */
DATA_OWNER						varchar(20),        /*资料所有者			*/
DATA_OWNED_DEPARTMENT			varchar(10),        /*资料所属部门		    */
DATA_CREATED_BY					varchar(20),        /*资料建立者			*/
DATA_CREATED_DEPARTMENT			varchar(10),        /*资料建立部门		    */
DATA_CREATED_DATE				TIMESTAMP,          /*资料创建日			*/
DATA_MODIFIED_BY				varchar(20),        /*资料修改者			*/
LAST_MODIFIED_DATE				TIMESTAMP,          /*最近修改日			*/
LANGUAGE						varchar(10),        /*語言別				*/
BANK_BRANCH_SHOTNAME			varchar(80),        /*银行网点简称		    */
BANK_BRANCH_FULLNAME			varchar(80),        /*银行网点全称		    */
BANK_HOLIDAY_DISCRIPTION		varchar(80),        /*银行节假日说明		*/
BANK_NAME						varchar(80),        /*银行名称			    */
DETAILED_ADDRESS				varchar(255),       /*详细地址			    */
BANK_TYPE_DISCRIPTION			varchar(80),        /*银行类型			    */
COUNTRY_REGION_NAME				varchar(80),        /*所属国家地区名称	    */

PRIMARY KEY (BANK_BRANCH_NO,LANGUAGE)
);





# 038 企业银行账户资料档 
# v0.1
# 创建者：陈松
#
# 历史：
# 创建于 2017-02-21
# 

DROP TABLE IF EXISTS BAS_BANK_ACCOUNT;

CREATE TABLE BAS_BANK_ACCOUNT(
DATA_OWNER								varchar(20),			/*资料所有者			*/		
DATA_OWNED_DEPARTMENT					varchar(10),            /*资料所属部门		    */
DATA_CREATED_BY							varchar(20),            /*资料建立者			*/
DATA_CREATED_DEPARTMENT					TIMESTAMP,              /*资料建立部门		    */
DATA_CREATED_DATE						varchar(10),            /*资料创建日			*/
DATA_MODIFIED_BY						varchar(20),            /*资料修改者			*/
LAST_MODIFIED_DATE						TIMESTAMP,              /*最近修改日			*/
STATUS_CODE								varchar(10),            /*状态码				*/
BAKN_ACCOUNT_NO							varchar(10),            /*账户编码			    */
ACCOUNT_HOLDER							varchar(10),            /*开户人（组织）		*/
BANK_ACCOUNT_TYPE						varchar(10),            /*账户类型			    */
DEPOSIT_BANK							varchar(15),            /*开户银行			    */
BANK_NO									varchar(30),            /*银行编号			    */
IS_BANK_ONLINE							varchar(1),             /*开通网银否			*/
CONTACT_FULLNAME						varchar(20),            /*联络人全名			*/
CONTACT_ADDRESS							varchar(20),            /*联络人地址			*/
CONTRACT_NO								varchar(20),            /*联络人电话			*/
DEFAULT_ACCOUNT_SUBJECT					varchar(24),            /*默认会计科目		    */
LANGUAGE								varchar(10),            /*語言別				*/
BANK_ACCOUNT_DISCRIPTION				varchar(80),            /*账户说明			    */
ACCOUNT_HOLDER_NAME						varchar(80),            /*开户人（组织）名称	*/
BANKACCOUNT_DISCRIPTION					varchar(80),            /*账户类型说明		    */
DEPOSIT_BANK_NAME						varchar(80),            /*开户银行名称		    */

PRIMARY KEY (BAKN_ACCOUNT_NO,LANGUAGE)
);





# 039 缴款优惠条件档 
# v0.1
# 创建者：陈松
#
# 历史：
# 创建于 2017-02-21
# 

DROP TABLE IF EXISTS BAS_PAYMENT_FAVORABLETERM;

CREATE TABLE BAS_PAYMENT_FAVORABLETERM(
DATA_OWNER									varchar(20),			/*资料所有者		*/	
DATA_OWNED_DEPARTMENT						varchar(10),            /*资料所属部门	    */
DATA_CREATED_BY								varchar(20),            /*资料建立者		*/
DATA_CREATED_DEPARTMENT						varchar(10),            /*资料建立部门	    */
DATA_CREATED_DATE							TIMESTAMP,              /*资料创建日		*/
DATA_MODIFIED_BY							varchar(20),            /*资料修改者		*/
LAST_MODIFIED_DATE							TIMESTAMP,              /*最近修改日		*/
STATUS_CODE									varchar(10),            /*状态码			*/
FAVORABLE_TERM								varchar(10),            /*优惠条件编号	    */
APPLICABLE_TYPE								varchar(1 ),            /*适用类型		    */
NOTE										varchar(255),           /*备注			    */
ADVANCE_DAYS1								DECIMAL(5,0),           /*提前天数(一)	    */
DISCOUNT_RATE1								DECIMAL(20,6),          /*折扣利率(一)	    */
ADVANCE_DAYS2								DECIMAL(5,0),           /*提前天数(二)	    */
DISCOUNT_RATE2								DECIMAL(20,6),          /*折扣利率(二)	    */
ADVANCE_DAYS3								DECIMAL(5,0),           /*提前天数(三)	    */
DISCOUNT_RATE3								DECIMAL(20,6),          /*折扣利率(三)	    */
LANGUAGE									varchar(10),            /*語言別			*/
FAVORABLE_TERM_DISCRIPTION					varchar(80),            /*缴款优惠说明	    */
APPLICABLE_TYPE_DISCRIPTION					varchar(80),            /*适用类型说明	    */

PRIMARY KEY (FAVORABLE_TERM,LANGUAGE)
);





# 040 交易对象付款方式设定档 
# v0.1
# 创建者：陈松
#
# 历史：
# 创建于 2017-2-15
# 

DROP TABLE IF EXISTS BAS_TRANSACTION_PAYMENT;

CREATE TABLE BAS_TRANSACTION_PAYMENT(
DATA_OWNER							varchar(20),			/* 资料所有者			*/		
DATA_OWNED_DEPARTMENT				varchar(10),            /* 资料所属部门		    */
DATA_CREATED_BY						varchar(20),            /* 资料建立者			*/
DATA_CREATED_DEPARTMENT				varchar(10),            /* 资料建立部门		    */
DATA_CREATED_DATE					TIMESTAMP,              /* 资料创建日			*/
DATA_MODIFIED_BY					varchar(20),            /* 资料修改者			*/
LAST_MODIFIED_DATE					TIMESTAMP,              /* 最近修改日			*/
STATUS_CODE							varchar(10),            /* 状态码				*/
OPERATION_ORGANIZATION				varchar(10),            /* 营运组织			    */
TRANSACTION_OBJECT					varchar(10),			/* 付款/收款对象		*/	
IS_ENDORSEMENT_FORBIDDEN			varchar(1 ),            /* 票据应禁止背书		*/
BILL_MAILING_MODE					varchar(10),            /* 票据寄领方式		    */
POUNDAGE							DECIMAL(20,6),          /* 手续费				*/
POUNDAGE_DEDUCTION_MODE				varchar(10),            /* 手续费扣款方式		*/
POSTAGE								DECIMAL(20,6),          /* 寄送邮资费			*/
POSTAGE_DEDUCTION_MODE				varchar(10),            /* 邮资费扣款方式		*/
NOTIFICATION_MODE					varchar(10),            /* 通知方式			    */
LANGUAGE							varchar(10),            /* 語言別				*/
OPERATION_ORGANIZATION_NAME			varchar(80),            /* 营运组织名称		    */
TRANSACTION_OBJECT_NAME				varchar(80),            /* 付款/收款对象名称	*/

PRIMARY KEY (OPERATION_ORGANIZATION,TRANSACTION_OBJECT,LANGUAGE)
);





# 041 账别资料档 
# v0.1
# 创建者：陈松
#
# 历史：
# 创建于 2017-2-15
# 

DROP TABLE IF EXISTS  BAS_ACCOUNT_TYPE;

CREATE TABLE  BAS_ACCOUNT_TYPE(
DATA_OWNER										varchar(20),				/*资料所有者							*/				
DATA_OWNED_DEPARTMENT							varchar(10),                /*资料所属部门					        */
DATA_CREATED_BY									varchar(20),                /*资料建立者						    */
DATA_CREATED_DEPARTMENT							varchar(10),                /*资料建立部门					        */
DATA_CREATED_DATE								TIMESTAMP,                  /*资料创建日						    */
DATA_MODIFIED_BY								varchar(20),                /*资料修改者						    */
LAST_MODIFIED_DATE								TIMESTAMP,                  /*最近修改日						    */
STATUS_CODE										varchar(10),                /*状态码							    */
ACCOUNT_SET										varchar(5),                 /*账套编号						        */
LEGAL_PERSON									varchar(10),                /*归属法人						        */
CURRENCY_USED									varchar(10),                /*使用币种						        */
REFERENCE_TABLE_NO								varchar(5),					/*参照表编号							*/
MONTHLY_CLOSE_MODE								varchar(1),                 /*月结方式						        */
YEARLY_CLOSE_MODE								varchar(1),                 /*年结方式						        */
IS_PARALLEL_ACCOUNTING							varchar(1),                 /*平行记账否						    */
VOUCHER_INPUT_MODE								varchar(1),                 /*凭证登录方式					        */
CURRENT_YEAR									DECIMAL(5,0),               /*现行年度						        */
CURRENT_PERIOD									DECIMAL(5,0),               /*现行期别						        */
LAST_POSTING_DATE								date,                       /*最后过账日期					        */
CLOSING_DATE									date,                       /*关账日期						        */
PRIMARY_ACCOUNT_SET								varchar(1),                 /*主账套							    */
IS_STANDARD_CURRENCY2							varchar(1),                 /*启用本位币二					        */
STANDARD_CURRENCY2								varchar(10),                /*本位币二						        */
CONVERSION_STANDARD_CURRENCY2					varchar(1),                 /*本位币二换算基准				        */
EXCHANGERATE_STANDARD_CURRENCY2					varchar(10),                /*本位币二汇率采用				        */
IS_STANDARD_CURRENCY3							varchar(1),                 /*启用本位币三					        */
STANDARD_CURRENCY3								varchar(10),                /*本位币三						        */
CONVERSION_STANDARD_CURRENCY3					varchar(1),                 /*本位币三换算基准				        */
EXCHANGERATE_STANDARD_CURRENCY3					varchar(10),                /*本位币三汇率采用				        */
GENERATING_SECONDARY_ACCOUNTS					varchar(1),			        /*次账套账务生成时机				    */
EXCHANGERATE_STANDARD_CURRENCY1					varchar(10),				/*本位币一汇率采用				        */
IS_GENERATION_MISSING							varchar(1),                 /*凭证录入时自动按缺号生成		        */
MAINNO_INPUT_TIMING								varchar(1),                 /*凭证总号录入时机				        */
IMBALANCE_MODE									varchar(1),                 /*凭证成立时,借贷不平衡的处理方式	    */
IS_POSTING_NOTPRINT								varchar(1),                 /*未打印的凭证可否进行过账		        */
ACCRUED_ADJUSTIVE_DOCUMENT						varchar(5),                 /*应计调整单别					        */
TERMINAL_CARRYFORWARD_DOCUMENT					varchar(5),                 /*期末结转单别					        */
YEAREND_CARRYFORWARD_DOCUMENT					varchar(5),                 /*年底结转单别					        */
COST_CALCULATION_TYPE							varchar(10),                /*成本计算类型					        */
ACTIVATE_SUBMODULE_ACCTENTRY					varchar(1),                 /*子模块启用分录底稿				    */
IS_TRANSACTION_DETAIL							varchar(1),                 /*总账可维护资金异动明细			    */
DOCUMENT_BELONGED_ORGANIZATION					varchar(5),                 /*单据组织编号					        */
IS_CONSOLIDATE_ACCTSET							varchar(1),                 /*合并账套否						    */
IS_HIERARCHICAL_CONSOLIDATE						varchar(1),					/*分层合并否							*/		
TRANSACTION_CODE_SETVALUE						varchar(10),				/*合并科目转换依据异动码设置值	        */
IS_ARCANCEL_ESTABLISHED							varchar(1),                 /*应收账款核销限定己立账凭证		    */
IS_APCANCEL_ESTABLISHED							varchar(1),                 /*应付账款核销限定已立账凭证		    */
CONSOLIDATED_STATEMENT_PERIOD					varchar(1),                 /*合并报表编制期别				        */
IS_DEFERREDINCOME_LIABILITY						varchar(1),                 /*递延收入(负债)管理生成否		        */
IS_DEFERREDINCOME_NONDELIVERYORDER				varchar(1),						/*无原出货单的递延负债减项者,是否仍立递延收入管理		*/
IS_ARCANCLE_TRANSDETAIL							varchar(1),                     /*应收帐款核销可维护资金异动明细						*/
IS_APCANCLE_TRANSDETAIL							varchar(1),                     /*应付帐款核销可维护资金异动明细						*/
EXCHRATE_SOURCE									varchar(1),                     /*汇率来源											    */
LANGUAGE										varchar(10),                    /*語言別												*/
PRIMARY_ACCTSET_DESCRIPTION						varchar(80),                    /*主账套说明											*/
LEGAL_PERSON_NAME								varchar(80),                    /*归属法人名称										    */
CURRENCY_USED_DESCRIPTION						varchar(80),                    /*使用币种说明										    */
REFERENCE_TABLE_DESCRIPTION						varchar(80),					/*参照表说明											*/						
STANDARD_CURRENCY2_DISCRIPTION					varchar(80),                    /*本位币二说明										    */
STANDARD_CURRENCY3_DISCRIPTION					varchar(80),				    /*本位币三说明										    */
MONTHLYCLOSE_MODE_DISCRIPTION					varchar(80),                    /*月结方式说明										    */
YEARLYCLOSE_MODE_DISCRIPTION					varchar(80),                    /*年结方式说明										    */
VOUCHERINPUT_MODE_DISCRIPTION					varchar(80),                    /*凭证登录方式说明									    */
ACRUADJUSTIVE_DOCUMENT_DISCRIPTION				varchar(80),                    /*应计调整单别说明									    */
TERMINAL_CARRYFORWARDDOC_DISCRIPTION			varchar(80),                    /*期末结转单别说明									    */
YEAREND_CARRYFORWARDDOC_DISCRIPTION				varchar(80),                    /*年底结转单别说明									    */
COST_CALTYPE_DISCRIPTION						varchar(80),                    /*成本计算类型说明									    */
DOCUMENT_BELONGEDORG_DISCRIPTION				varchar(80),                    /*单据组织说明										    */
AVGEXCHRATE_CALMODE_DISCRIPTION					varchar(80),                    /*平均汇率计算方式说明								    */
NONT100_IMPBALANCETYPE_DISCRIPTION				varchar(80),                    /*非T100公司导入余额类型说明							*/
IMBALANCE_MODE_DISCRIPTION						varchar(80),                    /*凭证成立时,借贷不平衡的处理方式说明					*/

PRIMARY KEY (ACCOUNT_SET,LANGUAGE)
);




# 042 品类维护作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-12
# 

DROP TABLE IF EXISTS BAS_PRODUCT_CATEGORY;

CREATE TABLE BAS_PRODUCT_CATEGORY(
STATUS_CODE						varchar(10),       /*状态码			  */
SETTING_ORGANIZATION			varchar(5),        /*制定组织		  */
CATEGORY_CODE					varchar(10),       /*品类编号		  */
CATEGORY_TYPE					varchar(10),       /*品类类型		  */
UPPER_CATEGORY					varchar(10),       /*上层品类		  */
CATEGORY_LEVEL					DECIMAL(5,0),      /*层级			  */
TOTAL_LOWER_CATEGORY			DECIMAL(5,0),      /*下级品类数		  */
BELONG_TOP_CATEGORY				varchar(10),	   /*所属一级品类	  */				
INSPECTION						varchar(1),	 	   /*检验否			  */					
DATA_OWNER						varchar(20),       /*资料所有者		  */
DATA_OWNED_DEPARTMENT			varchar(10),       /*资料所属部门	  */
DATA_CREATED_BY					varchar(20),       /*资料建立者		  */
DATA_CREATED_DEPARTMENT			varchar(10),       /*资料建立部门	  */
DATA_CREATED_DATE				TIMESTAMP,         /*资料创建日		  */
DATA_MODIFIED_BY				varchar(20),       /*资料修改者		  */
LAST_MODIFIED_DATE				TIMESTAMP,         /*最近修改日		  */
LANGUAGE						varchar(10),       /*语言别			  */
DESCRIPTION						varchar(80),       /*说明			  */
UPPER_CATEGORY_DESCRIPTION		varchar(80),	   /*上层品类说明	  */
TOP_CATEGORY_DESCRIPTION		varchar(80),	   /*所属一级品类说明 */

PRIMARY KEY (CATEGORY_CODE,LANGUAGE)
);





# 043 部门维护作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-11
# 

DROP TABLE IF EXISTS BAS_DEPARTMENT;

CREATE TABLE BAS_DEPARTMENT(
DATA_OWNER						VARCHAR(20),            /* 资料所有者		*/
DATA_OWNED_DEPARTMENT			VARCHAR(10),            /* 资料所属部门	    */
DATA_CREATED_BY					VARCHAR(20),            /* 资料建立者		*/
DATA_CREATED_DEPARTMENT			VARCHAR(10),            /* 资料建立部门	    */
DATA_CREATED_DATE				TIMESTAMP,              /* 资料创建日		*/
DATA_MODIFIED_BY				VARCHAR(20),            /* 资料修改者		*/
LAST_MODIFIED_DATE				TIMESTAMP,              /* 最近修改日		*/
STATUS_CODE						VARCHAR(10),            /* 状态码			*/
DEPT_NO							VARCHAR(10),            /* 部门编号			*/		                                              
RESPONSIBLE_CENTER_TYPE			VARCHAR(10),            /* 责任中心类型	    */
BELONGED_RESPONSIBLE_CENTER		VARCHAR(10),            /* 所属责任中心	    */
ACCOUNTING_DEPT					VARCHAR(1),             /* 会计部门		    */
VALID_DATE						DATE,            		/* 生效日期		    */
INVALID_DATE					DATE,           		/* 失效日期		    */
EXPENSE_CATAGORY				VARCHAR(10),            /* 费用类别		    */
BELONGED_CORPORATION			VARCHAR(10),            /* 归属法人		    */
DEPT_NAME						VARCHAR(80),            /* 部门名称		    */
DEPT_SUPERVISOR_EMPLYEENO		VARCHAR(20),        	/* 部门主管员工编号 */
DEPT_DECISION_LEVELS			VARCHAR(10),            /* 部门核决层级	    */
LANGUAGE						VARCHAR(10),            /* 语言别			*/
BELONGED_CORPORATION_NAME		VARCHAR(80),            /* 归属法人说明	    */
BELONGED_RESPONSIBLE_NAME		VARCHAR(80),        	/* 所属责任中心说明 */
DEPT_SUPERVISOR_NAME			VARCHAR(80),        	/* 部门主管员工名称 */

PRIMARY KEY (DEPT_NO,LANGUAGE)
);





# 044 员工职称维护作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-11
# 

DROP TABLE IF EXISTS BAS_EMPLOYEE_TITLE;

CREATE TABLE BAS_EMPLOYEE_TITLE(
STATUS_CODE					VARCHAR(10),           /* 状态码			*/
ACC							DECIMAL(5),            /* 应用分类		    */
ACC_CODE					VARCHAR(10),           /* 应用分类码		*/
UPDER_ACC_CODE				VARCHAR(10),       	   /* 上层应用分类码	*/
REFERENCE_FIELD1			VARCHAR(40),           /* 参考字段一		*/
REFERENCE_FIELD2			VARCHAR(40),           /* 参考字段二		*/
REFERENCE_FIELD3			VARCHAR(40),           /* 参考字段三		*/
REFERENCE_FIELD4			VARCHAR(40),           /* 参考字段四		*/
REFERENCE_FIELD5			VARCHAR(40),           /* 参考字段五		*/
REFERENCE_FIELD6			VARCHAR(40),           /* 参考字段六		*/
REFERENCE_FIELD7			VARCHAR(40),           /* 参考字段七		*/
REFERENCE_FIELD8			VARCHAR(40),           /* 参考字段八		*/
REFERENCE_FIELD9			VARCHAR(40),           /* 参考字段九		*/
REFERENCE_FIELD10			VARCHAR(40),           /* 参考字段十		*/
REFERENCE_FIELD11			VARCHAR(40),       	   /* 参考字段十一	    */
REFERENCE_FIELD12			VARCHAR(40),       	   /* 参考字段十二	    */
REFERENCE_FIELD13			VARCHAR(40),           /* 参考字段十三	    */
REFERENCE_FIELD14			VARCHAR(40),           /* 参考字段十四	    */
REFERENCE_FIELD15			VARCHAR(40),           /* 参考字段十五	    */
REFERENCE_FIELD16			VARCHAR(40),           /* 参考字段十六	    */
REFERENCE_FIELD17			VARCHAR(40),           /* 参考字段十七	    */
REFERENCE_FIELD18			VARCHAR(40),           /* 参考字段十八	    */
REFERENCE_FIELD19			VARCHAR(40),           /* 参考字段十九	    */
REFERENCE_FIELD20			VARCHAR(40),           /* 参考字段二十	    */
DATA_OWNER					VARCHAR(20),           /* 资料所有者		*/
DATA_OWNED_DEPARTMENT		VARCHAR(10),           /* 资料所属部门	    */
DATA_CREATED_BY				VARCHAR(20),           /* 资料建立者		*/
DATA_CREATED_DEPARTMENT		VARCHAR(10),           /* 资料建立部门	    */
DATA_CREATED_DATE			TIMESTAMP,             /* 资料创建日		*/
DATA_MODIFIED_BY			VARCHAR(20),           /* 资料修改者		*/
LAST_MODIFIED_DATE			TIMESTAMP,             /* 最近修改日		*/
LANGUAGE					VARCHAR(10),           /* 语言别			*/
ACC_NAME					VARCHAR(80),           /* 职称应用分类说明  */
UPDER_ACC_NAME				VARCHAR(80),	       /* 上层应用分类码说明*/

PRIMARY KEY (ACC,ACC_CODE,LANGUAGE)
);




# 045 时区设定作业
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-01-11
# 

DROP TABLE IF EXISTS BAS_TIME_ZONE;

CREATE TABLE BAS_TIME_ZONE(
STATUS_CODE						VARCHAR(10),            /* 状态码		*/
TIME_ZONE_NO					VARCHAR(10),        	/* 时区编号	    */
TIME_ZONE_SIMPLENO				VARCHAR(10),        	/* 时区简码	    */
REPRESENTATIONAL_CITY			VARCHAR(255),       	/* 代表城市	    */
DATA_OWNER						VARCHAR(20),        	/* 资料所有者	*/
DATA_OWNED_DEPARTMENT			VARCHAR(10),    		/* 资料所属部门 */
DATA_CREATED_BY					VARCHAR(20),        	/* 资料建立者	*/
DATA_CREATED_DEPARTMENT			VARCHAR(10),    		/* 资料建立部门 */
DATA_CREATED_DATE				TIMESTAMP,         		/* 资料创建日	*/
DATA_MODIFIED_BY				VARCHAR(20),        	/* 资料修改者	*/
LAST_MODIFIED_DATE				TIMESTAMP,         		/* 最近修改日	*/

PRIMARY KEY (TIME_ZONE_NO)
);





# 046 款别基本资料档
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-21
# 

DROP TABLE IF EXISTS BAS_PAYMENT_TYPE;

CREATE TABLE BAS_PAYMENT_TYPE(
PAYMENT_TYPE_NO								varchar(10),				/* 款别编号						*/			
PAYMENT_TYPE_PROPERTY						varchar(10),                /* 款别性质				        */
IS_CURRENCY									varchar(1),                 /* 本币否					    */
TRANSACTION_CERTIFICATE_TYPE				varchar(10),                /* 交易凭证类型			        */
STATUS_CODE									varchar(10),                /* 状态码					    */
DEFAULT_CURRENCY							varchar(10),                /* 默认币种				        */
UPPER_PAYMENT_TYPE							varchar(10),                /* 上级款别				        */
HIERARCHY									DECIMAL(5,0),               /* 层级					        */
SUBORDINATE_PAYMENTTYPE_AMOUNT				DECIMAL(5,0),               /* 下级款别数				    */
TOP_PAYMENT_TYPE							varchar(10),                /* 所属一级款别			        */
IS_BILL_ONDEMAND							varchar(1),                 /* 即期票据否				    */
IS_THIRDPARTY_COLLECTION					varchar(1),                 /* 第三方代收缴款否		        */
COLLECTION_AGENCY							varchar(10),                /* 代收机构				        */
COLLECTION_POUNDAGE_RATE					DECIMAL(20,6),              /* 代收手续费费率			    */
COLLECTION_POUNDAGE_MONEY					DECIMAL(20,6),              /* 代收手续费金额			    */
IS_COLLECTION_BILLING						varchar(1),                 /* 生成代收账款单否		        */
CORRESPONDING_PAYMENT_TYPE					varchar(10),				/* 对应款别编号					*/		
IS_DISCOUNT_RECEIVED						varchar(1),                 /* 是否实收折让			        */
IS_SINGLE_USE								varchar(1),                 /* 储值付款单次使用否		    */
ENTRYNO_MINIMUM_LENGTH						DECIMAL(5,0),               /* 录入号码最小长度		        */
IS_REFUNDABLE								varchar(1 ),                /* 可退款					    */
IS_GIVE_CHANGE								varchar(1),			        /* 可找零					    */
IS_OVERCHARGE								varchar(1),			        /* 可溢收					    */
STANDARD_POUNDAGE_RATE						DECIMAL(20,6),              /* 标准手续费费率			    */
COUPON_CONSUMPTION_MODE						varchar(10),                /* 券消费认列方式			    */
ACCOUNT_CURRENT_ORGANIZATION				varchar(1),	                /* 资金入账是否当前组织	        */
IS_COLLECTION								varchar(1),                 /* 代收银否				        */
COLLECTION_ORGANIZATION						varchar(10),                /* 代收银组织				    */
CARD_CEILLING_MONEY							DECIMAL(20,6),              /* 刷卡上限金额			        */
CEILLING_POUNDAGE_MONEY						DECIMAL(20,6),              /* 上限手续费金额			    */
IS_PAYMENT_CHECKDETAIL						varchar(1),                 /* 收银缴款是否核对明细	        */
DATA_OWNER									varchar(20),                /* 资料所有者				    */
DATA_OWNED_DEPARTMENT						varchar(10),                /* 资料所属部门			        */
DATA_CREATED_BY								varchar(20),                /* 资料建立者				    */
DATA_CREATED_DEPARTMENT						varchar(10),                /* 资料建立部门			        */
DATA_CREATED_DATE							TIMESTAMP,                  /* 资料创建日				    */
DATA_MODIFIED_BY							varchar(20),                /* 资料修改者				    */
LAST_MODIFIED_DATE							TIMESTAMP,                  /* 最近修改日				    */
LANGUAGE									varchar(10),                /* 語言別					    */
PAYMENT_TYPE_DISCRIPTION					varchar(80),                /* 款别说明				        */
DEFAULT_CURRENCY_DISCRIPTION				varchar(80),                /* 默认币种说明			        */
UPPER_PAYMENTTYPE_DISCRIPTION				varchar(80),                /* 上级款别说明			        */
TOP_PAYMENTTYPE_DISCRIPTION					varchar(80),                /* 所属一级款别说明		        */
TRANSCERTIFICATE_TYPE_DISCRIPTION			varchar(80),                /* 交易凭证类型说明		        */
COUPON_CONSUMPTIONMODE_DISCRIPTION			varchar(80),                /* 券消费认列方式说明		    */
CORRESPONDING_PAYMENTTYPE_DISCRIPTION		varchar(80),                /* 对应款别说明			        */
COLLECTION_AGENCY_NAME						varchar(80),                /* 代收机构名称			        */

PRIMARY KEY (PAYMENT_TYPE_NO,LANGUAGE)
);





# 047 款别依营运组织设置档
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-21
# 

DROP TABLE IF EXISTS BAS_PAYMENTTYPE_SETTING;

CREATE TABLE BAS_PAYMENTTYPE_SETTING(
STATUS_CODE											varchar(10),			/* 状态码							*/				
OPERATION_ORGANIZATION								varchar(10),            /* 营运组织				            */
PAYMENT_TYPE										varchar(10),            /* 款别编号				            */
DEFAULT_CURRENCY									varchar(10),            /* 款别指定币种			            */
IS_THIRDPARTY_COLLECTION							varchar(1 ),            /* 第三方代收缴款否		            */
COLLECTION_AGENCY									varchar(10),            /* 代收机构				            */
COLLECTION_POUNDAGE_RATE							DECIMAL(20,6),          /* 代收手续费费率			        */
COLLECTION_POUNDAGE_MONEY							DECIMAL(20,6),          /* 代收手续费金额			        */
IS_COLLECTION_BILLING								varchar(1),             /* 生成代收账款单否		            */
IS_DEFAULT_PAYMENTTYPE								varchar(1),             /* 默认款别否				        */
CORRESPONDING_PAYMENT_TYPE							varchar(10),			/* 对应款别编号						*/		
IS_DISCOUNT_RECEIVED								varchar(1),             /* 是否实收折让			            */
IS_SINGLE_USE										varchar(1),             /* 储值付款单次使用否		        */
ENTRYNO_MINIMUM_LENGTH								DECIMAL(5,0),           /* 录入号码最小长度		            */
IS_REFUNDABLE										varchar(1),             /* 可退款					        */
IS_GIVE_CHANGE										varchar(1),		        /* 可找零					        */
IS_OVERCHARGE										varchar(1),				/* 可溢收							*/					
DATA_OWNER											varchar(20),            /* 资料所有者				        */
DATA_OWNED_DEPARTMENT								varchar(10),            /* 资料所属部门			            */
DATA_CREATED_BY										varchar(20),            /* 资料建立者				        */
DATA_CREATED_DEPARTMENT								varchar(10),            /* 资料建立部门			            */
DATA_CREATED_DATE									TIMESTAMP,              /* 资料创建日				        */
DATA_MODIFIED_BY									varchar(20),            /* 资料修改者				        */
LAST_MODIFIED_DATE									TIMESTAMP,              /* 最近修改日				        */
BANK_ACCOUNT										varchar(20),            /* 对应的银存账户			        */
STANDARD_POUNDAGE_RATE								DECIMAL(20,6),          /* 标准卡手续费费率		            */
COUPON_CONSUMPTION_MODE								varchar(10),            /* 券消费认列方式			        */
TAX_DEDUCTION_SEQUENCE								DECIMAL(20,6),          /* 税额扣抵顺序			            */
IS_ACCOUNT_CURRENTORG								varchar(1),             /* 资金入账是否当前组织	            */
IS_COLLECTION										varchar(1),             /* 代收银否				            */
COLLECTING_ORGANIZATION								varchar(10),            /* 代收银组织				        */
CARD_CEILLING_MONEY									DECIMAL(20,6),          /* 刷卡上限金额			            */
CEILLING_POUNDAGE_MONEY								DECIMAL(20,6),          /* 上限手续费金额			        */
IS_PAYMENT_CHECKDETAIL								varchar(1),             /* 收银缴款是否核对明细	            */
POUNDAGE_DEPARTMENT									varchar(10),            /* 手续费归属部门			        */
LANGUAGE											varchar(10),            /* 語言別					        */
OPERATION_ORGANIZATION_NAME							varchar(80),            /* 营运组织名称			            */
PAYMENT_TYPE_DISCRIPTION							varchar(80),            /* 款别说明				            */
DEFAULT_CURRENCY_DISCRIPTION						varchar(80),            /* 款别指定币种说明		            */
COLLECTION_AGENCY_NAME								varchar(80),            /* 代收机构名称			            */
CORRESPONDING_PAYMENT_NAME							varchar(80),            /* 对应款别说明			            */
BANK_ACCOUNT_DISCRIPTION							varchar(80),            /* 对应银存账户说明		            */
COLLECTING_ORGANIZATION_NAME						varchar(80),            /* 代收银组织名称			        */
POUNDAGE_DEPARTMENT_NAME							varchar(80),            /* 手续费归属部门名称		        */
CORRESPONDING_PAYMENTTYPE_DISCRIPTION				varchar(80),            /* 对应款别说明			            */
COUPON_CONSUMPTIONMODE_DISCRIPTION					varchar(80),            /* 券消费认列方式说明		        */

PRIMARY KEY (OPERATION_ORGANIZATION,PAYMENT_TYPE,LANGUAGE)
);




# 048 多账期设定档
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-21
# 

DROP TABLE IF EXISTS BAS_MLTIPAYMENT_PERIOD;

CREATE TABLE BAS_MLTIPAYMENT_PERIOD(
MULTIPLE_ACCOUNT_PERIOD						varchar(10),				/* 多账期编号		*/		
PERIODS										DECIMAL(5,0),               /* 期数			    */
INTERVALS_QUARTER							DECIMAL(5,0),               /* 间隔（季）		*/
INTERVALS_MONTH								DECIMAL(5,0),               /* 间隔（月）		*/
INTERVALS_DAY								DECIMAL(5,0),               /* 间隔（日）		*/
PAYMENT_TYPE_PROPERTY						varchar(10),                /* 款别类型		    */
INSTALLMENT_RATE							DECIMAL(20,6),              /* 分期比率%		*/
MONEY_SETTING								varchar(40),                /* 金额设置		    */
DATA_OWNER									varchar(20),                /* 资料所有者		*/
DATA_OWNED_DEPARTMENT						varchar(10),                /* 资料所属部门	    */
DATA_CREATED_BY								varchar(20),                /* 资料建立者		*/
DATA_CREATED_DEPARTMENT						varchar(10),                /* 资料建立部门	    */
DATA_CREATED_DATE							TIMESTAMP,                  /* 资料创建日		*/
DATA_MODIFIED_BY							varchar(20),                /* 资料修改者		*/
LAST_MODIFIED_DATE							TIMESTAMP,                  /* 最近修改日		*/
STATUS_CODE									varchar(10),                /* 状态码			*/
LANGUAGE									varchar(10),                /* 語言別			*/
MULTIPLE_ACCTPERIOD_DISCRIPTION				varchar(80),                /* 多账期说明		*/

PRIMARY KEY (MULTIPLE_ACCOUNT_PERIOD,PERIODS,LANGUAGE)
);





# 049 客户/供应商资料档
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-21
# 

DROP TABLE IF EXISTS BAS_CUSTOMER_VENDOR;

CREATE TABLE BAS_CUSTOMER_VENDOR(
CUSTOMER_VENDOR									varchar(10),			/* 客户/供应商编号			*/				
LEGAL_PERSON_TYPE								varchar(1),             /* 法人类型			        */
LEGAL_PERSON									varchar(10),            /* 所属法人			        */
BELONGED_GROUP									varchar(10),			/* 所属集团				    */
CREDIT_CHECK_MODE								varchar(10),            /* 信用查核方式		        */
QUOTA_CUSTOMER									varchar(10),            /* 额度客商			        */
CREDIT_RATING									varchar(10),            /* 信用评核等级		        */
QUOTA_CURRENCY									varchar(10),            /* 额度计算币别		        */
ENTERPRISE_CREDIT_QUOTA							DECIMAL(20,6),          /* 企业额度			        */
EXCEEDING_RATE									DECIMAL(20,6),          /* 可超出率			        */
VALID_PERIOD									date,                   /* 有效期限			        */
OVERDUE_GRACE_DAYS								DECIMAL(5,0),           /* 逾期账款宽限天数	        */
ALLOW_EXCEPTION_QUOTA							DECIMAL(20,6),			/* 允许除外额				*/	
VENDOR_TYPE										varchar(10),			/* 供应商分类				*/		
VENDOR_LIFECYCLE_MAINTENANCE					varchar(10),            /* 供应商生命周期		    */
VENDOR_IMPORTANCE_GRADE							varchar(10),            /* 供应商重要性等级	        */
VENDOR_ORGANIZATION								varchar(10),            /* 供应商制定组织		    */
DEFAULT_PURCHASER								varchar(20),            /* 默认采购员			    */
CUSTOMER_TYPE									varchar(10),			/* 客户分类			        */
CUSTOMER_NATURE									varchar(10),            /* 客户性质			        */
CUSTOMER_LIFECYCLE_MAINTENANCE					varchar(10),            /* 客户生命周期		        */
CUSTOMER_IMPORTANCE_GRADE						varchar(10),            /* 客户重要等级		        */
CUSTOMER_DEVELOPMENT_ORGANIZATION				varchar(10),            /* 客户制定组织		        */
DEFAULT_SALESMAN								varchar(20),			/* 默认业务员				*/
IS_INVENTORY_MANAGEMENT							varchar(1),				/* 客户库存管理否			*/		
VENDOR_ATTRIBUTE1								varchar(10),            /* 供应商其他属性一	        */
VENDOR_ATTRIBUTE2								varchar(10),            /* 供应商其他属性二	        */
VENDOR_ATTRIBUTE3								varchar(10),            /* 供应商其他属性三	        */
VENDOR_ATTRIBUTE4								varchar(10),            /* 供应商其他属性四	        */
VENDOR_ATTRIBUTE5								varchar(10),            /* 供应商其他属性五	        */
VENDOR_ATTRIBUTE6								varchar(10),            /* 供应商其他属性六	        */
VENDOR_ATTRIBUTE7								varchar(10),            /* 供应商其他属性七	        */
VENDOR_ATTRIBUTE8								varchar(10),            /* 供应商其他属性八	        */
VENDOR_ATTRIBUTE9								varchar(10),            /* 供应商其他属性九	        */
VENDOR_ATTRIBUTE10								varchar(10),            /* 供应商其他属性十	        */
CUSTOMER_ATTRIBUTE1								varchar(10),            /* 客户其他属性一		    */
CUSTOMER_ATTRIBUTE2								varchar(10),            /* 客户其他属性二		    */
CUSTOMER_ATTRIBUTE3								varchar(10),            /* 客户其他属性三		    */
CUSTOMER_ATTRIBUTE4								varchar(10),            /* 客户其他属性四		    */
CUSTOMER_ATTRIBUTE5								varchar(10),            /* 客户其他属性五		    */
CUSTOMER_ATTRIBUTE6								varchar(10),            /* 客户其他属性六		    */
CUSTOMER_ATTRIBUTE7								varchar(10),            /* 客户其他属性七		    */
CUSTOMER_ATTRIBUTE8								varchar(10),            /* 客户其他属性八		    */
CUSTOMER_ATTRIBUTE9								varchar(10),            /* 客户其他属性九		    */
CUSTOMER_ATTRIBUTE10							varchar(10),            /* 客户其他属性十		    */
DATA_OWNER										varchar(20),            /* 资料所有者			    */
DATA_OWNED_DEPARTMENT							varchar(10),            /* 资料所属部门		        */
DATA_CREATED_BY									varchar(20),            /* 资料建立者			    */
DATA_CREATED_DEPARTMENT							varchar(10),            /* 资料建立部门		        */
DATA_CREATED_DATE								TIMESTAMP,              /* 资料创建日			    */
DATA_MODIFIED_BY								varchar(20),            /* 资料修改者			    */
LAST_MODIFIED_DATE								TIMESTAMP,              /* 最近修改日	  		    */
DATA_CONFIRMED_BY								varchar(20),            /* 资料审核者			    */
DATA_CONFIRMED_DATE								TIMESTAMP,              /* 资料审核日			    */
STATUS_CODE										varchar(10),            /* 状态码				    */
DEFAULT_PURCHASE_DEPARMENT						varchar(10),            /* 默认采购部门		        */
DEFAULT_SALES_DEPARTMENT						varchar(10),			/* 默认业务部门			    */
OVERDUE_GRACE_QUOTA								DECIMAL(20,6),          /* 逾期账款宽限额度	        */
EXCPQUOTA_VALID_DATE							date,		            /* 除外额度有效日期	        */
CONTACT 										varchar(80),            /* 联系人				    */
CONTACT_NO										varchar(80),            /* 联系电话			        */
MOBILE_NO										varchar(80),            /* 手机号				    */
EMAIL											varchar(80),            /* E-mail				    */
POSTCODE										varchar(10),            /* 邮编				        */
ADDRESS											varchar(255),           /* 地址				        */
COUNTRY_REGION									varchar(10),            /* 国家地区			        */
PROVINCE										varchar(10),            /* 省别				        */
CITY											varchar(10),            /* 城市				        */
COUNTY_DISTRICT									varchar(10),            /* 县区				        */
STREET											varchar(10),            /* 街道				        */
DEFAULT_BILLING_TYPE							varchar(2 ),            /* 默认开票类型		        */
NOTE											varchar(255),           /* 备注				        */
DEFAULT_TAX_CODE								varchar(10),            /* 默认税别			        */
DEFAULT_TAX_RATE								DECIMAL(5,2),           /* 默认税率			        */
DEFAULT_CURRENCY								varchar(10),            /* 默认币别			        */
DEFAULT_BILLING_ORGANIZATION					varchar(10),            /* 默认开票组织		        */
ACCOUNT_RECEIVABLE_TYPE							varchar(10),            /* 应收账款类别		        */
ACCOUNT_OBJECT									varchar(10),            /* 账款对象			        */
BELONGED_ORGANIZATION							varchar(10),            /* 归属组织			        */
BELONGED_CHANNEL_NO								varchar(10),            /* 所属渠道			        */
DELIVERY_OBJECT									varchar(10),            /* 送货对象			        */
REVENUE_CONFIRMATION_DOCUMENT					varchar(10),            /* 收入确认单据		        */
STRIKE_BALANCE_DOCUMENT							varchar(10),            /* 收款冲账单据		        */
LANGUAGE										varchar(10),            /* 語言別				    */
COUNTRY_REGION_NAME								varchar(80),            /* 国家地区名称		        */
PROVINCE_NAME									varchar(80),            /* 省别名称			        */
CITY_NAME										varchar(80),            /* 城市名称			        */
COUNTY_DISTRICT_NAME							varchar(80),            /* 县区名称			        */
STREET_NAME										varchar(80),            /* 街道名称			        */
BILLING_TYPE_DISCRIPTION						varchar(80),            /* 默认开票类型说明	        */
DEFAULT_TAX_DISCRIPTION							varchar(80),            /* 默认税别说明		        */
DEFAULT_CURRENCY_DISCRIPTION					varchar(80),            /* 默认币别说明		        */
BILLING_ORGANIZATION_NAME						varchar(80),            /* 默认开票组织名称	        */
AR_TYPE_DISCRIPTION								varchar(80),            /* 应收账款类别说明	        */
ACCOUNT_OBJECT_DISCRIPTION						varchar(80),            /* 账款对象说明		        */
BELONGED_ORGANIZATION_NAME						varchar(80),            /* 归属组织名称		        */
BELONGED_CHANNEL_NAME							varchar(80),            /* 所属渠道名称		        */
DELIVERY_OBJECT_DISCRIPTION						varchar(80),            /* 送货对象说明		        */
LEGAL_PERSON_NAME								varchar(80),            /* 所属法人名称		        */
GROUP_NAME										varchar(80),            /* 所属集团名称		        */
CUSTOMER_TYPE_DISCRIPTION						varchar(80),            /* 客户分类说明		        */
VENDOR_TYPE_DISCRIPTION							varchar(80),            /* 供应商分类说明		    */
VENDOR_IMPORTANCE_DISCRIPTION					varchar(80),            /* 供应商重要性等级说明     */
CUSTOMER_IMPORTANCE_DISCRIPTION					varchar(80),            /* 客户重要性等级说明	    */
DEFAULT_SALESMAN_NAME							varchar(80),            /* 默认业务员名称		    */
SALES_DEPARTMENT_NAME							varchar(80),            /* 默认业务部门名称	        */
DEFAULT_PURCHASER_NAME							varchar(80),            /* 默认采购员名称		    */
PURCHASE_DEPARMENT_NAME							varchar(80),            /* 默认采购部门名称	        */
CUSTOMER_DEVELOPMENTORG_NAME					varchar(80),            /* 客户制定组织名称	        */
SUPPLIER_DEVELOPMENTORG_NAME					varchar(80),            /* 经销商制定组织名称	    */
QUOTA_CUSTOMER_NAME								varchar(80),            /* 额度客商名称		        */
CREDIT_RATING_DISCRIPTION						varchar(80),            /* 信用评核等级说明	        */
QUOTA_CURRENCY_DISCRIPTION						varchar(80),            /* 额度计算币别说明	        */
CUSTOMER_VENDOR_FULLNAME						varchar(80),            /* 客户/供应商全称		    */
CUSTOMER_VENDOR_SHORTNAME						varchar(80),            /* 客户/供应商简称		    */

PRIMARY KEY (CUSTOMER_VENDOR,BELONGED_ORGANIZATION,LANGUAGE)
);





# 050 交易对象地址档
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-21
# 

DROP TABLE IF EXISTS BAS_TRANSOBJECT_ADDRESS;

CREATE TABLE BAS_TRANSOBJECT_ADDRESS(
STATUS_CODE							varchar(10),		/* 状态码			*/		
CUSTOMER_VENDOR						varchar(20),        /* 对象编号		    */
ADDRESS_NO							varchar(20),        /* 地址編號		    */
ADDRESS_TYPE						varchar(10),        /* 地址类型 		*/
IS_PRIMARY_ADDRESS					varchar(1),         /* 主要联络地址	    */
COUNTRY_REGION						varchar(10),        /* 国家地区		    */
POSTCODE							varchar(10),        /* 邮政编号		    */
PROVINCE							varchar(10),        /* 省别			    */
CITY								varchar(10),        /* 城市			    */
COUNTY_DISTRICT						varchar(10),        /* 县区			    */
STREET								varchar(12),        /* 街道			    */
DETAILED_ADDRESS					varchar(255),       /* 详细地址		    */
LANGUAGE							varchar(10),        /* 語言別			*/
COUNTRY_REGION_NAME					varchar(80),        /* 国家地区名称	    */
PROVINCE_NAME						varchar(80),        /* 省别名称		    */
CITY_NAME							varchar(80),        /* 城市名称		    */
COUNTY_DISTRICT_NAME				varchar(80),        /* 县区名称		    */
STREET_NAME							varchar(80),        /* 街道名称		    */
CUSTOMER_VENDOR_SHORTNAME			varchar(80),        /* 对象简称		    */

PRIMARY KEY (CUSTOMER_VENDOR,ADDRESS_NO,LANGUAGE)
);





# 051 交易对象通信方式档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-21
# 

DROP TABLE IF EXISTS BAS_TRANSOBJECT_COMMUNICATION;

CREATE TABLE BAS_TRANSOBJECT_COMMUNICATION(
STATUS_CODE							varchar(10),		/* 状态码			*/					
COMMUNICATION_NO					varchar(20),		/* 通信方式编号		*/
CUSTOMER_VENDOR						varchar(10),		/* 对象编号			*/	
COMMUNICATION_TYPE					varchar(10),		/* 通信类型			*/				
BRIEF_NAME							varchar(80),        /* 简要说明	        */
COMMUNICATION_CONTENT				varchar(255),		/* 通信内容			*/					
LANGUAGE							varchar(10),        /* 語言別		    */
CUSTOMER_VENDOR_SHORTNAME			varchar(80),        /* 对象简称	        */

PRIMARY KEY (COMMUNICATION_NO,CUSTOMER_VENDOR,LANGUAGE)
);





# 052 交易对象收付款条件维护档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-21
# 

DROP TABLE IF EXISTS BAS_TRANSCOLLECTIONPAYMENT_TERM;

CREATE TABLE BAS_TRANSCOLLECTIONPAYMENT_TERM(
CUSTOMER_VENDOR							varchar(10),			/* 对象编号				*/		
COLLECTION_PAYMENT_TERM					varchar(10),            /* 允许收付款条件		*/
TRANSACTION_TYPE						varchar(10),            /* 交易类型			    */
IS_MAIN									varchar(1),             /* 主要否				*/
STATUS_CODE								varchar(10),            /* 状态码				*/
BELONGED_ORGANIZATION					varchar(10),            /* 归属组织			    */
LANGUAGE								varchar(10),            /* 語言別				*/
COLLECTIONPAYMENT_TERM_DISCRIPTION		varchar(80),            /* 允许收付款条件说明	*/
CUSTOMER_VENDOR_SHORTNAME				varchar(80),            /* 对象简称			    */
BELONGED_ORGANIZATION_NAM				varchar(80),            /* 归属组织名称		    */

PRIMARY KEY (CUSTOMER_VENDOR,COLLECTION_PAYMENT_TERM,BELONGED_ORGANIZATION,LANGUAGE)
);





# 053 交易对象证照资料维护档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-21
# 

DROP TABLE IF EXISTS BAS_TRANSOBJECT_ID;

CREATE TABLE BAS_TRANSOBJECT_ID(
CUSTOMER_VENDOR						varchar(10),		/* 对象编号			*/	
BELONGED_ORGANIZATION				varchar(10),        /* 归属组织		    */
ID_CODE								varchar(20),        /* 证照号码		    */
ID_TYPE								varchar(10),        /* 证照类别		    */
ID_TYPE_DISCRIPTION					varchar(255),       /* 证照类别说明	    */
ID_NAME								varchar(10),        /* 证照名称		    */
VALID_DATE							date,               /* 生效日期		    */
INVALID_DATE						date,               /* 失效日期		    */
STATUS_CODE							varchar(10),        /* 状态码			*/
BELONGED_ORGANIZATION_NAME			varchar(80),        /* 归属组织名称	    */
CUSTOMER_VENDOR_SHORTNAME			varchar(80),        /* 对象简称		    */

PRIMARY KEY (CUSTOMER_VENDOR,ID_CODE,BELONGED_ORGANIZATION)
);





# 054 交易对象开票对象维护档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-21
# 

DROP TABLE IF EXISTS BAS_TRANSOBJECT_INVOICEOBJECT;

CREATE TABLE BAS_TRANSOBJECT_INVOICEOBJECT(
CUSTOMER_VENDOR						varchar(10),		/* 对象编号			*/
BELONGED_ORGANIZATION				varchar(10),        /* 归属组织	        */
TAX_CODE							varchar(20),        /* 税号		        */
DISCRIPTION							varchar(255),       /* 说明		        */
STATUS_CODE							varchar(10),        /* 状态码		    */
CUSTOMER_VENDOR_SHORTNAME			varchar(80),        /* 对象简称	        */
BELONGED_ORGANIZATION_NAME			varchar(80),        /* 归属组织名称     */
DETAILED_ADDRESS					varchar(255),       /* 详细地址	        */
                                                       
PRIMARY KEY (CUSTOMER_VENDOR,TAX_CODE,BELONGED_ORGANIZATION)
);





# 055 交易对象组织范围维护档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-21
# 

DROP TABLE IF EXISTS BAS_TRANSOBJECT_ORGSCOPE;

CREATE TABLE BAS_TRANSOBJECT_ORGSCOPE(
CUSTOMER_VENDOR						varchar(10),		/* 对象编号			*/	
BELONGED_ORGANIZATION				varchar(10),        /* 归属组织		    */
ORGANIZATION						varchar(10),        /* 组织编号		    */
STATUS_CODE							varchar(10),        /* 状态码			*/
LANGUAGE							varchar(10),        /* 語言別			*/
CUSTOMER_VENDOR_SHORTNAME			varchar(80),        /* 对象简称		    */
ORGANIZATION_NAME					varchar(80),        /* 组织名称		    */
BELONGED_ORGANIZATION_NAME			varchar(80),        /* 归属组织名称	    */
                                                       
PRIMARY KEY (CUSTOMER_VENDOR,ORGANIZATION_NAME,BELONGED_ORGANIZATION,ORGANIZATION,LANGUAGE)
);

