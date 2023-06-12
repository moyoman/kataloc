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
					alt="" class="logo">
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
						<li class="menu-item current-menu-item"><a href="../peliculas">Movies</a></li>
						<li class="menu-item"><a href="../series">Series</a></li>
						<li class="menu-item"><a href="../pages/about.html">About us</a></li>
					</ul>
					<!-- .menu -->

					<form class="search-form" id="formulario" method='POST' action="../searchPelicula"> 
						<input type="text" placeholder="Search Movie Title..." required name="search" autocomplete="off"></input>
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
					<div class="content">
							<div class="row">
							
								<div class="col-md-6">
									<figure class="movie-poster"><img src="http://image.tmdb.org/t/p/original/${pelicula.posterPath}" alt="${pelicula.title}"></img></figure>
								</div>
								<div class="col-md-6">
									<h2 class="movie-title">${pelicula.title}</h2>
									<div class="movie-summary">
										<p>${pelicula.overview}</p>
										<!--  
										<p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit sed.</p>
										-->
									</div>
									<ul class="movie-meta">
										<li><strong>Rating:</strong> 
											<div class="star-rating" title="Rated ${pelicula.voteAverage}.00 out of 5"><span style="width:80%"><strong class="rating">${pelicula.voteAverage}.00</strong> out of 5</span></div>
										</li>
										<li><strong>Length:</strong> ${pelicula.runtime}</li>
										<li><strong>Premiere:</strong> ${pelicula.releaseDate}</li>
										<li>
											<strong>Category:</strong>
											<c:forEach items="${pelicula.genres}" var="genero" varStatus="status">
											 	<i>${genero.name} ${not status.last ? ',':''}</i>
											</c:forEach>	 
										</li>
									</ul>

									<ul class="starring">
										<li><strong>Directors:</strong>
											<ul class="starring">
												<c:forEach items="${pelicula.director}" var="director">
													<li> ${director.name}</li>
												</c:forEach>
											</ul>
											
										</li>
										<li><strong>Writers:</strong>
											<ul class="starring">
												<c:forEach items="${pelicula.guionistas}" var="guion">
													<li> ${guion.name}</li>
												</c:forEach>
											</ul>
										</li>
										<li><strong>Stars:</strong></li>
										<li>
											<c:forEach items="${pelicula.topCast}" var="actor">
											<div class="col-sm-2">
												<div class="latest-movie">
													<figure>
														<img src="http://image.tmdb.org/t/p/original/${actor.profilePath}" alt="${actor.name}"/>
														<figcaption>${actor.name} - ${actor.character}</figcaption>
													</figure>													
												</div>
											</div>
										</c:forEach>
										</li>
									</ul> 
										
								</div>
							</div> <!-- .row -->
						<div class="row">
							<h3>Available in:</h3>
							<div class="filters">
								<form method="POST" action="${pelicula.id}" id="filtro">
									<select name="pais" id="pais" form="filtro">
										<option selected>-- Choose Country --</option>
										<c:forEach items="${countries}" var="country">
											<option value="${country.iso_639_1}">${country.englishName}</option>
										</c:forEach>
									</select>
									<input type="submit" value="Select Country"/>
								</form>
							</div>							
						</div>
						<div class="row">
							<h4>Streaming:</h4>
							<c:forEach items="${proveedores.flatrate}" var="proveedor">
								<div class="col-sm-1">
									<div class="latest-movie">
										<figure>
											<img alt="${proveedor.name}" src="http://image.tmdb.org/t/p/original/${proveedor.logoPath}"/>
											<figcaption>${proveedor.name}</figcaption>
										</figure>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="row">
							<h4>Rent:</h4>
							<c:forEach items="${proveedores.rent}" var="proveedor">
								<div class="col-sm-1">
									<div class="latest-movie">
										<figure>
											<img alt="${proveedor.name}" src="http://image.tmdb.org/t/p/original/${proveedor.logoPath}"/>
											<figcaption>${proveedor.name}</figcaption>
										</figure>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="row">
							<h4>Buy:</h4>
							<c:forEach items="${proveedores.buy}" var="proveedor">
								<div class="col-sm-1">
									<div class="latest-movie">
										<figure>
											<img alt="${proveedor.name}" src="http://image.tmdb.org/t/p/original/${proveedor.logoPath}"/>
											<figcaption>${proveedor.name}</figcaption>
										</figure>
									</div>
								</div>
							</c:forEach>
						</div>
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
	
	<script src="../../resources/js/jquery-1.11.1.min.js"></script>
	<script src="../../resources/js/plugins.js"></script>
	<script src="../../resources/js/app.js"></script>
</body>
</html>