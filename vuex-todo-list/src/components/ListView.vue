<template>
  <div class="listView">
    <div class="list mb-4">
      <!-- 여기서 :key부분에 문자열/숫자 외에 다른타입이 들어가면 오류가 난다는데 이런경우 어떻게 하나 -->
      <!-- key에 그냥 index를 주고 v-for에 같이 돌린다. by 고나령-->
      <!-- 근데 index는 어찌 알고 얘가 돌아가는 걸까 -->
      <div :class="{completed: todo.done}" v-for="(todo, index) in todoList" :key="index"> 
        <!-- <ul class="todo-list-g" >
          <li class="todo-item text-left" @click="complete">
          {{todo}}
          </li>
        </ul>-->
        <p>
          <label>
            <input  id="todo-item" type="checkbox" style="accent-color: red" @click="complete(todo)"/>
            {{todo.TD}}
            <button id="todo-complete" class="mb-1" @click="doLittle(todo)">Done</button>
          </label>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ListView",
  computed: {
    todoList() {
      return this.$store.state.todoList;
    }
  },
  methods: {
    complete(todo) { //complete는 todo.done의 상태값 바꿔줌 
      todo.done = !todo.done;
    },
    doLittle(index) {//위에서 사용한 index 가져와서
       this.$store.dispatch("doLittle", index); // 이쪽으로 넘겨줌
    }
  }
};
</script>

<style>
</style>