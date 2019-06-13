/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Modelos.Proveedores;
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
public class OperacionesProveedores {
    
    private Session sesion;
    
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
    
    @Transactional
    public int guardaProveedor(Proveedores proveedor){
        int id = 0;
        iniciaOperacion();
        id = (int)sesion.save(proveedor);
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
        return id;
    }
    @Transactional 
    public ArrayList<Proveedores> ListaProveedores(){
         
         ArrayList<Proveedores> listaProveedores = null;
         iniciaOperacion();
         listaProveedores = (ArrayList<Proveedores>) sesion.createQuery("from Proveedores").list();
         terminaOperacion();         
         return listaProveedores;
     }
    
     @Transactional
    public int eliminaProveedor(Proveedores proveedor){
        int id = proveedor.getIdproveedores();
        iniciaOperacion();
        proveedor = (Proveedores) sesion.get(Proveedores.class, id);
        sesion.delete(proveedor);
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente");
        return id;
    }
    
     @Transactional
    public Proveedores seleccionaProveedor(Proveedores proveedor){
        int id = proveedor.getIdproveedores();
        iniciaOperacion();
        proveedor = (Proveedores) sesion.get(Proveedores.class, id);    
        terminaOperacion();
        
        return proveedor;
    }
    @Transactional
    public int actualizaProveedor(Proveedores proveedor){
        int id = proveedor.getIdproveedores();
        iniciaOperacion();        
        sesion.update(proveedor);       
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Proveedor modificado correctamente");
        return id;
    }
    
    @Transactional 
    public ArrayList<Proveedores> ListaProveedoresBuscar(String campo,String buscar){
         
         ArrayList<Proveedores> listaProveedores = null;
         iniciaOperacion();
         listaProveedores = (ArrayList<Proveedores>) sesion.createQuery("from Proveedores WHERE "+campo+"='"+buscar+"'").list();
         terminaOperacion();         
         return listaProveedores;
     }
    
}
