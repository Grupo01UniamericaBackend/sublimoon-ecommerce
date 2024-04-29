let signCard = document.querySelector('.sign-card');
let signUpButton = document.querySelector('.sign-up-button');
let signInButton = document.querySelector('.sign-in-button');

signUpButton.addEventListener('click', flipTheSignCard);
signInButton.addEventListener('click', flipTheSignCard);

function flipTheSignCard() {
    signCard.classList.toggle('is-flipped');
};