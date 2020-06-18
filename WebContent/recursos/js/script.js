$(document).ready(function(){
listarAlumno();
listarEsc(0)
limpiar();


});
$("#guardar").click(function(){
	var escu= $("#escu").val();	
	var nom= $("#nom").val();
	var correo= $("#correo").val();
	var tel = $("#tel").val();
	var id = $("#id").val();
	if(id==0){
		$.post( "AlumnoController", {esc:escu,nom:nom,correo:correo,tel:tel, opc:3}).done(function(data){
			limpiar();
			listarEsc(0)
			listarAlumno();
			});
	}else{
		bootbox.confirm("Desea Modificar?", function(result) {
		if(result){
		 	bootbox.alert("Registro Modificado Correctamente...!", function() {		
			$.post( "AlumnoController", {ides :escu, alum:nom, correo:correo, telefono:tel, ida:id, opc:6}).done(function(data){
				$("#id").val(0);
				limpiar();
				listarEsc(0)
				listarAlumno();			
			});
		 	});
		}else{
	    	bootbox.alert("El registro no se Modifico...!");
	    	limpiar();
			listarEsc(0)
			listarAlumno();
	    }});		
	}
});
function listarEsc(x){
	var i, c =1;
	$("#escu").empty().append('<option selected="selected" value="test">Seleccionar Escuela</option>')
		$.get("AlumnoController", {opc : "1"}, 
		function(data) {
		var d = JSON.parse(data);
		for (i = 0; i < d.length; i++) {
			if (x == d[i].idescuela) {
				$("#escu").append(
						"<option selected='selected' value='" + d[i].idescuela + "'>"
								+ d[i].nombre + "</option>");
			} else {
				$("#escu").append(
						"<option value='" + d[i].idescuela + "'>"
								+ d[i].nombre + "</option>");
			}
		}
	});	
}

function listarAlumno(){
	var i, c =1;
	$.get("AlumnoController",{opc:"2"},function(data){	
		
		var d = JSON.parse(data);
		$('#tablita tbody').empty();
		for(i=0;i<d.length;i++){
			$("#tablita tbody").append("<tr><td style='color:blue'>"+c+"</td><td>"
			+d[i].nom_escuela+"</td><td>"
			+d[i].nombre_com+"</td><td>"
			+d[i].correo+"</td><td>"
			+d[i].telefono+
			"</td><td><a href='#' style='color:green' onclick='modificar("
			+d[i].idalumno+")'><i class='far fa-edit'></i></a></td><td><a href='#' style='color:red' onclick='eliminar("
			+d[i].idalumno+")'><i class='far fa-trash-alt'></i></a></td></tr>")
			c++;
		}
	});
}

function eliminar(id){	
	bootbox.confirm("Desea Eliminar?", function(result) {
    if(result){
    	bootbox.alert("Registro Eliminado Correctamente...!", function() {
    		$.get("AlumnoController",{id:id,opc:5},function(data){
    			limpiar();
				listarEsc(0)
				listarAlumno();
		});
    	});
		 
    }else{
    	bootbox.alert("El registro no se Elimino...!")
    }});
}
function modificar(id){	
	$.post("AlumnoController",{id:id,opc:4},function(data){
		var x = JSON.parse(data);
		$("#nom").val(x[0].nombre_com);
		$("#correo").val(x[0].correo);
		$("#tel").val(x[0].telefono);
		$("#id").val(x[0].idalumno);		
		listarEsc(x[0].idescuela);
	});
}
function limpiar(){
	$("#nom").val("");
	$("#correo").val("");
	$("#tel").val("");
	$("#nom").focus();
}
