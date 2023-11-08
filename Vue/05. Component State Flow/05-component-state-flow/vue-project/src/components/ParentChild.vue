<template>
  <div>
    <p>{{ myMsg }}</p>
    <p>{{ dynamicProps }}</p>
    <ParentGrandChild 
      :my-msg="myMsg" 
      @update-name="updateName"
    />
    <button @click="$emit('someEvent')">클릭</button>
    <button @click="buttonClick">클릭</button>
    <button @click="emitArgs">추가 인자 전달</button>
  </div>
</template>

<script setup>
  import ParentGrandChild from '@/components/ParentGrandChild.vue'

  // props 선언
  // 1. 문자열 배열 선언 방식
  // 카멜 케이스 사용(JavaScript)
  // defineProps(['myMsg'])

  // 2. 객체 선언 방식(권장)
  // defineProps({
  //   // 키: prop데이터 이름, value: 데이터 타입
  //   myMsg: String,

  //   // type, required사용하는 이유 => 유효성 검사
  //   // myMsg: {
  //   //   type: String,
  //   //   required: true,
  //   // }
  // })

  // props 데이터를 script에서 사용하기
  // const props = defineProps({
  //   myMsg: String,
  //   dynamicProps: String,
  // })
  // console.log(props)
  // console.log(props.myMsg)

  // 3. 다양한 객체 선언 방식
  defineProps({
    myMsg: {
      type: String,
      required: true,
      // validator(value) {
      //   return ['success', 'warning', 'danger'].includes(value)
      // }
      validator(value) {
        const validValues = ['success', 'warning', 'danger']
        if (!validValues.includes(value)) {
          console.error('에러발생!')
          return false
        }
        return true
      }
    },
    dynamicProps: String,
  })


  // emit 선언 방식
  const emit = defineEmits(['someEvent', 'emitArgs', 'updateName']) // 배열 방식 => 객체 방식도 지원한다.

  const buttonClick = () => {
    emit('someEvent')
  }

  const emitArgs = () => {
    emit('emitArgs', 1, 2, 3)
  }

  const updateName = () => {
    emit('updateName')
  }
</script>

<style scoped>

</style>