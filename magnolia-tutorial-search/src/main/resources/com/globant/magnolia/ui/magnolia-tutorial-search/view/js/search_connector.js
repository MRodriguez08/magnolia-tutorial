window.com_globant_magnolia_ui_SearchJs = function() {
	var element = $(this.getElement());
	var self = this;

	this.onStateChange = function() {
		window.searchComponent = new SearchComponent();
		
		if(this.getState().searchResults){
			
			var table = document.createElement("table");
			var thead = document.createElement("thead");
			
			var id = document.createElement("td");
			id.appendChild(document.createTextNode("id"));
			thead.appendChild(id);
			var path = document.createElement("td");
			path.appendChild(document.createTextNode("path"))
			thead.appendChild(path);
			var title = document.createElement("td");
			title.appendChild(document.createTextNode("title"))
			thead.appendChild(title);
			var version = document.createElement("td");
			version.appendChild(document.createTextNode("version"))
			thead.appendChild(version);
			table.appendChild(thead);
			
			var tbody = document.createElement("tbody");
			var results = JSON.parse(this.getState().searchResults);
			for (var i = 0; i < results.length; i++){
				var tr = document.createElement("tr");
				var id = document.createElement("td");
				id.appendChild(document.createTextNode(results[i].id));
				tr.appendChild(id);
				var path = document.createElement("td");
				path.appendChild(document.createTextNode(results[i].path_s))
				tr.appendChild(path);
				var title = document.createElement("td");
				title.appendChild(document.createTextNode(results[i].title_s))
				tr.appendChild(title);
				var version = document.createElement("td");
				version.appendChild(document.createTextNode(results[i]._version_))
				tr.appendChild(version);
				
				tbody.appendChild(tr);
			}
			table.appendChild(tbody);
			window.searchComponent.searchResults.html( table );
		};

	}

    $('body').on('change', '#search-input', function() {
    	console.log('state changed: ' + $(this).attr('id') + " = " + $(this).val());
       	self.search($(this).val(),$(this).attr('id'));
	});
};