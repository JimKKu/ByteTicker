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
        <div id="card" v-for="menu in menuList" :key="menu.id">
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
              <div id="son21" :style="menu.price2?'border-right: 1px solid gray':''">{{ menu.price1 }}<span style="font-size: 12px">￥</span></div>
              <div id="son22" v-if="menu.price2">{{ menu.price2 }}<span style="font-size: 12px">￥</span></div>
            </nav>
          </div>
        </div>
      </div>
      <div id="box3">
        <div>
          <div :class="aside1?'show':'hidden'" @animationend='aside1===false'>
            <div id="aside-order">
              <div id="in-aside-order1">
                <i class="iconfont icon-qian8 icon-money"></i>
                来单咯
                <i class="iconfont icon-qian8 icon-money"></i>
              </div>
              <div id="in-aside-order2">
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
                      <div id="in-aside-card-4" @click="btnDelOrder(index)" :style="order.num === 0?'height: 36px;transition: .5s all;line-height:36px;background-color:#f0a1a8;color:#fff;font-size: 32px':'transition: .5s all;'"><i class="iconfont icon-lajitong"></i></div>
                    </div>
                  </div>
              </div>
              <div id="in-aside-order3">
                <textarea placeholder="请输入备注..."></textarea>
              </div>
              <div id="in-aside-order4">
                <div id="button-order">下&nbsp;&nbsp;单</div>
              </div>
            </div>
          </div>
          <div :class="aside1?'hidden':'show'" @animationend='aside1===true'>
            <div id="aside-history">

            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 页脚 -->
    <footer>
<!--      <div id="order">下单</div>-->
    </footer>
    <div id="exchange-button" @click="changeAside">

    </div>
  </div>
</template>

<script>
import {reqGetTypeList} from "@/api/type";
import {reqGetMenuList} from "@/api/menu";

export default {
  name: 'OrderView',
  data() {
    return {
      /* type */
      typeList: [],
      menuList: [],
      orderList: [
        {
          name1: '雪菜肉丝面',
          name2: '刀削面',
          price: 22,
          size: 'big',
          num: 2
        },
        {
          name1: '雪菜肉丝面',
          name2: '刀削面',
          price: 22,
          size: 'big',
          num: 2
        },
        {
          name1: '雪菜肉丝面',
          name2: '刀削面',
          price: 22,
          size: 'big',
          num: 2
        },
        {
          name1: '雪菜肉丝面',
          name2: '刀削面',
          price: 22,
          size: 'big',
          num: 2
        },
        {
          name1: '雪菜肉丝面',
          name2: '刀削面',
          price: 22,
          size: 'big',
          num: 2
        },
        {
          name1: '雪菜肉丝面',
          name2: '刀削面',
          price: 22,
          size: 'big',
          num: 2
        },

      ],
      aside1: true
    }
  },
  mounted() {
    this.getTypeList();
    this.getMenuList(0);
  },
  methods: {
    /* ----- methods ----- */
    changeAside(){
      this.aside1=!this.aside1;
    },
    btnAddOrder (index) {
      if( this.orderList[index].num < 99) this.orderList[index].num ++;
    },
    btnMinusOrder (index) {
      if( this.orderList[index].num > 0) this.orderList[index].num --;
    },
    btnDelOrder (index) {
      this.orderList.splice(index,1)
    },
    /* ------- 请求 ------- */
    async getTypeList() {
      this.typeList = await reqGetTypeList();
    },
    async getMenuList(typeId) {
      this.menuList = await reqGetMenuList(typeId);
    }
  }
}
</script>

<style scoped>
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
}
#in-aside-order2 {
  text-align: center;
  flex: 1;
  padding: 16px 0;
  background: #e1e1e1;
  overflow-y: scroll;

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
  font-size: 18px;
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

#in-aside-order-card {
  display: inline-block;
  width: 90%;
  height: 120px;
  background: #e1e1e1;
  border-radius: 8px;
  border: 1px solid gray;
  margin: 10px 2px;
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



/* ------------  浮动样式  ----------------------- */

#exchange-button {
  width: 20px;
  height: 20px;
  background-color: #ff7474;
  position: absolute;
  z-index: 400;
  right: 100px;
  top: 0;
  border-radius: 0 0 5px 5px;
  transition: .25s all;
  border: 1px solid gray;
}
#exchange-button:hover {
  height: 40px;
  border-radius: 0 0 8px 8px;
}


/* ------ 小装饰 ----------- */
.icon-money {
  font-weight: 500;
  font-size: 22px;
  color: goldenrod;
  display: inline-block;
  animation: roate-money 2s linear infinite;
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
</style>
