# 数据库表结构：
# 用户表
CREATE TABLE user
(
  id        INT AUTO_INCREMENT
  COMMENT '主键'
    PRIMARY KEY,
  user_name VARCHAR(100)         NULL
  COMMENT '用户名',
  pass_word VARCHAR(100)         NULL
  COMMENT '密码md5加密',
  nick_name VARCHAR(50)          NULL
  COMMENT '用户昵称',
  user_type SMALLINT(1) UNSIGNED NULL
  COMMENT '类型，买家0，卖家1'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 产品表
CREATE TABLE product
(
  id      INT AUTO_INCREMENT
  COMMENT '主键'
    PRIMARY KEY,
  price   FLOAT(7, 2)  NULL
  COMMENT '当前价格',
  title   VARCHAR(100) NULL
  COMMENT '标题',
  image   VARCHAR(500) NULL
  COMMENT '图片',
  summary VARCHAR(200) NULL
  COMMENT '摘要',
  detail  BLOB         NULL
  COMMENT '正文'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 交易记录表
CREATE TABLE transaction
(
  id         INT AUTO_INCREMENT
  COMMENT '主键'
    PRIMARY KEY,
  product_id INT                                 NULL
  COMMENT '内容ID',
  user_id    INT                                 NULL
  COMMENT '用户ID',
  price      FLOAT(7, 2)                         NULL
  COMMENT '购买价格',
  time       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '购买时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 用户数据：
INSERT INTO `user` (`id`, user_name, pass_word, nick_name, user_type)
VALUES ('0', 'buyer', '37254660e226ea65ce6f1efd54233424', 'buyer', '0');
INSERT INTO `user` (user_name, pass_word, nick_name, user_type)
VALUES ('seller', '981c57a5cfb0f868e064904b8745766f', 'seller', '1');