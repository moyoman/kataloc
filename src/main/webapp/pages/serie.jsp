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
<link href="../resources/fonts/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- Loading main css file -->
<link rel="stylesheet" href="../resources/style.css">
</head>

<body>
	
	<div id="site-content">
		<header class="site-header">
			<div class="container">
				<a href="../" id="branding"> <img src="../resources/images/logo.png"
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
						<li class="menu-item"><a href="../peliculas">Movies</a></li>
						<li class="menu-item current-menu-item"><a href="../series">Series</a></li>
						<li class="menu-item"><a href="">About us</a></li>
					</ul>
					<!-- .menu -->

					<form class="search-form" id="formulario" method='POST' action="searchSerie"> 
						<input type="text" placeholder="Search Serie Title..." required name="search" autocomplete="off"></input>
						<button>
							<i class="fa fa-search"></i>
						</button>
						
						<!--  
						<input type="submit"><i class="fa fa-search"></i></input>
						-->
					</form>
				</div>
				<!-- .main-navigation -->

				<div class="mobile-navigation"></div>
			</div>
		</header>
		<main class="main-content">
				<div class="container">
					<div class="page">
						<div class="filters">
							<form method="POST" action="series" id="filtro">								
								<select name="generos" id="generos" form="filtro">
									<option selected>-- Choose Category --</option>
									<c:forEach items="${generos}" var="genero">
										<option value="${genero.id}">${genero.name}</option>
									</c:forEach>
								</select>
								<input type="submit" value="Filter"/>								
							</form>
						</div>
						
						<div class="movie-list">
							<c:forEach items="${series}" var="serie">
								<div class="movie">
									<figure class="movie-poster">
										<a href="../serie/${serie.id}">
											<img src="http://image.tmdb.org/t/p/original/${serie.posterPath}" alt="${serie.name}">
										</a>
									</figure>
									<div class="movie-title"><a href="../serie/${serie.id}">${serie.name}</a></div>
									<p>${serie.overview}</p>
								</div>
							</c:forEach>
						</div> <!-- .serie-list -->
						<div class="pagination">
							<a href="../series/1" class="page-number prev"><i class="fa fa-angle-left"></i></a>
							<span class="page-number current">1</span>
							<a href="../series/2" class="page-number">2</a>
							<a href="../series/3" class="page-number">3</a>
							<a href="../series/3" class="page-number">4</a>
							<a href="../series/4" class="page-number">5</a>
							<a href="" class="page-number next"><i class="fa fa-angle-right"></i></a>
						</div>
					</div>
				</div> <!-- .container -->
			</main>
		<footer class="site-footer">
			<div class="container">
				<div class="row">

				</div> <!-- .row -->

				<div class="colophon">Copyright 2023 Kataloc. All rights reserved</div>
			</div> <!-- .container -->

		</footer>
	</div>

	<script src="../../resources/js/jquery-1.11.1.min.js"></script>
	<script src="../../resources/js/plugins.js"></script>
	<script src="../../resources/js/app.js"></script>
</body>
</html>