package com.zubiri.FormularioExamen;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Servlet implementation class Anadir
 */
public class Anadir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Anadir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int nacimiento = Integer.parseInt(request.getParameter("ano"));
		
		try {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			
			
			out.println("<html>");
			out.println("<head><title>Respuesta</title>");
			out.println("<body>");
			out.println("<h1>persona del formulario</h1>");
			out.println("<p>dni: " +dni+"</p>");
			out.println("<p>nombre: " +nombre+"</p>");
			out.println("<p>apellido: " +apellido+"</p>");
			out.println("<p>año de nacimiento: " +nacimiento+"</p>");
			
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Connecting to database...");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "zubiri");
			Statement sentencia = conexion.createStatement();
			System.out.println("sentencia creada");
			
			sentencia.executeUpdate("create database if not EXISTS Formulario;");
			System.out.println("database creada");
			sentencia.executeUpdate("use Formulario;");
			
			sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS persona"
					+ "(dni varchar (9) primary key,"
					+"nombre varchar(15),"
					+"apellido varchar(15),"
					+"añoNacimiento int(4));");
			System.out.println("tabla creada...");
			
			sentencia.executeUpdate("insert into persona (dni, nombre, apellido, añoNacimiento)"
					+ "VALUES ('"+dni+"','"+nombre+"','"+apellido+"','"+nacimiento+"')");
				
			out.println("<p>ha sido insertado en la base de datos correctamente</p>");
			out.println("</body></html>");
		}
		catch(Exception e){
			System.out.println("aqui hay un problema " + e);
		}
		
	}

}
