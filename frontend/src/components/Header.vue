<template>
  <header class="header">
    <div class="container">
      <div class="logo">
        <router-link to="/" class="logo-link">InnoNest</router-link>
      </div>
      <nav class="nav">
        <router-link to="/" class="nav-link">홈</router-link>
        <router-link to="/innoWrite" class="nav-link">아이디어</router-link>
        <router-link to="/about" class="nav-link">소개</router-link>
      </nav>
      <div class="auth">
        <button v-if="!isLoggedIn" @click="login" class="btn btn-login">로그인</button>
        <button v-else @click="logout" class="btn btn-logout">로그아웃</button>
      </div>
      <button class="menu-toggle" @click="toggleMenu" aria-label="메뉴 열기">
        <span class="menu-icon"></span>
      </button>
    </div>
    <div class="mobile-menu" :class="{ 'is-active': isMenuOpen }">
      <router-link to="/" class="mobile-nav-link" @click="closeMenu">홈</router-link>
      <router-link to="/ideas" class="mobile-nav-link" @click="closeMenu">아이디어</router-link>
      <router-link to="/about" class="mobile-nav-link" @click="closeMenu">소개</router-link>
      <button v-if="!isLoggedIn" @click="login" class="btn btn-login">로그인</button>
      <button v-else @click="logout" class="btn btn-logout">로그아웃</button>
    </div>
  </header>
</template>

<script>
export default {
  name: 'Header',
  data() {
    return {
      isLoggedIn: false,
      isMenuOpen: false
    }
  },
  methods: {
    login() {
      this.isLoggedIn = true
      this.closeMenu()
    },
    logout() {
      this.isLoggedIn = false
      this.closeMenu()
    },
    toggleMenu() {
      this.isMenuOpen = !this.isMenuOpen
    },
    closeMenu() {
      this.isMenuOpen = false
    }
  }
}
</script>

<style scoped>
.header {
  background-color: #ffffff;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  position: fixed;
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
</style>