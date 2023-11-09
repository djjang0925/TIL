<template>
  <div>
    <h1>UserView</h1>
    <h2>{{ $route.params.id }}번 유저의 페이지입니다.</h2>
    <h2>{{ userId }}번 유저의 페이지입니다.</h2>
    <button @click="goHome">지브로!</button>
    <button @click="go100thUser">100번 유저 페이지로!</button>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import  { useRoute, useRouter, onBeforeRouteLeave, onBeforeRouteUpdate } from 'vue-router'

const route = useRoute()
const userId = ref(route.params.id)

// 프로그래밍 방식 네비게이션
const router = useRouter()

const goHome = () => {
  // router.push({ name: 'home' })

  // 위치만 바꾸고 이전 페이지 히스토리 스택에 푸쉬하지 않음(뒤로가기가 안됨!)
  // 로그인 후 메인 페이지로 이동하는 경우와 같이 사용됨
  router.replace({ name: 'home' })
}

// In-component Guard
// 1. onBeforeRouteLeave
onBeforeRouteLeave((to, from) => {
  const answer = window.confirm('진짜 감?')
  
  if (answer === false) {
    return false
  }
})

// 2. onBeforeRouteUpdate
const go100thUser = function() {
  router.push({ name: 'user', params: { id: 100 } })
}

onBeforeRouteUpdate((to, from) => {
  userId.value = to.params.id
})
</script>

<style scoped>

</style>