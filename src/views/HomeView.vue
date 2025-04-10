<template>
  <!-- 全屏DIV -->
  <div id="container">
    <!-- 头部 -->
    <header>
      <div>
        <img alt="Vue logo" src="../assets/logo.png" draggable="false" oncontextmenu="return false;">
      </div>
    </header>
    <!-- 身体 -->
    <div id="middle">
      <div id="box1">
        <ul>
          <li v-for="type in typeList" :key="type.id" @click="getMenuList(type.id)">
            <i :class="type.icon"></i>
          </li>
        </ul>
      </div>
      <div id="box2">
        <div id="card" v-for="(menu,index) in menuList" :key="menu.id">
          <div id="incard1">
            <div id="son11" style="text-overflow: ellipsis;">
              {{ menu.name1 }}
            </div>
            <div id="son12" style="text-overflow: ellipsis;">
              {{ menu.name2 }}
              <div v-if="!menu.name2" style="display: inline-block;width: 36px;height: 4px;border-top: .2px solid gray"></div>
            </div>
          </div>
          <div id="incard2">
            <nav>
              <div @click="btnMenuPrice1(index,menu.price2)" id="son21" :style="menu.price2?'border-right: 1px solid gray':''">{{ menu.price1 }}<span style="font-size: 12px">￥</span></div>
              <div @click="btnMenuPrice2(index)" id="son22" v-if="menu.price2">{{ menu.price2 }}<span style="font-size: 12px">￥</span></div>
            </nav>
          </div>
        </div>
      </div>
      <!-- 侧边栏 -->
      <div id="box3">
        <div>
          <!-- aside:点单 -->
          <div :class="aside1?'show':'hidden'" @animationend='aside1===false'>
            <div id="aside-order">
              <div id="in-aside-order1">
                <div id="in-aside-order1-inner">
                  <div id="in-aside-order1-inner-left" @click="orderList = []">
                    <i class="iconfont icon-lajitong lajitong-clear">&nbsp;</i>清&nbsp;空
                  </div>
                  <div id="in-aside-order1-inner-right">
                    <i class="iconfont icon-qian8 icon-money"></i>
                    来单咯
                    <i class="iconfont icon-qian8 icon-money"></i>
                  </div>
                </div>
              </div>
              <div id="in-aside-order2" :class="orderList.length?'do-order':'no-order'">
                  <!-- inline-block -->
                  <div id="in-aside-order-card" v-for="(order,index) in orderList">
                    <div id="in-aside-order-card-container">
                      <div id="in-aside-card-1">
                        {{ order.name1 }}
                      </div>
                      <div id="in-aside-card-2">
                        {{ order.name2 }}
                      </div>
                      <div id="in-aside-card-3">
                        <div class="order-button">
                          <button class="iconfont icon-jianhaob" :disabled="order.num === 0" @click="btnMinusOrder(index)"></button>
                        </div>
                        <div class="order-input">
                          <input v-model="order.num">
                        </div>
                        <div class="order-button">
                          <button class="iconfont icon-jiahao" :disabled="order.num === 99" @click="btnAddOrder(index)"></button>
                        </div>
                      </div>
                      <div id="in-aside-card-4" @click="btnDelOrder(index)" :style="!order.num?'height: 36px;transition: .5s all;line-height:36px;background-color:#f0a1a8;color:#fff;font-size: 32px':'transition: .5s all;'"><i class="iconfont icon-lajitong"></i></div>
                    </div>
                  </div>
              </div>
              <div id="in-aside-order-quick-info">
                <div v-for="order in quickInfoList" style="width: 100%;height: 100%">
                  <div id="quick-info-button" :style="{background: order.background}" @click="btnQuickInfo(order.info)">
                    <div id="in-quick-info-button-container">
                      <div>{{order.info}}</div>
                      <div  :class="order.icon" :style="{fontsize: order.size}" id="quick-info-icon"></div>
                    </div>
                  </div>
                </div>
              </div>
              <div id="in-aside-order3">
              <textarea placeholder="请输入备注..." v-model="comment"></textarea>
            </div>
              <div id="in-aside-order4">
                <button :disabled="this.orderList.length === 0" @click="btnNewOrder" id="button-order">下&nbsp;&nbsp;单</button>
              </div>
            </div>
          </div>
          <!-- aside:历史订单 -->
          <div :class="aside1?'hidden':'show'" @animationend='aside1===true'>
            <!-- box3>div>div>div -->
            <div id="aside-history">
              <div id="in-history-aside-1">
                <div id="history-title-moved">
                  <div id="history-title-moved-left-son" @click="btnLastDay">
                    <div id="left-icon-div">
                      <img src="@/assets/imgs/i-left.png" alt="左箭头" class="i-direction i-left">
                    </div>
                    <div id="left-colck-div">
                      <img src="@/assets/imgs/clock1.png" alt="时钟" class="icon-clock clock1">
                      <img src="@/assets/imgs/clock2.png" alt="时钟" class="icon-clock clock2">
                    </div>
                  </div>
                  <div id="history-title-moved-middle-son">
                    历史订单
                  </div>
                  <div id="history-title-moved-right-son" @click="btnNextDay">
                    <div id="right-icon-div">
                      <img src="@/assets/imgs/i-right.png" alt="右箭头" class="i-direction i-right">
                    </div>
                    <div id="right-colck-div">
                      <img src="@/assets/imgs/clock1.png" alt="时钟" class="icon-clock clock1">
                      <img src="@/assets/imgs/clock2.png" alt="时钟" class="icon-clock clock2">
                    </div>
                  </div>
                </div>
              </div>
              <div id="in-history-aside-2">
                <div id="history-card" v-for="(order,index) in historyList">
                  <div id="in-history-card-1">
                    <span>{{order.num}}</span>
                    <span>/{{order.createDate}}</span>
                  </div>
                  <div id="in-history-card-2" v-html="order.menuInfo.replaceAll('/','<br>')">
                    <!-- v-html绑定内容 -->
                  </div>
                  <div id="in-history-card-3">
                    备注：{{order.comment?order.comment:'无'}}
                  </div>
                  <div id="in-history-card-absolute-1">
                    {{order.price}}<span style="font-size: 24px">￥</span>
                  </div>
                  <div id="in-history-card-absolute-2"></div>
                </div>
              </div>
              <div id="in-history-aside-3">
                <div id="in-history-aside-3-container">
                  <div class="iconfont icon-jintian4" @click="btnToday"></div>
                  <input v-model="history_orderDate" placeholder="日期" :style="iToday === history_orderDate?'color:gray':'color:#3a5fd9;font-weight: 500'">
                  <input v-model="history_orderNo" placeholder="订单号" v-on:input="queryHistoryOrders">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 页脚 -->
    <footer>
      <div v-if="sum!==0">应收金额:&nbsp;&nbsp;<span>{{ sum }}</span>&nbsp;元</div>
    </footer>

    <!-- 右上角两个绝对定位按钮 -->
    <div id="exchange-button" class="float-button" @click="changeAside">
      <div class="in-float-button-container">
        <div>
          <i :class="aside1? 'iconfont icon-lishijilu':'iconfont icon-dingdan'"></i>
        </div>
        <div>
          {{aside1 ? '历史订单' : '继续点单'}}
        </div>
      </div>
    </div>

    <div id="reprint-button" class="float-button" style="right: 100px" @click="rePrinter">
      <div class="in-float-button-container">
        <div>
          <i class="iconfont icon-zhongxinshengcheng"></i>
        </div>
        <div>
          重新打印
        </div>
      </div>
    </div>


  </div>
</template>

<script>
import {reqGetTypeList} from "@/api/type";
import {reqGetMenuList} from "@/api/menu";
import {historyOrder, rePrintLatest, reqNewOrder, sumPrice} from "@/api/order";
import {lastDay,today,nextDay} from "@/api/date";

export default {
  name: 'OrderView',
  data() {
    return {
      /* type */
      typeList: [],
      menuList: [],
      orderList: [],
      historyList: [],
      comment: '', /* 备注 */
      history_orderNo:'', /* 模糊搜索历史订单 */
      history_orderDate: 0,
      iToday: '',
      sum: 0,
      aside1: true,
      quickInfoList: [
        {
          background: '#ffc09f',
          info: '微辣',
          icon: 'iconfont icon-lajiao1ge',
          size: '18px'
        },{
          background: '#ff8c51',
          info: "中辣",
          icon: 'iconfont icon-lajiao2ge',
          size: '18px'
        },{
          background: '#ff3333',
          info: "重辣",
          icon: 'iconfont icon-lajiao3ge',
          size: '18px'
        },{
          background: '#3f9124',
          info: "香葱",
          icon: 'iconfont icon-dacong',
          size: '12px'
        },{
          background: '#6cc94c',
          info: "香菜",
          icon: 'iconfont icon-food31',
          size: '12px'
        }
      ]
    }
  },
  mounted() {
    this.getTypeList();
    this.getMenuList(0);
    this.INIT_Date();
    this.queryHistoryOrders();
  },
  methods: {
    /* ----- methods ----- */
    getSum() {
      this.sum = sumPrice(this.orderList);
      console.log(this.sum);
    },
    changeAside(){
      this.aside1=!this.aside1;
      if(!this.aside1) {
        this.queryHistoryOrders();
      }
    },
    btnMenuPrice1(index,bool) {
      var m = this.menuList[index];
      /* ---- SIZE:大份小份 ---- */
      var SIZE = 0;
      if(bool !== 0) {
        SIZE = 1;
      }
      /* ---- 已点份数 ---- */
      var flag = 0;
      this.orderList.forEach((o,index) => {
          if(o.name1 === m.name1 && o.name2 === m.name2 && o.size === SIZE) {
            this.orderList[index].num++;
            flag = 1;
          }
      })

      if(flag === 0) {
        var o = {
          name1: m.name1,
          name2: m.name2,
          price: m.price1,
          size: SIZE,
          num: 1
        }
        this.orderList.push(o)
      }
      this.getSum();
    },
    btnMenuPrice2(index) {
      var m = this.menuList[index];
      /* ---- 已点份数 ---- */
      var flag = 0;
      this.orderList.forEach((o,index) => {
        if(o.name1 === m.name1 && o.name2 === m.name2 && o.size === 2) {
          this.orderList[index].num++;
          flag = 1;
        }
      })

      if(flag === 0) {
        var o = {
          name1: m.name1,
          name2: m.name2,
          price: m.price2,
          size: 2, /* 一定是大份 */
          num: 1
        }
        this.orderList.push(o)
      }
      this.getSum();
    },
    btnAddOrder (index) {
      if( this.orderList[index].num < 99) this.orderList[index].num ++;
      this.getSum();
    },
    btnMinusOrder (index) {
      if( this.orderList[index].num > 0) this.orderList[index].num --;
      this.getSum();
    },
    btnDelOrder (index) {
      this.orderList.splice(index,1)
      this.getSum();
    },
    btnQuickInfo(info) {
      if(info.includes('辣')) {
        if(this.comment.includes('微辣')) {
          this.comment = this.comment.replace('微辣',info);
        } else if (this.comment.includes('中辣')) {
          this.comment = this.comment.replace('中辣',info);
        } else if (this.comment.includes('重辣')) {
          this.comment = this.comment.replace('重辣',info)
        } else {
          this.comment += (info + '、');
        }
      } else if (!this.comment.includes('香葱') && info === '香葱') {
        this.comment += ('不要香葱、')
      } else if (!this.comment.includes('香菜') && info === '香菜') {
        this.comment += ('不要香菜、')
      }
    },
    async btnLastDay(){
      this.history_orderDate = lastDay(this.history_orderDate);
      // this.history_orderDate = lastDay(this.history_orderDate);
      this.historyList = await historyOrder(this.history_orderDate,this.history_orderNo);
    },
    async btnNextDay(){
      this.history_orderDate = nextDay(this.history_orderDate);
      // this.history_orderDate++;
      this.historyList = await historyOrder(this.history_orderDate,this.history_orderNo);
    },
    async btnToday(){
      this.history_orderDate = today();
      // this.history_orderDate++;
      this.historyList = await historyOrder(this.history_orderDate,this.history_orderNo);
    },
    /* ------ 触发请求 ----- */
    /* 下单按钮 */
    async btnNewOrder(){
      var code = await reqNewOrder(this.orderList,this.comment,this.sum);
      if(code === '000') {
        this.$notify.success("下单成功！");
        this.orderList.splice(0,this.orderList.length);
        this.comment = '';
        this.sum = 0;
      } else {
        this.$notify.error("下单失败！");
      }
    },
    async queryHistoryOrders() {
      this.historyList = await historyOrder(this.history_orderDate,this.history_orderNo);
    },
    /* ------ Mounted ------ */
    async getTypeList() {
      this.typeList = await reqGetTypeList();
    },
    async getMenuList(typeId) {
      this.menuList = await reqGetMenuList(typeId);
    },
    async rePrinter() {
      await rePrintLatest();
    },
    INIT_Date() {
      this.iToday = today();
      this.history_orderDate = today();
    }
  }
}
</script>

<style scoped>

/* --- 历史订单·小卡片 --- */
#history-card {
  width: calc(100% - 20px);
  border: 1px solid gray;
  margin: 20px 10px;
  border-radius: 12px;
  padding: 5px;
  box-sizing: border-box;
  position: relative;
  background: #e1e1e1;
  box-shadow: 2px 2px 4px #b0b0b0,-2px -2px 4px #ffffff;
}
#history-card div:hover,
#history-card span:hover{
  color: red;
}
/* 单号/日期 */
#in-history-card-1 {
  width: 100%;
  height: 26px;
  line-height: 26px;
}
/* 单号 */
#in-history-card-1 :nth-child(1) {
  font-size: 24px;
  font-weight: 700;
  color: #565656;
}
/* 日期 */
#in-history-card-1 :nth-child(2) {
  font-size: 14px;
  color: gray;
}
/* 订单详情 */
#in-history-card-2 {
  color: gray;
  font-size: 14px;
  padding: 10px 5px 10px 0;
  margin-top: 10px;
  border-top: 1px solid gray;
  border-bottom: 1px solid gray;
}
/* 备注 */
#in-history-card-3 {
  color: gray;
  font-size: 14px;
  padding: 5px 10px 5px 0;
  font-weight: 500;
}
/* 价格（右上角） */
#in-history-card-absolute-1 {
  position: absolute;
  right: 10px;
  top: -22px;
  color: #3a5fd9;
  display: inline-block;
  font-size: 32px;
  font-weight: 700;
  font-style: italic;
  font-family: Tahoma;
}
/* 详情按钮（暂时未用到） */
#in-history-card-absolute-2 {

}
/* --- 历史订单·侧边栏 --- */

#history-title-moved {
  width: 360px;
  display: flex;
  flex-direction: row;
}
.icon-clock {
  width: 22px;
  height: 22px;
}
#history-title-moved>div {
  width: 120px;
  height: 52px;
  display: inline-block;
  transform: translateX(-60px);
  transition: all .25s;
  position: relative;
}
#history-title-moved-left-son {
  z-index: 600;
}
#history-title-moved-left-son:hover {
  //background: rgba(58,95,217,0.8);
  //background-image: linear-gradient( 135deg, #E2B0FF 10%, #9F44D3 100%);
  transform: translateX(0px);
  background: #ee3f4d;
  border-radius: 12px;
  width: 116px;
  height: 48px;
  margin: 2px;
  //background-image: linear-gradient( 135deg, #3C8CE7 10%, #00EAFF 100%);
  //box-shadow: 2px 2px 4px #b0b0b0 inset,-2px -2px 4px #ffffff inset;
}
#history-title-moved-middle-son {
  z-index: 700;
  background: #e1e1e1;
}
#history-title-moved-right-son {
  z-index: 600;
}
#history-title-moved-right-son:hover {
  //background: rgba(58,95,217,0.8);
  //background-image: linear-gradient( 135deg, #E2B0FF 10%, #9F44D3 100%);
  transform: translateX(-120px);
  background: #ee3f4d;
  border-radius: 12px;
  width: 116px;
  height: 48px;
  margin: 2px;
  //background-image: linear-gradient( 135deg, #CE9FFC 10%, #7367F0 100%);
  //box-shadow: 2px 2px 6px #b0b0b0 inset,-2px -2px 6px #ffffff inset;
}

#left-colck-div {
  position: absolute;
  width: 22px;
  background: #e1e1e1;
  right: 5px;
  bottom: 14px;
}
#right-colck-div {
  position: absolute;
  width: 22px;
  background: #e1e1e1;
  left: 5px;
  bottom: 16px;
}
.i-direction {
  width: 18px;
  bottom: 15px;
  position: absolute;
}
.i-left {
  left: 21px;
}
.i-right {
  right: 21px;
}
/* 全局容器 */
#container {
  width: 100%;
  height: 100%;
  background: pink;
  display: flex;
  flex-direction: column;
  overflow: hidden;
}


/* 头部标签样式 */
header {
  width: 100%;
  height: 58px;
  box-shadow: 0 0 5px #868686;
  background-color: #e1e1e1;
  position: absolute;
  line-height: 80px;
  z-index: 300;
}

/* 尾部标签样式*/
footer {
  width: 100%;
  height: 58px;
  position: absolute;
  display: inline-block;
  bottom: 0;
  background-color: #e1e1e1;
  box-shadow: 0 0 5px #868686;
  z-index: 300;
  text-align: center;
}

footer div {
  margin-top: 10px;
  display: inline-block;
  color: #3a5fd9;
  font-size: 18px;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
}

footer span {
  font-size: 24px;
  font-weight: 700;
}

/* 身体样式 */
#middle {
  width: 100%;
  height: 100%;
  background-color: #e1e1e1;
  padding: 58px 0;
  flex: 1;
  z-index: 100;
  display: flex;
}



/* ------------  头部样式  ----------------------- */

header div {
  width: 48px;
  height: 48px;
  background-color: #e1e1e1;
  display: inline-block;
  line-height: 64px;
  padding: 3px;
  box-sizing: border-box;
  border-radius: 12px;
  box-shadow: 2px 2px 6px #b0b0b0,-2px -2px 6px #ffffff;
  position: absolute;
  top: 50%;
  left: 20px;
  margin-top: -24px;
}

header img {
  height: 42px;
  border-radius: 24px;
}


/* ------------  身体样式  ----------------------- */

/* 体内浮动显示 */
#box1 {
  width: 64px;
  float: left;
  background: #e1e1e1;
  box-shadow: 0 0 4px grey;
  z-index: 200;
}
#box2 {
  flex: 1;
  background: #e1e1e1;
  z-index: 1;
  box-sizing: border-box;
  padding: 30px 30px 80px 30px;
  display: flex;
  flex-wrap: wrap;
  align-content: flex-start;
  overflow: auto;
}
#box3 {
  background: #e1e1e1;
  width: 280px;
  height: 100%;
  float: right;
  box-shadow: 0 0 4px grey;
  z-index: 200;
  display: flex;
  flex-direction: column;
  overflow: hidden;
}


/* -----  左侧边栏样式  ----- */

#box1 li {
  width: 46px;
  height: 46px;
  display: inline-block;
  background-color: #e1e1e1;
  border-radius: 14px;
  box-sizing: border-box;
  margin: 10px;
  text-align: center;
  line-height: 46px;
  border: 1px solid gray;
  transition: .25s all;
  font-size: 18px;
}
#box1 li:hover {
  box-shadow: 2px 2px 6px #a9a9a9,-2px -2px 6px #ffffff;
  background: #e1e1e1;
  color: #3a5fd9;
  border: .1px solid transparent;
  font-size: 22px;
}

/* -----  中间部分样式  ----- */
#card {
  width: 140px;
  height: 110px;
  display: inline-block;
  box-sizing: border-box;
  margin: 20px 20px 60px 20px;
  background: #e1e1e1;
  border: 1px solid gray;
  border-radius: 12px;
  transition: .25s all;
  padding: 8px;
  position: relative;
}

#card:hover {
  box-shadow: 4px 4px 8px #a9a9a9,-4px -4px 8px #ffffff;
  border: .1px solid transparent;
  margin: 14px;
  width: 152px;
  height: 122px;
  color: #1a50ff;
}

#card>div {
  position: absolute;
  display: inline-block;
  left: 0;
}

#incard1 {
  height: 100%;
  width: 100%;
  background-color: #e1e1e1;
  top: 0;
  border-radius: 12px;
  padding: 4px;
  box-sizing: border-box;
}
#incard2 {
  height: 40px;
  width: 100%;
  bottom: 0;
  border-radius: 0 0 12px 12px;
  border-top: 1px solid gray;
}

#incard2 nav {
  width: 100%;
  height: 100%;
  display: flex;
  flex-wrap: nowrap;
}

#incard2 div {
  flex: 1;
  text-align: center;
  height: 40px;
  line-height: 40px;
}


#incard2 div:hover {
  background: #3a5fd9;
  color: gold;
  height: 41px;
  line-height: 41px;
  font-size: 18px;
  font-weight: 700;
  border-radius: 0 0 12px 12px;
}

#son21 {
  border-bottom-left-radius: 12px;
}

#son22 {
  border-bottom-right-radius: 12px;
  border-left: 1px solid gray;
  margin-left: -1px;
}

#incard1>div {
  text-align: center;
  width: 100%;
  overflow: hidden;
}

#son11 {
  height: 35px;
  line-height: 40px;
  font-weight: 700;
  font-size: 18px;
}
#son12 {
  height: 30px;
  font-size: 14px;
  line-height: 14px;
  color: gray;
}

/* -----  右边栏样式  ----- */

#box3>div {
  width: 560px;
  height: 100%;
  display: inline-block;
  position: relative;;
}
#box3>div>div {
  width: 280px;
  height: 100%;
  padding: 20px 20px 120px 20px;
  box-sizing: border-box;
  position: absolute;
  right: 0;
  top: 0;
  background-color: #e1e1e1;
}
#box3>div>div>div {
  width: 100%;
  height: 100%;
  border-radius: 12px;
  border: 1px solid gray;
  background-color: #e1e1e1;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
}
#in-aside-order1 {
  width: 100%;
  height: 50px;
  border-radius: 12px 12px 0 0;
  border-bottom: 1px solid gray;
  background: #e1e1e1;
  line-height: 50px;
  text-align: center;
  font-size: 24px;
  font-weight: 700;
  overflow: hidden;
  position: relative;
}
/* 左侧是删除 右侧是标题 */
#in-aside-order1-inner {
  width: 480px;
  height: 50px;
  float: right;
  position: absolute;
  background: #e1e1e1;
  right: 0;
  top: 0;
  transition: all .25s;
}
#in-aside-order1-inner:hover {
  transform: translateX(240px);
  background: #ff4e4e;
  color: #fff;
}
#in-aside-order1-inner>div {
  width: 240px;
  height: 50px;
  display: inline-block;
  text-align: center;
}
#in-aside-order1-inner-left {
  display: inline-block;
  float: left;
  background: transparent;
  position: relative;
}
#in-aside-order1-inner-right {
  display: inline-block;
  float: right;
  background: transparent;
}
#in-aside-order2 {
  text-align: center;
  flex: 1;
  padding: 16px 0;
  overflow-y: scroll;
}
#in-aside-order-quick-info {
  padding: 0 10px;
  width: 239px;
  box-sizing: border-box;
  height: 38px;
  background-color: #e1e1e1;
  border-top: 1px solid gray;
  z-index: 700;
  display: flex;
  text-align: center;
  flex-wrap: nowrap;
  flex-direction: row;
}
#quick-info-button {
  flex: 1;
  height: 30px;
  margin: 4px 2px;
  border-radius: 2px;
  font-size: 12px;
  line-height: 30px;
  color: #fff;
  box-sizing: border-box;
  transition: all .25s;
  position: relative;
  overflow: hidden;
}

#in-quick-info-button-container {
  width: 200%;
  height: 30px;
  position: absolute;
  right: 0;
  top: 0;
}

#in-quick-info-button-container:hover {
  left: 0;
}

#in-quick-info-button-container>div {
  width: 50%;
  height: 30px;
  display: inline-block;
  position: absolute;
  top: 0;
  text-align: center;
  line-height: 30px;
}
#in-quick-info-button-container :first-child {
  background: #3a5fd9;
  left: 0;
}
#in-quick-info-button-container :last-child {
  right: 0;
}

#quick-info-button:hover {
  box-shadow: 0 0 4px gray;
  font-size: 16px;
}
#quick-info-icon {
  color: #fff;
  font-size: 24px;
  font-weight: 200;
}
#in-aside-order3 {
  padding: 8px 5%;
  background-color: #e1e1e1;
  text-align: center;
  border-top: 1px solid gray;
  z-index: 700;
}
#in-aside-order3>textarea {
  width: 90%;
  height: 24px;
  background-color: #e1e1e1;
  border-radius: 4px;
  resize:none;
  outline: none;
  border: 1px solid gray;
  font-weight: 400;
  padding: 2px;
  font-size: 14px;
  transition: all .25s;
  line-height: 24px;
}
#in-aside-order3>textarea:hover {
  box-shadow: 2px 2px 4px #a9a9a9,-2px -2px 4px #ffffff;
  border: 1px solid transparent;
}
#in-aside-order3>textarea:focus {
  box-shadow: 2px 2px 4px #a9a9a9 inset,-2px -2px 4px #ffffff inset;
  height: 72px;
  border: 1px solid transparent;
  padding: 12px 6px;
  box-sizing: border-box;
}
#in-aside-order4 {
  height: 64px;
  background-color: #e1e1e1;
  border-radius: 0 0 12px 12px;
  text-align: center;
  border-top: 1px solid gray;
  z-index: 700;
}


#button-order {
  display: inline-block;
  width: 196px;
  height: 38px;
  border: 1px solid gray;
  transform: translateY(13px);
  margin: 2px;
  line-height: 38px;
  color: #3a5fd9;
  background-color: #e1e1e1;
  font-weight: 700;
  border-radius: 4px;
  transition: all .25s;
}

#button-order:hover {
  width: 200px;
  height: 40px;
  line-height: 39px;
  background: #3a5fd9;
  color: gold;
  box-shadow: 4px 4px 8px #a9a9a9,-4px -4px 8px #ffffff;
}
#button-order:disabled {
  background-color: #d9d9d9;
  color: gray;
}
#button-order:disabled:hover {
  width: 196px;
  height: 38px;
  line-height: 38px;
  box-shadow: none;
}
#in-aside-order-card {
  display: inline-block;
  width: 90%;
  height: 120px;
  background: #e1e1e1;
  border-radius: 8px;
  border: 1px solid gray;
  margin: 10px 2px;
  box-shadow: 2px 2px 4px #a9a9a9,-2px -2px 4px #ffffff;

}
#in-aside-order-card-container {
  width: 100%;
  height: 120px;
  display: flex;
  flex-wrap: nowrap;
  flex-direction: column;
  text-align: center;
}

/* ---- 点菜小卡片 ---- */
#in-aside-card-1 {
  flex: .3;
  border-radius: 8px 8px 0 0;
  color: #000;
  font-size: 20px;
  font-weight: 700;
  box-sizing: border-box;
  margin-top: 10px;
}
#in-aside-card-2 {
  flex: .3;
  color: gray;
  font-size: 12px;
}
#in-aside-card-3 {
  flex: .4;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
}

.order-input {
  flex: .4;
  height: 28px;
  display: inline-block;
  box-sizing: border-box;
  outline: none;
  text-align: center;
}
.order-input>input {
  text-align: center;
  background-color: #e1e1e1;
  width: 64px;
  height: 28px;
  font-size: 28px;
  font-weight: 400;
  border: none;
  outline: none;
  transition: all .25s
}
.order-input:hover {
  border: none;
  box-shadow: 4px 4px 8px #a9a9a9,-4px -4px 8px #ffffff;
}
.order-input>input:focus {
  box-shadow: 2px 2px 4px #a9a9a9 inset;
  color: #3a5fd9;
  font-size: 24px;
}
.order-button {
  flex: .4;
}

.order-button>button {
  display: inline-block;
  width: 64%;
  height: 28px;
  background-color: #e1e1e1;
  text-align: center;
  line-height: 28px;
  box-sizing: border-box;
  margin: 2px 4px;
  border: none;
  transition: all .25s;
}
.order-button>button:hover {
  border: none;
  box-shadow: 4px 4px 8px #a9a9a9,-4px -4px 8px #ffffff;
}
.order-button>button:disabled {
  opacity: 0;
}
#in-aside-card-4 {
  height: 20px;
  color: #000;
  border-radius: 0 0 8px 8px;
  font-size: 18px;
  font-weight: 400;
  line-height: 18px;
  border-top: 1px solid gray;
}
#in-aside-card-4:hover {
  background-color: #ff4141;
  color: #fff;
}

/* ---- 历史页面 ---- */
#in-history-aside-1 {
  width: 100%;
  height: 52px;
  border-radius: 12px 12px 0 0;
  border-bottom: 1px solid gray;
  background: #e1e1e1;
  line-height: 50px;
  text-align: center;
  font-size: 24px;
  font-weight: 700;
  overflow: hidden;
}
#in-history-aside-2 {
  flex: 1;
  box-shadow: 2px 2px 4px #a9a9a9 inset,-2px -2px 4px #ffffff inset;
  background: #dadada;
  overflow: scroll;
}

#in-history-aside-3 {
  width: 100%;
  height: 70px;
  border-top: 1px solid gray;
  text-align: center;
}

#in-history-aside-3-container {
  width: 220px;
  height: 28px;
  margin: 22px 10px 0 10px;
  display: flex;
  flex-wrap: nowrap;
  flex-direction: row;
}
#in-history-aside-3-container>input {
  //width: 40%;
  height: 100%;
  outline: none;
  background-color: #e1e1e1;
  border: 1px solid gray;
  text-align: center;
  line-height: 28px;
  font-size: 16px;
  font-weight: 200;
  transition: all .25s;
}
/* 历史订单-回到今天 */
#in-history-aside-3-container :nth-child(1) {
  width: 32px;
  height: 28px;
  line-height: 28px;
  text-align: center;
  font-size: 22px;
  display: inline-block;
  border: 1px solid gray;
  border-radius: 8px 0 0 8px;
  border-right-style: dashed;
}
#in-history-aside-3-container :nth-child(1):hover {
  background: #3a5fd9;
  color: #fff;
}
#in-history-aside-3-container :nth-child(2) {
  text-align: center;
  border-right: none;
  border-left: none;
  min-width: 0px;
  flex: 1;
}
#in-history-aside-3-container :nth-child(3) {
  border-radius: 0 8px 8px 0;
  text-align: center;
  border-left-style: dashed;
  min-width: 0px;
  flex: 1;
}
#in-history-aside-3-container>input:focus {
  color: #3a5fd9;
  font-size: 18px;
  box-shadow: 2px 2px 4px #a9a9a9 inset,-2px -2px 4px #ffffff inset;
}

/* ----------- 动画 ---------------- */

.hidden {
  animation: hidden .25s forwards;
}
.show {
  animation: show .25s forwards;
}

@keyframes show {
  0% {
    transform: translateX(0);
    opacity: 1;
    z-index: 400;
    width: 280px;
    height: 100%;
  }
  100% {
    transform: translateX(-280px);
    opacity: 1;
    z-index: 400;
    width: 280px;
    height: 100%;
  }
}
@keyframes hidden {
  0% {
    transform: translateX(-280px);
    z-index: 300;
    width: 280px;
    height: 100%;
    opacity: 1;
  }
  50% {
    opacity: 0;
  }
  100% {
    transform: translateX(0);
    z-index: 300;
    width: 240px;
    height: 100%;
  }
}

/* 时针 */
@keyframes clock1 {
  0% {
    transform: rotateZ(0);
  }
  100% {
    transform: rotateZ(-360deg);
  }
}
/* 分针 */
@keyframes clock2 {
  0% {
    transform: rotateZ(0);
  }
  100% {
    transform: rotateZ(-1440deg);
  }
}

/* ------------  浮动样式  ----------------------- */

.float-button {
  width: 40px;
  height: 40px;
  background-color: #e1e1e1;
  position: absolute;
  z-index: 400;
  top: 0;
  border-radius: 0 0 8px 8px;
  transition: .25s all;
  border: 1px solid gray;
  color: gray;
  font-size: 14px;
  text-align: center;
  line-height: 20px;
  overflow: hidden;
}

.in-float-button-container {
  width: 80px;
  height: 40px;
  position: absolute;
  right: 0;
  top: 0;
  transition: all .25s;
}

.in-float-button-container>div {
  display: inline-block;
  width: 50%;
  height: 100%;
  transition: all .25s;
}

.in-float-button-container :first-child {
  float: left;
  color: #fff;
  font-size: 22px;
  text-align: center;
  line-height: 40px;
  width: 40px;
  transform: translateX(0);
}


.in-float-button-container:hover {
  transform: translateX(40px);
  background: #3a5fd9;
}

.in-float-button-container :first-child:active {
  font-size: 18px;
}




#exchange-button {
  right: 180px;
}
#reprint-button {
  right: 100px;
}

/* ------ 小装饰 ----------- */
.lajitong-clear {
  font-size: 24px;
  color: #efefff;
}

.img-recycle-clear {
  width: 40px;
  height: 40px;
  position: absolute;
  bottom: 0;
  right: 16px;
  z-index: 2000;
}
.icon-money {
  font-weight: 500;
  font-size: 22px;
  color: goldenrod;
  display: inline-block;
  animation: roate-money 2s linear infinite;
}

.icon-clock {
  position: absolute;
  width: 22px;
  height: 22px;
  left: 0;
  bottom: -4px;
}
.clock1 {
  animation: clock1 2s linear infinite;
}
.clock2 {
  animation: clock2 2s linear infinite;
}
@keyframes roate-money {
  50% {
    transform: rotateY(180deg);
  }
  100% {
    transform: rotateY(360deg);
  }

}


/* ------ 整体样式 ------ */
div::-webkit-scrollbar {
  display: none;
}
textarea {
  overflow: hidden;
}

/* ----- 一些小装饰 ----- */
.do-order {
  box-shadow: 2px 2px 4px #a9a9a9 inset,-2px -2px 4px #ffffff inset;
  background: #dadada;
}
.no-order {

}
</style>
