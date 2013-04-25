function LinkListCtrl($scope, $http) {
  $http.get('http://localhost:8080/links').success(function(data) {
    $scope.links = data;
  });
}