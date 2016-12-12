var georeferencedData = [
	{
		cityName: 'Goiânia',
		coordinates: {lat: -16.686891, lng: -49.264794},
		names: ['nomeEgresso1', 'nomeEgresso2', 'nomeEgresso3', 'nomeEgresso4'],
		type: 'Residência'
	},
	{
		cityName: 'Aparecida de Goiânia',
		coordinates: {lat: -16.820257, lng: -49.247304},
		names: ['nomeEgresso5', 'nomeEgresso6', 'nomeEgresso7'],
		type: 'Residência'
	},
	{
		cityName: 'Anápolis',
		coordinates: {lat: -16.328546, lng: -48.953403},
		names: ['nomeEgresso8', 'nomeEgresso9'],
		type: 'Atuação Profissional'
	},
	{
		cityName: 'Hidrolândia',
		coordinates: {lat: -16.965753, lng: -49.231423},
		names: ['nomeEgresso10'],
		type: 'Atuação Profissional'
	}
];

$(document).ready(function(){

	initCityDetails();

	$('#detailsByCity').find('> a').on('click', function () {
        updateCityModalInfo($(this).attr('id'));
    });

});

function initCityDetails() {

	var htmlContent = "";
	var cityNames = collectData("cityName");
	var names = collectData("names");

	for(var x = 0; x < georeferencedData.length; x++) {
		htmlContent += "<a href='#' id='city" + x + "' class='list-group-item' data-toggle='modal' data-target='#cityModal'>" +
		"	<i class='fa fa-map-pin fa-fw'></i> " + cityNames[x]  +
		"	<span class='pull-right text-muted small'><em>" + names[x].length + " resultados </em>" +
		"	</span>" +
		"</a>"
	}

	$('#detailsByCity').html(htmlContent);

}

function updateCityModalInfo(idAsStr) {

	var idAsInt = parseInt(idAsStr.substring(4));
	$('#cityModalTitle').html(georeferencedData[idAsInt].cityName);
	$('#cityModalBody').html("<p>" + georeferencedData[idAsInt].names.join(", ") + "</p>");

}

function initMap() {

	var names = collectData("names");
	var cityNames = collectData("cityName");
	var markerLocations = collectData("coordinates");
	var map = new google.maps.Map(document.getElementById('map'), {
		zoom: 9,
		center: {lat: -16.8, lng: -49.0}
	});

	for(var x = 0; x < markerLocations.length; x++){
		(function () {
			var infowindow = new google.maps.InfoWindow({
				content: "<b>Total em " + cityNames[x] + ": " + names[x].length + "</b>"
			});
			var marker = new google.maps.Marker({
				position: markerLocations[x],
				map: map
			});
			google.maps.event.addListener(marker, 'mouseover', function() {
				infowindow.open(map,marker);
			});
			google.maps.event.addListener(marker, 'mouseout', function() {
				infowindow.close(map,marker);
			});
		}());
	}
}

function collectData(dataName){

	var data = [];

	for(var x = 0; x < georeferencedData.length; x++){
		data.push(georeferencedData[x][dataName]);
	}

	return data;
}
