<template>
  <div class="home">
    <main class="main-content">
      <hero-section />
      <featured-ideas :ideas="featuredIdeas" />
      <idea-list-main :ideas="ideas" />
      <trending-tags :tags="trendingTags" />
    </main>
  </div>
</template>

<script>
import axios from 'axios';
import HeroSection from '@/components/HeroSection.vue';
import FeaturedIdeas from '@/components/FeaturedIdeasMain.vue';
import IdeaListMain from '@/components/IdeaListMain.vue';
import TrendingTags from '@/components/TrendingTagsMain.vue';

export default {
  name: 'Home',
  components: {
    HeroSection,
    FeaturedIdeas,
    IdeaListMain,
    TrendingTags,
  },
  data() {
    return {
      featuredIdeas: [], // Featured ideas 데이터를 저장할 배열
      ideas: [], // Idea list 데이터를 저장할 배열
      trendingTags: [], // Trending tags 데이터를 저장할 배열
    };
  },
  async mounted() {
    try {
      const response = await axios.get('/api/main/list'); // API 요청
      const data = response.data; // 응답 데이터

      // 응답 데이터에서 필요한 정보를 추출하여 Vue 인스턴스의 데이터에 할당합니다
      this.featuredIdeas = data.featuredIdeas || [];
      this.ideas = data.ideas || [];
      this.trendingTags = data.trendingTags || [];
      
    } catch (error) {
      console.error('데이터를 가져오는 중 오류가 발생했습니다:', error); // 에러 처리
    }
  },
};
</script>

<style scoped>
.home {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh; /* 세로 가운데 정렬을 위해 */
  font-family: 'Arial', sans-serif;
  color: #333;
  background-color: #f5f5f5;
}

.main-content {
  max-width: 1200px;
  margin: 0 auto;
  padding: 2rem;
  background-color: white; /* 배경색이 필요하다면 추가 */
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); /* 시각적으로 중앙에 놓이도록 그림자 추가 */
}


</style>
