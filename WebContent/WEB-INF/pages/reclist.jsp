<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>admin</title>
</head>
<script>
function modalOpen(id,fname,lname,email,mobile,address,qualification,username) {
	
		const edfname = document.getElementById('edfname');
		const edlname= document.getElementById('edlname');
		const edemail= document.getElementById('edemail');
		const edmobile= document.getElementById('edmobile');
		const edaddress= document.getElementById('edaddress');
		const edquali= document.getElementById('edquali');
		const eduser= document.getElementById('eduser');
		
		/* form.setAttribute('action', 'updateDish?dishId='+ id); */
		edfname.value = fname;
	    edid.value=id;
        edlname.value=lname;
		
         edemail.value=email;
        edmobile.value=mobile;
        edaddress.value=address;
        edquali.value=qualification;
        eduser.value=username;
     
		$('#exampleModal').modal();
		
	}
	</script>
<body>
             
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Edit Receptionist Details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="updateRec" method="post">
                        <input type="hidden"  name="userId" id="edid">
                               <div class="form-group">
                            	<label for="edfname"> First Name</label>
                                <input type="text" class="form-control"  id="edfname" name="fname" required aria-describedby="Doctor Fname" placeholder="Edit Doctor Name">
                            </div>
                            <div class="form-group">
                            	<label for="edlname">last name</label>
                                <input type="text" class="form-control" id="edlname" name="lname" required placeholder="Edit Doctor Lname">
                            </div>
                            <div class="form-group">
                             	<label for="edemail">E-mail</label>
                                <input type="text" id="edemail" required class="form-control" name="email" placeholder="add emil">
                            </div>
                            
                            <div class="form-group">
                             	<label for="eduser">UserName</label>
                                <input type="text" id="eduser" required class="form-control" name="username" placeholder="add username">
                            </div>
                            <div class="form-group">
                             	<label for="edmobile">Mobile no</label>
                                <input type="text"  id="edmobile" required class="form-control" name="mobileno" placeholder="add mobile no" >
                            </div>
                            <div class="form-group">
                            	<label for="edaddress">Address</label>
                                <input type="text" id="edaddress" required class="form-control" id="address" name="address" aria-describedby="doctor adress" placeholder="address" required autofocus>
                            </div>
                            <div class="form-group">
                            	<label for="edquali">Qualification</label>
                                <input type="text" id="edquali" required class="form-control" id="qualifiction" name="quali" aria-describedby="doctor qualification" placeholder="add doctor qualificationd" required autofocus>
                            </div>
                            
                          <button type="submit" class="btn btn-primary">Update</button>
                        </form>
                    </div>
            </div>
                </div>
            </div>
    <div class="container py-2">
    <center><h2>Receptionist Details</h2></center>
        <table class="table table-striped table-responsive-sm">
                <thead>
                  <tr>
                     <th scope="col">Rec_Fname</th>
                     <th scope="col">Rec_Lname</th>
                     <th scope="col">Rec_EmailId</th>
                     <th scope="col">Rec_MobileNo</th>
                     <th scope="col">Rec_Address</th>
                     <th scope="col">Rec_Qualifiaction</th>
                     <th scope="col">Rec_UserName</th>
                    
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${list}" var="l" varStatus="loop">
                  <tr>
                    <th scope="row">${l.fname}</th>
                    <th scope="row">${l.lname}</th>
                    <th scope="row">${l.email}</th>
                    <th scope="row">${l.mobileno}</th>
                    <th scope="row">${l.address}</th>
                    <th scope="row">${l.quali}</th>
                    <th scope="row">${l.username}</th>
                    <td>
                        <button type="button" class="btn btn-primary" onClick="modalOpen('${l.userId}','${l.fname}','${l.lname}','${l.email}','${l.mobileno}','${l.address}','${l.quali}','${l.username}')" data-toggle="modal">
                               Edit
                         </button>
                    </td>
                    <td>
                    <form action="deleteRec" method="post">
                      <input type="hidden" name="userId" value=${l.userId }>
                    	<button type="submit" class="btn btn-danger">
                    		Delete
                    	</button>
                    	</form>
                    </td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</body>
</html>