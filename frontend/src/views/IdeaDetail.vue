<template>
  <section class="idea-detail">
    <div class="content-container">
      <h2>{{ idea.TITLE }}</h2>
      <div class="meta-info">
        <div class="author-info">
          <i class="fas fa-user-circle"></i>
          <span>{{ idea.WRITER }}</span>
        </div>
        <div class="date-info">
          <i class="fas fa-calendar-alt"></i>
          <span>{{ formatDate(idea.WRITERDATE) }}</span>
        </div>
      </div>
      <div class="idea-content">
        <pre>{{ idea.CONTENT }}</pre>
      </div>
      <div class="interaction-stats">
        <div class="stat-item">
          <span>LIKES {{ idea.LIKE_COUNT }}</span>
          <button class="btn-icon" :class="{ active: userReaction === 'LIKE' }" @click="toggleLike">
            <i class="bi bi-hand-thumbs-up"></i>
          </button>
        </div>
        <div class="stat-item">
          <span>DISLIKES {{ idea.DISLIKE_COUNT }}</span>
          <button class="btn-icon" :class="{ active: userReaction === 'DISLIKE' }" @click="toggleDislike">
            <i class="bi bi-hand-thumbs-down"></i>
          </button>
        </div>
        <div class="stat-item">
          <i class="fas fa-eye"></i>
          <span>VIEW {{ idea.VIEW_COUNT }}</span>
        </div>
      </div>
      <div class="idea-tags">
        <span v-for="tag in parseTags(idea.TAGS)" :key="tag" class="tag">{{ tag }}</span>
      </div>
    </div>
    <div class="action-buttons">
      <router-link to="/ideaList" class="btn btn-secondary">목록</router-link>
      <div v-if="canEditOrDelete" class="edit-delete-buttons">
        <button class="btn btn-primary" @click="goToEditPage">수정</button>
        <button class="btn btn-danger" @click="deleteIdea">삭제</button>
      </div>
    </div>
  </section>
</template>

<script>
import axios from 'axios';
import { computed, ref, onMounted } from 'vue';
import { useStore } from 'vuex';
import { useRoute, useRouter } from 'vue-router';

export default {
  name: 'IdeaDetail',
  setup() {
    const store = useStore();
    const route = useRoute();
    const router = useRouter();

    const user = computed(() => store.getters.user);
    const role = computed(() => store.getters.role);

    const idea = ref({});
    const userReaction = ref(null);

    const fetchIdeaDetail = async () => {
      const ideaId = route.params.id;
      const userId = user.value?.id;
      try {
        const response = await axios.get(`/api/idea/detail/${ideaId}`, {
          headers: {
            'User-Id': userId
          }
        });
        idea.value = response.data;
        fetchUserReaction();
      } catch (error) {
        console.error('아이디어 세부정보를 가져오는 중 오류 발생:', error);
      }
    };

    const fetchUserReaction = async () => {
      const ideaId = route.params.id;
      const userId = user.value?.id;
      if (userId) {
        try {
          const response = await axios.get(`/api/idea/reaction/count/${ideaId}`, {
            headers: {
              'User-Id': userId
            }
          });
          userReaction.value = response.data.reactionType;
        } catch (error) {
          console.error('사용자 반응을 가져오는 중 오류 발생:', error);
        }
      }
    };

    const formatDate = (dateString) => {
      const options = { year: 'numeric', month: 'long', day: 'numeric' };
      return new Date(dateString).toLocaleDateString(undefined, options);
    };

    const goToEditPage = () => {
      router.push({ name: 'IdeaEdit', params: { id: route.params.id } });
    };

    const deleteIdea = async () => {
      const ideaId = route.params.id;
      if (confirm('정말로 이 아이디어를 삭제하시겠습니까?')) {
        try {
          await axios.delete(`/api/idea/delete/${ideaId}`);
          alert('아이디어가 삭제되었습니다.');
          router.push({ name: 'IdeaList' });
        } catch (error) {
          console.error('아이디어를 삭제하는 중 오류 발생:', error);
        }
      }
    };

    const parseTags = (tagsString) => {
      return tagsString ? tagsString.split(',').map(tag => tag.trim()) : [];
    };

    const toggleLike = async () => {
      const ideaId = route.params.id;
      const userId = user.value?.id;
      try {
        if (userReaction.value === 'LIKE') {
          await axios.delete(`/api/idea/reaction/${ideaId}`, {
            data: {
              userId,
              reactionType: 'LIKE'
            }
          });
          userReaction.value = null;
        } else {
          await axios.post(`/api/idea/reaction/${ideaId}`, {
            userId,
            reactionType: 'LIKE'
          });
          userReaction.value = 'LIKE';
        }
        fetchIdeaDetail(); // 새로고침하여 반영
      } catch (error) {
        console.error('아이디어를 좋아요 하는 중 오류 발생:', error);
      }
    };

    const toggleDislike = async () => {
      const ideaId = route.params.id;
      const userId = user.value?.id;
      try {
        if (userReaction.value === 'DISLIKE') {
          await axios.delete(`/api/idea/reaction/${ideaId}`, {
            data: {
              userId,
              reactionType: 'DISLIKE'
            }
          });
          userReaction.value = null;
        } else {
          await axios.post(`/api/idea/reaction/${ideaId}`, {
            userId,
            reactionType: 'DISLIKE'
          });
          userReaction.value = 'DISLIKE';
        }
        fetchIdeaDetail(); // 새로고침하여 반영
      } catch (error) {
        console.error('아이디어를 싫어요 하는 중 오류 발생:', error);
      }
    };

    const canEditOrDelete = computed(() => {
      if (!user.value || !user.value.id || !role.value) {
        return false;
      }
      return idea.value.WRITER === user.value.id || role.value === 'ADMIN';
    });

    onMounted(() => {
      fetchIdeaDetail(); // 컴포넌트가 마운트될 때 아이디어 세부정보를 가져옴
    });

    return {
      idea,
      userReaction,
      formatDate,
      goToEditPage,
      deleteIdea,
      parseTags,
      toggleLike,
      toggleDislike,
      canEditOrDelete
    };
  }
};
</script>

<style scoped>
.idea-detail {
  max-width: 800px;
  margin: 2rem auto;
  background-color: #ffffff;
  border-radius: 12px;
  box-shadow: 0 5px 20px rgba(0, 0, 0, 0.1);
  overflow: hidden;
}

.content-container {
  padding: 2rem;
}

h2 {
  font-size: 2.2rem;
  color: #2c3e50;
  margin-bottom: 1rem;
  font-weight: 700;
}

.meta-info {
  display: flex;
  justify-content: space-between;
  margin-bottom: 1.5rem;
  font-size: 0.9rem;
  color: #7f8c8d;
}

.author-info,
.date-info {
  display: flex;
  align-items: center;
}

.author-info i,
.date-info i {
  margin-right: 0.5rem;
  font-size: 1.2rem;
}

.idea-content {
  font-size: 1.1rem;
  color: #34495e;
  line-height: 1.6;
  margin-bottom: 2rem;
}

.idea-content pre {
  white-space: pre-wrap;
  font-weight: 700;
  color: #34495e;
}

.interaction-stats {
  display: flex;
  justify-content: flex-start;
  gap: 2rem;
  margin-bottom: 1.5rem;
}

.stat-item {
  display: flex;
  align-items: center;
  font-size: 1rem;
  color: #7f8c8d;
}

.stat-item i {
  margin-right: 0.5rem;
  font-size: 1.2rem;
}

.idea-tags {
  display: flex;
  flex-wrap: wrap;
  gap: 0.5rem;
  margin-bottom: 1.5rem;
}

.tag {
  background-color: #3498db;
  color: #ffffff;
  border-radius: 12px;
  padding: 0.3rem 0.6rem;
  font-size: 0.8rem;
  white-space: nowrap;
  font-weight: 500;
}

.tag:hover {
  background-color: #2980b9;
}

.action-buttons {
  display: flex;
  justify-content: space-between;
  padding: 1rem 2rem;
  background-color: #f8f9fa;
  border-top: 1px solid #e9ecef;
}

.btn {
  padding: 0.6rem 1.2rem;
  border: none;
  border-radius: 5px;
  font-size: 1rem;
  cursor: pointer;
  transition: all 0.3s ease;
  font-weight: 600;
}

.btn-secondary {
  background-color: #6c757d;
  color: #ffffff;
  text-decoration: none;
}

.btn-primary {
  background-color: #007bff;
  color: #ffffff;
}

.btn-danger {
  background-color: #dc3545;
  color: #ffffff;
}

.btn:hover {
  opacity: 0.9;
  transform: translateY(-2px);
}

.edit-delete-buttons {
  display: flex;
  gap: 1rem;
}

.btn-icon {
  display: flex;
  align-items: center;
  background: none;
  border: none;
  font-size: 1rem;
  color: #7f8c8d;
  cursor: pointer;
  transition: color 0.3s ease;
}

.btn-icon:hover {
  color: #007bff;
}

.btn-icon i {
  margin-right: 0.5rem;
  font-size: 1.2rem;
}

.btn-icon.active {
  color: #007bff;
}

.btn-icon.active i {
  color: #007bff;
}

@media (max-width: 600px) {
  .idea-detail {
    margin: 1rem;
  }

  .content-container {
    padding: 1.5rem;
  }

  h2 {
    font-size: 1.8rem;
  }

  .interaction-stats {
    flex-wrap: wrap;
    gap: 1rem;
  }

  .action-buttons {
    flex-direction: column;
    gap: 1rem;
  }

  .btn {
    width: 100%;
  }
}
</style>
