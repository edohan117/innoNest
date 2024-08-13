<template>
  <footer class="footer">
    <div class="footer-content">
      <div class="footer-section">
        <h3>InnoNest</h3>
        <p>혁신적인 아이디어의 온상, InnoNest에서 여러분의 창의력을 펼쳐보세요.</p>
      </div>
      <div class="footer-section">
        <h3>빠른 링크</h3>
        <ul>
          <li><a href="/sitemap">사이트맵</a></li>
          <li><a href="/terms">이용 약관</a></li>
          <li><a href="/privacy">개인정보 처리방침</a></li>
          <li><a href="/support">고객 지원</a></li>
        </ul>
      </div>
      <div class="footer-section">
        <h3>소셜 미디어</h3>
        <div class="social-icons">
          <a href="#" aria-label="Facebook"><i class="fab fa-facebook-f"></i></a>
          <a href="#" aria-label="Twitter"><i class="fab fa-twitter"></i></a>
          <a href="#" aria-label="Instagram"><i class="fab fa-instagram"></i></a>
          <a href="#" aria-label="LinkedIn"><i class="fab fa-linkedin-in"></i></a>
        </div>
      </div>
      <div class="footer-section">
        <h3>뉴스레터 구독</h3>
        <form @submit.prevent="subscribeNewsletter" class="newsletter-form">
          <input type="email" v-model="email" placeholder="이메일 주소" required>
          <button type="submit">구독</button>
        </form>
      </div>
    </div>
    <div class="footer-bottom">
      <p>&copy; 2024 InnoNest. All rights reserved.</p>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'Footer',
  data() {
    return {
      email: ''
    }
  },
  methods: {
    subscribeNewsletter() {
      // 여기에 뉴스레터 구독 로직을 구현합니다.
      console.log('구독 이메일:', this.email);
      // API 호출 등의 로직을 추가할 수 있습니다.
      this.email = ''; // 폼 초기화
      alert('뉴스레터 구독이 완료되었습니다!');
    }
  }
}
</script>

<style scoped>
.footer {
  background-color: #2c3e50;
  color: #ecf0f1;
  padding: 3rem 0 1rem;
  flex-shrink: 0;
  /* 추가 */
}


.footer-content {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 2rem;
}

.footer-section {
  flex: 1;
  margin-bottom: 2rem;
  min-width: 200px;
}

.footer-section h3 {
  color: #3498db;
  margin-bottom: 1rem;
}

.footer-section ul {
  list-style-type: none;
  padding: 0;
}

.footer-section ul li {
  margin-bottom: 0.5rem;
}

.footer-section a {
  color: #ecf0f1;
  text-decoration: none;
  transition: color 0.3s ease;
}

.footer-section a:hover {
  color: #3498db;
}

.social-icons {
  display: flex;
  gap: 1rem;
}

.social-icons a {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  width: 40px;
  height: 40px;
  background-color: #34495e;
  border-radius: 50%;
  transition: background-color 0.3s ease;
}

.social-icons a:hover {
  background-color: #3498db;
}

.newsletter-form {
  display: flex;
  margin-top: 1rem;
}

.newsletter-form input {
  flex-grow: 1;
  padding: 0.5rem;
  border: none;
  border-radius: 4px 0 0 4px;
}

.newsletter-form button {
  padding: 0.5rem 1rem;
  background-color: #3498db;
  color: white;
  border: none;
  border-radius: 0 4px 4px 0;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.newsletter-form button:hover {
  background-color: #2980b9;
}

.footer-bottom {
  text-align: center;
  margin-top: 2rem;
  padding-top: 1rem;
  border-top: 1px solid #34495e;
}

@media (max-width: 768px) {
  .footer-content {
    flex-direction: column;
  }

  .footer-section {
    margin-bottom: 2rem;
  }
}
</style>