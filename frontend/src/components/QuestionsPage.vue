<template>
  <div class="container">
    <div v-for="que in questions" :key="que.id">
      <div>{{ que.text }}</div>
    </div>
    <div class="row">
      <div class="row">
        <i class="col bi bi-coin"></i>
        <span class="col">{{ this.coins }}</span>
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
      <button class="btn btn-primary p-3" @click="checkAnswer(this.userAnswer)">Отправить</button>
    </div>
  </div>


</template>

<script>
export default {
  props: ['questions'],
  data() {
    return {
      //текущий вопрос по индексу
      currentQuestion: this.questions[0],
      //ответ пользователя
      userAnswer: "",
      //текущее число монет
      coins: 0,
      //текущий индекс вопроса(инкрементируется, если ответ правильный)
      questionIndex: 0,
      //маячок, показывающий неверный ответ
      incorrectAnswer: false
    }
  },
  methods: {
    checkAnswer(correctAnswer) {
      console.log("currentQUE: " + JSON.stringify(this.currentQuestion))

      console.log("корректный ответ: " + correctAnswer);
      console.log("ответ юзера: " + this.userAnswer)
      if (this.userAnswer === correctAnswer) {
        this.coins = this.coins + 1;
        this.questionIndex++;
        this.incorrectAnswer = false;
      } else {
        this.incorrectAnswer = true;
      }

      this.userAnswer = "";
    }
  },
  watch: {
    questionIndex() {
      this.currentQuestion = this.questions[this.questionIndex];
    }
  }
}
</script>