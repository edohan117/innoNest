<template>
    <div class="login-form">
        <h2>Login</h2>
        <input v-model="username" type="text" placeholder="Username" />
        <input v-model="password" type="password" placeholder="Password" />
        <button @click="login">Login</button>
    </div>
</template>
  
<script>
import { ref, inject } from 'vue';
import { useRouter } from 'vue-router';

export default {
    setup() {
        const store = inject('$store');
        const router = useRouter();
        const username = ref('');
        const password = ref('');

        const login = () => {
            if (username.value && password.value) {
                if (store) {
                    store.loggedIn = true; // store 객체에 loggedIn 속성이 있는지 확인
                    router.push('/');
                } else {
                    console.error('Store is not provided');
                }
            } else {
                alert('Please enter username and password');
            }
        };

        return {
            username,
            password,
            login
        };
    }
}
</script>
  
<style>
.login-form {
    display: flex;
    flex-direction: column;
    width: 300px;
    margin: 20px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f9f9f9;
}

.login-form input {
    margin-bottom: 10px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

.login-form button {
    padding: 10px;
    background-color: #333;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
</style>
  