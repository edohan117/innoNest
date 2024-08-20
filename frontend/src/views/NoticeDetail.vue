<template>
  <section class="notice-detail">
    <h2>{{ notice.TITLE }}
      <div class="button-group">
        <router-link to="/noticeList" class="golist-btn">목록</router-link>
        <button class="modify-btn" @click="goToEditPage">수정</button>
        <button class="delete-btn" @click="deleteNotice">삭제</button>
      </div>
    </h2>
    <p class="notice-content">{{ notice.CONTENT }}</p>
    <div class="notice-meta">
      <div class="notice-author">
        <i class="fas fa-user"></i>
        <span>{{ notice.WRITER }}</span>
      </div>
      <div class="notice-date">
        <i class="fas fa-calendar-alt"></i>
        <span>{{ formatDate(notice.CREATEDATE) }}</span>
      </div>
    </div>


  </section>
</template>

<script>
import axios from 'axios';

export default {
  name: 'NoticeDetail',
  data() {
    return {
      notice: {},
      comments: [],
      newComment: '',
      replyForm: {},
      replyText: {}
    };
  },
  created() {
    this.fetchNoticeDetail();
  },
  methods: {
    fetchNoticeDetail() {
      const noticeId = this.$route.params.id;
      axios.get(`/api/notice/detail/${noticeId}`)
        .then(response => {
          this.notice = response.data;
        })
        .catch(error => {
          console.error('아이디어 세부정보를 가져오는 중 오류 발생:', error);
        });
    },
    formatDate(dateString) {
      const options = { year: 'numeric', month: 'long', day: 'numeric' };
      return new Date(dateString).toLocaleDateString(undefined, options);
    },
    goToEditPage() {
      this.$router.push({ name: 'NoticeEdit', params: { id: this.$route.params.id } });
    },
    deleteNotice() {
      const noticeId = this.$route.params.id;
      if (confirm('정말로 이 아이디어를 삭제하시겠습니까?')) {
        axios.delete(`/api/notice/delete/${noticeId}`)
          .then(() => {
            alert('아이디어가 삭제되었습니다.');
            this.$router.push({ name: 'NoticeList' }); // 아이디어 목록 페이지로 이동
          })
          .catch(error => {
            console.error('아이디어를 삭제하는 중 오류 발생:', error);
          });
      }
    }
  }
};
</script>

<style scoped>
.notice-detail {
  max-width: 800px;
  margin: 0 auto;
  padding: 2rem;
}

h2 {
  font-size: 2rem;
  color: #333;
  margin-bottom: 1rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button-group {
  display: flex;
  gap: 0.5rem; /* 버튼 사이의 간격 */
}

.modify-btn, .delete-btn {
  border: none;
  border-radius: 4px;
  padding: 0.3rem 0.8rem;
  font-size: 0.8rem;
  cursor: pointer;
  transition: background-color 0.3s, transform 0.2s;
}

.modify-btn {
  background-color: #2c3e50;
  color: #ecf0f1;
}

.modify-btn:hover {
  background-color: #34495e;
  transform: scale(1.05);
}

.delete-btn {
  background-color: #e74c3c; /* 붉은색 */
  color: #fff;
}

.delete-btn:hover {
  background-color: #c0392b; /* 더 어두운 붉은색 */
  transform: scale(1.05);
}

.notice-content {
  font-size: 1.1rem;
  color: #34495e;
  margin-bottom: 1rem;
}

.notice-meta {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
  font-size: 0.9rem;
  color: #7f8c8d;
  margin-bottom: 2rem;
}

.golist-btn {
  display: inline-block;
  background-color: #3498db;
  color: #fff;
  padding: 0.25rem 0.5rem;
  text-decoration: none;
  border-radius: 3px;
  font-size: 1rem;
  transition: background-color 0.3s;
}

.golist-btn:hover {
  background-color: #34495e;
  transform: scale(1.05);
}
</style>
