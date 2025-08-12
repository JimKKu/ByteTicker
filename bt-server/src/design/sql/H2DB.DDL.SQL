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



----- 测试数据（部分）

-- Insert data into the menu table
INSERT INTO TBL_MENU (TYPE_ID, NAME1, NAME2, PRICE1, PRICE2, COMMENT) 
VALUES (1, '番茄炒蛋盖浇饭', 'Tomato Egg Rice', 12.00, 15.00, NULL);

INSERT INTO TBL_MENU (TYPE_ID, NAME1, NAME2, PRICE1, PRICE2, COMMENT) 
VALUES (1, '青椒牛肉盖浇饭', 'Pepper Beef Rice', 14.00, 16.00, '可选鸡肉/猪肉/虾');

INSERT INTO TBL_MENU (TYPE_ID, NAME1, NAME2, PRICE1, PRICE2, COMMENT) 
VALUES (1, '鱼香肉丝盖浇饭', 'YuXiang Pork Rice', 14.00, 16.00, NULL);

INSERT INTO TBL_MENU (TYPE_ID, NAME1, NAME2, PRICE1, PRICE2, COMMENT) 
VALUES (2, '青菜面', 'Vegetable Noodles', 8.00, 10.00, '微辣');

INSERT INTO TBL_MENU (TYPE_ID, NAME1, NAME2, PRICE1, PRICE2, COMMENT) 
VALUES (2, '番茄鸡蛋面', 'Tomato Egg Noodles', 11.00, 13.00, '时令蔬菜');

INSERT INTO TBL_MENU (TYPE_ID, NAME1, NAME2, PRICE1, PRICE2, COMMENT) 
VALUES (2, '红烧牛肉面', 'Braised Beef Noodles', 16.00, 18.00, NULL);

INSERT INTO TBL_MENU (TYPE_ID, NAME1, NAME2, PRICE1, PRICE2, COMMENT) 
VALUES (3, '牛肉水饺', 'Beef Dumplings', 16.00, 22.00, '罐装');

INSERT INTO TBL_MENU (TYPE_ID, NAME1, NAME2, PRICE1, PRICE2, COMMENT) 
VALUES (3, '羊肉水饺', 'Lamb Dumplings', 16.00, 22.00, '香草/巧克力/草莓');

INSERT INTO TBL_MENU (TYPE_ID, NAME1, NAME2, PRICE1, PRICE2, COMMENT) 
VALUES (3, '韭菜鸡蛋水饺', 'Chive Egg Dumplings', 12.00, 16.00, NULL);

INSERT INTO TBL_MENU (TYPE_ID, NAME1, NAME2, PRICE1, COMMENT) 
VALUES (4, '卤蛋', 'Marinated Egg', 2.00, NULL);

INSERT INTO TBL_MENU (TYPE_ID, NAME1, NAME2, PRICE1, COMMENT) 
VALUES (4, '煎鸡蛋', 'Fried Egg', 2.00, NULL);