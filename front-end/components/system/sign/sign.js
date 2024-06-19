// Beginning of the code responsible for the 3d effect in sign-in/sign-up card.

let signCard = document.querySelector('.sign-card');
let signUpButton = document.querySelector('.sign-up-button');
let signInButton = document.querySelector('.sign-in-button');

signUpButton.addEventListener('click', flipTheSignCard);
signInButton.addEventListener('click', flipTheSignCard);

function flipTheSignCard() {
    signCard.classList.toggle('is-flipped');
};

// End of the code responsible for the 3d effect in sign-in/sign-up card.


let userMail = document.getElementById('mail');
let userPassword = document.getElementById('password');

let signFormEnterButton = document.getElementById('sign-form__enter-button');
signFormEnterButton.addEventListener('click', signIn);

async function signIn() {

    const response = await fetch(
        'http://192.168.56.101:8080/realms/development/protocol/openid-connect/token',
        {
                method: 'POST',
                headers:{'Content-Type':'application/x-www-form-urlencoded'},
                body: new URLSearchParams({
                client_id: 'sublimoon',
                client_secret: '2jhu6nTDQbZncPRsqqzX4iyOZpul1jb0',
                grant_type: 'password',
                username: `${userMail.value}`,
                password: `${userPassword.value}`
             }).toString()
        }
    )
    console.log(response.json());
}

// const requestOptions = {
//     method: 'POST',
//     headers:{'Content-Type':'application/x-www-form-urlencoded'},
//     body: new URLSearchParams({
//         client_id: 'sublimoon',
//         client_secret: '2jhu6nTDQbZncPRsqqzX4iyOZpul1jb0',
//         grant_type: 'password',
//         username: `${userMail.value}`,
//         password: `${userPassword.value}`
//     }).toString()
// };

// const request = new Request(
//     'http://192.168.56.101:8080/realms/development/protocol/openid-connect/token',
//     {
//         method: 'POST',
//         headers:{'Content-Type':'application/x-www-form-urlencoded'},
//         body: new URLSearchParams({
//             client_id: 'sublimoon',
//             client_secret: '2jhu6nTDQbZncPRsqqzX4iyOZpul1jb0',
//             grant_type: 'password',
//             username: `${userMail.value}`,
//             password: `${userPassword.value}`
//         }).toString()
//     }
// );

// async function signIn() {
//     const response = await fetch(request);
//     const responseJson = response.json();
//     console.log(`${userMail.value}`);
//     console.log(`${userPassword.value}`);
//     console.log(responseJson);
// };

// async function signIn() {
//     alert(userMail.value);
//     alert(userPassword.value);
// }