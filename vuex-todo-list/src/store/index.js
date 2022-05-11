import Vue from 'vue'
import Vuex from 'vuex'
import createPersistateState from "vuex-persistedstate"; //로컬스토리지 그대로 두기

Vue.use(Vuex)

export default new Vuex.Store({
  plugins: [createPersistateState()],
  state: {
    todoList: [],
  },
  getters: {
    // getTodoList(state) {
    //   if(localStorage.getItem('todoList')) {
    //     state.todoList = localStorage.getItem('todoList')
    //   }
    //   return state.todoList
    // }
  },
  mutations: {
    ADD_LIST(state, payload) {
      state.todoList.push(payload)
      // localStorage.setItem('todoList', state.todoList)
      console.log(state.todoList)
    },
    DELETE_LIST(state) { //FormView에서 deleteAll 부분
      state.todoList = [];
    },
    DELETE_LITTLE(state, index) { //index가 일로 왔다.
      state.todoList.splice(index, 1); //todolist에서 해당 부분만 잘라줌.
    }

  },
  actions: {
    addList({commit}, payload) {
      commit('ADD_LIST', payload)
      // console.log(payload)
    },
    deleteAll({commit}) { //FormView에서 deleteAll 하면 여기서 처리
      commit('DELETE_LIST')
    },
    doLittle({commit}, index) {//delete_littel로 index를 같이 넘겨준다.
      commit('DELETE_LITTLE', index)
    }
  },
  modules: {
  }
})
