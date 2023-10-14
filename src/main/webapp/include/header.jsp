<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">


    <title><% if(request.getAttribute("title")==null){
        out.print("HomePage");
    }else {
  out.print(request.getAttribute("title"));
}%></title>
    <!-- Bootstrap core CSS -->
    <link href="include/assets/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="include/assets/css/style.css" rel="stylesheet">
    <link href="include/assets/css/font-awesome.min.css" rel="stylesheet">


    <!-- Just for debugging purposes. Don't actually copy this line! -->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <![endif]-->
  </head>

  <body>

    <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${pageContext.request.contextPath}/site?page=home">SOLID.</a>
        </div>
        <div class="navbar-collapse collapse navbar-right">
          <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/site?page=home">HOME</a> </li>
            <li><a href="${pageContext.request.contextPath}/operation?page=list-users">List Users</a> </li>
            <li><a href="${pageContext.request.contextPath}/operation?page=add-user">Add Users</a> </li>
            <li><a href="${pageContext.request.contextPath}/operation?page=update-user">Update User Info</a> </li>

          </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>