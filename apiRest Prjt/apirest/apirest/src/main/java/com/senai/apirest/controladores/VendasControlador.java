
package com.senai.apirest.controladores;

import com.senai.apirest.entidades.MsgRetorno;
import com.senai.apirest.entidades.Vendas;
import com.senai.apirest.servicos.VendaSevico;
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
public class VendasControlador {
    
    @Autowired
    VendaSevico vendasservico;
    
    
    @CrossOrigin(origins = "*")
    @GetMapping("/vendas/{id}")
    public ResponseEntity<Object> consultaVendas(@PathVariable(value = "id") Long idVendas){
        
        Optional<Vendas> vendas = vendasservico.consultarVendas(idVendas);
        if(vendas.isPresent()){
            return new ResponseEntity<>(vendas.get(), HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Consultar Vendas");
            erro.setDescrição("Erro ao consultar Vendas ID: " + idVendas );
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);            
        }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/vendas", consumes = {"application/json"})
    public ResponseEntity<Object> incluirVendas(@Valid @RequestBody Vendas vendas){
        
        Long idVen = vendasservico.incluirVendas(vendas);
        if(idVen != null && idVen > 0){
            return new ResponseEntity<>(idVen, HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Incluir Vendas");
            erro.setDescrição("Erro ao incluir Vendas! Chame a TI!!");
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);            
        }
    }
  
@CrossOrigin(origins = "*")
    @PutMapping("/vendas")
    public ResponseEntity<Object> atualizarVendas( @Valid @RequestBody Object atualizaVen )
    {
        MsgRetorno msg = new MsgRetorno();
        msg.setFuncao("Atualizar Vendas");
        Long idVen = vendasservico.atualizarCliente(atualizaVen);
        if(idVen !=null && idVen > 0){
            msg.setDescrição("Vendas IdVendas ("+ idVen + ") atualizado com sucesso!");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
            msg.setDescrição("Vendas IdVendas ("+ idVen + ") Erro ao atualizar Vendas.");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }    
    
@CrossOrigin(origins = "*")
    @DeleteMapping("/vendas/{id}")
    public ResponseEntity<Object> excluirVendas(@PathVariable(value = "id") long id){
        
        MsgRetorno msg = new MsgRetorno();
        msg.setFuncao("Excluir vendas");
        if ( vendasservico.excluirVendas(id) ){
            msg.setDescrição("Vendas IdVendas ("+ id + ") excluído com sucesso!");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } else {
            msg.setFuncao("Excluir Vendas");
            msg.setDescrição("Erro ao excluir Vendas IdVendas("+id+"), não cadastrado/inexistente!");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
    }    
    
@CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/vendas")
    public ResponseEntity<Long> novoCliente(@Valid @RequestBody Object obj) {
    	Long IDnovo = vendasservico.incluirVendas((Vendas) obj);
        return new ResponseEntity<>(IDnovo, HttpStatus.OK);
    }    
  
}
