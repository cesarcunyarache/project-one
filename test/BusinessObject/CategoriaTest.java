/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BusinessObject;

import TransferObject.CategoriaDTO;
import java.util.ArrayList;
import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cesarcunyarache
 */
public class CategoriaTest {
    
    public CategoriaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of crear method, of class Categoria.
     */
    @Test
    public void testCrear() {
        System.out.println("crear");
        String dato = "";
        Categoria instance = null;
        instance.crear(dato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class Categoria.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        int id = 0;
        Categoria instance = null;
        instance.eliminar(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizar method, of class Categoria.
     */
    @Test
    public void testActualizar() {
        System.out.println("actualizar");
        int id = 0;
        String dato = "";
        Categoria instance = null;
        instance.actualizar(id, dato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Buscar method, of class Categoria.
     */
    @Test
    public void testBuscar() {
        System.out.println("Buscar");
        int id = 0;
        Categoria instance = null;
        CategoriaDTO expResult = null;
        CategoriaDTO result = instance.Buscar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class Categoria.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        Categoria instance = null;
        ArrayList<CategoriaDTO> expResult = null;
        ArrayList<CategoriaDTO> result = instance.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarCategoria method, of class Categoria.
     */
    @Test
    public void testMostrarCategoria() {
        System.out.println("mostrarCategoria");
        Categoria instance = null;
        Vector<CategoriaDTO> expResult = null;
        Vector<CategoriaDTO> result = instance.mostrarCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
