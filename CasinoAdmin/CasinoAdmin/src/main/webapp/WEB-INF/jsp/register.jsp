<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<script type="text/javascript">
	function ageValidator() {
		dob_input = document.getElementById("dob");
		var dob =new Date (dob_input.value);
		milsec = Date.now() - dob.getTime();
		years = milsec/(1000 * 60 * 60 * 24* 365);
		 if( years < 18) 
			 dob_input.setCustomValidity('Age should be atleast 18 !!! ')
			 }
   </script>

</head>
<body>

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
				<li class="nav-item active"><a class="nav-link"
					href="http://localhost:8080/admin/register">Register</a></li>
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/admin/userLists">User List</a></li>

			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="jombotron">
			<form action="http://localhost:8080/admin/addContent" method="POST" enctype="multipart/form-data">
				<div class="form-group">
					<label>Name</label> <input type="text" class="form-control"
						id="name" name="name" placeholder="Enter Name"
						pattern="[a-zA-Z ]+" required />
				</div>

				<div class="form-group">
					<label>Email</label> <input type="email" class="form-control"
						id="email" name="email" placeholder="Enter Email" required />
				</div>

				<div class="form-group">
					<label>Contact Number</label> <input type="text"
						class="form-control" id="number" name="number"
						placeholder="Enter contact" pattern="[789][0-9]{9}" required />
				</div>

				<div class="form-group">
					<label>Date Of Birth</label> <input type="date" id="dob" name="dob"
						onblur="ageValidator()" class="form-control" placeholder="Enter DOB"
						required />
				</div>
				
				<div class="form-group">
					<label>Copy Of ID</label> 
					<input type="file" id="file" name="file" class="form-control" placeholder="Upload image"
						required />
				</div>
				
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>

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