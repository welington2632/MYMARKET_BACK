package Controller;

import Model.DAO.EnderecoDAO;
import Model.DAO.UsuarioDAO;
import Model.Entity.Endereco;
import Model.Entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/CadastrarUsuario",
    "/ConsultarUsuario",
    "/AtualizarUsuario",
    "/DeletarUsuario",
    "/Logar"})

public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/CadastrarUsuario")) {
            Cadastrar(request, response);
        } else if (uri.equals(request.getContextPath() + "/Logar")) {
            Logar(request, response);
        }
    }

    public void Cadastrar(HttpServletRequest request, HttpServletResponse response) {
        try {
            Usuario usuario = new Usuario();
            usuario.setNome(request.getParameter("nome"));
            usuario.setCnpj(request.getParameter("cnpj"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setSenha(request.getParameter("senha"));
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.Cadastrar(usuario);
            request.getSession(true).setAttribute("usuario_logado", usuario);
            request.getRequestDispatcher("user_area.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Logar(HttpServletRequest request, HttpServletResponse response) {
        try {
            Usuario usuario = new Usuario();
            usuario.setEmail(request.getParameter("email"));
            usuario.setSenha(request.getParameter("senha"));
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (usuarioDAO.Validar(usuario)) {
                usuario = usuarioDAO.ConsultarPorEmail(usuario);
                request.getSession(true).setAttribute("usuario_logado", usuario);
                request.getRequestDispatcher("user_area.jsp").forward(request, response);

            }
            request.getSession(true).setAttribute("usuario_logado", usuario);
            request.getRequestDispatcher("user_area.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AtualizarUsuario(HttpServletRequest request, HttpServletResponse response) {
        try {
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(request.getParameter("id_usuario")));
            usuario.setNome(request.getParameter("nome"));
            usuario.setCnpj(request.getParameter("cnpj"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setSenha(request.getParameter("senha"));
            usuario.setEndereco(new Endereco(Integer.parseInt(request.getParameter("id_endereco")), request.getParameter("logradouro"), request.getParameter("cep"), Integer.parseInt(request.getParameter("numero")), request.getParameter("complemento")));
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            //usuarioDAO.atualizar(usuario);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
