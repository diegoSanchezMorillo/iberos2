/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Modelos.Categorias;
import Modelos.Clientes;
import Modelos.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Diego
 */
public class OperacionesCategorias {
    
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
    @Transactional
    public int guardaCategoria(Categorias categoria){
        int id = 0;
        iniciaOperacion();
        id = (int)sesion.save(categoria);
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
        return id;
    }
    @Transactional 
    public List<Categorias> ListaCategorias(){
         
         ArrayList<Categorias> listaCategorias = null;
         iniciaOperacion();
         listaCategorias = (ArrayList<Categorias>) sesion.createQuery("from Categorias").list();
         terminaOperacion();         
         return listaCategorias;
     }
    
    
    @Transactional
    public int eliminaCategoria(Categorias categoria){
        int id = categoria.getIdcategorias();
        iniciaOperacion();
        sesion.delete(categoria);
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Categoria eliminada correctamente");
        return id;
    } 
    
     @Transactional
    public Categorias seleccionaCategoria(Categorias categoria){
        int id = categoria.getIdcategorias();
        iniciaOperacion();
        categoria = (Categorias) sesion.get(Categorias.class, id);    
        terminaOperacion();
        
        return categoria;
    }
    
    @Transactional
    public int actualizaCategoria(Categorias categoria){
        int id = categoria.getIdcategorias();
        iniciaOperacion();
        sesion.update(categoria);
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Categoria modificada correctamente");
        return id;
    }
    
    @Transactional 
    public List<Categorias> ListaCategoriasNombre(String nombre){
         
         ArrayList<Categorias> listaCategorias = null;
         iniciaOperacion();
         listaCategorias = (ArrayList<Categorias>) sesion.createQuery("from Categorias WHERE nombre ='"+nombre+"'").list();
         terminaOperacion();         
         return listaCategorias;
     }
    
    
}
