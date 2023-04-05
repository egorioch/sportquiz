<template>
  <div class="container">
    <div v-for="que in questions" :key="que.id">
      <div class="row">
        <p class="fs-3 p-2">Вопрос: </p>
        <span class="border border-primary">que.text</span>
      </div>
    </div>
    <div class="row justify-content-md-center">
      <input v-model="this.userAnswer" placeholder="Ваш ответ">
      <button class="btn btn-primary p-3">Отправить</button>
    </div>
  </div>
</template>

<script>
export default {
  props: ['questions'],
  data() {
    return {
      userAnswer: null
    }
  }
}
</script>