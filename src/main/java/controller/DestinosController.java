package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinosDAO;
import model.Destinos;


@WebServlet( urlPatterns = {"/html/destinos", "/destinos-save", "/destinos-delete"})
public class DestinosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DestinosDAO dDao = new DestinosDAO();
    public DestinosController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String route = request.getServletPath();
		switch(route) {
		case "/html/destinos":
			read(request, response);
			break;
		case "/destinos-save":
			save(request, response);	
			break;
			
		case "/destinos-delete":
			delete(request, response);
			break;
			default:
			response.sendRedirect("/tde/html/index.html");
			break;
		}
	}
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Destinos> destinos = dDao.read();
		request.setAttribute("destinos", destinos);
		RequestDispatcher rd = request.getRequestDispatcher("./destinos.jsp");
		rd.forward(request, response);
	}
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Destinos destino = new Destinos();
		if(request.getParameter("id") != null) {
			destino.setIdDestino(Integer.parseInt(request.getParameter("id")));
		}
		destino.setNomeDestino(request.getParameter("nome"));
		destino.setAvaliacao(Integer.parseInt(request.getParameter("avaliacao")));
		dDao.save(destino);
		response.sendRedirect("/tde/html/destinos");
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dDao.delete(id);
		response.sendRedirect("/tde/html/destinos");
	}

}
