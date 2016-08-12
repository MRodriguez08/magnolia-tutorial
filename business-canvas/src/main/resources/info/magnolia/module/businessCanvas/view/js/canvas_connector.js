window.info_magnolia_module_businessCanvas_view_BusinessCanvasJs = function() {
	var element = $(this.getElement());
	var self = this;

	this.onStateChange = function() {
		window.businessCanvas = new BusinessCanvas();
		
		if(this.getState().keyActivities){
			window.businessCanvas.currentValue.html( this.getState().currentValue);
		};
		
		if(this.getState().keyPartners){
			window.businessCanvas.keyPartners.val( this.getState().keyPartners);

		};

		if(this.getState().keyActivities){
			window.businessCanvas.keyActivities.val( this.getState().keyActivities);
		};

		if(this.getState().valueProposition){
			window.businessCanvas.valueProposition.val( this.getState().valueProposition);
		};

		if(this.getState().customerRelationship){
			window.businessCanvas.customerRelationship.val( this.getState().customerRelationship);
		};

		if(this.getState().keyActivities){
			window.businessCanvas.keyActivities.val( this.getState().keyActivities);
		};

		if(this.getState().customerSegments){
			window.businessCanvas.customerSegments.val( this.getState().customerSegments);
		};

		if(this.getState().keyResources){
			window.businessCanvas.keyResources.val( this.getState().keyResources);
		};

		if(this.getState().channels){
			window.businessCanvas.channels.val( this.getState().channels);
		};

		if(this.getState().revenueStreams){
			window.businessCanvas.revenueStreams.val( this.getState().revenueStreams);
		};

		if(this.getState().costStructure){
			window.businessCanvas.costStructure.val( this.getState().costStructure);
		};

	}

    $('body').on('change', '.canvasTextField', function() {
    	console.log('state changed: ' + $(this).attr('id') + " = " + $(this).val());
       	self.getCanvas($(this).val(),$(this).attr('id'));
	});
};