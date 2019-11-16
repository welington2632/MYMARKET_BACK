package Model.DAO;

import Model.Entity.Endereco;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDAO {
    
    public void Criar(Endereco endereco) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement comand = con.prepareStatement("insert into endereco (id, logradouro, cep, numero, complemento) values (nextval('seq_endereco'),?,?,?,?");
        comand.setString(1, endereco.getLogradouro());
        comand.setString(2, endereco.getCep());
        comand.setInt(3, endereco.getNumero());
        comand.setString(4, endereco.getComplemento());
        comand.execute();
        con.close();
    }
}
