package edu.basicoServlet.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class indexServlet
 */
//Al extender de la clase HttpServlet puede ejecutarse en el lado del
//servidor y aceptar peticiones del lado cliente.

@WebServlet(name="operar", urlPatterns={"/operar"})
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    //Los métodos get y post permiten recibir peticiones del lado del cliente,
    //según se indique.
    //El parámetro request trae al lado servidor información del lado cliente.
    //El parámetro response lleva al lado cliente información del lado servidor.
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uno = request.getParameter("textUno");
		String dos = request.getParameter("textDos");
		int nUno = Integer.parseInt(uno);
		int nDos = Integer.parseInt(dos);
		String btnSumar = request.getParameter("btnSumar");
		String btnRestar = request.getParameter("btnRestar");
		int resultado = 0;
		
		if(btnSumar!=null) {
			resultado = nUno + nDos;
		}
		if(btnRestar!=null) {
			resultado = nUno - nDos;
		}
		//Opción request: solo vive durante la petición.
		request.setAttribute("resultadoOperacion", resultado);
		//Opción session: vive durante la sesión.
		request.getSession().setAttribute("resultadoOperacionS", resultado);
		//Opción context: vive durante el tiempo de vida del servlet.
		getServletContext().setAttribute("resultadoOperacionC", resultado);
		
		RequestDispatcher  rd;
		rd = request.getRequestDispatcher("/resultado.jsp");
		rd.forward(request, response);
		
	}

}
