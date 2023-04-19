// Function to check if a cookie exists
function checkCookie(cookieName) {
    return document.cookie.indexOf(cookieName) !== -1;
}

// Function to set a cookie with a given name, value, and expiration date
function setCookie(cookieName, cookieValue, daysToExpire) {
    const date = new Date();
    date.setTime(date.getTime() + (daysToExpire * 24 * 60 * 60 * 1000));
    const expires = "expires=" + date.toUTCString();
    document.cookie = cookieName + "=" + cookieValue + ";" + expires + ";path=/";
}

// Function to increment the value of a cookie by 1
function incrementCookie(cookieName) {
    const cookieValue = parseInt(getCookie(cookieName));
    setCookie(cookieName, cookieValue + 1, 365);
}

// Function to get the value of a cookie by its name
function getCookie(cookieName) {
    const name = cookieName + "=";
    const decodedCookie = decodeURIComponent(document.cookie);
    const cookieArray = decodedCookie.split(';');
    for (let i = 0; i < cookieArray.length; i++) {
        let cookie = cookieArray[i];
        while (cookie.charAt(0) === ' ') {
            cookie = cookie.substring(1);
        }
        if (cookie.indexOf(name) === 0) {
            return cookie.substring(name.length, cookie.length);
        }
    }
    return "";
}

// Check if the "isGuest" cookie exists
$(document).ready(function() {
    if (!checkCookie("isGuest")) {
        // If it does not exist, generate the cookie with a value of 1
        setCookie("isGuest", 1, 365);
    }
});
