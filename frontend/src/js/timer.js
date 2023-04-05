timer = setInterval(function () {
  let seconds = timeMinut%60 // Получаем секунды
  let minutes = timeMinut/60%60 // Получаем минуты
  let hour = timeMinut/60/60%60 // Получаем часы
  // Условие если время закончилось то...
  if (timeMinut <= 0) {
    // Таймер удаляется
    clearInterval(timer);
    // Выводит сообщение что время закончилось
    alert("Время закончилось");
  } else { // Иначе
    // Создаём строку с выводом времени
    let strTimer = `${Math.trunc(hour)}:${Math.trunc(minuts)}:${seconds}`;
    // Выводим строку в блок для показа таймера
    timerShow.innerHTML = strTimer;
  }
  --timeMinut; // Уменьшаем таймер
}, 1000)