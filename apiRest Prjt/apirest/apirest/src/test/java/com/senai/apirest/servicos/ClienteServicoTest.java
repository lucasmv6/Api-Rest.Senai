/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.senai.apirest.servicos;

import com.senai.apirest.entidades.Cliente;
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
public class ClienteServicoTest {
    
    @Autowired
    private ClienteServico srv;
    
    public ClienteServicoTest() {
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
    public void testIncluirCliente() {
        System.out.println("incluirCliente");
        Cliente cliente = new Cliente();
        cliente.setCpf("Cpf");
        cliente.setEmail("Email");
        cliente.setNome("josé");
        Long expResult = null;
        Long result = srv.incluirCliente(cliente);
        assertNotEquals(expResult, result);

    }
    
    @Test
    public void testIncluirClienteSemCpf() {
        System.out.println("incluirCliente");
        Cliente cliente = new Cliente();
        cliente.setEmail("Email");
        cliente.setNome("josé");
        Long expResult = null;
        Long result = srv.incluirCliente(cliente);
        assertNotEquals(expResult, result);


    }
    

    
    @Test
    public void testIncluirClienteSemEmail() {
        System.out.println("incluirCliente");
        Cliente cliente = new Cliente();
        cliente.setCpf("Cpf");
        cliente.setNome("josé");
        Long expResult = null;
        Long result = srv.incluirCliente(cliente);
        assertNotEquals(expResult, result);


    }

    
    @Test
    public void testIncluirClienteSemNome() {
        System.out.println("incluirCliente");
        Cliente cliente = new Cliente();
        cliente.setCpf("Cpf");
        cliente.setEmail("Email");
        Long expResult = null;
        Long result = srv.incluirCliente(cliente);
        assertNotEquals(expResult, result);

    }

    @Test
    public void testExcluirCliente() {
        System.out.println("excluirCliente");
        Long idCliente = 202L;
        Boolean expResult = true;
        Boolean result = srv.excluirCliente(idCliente);
        assertEquals(expResult, result);
        

    }

    @Test
    public void testConsultarCliente() {
        System.out.println("consultarCliente");
        Long idCliente = 402L;
        Optional<Cliente> expResult = null;
        Optional<Cliente> result = srv.consultarCliente(idCliente);
        assertNotEquals(expResult, result);

    }

    @Test
    public void testListarClientes() {
        System.out.println("listarClientes");
        List<Cliente> expResult = null;
        List<Cliente> result = srv.listarClientes();
        assertNotEquals(expResult, result);

    }

    @Test
    public void testAtualizarCliente_Cliente() {
        System.out.println("atualizarCliente");
        Cliente cliente = new Cliente();
        cliente.setNome("josé_gh");
        cliente.setCpf("08890969610");
        cliente.setEmail("joséBraboDMS@gmail.com"); 
        cliente.setIDCliente(952L);
        Boolean result = srv.atualizarCliente(cliente);
        assertTrue( result);
    }

   
    
}
