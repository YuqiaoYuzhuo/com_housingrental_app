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
   AREA_HOUSE_REL_UUID  varchar(64) not null comment '������ϵ��ʾ',
   HOUSE_UUID           varchar(64) comment '���ݱ�ʾ',
   AREA_UUID            int comment '��������������ʾ',
   primary key (AREA_HOUSE_REL_UUID)
);

alter table TB_AREA_HOUSE_REL comment '�������ַ������ϵ��';

/*==============================================================*/
/* Table: TB_ATTACHMENT                                         */
/*==============================================================*/
create table TB_ATTACHMENT
(
   ATTACH_UUID          varchar(64) not null comment '������ʾ',
   ATTACH_SYS_NAME      varchar(200) comment '����ϵͳ����',
   ATTACH_REAL_NAME     varchar(200) comment '����ԭ����',
   ATTACH_TYPE          int comment '��������',
   ATTACH_SYS_PATH      varchar(100) comment '����ϵͳ·��',
   ATTACH_UP_PATH       varchar(100) comment '����ԭ�ϴ�·��',
   ATTACH_SIZE          double comment '������С',
   ATTACH_ETC           varchar(20) comment '������׺',
   ATTACH_UP_TIME       timestamp comment '�����ϴ�ʱ��',
   ATTACH_UP_PERSON     varchar(64) comment '�����ϴ��˱�ʾ',
   ATTACH_MEMO          varchar(255) comment '��ע',
   ATTACH_MODIFY_TIME   timestamp comment '��������޸�ʱ��',
   primary key (ATTACH_UUID)
);

alter table TB_ATTACHMENT comment '������';

/*==============================================================*/
/* Table: TB_BACK_MONEY_CERTIFICATE                             */
/*==============================================================*/
create table TB_BACK_MONEY_CERTIFICATE
(
   BACK_CERTIFICATE_UUID varchar(64) not null comment '�˿�ƾ֤��ʾ',
   BACK__CERTIFICATE_USER_UUID varchar(64) comment '�˿��˱�ʾ',
   BACK__CERTIFICATE_HANDEL_PERSON varchar(64) comment '�տ��˱�ʾ',
   BACK__CERTIFICATE_USER_NAME varchar(200) comment '�˿�������',
   BACK__CERTIFICATE_HANDEL_PERSON_NAME varchar(200) comment '�տ�������',
   BACK__AMT            double comment '�˿���',
   BACK__AMT_STR        varchar(200) comment '�˿����д',
   BACK__TIME           timestamp comment '�˿�����',
   BACK_STYLE           timestamp comment '�˿ʽ',
   BACK__RESON          varchar(225) comment '�˷�����',
   BACK_STAUS           int comment '״̬',
   primary key (BACK_CERTIFICATE_UUID)
);

alter table TB_BACK_MONEY_CERTIFICATE comment '�˿�ƾ֤';


/*==============================================================*/
/* Table: TB_BUSINESS_ATTACHMENT_REL                            */
/*==============================================================*/
create table TB_BUSINESS_ATTACHMENT_REL
(
   ATTACH_REL_UUID      varchar(64) not null comment '������ϵ��ʾ',
   ATTACH_UUID          varchar(64) not null comment '������ʾ',
   BUSINESS_UUDI        varchar(64) comment 'ҵ���ʾ',
   ATTACH_MEMO          varchar(225) comment '��ע',
   ATTACH_REL_LASTMODIFY_TIME timestamp comment '����޸�ʱ��',
   primary key (ATTACH_REL_UUID)
);

alter table TB_BUSINESS_ATTACHMENT_REL comment '����ҵ�������ϵ��';

/*==============================================================*/
/* Table: TB_CANCLE_RENTAL                                      */
/*==============================================================*/
create table TB_CANCLE_RENTAL
(
   CANCLE_RENTAL_UUID   varchar(64) not null comment '�����ʾ',
   CANCLE_RENTAL_HOUSE_UUID varchar(64) comment '���ⷿ���ʾ',
   CANCLE_RENTAL_DATE   date comment '��������',
   CANCLE_RENTAL_STAUS  int comment '����״̬',
   RENTAL_IS_OVER       int comment '���޺�Լ�Ƿ���',
   RENATL_OVER_DATE     date comment '���޺�Լ����ʱ��',
   IS_BACK_MONEY        int comment '�Ƿ���Ҫ�˿�',
   BACK_PRICE           double comment '�˿���',
   IS_PENATLY           int comment '�Ƿ����ΥԼ��',
   RENATLY_AMT          double comment '����ΥԼ����',
   RENTAL_CANALE_RESON  int comment '����ԭ��',
   CANCLE_RENTAL_ADVICE varchar(1000) comment '���⽨��',
   CANCLE_HANDLE_PSERSON varchar(64) comment '���⾭����',
   CANCLE_APPLY_PERSON  varchar(64) comment '����������',
   CANCLE_HABDEL_PERSON_NAME varchar(100) comment '���⾭��������',
   CANCLE_APPLY_PERSON_NAME varchar(100) comment '��������������',
   CANCLE_LAST_MODIFY_TIME timestamp comment '����޸�ʱ��',
   primary key (CANCLE_RENTAL_UUID)
);

alter table TB_CANCLE_RENTAL comment '���������';

/*==============================================================*/
/* Table: TB_DICT                                               */
/*==============================================================*/
create table TB_DICT
(
   DICT_UUID            varchar(64) not null comment '�ֵ����ʾ',
   DCIT_TYPEUUID        varchar(64) comment '�ֵ����ͱ�ʾ',
   DCIT_ENUM            int comment '�ֵ���ֵ',
   DICT_NAME            varchar(100) comment '�ֵ�������',
   DICT_VALID           int comment '�ֵ����Ƿ���Ч',
   DCIT_SORT            int comment '�ֵ�������',
   DCIT_LAST_MODIFY_TIME timestamp comment '����޸�ʱ��',
   primary key (DICT_UUID)
);

alter table TB_DICT comment 'ϵͳϵͳ�ֵ��';

/*==============================================================*/
/* Table: TB_DICT_TYPE                                          */
/*==============================================================*/
create table TB_DICT_TYPE
(
   DCIT_TYPEUUID        varchar(64) not null comment '�ֵ����ͱ�ʾ',
   DCIT_TYPE_ENUM       int comment '�ֵ���ֵ',
   DICT_TYPE_NAME       varchar(100) comment '�ֵ�����������',
   DICT_TYPE_VALID      int comment '�ֵ������Ƿ���Ч',
   DCIT_TYPE_SORT       int comment '�ֵ���������',
   DCIT_TYPE_LAST_MODIFY_TIME timestamp comment '����޸�ʱ��',
   primary key (DCIT_TYPEUUID)
);

alter table TB_DICT_TYPE comment 'ϵͳ�ֵ����ͱ�';

/*==============================================================*/
/* Table: TB_HOUSE                                              */
/*==============================================================*/
create table TB_HOUSE
(
   HOUSE_UUID           varchar(64) not null comment '�����ʾ',
   HOUSE_RENTAL_TYPE    int comment '��ס����',
   HOUSE_SAMPE_VILLAGE  varchar(255) comment '����С�����',
   HOUSE_SPC            int comment '������',
   HOUSE_DIRECTION      varchar(100) comment '���䳯��',
   HOUSE_TYPE           int comment '��������',
   HOUSE_RENTAL_PRICE_TYPE int comment '���֧������',
   HOUSE_AREA           double comment '�������',
   HOUSE_ROOM_NUM       int comment '���仧��',
   HOUSE_FLOOR          varchar(100) comment '����¥��',
   HOUSE_DECORATE       int comment 'װ�޵ȼ�',
   HOUSE_CODE           varchar(64) comment '������',
   HOUSE_LAST_MODIFY_TIME timestamp comment '������ʱ��',
   HOUSE_ADDR           varchar(225) comment '�����ַ',
   HOUSE_VILLAGE        varchar(255) comment 'С��ȫ��',
   HOUSE_TRAFFIC_DESC   varchar(225) comment '��ͨ�������',
   HOUSE_DESC           varchar(500) comment '��������',
   HOUSE_RENTAL_PRICE   double comment '���',
   HOUSE_MEDIUM_AMT     double comment '�н��',
   HOUSE_IS_MEDIUM      int comment '�Ƿ��н�',
   HOUSE_OWNER_TEL      varchar(100) comment '�����绰',
   HOUSE_OWNER_NAME     varchar(255) comment '������ϵ��',
   HOUSE_SINGLE_USE     int comment '������ʩ',
   HOUSE_STAUS          int comment '����״̬',
   HOUSE_ORDER          int comment '��������',
   primary key (HOUSE_UUID)
);

alter table TB_HOUSE comment '������Ϣ';

/*==============================================================*/
/* Table: TB_HOUSE_SPC_REL                                      */
/*==============================================================*/
create table TB_HOUSE_SPC_REL
(
   HOUSE_SPC_REL_UUID   varchar(64) not null comment '������ϵ��',
   HOUSE_SPC_REL_CODE   int comment '�������ͱ���',
   HOUSE_UUID           varchar(64) comment '�����ʾ',
   primary key (HOUSE_SPC_REL_UUID)
);

alter table TB_HOUSE_SPC_REL comment '���ͷ��ݹ�����ϵ';

/*==============================================================*/
/* Table: TB_HOUSE_SURROUND_REL                                 */
/*==============================================================*/
create table TB_HOUSE_SURROUND_REL
(
   HOUSE_SURROUND_REL_UUID varchar(64) comment '�ܱ����������ϵ',
   HOUSE_UUID           int comment '���ݱ�ʾ',
   TB_HOUSE_SURROUND_CODE varchar(64) comment '�ܱ��������'
);

alter table TB_HOUSE_SURROUND_REL comment '�ܱ������';

/*==============================================================*/
/* Table: TB_ORDER                                              */
/*==============================================================*/
create table TB_ORDER
(
   ORDER_UUID           varchar(64) not null comment '������ʾ',
   ORDER_PAYMENT        double comment '����ʵ�����',
   ORDER_PAY_STYLE      int comment '֧������',
   ORDER_STAUS          int comment '״̬',
   USER_UUID            varchar(100) comment '�û���ʾ',
   ORDER_PRICE          double comment '�������',
   ORDER_TIME           timestamp comment '����ʱ��',
   HOUSE_UUID           varchar(64) comment '������Ϣ��ʾ',
   ORDER_NUM            varchar(100) comment '�������',
   ORDER_PAY_TIME       timestamp comment '֧��ʱ��',
   ORDER_MEMO           varchar(225) comment '��ע',
   primary key (ORDER_UUID)
);

alter table TB_ORDER comment '������';

/*==============================================================*/
/* Table: TB_PAYMENT_CERTIFICATE                                */
/*==============================================================*/
create table TB_PAYMENT_CERTIFICATE
(
   PAYMENT_CERTIFICATE_UUID varchar(64) not null comment '����ƾ֤��ʾ',
   PAYMENT_CERTIFICATE_USER_UUID varchar(64) comment '�ɿ��˱�ʾ',
   PAYMENT_CERTIFICATE_HANDEL_PERSON varchar(64) comment '�տ��˱�ʾ',
   PAYMENT_CERTIFICATE_USER_NAME varchar(200) comment '�ɿ�������',
   PAYMENT_CERTIFICATE_HANDEL_PERSON_NAME varchar(200) comment '�տ�������',
   PAYMENT_AMT          double comment '�ɿ���',
   PAYMENT_AMT_STR      varchar(200) comment '�ɿ����д',
   PAYMENT_TIME         timestamp comment '�ɿ�����',
   PAY_STYLE            timestamp comment '�ɿʽ',
   PAY_RESON            varchar(225) comment '�ɷ�����',
   primary key (PAYMENT_CERTIFICATE_UUID)
);

alter table TB_PAYMENT_CERTIFICATE comment '����ƾ֤';

/*==============================================================*/
/* Table: TB_PROMPT                                             */
/*==============================================================*/
create table TB_PROMPT
(
   PROMPT_UUID          varchar(64) not null comment '�߿��ʾ',
   PROMPT_PSESON_UUID   varchar(64) comment '�߿��˱�ʾ',
   PROMPT__PERSON_NAME  varchar(100) comment '�߿���',
   PROMPT_USER_UUID     varchar(64) comment '���߿��˱�ʾ',
   PROMPT_USER_NAME     varchar(100) comment '���߿���',
   PROMPT_RESON         varchar(225) comment '�߿�����',
   PROMPT_TIME          timestamp comment '�߿�����',
   LATEFEE_START_TIME   timestamp comment '���ɽ���������',
   PROMPT_STAUS         int comment '�߿�״̬',
   PROMPT_MEMO          varchar(225) comment '��ע',
   LATEFEE_TYPE         int comment '���ɽ���㷽ʽ',
   LAST_MODFIY_TIME     timestamp comment '����޸�ʱ��',
   primary key (PROMPT_UUID)
);

alter table TB_PROMPT comment '�߿���Ϣ';

/*==============================================================*/
/* Table: TB_RENTAL                                             */
/*==============================================================*/
create table TB_RENTAL
(
   RENTAL_UUID          varchar(64) not null comment '���ޱ�ʾ',
   RENTAL_TYPE          int comment '��������',
   RENTAL_YEARS         double comment '����',
   RENTAL_HOUSE_UUID    varchar(64) comment '���޷����ʾ',
   RENTAL_START_TIME    date comment '��������ʱ��',
   RENTAL_END_TIME      date comment '���޽�ֹʱ��',
   RENTAL_PRICE         double comment 'Ӧ֧�������',
   RENTAL_PAY_STAUS     int comment '���֧��״̬',
   RENTAL_PRICE_REAL    int comment 'ʵ��֧�����',
   RANTAL_PAY_STYLE     int comment '���֧����ʽ',
   RENTAL_PARY_LAST     int comment 'ʣ��֧�����',
   RENTAL_LAST_PAY_DATE date comment '�´�֧���������',
   RENTAL_STAUS         int comment '����״̬�������� ������',
   RENTAL_APPLY_PERSON_UUID varchar(64) comment '�����˱�ʾ',
   RENTAL_APPLAY_PSERSON_NAME varchar(100) comment '����������',
   RENTAL_HANDEL_PERSON_UUID varchar(64) comment '�����˱�ʾ',
   RENTAL_HANDEL_PSERSON_NAME varchar(100) comment '����������',
   RENTAL_LAST_MODIFY_TIME timestamp comment '����޸�ʱ��',
   primary key (RENTAL_UUID)
);

alter table TB_RENTAL comment '���������';

/*==============================================================*/
/* Table: TB_RENTAL_PRICE_RANGE_REL                             */
/*==============================================================*/
create table TB_RENTAL_PRICE_RANGE_REL
(
   RENTAL_PRICE_RANGE_UUID varchar(64) not null comment '���Χ��ʾ',
   RENTAL_PRICE_RANGE_CODE int comment '���Χ����',
   HOUSE_UUID           varchar(64) comment '�����ʾ',
   primary key (RENTAL_PRICE_RANGE_UUID)
);

alter table TB_RENTAL_PRICE_RANGE_REL comment '������䷿�ݹ�����ϵ��';

/*==============================================================*/
/* Table: TB_RENTAL_TYPE_REL                                    */
/*==============================================================*/
create table TB_RENTAL_TYPE_REL
(
   RENTAL_TYPE_REL_UUID varchar(64) comment '������ϵ��ʾ',
   HOUSE_UUID           varchar(64) comment '��������',
   RENTAL_TYPE_CODE     int comment '��ס���ͱ���'
);

alter table TB_RENTAL_TYPE_REL comment '������ס���ͱ�';

/*==============================================================*/
/* Table: TB_USER_ACCOUNT                                       */
/*==============================================================*/
create table TB_USER_ACCOUNT
(
   USER_ACCOUNT_UUID    varchar(64) not null comment '�û��˻���ʾ',
   UASER_ACCOUNT_NUM    varchar(255) comment '�û��˺�',
   USER_ACCOUNT_PASSWORD varchar(100) comment '�û�����',
   USER_ACCOUNT_TYPE    varchar(100) comment '�û��˺�����',
   USER_ACCOUNT_STAUS   int comment '�û��˺�״̬',
   USER_UUID            varchar(64) comment '�û���ʾ',
   ERROR_NUM            int comment '�û�����������',
   USER_ACCOUNT_CODE    varchar(100) comment '�û���ɫ�˺ű���',
   USER_ACCOUNT_NAME    varchar(100) comment '�û���ɫ��������',
   primary key (USER_ACCOUNT_UUID)
);

alter table TB_USER_ACCOUNT comment '�û��˻���';

/*==============================================================*/
/* Table: TB_USER_INO                                           */
/*==============================================================*/
create table TB_USER_INO
(
   USER_UUID            varchar(64) not null comment '�û���ʾ',
   USER_NAME            varchar(255) comment '�û�����',
   USER_ADDR            varchar(255) comment '�û���ַ',
   USER_REG_TIME        timestamp comment 'ע��ʱ��',
   USER_EMAINL          varchar(100) comment '�û�����',
   USER_TEL             varchar(50) comment '�û��绰',
   USER_STAUS           int comment '�û�״̬ ',
   USER_LEVEL           int comment '�û��ȼ�',
   USER_LAST_MODIFY_TIME timestamp comment '����޸�ʱ��',
   USER_GENDER          int comment '�û��Ա�',
   USER_BIRTHDAY        date comment '�û�����',
   USER_QQ����ACCOUNT     varchar(100) comment '�û�QQ�˺�',
   USER_WX_ACCOUT       varchar(100) comment '�û�΢���˺�',
   USER_REGIP           varchar(100) comment '�û�ע��ip',
   USER_LAST_LOGIN_TIME timestamp comment '����¼ʱ��',
   USER_LAST_LOGIN_IP   varchar(100) comment '����¼IP��ַ',
   primary key (USER_UUID)
);

alter table TB_USER_INO comment '�û���Ϣ��';

