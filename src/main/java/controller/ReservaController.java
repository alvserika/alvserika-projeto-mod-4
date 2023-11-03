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
import dao.PacotesDAO;
import dao.ReservaDAO;
import dao.UsuarioDAO;
import model.Destinos;
import model.Pacotes;
import model.Reserva;
import model.Usuario;

@WebServlet( urlPatterns = {"/reserva", "/reserva-save", "/reserva-delete"})
public class ReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReservaDAO rDao = new ReservaDAO();
	UsuarioDAO uDao = new UsuarioDAO();
	PacotesDAO pDao = new PacotesDAO();
	DestinosDAO dDao = new DestinosDAO();
    public ReservaController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Usuario> usuarios = uDao.read();
		List <Pacotes> pacotes = pDao.read();
		List <Destinos> destinos = dDao.read();
		
		request.setAttribute("destinos", destinos);
		request.setAttribute("usuarios", usuarios);
		request.setAttribute("pacotes", pacotes);
		
		String route = request.getServletPath();
		switch(route) {
		case "/reserva":
			read(request, response);
			break;
		case "/reserva-save":
			save(request, response);	
			break;
			
		case "/reserva-delete":
			delete(request, response);
			break;
			default:
			response.sendRedirect("/tde/html/index.html");
			break;
		}
	}
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Reserva> reservas = rDao.read();
		request.setAttribute("reservas", reservas);
		RequestDispatcher rd = request.getRequestDispatcher("./reservas.jsp");
		rd.forward(request, response);
	}
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reserva reserva = new Reserva();
		if(request.getParameter("id") != null) {
			reserva.setIdReserva(Integer.parseInt(request.getParameter("id")));
		}
		reserva.setDtCheckout(request.getParameter("checkout"));
		reserva.setDtCheckIn(request.getParameter("checkin"));
		reserva.setStatusReserva(Boolean.parseBoolean(request.getParameter("status")));
		int idUsuario = Integer.parseInt(request.getParameter("usuario"));
		int idPacote = Integer.parseInt(request.getParameter("pacote"));
		int idDestino = Integer.parseInt(request.getParameter("destino"));
		
		reserva.setUsuario(uDao.readById(idUsuario));
		reserva.setPacotes(pDao.readById(idPacote));
		reserva.setDestinos(dDao.readById(idDestino));
		rDao.save(reserva);
		response.sendRedirect("/reservas");
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		rDao.delete(id);
		response.sendRedirect("./reservas.jsp");
	}

}
