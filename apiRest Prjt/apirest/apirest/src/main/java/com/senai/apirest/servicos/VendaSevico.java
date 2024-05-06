package com.senai.apirest.servicos;

import com.senai.apirest.entidades.Cliente;
import com.senai.apirest.entidades.Vendas;
import com.senai.apirest.entidades.VendasProduto;
import com.senai.apirest.repositorios.VendasRepositorio;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaSevico {
    
    @Autowired
    private VendasRepositorio vendasrepositorio;
    
    @Autowired
    private ClienteServico clisrv;
    
    public Long IncluirVendas (Vendas vendas,Long IDCliente){
        Optional<Cliente> cli = clisrv.consultarCliente(IDCliente);
        if(cli.isPresent()){
            vendas.setCliente(cli.get());
        }
        Integer status = vendas.getStatus();
        if( status > 0 ){
       return vendasrepositorio.save(vendas).getIDVendas ();
   }else{
        return null;
        }
        
        
    }
    public Boolean excluirVendas(Long idVendas){
        
    try{
     vendasrepositorio.deleteById(idVendas);
   return true;
   } catch(Exception ex){
   System.out.println("Erro ao excluir"
                      + "  ID: " + idVendas
                      + " Erro: " + ex.getLocalizedMessage());
   return false;
 }
}

public Optional<Vendas> consultarVendas(Long idVendas){
        
        return vendasrepositorio.findById(idVendas);
}
public List<Vendas> listarVendas(){
        
        return vendasrepositorio.findAll();
}
@Transactional
public Boolean atualizarVendas(Vendas vendas) {
        
        Vendas ven = vendasrepositorio.getReferenceById(vendas.getIDVendas());
        if( ven != null) {
            ven.setCliente(vendas.getCliente());
            ven.setIDVendas(vendas.getIDVendas());
            ven.setStatus(vendas.getStatus());
            ven.setVendasProduto(vendas.getVendasProduto());
           vendasrepositorio.save(ven);
          return true;
        } else {
            return false;            
    }
        
  }

    public Long incluirVendas(Vendas vendas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Long atualizarCliente(Object atualizaVen) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Long IncluirVendasProduto(VendasProduto vendasProduto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}