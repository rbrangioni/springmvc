package br.com.springmvc.controller;

import br.com.springmvc.dao.CadastroDAO;
import br.com.springmvc.dominio.Cadastro;
import com.google.gson.Gson;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author raphael.brangioni
 */
@Controller

public class IniciandoController {

    @RequestMapping("/bem-vindo")
    public String iniciando() {
        return "index";
    }

    @RequestMapping("/confirm")
    public String registrado(Model model, Cadastro cadastro) {
        
        CadastroDAO dao = new CadastroDAO();
        
        try {
            dao.adiciona(cadastro);

            model.addAttribute("retorno", cadastro.getNome());
        } catch (SQLException e) {
            System.out.println(e);

        }
        return "registrado";
    }

    @RequestMapping("/cadastro")
    public String cadastro() {

        return "cadastro";
    }

    @RequestMapping("/lista")
    public String lista(Model model) throws SQLException {

        CadastroDAO dao = new CadastroDAO();
        //System.out.println(dao.busca());
        try {
            model.addAttribute("lista", dao.busca());
        } catch (Exception e) {
        }
        return "exibir";
    }
    
    @RequestMapping("/retorno")
    public @ResponseBody String retorno() throws SQLException{
        
    CadastroDAO dao = new CadastroDAO();
     Gson gson = new Gson();
     
     String retorno = gson.toJson(dao.busca());
     
     return retorno;
}

}
