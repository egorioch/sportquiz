<template>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Главная</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="mynavbar">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/play">Викторина</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/shop">Магазин</a>
                    </li>
                </ul>
                <form class="d-flex">
                    <button class="btn btn-primary" type="button">Личный кабинет</button>
                </form>
            </div>
        </div>
    </nav>

    <router-view></router-view>
</template>

<script>
export default {
  name: "NavbarSide"
}
</script>