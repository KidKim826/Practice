<template>
  <div id="formV">
    <div class="container">
      <div class="col-md-6 offset-md-3">
      <h1 class="text-center" style="font-weight: bolder"> &#129497; TodoList &#129409;</h1>
      <div>
        <input type="text" class="form-control form-control-lg mb-4" v-model="todo"
          placeholder="what do you want to do"  @keyup.enter="addList"/>
        <button id="btn" @click="addList">+</button>
        <input id="save" type="button" value="save" />
        <input id="check" type="button" value="complete"/>
        <button id="deleteAll" class="" @click="deleteAll">delete all</button>
      </div>
    </div>
    </div>
    </div>
</template>

<script>
export default {
  name: "FormView",
  data() {
    return {
      todo: ""
    };
  },
  methods: {
    addList() { //인자를 input에서 문자열로 들어오는 todo랑, done이라는걸 하나 만들어서 그걸 TL에 담아서 넘겨줌
      let TD = this.todo;
      let done = false;
      let TL = {TD, done};
      this.$store.dispatch("addList", TL);
      this.todo = "";
    },
    deleteAll() { // deleteAll 하는거
      this.$store.dispatch("deleteAll");
    },
  }
};
</script>

<style>
/* https://unikys.tistory.com/371  부트스트랩 그리드
    http://bootstrapk.com/css/
    https://getbootstrap.com/docs/5.0/forms/form-control/
*/
</style>

