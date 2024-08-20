<template>
  <section class="trending-tags">
    <h3>Trending Tags</h3>
    <div class="tags-grid">
      <div v-for="tag in tags" :key="tag.id" class="tag-card">
        <h4>{{ tag.title }}</h4>
        <p>{{ tag.description }}</p>
        <div class="tag-meta">
          <span>By {{ tag.author }}</span>
          <span>{{ tag.likes }} Likes</span>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'TrandingTags',
  props: {
    tags: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style scoped>
.trending-tags {
  margin-bottom: 2rem;
  text-align: center; /* 제목과 아이템들 중앙 정렬 */
}

h3 {
  font-size: 1.5rem;
  margin-bottom: 1rem;
}

.tags-grid {
  display: flex; /* Flexbox 사용 */
  flex-wrap: wrap; /* 아이템들이 넘칠 경우 줄바꿈 */
  justify-content: center; /* 가로 방향 중앙 정렬 */
  gap: 1.5rem; /* 아이템 간격 */
}

.tag-card {
  background-color: #fff;
  border-radius: 8px;
  padding: 1.5rem;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
  transition: transform 0.3s ease;
  flex: 1 1 calc(33.333% - 1.5rem); /* 가로 폭을 화면의 1/3으로 설정 */
  max-width: calc(33.333% - 1.5rem); /* 가로 폭의 최대값 설정 */
  min-width: 250px; /* 최소 너비 설정 */
}

.tag-card:hover {
  transform: translateY(-5px);
}

.tag-card h4 {
  font-size: 1.5rem;
  margin-bottom: 1rem;
}

.tag-meta {
  display: flex;
  justify-content: space-between;
  font-size: 0.9rem;
  color: #666;
  margin-top: 1rem;
}
</style>
