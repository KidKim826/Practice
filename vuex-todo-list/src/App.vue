<template>
  <div id="app">
    <form-view></form-view>
    <list-view></list-view>
  </div>
</template>

<script>
import FormView from "./components/FormView.vue"
import ListView from "./components/ListView.vue"

export default {
  components: {
    FormView,
    ListView,
  }
}
</script>

<style>
@import url("css/appvue.css");

</style>
