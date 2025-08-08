<template>
<div>
  <div><input v-model="counter"></div>
  <div>{{counter}}</div>
  <div>{{showNum.toFixed()}}</div>
</div>
</template>

<script>
import {gsap} from "gsap";
export default {
  name: 'TestView',
  data() {
    return {
      counter: 0,
      showNum: 0
    }
  },
  watch: {
    counter(newValue) {
      console.log(newValue)
      gsap.to(this, {duration: 1, showNum: newValue})
    }
  }
}
</script>


<style scoped>

</style>