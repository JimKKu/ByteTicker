## 启动项目

1. 下载相应安装包，点击`Mac启动程序`或`.exe`启动程序

## 连接打印机 

1. 购买一台芯烨打印机(我用的是58IIH-USB)版本，只能通过USB连接
2. 连接至电脑，安装相关驱动
3. 下载相应启动包，启动应用程序
5. 选择相应的菜品，点击下单，测试是否打印成功
6. 若存在相关问题可以[提交Issues](https://github.com/JimKKu/ByteTicker/issues)

## 如何修改类别、菜单

1. 启动程序
2. 浏览器访问 [http://127.0.0.1:14156/h2db](http://127.0.0.1:14156/h2db)
3. 使用下方信息登录数据库控制台(由于时间原因没有做一个管理页面，这里有问题可以[提交Issues](https://github.com/JimKKu/ByteTicker/issues)或从身边找个计算机的朋友帮忙看下)

| 参数 | 值 | 备注 |
|:--|:--|:--|
|JDBC URL| `jdbc:h2:file:~/.config/ByteTicker/db/h2db` | 照抄即可 |
| User Name | root | 照抄即可 |
| Password | root | 照抄即可 |

4. 登陆之后可以看到一个数据库控制台，里面包含四个主要的表，如下：

| 参数 | 值 | 备注 |
|:--|:--|:--|
| TBL_TYPE | 菜品分类表，对应左侧分类 | ID为0时表示显示全部 |
| TBL_MENU | 菜品表，对应中心区域所有的菜 | price2为空时仅显示一个价格（参考示例中的卤蛋） |
| TBL_ORDER | 订单信息表 | 不用管，仅用于重新打印、历史订单查询等功能  |
| TBL_ORDER_DETAIL | 订单详细信息表 | 不用管  |

其中 `TBL_MENU` 的 type_id 字段，需要对应 `TBL_TYPE` 的 ID，即可在软件中点击左侧类型，在右侧显示该类别下的菜品。
