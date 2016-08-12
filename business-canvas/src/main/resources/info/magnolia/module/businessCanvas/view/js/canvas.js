BusinessCanvas = function() {
	this.registerFields();
	this.keyPartners = $("#keyPartners");
	this.keyActivities =  $("#keyActivities");
	this.valueProposition = $("#valueProposition");
	this.customerRelationship = $("#customerRelationship");
	this.customerSegments = $("#customerSegments");
	this.keyResources = $("#keyResources");
	this.channels = $("#channels");
	this.costStructure = $("#costStructure");
	this.revenueStreams = $("#revenueStreams");
	this.currentValue = $("#currentValue");
};


BusinessCanvas.prototype.registerFields = function() {
	console.log("Registering Fields");
};


$(document).ready(function() {
	window.businessCanvas = new BusinessCanvas();
});

