const swiper = new Swiper('.swiper', { // Use const to declare a constant variable and single quotes for strings
    effect: 'coverflow',
    grabCursor: true,
    centeredSlides: true,
    coverflowEffect: {
        rotate: 0, // Use consistent indentation and spacing
        stretch: 0,
        depth: 100,
        modifier: 3,
        slideShadows: true
    },
    loop: true,
    pagination: {
        el: '.swiper-pagination',
        clickable: true
    },
    breakpoints: {
        640: {
            slidesPerView: 2
        },
        768: {
            slidesPerView: 1
        },
        1024: {
            slidesPerView: 2
        },
        1560: {
            slidesPerView: 3
        }
    }
}); // Add a semicolon and remove the extra space

// I hope this helps you fix and improve your code. 😊