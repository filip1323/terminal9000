myApp = angular.module('ManagerAspect', ['ngDragDrop']);
myApp.controller('ManagerCtrl', ['$http','$compile', '$scope','$timeout', function ($http, $compile, $scope, $timeout) {
        var ctrl = this;
        this.selectedTable = {};
        this.tables = [];
        this.setAsSelected = function(id){
            //alert(ctrl.selectedTable.id);
            this.sendJSONData("get-table", parseInt(id), function(incData){
                ctrl.selectedTable = incData;
            });
        }
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
        this.sendJSONData("get-tables",[], function(newTables){
            ctrl.tables = newTables;
        });

    }]).run(function ($rootScope, $compile, $rootElement) {

});