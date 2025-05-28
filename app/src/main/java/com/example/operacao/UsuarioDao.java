package com.example.operacao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class UsuarioDao {
    Connection connect;

    public Usuario selecionarUsuario(String email, String senha) {
        try {
            conexao connectionHelper = new conexao();
            connect = connectionHelper.CONN();
            if (connect != null) {
                String qu = "SELECT * FROM mra010 WHERE email = '"+email+"' and senha = '"+senha+"'";
                Statement statemente = connect.createStatement();
                ResultSet resultSet = statemente.executeQuery(qu);
                while (resultSet.next()){
                    Usuario usu = new Usuario();
                    usu.setId(resultSet.getInt(1));
                    usu.setEmail(resultSet.getString(4));
                    usu.setSenha(resultSet.getString(3));

                    connect.close();
                    return usu;
                }


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}