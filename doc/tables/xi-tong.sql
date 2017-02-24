# 系统级别的表

# 001 单别设置档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-17
# 

DROP TABLE IF EXISTS SYS_DOCUMENT_SETTING;  

CREATE TABLE SYS_DOCUMENT_SETTING(			                 
DOCUMENT						varchar(5),				/* 单据别			*/	
MODULE							varchar(4),             /* 模组别			*/
DOCUMENT_TYPE					varchar(20),            /* 单据性质		    */
CORRESPONDING_PROGRAM_NO		varchar(20),            /* 对应作业编号	    */
IS_AUTO_NUMERING				varchar(1),             /* 自动编码否		*/
PERIOD_CODE						varchar(1),             /* 期别码			*/
SERIAL_NUMBER_LENGTH			DECIMAL(5,0),           /* 流水号长度		*/
NUMBERING_RESULT				varchar(20),            /* 编号结果		    */
DATA_OWNER						varchar(20),            /* 资料所有者		*/
DATA_OWNED_DEPARTMENT			varchar(10),            /* 资料所有部门	    */
DATA_CREATED_BY					varchar(20),            /* 资料录入者		*/
DATA_CREATED_DEPARTMENT			varchar(10),            /* 资料录入部门	    */
DATA_CREATED_DATE				TIMESTAMP,              /* 资料创建日		*/
DATA_MODIFIED_BY				varchar(20),            /* 资料更改者		*/
LAST_MODIFIED_DATE				TIMESTAMP,              /* 最近更改日		*/
STATUS_CODE						varchar(10),            /* 状态码			*/
LANGUAGE						varchar(10),            /* 语言别			*/
DOCUMENT_NAME					varchar(80),            /* 单据别名称		*/
CORRESPONDING_PROGRAM_NAME		varchar(80),            /* 对应作业名称	    */

PRIMARY KEY (DOCUMENT,LANGUAGE)
);





# 002 单别维护档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-17
# 

DROP TABLE IF EXISTS SYS_DOCUMENT;  

CREATE TABLE SYS_DOCUMENT(			                 
STATUS_CODE						varchar(10),		/* 状态码			*/       	   				
REFERENCE_TABLE_NO				varchar(5 ),        /* 参照表编号		*/
DOCUMENT						varchar(5),	        /* 单据别			*/
DATA_OWNER						varchar(20),        /* 资料所有者		*/
DATA_OWNED_DEPARTMENT			varchar(10),        /* 资料所有部门	    */
DATA_CREATED_BY					varchar(20),        /* 资料录入者		*/
DATA_CREATED_DEPARTMENT			varchar(10),        /* 资料录入部门	    */
DATA_CREATED_DATE				TIMESTAMP,          /* 资料创建日		*/
DATA_MODIFIED_BY				varchar(20),        /* 资料更改者		*/
LAST_MODIFIED_DATE				TIMESTAMP,			/* 最近更改日		*/				
NOTE							varchar(255),		/* 备注				*/				
MODULE							varchar(4),         /* 模组别			*/
DOCUMENT_TYPE					varchar(20),        /* 单据性质		    */
CORRESPONDING_PROGRAM_NO		varchar(20),        /* 对应作业编号	    */
IS_AUTO_NUMERING				varchar(1),         /* 自动编码否		*/
PERIOD_CODE						varchar(1),         /* 期别码			*/
SERIAL_NUMBER_LENGTH			DECIMAL(5,0),       /* 流水号长度		*/
NUMBERING_RESULT				varchar(20),        /* 编号结果		    */
DEFAULT_DOCUMENT				varchar(1),         /* 默认单别		    */
LANGUAGE						varchar(10),        /* 语言别			*/
REFERENCE_TABLE_DESCRIPTION		varchar(80),        /* 参照表说明		*/
DOCUMENT_NAME					varchar(80),        /* 单据别名称		*/
MODULE_NAME						varchar(80),        /* 模组名称		    */
CORRESPONDING_PROGRAM_NAME		varchar(80),        /* 对应作业名称	    */

PRIMARY KEY (REFERENCE_TABLE_NO,DOCUMENT,LANGUAGE)
);





# 003 单别最大流水号记录档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-17
# 

DROP TABLE IF EXISTS SYS_MAXIMUM_SERIALNO;  

CREATE TABLE SYS_MAXIMUM_SERIALNO(			                 
OPERATION_ORGANIZATION			varchar(10),		/* 营运组织				*/
ORGANIZATION_SIMPLE_CODE		varchar(5),         /* 组织简码			    */
DOCUMENT						varchar(5),         /* 单据别				*/
PERIOD_CODE						varchar(10),        /* 期别码				*/
MAXIMUM_SERIAL_NO				DECIMAL(10,0),      /* 最大流水号			*/
MAXIMUM_DOCUMENT_NO				varchar(20),        /* 最大流水号完整单号	*/

PRIMARY KEY (OPERATION_ORGANIZATION,ORGANIZATION_SIMPLE_CODE,DOCUMENT,PERIOD_CODE)
);





# 004 自动编码设置档 
# v0.1
# 创建者: 陈松
# 
# 历史:
# 创建于 2017-02-17
# 

DROP TABLE IF EXISTS BAS_AUTO_NUMBERING;  

CREATE TABLE BAS_AUTO_NUMBERING(			                 
RULE_NUMBER								varchar(20),           /*规则编码	     */	
TOTAL_NUMBERING_LENGTH					DECIMAL(5,0),          /*编码总长度		 */
NUMBERING_RESULT						varchar(40),           /*编码结果		 */
PROGRAM_NO								varchar(20),           /*作业编号		 */
TABLE_NO								varchar(80),           /*表				 */
NUMBERING_FIELD_NO						varchar(80),           /*编码字段		 */
NOTE									varchar(255),          /*备注			 */
SERIAL_NO								DECIMAL(5,0),          /*序号			 */
NUMBERED_ITEM							varchar(1),            /*编码项目		 */
FIELD_NO								varchar(80),           /*字段			 */
DATE_FORMAT								varchar(1),            /*日期格式		 */
DISPLAY_FORMAT							varchar(40),           /*展示格式		 */
LENGTH									DECIMAL(5,0),          /*长度			 */
DATA_OWNER								varchar(20),           /*资料所有者		 */
DATA_OWNED_DEPARTMENT					varchar(10),           /*资料所有部门	 */
DATA_CREATED_BY							varchar(20),           /*资料录入者		 */
DATA_CREATED_DEPARTMENT					varchar(10),           /*资料录入部门	 */
DATA_CREATED_DATE						TIMESTAMP,             /*资料创建日		 */
DATA_MODIFIED_BY						varchar(20),           /*资料更改者		 */
LAST_MODIFIED_DATE						TIMESTAMP,             /*最近更改日		 */
STATUS_CODE								varchar(10),           /*状态码			 */
LANGUAGE								varchar(10),           /*语言别			 */
RULE_NUMBER_DESCRIPTION					varchar(80),           /*规则编码说明	 */
PRAGRAM_NAME							varchar(80),           /*作业名称		 */
TABLE_NAME								varchar(80),           /*表名称			 */
NUMBERING_FIELD_NAME					varchar(80),           /*编码字段名称	 */
FIELD_NAME								varchar(80),           /*字段名称		 */

PRIMARY KEY (RULE_NUMBER,SERIAL_NO,LANGUAGE)
);


