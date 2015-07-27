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

    <body id="manager" ng-controller="ManagerCtrl as manager">
        <div id="view" >
            <div ng-repeat="table in manager.tables" ng-click="manager.setAsSelected(table.id)" class="table" style="position: absolute; width: {{table.width}}px;height: {{table.height}}px;top: {{table.yCoord}}px;left: {{table.xCoord}}px;">{{table.id}}</div>
        </div>

        <div id="manager-ui">
            <p>Table selected id: {{manager.selectedTable.id}}<u ng-show="manager.selectedTable.id == null">none</u></p>
            <a ng-show="manager.selectedTable.id != null" href="#" ng-click="manager.createOrder()">Dodaj zamowienie</a>
            <table class="order" ng-repeat="order in manager.selectedTable.orders">
                <caption><a href="#" ng-click="manager.selectOrder(order.id)">order &#35{{order.id}}</a></caption>
                <th>
                    <td>index</td><td>name</td><category</td><td>price</td>
                </th>
                <tr ng-repeat="product in order.products">
                    <td>{{$index}}</td><td>{{product.name}}</td><td>{{product.category}}</td><td>{{product.price}}</td>
                </tr>
            </table>
        </div>
        <div id="orders-ui">
            <p>Order &#35{{manager.selectedOrder.id}}</p>

        </div>
    </body>

</html>