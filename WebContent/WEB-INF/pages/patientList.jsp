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

    <title>Patient</title>
</head>
<script>
function modalOpen(id,fname,lname,mobile,address,admitDate,dischargeDate) {
	    alert("hi");
		const pfname = document.getElementById('pfname');
		const plname= document.getElementById('plname');
		
		const pmobile= document.getElementById('pmobile');
		const paddress= document.getElementById('paddress');
		
		/* form.setAttribute('action', 'updateDish?dishId='+ id); */
		pfname.value = fname;
	    pdid.value=id;
        plname.value=lname;
		
         
        pmobile.value=mobile;
        paddress.value=address;
        
		$('#exampleModal').modal();
		
	}
	</script>
<body>
             
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Edit patient Details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="updatePat" method="post">
                        <input type="hidden"  name="userId" id="pdid">
                               <div class="form-group">
                            	<label for="pfname"> First Name</label>
                                <input type="text" class="form-control"  id="pfname" name="fname" required aria-describedby="Patient Fname" placeholder="Patient Name">
                            </div>
                            <div class="form-group">
                            	<label for="plname">last name</label>
                                <input type="text" class="form-control" id="plname" name="lname" required placeholder="Patient Lname">
                            </div>
                            
                            
                            <div class="form-group">
                             	<label for="pmobile">Mobile no</label>
                                <input type="text"  id="pmobile" required class="form-control" name="mobile" placeholder="add mobile no" >
                            </div>
                            <div class="form-group">
                            	<label for="paddress">Address</label>
                                <input type="text" id="paddress" required class="form-control" id="paddress" name="address" aria-describedby="address" placeholder="address" required autofocus>
                            </div>
                            
                            
                          <button type="submit" class="btn btn-primary">Update</button>
                        </form>
                    </div>
            </div>
                </div>
            </div>
    <div class="container py-2">
    <center><h2>Patient Details</h2></center>
        <table class="table table-striped table-responsive-sm">
                <thead>
                  <tr>
                     <th scope="col">Pat_Fname</th>
                     <th scope="col">Pat_Lname</th>
                    
                     <th scope="col">Pat_MobileNo</th>
                     <th scope="col">Pat_Address</th>
                     <th scope="col">Pat_AdmitDate</th>
                     <th scope="col">Pat_DischargeDate</th>
                    
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${list}" var="l" varStatus="loop">
                  <tr>
                    <th scope="row">${l.fname}</th>
                    <th scope="row">${l.lname}</th>
                    <th scope="row">${l.mobile}</th>
                    <th scope="row">${l.address}</th>
                    <th scope="row">${l.admitDate}</th>
                    <th scope="row">${l.dischargeDate}</th>
                    <td>
                        <button type="button" class="btn btn-primary" onClick="modalOpen('${l.userId}','${l.fname}','${l.lname}','${l.mobile}','${l.address}','${l.admitDate}','${l.dischargeDate}')" data-toggle="modal">
                               Edit
                         </button>
                    </td>
                    <td>
                    <form action="deletePat" method="post">
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