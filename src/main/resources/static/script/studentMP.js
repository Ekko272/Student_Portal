var app = angular.module('addCourseStuApp', []);
app.controller('addCourseStuCont', function ($http, $scope) {
    $scope.id = '';
    $scope.searchResult = null;
    $scope.addCourseStu = function () {
        $http.post('/api/addCourseStu', $scope.id)
            .then(function (response) {
                $scope.searchResult = response.data;
            })
            .catch(function (error) {
                console.error(error.data);
            });
    };
});

var modal = document.getElementById("myModal");
var btn = document.getElementById("addCourseBtn");
var span = document.getElementsByClassName("close")[0];
btn.onclick = function() {
    modal.style.display = "block";
}
span.onclick = function() {
    modal.style.display = "none";
}
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
