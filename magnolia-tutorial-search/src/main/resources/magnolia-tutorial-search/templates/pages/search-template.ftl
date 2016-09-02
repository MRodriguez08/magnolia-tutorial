[#assign title = content.title!"Mgnl Training - Search component"]
<!DOCTYPE html>
<html>
<head>
<title>${title}</title>

<link rel="stylesheet"
 href="${ctx.contextPath}/.resources/magnolia-tutorial-search/webresources/css/style.css">
<link rel="stylesheet"
 href="${ctx.contextPath}/.resources/magnolia-tutorial-search/webresources/css/bootstrap.min.css">

[@cms.page /]
</head>
<body ng-app="searchApp">
 <div class="container">
  <header>
   <h1>${title}</h1>
  </header>

  <div class="container" ng-controller="searchController">
   <div class="row">
    <div class="col-md-12">
     <form>
      <div class="form-group">
       <input type="text" class="form-control" id="search-input"
        placeholder="search..." ng-model="query" ng-change="search()">
      </div>
     </form>
    </div>
    <div class="col-md-12">
     <table class="table table-bordered">
      <thead>
       <tr>
        <th>Id</th>
        <th>Path</th>
        <th>Title</th>
       </tr>
      </thead>
      <tbody>
       <tr ng-repeat="item in resultItems">
        <td>{{item.id}}</td>
        <td>{{item.path_s}}</td>
        <td>{{item.title_s}}</td>
       </tr>
      </tbody>
     </table>
    </div>
   </div>
  </div>
 </div>
</body>
<script type="text/javascript"
 src="${ctx.contextPath}/.resources/magnolia-tutorial-search/webresources/js/jquery.js"></script>
<script type="text/javascript"
 src="${ctx.contextPath}/.resources/magnolia-tutorial-search/webresources/js/angular.min.js"></script>
 <script type="text/javascript"
 src="${ctx.contextPath}/.resources/magnolia-tutorial-search/webresources/js/angular-resource.js"></script>
<script type="text/javascript"
 src="${ctx.contextPath}/.resources/magnolia-tutorial-search/webresources/js/bootstrap.min.js"></script>
<script type="text/javascript"
 src="${ctx.contextPath}/.resources/magnolia-tutorial-search/webresources/js/app.js"></script>
</html>
