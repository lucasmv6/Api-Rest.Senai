
package com.senai.apirest.controladores;

import com.senai.apirest.entidades.MsgRetorno;
import com.senai.apirest.entidades.Produto;
import com.senai.apirest.servicos.ProdutoServico;
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
public class ProdutoCtrolador {
    
    @Autowired
    ProdutoServico produtoservico;
    
    @CrossOrigin(origins = "*")
    @GetMapping("/produto/{id}")
    public ResponseEntity<Object> consultaProduto(@PathVariable(value = "id") Long idProduto){
        
        Optional<Produto> produto = produtoservico.consultarProduto(idProduto);
        if(produto.isPresent()){
            return new ResponseEntity<>(produto.get(), HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Consultar Produto");
            erro.setDescrição("Erro ao consultar Produto ID: " + idProduto );
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);            
        }
    }
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/produto", consumes = {"application/json"})
    public ResponseEntity<Object> incluirProduto(@Valid @RequestBody Produto produto){
        
        Long idPro = produtoservico.incluirProduto(produto);
        if(idPro != null && idPro > 0){
            return new ResponseEntity<>(idPro, HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Incluir Produto");
            erro.setDescrição("Erro ao incluir Produto! Chame a TI!!");
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);            
        }
    }

@CrossOrigin(origins = "*")
    @PutMapping("/produto")
    public ResponseEntity<Object> atualizarProduto( @Valid @RequestBody Object atualizaPro )
    {
        MsgRetorno msg = new MsgRetorno();
        msg.setFuncao("Atualizar Produto");
        Long idPro = produtoservico.atualizarProduto(atualizaPro);
        if(idPro !=null && idPro > 0){
            msg.setDescrição("Produto IdProduto ("+ idPro + ") atualizado com sucesso!");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
            msg.setDescrição("Produto IdProduto ("+ idPro + ") Erro ao atualizar produto.");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }
    
@CrossOrigin(origins = "*")
    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Object> excluirProduto(@PathVariable(value = "id") long id){
        
        MsgRetorno msg = new MsgRetorno();
        msg.setFuncao("Excluir produto");
        if ( produtoservico.excluirProduto(id) ){
            msg.setDescrição("Produto IdProduto ("+ id + ") excluído com sucesso!");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } else {
            msg.setFuncao("Excluir cliente");
            msg.setDescrição("Erro ao excluir produto IdProduto("+id+"), não cadastrado/inexistente!");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
    }    
    
@CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/produto")
    public ResponseEntity<Long> novoProduto(@Valid @RequestBody Object obj) {
    	Long IDnovo = produtoservico.incluirProduto((Produto) obj);
        return new ResponseEntity<>(IDnovo, HttpStatus.OK);
    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
