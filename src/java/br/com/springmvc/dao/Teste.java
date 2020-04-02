package br.com.springmvc.dao;

import br.com.springmvc.dominio.Cadastro;
import java.sql.SQLException;

public class Teste {

    public static void main(String[] args) {

        Cadastro cad = new Cadastro();
        CadastroDAO dao = new CadastroDAO();


        cad.setNome("Raphael Brangioni 0000000000");
        cad.setEndereco("Rua Dorival Castilhos Machado, 116, Hípica");
        cad.setTelefone(981326644);
        cad.setEmail("raphaelbrangioni@gmail.com");
        try {

            dao.adiciona(cad);
            System.out.println(" Registro Inserido com Sucesso!");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

}
