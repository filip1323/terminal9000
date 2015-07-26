myApp = angular.module('ManagerAspect', ['ngDragDrop']);
myApp.controller('ManagerCtrl', ['$http','$compile', '$scope', function ($http, $compile, $scope) {
        var ctrl = this;
        this.tables = [{id:0},{id:3}];
        this.sendJSONData = function (header,data, onSucces) {
            var res = $http.post('/gastronomy-terminal/rest/' + header, JSON.stringify(data, null, 4));
                res.success(function (incData, status, headers, config) {
                console.log("SUCCES");
                console.log(incData);
                console.log(status);
                console.log(headers);
                console.log(config);
                $("#room").html(incData);
                onSucces(incData);
            });
            res.error(function (incData, status, headers, config) {
                console.log("FAILURE");
                console.log(incData);
                $("#room").html(incData);
            });
        }
        this.sendJSONData("gettables",[], function(newTables){
            ctrl.tables = newTables;
        });

    }]).run(function ($rootScope, $compile, $rootElement) {

});