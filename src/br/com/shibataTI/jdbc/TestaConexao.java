package br.com.shibataTI.jdbc;

import javax.swing.JOptionPane;

public class TestaConexao {

    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
        } catch (Exception erroSql) {
            JOptionPane.showMessageDialog(null, "Algum erro ao se conectar ao banco." + erroSql);
        }
    }
}
