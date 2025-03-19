<template>
  <!-- 全屏DIV -->
  <div style="width: 100%;height: 100%;position: fixed">
    <div style="width: 100%;height: 100%;position: relative">
      <!-- 头部DIV -->
      <div id="c-header">
        <div id="c-header-div">
          <img id="c-header-div-img" alt="Vue logo" src="../assets/logo.png">
        </div>
      </div>
      <!-- 身体DIV -->
      <div id="c-body">
        <div id="c-in-body1"></div>
        <div id="c-in-body2"></div>
        <div id="c-in-body3"></div>
      </div>
      <!-- 底部DIV -->
      <div id="c-bottom">
        <div id="order">下单</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'OrderView'
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
  box-shadow: 2px 2px 6px #b0b0b0,-2px -2px 6px #ffffff;
}

#c-body {
  z-index: -1;
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
  //background-color: #fcc307;
  background: linear-gradient(to right,#12c2e9, #ffff1c);;
  position: absolute;
  bottom: 24px;
  right: 264px;
  line-height: 80px;
  text-align: center;
  color: #fff;
  font-size: 42px;
  border-radius: 24px;
  transition: 1s all;
  box-shadow: 2px 2px 4px #ffff1c inset,-2px -2px 4px #12c2e9 inset ;
}
#order:hover {
  box-shadow: -2px -2px 4px #ffff1c inset,2px 2px 4px #12c2e9 inset ;
  //animation-name: hover-order;
  //animation-duration: 1s;
}

@keyframes hover-order {
  50% {
    box-shadow: -2px -2px 4px #ffff1c inset,2px 2px 4px #12c2e9 inset ;
    background: linear-gradient(to right,#ffff1c, #12c2e9);;
  } 100% {
    box-shadow: 2px 2px 4px #ffff1c inset,-2px -2px 4px #12c2e9 inset ;
    background: linear-gradient(to right,#12c2e9, #ffff1c);;
  }
}

</style>
