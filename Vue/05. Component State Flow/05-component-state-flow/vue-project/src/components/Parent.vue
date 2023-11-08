<template>
  <div>
    <!-- 케밥케이스로 보냄(html속성 값 => '-'사용) -->
    <ParentChild
      my-msg="ssafy" 
      :dynamic-props="name"
      @some-event="someCallback"
      @emit-args="getNumbers"
      @update-name="updateName"
    />
  </div>
</template>

<script setup>
  import ParentChild from '@/components/ParentChild.vue'
  import { ref } from 'vue'

  const name = ref('Alice')

  const someCallback = () => {
    console.log('ParentChild가 발신한 emit 이벤트를 수신')
  }

  const getNumbers = (...args) => {
    console.log(args)
  }

  const updateName = () => {
    name.value = 'Bella'
  }
</script>

<style scoped>

</style>