<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Users using ajax</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
function doAjaxAddPost() {  
	  // get the form values
	  
	  var name = $('#name').val();
	  var desc = $('#desc').val();
	   
	  $.ajax({  
	    type: "POST",  
	    url: "/SpringHibernateWithAjax/addArticle.html",  
	    data: "articleName=" + name + "&articleDesc=" + desc,  
	    success: function(response){  
	      // we have the response  
	      $('#info').html(response);
	      $('#name').val('');
	      $('#desc').val('');
	      $('#result').val('');
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}
function doAjaxSearchPost() {  
	  // get the form values
	  
	  var keyword = $('#keyword').val();
	  //alert(keyword);
	  $.ajax({  
	    type: "POST",  
	    url: "/SpringHibernateWithAjax/searchArticle.html",  
	    data: "keyword=" + keyword,  
	    success: function(response){  
	      // we have the response  
	      $('#info').val('');
	      $('#name').val('');
	      $('#desc').val('');
	      $('#result').html(response);
	      
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}
</script>
</head>
<body>
<h1>Add Article using Ajax ........</h1>
	<table>
		<tr><td>Enter your name : </td><td> <input type="text" id="name"><br/></td></tr>
		<tr><td>Enter Desc : </td><td> <input type="text" id="desc"><br/></td></tr>
		<tr><td colspan="2"><input type="button" value="Add Article" onclick="doAjaxAddPost()"><br/></td></tr>
		<!-- <tr><td colspan="2"><div id="info" style="color: green;"></div></td></tr> -->
	</table>
	<div id="info" style="color: green;"></div>
	<table>
		<tr><td>Search : </td><td> <input type="text" id="keyword"><br/></td></tr>
		
		<tr><td colspan="2"><input type="button" value="Search Article" onclick="doAjaxSearchPost()"><br/></td></tr>
		<!-- <tr><td colspan="2"><div id="result" style="color: green;"></div></td></tr> -->
	</table>
	<div id="result" style="color: green;"></div>
</body>
</html>