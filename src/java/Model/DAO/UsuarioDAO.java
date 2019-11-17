package Model.DAO;

import Model.Entity.Usuario;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    
    public void Criar (Usuario usuario) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement comand = con.prepareStatement("insert into usuario (id,nome,cnpj,email,senha) values (nextval('seq_usuario'),?,?,?,?");
        comand.setString(1,usuario.getNome());
        comand.setString(2, usuario.getCpnj());
        comand.setString(3, usuario.getEmail());
        comand.setString(4, usuario.getSenha());
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
}
