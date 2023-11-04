package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet( urlPatterns = {"/html/usuario", "/usuario-save", "/usuario-delete"})
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UsuarioDAO uDao = new UsuarioDAO();
    public UsuarioController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String route = request.getServletPath();
		switch(route) {
		case "/html/usuario":
			read(request, response);
			break;
		case "/usuario-save":
			save(request, response);	
			break;
			
		case "/usuario-delete":
			delete(request, response);
			break;
			default:
			response.sendRedirect("/tde/html/index.html");
			break;
		}
	}
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Usuario> usuarios = uDao.read();
		request.setAttribute("usuarios", usuarios);
		RequestDispatcher rd = request.getRequestDispatcher("./usuario.jsp");
		rd.forward(request, response);
	}
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Usuario usuario = new Usuario();
	if(request.getParameter("id") != null) {
		usuario.setIdUsuario(Integer.parseInt(request.getParameter("id")));
	}
	usuario.setNome(request.getParameter("nome"));
	usuario.setEmail(request.getParameter("email"));
	usuario.setCpf(request.getParameter("cpf"));
	usuario.setSenha(request.getParameter("senha"));
	usuario.setLocalizacao(request.getParameter("localizacao"));
	uDao.save(usuario);
	response.sendRedirect("/tde/html/usuario");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		uDao.delete(id);
		response.sendRedirect("/tde/html/usuario");
	}
}
