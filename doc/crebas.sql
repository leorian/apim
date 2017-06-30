/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/29 星期四 15:31:52                       */
/*==============================================================*/


drop table if exists T_API_INTERFACE;

drop table if exists T_API_INTERFACE_METHOD;

drop table if exists T_API_INTERFACE_METHOD_PARAMETER;

drop table if exists T_API_INTERFACE_METHOD_RETURNTYPE;

drop table if exists T_API_INTERFACE_REQUEST;

drop table if exists T_API_INTERFACE_RESPONSE;

drop table if exists T_API_PROJECT;

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
   primary key (interfaceId)
);

alter table T_API_INTERFACE comment '项目接口表';

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
   primary key (returnTypeId)
);

alter table T_API_INTERFACE_METHOD_RETURNTYPE comment '接口方法返回值类型';

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
   primary key (interfaceResponseId)
);

alter table T_API_INTERFACE_RESPONSE comment '接口出参表';

/*==============================================================*/
/* Table: T_API_PROJECT                                         */
/*==============================================================*/
create table T_API_PROJECT
(
   projectId            bigint not null comment '项目ID',
   projectName          varchar(100) comment '项目名称',
   projectDescribe      varchar(512) comment '项目描述',
   projectManager       bigint not null comment '项目经理',
   primary key (projectId)
);

alter table T_API_PROJECT comment '项目表';

/*==============================================================*/
/* Table: T_API_PROJECT_MEMBER                                  */
/*==============================================================*/
create table T_API_PROJECT_MEMBER
(
   projectMemberId      bigint not null comment '项目成员关系ID',
   projectId            bigint comment '项目ID',
   userId               bigint comment '用户ID',
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
   group                varchar(32) comment '组',
   version              varchar(32) comment '版本',
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

alter table T_API_PROJECT_MEMBER add constraint FK_Reference_2 foreign key (projectId)
      references T_API_PROJECT (projectId) on delete restrict on update restrict;

alter table T_API_PROJECT_MEMBER add constraint FK_Reference_3 foreign key (userId)
      references T_API_USER (userId) on delete restrict on update restrict;

alter table T_API_PUBLISHER add constraint FK_Reference_5 foreign key (interfaceId)
      references T_API_INTERFACE (interfaceId) on delete restrict on update restrict;

