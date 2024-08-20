<template>
  <section class="featured-ideas">
    <h3>Featured Ideas</h3>
    <div class="idea-grid">
      <div v-for="idea in ideas" :key="idea.id" class="idea-card">
        <h4>{{ idea.title }}</h4>
        <p>{{ idea.description }}</p>
        <div class="idea-meta">
          <span>By {{ idea.author }}</span>
          <span>{{ idea.likes }} Likes</span>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'FeaturedIdeas',
  props: {
    ideas: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style scoped>
.featured-ideas {
  margin-bottom: 2rem;
  text-align: center; /* 제목 중앙 정렬 */
}

h3 {
  font-size: 1.5rem;
  margin-bottom: 1rem;
}

.idea-grid {
  display: flex; /* Flexbox 사용 */
  flex-wrap: wrap; /* 아이템들이 넘칠 경우 줄바꿈 */
  justify-content: center; /* 가로 방향 중앙 정렬 */
  gap: 1.5rem; /* 아이템 간격 */
}

.idea-card {
  background-color: #fff;
  border-radius: 8px;
  padding: 1.5rem;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
  transition: transform 0.3s ease;
  flex: 1 1 calc(33.333% - 1.5rem); /* 가로 폭을 화면의 1/3으로 설정 */
  max-width: calc(33.333% - 1.5rem); /* 가로 폭의 최대값 설정 */
  min-width: 250px; /* 최소 너비 설정 */
}

.idea-card:hover {
  transform: translateY(-5px);
}

.idea-card h4 {
  font-size: 1.5rem;
  margin-bottom: 1rem;
}

.idea-meta {
  display: flex;
  justify-content: space-between;
  font-size: 0.9rem;
  color: #666;
  margin-top: 1rem;
}
</style>
