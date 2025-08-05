-- 菜单表
CREATE TABLE tbl_menu (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          type_id INT NOT NULL,
                          name1 VARCHAR(255),
                          name2 VARCHAR(255),
                          price1 DECIMAL(10,2),
                          price2 DECIMAL(10,2),
                          comment VARCHAR(500)
);

-- 订单详情表
CREATE TABLE tbl_order_detail (
                                  id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                  order_id BIGINT NOT NULL,
                                  name1 VARCHAR(255),
                                  name2 VARCHAR(255),
                                  price INT,
                                  size TINYINT,
                                  num INT,
                                  comment VARCHAR(500)
);

-- 订单表
CREATE TABLE tbl_order (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           menu_info VARCHAR(1000),
                           num INT,
                           status INT,
                           price INT,
                           createDate VARCHAR(20),
                           comment VARCHAR(500)
);

-- 类型表
CREATE TABLE tbl_type (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255),
                          icon VARCHAR(255),
                          comment VARCHAR(500)
);