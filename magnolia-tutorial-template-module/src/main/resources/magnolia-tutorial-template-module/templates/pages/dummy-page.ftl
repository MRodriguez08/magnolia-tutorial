[#assign title = content.title!"Dummy page (created by maven archetype)"]
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>

    <link rel="stylesheet" href="${ctx.contextPath}/.resources/magnolia-tutorial-template-module/webresources/css/style.css">
    <script type="text/javascript"
        src="${ctx.contextPath}/.resources/magnolia-tutorial-search/webresources/js/bootstrap.min.js"></script>

[@cms.page /]
</head>
<body>
<div class="container">
    <header>
        <h1>${title}</h1>
    </header>

    <div class="main">
    [@cms.area name="main"/]
    </div>

</div>
</body>
</html>
