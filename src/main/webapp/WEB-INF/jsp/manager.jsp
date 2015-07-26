<html ng-app="ManagerAspect">
    <head>
        <title>Service</title>
        <link rel="Shortcut icon" href="resources/favicon.ico" />
        <link rel="Stylesheet" type="text/css" href="resources/css/style.css" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
        <script src="resources/js/angular.js" type="text/javascript"></script>
        <script src="resources/js/jquery-1.11.3.js" type="text/javascript"></script>
        <script src="resources/js/angular-dragdrop.js" type="text/javascript"></script>
        <script src="resources/js/main.js"></script>
        <script src="resources/js/manager.js"></script>
    </head>

    <body id="manager">
        <div id="view" ng-controller="ManagerCtrl as editor">
            <div ng-repeat="table in editor.tables" class="table" style="position: absolute; width: {{table.width}}px;height: {{table.height}}px;top: {{table.yCoord}}px;left: {{table.xCoord}}px;">{{table.id}}</div>
        </div>

        <div id="editor">
        </div>
    </body>

</html>