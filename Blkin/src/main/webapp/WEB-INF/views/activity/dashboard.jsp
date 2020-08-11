<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<html>
<head>
<title>대시보</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/dashboard/assets/css/main.css" />
</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Menu -->
		<section id="menu">

			<!-- Search -->
			<section>
				<form class="search" method="get" action="#">
					<input type="text" name="query" placeholder="Search" />
				</form>
			</section>

			<!-- Links -->
			<section>
				<ul class="links">
					<li><a href="#">
							<h3>가나다</h3>
							<p>Feugiat tempus veroeros dolor</p>
					</a></li>
					<li><a href="#">
							<h3>Dolor sit amet</h3>
							<p>Sed vitae justo condimentum</p>
					</a></li>
					<li><a href="#">
							<h3>Feugiat veroeros</h3>
							<p>Phasellus sed ultricies mi congue</p>
					</a></li>
					<li><a href="#">
							<h3>Etiam sed consequat</h3>
							<p>Porta lectus amet ultricies</p>
					</a></li>
				</ul>
			</section>

			<!-- Actions -->
			<section>
				<ul class="actions stacked">
					<li><a href="#" class="button large fit">Log In</a></li>
				</ul>
			</section>

		</section>

		<!-- Main -->
		<div id="main">

			<!-- Post -->
			<article class="post">
				<header>
					<div class="title">
						<h2>
							<a href="">${list.activity_subject}</a>
						</h2>
						<p>Lorem ipsum dolor amet nullam consequat etiam feugiat</p>
					</div>
					<div class="meta">
						<time class="published" datetime="2015-11-01">November 1,
							2015</time>
						<a href="#" class="author"><span class="name">Jane Doe</span><img
							src="images/avatar.jpg" alt="" /></a>
					</div>
				</header>
				<div>
					<div>이름</div>
				</div>
				<footer>
					<ul class="actions">
						<li><a href="single.html" class="button large">Continue
								Reading</a></li>
					</ul>
					<ul class="stats">
						<li><a href="#">General</a></li>
						<li><a href="#" class="icon solid fa-heart">28</a></li>
						<li><a href="#" class="icon solid fa-comment">128</a></li>
					</ul>
				</footer>
			</article>



			<!-- Pagination -->
			<ul class="actions pagination">
				<li><a href="" class="disabled button large previous">Previous
						Page</a></li>
				<li><a href="#" class="button large next">Next Page</a></li>
			</ul>

		</div>

		<!-- Sidebar -->
		<section id="sidebar">

			<!-- Intro -->
			<section id="intro">
				<a href="#" class="logo"><img src="images/logo.jpg" alt="" /></a>
				<header>
					<h2>Future Imperfect</h2>
					<p>
						Another fine responsive site template by <a
							href="http://html5up.net">HTML5 UP</a>
					</p>
				</header>
			</section>

			<!-- Mini Posts -->
			<section>
				<div class="mini-posts">

					<!-- Mini Post -->
					<article class="mini-post">
						<header>
							<h3>
								<a href="single.html">Vitae sed condimentum</a>
							</h3>
							<time class="published" datetime="2015-10-20">October 20,
								2015</time>
							<a href="#" class="author"><img src="images/avatar.jpg"
								alt="" /></a>
						</header>
						<a href="single.html" class="image"><img
							src="images/pic04.jpg" alt="" /></a>
					</article>
			</section>

			<!-- Posts List -->
			<section>
				<ul class="posts">
					<li>
						<article>
							<header>
								<h3>
									<a href="single.html">Lorem ipsum fermentum ut nisl vitae</a>
								</h3>
								<time class="published" datetime="2015-10-20">October 20,
									2015</time>
							</header>
							<a href="single.html" class="image"><img
								src="images/pic08.jpg" alt="" /></a>
						</article>
					</li>
					<li>
			</section>

			<!-- About -->
			<section class="blurb">
				<h2>About</h2>
				<p>Mauris neque quam, fermentum ut nisl vitae, convallis maximus
					nisl. Sed mattis nunc id lorem euismod amet placerat. Vivamus
					porttitor magna enim, ac accumsan tortor cursus at phasellus sed
					ultricies.</p>
				<ul class="actions">
					<li><a href="#" class="button">Learn More</a></li>
				</ul>
			</section>

			<!-- Footer -->
			<section id="footer">
				<ul class="icons">
					<li><a href="#" class="icon brands fa-twitter"><span
							class="label">Twitter</span></a></li>
					<li><a href="#" class="icon brands fa-facebook-f"><span
							class="label">Facebook</span></a></li>
					<li><a href="#" class="icon brands fa-instagram"><span
							class="label">Instagram</span></a></li>
					<li><a href="#" class="icon solid fa-rss"><span
							class="label">RSS</span></a></li>
					<li><a href="#" class="icon solid fa-envelope"><span
							class="label">Email</span></a></li>
				</ul>
			</section>

		</section>

	</div>

	<!-- Scripts -->
	<script
		src="${pageContext.request.contextPath}/dashboard/assets/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/dashboard/assets/js/browser.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/dashboard/assets/js/breakpoints.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/dashboard/assets/js/util.js"></script>
	<script
		src="${pageContext.request.contextPath}/dashboard/assets/js/main.js"></script>

</body>
</html>