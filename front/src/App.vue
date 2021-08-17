<template>
 <div id="app">
    <newfile></newfile>
  </div>
</template>

<script>
import newfile from './components/newfile'


export default {
  name: 'app',
  components: {
   newfile
   
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
