<template>
  <div class="container">
    <div class="row justify-content-md-center">
      <span class="fs-3"> Выберите уровень сложности: </span>
      <div class="col md-auto p-2">
        <button class="btn btn-success" @click="setDiffLevel('easy')">
          Легкий
        </button>
      </div>
      <div class="col md-auto p-2">
        <button class="btn btn-warning" @click="setDiffLevel('medium')">
          Средний
        </button>
      </div>
      <div class="col md-auto p-2">
        <button class="btn btn-danger" @click="setDiffLevel('hard')">
          Сложный
        </button>
      </div>
    </div>

    <div class="row justify-content-md-center">
      <div class="col-md-auto p-2">
        <div class="d-grid gap-2">
          <button class="btn btn-success fs-3" v-if="diff_level" @click="load_questions()">
            Начать
          </button>
        </div>
      </div>
    </div>

    <div class="row justify-content-md-center p-3" v-if="diff_level">

    </div>
  </div>
</template>


<script>
const url = "http://localhost:8080/question/";

export default {
  data() {
    return {
      diff_level: null,
      start: true,
      questions: [],
      current_question: {}
    }
  },
  methods: {
    setDiffLevel(level) {
      this.diff_level = level;
      console.log('Уровень сложности установлен: ' + this.diff_level);
    },
    async load_questions() {
      this.start = false;

      let jsonArray = await fetch(url + this.diff_level, {
        method: "GET",
      })
        .then(response => response.json())

      this.questions =  jsonArray;
      let length = this.questions.length;

      console.log('array: ')
      for (let i = 0; i < length; i++) {
        console.log("obj: " + this.questions[i].text);
      }

      console.log("length: " + this.questions.length)
      console.log("questions: " + JSON.stringify(this.questions))
    }
  }

}
</script>