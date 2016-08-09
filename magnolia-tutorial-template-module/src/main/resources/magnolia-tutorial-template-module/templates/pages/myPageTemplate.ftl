<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${ctx.contextPath}/hello-magnolia/webresources/css/styles.css}">	
		[@cms.page /]
	</head>
	<body>
	<div class="container">
		<header>
			<h1>Hello magnolia</h1>
			<p>This page was created with the template "${def.name}"</p>
			<p>${content.title!}</p>
			<p>${content.introText!}</p>
		</header>
	</div>
	</body>
</html>