/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.senai.apirest.servicos;

import com.senai.apirest.entidades.Produto;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ProdutoServicoTest {
    
    @Autowired
    private ProdutoServico srv;
    
    public ProdutoServicoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testIncluirProduto() {
        System.out.println("IncluirProduto");
        Produto produto = new Produto();
        produto.setNomeProduto("arroz");
        produto.setDescricaoProduto("arroz é bom");
        produto.setValorProduto(10.0);
        Long expResult = null;
        Long result = srv.IncluirProduto(produto);
        assertNotEquals(expResult, result);

    }
    
        @Test
    public void testIncluirProdutoSemValor() {
        System.out.println("IncluirProduto");
        Produto produto = new Produto();
        produto.setNomeProduto("arroz");
        produto.setDescricaoProduto("arroz é bom");
        Long expResult = null;
        Long result = srv.IncluirProduto(produto);
        assertNotEquals(expResult, result);
    }
    
       @Test
    public void testIncluirProdutoSemDesc() {
        System.out.println("IncluirProduto");
        Produto produto = new Produto();
        produto.setNomeProduto("arroz");
        produto.setValorProduto(10.0);
        Long expResult = null;
        Long result = srv.IncluirProduto(produto);
        assertNotEquals(expResult, result);

    }
        @Test
    public void testIncluirProdutoSemNome() {
        System.out.println("IncluirProduto");
        Produto produto = new Produto();
        produto.setDescricaoProduto("arroz é bom");
        produto.setValorProduto(10.0);
        Long expResult = null;
        Long result = srv.IncluirProduto(produto);
        assertNotEquals(expResult, result);

    }
    
    @Test
    public void testExcluirProduto() {
        System.out.println("excluirProduto");
        Long idProduto = 102L;
        Boolean expResult = true;
        Boolean result = srv.excluirProduto(idProduto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testConsultarProduto() {
        System.out.println("consultarProduto");
        Long idProduto = 1L;
        Optional<Produto> expResult = null;
        Optional<Produto> result = srv.consultarProduto(idProduto);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testListarProduto() {
        System.out.println("listarProduto");
        List<Produto> expResult = null;
        List<Produto> result = srv.listarProduto();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testAtualizarProduto_Produto() {
        System.out.println("atualizarProduto");
        Produto produto = new Produto();
        produto.setNomeProduto("batata");
        produto.setDescricaoProduto("batata é ruim");
        produto.setValorProduto(16.0);
        produto.setIDProduto(1L);
        Boolean result = srv.atualizarProduto(produto);
        assertTrue( result);
    }

 
    
}
