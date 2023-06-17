
const headerDOM =document.getElementById("header-main");
const searchDOM = document.getElementById("header-search-one")
const searchItem = document.getElementById("wrapper_search")
window.onscroll = function() {myFunction()};

console.log("hhh",searchItem )
function myFunction() {
    if (document.documentElement.scrollTop > 50) {
        headerDOM.style.backgroundColor = "#1b1b1b";
    } else {
        headerDOM.addEventListener("mouseenter", handleMouseenter)
        headerDOM.addEventListener("mouseleave", handleMouseLeave)
        headerDOM.style.background = "rgba(0, 0, 0 ,0)"
    }
}

function  handleMouseenter () {
    headerDOM.style.backgroundColor = "#1b1b1b";
}

function handleMouseLeave () {
    headerDOM.style.background = "rgba(0, 0, 0 ,0)"
}

const handleSearch = () => {
    searchItem.style.display = "block";
}

const handleMouseLeave1 = () => {
    searchItem.style.display = "none";
}

searchDOM.addEventListener("click", handleSearch)


searchItem.addEventListener("mouseleave", handleMouseLeave1)
