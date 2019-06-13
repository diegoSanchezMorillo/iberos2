/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Contiene;
import Modelos.ContieneId;
import Modelos.Productos;
import Modelos.Ventas;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Diego
 */
public class OperacionesVentas {
    
      private Session sesion;
    
    
    private void iniciaOperacion(){
    
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        sesion = sessionFactory.openSession();
        sesion.beginTransaction();
    }
    
    
    private void terminaOperacion(){
        sesion.getTransaction().commit();
        sesion.close();
    }
    
    
    public int guardaVenta(Ventas venta){
        int id = 0;
        iniciaOperacion();
        id = (int)sesion.save(venta);
        terminaOperacion();
        return id;
    }
    
    
    public void guardaContiene(Contiene contiene){
        
        iniciaOperacion();
        sesion.save(contiene);
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Venta creada correctamente");
        
    }
    
    
    public ArrayList<Ventas> ListaVentas(){
         
         ArrayList<Ventas> listaVentas = null;
         iniciaOperacion();
         listaVentas = (ArrayList<Ventas>) sesion.createQuery("from Ventas").list();
         terminaOperacion();         
         return listaVentas;
     }
    
    public ArrayList<Productos> ListaProductos(){
         
         ArrayList<Productos> listaVentas = null;
         iniciaOperacion();
         listaVentas = (ArrayList<Productos> ) sesion.createQuery("from Contiene").list();
         terminaOperacion();   
         
         return listaVentas;
     }
    
    
    public int eliminaVenta(Ventas venta,Contiene contiene,ContieneId contieneId){
        int id = venta.getIdventas();
        iniciaOperacion();
        venta = (Ventas) sesion.get(Ventas.class, id);
        contiene = (Contiene) sesion.get(Contiene.class, id);
        sesion.delete(venta);
        sesion.delete(contiene);
        contieneId = (ContieneId) sesion.get(ContieneId.class, id);
        sesion.delete(contieneId);
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Venta eliminada correctamente");
        return id;
    }
    
    
    public Ventas seleccionaVenta(Ventas venta){
        int id = venta.getIdventas();
        iniciaOperacion();
        venta = (Ventas) sesion.get(Ventas.class, id);    
        terminaOperacion();
        
        return venta;
    }
    
    public int actualizaVenta(Ventas venta){
        int id = venta.getIdventas();
        iniciaOperacion();        
        sesion.update(venta);       
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Venta modificada correctamente");
        return id;
    }

    
}
