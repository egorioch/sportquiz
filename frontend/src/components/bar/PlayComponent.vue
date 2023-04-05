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
          <div class="row">
            <div class="col justify-center">timer: {{ this.seconds_remaining }} </div>
            <button class="col btn btn-success fs-3" v-if="diff_level && start" @click="load_questions(); timer()">
              Начать
            </button>
          </div>
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
const urlLogin = "http://localhost:8080/user/";

export default {
  components: {QuestionsPage},
  data() {
    return {
      diff_level: null,
      start: true,
      questions: [],
      current_question: {},
      coins: 0,
      time_end: false,
      seconds_remaining: 10
    }
  },
  async created() {
    this.user = await fetch(urlLogin + 0, {
      method: "GET"
    })
      .then(response => response.json());

    this.coins = this.user.coins;
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

    },
    async timer() {
      this.seconds_remaining--;
      if (this.seconds_remaining < 0) {
        alert('Время вышло');
        this.seconds_remaining = 60;
        this.start = true;
        this.user.coins = this.coins;

        await fetch(urlLogin + 0, {
          method: "PUT",
          body: JSON.stringify(this.user),
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        }).then(response => console.log("RESPONSE: " + JSON.stringify(response)))
          .catch(error => console.log("ERROR RESPONSE: " + JSON.stringify(error)))
      } else {
        setTimeout(this.timer, 1000);
      }
    },
    watch: {
      coins() {
        console.log('новые коинсы: ' + this.coins());
      }
    }
  }

}
</script>