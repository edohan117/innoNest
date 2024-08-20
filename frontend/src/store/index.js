import { createStore } from 'vuex';

export default createStore({
  state: {
    user: JSON.parse(localStorage.getItem('user')) || null, // localStorage에서 사용자 정보 불러오기
    isAuthenticated: !!localStorage.getItem('user'), // localStorage에 정보가 있으면 인증됨
    role: localStorage.getItem('role') || '' // 사용자 권한 상태 추가
  },
  mutations: {
    SET_USER(state, user) {
      state.user = user;
      state.isAuthenticated = !!user;
      localStorage.setItem('user', JSON.stringify(user)); // localStorage에 사용자 정보 저장
    },
    SET_ROLE(state, role) {
      state.role = role;
      localStorage.setItem('role', role); // localStorage에 권한 정보 저장
    },
    LOGOUT(state) {
      state.user = null;
      state.isAuthenticated = false;
      state.role = '';
      localStorage.removeItem('user'); // localStorage에서 사용자 정보 제거
      localStorage.removeItem('role'); // localStorage에서 권한 정보 제거
    }
  },
  actions: {
    login({ commit }, { user, role }) {
      commit('SET_USER', user);
      commit('SET_ROLE', role);
    },
    logout({ commit }) {
      commit('LOGOUT');
    }
  },
  getters: {
    isAuthenticated(state) {
      return state.isAuthenticated;
    },
    user(state) {
      return state.user;
    },
    role(state) {
      return state.role; // 추가된 권한 반환
    }
  }
});
