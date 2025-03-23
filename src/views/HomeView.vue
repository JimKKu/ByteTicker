<template>
  <!-- 全屏DIV -->
  <div id="container">
    <!-- 头部 -->
    <header>
      <div>
        <img alt="Vue logo" src="../assets/logo.png">
      </div>
    </header>
    <!-- 身体 -->
    <div id="middle">
      <div id="box1">
        <ul>
          <li v-for="type in typeList" :key="type.id">
            <i :class="type.icon"></i>
          </li>
        </ul>
      </div>
      <div id="box2">
        <div id="card" v-for="menu in menuList" :key="menu.id">
          <div id="incard1">
            <div id="son11">{{ menu.name }}1</div>
            <div id="son12">{{ menu.name }}2</div>
          </div>
          <div id="incard2">
            <div id="son21">{{ menu.price }}<span style="font-size: 12px">￥</span></div>
            <div id="son22">{{ menu.price+2 }}<span style="font-size: 12px">￥</span></div>
          </div>
        </div>
      </div>
      <div id="box3">我是边栏</div>
    </div>
    <!-- 页脚 -->
    <footer>
<!--      <div id="order">下单</div>-->
    </footer>
    <div id="exchange-button">

    </div>
  </div>
</template>

<script>
import {reqGetTypeList} from "@/api/type";

export default {
  name: 'OrderView',
  data() {
    return {
      /* type */
      typeList: [],
      menuList: [
        {
          id:1,
          name:'饺子饺子饺子饺子饺子饺子饺子饺子饺子饺子',
          price: 22,
        },
        {
          id:2,
          name:'馄饨',
          price: 22,
        },
        {
          id:3,
          name:'挂面',
          price: 22,
        },
        {
          id:1,
          name:'饺子',
          price: 22,
        },
        {
          id:2,
          name:'馄饨',
          price: 22,
        },
        {
          id:3,
          name:'挂面',
          price: 22,
        },
        {
          id:1,
          name:'饺子',
          price: 22,
        },
        {
          id:2,
          name:'馄饨',
          price: 22,
        },
        {
          id:3,
          name:'挂面',
          price: 22,
        },
        {
          id:1,
          name:'饺子',
          price: 22,
        },
        {
          id:2,
          name:'馄饨',
          price: 22,
        },
        {
          id:3,
          name:'挂面',
          price: 22,
        },
        {
          id:1,
          name:'饺子',
          price: 22,
        },
        {
          id:2,
          name:'馄饨',
          price: 22,
        },
        {
          id:3,
          name:'挂面',
          price: 22,
        },
        {
          id:1,
          name:'饺子',
          price: 22,
        },
        {
          id:2,
          name:'馄饨',
          price: 22,
        },
        {
          id:3,
          name:'挂面',
          price: 22,
        },
        {
          id:1,
          name:'饺子',
          price: 22,
        },
        {
          id:2,
          name:'馄饨',
          price: 22,
        },
        {
          id:3,
          name:'挂面',
          price: 22,
        },
      ]
    }
  },
  mounted() {
    this.getTypeList();
  },
  methods: {
    async getTypeList() {
      const {data} = await reqGetTypeList();
      this.typeList = data;
    }
    // getTypeList() {
    //   console.log('---------------------------------------------------------')
    //   this.typeList = reqGetTypeList();
    //   console.log(JSON.stringify(this.typeList));
    //   console.log('---------------------------------------------------------')
    // }
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
  padding: 50px;
  display: flex;
  flex-wrap: wrap;
  align-content: flex-start;
  overflow: auto;
}
#box3 {
  background: #e1e1e1;
  width: 180px;
  float: right;
  box-shadow: 0 0 4px grey;
  z-index: 200;
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
}

#incard1 {
  height: 100%;
  width: 100%;
  background-color: #e1e1e1;
  position: absolute;
  top: 0;
  left: 0;
  border-radius: 12px;
  padding: 4px;
  box-sizing: border-box;
}
#incard2 {
  height: 40px;
  width: 100%;
  position: absolute;
  bottom: 0;
  left: 0;
  border-radius: 0 0 12px 12px;
  border-top: 1px solid gray;
}

#incard2>div {
  width: 50%;
  height: 40px;
  line-height: 40px;
  box-sizing: border-box;
  text-align: center;
  background-color: #e1e1e1;
  transition: .25s all;
  border-collapse: collapse;
  font-size: 16px;
  color: gray;
}
#incard2>div:hover {
  background: #3a5fd9;
  color: gold;
  height: 41px;
  line-height: 41px;
  font-size: 18px;
  font-weight: 700;
}

#son21 {
  border-bottom-left-radius: 12px;
  float: left;
  border-right: 1px solid gray;
}

#son22 {
  border-bottom-right-radius: 12px;
  float: right;
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
</style>
