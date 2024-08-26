import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/views/Home.vue';
import LoginForm from '@/views/LoginPage.vue';
import IdeaSubmit from '@/views/IdeaSubmit.vue';
import IdeaList from '@/views/IdeaList.vue';
import IdeaDetail from '@/views/IdeaDetail.vue';
import IdeaEdit from '@/views/IdeaEdit.vue';
import NoticeList from '@/views/NoticeList.vue';
import NoticeDetail from '@/views/NoticeDetail.vue';
import NoticeEdit from '@/views/NoticeEdit.vue';
import NoticeCreate from '@/views/NoticeCreate.vue';
import Register from '@/views/RegisterPage.vue';
import MemberList from '@/views/MemberList.vue';
import Challenge from '@/views/Challenge.vue';
import Profile from '@/views/Profile.vue';
import MyIdea from '@/views/MyIdea.vue';
import MySettings from '@/views/MySettings.vue';

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/loginForm', name: 'LoginForm', component: LoginForm },
  { path: '/ideaSubmit', name: 'IdeaSubmit', component: IdeaSubmit },
  { path: '/ideaList', name: 'IdeaList', component: IdeaList },
  { path: '/ideaDetail/:id', name: 'IdeaDetail', component: IdeaDetail },
  { path: '/ideaEdit/:id', name: 'IdeaEdit', component: IdeaEdit },
  { path: '/noticeList', name: 'NoticeList', component: NoticeList },
  { path: '/noticeDetail/:id', name: 'NoticeDetail', component: NoticeDetail },
  { path: '/noticeEdit/:id', name: 'NoticeEdit', component: NoticeEdit },
  { path: '/noticeCreate', name: 'NoticeCreate', component: NoticeCreate },
  { path: '/register', name: 'Register', component: Register },
  { path: '/memberList', name: 'MemberList', component: MemberList },
  { path: '/challenge', name: 'Challenge', component: Challenge },
  { path: '/profile', name: 'Profile', component: Profile },
  { path: '/myIdea', name: 'MyIdea', component: MyIdea },
  { path: '/mySettings', name: 'MySettings', component: MySettings },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});
export default router;