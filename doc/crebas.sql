/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/7/10 星期一 10:35:43                       */
/*==============================================================*/


drop table if exists T_API_INTERFACE;

drop table if exists T_API_INTERFACE_HTTP;

drop table if exists T_API_INTERFACE_METHOD;

drop table if exists T_API_INTERFACE_METHOD_PARAMETER;

drop table if exists T_API_INTERFACE_METHOD_RETURNTYPE;

drop table if exists T_API_INTERFACE_PARAM;

drop table if exists T_API_INTERFACE_REQUEST;

drop table if exists T_API_INTERFACE_RESPONSE;

drop table if exists T_API_INTERFACE_RESULT;

drop table if exists T_API_INTERFACE_RPC;

drop table if exists T_API_PROJECT;

drop table if exists T_API_PROJECT_DEPLOY;

drop table if exists T_API_PROJECT_MEMBER;

drop table if exists T_API_PUBLISHER;

drop table if exists T_API_USER;

/*==============================================================*/
/* Table: T_API_INTERFACE                                       */
/*==============================================================*/
create table T_API_INTERFACE
(
   interfaceId          bigint not null comment '接口ID',
   projectId            bigint comment '项目ID',
   interfaceName        varchar(100) comment '接口名称',
   interfaceType        int comment '接口类型',
   interfaceAddress     varchar(256) comment '接口地址',
   requestMethod        int comment '请求方式',
   createUserId         bigint,
   createDateTime       datetime,
   updateUserId         bigint,
   updateDateTime       datetime,
   primary key (interfaceId)
);

alter table T_API_INTERFACE comment '项目接口表';

/*==============================================================*/
/* Table: T_API_INTERFACE_HTTP                                  */
/*==============================================================*/
create table T_API_INTERFACE_HTTP
(
   id                   varchar(64) not null comment '接口ID主键',
   appId                int comment '应用ID',
   protocol             varchar(5) comment '协议(HTTPS/HTTP)',
   method               varchar(10) comment '请求方式（GET/POST）',
   transformat          varchar(10) comment '传输格式（JSON/XML/HTML）',
   address              varchar(256) comment '接口地址',
   name                 varchar(128) comment '接口名称',
   description           varchar(512) comment '接口描述',
   createId             varchar(32) comment '创建人ID',
   createDateTime       datetime comment '创建时间',
   updateId             varchar(32) comment '更新人ID',
   updateDateTime       datetime comment '更新时间',
   primary key (id)
);

alter table T_API_INTERFACE_HTTP comment 'HTTP接口表';
--新版本
create table T_API_INTERFACE_HTTP
(
   id                   BIGINT not null comment '接口ID主键',
   appId                BIGINT comment '应用ID',
   protocol             varchar(5) comment '协议(HTTPS/HTTP)',
   method               varchar(10) comment '请求方式（GET/POST）',
   transformat          varchar(10) comment '传输格式（JSON/XML/HTML）',
   address              varchar(256) comment '接口地址',
   name                 varchar(128) comment '接口名称',
   description           varchar(512) comment '接口描述',
   createUserId             BIGINT comment '创建人ID',
   createDateTime       datetime comment '创建时间',
   updateUserId             BIGINT comment '更新人ID',
   updateDateTime       datetime comment '更新时间',
   primary key (id)
);

alter table T_API_INTERFACE_HTTP comment 'HTTP接口表';

/*==============================================================*/
/* Table: T_API_INTERFACE_METHOD                                */
/*==============================================================*/
create table T_API_INTERFACE_METHOD
(
   interfaceMethodId    bigint not null comment '接口方法ID',
   interfaceId          bigint comment '接口ID',
   interfaceMethodName  varchar(100) comment '方法名称',
   functionDescribe     varchar(256) comment '功能说明',
   methodParameter      varchar(512) comment '方法参数',
   returnType           varchar(512) comment '返回值类型',
   createUserId         bigint,
   createDateTime       datetime,
   updateUserId         bigint,
   updateDateTime       datetime,
   primary key (interfaceMethodId)
);

alter table T_API_INTERFACE_METHOD comment '接口方法表';

/*==============================================================*/
/* Table: T_API_INTERFACE_METHOD_PARAMETER                      */
/*==============================================================*/
create table T_API_INTERFACE_METHOD_PARAMETER
(
   parameterId          bigint not null comment '参数ID',
   interfaceMethodId    bigint comment '接口方法ID',
   methodId             bigint comment '方法ID',
   parameterIndex       int comment '参数索引',
   parameterTypeShortName varchar(32) comment '参数类型简称',
   parameterTypeFullName varchar(128) comment '参数类型全称',
   parameterName        varchar(64) comment '参数名称',
   parameterMeaning     varchar(256) comment '参数解释',
   parameterRequired    int comment '是否必填',
   code                 text comment '源代码',
   createUserId         bigint,
   createDateTime       datetime,
   updateUserId         bigint,
   updateDateTime       datetime,
   primary key (parameterId)
);

alter table T_API_INTERFACE_METHOD_PARAMETER comment '接口方法参数表';

/*==============================================================*/
/* Table: T_API_INTERFACE_METHOD_RETURNTYPE                     */
/*==============================================================*/
create table T_API_INTERFACE_METHOD_RETURNTYPE
(
   returnTypeId         bigint not null comment '返回值类型ID',
   interfaceMethodId    bigint comment '接口方法ID',
   methodId             bigint comment '方法ID',
   returnTypeShortName  varchar(32) comment '返回值类型简称',
   returnTypeFullName   varchar(128) comment '返回值类型全称',
   code                 text comment '代码',
   createUserId         bigint,
   createDateTime       datetime,
   updateUserId         bigint,
   updateDateTime       datetime,
   primary key (returnTypeId)
);

alter table T_API_INTERFACE_METHOD_RETURNTYPE comment '接口方法返回值类型';

/*==============================================================*/
/* Table: T_API_INTERFACE_PARAM                                 */
/*==============================================================*/
create table T_API_INTERFACE_PARAM
(
   id                   varchar(64) comment '接口参数主键',
   interfaceId          varchar(64) comment '接口ID',
   interfaceType        varchar(10) comment '接口类型',
   paramName            varchar(128) comment '参数名称',
   paramType            varchar(32) comment '参数类型',
   paramDescribe        varchar(512) comment '参数描述',
   required             bool comment '是否必填',
   jsontransformat      bool comment '是否JSON格式化传输',
   example              varchar(512) comment '示例',
   defaultValue         varchar(512) comment '默认值',
   createId             varchar(32) comment '创建人ID',
   createDateTime       datetime comment '创建时间',
   updateId             varchar(32) comment '更新人ID',
   updateDateTime       datetime comment '更新时间'
);

alter table T_API_INTERFACE_PARAM comment '接口参数表';

--新版本
create table T_API_INTERFACE_PARAM
(
   id                   BIGINT comment '接口参数主键',
   interfaceId          BIGINT comment '接口ID',
   interfaceType        varchar(10) comment '接口类型',
   paramName            varchar(128) comment '参数名称',
   paramType            varchar(32) comment '参数类型',
   paramDescribe        varchar(512) comment '参数描述',
   required             bool comment '是否必填',
   jsontransformat      bool comment '是否JSON格式化传输',
   example              varchar(512) comment '示例',
   defaultValue         varchar(512) comment '默认值',
   createUserId             BIGINT comment '创建人ID',
   createDateTime       datetime comment '创建时间',
   updateUserId             BIGINT comment '更新人ID',
   updateDateTime       datetime comment '更新时间'
);

alter table T_API_INTERFACE_PARAM comment '接口参数表';

/*==============================================================*/
/* Table: T_API_INTERFACE_REQUEST                               */
/*==============================================================*/
create table T_API_INTERFACE_REQUEST
(
   interfaceRequestId   bigint not null comment '接口入参ID',
   interfaceId          bigint comment '接口ID',
   location             int comment '入参位置',
   requestParameterName varchar(64) comment '入参名称',
   requestParameterType varchar(64) comment '入参类型',
   parameterRequired    int comment '是否必填',
   parameterDescribe    varchar(512) comment '参数说明',
   createUserId         bigint,
   createDateTime       datetime,
   updateUserId         bigint,
   updateDateTime       datetime,
   primary key (interfaceRequestId)
);

alter table T_API_INTERFACE_REQUEST comment '接口入参表';

/*==============================================================*/
/* Table: T_API_INTERFACE_RESPONSE                              */
/*==============================================================*/
create table T_API_INTERFACE_RESPONSE
(
   interfaceResponseId  bigint not null comment '接口出参ID',
   interfaceId          bigint comment '接口ID',
   scene                int comment '场景',
   responseReturnMode   int comment '返回类型',
   responseExample      text comment '返回示例',
   responseRemark       text comment '返回备注',
   createUserId         bigint,
   createDateTime       datetime,
   updateUserId         bigint,
   updateDateTime       datetime,
   primary key (interfaceResponseId)
);

alter table T_API_INTERFACE_RESPONSE comment '接口出参表';

/*==============================================================*/
/* Table: T_API_INTERFACE_RESULT                                */
/*==============================================================*/
create table T_API_INTERFACE_RESULT
(
   id                   varchar(64) not null comment '接口返回示例ID',
   interfaceId          varchar(64) comment '接口ID',
   interfaceType        varchar(64) comment '接口类型',
   exampleType          varchar(32) comment '示例类型（返回示例/异常示例）',
   exampleContent       varchar(512) comment '示例内容',
   attentionMatters     varchar(512) comment '注意事项',
   createId             varchar(32) comment '创建人ID',
   createDateTime       datetime comment '创建时间',
   updateId             varchar(32) comment '更新人ID',
   updateDateTime       datetime comment '更新时间',
   primary key (id)
);

alter table T_API_INTERFACE_RESULT comment '接口返回示例表';

/*==============================================================*/
/* Table: T_API_INTERFACE_RPC                                   */
/*==============================================================*/
create table T_API_INTERFACE_RPC
(
   id                   varchar(64) not null comment '接口ID',
   appId                int comment '应用ID',
   name                 varchar(128) comment '接口名称',
   className            varchar(256) comment '类全路径名称',
   methodName           varchar(128) comment '方法名称',
   functionDescribe     varchar(512) comment '功能描述',
   returnType           varchar(256) comment '返回值类型',
   methodParam          varchar(512) comment '方法参数',
   createId             varchar(32) comment '创建人ID',
   createDateTime       datetime comment '创建时间',
   updateId             varchar(32) comment '更新人ID',
   updateDateTime       datetime comment '更新时间',
   primary key (id)
);

alter table T_API_INTERFACE_RPC comment 'RPC接口表';

/*==============================================================*/
/* Table: T_API_PROJECT                                         */
/*==============================================================*/
create table T_API_PROJECT
(
   projectId            bigint not null comment '项目ID',
   projectName          varchar(100) comment '项目名称',
   projectDescribe      varchar(512) comment '项目描述',
   projectManager       bigint not null comment '项目经理',
   createUserId         bigint,
   createDateTime       datetime,
   updateUserId         bigint,
   updateDateTime       datetime,
   primary key (projectId)
);

alter table T_API_PROJECT comment '项目表';

/*==============================================================*/
/* Table: T_API_PROJECT_DEPLOY                                  */
/*==============================================================*/
create table T_API_PROJECT_DEPLOY
(
   deployId             bigint not null comment '发布ID',
   projectId            bigint comment '项目ID',
   env                  varchar(10) comment '环境',
   ip                   varchar(20) comment 'IP地址',
   port                 int comment '端口号',
   path                 varchar(512) comment 'tomcat等服务器系统路径',
   createUserId         bigint comment '创建人',
   createDateTime       datetime comment '创建时间',
   updateUserId         bigint comment '更新人',
   updateDateTime       datetime comment '更新时间',
   loginAccount         varchar(32) comment '登录账号',
   loginPassword        varchar(256) comment '登录密码',
   loginPort            int comment '登录监听的端口号',
   loginProtocol        varchar(10) comment '登录所用的协议',
   loginOs              varchar(20) comment '登录的系统',
   primary key (deployId)
);

alter table T_API_PROJECT_DEPLOY comment '项目部署情况表';

/*==============================================================*/
/* Table: T_API_PROJECT_MEMBER                                  */
/*==============================================================*/
create table T_API_PROJECT_MEMBER
(
   projectMemberId      bigint not null comment '项目成员关系ID',
   projectId            bigint comment '项目ID',
   userId               bigint comment '用户ID',
   createUserId         bigint,
   createDateTime       datetime,
   updateUserId         bigint,
   updateDateTime       datetime,
   primary key (projectMemberId)
);

alter table T_API_PROJECT_MEMBER comment '项目成员关系表';

/*==============================================================*/
/* Table: T_API_PUBLISHER                                       */
/*==============================================================*/
create table T_API_PUBLISHER
(
   publisherId          bigint not null comment '发布管理ID',
   interfaceId          bigint comment '接口ID',
   environment          int comment '环境',
   interfaceRealAddress varchar(256) comment '接口实际调用地址',
   groupName            varchar(32) comment '组',
   version              varchar(32) comment '版本',
   createUserId         bigint,
   createDateTime       datetime,
   updateUserId         bigint,
   updateDateTime       datetime,
   primary key (publisherId)
);

alter table T_API_PUBLISHER comment '发布管理表';

/*==============================================================*/
/* Table: T_API_USER                                            */
/*==============================================================*/
create table T_API_USER
(
   userId               bigint not null comment '用户ID',
   usName               varchar(32) comment '用户英文名称',
   cnName               varchar(32) comment '用户中文名称',
   userRole             int comment '用户身份',
   cellPhone            varchar(11) comment '手机号码',
   email                varchar(50) comment '工作邮箱',
   password             varchar(256),
   createUserId         bigint,
   createDateTime       datetime,
   updateUserId         bigint,
   updateDateTime       datetime,
   primary key (userId)
);

alter table T_API_USER comment '用户表';

alter table T_API_INTERFACE add constraint FK_Reference_4 foreign key (projectId)
      references T_API_PROJECT (projectId) on delete restrict on update restrict;

alter table T_API_INTERFACE_METHOD add constraint FK_Reference_6 foreign key (interfaceId)
      references T_API_INTERFACE (interfaceId) on delete restrict on update restrict;

alter table T_API_INTERFACE_METHOD_PARAMETER add constraint FK_Reference_7 foreign key (interfaceMethodId)
      references T_API_INTERFACE_METHOD (interfaceMethodId) on delete restrict on update restrict;

alter table T_API_INTERFACE_METHOD_RETURNTYPE add constraint FK_Reference_8 foreign key (interfaceMethodId)
      references T_API_INTERFACE_METHOD (interfaceMethodId) on delete restrict on update restrict;

alter table T_API_INTERFACE_REQUEST add constraint FK_Reference_9 foreign key (interfaceId)
      references T_API_INTERFACE (interfaceId) on delete restrict on update restrict;

alter table T_API_INTERFACE_RESPONSE add constraint FK_Reference_10 foreign key (interfaceId)
      references T_API_INTERFACE (interfaceId) on delete restrict on update restrict;

alter table T_API_PROJECT add constraint FK_Reference_1 foreign key (projectManager)
      references T_API_USER (userId) on delete restrict on update restrict;

alter table T_API_PROJECT_DEPLOY add constraint FK_Reference_11 foreign key (projectId)
      references T_API_PROJECT (projectId) on delete restrict on update restrict;

alter table T_API_PROJECT_MEMBER add constraint FK_Reference_2 foreign key (projectId)
      references T_API_PROJECT (projectId) on delete restrict on update restrict;

alter table T_API_PROJECT_MEMBER add constraint FK_Reference_3 foreign key (userId)
      references T_API_USER (userId) on delete restrict on update restrict;

alter table T_API_PUBLISHER add constraint FK_Reference_5 foreign key (interfaceId)
      references T_API_INTERFACE (interfaceId) on delete restrict on update restrict;

