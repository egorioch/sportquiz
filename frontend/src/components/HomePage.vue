<template>

  <div class="container overflow-hidden p-4">
    <div class="position-absolute"></div>

    <div class="row justify-content-md-center">
      <div class="col-md-auto p-2">
        <div class="d-grid gap-2">
          <router-link to="/play" class="btn btn-warning fs-3">
            Викторина
          </router-link>
        </div>
      </div>
    </div>
    <div class="row justify-content-md-center">
      <div class="col-md-auto p-2">
        <div class="d-grid gap-4">
          <router-link to="/shop" class="btn btn-success fs-4">
            Магазин
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomePage"
}
</script>