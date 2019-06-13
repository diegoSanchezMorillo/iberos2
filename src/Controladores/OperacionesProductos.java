/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Productos;
import Modelos.Proveedores;
import java.util.ArrayList;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class OperacionesProductos {
    
    private Session sesion;
    
     //con transactional podemos volver a ejecutar otros métodos
    @Transactional
    private void iniciaOperacion(){
    
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        sesion = sessionFactory.openSession();
        sesion.beginTransaction();
    }
    
    @Transactional
    private void terminaOperacion(){
        sesion.getTransaction().commit();
        sesion.close();
    }
    
     public int guardaProducto(Productos producto){
        int id = 0;
        iniciaOperacion();  
        id = (int)sesion.save(producto);
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
        return id;
    }
     
      @Transactional 
    public ArrayList<Productos> ListaProductos(){
         
         ArrayList<Productos> listaProductos = null;
         iniciaOperacion();
         listaProductos = (ArrayList<Productos>) sesion.createQuery("from Productos").list();
         terminaOperacion();         
         return listaProductos;
     }
    
     @Transactional
    public int eliminaProducto(Productos producto){
        int id = producto.getIdproductos();
        iniciaOperacion();
        producto = (Productos) sesion.get(Productos.class, id);
        sesion.delete(producto);
        
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
        return id;
    }
    
     @Transactional
    public Productos seleccionaProducto(Productos producto){
        int id = producto.getIdproductos();
        iniciaOperacion();
        producto = (Productos) sesion.get(Productos.class, id);    
        terminaOperacion();
        
        return producto;
    }
    @Transactional
    public int actualizaProducto(Productos producto){
        int id = producto.getIdproductos();
        iniciaOperacion();        
        sesion.update(producto);       
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
        return id;
    }

     @Transactional 
    public ArrayList<Productos> ListaProductosBuscar(String campo,String buscar){
         
         ArrayList<Productos> listaProductos = null;
         iniciaOperacion();
         listaProductos = (ArrayList<Productos>) sesion.createQuery("from Productos WHERE "+campo+"='"+buscar+"'").list();
         terminaOperacion();         
         return listaProductos;
     }
    @Transactional
    public int actualizaCantidadProducto(Productos producto){
        int id = producto.getIdproductos();
        iniciaOperacion();        
        sesion.update(producto);       
        terminaOperacion();
        
        return id;
    }
}
