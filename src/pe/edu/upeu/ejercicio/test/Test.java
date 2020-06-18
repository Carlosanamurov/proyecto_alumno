package pe.edu.upeu.ejercicio.test;

import com.google.gson.Gson;

import pe.edu.upeu.ejercicio.dao.AlumnoDao;
import pe.edu.upeu.ejercicio.daoImp.AlumnoDaoImp;
import pe.edu.upeu.ejercicio.util.Conexion;


public class Test {

	private static Gson g = new Gson();
	private static AlumnoDao df= new AlumnoDaoImp();
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
lista();
	}
	static void lista() {
		System.out.println(g.toJson(df.readAll()));
	}
static void conex() {
	if(Conexion.getConexion()!=null) {
		System.out.println(1);
	}
}



}
