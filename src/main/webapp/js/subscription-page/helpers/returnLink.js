const returnLink = document.querySelector('.return-link')

returnLink.addEventListener('click', () => {
  window.history.back()
})