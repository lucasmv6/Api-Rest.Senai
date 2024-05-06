package com.senai.apirest.servicos;

import com.senai.apirest.entidades.Produto;
import com.senai.apirest.repositorios.ProdutoRepositorio;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServico {
    
    @Autowired
    private ProdutoRepositorio produtoRepositorio;
 
    
   public Long IncluirProduto (Produto produto){
       
       return produtoRepositorio.save(produto).getIDProduto ();
       
   }
   public Boolean excluirProduto(Long idProduto){
   
        try{
            produtoRepositorio.deleteById(idProduto);
            return true;
        } catch(Exception ex){
            System.out.println("Erro ao excluir"
                             + "  ID: " + idProduto
                             + " Erro: " + ex.getLocalizedMessage());
            return false;
        }
   }
   public Optional<Produto> consultarProduto(Long idProduto){
        
        return produtoRepositorio.findById(idProduto);
    }
   public List<Produto> listarProduto(){
        
        return produtoRepositorio.findAll();
    }
   @Transactional
   public Boolean atualizarProduto(Produto produto) {
        
        Produto pro = produtoRepositorio.getReferenceById(produto.getIDProduto());
        if( pro != null) {
            pro.setDescricaoProduto(produto.getDescricaoProduto());
            pro.setIDProduto(produto.getIDProduto());
            pro.setNomeProduto(produto.getNomeProduto());
            pro.setValorProduto(produto.getValorProduto());
            pro.setVendasProduto(produto.getVendasProduto());
            produtoRepositorio.save(pro);
            return true;
        } else {
            return false;            
    }
   
   
}

    public Long incluirProduto(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Long atualizarProduto(Object atualizaPro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}