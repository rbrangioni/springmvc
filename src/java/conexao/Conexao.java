package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

public class Conexao {

    private Connection conn;

    private void conectar() {
        System.out.println("Conectando ao Banco de Dados");
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SpringMVC", "postgres", "admin");
            System.out.println("Conectado");

        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrada!");
            java.util.logging.Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Connection getConexao() {
        conectar();
        return conn;
    }

    public void desconecta() {
        try {
            conn.close();
            //JOptionPane.showMessageDialog(null, "Desconectado do Banco de Dados(Postgres)");
        } catch (SQLException ex) {
            System.out.println("Erro ao Desconectar do Banco de Dados");
        }

    }

}
