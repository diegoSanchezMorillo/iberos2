package Modelos;
// Generated 10-jun-2019 1:48:46 by Hibernate Tools 4.3.1



/**
 * ContieneId generated by hbm2java
 */
public class ContieneId  implements java.io.Serializable {


     private int idventas;
     private int idproductos;

    public ContieneId() {
    }

    public ContieneId(int idventas, int idproductos) {
       this.idventas = idventas;
       this.idproductos = idproductos;
    }
   
    public int getIdventas() {
        return this.idventas;
    }
    
    public void setIdventas(int idventas) {
        this.idventas = idventas;
    }
    public int getIdproductos() {
        return this.idproductos;
    }
    
    public void setIdproductos(int idproductos) {
        this.idproductos = idproductos;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ContieneId) ) return false;
		 ContieneId castOther = ( ContieneId ) other; 
         
		 return (this.getIdventas()==castOther.getIdventas())
 && (this.getIdproductos()==castOther.getIdproductos());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdventas();
         result = 37 * result + this.getIdproductos();
         return result;
   }   


}


