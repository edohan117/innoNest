import { createStore } from 'vuex';

const store = createStore({
  state: {
    loggedIn: false
  },
  mutations: {
    setLoggedIn(state, status) {
      state.loggedIn = status;
    }
  },
  actions: {
    login({ commit }) {
      commit('setLoggedIn', true);
    },
    logout({ commit }) {
      commit('setLoggedIn', false);
    }
  },
  getters: {
    isLoggedIn(state) {
      return state.loggedIn;
    }
  }
});

export default store;
