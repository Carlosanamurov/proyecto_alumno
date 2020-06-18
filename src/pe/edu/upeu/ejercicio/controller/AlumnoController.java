package pe.edu.upeu.ejercicio.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.ejercicio.dao.AlumnoDao;
import pe.edu.upeu.ejercicio.dao.EscuelaDao;
import pe.edu.upeu.ejercicio.daoImp.AlumnoDaoImp;
import pe.edu.upeu.ejercicio.daoImp.EscuelaDaoImp;
import pe.edu.upeu.ejercicio.entity.Alumno;





/**
 * Servlet implementation class AlumnoController
 */
@WebServlet("/AlumnoController")
public class AlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlumnoDao pd1 = new AlumnoDaoImp();
	private EscuelaDao cd = new EscuelaDaoImp();
	private Gson g = new Gson();
	int ida, ides; String alum,telefono,correo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("opc"));
		switch(op) {
		case 1: //
				out.println(g.toJson(cd.readAll()));
				break;
		case 2: //
			out.println(g.toJson(pd1.readAll()));
		    break;
		case 3: //
			
			pd1.create(new Alumno(0,
					Integer.parseInt(
							request.getParameter("esc")),
					        request.getParameter("nom"),
					        request.getParameter("correo"),
					        request.getParameter("tel")));
							out.println(g.toJson("Registro guardado correctamente"));
			
			break;
		case 4: //
			out.println(g.toJson(pd1.read(Integer.parseInt(request.getParameter("id")))));
			break;
		case 5: //
			int x = pd1.delete(Integer.parseInt(request.getParameter("id")));
			out.println(g.toJson(x));
			break;	
		case 6: //
			ida = Integer.parseInt(request.getParameter("ida"));
			ides = Integer.parseInt(request.getParameter("ides"));
			alum = request.getParameter("alum");
			correo =request.getParameter("correo");				
			telefono = request.getParameter("telefono");
			out.println(g.toJson(pd1.update(new Alumno(ida, ides, alum, correo, telefono))));
			
			break;	
				}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
