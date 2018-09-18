(function() {
	var app = angular.module('modone', [ 'ngRoute' ]);

	app.controller('eventscontroller', function($http, $scope) {
		$scope.events = [];
		this.availableOptions = [ 'AK', 'AL', 'AR', 'AZ', 'CA', 'CO', 'CT',
				'DC', 'DE', 'FL', 'GA', 'HI', 'IA', 'ID' ];

		this.eventDetail = {
			"name" : null,
			"date" : null,
			"venueDTO" : {
				"name" : null,
				"city" : null,
				"state" : null
			}
		};

		this.add = function() {
			$http.post('events/', this.eventDetail).success(
					function(data, status, headers, config) {
						alert('Event created.');
						$scope.events[$scope.events.length] = data;
					}).error(function(data, status, headers, config) {
				alert('Can not create event.');
			});
		};

		this.all = function() {
			$http.get('events/').success(
					function(data, status, headers, config) {
						$scope.events = data;
					}).error(function(data, status, headers, config) {
				alert('Can not perform search.');
			});
		};

		this.all();
	});
})();
