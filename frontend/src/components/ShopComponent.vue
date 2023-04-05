<template>
  <div class="card-group">
    <div class="card">
      <div class="card-body first_back">
        <button
                class="btn btn-success"
                @click="buyMethod('first_back', 5)"
        >Купить(5 монет)</button>
      </div>
    </div>
    <div class="card">
      <div class="card-body second_back">
        <button
                class="btn btn-success"
                @click="buyMethod('second_back', 10)"
        >Купить(5 монет)</button>
      </div>
    </div>
    <div class="card">
      <div class="card-body third_back">
        <button
                class="btn btn-success"
                @click="buyMethod('third_back', 15)"
        >Купить(5 монет)</button>
      </div>
    </div>
  </div>
</template>

<script>
const urlLogin = "http://localhost:8080/user/";

export default {
  data() {
    return {
      user: {},
      //строка с названиями фонов
      backgrounds: "",
      //уведоимление об успешности покупки
      notification: ""
    }
  },
  async created() {
    this.user = await fetch(urlLogin + 0, {
      method: "GET"
    })
      .then(response => response.json());

    this.backgrounds = this.user.purchased_backgrounds;
  },
  methods: {
    async buyMethod(background, price) {
      if (this.backgrounds.includes(background)) {
        this.notification = "У вас уже есть этот фон!";
      } else {
        this.user.coins -= price;
        this.user.purchased_backgrounds += ", " + background;

        await fetch(urlLogin + 0, {
          method: "PUT",
          body: JSON.stringify(this.user),
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        }).then(response => console.log("RESPONSE: " + JSON.stringify(response)))
          .catch(error => console.log("ERROR RESPONSE: " + JSON.stringify(error)))
      }

    }
  }
}
</script>

<style>
.first_back {
    background: #6a11cb;
}

.second_back {
    background: #815850;
}

.third_back {
    background: #ffffff;
}
</style>