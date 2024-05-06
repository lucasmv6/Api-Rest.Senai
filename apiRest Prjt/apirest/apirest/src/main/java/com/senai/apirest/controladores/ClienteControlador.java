package com.senai.apirest.controladores;

import com.senai.apirest.entidades.Cliente;
import com.senai.apirest.entidades.MsgRetorno;
import com.senai.apirest.servicos.ClienteServico;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class ClienteControlador {
    
    @Autowired
    ClienteServico clienteservico;
    
    //GET  http://localhost:8010/apiweb/cliente/12
    
    @CrossOrigin(origins = "*")
    @GetMapping("/cliente/{id}")
    public ResponseEntity<Object> consultaCliente(@PathVariable(value = "id") Long idCliente){
        
        Optional<Cliente> cliente = clienteservico.consultarCliente(idCliente);
        if(cliente.isPresent()){
            return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Consultar Cliente");
            erro.setDescrição("Erro ao consultar Cliente ID: " + idCliente );
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);            
        }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/cliente", consumes = {"application/json"})
    public ResponseEntity<Object> incluirCliente(@Valid @RequestBody Cliente cliente){
        
        Long idCli = clienteservico.incluirCliente(cliente);
        if(idCli != null && idCli > 0){
            return new ResponseEntity<>(idCli, HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Incluir Cliente");
            erro.setDescrição("Erro ao incluir Cliente! Chame a TI!!");
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);            
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/cliente")
    public ResponseEntity<Object> atualizarCliente( @Valid @RequestBody Object atualizaCli )
    {
        MsgRetorno msg = new MsgRetorno();
        msg.setFuncao("Atualizar Cliente");
        Long idCli = clienteservico.atualizarCliente(atualizaCli);
        if(idCli !=null && idCli > 0){
            msg.setDescrição("Cliente IdCliente ("+ idCli + ") atualizado com sucesso!");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
            msg.setDescrição("Cliente IdCliente ("+ idCli + ") Erro ao atualizar cliente.");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }
    
    @CrossOrigin(origins = "*")
    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Object> excluirCliente(@PathVariable(value = "id") long id){
        
        MsgRetorno msg = new MsgRetorno();
        msg.setFuncao("Excluir cliente");
        if ( clienteservico.excluirCliente(id) ){
            msg.setDescrição("Cliente IdCliente ("+ id + ") excluído com sucesso!");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } else {
            msg.setFuncao("Excluir cliente");
            msg.setDescrição("Erro ao excluir cliente IdCliente("+id+"), não cadastrado/inexistente!");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/cliente")
    public ResponseEntity<Long> novoCliente(@Valid @RequestBody Object obj) {
    	Long IDnovo = clienteservico.incluirCliente((Cliente) obj);
        return new ResponseEntity<>(IDnovo, HttpStatus.OK);
    }
    
    
    
    
}
