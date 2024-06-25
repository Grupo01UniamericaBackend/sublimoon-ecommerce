// let mainContent = document.getElementById("main-content");

// function createCarouselItems(carouselItems) {
//     carouselItems.forEach(element => {
//         console.log(element);
//         let carouselItem = document.createElement("div");
//         carouselItem.innerHTML = `
//             <a href="${element.link}" target="blank">
//                 <img class="carousel__item" src="${element.image}" >
//             </a>
//         `;
//         mainContent.appendChild(carouselItem);
//     });
// }

// async function loadCarouselItems() {
//     const response = await fetch("http://localhost:8081/carousel");
//     const carouselItems = await response.json();
//     createCarouselItems(carouselItems);
// }

// loadCarouselItems();

async function loadItems() {
    const response = await fetch("http://localhost:8081/api/item");
    console.log(response);
}

loadItems();