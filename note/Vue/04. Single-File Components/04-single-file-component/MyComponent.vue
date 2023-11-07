<!-- vbase-3-setup -->
<template>
  <div class="greeting">{{ msg }}</div>
</template>

<script setup>
import { ref } from 'vue'

const msg = ref('hello world!')
</script>

<!-- scss문법을 사용하지 않으므로 지울 것 -->
<style scoped>
.greeting {
  color: crimson;
}
</style>