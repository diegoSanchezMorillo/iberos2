/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Compras;
import Modelos.Tiene;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Diego
 */
public class OperacionesCompras {
    
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
    
    
    public int guardaCompra(Compras compra){
        int id = 0;
        iniciaOperacion();
        id = (int)sesion.save(compra);
        terminaOperacion();
        
        return id;
    }
    
    
    public void guardaTiene(Tiene tiene){
        
        iniciaOperacion();
        sesion.save(tiene);
        terminaOperacion();
        
        
    }
    
    
    public ArrayList<Compras> ListaCompras(){
         
         ArrayList<Compras> listaCompras = null;
         iniciaOperacion();
         listaCompras = (ArrayList<Compras>) sesion.createQuery("from Compras").list();
         terminaOperacion();         
         return listaCompras;
     }
    
    public ArrayList<Compras> ListaProductos(){
         
         ArrayList<Compras> listaCompras = null;
         iniciaOperacion();
         listaCompras = (ArrayList<Compras> ) sesion.createQuery("from Tiene").list();
         terminaOperacion();         
         return listaCompras;
     }
    
    /**
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
    }**/
    
    
    public Compras seleccionaCompra (Compras compra){
        int id = compra.getIdcompras();
        iniciaOperacion();
        compra = (Compras) sesion.get(Compras.class, id);    
        terminaOperacion();
        
        return compra;
    }
    
    public int actualizaCompra(Compras compra){
        int id = compra.getIdcompras();
        iniciaOperacion();        
        sesion.update(compra);       
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Venta modificada correctamente");
        return id;
    }

    
}
