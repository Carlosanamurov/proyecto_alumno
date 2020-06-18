package pe.edu.upeu.ejercicio.entity;

public class Alumno {
	private int idalumno;
	private int idescuela;
	private String nombre_com;
	private String correo;
	private String telefono;
	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alumno(int idalumno, int idescuela, String nombre_com, String correo, String telefono) {
		super();
		this.idalumno = idalumno;
		this.idescuela = idescuela;
		this.nombre_com = nombre_com;
		this.correo = correo;
		this.telefono = telefono;
	}
	public int getIdalumno() {
		return idalumno;
	}
	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}
	public int getIdescuela() {
		return idescuela;
	}
	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}
	public String getNombre_com() {
		return nombre_com;
	}
	public void setNombre_com(String nombre_com) {
		this.nombre_com = nombre_com;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

}
