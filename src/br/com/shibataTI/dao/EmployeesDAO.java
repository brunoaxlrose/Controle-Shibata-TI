package br.com.shibataTI.dao;

import br.com.shibataTI.jdbc.ConnectionFactory;
import br.com.shibataTI.view.FormScreenLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class EmployeesDAO {

    private Connection conexao;

    public EmployeesDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }
    
    //Método para efetuar login

    public boolean efetuarLogin(String usuario, String senha) {
        try {
            //SQL
            String sql = "select * from tb_funcionarios where usuario=? and senha=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            //Organizar em cada ponto de interrogação.
            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            //Verificar se o resultado da consulta contém uma linha
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Seja bem-vindo");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
                return false;
            }
        } catch (SQLException erroSQL) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + erroSQL);
            return false;
        }
    }

}
