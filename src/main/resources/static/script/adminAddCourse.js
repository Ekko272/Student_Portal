//angular前端框架,‘addCalssApp’匹配上方div,将其变成app
var app = angular.module('addClassApp',[]);
app.controller('addClassCont',function($http,$scope,$window,$location){
    //js ng-model variable，同时赋值
    $scope.id='';
    $scope.maxStudent='';
    $scope.enrollment='';
    $scope.location='';
    $scope.startDate='';
    $scope.showEnable='';
    $scope.description='';
    $scope.endDate='';
    $scope.timeInterval='';
    $scope.name='';
    $scope.price='';
    $scope.mode='';
    $scope.weekDays='';
    $scope.instructor='';
    $scope.numOfWeeks='';

    //js object json
    $scope.newClass ={id:'', maxStudent:'',enrollment:'',location:'',startDate:'',showEnable:'',description:'',endDate:'',timeInterval:'',name:'',
        price:'',mode:'',weekDays:'',instructor:'',numOfWeeks:''};

    //ng-click响应函数给newClass properties赋值
    $scope.addNewClass=function (){
        $scope.newClass.id = $scope.id;
        $scope.newClass.maxStudent = $scope.maxStudent;
        $scope.newClass.enrollment = $scope.enrollment;
        $scope.newClass.location = $scope.location;
        $scope.newClass.startDate = $scope.startDate;
        $scope.newClass.showEnable = $scope.showEnable;
        $scope.newClass.description = $scope.description;
        $scope.newClass.endDate = $scope.endDate;
        $scope.newClass.timeInterval = $scope.timeInterval;
        $scope.newClass.name = $scope.name;
        $scope.newClass.price = $scope.price;
        $scope.newClass.mode = $scope.mode;
        $scope.newClass.weekDays = $scope.weekDays;
        $scope.newClass.instructor = $scope.instructor;
        $scope.newClass.numOfWeeks = $scope.numOfWeeks;


        //restful api， post，响应地址为/api/addClass，响应参数为$scope.newClass
        $http.post('/api/addClass',$scope.newClass)
            .then(function (respond){//得到的响应函数
                alert(respond.data);
            }).catch(function (error){
            alert(error);
        })
    }

})