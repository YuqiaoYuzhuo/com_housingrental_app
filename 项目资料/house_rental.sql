/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/1/25 22:07:09                           */
/*==============================================================*/


drop table if exists TB_AREA_HOUSE_REL;

drop table if exists TB_ATTACHMENT;

drop table if exists TB_BACK_MONEY_CERTIFICATE;

drop table if exists TB_BASE_AREA;

drop table if exists TB_BUSINESS_ATTACHMENT_REL;

drop table if exists TB_CANCLE_RENTAL;

drop table if exists TB_DICT;

drop table if exists TB_DICT_TYPE;

drop table if exists TB_HOUSE;

drop table if exists TB_HOUSE_SPC_REL;

drop table if exists TB_HOUSE_SURROUND_REL;

drop table if exists TB_ORDER;

drop table if exists TB_PAYMENT_CERTIFICATE;

drop table if exists TB_PROMPT;

drop table if exists TB_RENTAL;

drop table if exists TB_RENTAL_PRICE_RANGE_REL;

drop table if exists TB_RENTAL_TYPE_REL;

drop table if exists TB_USER_ACCOUNT;

drop table if exists TB_USER_INO;

/*==============================================================*/
/* Table: TB_AREA_HOUSE_REL                                     */
/*==============================================================*/
create table TB_AREA_HOUSE_REL
(
   AREA_HOUSE_REL_UUID  varchar(64) not null comment '关联关系标示',
   HOUSE_UUID           varchar(64) comment '房屋标示',
   AREA_UUID            int comment '地域行政区划标示',
   primary key (AREA_HOUSE_REL_UUID)
);

alter table TB_AREA_HOUSE_REL comment '房屋与地址关联关系表';

/*==============================================================*/
/* Table: TB_ATTACHMENT                                         */
/*==============================================================*/
create table TB_ATTACHMENT
(
   ATTACH_UUID          varchar(64) not null comment '附件标示',
   ATTACH_SYS_NAME      varchar(200) comment '附件系统名称',
   ATTACH_REAL_NAME     varchar(200) comment '附件原名称',
   ATTACH_TYPE          int comment '附件类型',
   ATTACH_SYS_PATH      varchar(100) comment '附件系统路径',
   ATTACH_UP_PATH       varchar(100) comment '附件原上传路径',
   ATTACH_SIZE          double comment '附件大小',
   ATTACH_ETC           varchar(20) comment '附件后缀',
   ATTACH_UP_TIME       timestamp comment '附件上传时间',
   ATTACH_UP_PERSON     varchar(64) comment '附件上传人标示',
   ATTACH_MEMO          varchar(255) comment '备注',
   ATTACH_MODIFY_TIME   timestamp comment '附件最后修改时间',
   primary key (ATTACH_UUID)
);

alter table TB_ATTACHMENT comment '附件表';

/*==============================================================*/
/* Table: TB_BACK_MONEY_CERTIFICATE                             */
/*==============================================================*/
create table TB_BACK_MONEY_CERTIFICATE
(
   BACK_CERTIFICATE_UUID varchar(64) not null comment '退款凭证标示',
   BACK__CERTIFICATE_USER_UUID varchar(64) comment '退款人标示',
   BACK__CERTIFICATE_HANDEL_PERSON varchar(64) comment '收款人标示',
   BACK__CERTIFICATE_USER_NAME varchar(200) comment '退款人姓名',
   BACK__CERTIFICATE_HANDEL_PERSON_NAME varchar(200) comment '收款人姓名',
   BACK__AMT            double comment '退款金额',
   BACK__AMT_STR        varchar(200) comment '退款金额大写',
   BACK__TIME           timestamp comment '退款日期',
   BACK_STYLE           timestamp comment '退款方式',
   BACK__RESON          varchar(225) comment '退费事项',
   BACK_STAUS           int comment '状态',
   primary key (BACK_CERTIFICATE_UUID)
);

alter table TB_BACK_MONEY_CERTIFICATE comment '退款凭证';


/*==============================================================*/
/* Table: TB_BUSINESS_ATTACHMENT_REL                            */
/*==============================================================*/
create table TB_BUSINESS_ATTACHMENT_REL
(
   ATTACH_REL_UUID      varchar(64) not null comment '关联关系标示',
   ATTACH_UUID          varchar(64) not null comment '附件标示',
   BUSINESS_UUDI        varchar(64) comment '业务标示',
   ATTACH_MEMO          varchar(225) comment '备注',
   ATTACH_REL_LASTMODIFY_TIME timestamp comment '最后修改时间',
   primary key (ATTACH_REL_UUID)
);

alter table TB_BUSINESS_ATTACHMENT_REL comment '附件业务关联关系表';

/*==============================================================*/
/* Table: TB_CANCLE_RENTAL                                      */
/*==============================================================*/
create table TB_CANCLE_RENTAL
(
   CANCLE_RENTAL_UUID   varchar(64) not null comment '退租标示',
   CANCLE_RENTAL_HOUSE_UUID varchar(64) comment '退租房间标示',
   CANCLE_RENTAL_DATE   date comment '退租日期',
   CANCLE_RENTAL_STAUS  int comment '退租状态',
   RENTAL_IS_OVER       int comment '租赁合约是否到期',
   RENATL_OVER_DATE     date comment '租赁合约到期时间',
   IS_BACK_MONEY        int comment '是否需要退款',
   BACK_PRICE           double comment '退款金额',
   IS_PENATLY           int comment '是否缴纳违约金',
   RENATLY_AMT          double comment '缴纳违约金金额',
   RENTAL_CANALE_RESON  int comment '退租原因',
   CANCLE_RENTAL_ADVICE varchar(1000) comment '退租建议',
   CANCLE_HANDLE_PSERSON varchar(64) comment '退租经办人',
   CANCLE_APPLY_PERSON  varchar(64) comment '退租申请人',
   CANCLE_HABDEL_PERSON_NAME varchar(100) comment '退租经办人姓名',
   CANCLE_APPLY_PERSON_NAME varchar(100) comment '退租申请人姓名',
   CANCLE_LAST_MODIFY_TIME timestamp comment '最后修改时间',
   primary key (CANCLE_RENTAL_UUID)
);

alter table TB_CANCLE_RENTAL comment '退租情况表';

/*==============================================================*/
/* Table: TB_DICT                                               */
/*==============================================================*/
create table TB_DICT
(
   DICT_UUID            varchar(64) not null comment '字典码标示',
   DCIT_TYPEUUID        varchar(64) comment '字典类型标示',
   DCIT_ENUM            int comment '字典码值',
   DICT_NAME            varchar(100) comment '字典码名称',
   DICT_VALID           int comment '字典码是否有效',
   DCIT_SORT            int comment '字典码排序',
   DCIT_LAST_MODIFY_TIME timestamp comment '最后修改时间',
   primary key (DICT_UUID)
);

alter table TB_DICT comment '系统系统字典表';

/*==============================================================*/
/* Table: TB_DICT_TYPE                                          */
/*==============================================================*/
create table TB_DICT_TYPE
(
   DCIT_TYPEUUID        varchar(64) not null comment '字典类型标示',
   DCIT_TYPE_ENUM       int comment '字典码值',
   DICT_TYPE_NAME       varchar(100) comment '字典类型码名称',
   DICT_TYPE_VALID      int comment '字典类型是否有效',
   DCIT_TYPE_SORT       int comment '字典类型排序',
   DCIT_TYPE_LAST_MODIFY_TIME timestamp comment '最后修改时间',
   primary key (DCIT_TYPEUUID)
);

alter table TB_DICT_TYPE comment '系统字典类型表';

/*==============================================================*/
/* Table: TB_HOUSE                                              */
/*==============================================================*/
create table TB_HOUSE
(
   HOUSE_UUID           varchar(64) not null comment '房间标示',
   HOUSE_RENTAL_TYPE    int comment '租住类型',
   HOUSE_SAMPE_VILLAGE  varchar(255) comment '房间小区简称',
   HOUSE_SPC            int comment '房间规格',
   HOUSE_DIRECTION      varchar(100) comment '房间朝向',
   HOUSE_TYPE           int comment '房间类型',
   HOUSE_RENTAL_PRICE_TYPE int comment '租金支付类型',
   HOUSE_AREA           double comment '房间面积',
   HOUSE_ROOM_NUM       int comment '房间户型',
   HOUSE_FLOOR          varchar(100) comment '房间楼层',
   HOUSE_DECORATE       int comment '装修等级',
   HOUSE_CODE           varchar(64) comment '房间编号',
   HOUSE_LAST_MODIFY_TIME timestamp comment '最后更新时间',
   HOUSE_ADDR           varchar(225) comment '房间地址',
   HOUSE_VILLAGE        varchar(255) comment '小区全称',
   HOUSE_TRAFFIC_DESC   varchar(225) comment '交通情况描述',
   HOUSE_DESC           varchar(500) comment '房间描述',
   HOUSE_RENTAL_PRICE   double comment '租金',
   HOUSE_MEDIUM_AMT     double comment '中介费',
   HOUSE_IS_MEDIUM      int comment '是否中介',
   HOUSE_OWNER_TEL      varchar(100) comment '房东电话',
   HOUSE_OWNER_NAME     varchar(255) comment '房屋联系人',
   HOUSE_SINGLE_USE     int comment '独用设施',
   HOUSE_STAUS          int comment '房间状态',
   HOUSE_ORDER          int comment '房间排序',
   primary key (HOUSE_UUID)
);

alter table TB_HOUSE comment '房屋信息';

/*==============================================================*/
/* Table: TB_HOUSE_SPC_REL                                      */
/*==============================================================*/
create table TB_HOUSE_SPC_REL
(
   HOUSE_SPC_REL_UUID   varchar(64) not null comment '关联关系表',
   HOUSE_SPC_REL_CODE   int comment '房间类型编码',
   HOUSE_UUID           varchar(64) comment '房间标示',
   primary key (HOUSE_SPC_REL_UUID)
);

alter table TB_HOUSE_SPC_REL comment '户型房屋关联关系';

/*==============================================================*/
/* Table: TB_HOUSE_SURROUND_REL                                 */
/*==============================================================*/
create table TB_HOUSE_SURROUND_REL
(
   HOUSE_SURROUND_REL_UUID varchar(64) comment '周边情况关联关系',
   HOUSE_UUID           int comment '房屋标示',
   TB_HOUSE_SURROUND_CODE varchar(64) comment '周边情况编码'
);

alter table TB_HOUSE_SURROUND_REL comment '周边情况表';

/*==============================================================*/
/* Table: TB_ORDER                                              */
/*==============================================================*/
create table TB_ORDER
(
   ORDER_UUID           varchar(64) not null comment '订单标示',
   ORDER_PAYMENT        double comment '订单实付金额',
   ORDER_PAY_STYLE      int comment '支付类型',
   ORDER_STAUS          int comment '状态',
   USER_UUID            varchar(100) comment '用户标示',
   ORDER_PRICE          double comment '订单金额',
   ORDER_TIME           timestamp comment '订单时间',
   HOUSE_UUID           varchar(64) comment '房屋信息标示',
   ORDER_NUM            varchar(100) comment '订单编号',
   ORDER_PAY_TIME       timestamp comment '支付时间',
   ORDER_MEMO           varchar(225) comment '备注',
   primary key (ORDER_UUID)
);

alter table TB_ORDER comment '订单表';

/*==============================================================*/
/* Table: TB_PAYMENT_CERTIFICATE                                */
/*==============================================================*/
create table TB_PAYMENT_CERTIFICATE
(
   PAYMENT_CERTIFICATE_UUID varchar(64) not null comment '交款凭证标示',
   PAYMENT_CERTIFICATE_USER_UUID varchar(64) comment '缴款人标示',
   PAYMENT_CERTIFICATE_HANDEL_PERSON varchar(64) comment '收款人标示',
   PAYMENT_CERTIFICATE_USER_NAME varchar(200) comment '缴款人姓名',
   PAYMENT_CERTIFICATE_HANDEL_PERSON_NAME varchar(200) comment '收款人姓名',
   PAYMENT_AMT          double comment '缴款金额',
   PAYMENT_AMT_STR      varchar(200) comment '缴款金额大写',
   PAYMENT_TIME         timestamp comment '缴款日期',
   PAY_STYLE            timestamp comment '缴款方式',
   PAY_RESON            varchar(225) comment '缴费事项',
   primary key (PAYMENT_CERTIFICATE_UUID)
);

alter table TB_PAYMENT_CERTIFICATE comment '交款凭证';

/*==============================================================*/
/* Table: TB_PROMPT                                             */
/*==============================================================*/
create table TB_PROMPT
(
   PROMPT_UUID          varchar(64) not null comment '催款单标示',
   PROMPT_PSESON_UUID   varchar(64) comment '催款人标示',
   PROMPT__PERSON_NAME  varchar(100) comment '催款人',
   PROMPT_USER_UUID     varchar(64) comment '被催款人标示',
   PROMPT_USER_NAME     varchar(100) comment '被催款人',
   PROMPT_RESON         varchar(225) comment '催款事项',
   PROMPT_TIME          timestamp comment '催款日期',
   LATEFEE_START_TIME   timestamp comment '滞纳金起算日期',
   PROMPT_STAUS         int comment '催款状态',
   PROMPT_MEMO          varchar(225) comment '备注',
   LATEFEE_TYPE         int comment '滞纳金计算方式',
   LAST_MODFIY_TIME     timestamp comment '最后修改时间',
   primary key (PROMPT_UUID)
);

alter table TB_PROMPT comment '催款信息';

/*==============================================================*/
/* Table: TB_RENTAL                                             */
/*==============================================================*/
create table TB_RENTAL
(
   RENTAL_UUID          varchar(64) not null comment '租赁标示',
   RENTAL_TYPE          int comment '租赁类型',
   RENTAL_YEARS         double comment '租期',
   RENTAL_HOUSE_UUID    varchar(64) comment '租赁房间标示',
   RENTAL_START_TIME    date comment '租赁起算时间',
   RENTAL_END_TIME      date comment '租赁截止时间',
   RENTAL_PRICE         double comment '应支付租金金额',
   RENTAL_PAY_STAUS     int comment '租金支付状态',
   RENTAL_PRICE_REAL    int comment '实际支付租金',
   RANTAL_PAY_STYLE     int comment '租金支付方式',
   RENTAL_PARY_LAST     int comment '剩余支付金额',
   RENTAL_LAST_PAY_DATE date comment '下次支付租金日期',
   RENTAL_STAUS         int comment '租赁状态：租赁中 ；退租',
   RENTAL_APPLY_PERSON_UUID varchar(64) comment '租赁人标示',
   RENTAL_APPLAY_PSERSON_NAME varchar(100) comment '租赁人姓名',
   RENTAL_HANDEL_PERSON_UUID varchar(64) comment '经办人标示',
   RENTAL_HANDEL_PSERSON_NAME varchar(100) comment '经办人姓名',
   RENTAL_LAST_MODIFY_TIME timestamp comment '最后修改时间',
   primary key (RENTAL_UUID)
);

alter table TB_RENTAL comment '租赁情况表';

/*==============================================================*/
/* Table: TB_RENTAL_PRICE_RANGE_REL                             */
/*==============================================================*/
create table TB_RENTAL_PRICE_RANGE_REL
(
   RENTAL_PRICE_RANGE_UUID varchar(64) not null comment '租金范围标示',
   RENTAL_PRICE_RANGE_CODE int comment '租金范围编码',
   HOUSE_UUID           varchar(64) comment '房间标示',
   primary key (RENTAL_PRICE_RANGE_UUID)
);

alter table TB_RENTAL_PRICE_RANGE_REL comment '租金区间房屋关联关系表';

/*==============================================================*/
/* Table: TB_RENTAL_TYPE_REL                                    */
/*==============================================================*/
create table TB_RENTAL_TYPE_REL
(
   RENTAL_TYPE_REL_UUID varchar(64) comment '关联关系标示',
   HOUSE_UUID           varchar(64) comment '房屋主键',
   RENTAL_TYPE_CODE     int comment '租住类型编码'
);

alter table TB_RENTAL_TYPE_REL comment '房屋租住类型表';

/*==============================================================*/
/* Table: TB_USER_ACCOUNT                                       */
/*==============================================================*/
create table TB_USER_ACCOUNT
(
   USER_ACCOUNT_UUID    varchar(64) not null comment '用户账户标示',
   UASER_ACCOUNT_NUM    varchar(255) comment '用户账号',
   USER_ACCOUNT_PASSWORD varchar(100) comment '用户密码',
   USER_ACCOUNT_TYPE    varchar(100) comment '用户账号类型',
   USER_ACCOUNT_STAUS   int comment '用户账号状态',
   USER_UUID            varchar(64) comment '用户标示',
   ERROR_NUM            int comment '用户密码错误次数',
   USER_ACCOUNT_CODE    varchar(100) comment '用户角色账号编码',
   USER_ACCOUNT_NAME    varchar(100) comment '用户角色中文名称',
   primary key (USER_ACCOUNT_UUID)
);

alter table TB_USER_ACCOUNT comment '用户账户表';

/*==============================================================*/
/* Table: TB_USER_INO                                           */
/*==============================================================*/
create table TB_USER_INO
(
   USER_UUID            varchar(64) not null comment '用户标示',
   USER_NAME            varchar(255) comment '用户姓名',
   USER_ADDR            varchar(255) comment '用户地址',
   USER_REG_TIME        timestamp comment '注册时间',
   USER_EMAINL          varchar(100) comment '用户邮箱',
   USER_TEL             varchar(50) comment '用户电话',
   USER_STAUS           int comment '用户状态 ',
   USER_LEVEL           int comment '用户等级',
   USER_LAST_MODIFY_TIME timestamp comment '最后修改时间',
   USER_GENDER          int comment '用户性别',
   USER_BIRTHDAY        date comment '用户生日',
   USER_QQ——ACCOUNT     varchar(100) comment '用户QQ账号',
   USER_WX_ACCOUT       varchar(100) comment '用户微信账号',
   USER_REGIP           varchar(100) comment '用户注册ip',
   USER_LAST_LOGIN_TIME timestamp comment '最后登录时间',
   USER_LAST_LOGIN_IP   varchar(100) comment '最后登录IP地址',
   primary key (USER_UUID)
);

alter table TB_USER_INO comment '用户信息表';

