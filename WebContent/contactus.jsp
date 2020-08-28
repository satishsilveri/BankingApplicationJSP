<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Lambton Bank</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light"
		style="margin-bottom: 50px;">
		<a class="navbar-brand" href="#">Lambton Bank</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link"
					href="cashtransactions.jsp">Cash Transactions <span
						class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="viewtransactions.jsp">View Transactions</a></li>
				<li class="nav-item active"><a class="nav-link" href="#">Contact
						Us</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
			<form class="form-inline my-2 my-lg-0" method="link"
				action="logout.jsp" style="margin-left: 10px;">
				<button class="btn btn-danger" type="submit">Logout</button>
			</form>
		</div>
	</nav>

	<div class="col-md-4 col-md-offset-4"
		style="margin: 0 auto; width: 70%">
		<form action="<%=request.getContextPath()%>/complaint" method="post">
			<h5>We can't solve your problem if you don't tell us about it!</h5>
			<div class="form-group">
				<label for="name">Your Name:</label> <input type="text"
					class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" name="email">
			</div>
			<div class="form-group">
				<label for="message">Message</label>
				<textarea class="form-control" id="message" rows="5" name="message"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<br> <br>
		<h6>Address:</h6>
		<p>265 Yorkland Blvd #400,</p>
		<p>North York,</p>
		<p>ON M2J 1S5</p>
	</div>

</body>
</html>