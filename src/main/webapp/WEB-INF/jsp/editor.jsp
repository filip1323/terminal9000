<html ng-app="EditorAspect">
    <head>
        <title>Service</title>
        <link rel="Shortcut icon" href="resources/favicon.ico" />
        <link rel="Stylesheet" type="text/css" href="resources/css/style.css" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
        <script src="resources/js/angular.js" type="text/javascript"></script>
        <script src="resources/js/jquery-1.11.3.js" type="text/javascript"></script>
        <script src="resources/js/angular-dragdrop.js" type="text/javascript"></script>
    </head>

    <body id="editor">
   
        <div id="view">

        </div>

        <div id="editor-ui" jqyoui-droppable ng-controller="EditCtrl as editor">
            <h1>Edytor:</h1>
            <a href="#" ng-click="editor.addTable()">Dodaj stol</a>
            <a href="#" ng-click="editor.saveTables()">Zapisz stoliki</a>
            <p>Przeciagnij stolik o wymaganych wymiarach na wybrane miejsce.</p>
        </div>
        <script src="resources/js/main.js"></script>
    </body>

</html>