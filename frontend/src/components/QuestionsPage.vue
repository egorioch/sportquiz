<template>
  <div class="container">

    <div class="row">
      <div class="row">
        <i class="col bi bi-coin"></i>
        <span class="col">{{ this.currentCoins }}</span>
      </div>

      <span class="border border-danger" v-if="this.incorrectAnswer">Ответ неверный!</span>
      <div class="fs-3 p-2 justify-content-md-center">
        <div class="border border-primary">
          <div class="p-2">
            Вопрос: <span class="">{{ this.currentQuestion.text }}</span>
          </div>
        </div>
      </div>

    </div>

    <div class="row justify-content-md-center">
      <input class="p-2 m-2" v-model="this.userAnswer" placeholder="Ваш ответ">
      <button class="btn btn-primary p-3" @click="checkAnswer(this.currentQuestion.answer)">Отправить</button>
    </div>
  </div>
</template>

<script>

export default {
  props: ['questions', 'coins'],
  data() {
    return {
      //текущий вопрос по индексу
      currentQuestion: this.questions[0],
      //ответ пользователя
      userAnswer: "",
      currentCoins: this.coins,
      //текущий индекс вопроса(инкрементируется, если ответ правильный)
      questionIndex: 0,
      //маячок, показывающий неверный ответ
      incorrectAnswer: false,

    }
  },

  methods: {
    async checkAnswer(correctAnswer) {

      if (this.userAnswer === correctAnswer) {
        this.currentCoins= this.currentCoins + 1;

        //меняем данные родительского компонента:
        this.$emit("coins", this.currentCoins)

        //если индекс достиг конца массива - остановка
        if (this.questionIndex === this.questions.length - 1) {
          this.$emit('start', true)
        } else {
          this.questionIndex++;
        }

        this.incorrectAnswer = false;
      } else {
        this.incorrectAnswer = true;
      }

      this.userAnswer = "";
    },

  },
  watch: {
    questionIndex() {
      this.currentQuestion = this.questions[this.questionIndex];
    }
  }
}
</script>