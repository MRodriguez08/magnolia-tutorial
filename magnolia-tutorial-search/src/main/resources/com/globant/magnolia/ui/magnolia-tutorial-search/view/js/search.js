SearchComponent = function() {
	this.registerFields();
	this.searchResults = $(".results-row");
};


SearchComponent.prototype.registerFields = function() {
	console.log("Registering Fields");
};


$(document).ready(function() {
	window.searchComponent = new SearchComponent();
});

