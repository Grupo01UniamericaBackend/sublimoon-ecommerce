let signCard = document.querySelector('.sign-card');
let signUpButton = document.querySelector('.sign-up-button');
let signInButton = document.querySelector('.sign-in-button');

signUpButton.addEventListener('click', flipTheSignCard);
signInButton.addEventListener('click', flipTheSignCard);

function flipTheSignCard() {
    signCard.classList.toggle('is-flipped');
};

alert("Teste");

const requestObjParams = {
    grant_type: 'password',
    client_id: 'sublimoon',
    username: 'gabrielruizmb',
    password: 'user',
    client_secret: '2jhu6nTDQbZncPRsqqzX4iyOZpul1jb0'
};

const requestOptions = {
    method: 'POST',
    headers:{'Content-Type':'application/x-www-form-urlencoded'},
    body: 'grant_type=password&client_id=sublimoon&username=gabrielruizmb&password=user&client_secret=2jhu6nTDQbZncPRsqqzX4iyOZpul1jb0'
};

const request = new Request(
    'http://192.168.56.101:8080/realms/development/protocol/openid-connect/token',
    requestOptions
);

async function login() {
    const response = await fetch(request);
    const responseJson = response.json();
    
    console.log(responseJson);
};

login();
