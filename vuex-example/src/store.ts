import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count: 0,
    todos: [
      {id: 1, text: '...',done: true},
      {id: 2, text: '...', done: false}
    ]
  },
  getters: {
    doneTodos: state => {
      return state.todos.filter(todo => todo.done)  //过滤条件为todo.done
    },
    doneTodosCount: (state, getters) => {
      return getters.doneTodos.length
    }
  },
  mutations: {
    increment (state, n) {
      state.count += n
    },
    decrement (state) {
      state.count--
    }
  },
  actions: {
    add (context) {
      context.commit('increment',100)
    }
  }
})
