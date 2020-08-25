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
				<li class="nav-item active"><a class="nav-link" href="#">Cash
						Transactions <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="viewtransactions.jsp">View Transactions</a></li>
				<li class="nav-item"><a class="nav-link" href="contactus.jsp">Contact
						Us</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>

	<div class="col-md-4 col-md-offset-4"
		style="margin: 0 auto; width: 70%">
		<form action="<%=request.getContextPath()%>/cashtransaction"
			method="post">
			<div class="form-group">
				<label for="accountnumber">Account Number</label> <input type="text"
					class="form-control" id="accountnumber">
			</div>
			<div class="form-group">
				<label for="operation">Type of transaction</label> <select
					class="form-control" id="operation">
					<option value="" disabled selected>Select transaction type</option>
					<option>Withdraw</option>
					<option>Deposit</option>
				</select>
			</div>
			<div class="form-group">
				<label for="amount">Amount</label> <input type="text"
					class="form-control" id="amount">
			</div>
			<div class="form-group">
				<label for="description">Description</label>
				<textarea class="form-control" id="description" rows="3"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>