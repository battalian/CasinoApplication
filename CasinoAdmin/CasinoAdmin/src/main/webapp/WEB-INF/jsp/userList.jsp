<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
	

	<script type="text/javascript">
	$(document).ready(function () {
		$('#exampleModal').on('show.bs.modal', function (event) {
			  var button = $(event.relatedTarget) 
			  var recipient = button.data('id')
			  var modal = $(this)
			  modal.find('.modal-body input[name="id"]').val(recipient)
			})
		});
	
	</script>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Casino Admin</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/admin/home">Home </a></li>
				<li class="nav-item "><a class="nav-link"
					href="http://localhost:8080/admin/register">Register</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="http://localhost:8080/admin/userLists">User List</a></li>

			</ul>
		</div>
	</nav>

	<div class="container">

		<form action="http://localhost:8080/admin/handlingSearch"
			method="post">
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label>Name</label> <input type="text" name="name"
							class="form-control" placeholder="Name">
					</div>

				</div>

				<div class="col">
					<div class="form-group">
						<label>Number</label> <input type="text" name="number"
							class="form-control" placeholder="Number">
					</div>

				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label>Email</label> <input type="text" name="email"
							class="form-control" placeholder="Email">
					</div>

				</div>

				<div class="col">
					<button type="submit" class="btn btn-info">Search</button>

				</div>
			</div>


		</form>
	</div>


	<div class="container">
		<div class="jombotron">

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Name</th>
						<th scope="col">DOB</th>
						<th scope="col">Contact</th>
						<th scope="col">Email</th>
						<th scope="col">Balance(in Rs.)</th>
						<th scope="col">Recharge</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<c:set var = "dob" value = "${fn:replace(user.dob, '00:00:00.0', ' ')}" />
							<td>${user.id}</td>
							<td>${user.name}</td>
							<td>${dob}</td>
							<td>${user.number}</td>
							<td>${user.email}</td>
							<td>${user.amount}</td>
							<td><span class="fa fa-plus fa-2x" data-toggle="modal"
								data-target="#exampleModal" data-id=${user.id} ></span>

								<div class="modal fade" id="exampleModal" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalLabel"
									aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">Recharge
													Balance</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												<form action="http://localhost:8080/admin/addAmount"
													method="post">
													<div class="form-group">
														<label class="col-form-label">Amount</label> <input
															type="number" name="amount" class="form-control" min="0" 
															step="0.01"
															id="amount"> 
															
															<input type="number" name="id"
															value="${user.id}" style="display: none;" />
														<button type="submit" class="btn btn-primary">Recharge</button>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Close</button>
											</div>
										</div>
									</div>
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


		</div>
	</div>



	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
		integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
		crossorigin="anonymous"></script>
</body>

</html>