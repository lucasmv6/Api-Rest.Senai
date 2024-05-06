/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.senai.apirest.servicos;

import com.senai.apirest.entidades.Vendas;
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
public class VendaSevicoTest {
    
    @Autowired
    private VendaSevico srv;
    
    public VendaSevicoTest() {
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
    public void testIncluirVendas() {
        System.out.println("IncluirVendas");
        Vendas vendas = new Vendas();
        vendas.setStatus(1);
        Long expResult = null;
        Long result = srv.IncluirVendas(vendas,1L);
        assertNotEquals(expResult, result);
        
    }
    
    @Test
    public void testIncluirVendasSemStatus() {
        System.out.println("IncluirVendasSemStatus");
        Vendas vendas = new Vendas();
//      vendas.setStatus(0);
        Long expResult = null;
        Long result = srv.IncluirVendas(vendas,1L);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testExcluirVendas() {
        System.out.println("excluirVendas");
        Long idVendas = 2L;
        Boolean expResult = true;
        Boolean result = srv.excluirVendas(idVendas);
        assertEquals(expResult, result);

    }

    @Test
    public void testConsultarVendas() {
        System.out.println("consultarVendas");
        Long idVendas = 1L;
        Optional<Vendas> expResult = null;
        Optional<Vendas> result = srv.consultarVendas(idVendas);
        assertNotEquals(expResult, result);
    }

    @Test
    public void testListarVendas() {
        System.out.println("listarVendas");
        List<Vendas> expResult = null;
        List<Vendas> result = srv.listarVendas();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testAtualizarVendas() {
        System.out.println("atualizarVendas");
        Vendas vendas = new Vendas();
        vendas.setStatus(5);
        Long expResult = null;
        Long result = srv.IncluirVendas(vendas,1L);
        assertNotEquals(expResult, result);
    }   
}
