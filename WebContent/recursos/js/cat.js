$(document).ready(function(){
	listarCat();
});

$("#boton").click(function(){
	var cat = $("#cat").val();
	var idc = $("#idc").val();
	if(idc==0){
		$.post("cc",{categoria:cat,opc:1}).done(function(data){
			listarCat();
			limpiar();
		});
	}else{
		$.post("cc",{id:idc,categoria:cat,opc:5}).done(function(data){
			$("#idc").val(0);
			listarCat();
			limpiar();
		});
		
	}
	
});
function listarCat() {
	$.get("cc",{opc:2},function(data){
		var cc = JSON.parse(data);
		$("#tablita tbody").empty();
		for(i=0;i<cc.length;i++){
			$("#tablita").append("<tr><td>"+cc[i].idcategoria+"</td><td>"+cc[i].nombre+"</td><td><a href='#' onclick='modificar("+cc[i].idcategoria+")'><i class='far fa-edit'></i></a></td><td><a href='#' onclick='eliminar("+cc[i].idcategoria+")'><i class='far fa-trash-alt'></i></a></td></tr>");
		}
	});
}
function eliminar(id) {
	bootbox.confirm("Desea Eliminar?",function(result){
		if(result){
			bootbox.alert("Registro eliminado carrectamente...!", function(){
				$.get("cc",{id:id,opc:3},function(data){
					listarCat();
				});
			});
		}else{
			bootbox.alert("Registro no se elimino...!")
		}});
}
function modificar(id) {
	$.get("cc",{id:id,opc:4},function(data){
		var x = JSON.parse(data);
		$("#cat").val(x.nombre);
		$("#idc").val(x.idcategoria);
	});
}
function limpiar(){
	$("#cat").val("");
	$("#idc").val(0);
	$("#cat").focus();
}