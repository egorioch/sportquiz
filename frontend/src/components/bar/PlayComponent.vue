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

    <div class="row justify-content-md-center p-3" v-if="!start">
      <questions-page
        :questions="questions"
        :coins="coins"
      >
      </questions-page>
    </div>
  </div>
</template>


<script>
import QuestionsPage from "@/components/QuestionsPage.vue";

const url = "http://localhost:8080/question/";
const urlLogin = "http://localhost:8080/login/";

export default {
  components: {QuestionsPage},
  data() {
    return {
      diff_level: null,
      start: true,
      questions: [],
      current_question: {},
      coins: 0
    }
  },
  async created() {
    this.coins = await fetch(urlLogin + 0, {
      method: "GET"
    })
      .then(response => response.json());

    console.log('coins: ' + this.coins)
  },
  methods: {
    setDiffLevel(level) {
      this.diff_level = level;
      console.log('Уровень сложности установлен: ' + this.diff_level);
    },
    async load_questions() {


      let jsonArray = await fetch(url + this.diff_level, {
        method: "GET",
      })
        .then(response => response.json())

      this.questions =  jsonArray;
      this.start = false;
      let length = this.questions.length;

      console.log("length: " + length)
      console.log("questions: " + JSON.stringify(this.questions))

    }
  }

}
</script>