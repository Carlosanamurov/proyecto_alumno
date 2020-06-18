package pe.edu.upeu.ejercicio.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.edu.upeu.ejercicio.dao.AlumnoDao;
import pe.edu.upeu.ejercicio.entity.Alumno;
import pe.edu.upeu.ejercicio.util.Conexion;


public class AlumnoDaoImp implements AlumnoDao {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public int create(Alumno u) {
		// TODO Auto-generated method stub
		int x = 0;
		String sql ="INSERT INTO alumno (idalumno, idescuela, nombre_com, correo, telefono) VALUES (NULL, ?, ?, ?, ?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, u.getIdescuela());
			ps.setString(2, u.getNombre_com());
			ps.setString(3, u.getCorreo());
			ps.setString(4, u.getTelefono());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}
	@Override
	public int update(Alumno u) {
		// TODO Auto-generated method stub
		int x = 0;
		String sql = "UPDATE alumno SET idescuela = ?, nombre_com = ?, correo = ?, telefono = ? WHERE idalumno = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, u.getIdescuela());
			ps.setString(2, u.getNombre_com());
			ps.setString(3, u.getCorreo());
			ps.setString(4, u.getTelefono());
			ps.setInt(5, u.getIdalumno());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		int x = 0;
		// TODO Auto-generated method stub
		String sql= "DELETE FROM alumno WHERE idalumno= ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return x;
	}
	@Override
	public List<Map<String, Object>> read(int id) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<>();
		String sql = "select e.idescuela, e.nom_escuela, "+
		             "a.idalumno, a.nombre_com, "+ 
				     "a.correo, a.telefono from alumno as a,"+
		             " escuela as e where e.idescuela = a.idescuela and a.idalumno=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String, Object>();
                map.put("idescuela", rs.getInt("idescuela"));
                map.put("nom_escuela", rs.getString("nom_escuela"));
                map.put("idalumno", rs.getInt("idalumno"));
                map.put("nombre_com", rs.getString("nombre_com"));
                map.put("correo", rs.getString("correo"));
                map.put("telefono", rs.getString("telefono"));
			    list.add(map);
			    
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<>();
		String sql = "select e.idescuela, e.nom_escuela, "+
	             "a.idalumno, a.nombre_com, "+ 
			     "a.correo, a.telefono from alumno as a,"+
	             " escuela as e where e.idescuela = a.idescuela";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String, Object>();
                map.put("idescuela", rs.getInt("idescuela"));
                map.put("nom_escuela", rs.getString("nom_escuela"));
                map.put("idalumno", rs.getInt("idalumno"));
                map.put("nombre_com", rs.getString("nombre_com"));
                map.put("correo", rs.getString("correo"));
                map.put("telefono", rs.getString("telefono"));
			    list.add(map);
			    
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	

}
