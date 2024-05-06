
package com.senai.apirest.servicos;

import com.senai.apirest.entidades.VendasProduto;
import com.senai.apirest.repositorios.VendasProdutoRepositorio;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendasProdutoServico {
    
    @Autowired
    private VendasProdutoRepositorio vendasProdutoRepositorio;
    
    
     public Long IncluirVendasProduto (VendasProduto vendasProduto){
       return vendasProdutoRepositorio.save(vendasProduto).getIDVendasProduto ();
   }
     public Boolean excluirVendasProduto(Long idVendasProduto){
        
    try{
     vendasProdutoRepositorio.deleteById(idVendasProduto);
   return true;
   } catch(Exception ex){
   System.out.println("Erro ao excluir"
                      + "  ID: " + idVendasProduto
                      + " Erro: " + ex.getLocalizedMessage());
   return false;
 }
}
     
    public Optional<VendasProduto> consultarVendasProduto(Long idVendasProduto){
        
        return vendasProdutoRepositorio.findById(idVendasProduto);
}
    public List<VendasProduto> listarVendasProduto(){
        
        return vendasProdutoRepositorio.findAll();
    }
    @Transactional
    public Boolean atualizarVendas(VendasProduto vendasProduto) {
        
        VendasProduto venp = vendasProdutoRepositorio.getReferenceById(vendasProduto.getIDVendasProduto());
        if( venp != null) {
            venp.setIDVendasProduto(vendasProduto.getIDVendasProduto());
            venp.setProduto(vendasProduto.getProduto());
            venp.setQtdProduto(vendasProduto.getQtdProduto());
            venp.setValorProduto(vendasProduto.getValorProduto());
            venp.setVendas(vendasProduto.getVendas());
           vendasProdutoRepositorio.save(venp);
            return true;
        } else {
            return false;            
    }
}

    public Long incluirVendasProduto(VendasProduto vendasproduto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Long atualizarVendasProduto(Object atualizaVenP) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
