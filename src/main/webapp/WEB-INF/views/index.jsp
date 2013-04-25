<html ng-app id="ng-app">
<head>
  <script src="/resources/js/angular.js"></script>
  <script src="/resources/js/controllers.js"></script>
</head>
<body ng-controller="LinkListCtrl">
  <ul>
    <li ng-repeat="link in links">
      {{link.name}}
    <p>{{link.url}}</p>
    </li>
  </ul>
</body>
</html>