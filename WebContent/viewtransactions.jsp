<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<li class="nav-item active"><a class="nav-link" href="#">View
						Transactions</a></li>
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

	<div class="col-md-8 col-md-offset-8"
		style="margin: 0 auto; width: 70%">

		<form action="<%=request.getContextPath()%>/filter_transactions"
			method="post" style="margin-bottom: 30px;">
			<div class="container">
				<div class="row">
					<div class="col-md-4">
						<label for="start" style="margin-right: 20px;">Start Date:
						</label><input type="date" id="start" name="start_date" />
					</div>
					<div class="col-md-4">
						<label for="end" style="margin-right: 20px;">End Date: </label><input
							type="date" id="end" name="end_date" />
					</div>
					<button type="submit" class="btn btn-primary">Filter</button>
				</div>
			</div>
		</form>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Transaction ID</th>
					<th scope="col">Transaction Type</th>
					<th scope="col">Receiver</th>
					<th scope="col">Amount</th>
					<th scope="col">Status</th>
					<th scope="col">Description</th>
					<th scope="col">Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${transactions}" var="transaction">
					<tr>
						<td>${transaction.transactionID}</td>
						<td>${transaction.transactionType}</td>
						<td>${transaction.toAccount}</td>
						<td>${transaction.amount}</td>
						<td>${transaction.status}</td>
						<td>${transaction.description}</td>
						<td>${transaction.dateTime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>