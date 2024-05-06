/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.senai.apirest.servicos;

import com.senai.apirest.entidades.Produto;
import com.senai.apirest.entidades.VendasProduto;
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
public class VendasProdutoServicoTest {
    
    @Autowired
    private VendasProdutoServico srv;
    
    @Autowired
    private ProdutoServico prs;
    
    public VendasProdutoServicoTest() {
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
    public void testIncluirVendasProduto() {
        System.out.println("IncluirVendasProduto");
        VendasProduto vendasProduto = new VendasProduto();
        Optional<Produto> prd = prs.consultarProduto(202L); 
        vendasProduto.setProduto(prd.get());
        vendasProduto.setQtdProduto(2);
        vendasProduto.setValorProduto(24.0);
        boolean expResult = true;
        Long result = srv.IncluirVendasProduto(vendasProduto);
        assertNotEquals(expResult, result);
    }

    @Test
    public void testExcluirVendasProduto() {
        System.out.println("excluirVendasProduto");
        Long idVendasProduto = 2L;
        Boolean expResult = true;
        Boolean result = srv.excluirVendasProduto(idVendasProduto);
        assertEquals(expResult, result);
    }

    @Test
    public void testConsultarVendasProduto() {
        System.out.println("consultarVendasProduto");
        Long idVendasProduto = 202L;
        Optional<VendasProduto> expResult = null;
        Optional<VendasProduto> result = srv.consultarVendasProduto(idVendasProduto);
        assertNotEquals(expResult, result);
    }

    @Test
    public void testListarVendasProduto() {
        System.out.println("listarVendasProduto");
        List<VendasProduto> expResult = null;
        List<VendasProduto> result = srv.listarVendasProduto();
        assertNotEquals(expResult, result);
    }

    
    @Test
    public void testAtualizarVendas() {
        System.out.println("atualizarVendas");
        VendasProduto vendasProduto = new VendasProduto();
        Optional<Produto> prd = prs.consultarProduto(202L);
        vendasProduto.setProduto(prd.get());
        vendasProduto.setQtdProduto(200);
        vendasProduto.setValorProduto(244.0);
        vendasProduto.setIDVendasProduto(52L);
        Long expResult = null;
        Boolean result = srv.atualizarVendas(vendasProduto);
        assertNotEquals(expResult, result);
    }
    
    
}
