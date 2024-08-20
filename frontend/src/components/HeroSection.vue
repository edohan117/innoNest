<template>
  <section class="hero">
    <h2>Welcome to InnoNest</h2>
    <p>Share your innovative ideas and connect with like-minded individuals</p>
    <a href="#" @click.prevent="checkLoginAndNavigate('/ideaSubmit')" class="cta-button">Start Sharing</a>
  </section>
</template>
  
<script>
import { computed } from 'vue';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';

export default {
  name: 'HeroSection',
  setup() {
    const store = useStore();
    const router = useRouter();

    // Vuex 상태와 Getter
    const isLoggedIn = computed(() => store.getters.isAuthenticated);
    const user = computed(() => store.getters.user);
    const role = computed(() => store.getters.role);

    const checkLoginAndNavigate = (path) => {
      if (!isLoggedIn.value) {
        router.push('/loginForm');
      } else {
        router.push(path);
      }
    };

    return {
      isLoggedIn,
      user,
      role,
      checkLoginAndNavigate,
    };
  },
  computed: {
    canView() {
      return this.role === 'ADMIN';
    }
  },
};
</script>

  
<style scoped>
.hero {
  background-color: #3498db;
  color: #fff;
  text-align: center;
  padding: 4rem 2rem;
  border-radius: 8px;
  margin-bottom: 2rem;
}

h2 {
  font-size: 2.5rem;
  margin-bottom: 1rem;
}

p {
  font-size: 1.2rem;
  margin-bottom: 2rem;
}

.cta-button {
  background-color: #fff;
  color: #3498db;
  border: none;
  padding: 0.75rem 1.5rem;
  font-size: 1rem;
  font-weight: bold;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease, color 0.3s ease;
  text-decoration: none;
}

.cta-button:hover {
  background-color: #2980b9;
  color: #fff;
  width: 100%;
}
</style>