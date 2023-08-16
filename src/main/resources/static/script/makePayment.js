
    function sendDataToBackend() {
    var courses = document.querySelectorAll('tr[data-course-id]');
    var paymentData = [];

    courses.forEach(function(course) {
    var courseId = course.getAttribute('data-course-id');
    var coursePrice = course.getAttribute('data-course-price');
    var inputField = course.querySelector('input[data-remarks-for="' + courseId + '"]');
    var userRemarks = inputField.value;
    var courseData = {
    id: generateOrderId(),
    fee: coursePrice,
    enterDate:'2023-01-01',
    courseId: courseId,
    paymentDate:'',
    approved:0,
    note: userRemarks,
    studentId:0
};

    paymentData.push(courseData);
});

    fetch('/api/makePayment', {
    method: 'POST',
    headers: {
    'Content-Type': 'application/json'
},
    body: JSON.stringify(paymentData)
}).then(function(response) {
    if (response.ok) {
    var successMessageElement = document.getElementById('successMessage');
    successMessageElement.style.display = 'block';
} else {
    var failMessageElement = document.getElementById('failMessage');
    failMessageElement.style.display = 'block';
}
}).catch(function(error) {
    console.error('Error occurred while sending payment data:', error);
});
}

    function generateOrderId() {
    const characters = '0123456789';
    const orderIdLength = 6;
    let orderId = '';
    function isCharacterPresent(char) {
    return orderId.indexOf(char) !== -1;
}
    while (orderId.length < orderIdLength) {
    const randomIndex = Math.floor(Math.random() * characters.length);
    const randomCharacter = characters[randomIndex];
    if (!isCharacterPresent(randomCharacter)) {
    orderId += randomCharacter;
}
}
    return orderId;
}
