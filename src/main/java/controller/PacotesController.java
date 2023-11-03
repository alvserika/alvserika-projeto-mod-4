package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacotesDAO;
import model.Pacotes;

@WebServlet( urlPatterns = {"/pacotes", "/pacotes-save", "/pacotes-delete"})
public class PacotesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PacotesDAO pDao = new PacotesDAO();
    public PacotesController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String route = request.getServletPath();
		switch(route) {
		case "/pacotes":
			read(request, response);
			break;
		case "/pacotes-save":
			save(request, response);	
			break;
			
		case "/pacotes-delete":
			delete(request, response);
			break;
			default:
				response.sendRedirect("/tde/html/index.html");
			break;
		}
	}
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Pacotes> pacotes = pDao.read();
		request.setAttribute("pacotes", pacotes);
		RequestDispatcher rd = request.getRequestDispatcher("./pacotes.jsp");
		rd.forward(request, response);
	}
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pacotes pacote = new Pacotes();
		if(request.getParameter("id") != null) {
			pacote.setIdPacote(Integer.parseInt(request.getParameter("id")));
		}
		pacote.setDescPacote(Double.parseDouble(request.getParameter("desconto")));
		pacote.setValorPacote(Double.parseDouble(request.getParameter("valor")));
		pDao.save(pacote);
		response.sendRedirect("/pacote");
		}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		pDao.delete(id);
		response.sendRedirect("./pacotes.jsp");
	}

}
