
package com.senai.apirest.controladores;

import com.senai.apirest.entidades.MsgRetorno;
import com.senai.apirest.entidades.VendasProduto;
import com.senai.apirest.servicos.VendasProdutoServico;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendasProdutoControlador {
    
    @Autowired
    VendasProdutoServico vendasprodutoservico;
    
    @CrossOrigin(origins = "*")
    @GetMapping("/vendasproduto/{id}")
    public ResponseEntity<Object> consultaVendasProduto(@PathVariable(value = "id") Long idVendasProduto){
        
        Optional<VendasProduto> vendasproduto = vendasprodutoservico.consultarVendasProduto(idVendasProduto);
        if(vendasproduto.isPresent()){
            return new ResponseEntity<>(vendasproduto.get(), HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Consultar VendasProduto");
            erro.setDescrição("Erro ao consultar VendasProduto ID: " + idVendasProduto );
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);            
        }
    }
  
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/vendasproduto", consumes = {"application/json"})
    public ResponseEntity<Object> incluirVendasProduto(@Valid @RequestBody VendasProduto vendasproduto){
        
        Long idVenP = vendasprodutoservico.incluirVendasProduto(vendasproduto);
        if(idVenP != null && idVenP > 0){
            return new ResponseEntity<>(idVenP, HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Incluir VendasProduto");
            erro.setDescrição("Erro ao incluir VendasProduto! Chame a TI!!");
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);            
        }
    }
  
@CrossOrigin(origins = "*")
    @PutMapping("/VendasProduto")
    public ResponseEntity<Object> atualizarVendasProduto( @Valid @RequestBody Object atualizaVenP )
    {
        MsgRetorno msg = new MsgRetorno();
        msg.setFuncao("Atualizar VendasProduto");
        Long idVenP = vendasprodutoservico.atualizarVendasProduto(atualizaVenP);
        if(idVenP !=null && idVenP > 0){
            msg.setDescrição("VendasProduto IdVendasProduto ("+ idVenP + ") atualizado com sucesso!");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
            msg.setDescrição("VendasProduto IdVendasProduto ("+ idVenP + ") Erro ao atualizar VendasProduto.");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }    
    
    
@CrossOrigin(origins = "*")
    @DeleteMapping("/VendasProduto/{id}")
    public ResponseEntity<Object> excluirVendasProduto(@PathVariable(value = "id") long id){
        
        MsgRetorno msg = new MsgRetorno();
        msg.setFuncao("Excluir cliente");
        if ( vendasprodutoservico.excluirVendasProduto(id) ){
            msg.setDescrição("VendasProduto IdCVendasProduto ("+ id + ") excluído com sucesso!");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } else {
            msg.setFuncao("Excluir VendasProduto");
            msg.setDescrição("Erro ao excluir VendasProduto IdVendasProduto("+id+"), não cadastrado/inexistente!");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
    }    
    
@CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/VendasProduto")
    public ResponseEntity<Long> novoVendasProduto(@Valid @RequestBody Object obj) {
    	Long IDnovo = vendasprodutoservico.incluirVendasProduto((VendasProduto) obj);
        return new ResponseEntity<>(IDnovo, HttpStatus.OK);
    }    
    
    
    
    
    
    
    
    
    
}
