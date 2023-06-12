<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">

<title>Kataloc</title>

<!-- Loading third party fonts -->
<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
<link href="resources/fonts/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- Loading main css file -->
<link rel="stylesheet" href="resources/style.css">
</head>

<body>
	
	<div id="site-content">
		<header class="site-header">
			<div class="container">
				<a href="../" id="branding"> <img src="resources/images/logo.png"
					alt="" class="logo"/>
					<div class="logo-copy">
						<h1 class="site-title">Kataloc</h1>
						<!--  
						<small class="site-description">Tagline goes here</small>
						-->
					</div>
				</a>
				<!-- #branding -->

				<div class="main-navigation">
					<button type="button" class="menu-toggle">
						<i class="fa fa-bars"></i>
					</button>
					<ul class="menu">
						<li class="menu-item"><a href="../">Home</a></li>
						<li class="menu-item current-menu-item"><a href="peliculas">Movies</a></li>
						<li class="menu-item"><a href="series">Series</a></li>
						<li class="menu-item"><a href="">About us</a></li>
					</ul>
					<!-- .menu -->

					<form class="search-form" id="formulario" method='POST' action="search"> 
						<input type="text" placeholder="Search..." required name="search" autocomplete="off"></input>
						<button>
							<i class="fa fa-search"></i>
						</button>						
					</form>
				</div>
				<!-- .main-navigation -->

				<div class="mobile-navigation"></div>
			</div>
		</header>
		<main class="main-content">
			<div class="container">
				<div class="page">
					<div class="row">
						<h1 class="movie-title"> Movie Search Results</h1>
						<c:forEach items="${search}" var="pelicula">
							<div class="col-sm-6 col-md-3">
								<div class="latest-movie">
									<a href="pelicula/${pelicula.id}"><img src="http://image.tmdb.org/t/p/original/${pelicula.posterPath}" alt="${pelicula.title}"></a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</main>
		<footer class="site-footer">
			<div class="container">
				<div class="row">

				</div> <!-- .row -->

				<div class="colophon">Copyright 2023 Kataloc. All rights reserved</div>
			</div> <!-- .container -->

		</footer>
	</div>

	<script src="../resources/js/jquery-1.11.1.min.js"></script>
	<script src="../resources/js/plugins.js"></script>
	<script src="../resources/js/app.js"></script>
</body>
</html>