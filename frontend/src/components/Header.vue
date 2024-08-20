<template>
  <header class="header">
    <div class="container">
      <div class="logo">
        <router-link to="/" class="logo-link">InnoNest</router-link>
      </div>
      <nav class="nav">
        <router-link to="/ideaList" class="nav-link">List</router-link>
        <router-link to="/ideaSubmit" class="nav-link">Submit</router-link>
        <router-link to="/noticeList" class="nav-link">Notice</router-link>
      </nav>
      <div class="auth">
        <span v-if="isLoggedIn" class="sessionId">{{ user.id }} 님</span>
        <button v-if="!isLoggedIn" @click="goToLogin" class="btn btn-login">로그인</button>
        <button v-else @click="logout" class="btn btn-logout">로그아웃</button>
      </div>
      <button class="menu-toggle" @click="toggleMenu" aria-label="메뉴 열기">
        <span class="menu-icon"></span>
      </button>
    </div>
    <div class="mobile-menu" :class="{ 'is-active': isMenuOpen }">
      <router-link to="/" class="mobile-nav-link" @click="closeMenu">홈</router-link>
      <router-link to="/ideaSubmit" class="mobile-nav-link" @click="closeMenu">아이디어</router-link>
      <router-link to="/noticeList" class="mobile-nav-link" @click="closeMenu">공지사항</router-link>
      <span v-if="isLoggedIn" class="sessionId">{{ user.id }} 님</span>
      <button v-if="!isLoggedIn" @click="goToLogin" class="btn btn-login">로그인</button>
      <button v-else @click="logout" class="btn btn-logout">로그아웃</button>
    </div>
  </header>
</template>

<script>
import { computed, ref } from 'vue';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';

export default {
  name: 'Header',
  setup() {
    const store = useStore();
    const router = useRouter();

    // Vuex 상태와 Getter
    const isLoggedIn = computed(() => store.getters.isAuthenticated);
    const user = computed(() => store.getters.user);

    const goToLogin = () => {
      router.push('/loginForm');
    };

    const logout = () => {
      store.dispatch('logout');
      router.push('/');
    };

    const isMenuOpen = ref(false);

    const toggleMenu = () => {
      isMenuOpen.value = !isMenuOpen.value;
    };

    const closeMenu = () => {
      isMenuOpen.value = false;
    };

    return {
      isLoggedIn,
      user,
      goToLogin,
      logout,
      isMenuOpen,
      toggleMenu,
      closeMenu,
    };
  },
};
</script>



<style scoped>
.header {
  background-color: #ffffff;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  position: sticky;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;
}

.container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1rem 2rem;
  max-width: 1200px;
  margin: 0 auto;
}

.logo-link {
  font-size: 1.5rem;
  font-weight: 700;
  color: #3a86ff;
  text-decoration: none;
  letter-spacing: 1px;
  transition: color 0.3s ease;
}

.logo-link:hover {
  color: #2563eb;
}

.nav {
  display: flex;
  gap: 1.5rem;
}

.nav-link {
  color: #4a5568;
  text-decoration: none;
  font-weight: 500;
  transition: color 0.3s ease;
  position: relative;
}

.nav-link::after {
  content: '';
  position: absolute;
  bottom: -5px;
  left: 0;
  width: 0;
  height: 2px;
  background-color: #3a86ff;
  transition: width 0.3s ease;
}

.nav-link:hover::after {
  width: 100%;
}

.btn {
  padding: 0.5rem 1.5rem;
  border: none;
  border-radius: 25px;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.3s ease;
}

.btn-login {
  background-color: #3a86ff;
  color: #ffffff;
}

.btn-login:hover {
  background-color: #2563eb;
  transform: translateY(-2px);
  box-shadow: 0 4px 6px rgba(58, 134, 255, 0.2);
}

.btn-logout {
  background-color: #e2e8f0;
  color: #4a5568;
}

.btn-logout:hover {
  background-color: #cbd5e0;
  transform: translateY(-2px);
  box-shadow: 0 4px 6px rgba(203, 213, 224, 0.2);
}

.menu-toggle {
  display: none;
  background: none;
  border: none;
  cursor: pointer;
  padding: 10px;
}

.menu-icon {
  display: block;
  width: 25px;
  height: 3px;
  background-color: #4a5568;
  position: relative;
  transition: background-color 0.3s ease;
}

.menu-icon::before,
.menu-icon::after {
  content: '';
  position: absolute;
  width: 25px;
  height: 3px;
  background-color: #4a5568;
  transition: transform 0.3s ease;
}

.menu-icon::before {
  top: -8px;
}

.menu-icon::after {
  bottom: -8px;
}

.mobile-menu {
  display: none;
}

@media (max-width: 768px) {

  .nav,
  .auth {
    display: none;
  }

  .menu-toggle {
    display: block;
  }

  .mobile-menu {
    display: flex;
    flex-direction: column;
    background-color: #ffffff;
    padding: 1rem;
    position: absolute;
    top: 100%;
    left: 0;
    right: 0;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    transform: translateY(-100%);
    transition: transform 0.3s ease;
  }

  .mobile-menu.is-active {
    transform: translateY(0);
  }

  .mobile-nav-link {
    color: #4a5568;
    text-decoration: none;
    padding: 0.75rem 0;
    font-weight: 500;
    border-bottom: 1px solid #e2e8f0;
  }

  .mobile-menu .btn {
    margin-top: 1rem;
    width: 100%;
  }

  .menu-toggle[aria-expanded="true"] .menu-icon {
    background-color: transparent;
  }

  .menu-toggle[aria-expanded="true"] .menu-icon::before {
    transform: translateY(8px) rotate(45deg);
  }

  .menu-toggle[aria-expanded="true"] .menu-icon::after {
    transform: translateY(-8px) rotate(-45deg);
  }
}

/* 오른쪽 여백 추가 */
.auth {
  display: flex;
  align-items: center;
  gap: 1rem; /* 로그인/로그아웃 버튼과 사용자 ID 사이의 간격 추가 */
}

.sessionId {
  margin-right: 1rem; /* 오른쪽 여백 추가 */
}
</style>
