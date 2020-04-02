package br.com.springmvc.dao;

import br.com.springmvc.dominio.Cadastro;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class CadastroDAO {
    
   public EntityManager getEM(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringMVCPU");
        
        return factory.createEntityManager();
    }


    public void adiciona(Cadastro cad) throws SQLException {
        

//        Conexao conn = new Conexao();
//
//        String sql = "insert into cadastro( nome, endereco, telefone, email) values (?, ?, ?, ?)";
//
//        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
//        
//        System.out.println("nome: "+cad.getNome());
//
//        ps.setString(1, cad.getNome());
//        ps.setString(2, cad.getEndereco());
//        ps.setInt(3, cad.getTelefone());
//        ps.setString(4, cad.getEmail());
//        ps.execute();
//        conn.desconecta();

           EntityManager em = getEM();
           em.getTransaction().begin();
           em.persist(cad);
           em.getTransaction().commit();
           em.close();

    }

    public List<Cadastro> busca() throws SQLException {
        //List<Cadastro> lista = new ArrayList<>();

//        Conexao conn = new Conexao();
//
//        String sql = "select nome, endereco, telefone, email, id_cadastro from cadastro";
//
//        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            Cadastro cad = new Cadastro();
//
//            cad.setId(rs.getInt("id_cadastro"));
//            cad.setNome(rs.getString("nome"));
//            cad.setEndereco(rs.getString("endereco"));
//            cad.setTelefone(rs.getInt("telefone"));
//            cad.setEmail(rs.getString("email"));
//
//            //System.out.println("cad "+cad.getId());
//            lista.add(cad);
//        }

        EntityManager em = getEM();
        
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Cadastro.class));
         List<Cadastro> lista = em.createQuery(criteria).getResultList();
         
        return lista;

    }
}
