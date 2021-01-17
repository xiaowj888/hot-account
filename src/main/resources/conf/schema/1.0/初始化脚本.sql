DROP TABLE IF EXISTS T_ACCOUNT_ATOM_ORDER;

DROP TABLE IF EXISTS T_ACCOUNT_BALANCE;

DROP TABLE IF EXISTS T_ACCOUNT_INFO;

DROP TABLE IF EXISTS T_ACCOUNT_WATER;

DROP TABLE IF EXISTS T_PRODUCT;

/*==============================================================*/
/* Table: T_ACCOUNT_ATOM_ORDER                                  */
/*==============================================================*/
CREATE TABLE T_ACCOUNT_ATOM_ORDER
(
   ATOM_ID              BIGINT NOT NULL AUTO_INCREMENT COMMENT '原子单ID',
   ACCOUNT_ID           BIGINT NOT NULL COMMENT '账户ID',
   ACCOUNT_NAME         VARCHAR(256) COMMENT '账户名称',
   PRODUCT_ID           BIGINT NOT NULL COMMENT '产品ID',
   PRODUCT_NAME         VARCHAR(128) COMMENT '产品名称',
   ORG_CODE             VARCHAR(32) NOT NULL COMMENT '机构编码',
   ORG_NAME             VARCHAR(128) NOT NULL COMMENT '机构名称',
   ATOM_TYPE            VARCHAR(32) COMMENT '原子类型(ADD,SUB,FROZ,UNFROZ)',
   AMT                  BIGINT NOT NULL COMMENT '金额',
   STATUS               VARCHAR(16) COMMENT '状态(INIT,SUCC,FAIL)',
   REMARK               VARCHAR(256) COMMENT '备注信息',
   CREATE_TIME          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   UPDATE_TIME          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   PRIMARY KEY (ATOM_ID)
)ENGINE=InnoDB
  AUTO_INCREMENT=1
  DEFAULT CHARSET=utf8
  COLLATE=utf8_unicode_ci
  COMMENT='账户原子操作表';

/*==============================================================*/
/* Table: T_ACCOUNT_BALANCE                                     */
/*==============================================================*/
CREATE TABLE T_ACCOUNT_BALANCE
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   ACCOUNT_ID           BIGINT NOT NULL COMMENT '账户ID',
   PRODUCT_ID           BIGINT NOT NULL COMMENT '产品ID',
   FROZ                 BIGINT NOT NULL COMMENT '冻结',
   BALANCE              BIGINT NOT NULL COMMENT '余额',
   VERSION              BIGINT NOT NULL COMMENT '版本信息',
   REMARK               VARCHAR(256) COMMENT '备注信息',
   CREATE_TIME          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   UPDATE_TIME          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   PRIMARY KEY (ID)
)ENGINE=InnoDB
  AUTO_INCREMENT=1
  DEFAULT CHARSET=utf8
  COLLATE=utf8_unicode_ci
  COMMENT='账户余额表';

/*==============================================================*/
/* Table: T_ACCOUNT_INFO                                        */
/*==============================================================*/
CREATE TABLE T_ACCOUNT_INFO
(
   ACCOUNT_ID           BIGINT NOT NULL AUTO_INCREMENT COMMENT '账户ID',
   ACCOUNT_NAME         VARCHAR(256) COMMENT '账户名称',
   ORG_CODE             VARCHAR(32) NOT NULL COMMENT '机构编码',
   ORG_NAME             VARCHAR(128) NOT NULL COMMENT '机构名称',
   REMARK               VARCHAR(256) COMMENT '备注信息',
   CREATE_TIME          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   UPDATE_TIME          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   PRIMARY KEY (ACCOUNT_ID)
)ENGINE=InnoDB
  AUTO_INCREMENT=1
  DEFAULT CHARSET=utf8
  COLLATE=utf8_unicode_ci
  COMMENT='账户信息表';
/*==============================================================*/
/* Table: T_ACCOUNT_WATER                                       */
/*==============================================================*/
CREATE TABLE T_ACCOUNT_WATER
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   ACCOUNT_ID           BIGINT NOT NULL COMMENT '账户ID',
   PRODUCT_ID           BIGINT NOT NULL COMMENT '产品ID',
   ATOM_ID              BIGINT NOT NULL COMMENT '原子单ID',
   ATOM_TYPE            VARCHAR(32) COMMENT '原子类型(ADD,SUB,FROZ,UNFROZ)',
   PRE_BALANCE          BIGINT NOT NULL COMMENT '操作前余额',
   AFT_BALANCE          BIGINT NOT NULL COMMENT '操作后余额',
   EFCT_BALANCE         BIGINT NOT NULL COMMENT '发生额',
   REMARK               VARCHAR(256) COMMENT '备注信息',
   CREATE_TIME          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   UPDATE_TIME          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   PRIMARY KEY (ID)
)ENGINE=InnoDB
  AUTO_INCREMENT=1
  DEFAULT CHARSET=utf8
  COLLATE=utf8_unicode_ci
  COMMENT='账户流水表';

/*==============================================================*/
/* Table: T_PRODUCT                                             */
/*==============================================================*/
CREATE TABLE T_PRODUCT
(
   PRODUCT_ID           BIGINT NOT NULL AUTO_INCREMENT COMMENT '产品ID',
   PRODUCT_NAME         VARCHAR(256) COMMENT '产品名称',
   ORG_CODE             VARCHAR(32) NOT NULL COMMENT '机构编码',
   ORG_NAME             VARCHAR(128) NOT NULL COMMENT '机构名称',
   STATUS               VARCHAR(256) COMMENT '状态(NORMAL,DELETED,DISABLED)',
   REMARK               VARCHAR(256) COMMENT '备注信息',
   CREATE_TIME          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   UPDATE_TIME          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   PRIMARY KEY (PRODUCT_ID)
)ENGINE=InnoDB
  AUTO_INCREMENT=1
  DEFAULT CHARSET=utf8
  COLLATE=utf8_unicode_ci
  COMMENT='产品表';
