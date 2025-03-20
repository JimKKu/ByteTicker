<template>
  <!-- 全屏DIV -->
  <div style="width: 100%;height: 100%;position: fixed">

      <!-- 身体DIV -->
      <div id="c-body">
        <!-- 头部DIV -->
        <div id="c-header" style="z-index: 100">
          <div id="c-header-div">
            <img id="c-header-div-img" alt="Vue logo" src="../assets/logo.png">
          </div>
        </div>
        <div id="c-in-body1" style="z-index: 1">
          <ul>
            <li v-for="type in typeList" :key="type.id">
              <i :class="type.icon"></i>
            </li>
          </ul>
        </div>
        <div id="c-in-body2">

        </div>
        <div id="c-in-body3"></div>
      </div>
      <!-- 底部DIV -->
      <div id="c-bottom">
        <div id="order">下单</div>
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
#c-header {
  height: 58px;
  line-height: 80px;
  box-shadow: 0 0 5px #868686;
  background-color: #e1e1e1;
  position: relative;
}

#c-header-div {
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
#c-header-div-img {
  height: 42px;
  border-radius: 24px;
}

#c-body {
  width: 100%;
  height: 100%;
  background-color: #e1e1e1;
  position: relative;
}
#c-bottom {
  width: 100%;
  height: 64px;
  position: absolute;
  display: inline-block;
  bottom: 0;
  background-color: #e1e1e1;
  box-shadow: 0 0 5px #868686;
}

#c-in-body1 {
  width: 64px;
  height: 100%;
  background-color: #e1e1e1;
  position: absolute;
  left: 0;
  box-shadow: 0 0 5px #868686;
  text-align: center;
}
#c-in-body1 li {
  display: inline-block;
  width: 46px;
  height: 46px;
  background-color: #e1e1e1;
  border-radius: 14px;
  box-sizing: border-box;
  margin: 10px;
  text-align: center;
  line-height: 46px;
  box-shadow: 2px 2px 6px #a9a9a9,-2px -2px 6px #ffffff;
  transition: .25s all;
  font-size: 20px;
}

#c-in-body1 li:hover {
  box-shadow: 2px 2px 6px #a9a9a9 inset,-2px -2px 6px #ffffff inset;
  font-size: 18px;
}


#c-in-body2 {
  z-index: -1;
  width: 100%;
  height: 100%;
  position: absolute;
  left: 64px;
}

#c-in-body3 {
  width: 256px;
  height: 100%;
  background-color: #e1e1e1;
  position: absolute;
  right: 0;
  box-shadow: 0 0 5px #868686;
}
#order {
  width: 140px;
  height: 80px;
  background-color: #fcc307;
  position: absolute;
  bottom: 24px;
  right: 264px;
  line-height: 80px;
  text-align: center;
  color: #fff;
  font-size: 42px;
  border-radius: 24px;
  transition: .25s all;
  box-shadow: 2px 2px 4px #ffff1c,-2px -2px 4px #12c2e9 ;
}


@keyframes hover-order {
  50% {
    box-shadow: none;
  } 100% {
    box-shadow: 2px 2px 6px #a9a9a9 inset,-2px -2px 6px #ffffff inset;
  }
}

</style>
