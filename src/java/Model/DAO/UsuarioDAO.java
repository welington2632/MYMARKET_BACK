package Model.DAO;

import Model.Entity.TipoUsuario;
import Model.Entity.Usuario;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    
    public void Cadastrar (Usuario usuario) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement comand = con.prepareStatement("insert into usuario (id, nome, cnpj, email, senha,tipousuariofk) values (nextval('seq_usuario'),?,?,?,?)");
        comand.setString(1,usuario.getNome());
        comand.setString(2, usuario.getCpnj());
        comand.setString(3, usuario.getEmail());
        comand.setString(4, usuario.getSenha());
        comand.setInt(5, TipoUsuario.COMUM.hashCode());
        comand.execute();
        con.close();
    }
    
    public void Alterar (Usuario usuario) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement comand = con.prepareStatement("update usuario set nome = ?, cnpj = ?, email = ?, senha = ?, enderecofk = ?, tipousuariofk = ? WHERE id = ?");
        comand.setString(1, usuario.getNome());
        comand.setString(2, usuario.getCpnj());
        comand.setString(3, usuario.getEmail());
        comand.setString(4, usuario.getSenha());
        comand.setInt(5, usuario.getEndereco().getId());
        comand.setInt(6, usuario.getTipo().hashCode());
        comand.setInt(7, usuario.getId());
    }
    
    public Usuario ConsultarPorEmail(Usuario usuario) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement comand = con.prepareStatement("select * from usuario where email = ?");
        comand.setString(1, usuario.getEmail());
        ResultSet resultado = comand.executeQuery();
        Usuario usuarioConsultado = new Usuario();
        if (resultado.next()){
            usuarioConsultado.setId(Integer.parseInt(resultado.getString("id")));
            usuarioConsultado.setNome(resultado.getString("nome"));
            usuarioConsultado.setCnpj(resultado.getString("cnpj"));
            usuarioConsultado.setTipo(TipoUsuario.values()[resultado.getInt("tipousuariofk")]);
            usuarioConsultado.setEmail(usuario.getEmail());
            usuarioConsultado.setSenha(usuario.getSenha());
        }
        con.close();
        return usuarioConsultado;
    }
    
    public boolean Validar (Usuario usuario) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement comand = con.prepareStatement("select * from usuario where email = ?");
        comand.setString(1, usuario.getEmail());
        ResultSet result = comand.executeQuery();
        boolean validado = false;
        if (result.next()){
            if (result.getString("senha").equals(usuario.getSenha())){
                validado = true;
            }
        }
        con.close();
        return validado;
    }
}
