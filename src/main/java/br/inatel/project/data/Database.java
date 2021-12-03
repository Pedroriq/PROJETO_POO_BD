package br.inatel.project.data;

import javax.xml.crypto.Data;
import java.sql.*;

public abstract class Database {
    Connection connection;
    Statement statement;
    ResultSet result;
    PreparedStatement pst;

    static final String aluno = "root";
    static final String database = "store";
    private String resultadoDaConexao;

    // string com URL de conexão com servidor
    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    public boolean check = false;

    public boolean connect(String password){
        try {
            connection = DriverManager.getConnection(url, aluno, password);
            resultadoDaConexao = "Conexão feita com sucesso: "+ connection;
            return true;
        }catch (SQLException e){
            resultadoDaConexao = "Erro de conexão: " + e.getMessage();
            return false;

        }
    }
}
