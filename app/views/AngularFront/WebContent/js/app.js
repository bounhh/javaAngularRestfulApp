var myapp = angular.module('myapp', ['ngRoute']);
	myapp.config( function($routeProvider){
		$routeProvider.when('/', {templateUrl: 'home.html'});
		$routeProvider.when('/view1', {templateUrl: 'view1/view1.html'});
		$routeProvider.when('/allCustumer', {templateUrl: 'showAllCustomers.html', controller: 'allcustumerController'});
		$routeProvider.when('/addClient', {templateUrl: 'AddCustomers.html', controller: 'allcustumerController'});
		$routeProvider.otherwise({redirect: '/allCustumer'});
		
	});
	
	myapp.controller('allcustumerController', function($scope, $http){
		$scope.costumer = {};
		$scope.editBtn=false;
			$http.get("http://localhost:9000/customers").then(function (response) {
				$scope.costumers = response.data;
			});
			
			$scope.deletcustomer = function(costumer){
				$http({
					method: 'GET',
					url: 'http://localhost:9000/delete/'+costumer._id,
					headers:{},
					data: null
				}).success(function(data){
					$scope.status=data;
					var url="";
					$http.get(url).success(function(response){
					$scope.customers = response;
					});
				});
			};
			
			$scope.addcustomer = function(costumer){
				$http({
					method: 'GET',
					url: 'http://localhost:9000/addCustomer/'+costumer.name+"/"+costumer.email+"/"+costumer.company+"/"+costumer.phone+"/"+costumer.adress,
					headers: {},
					data: null})
					.success(function(data){
						$scope.status = data;
						var url = "#/allCustumer";
						$http.get(url).success(function (response){
							$scope.customers = response;
						});
					});
				reset();
				};
			
			$scope.editcustomer = function(costumer){
				$scope.costumer.name = costumer.name;
				$scope.costumer.company = costumer.company;
				$scope.costumer.email = costumer.email;
				$scope.costumer.id = costumer.id;
				showBtn();
			};
			
			function showBtn(){
				$scope.editBtn=true;			
			};

			function hideBtn(){
				$scope.editBtn=false;
			};
			
			function reset(){
				$scope.costumer.name="";
				$scope.costumer.company = "";
				$scope.costumer.email = "";
				$scope.costumer.id="";
				$scope.costumer.age="";
				$scope.costumer.adress="";
				$scope.costumer.about="";
				$scope.costumer.phone="";
			};
	});
	
	
	
	
	
	