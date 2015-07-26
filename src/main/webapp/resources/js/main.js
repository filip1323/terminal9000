myApp = angular.module('EditorAspect', ['ngDragDrop']);
myApp.controller('EditCtrl', ['$http','$compile', '$scope', function ($http, $compile, $scope) {
        this.sendJSONData = function (header,data) {
            var res = $http.post('/gastronomy-terminal/rest/' + header, JSON.stringify(data, null, 4));
                res.success(function (incData, status, headers, config) {
                console.log("SUCCES");
                console.log(incData);
                console.log(status);
                console.log(headers);
                console.log(config);
                $("#room").html(incData);
            });
            res.error(function (incData, status, headers, config) {
                console.log("FAILURE");
                console.log(incData);
                console.log(status);
                console.log(headers);
                console.log(config);
                $("#room").html(incData);
            });
        }
        this.saveTables = function () {
            var elements = document.getElementsByClassName("table");
            var dataToSend = [];
            for (var i = 0; i < elements.length; i++) {
                var element = $(elements[i]);
                var tableJSON = {id: i, xCoord: parseInt(element.offset().left), yCoord: parseInt(element.offset().top), width: parseInt(element.css("width")), height: parseInt(element.css("height"))};
                dataToSend.push(tableJSON);
            }
           this.sendJSONData("multi", dataToSend);
        }

        this.addTable = function () {
            var element = "<div class='table' data-drag='true' jqyoui-draggable>lolcontent " + document.getElementsByClassName("table").length + "</div>";
            var newElement = ($compile(element)($scope));
            $('#editor').append(newElement);
            applyGridControl($('#editor').children().last()[0]);
            //$scope.$apply();
        };
        this.changeElementParent = function (element, newParent) {
            var elementHtml = element[0].outerHTML;
            var newElement = ($compile(elementHtml)($scope));
            newParent.append(newElement);

            //applyGridControl(newElement);
            //$scope.$apply();
        };
    }]).run(function ($rootScope, $compile, $rootElement) {
    applyGridControl($(".table"));
});
function applyGridControl(element) {
    element.click(function () {

        var gridStep = 20;

        var leftOffset = parseInt($(this).offset().left);
        var topOffset = parseInt($(this).offset().top);

        var leftSuffix = (leftOffset % gridStep < gridStep / 2) ? -leftOffset % gridStep : gridStep - leftOffset % gridStep;
        var topSuffix = (topOffset % gridStep < gridStep / 2) ? -topOffset % gridStep : gridStep - topOffset % gridStep;

        $(this).offset({top: topOffset + topSuffix, left: leftOffset + leftSuffix});


    });
}
function refreshGrid(element) {
    var gridStep = 20;

    var leftOffset = parseInt(element.offset().left);
    var topOffset = parseInt(element.offset().top);

    var leftSuffix = (leftOffset % gridStep < gridStep / 2) ? -leftOffset % gridStep : gridStep - leftOffset % gridStep;
    var topSuffix = (topOffset % gridStep < gridStep / 2) ? -topOffset % gridStep : gridStep - topOffset % gridStep;

    element.offset({top: topOffset + topSuffix, left: leftOffset + leftSuffix});

}
