import java.awt.event.ActionEvent;
import javax.swing.*;

import java.rmi.*;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.rmi.server.*;
import java.sql.*;
import java.util.Vector;
import java.text.NumberFormat;

public class ServeurFenetre extends UnicastRemoteObject implements InterfaceMoteur,Serializable {
	/**
	 * 
	 */
	
	private String message;
	public Vector<String> liste;
	ServeurFenetre(String s)throws RemoteException{
		message=s;
		
	}
	public String[] lu=new String[15];
	public String[] lu1=new String[15];
	public int[] tab = new int[15];
	public String[] lu2=new String[15];
	
	public String password="john";
	
	
	

	public static void main(String[] argv){
		//***********************lancement du serveur********************
		//System.setSecurityManager( new RMISecurityManager());
		try {
			/* crÃ©er une instance de la classe Hello et l'enregistrer dans le serveur de nom */
			java.rmi.registry.LocateRegistry.createRegistry(1099);
		   ServeurFenetre c1=new ServeurFenetre("testde RMI3");
			
			Naming.rebind("rmi://localhost/autre",c1);
			System.out.println("le serveur ete lancer");
			
		}
		catch(Exception e){System.out.println("idiot  "+e);}
	}
	
	
	
	//*************************************fonction de recupération du nom du prenom et de la date de naissance du patient******************
	
	public Statement conexion()throws RemoteException{
		try{//***********************************conexion sur le driver
			Class.forName("org.postgresql.Driver");
			System.out.println("driver établi");
		}
		catch(Exception e){
			System.out.println("connexion driver recupere dossier non établie");
		}
        try{//************************************connexion sur la base de donnée
			
			
		    Connection  conex = DriverManager.getConnection("jdbc:postgresql://localhost/bdhospital","postgres",password);
		    //Connection  conex = DriverManager.getConnection("jdbc:postgresql://192.168.0.8/bdhospital","bdinfo3",password);

		    System.out.println("conexion établie sur la base de donnée recupere nom");
		    Statement state= conex.createStatement();
		    return state;
        }
        catch(Exception ez){
        	System.out.println("connexion non établi sur la BD");
        	return null;
        }
		
	}
	
	public String[] RecupereNom(int i) throws RemoteException{
		NumberFormat format=NumberFormat.getInstance();
		
		try{//************************************connexion sur la base de donnée
		    ResultSet resulte= this.conexion().executeQuery("SELECT * FROM patient WHERE id_patient="+i);
		    if(resulte==null){
            	return null;
            }
            lu=new String[15];
            int j=1;
            while(resulte.next()){
            	lu[j-1]=resulte.getString(j);
            	lu[j]=resulte.getString(j+1);
            	lu[j+1]=resulte.getString(j+2);
            	lu[j+2]=resulte.getString(j+3);
            	lu[j+3]=resulte.getString(j+4);
            	lu[j+4]=resulte.getString(j+5);
            	lu[j+5]=resulte.getString(j+6);
            	lu[j+6]=resulte.getString(j+7);
            	
            	System.out.println(resulte.getString(3));
            }
            return lu;
		}
		catch(SQLException ee){
			System.out.println("votre requête ne sera jamais exécutée" +ee);
			return null;
		}
		//System.out.println(liste);
		
	}
	
	//**************************************fin fonction recupereNom   et debut fonction recupereExamensPrescrit*****************************
	
	public String[][] RecupereExamensPrescrit(int i) throws RemoteException{
		
		   try{ 
		    
		    ResultSet resulte= this.conexion().executeQuery("SELECT * FROM prescrire_exam WHERE id_patient="+i);
		    
            //récupération des informations sur la prescription dudit examen
		    String[][] lu1=new String[25][25];
            int l=0,j=1;
            boolean k=resulte.next();
            while(k){
            	lu1[l][j-1]=resulte.getString(j);
            	lu1[l][j]=resulte.getString(j+1);
            	lu1[l][j+1]=resulte.getString(j+2);
            	lu1[l][j+2]=resulte.getString(j+3);
            	lu1[l][j+3]=resulte.getString(j+4);
            	lu1[l][j+4]=resulte.getString(j+5);
            	lu1[l][j+5]=resulte.getString(j+6);
            	lu1[l][j+6]=resulte.getString(j+7);   	
            	System.out.println(resulte.getString(3));
            	l++;
            	k=resulte.next();
            }
            System.out.println("bidonville");
                       return lu1;
		}
		catch(SQLException ee){
			System.out.println("votre requête ne sera jamais exécutée" +ee);
			return null;
		}
	}
		//**************************************fin fonction recupereExamensPrescrit   et debut fonction recupereExamen*****************************
        public String[] RecupereExamen(String i) throws RemoteException{
        	
    		try{
    		    ResultSet resulte= this.conexion().executeQuery("SELECT * FROM examen WHERE id_exam="+i);
    		    lu=new String[15];
                int j=1;
                while(resulte.next()){
                	lu[j-1]=resulte.getString(j+1);
                	lu[j]=resulte.getString(j+2);
                }
                return lu;
    		}
    		catch(SQLException ee){
    			System.out.println("votre requête ne sera jamais exécutée" +ee);
    			return null;
    		}
    		//System.out.println(liste);
		
	}
        
		//**************************************fin fonction recupereExamens   et debut fonction recupereLaborantin*****************************

        
    	public String[] RecupereLaborantin(String i)throws RemoteException{
    		
            try{
    		    ResultSet resulte= this.conexion().executeQuery("SELECT * FROM laborantin WHERE id_perso="+i);
    		    lu=new String[15];
                int j=1;
                while(resulte.next()){
                	lu[j-1]=resulte.getString(j);
                	lu[j]=resulte.getString(j+1);
                	lu[j+1]=resulte.getString(j+2);
                	lu[j+2]=resulte.getString(j+3);
                	lu[j+3]=resulte.getString(j+4);
                	lu[j+4]=resulte.getString(j+5);
                	lu[j+5]=resulte.getString(j+6);
                	lu[j+6]=resulte.getString(j+7);
                	       	
               }
                return lu;
    		}
    		catch(SQLException ee){
    			System.out.println("votre requête ne sera jamais exécutée" +ee);
    			return null;
    		}
    		
    		
    	}
    	
    	//**************************************fin fonction recupereLaborantin   et debut fonction recupereMedecin*****************************
    	
    	public String[] RecupereMedecin(String i)throws RemoteException{
    		
            try{
    		    ResultSet resulte= this.conexion().executeQuery("SELECT * FROM medecin  WHERE id_perso="+i);
    		    lu=new String[15];
                int j=1;
                while(resulte.next()){
                	lu[j-1]=resulte.getString(j);
                	lu[j]=resulte.getString(j+1);
                	lu[j+1]=resulte.getString(j+2);
                	lu[j+2]=resulte.getString(j+3);
                	lu[j+3]=resulte.getString(j+4);
                	lu[j+4]=resulte.getString(j+5);
                	lu[j+5]=resulte.getString(j+6);
                	lu[j+6]=resulte.getString(j+7);
                	       	
               }
                return lu;
    		}
    		catch(SQLException ee){
    			System.out.println("votre requête ne sera jamais exécutée" +ee);
    			return null;
    		}
    		
    		
    	}
    	
    	//********************************************************les chiens****************************
    	
//////////////////************************Fonction permetant d'identifier un patient dans la base

public boolean connecter(int i) throws RemoteException{
			
			
			try{//************************************connexion sur la base de donnée
				
			   
			    ResultSet resulte= this.conexion().executeQuery("SELECT id_patient FROM patient WHERE id_patient="+i);
			   
			    if(!resulte.next())return false;
			    resulte.close();
			    return true;
			    
			}catch(SQLException ee){
				System.out.println("votre requête ne sera jamais exécutée" +ee);
				return false;
			}
	 }

//////////////////************************Fonction permetant d'interner un patient

public int interner(int i,int j,java.sql.Date d)throws RemoteException{
	 
	 Date da = new Date(0001,01,01);
	 
   try{ 
		
		Class.forName("org.postgresql.Driver");
		System.out.println("driver établi");
	}
	catch(Exception e){
		System.out.println("connexion driver non établie");
	}
	
	try{//************************************connexion sur la base de donnée
		
	    //Connection  con = DriverManager.getConnection("jdbc:postgresql://192.168.0.8/bdhospital","bdinfo3",password);
	    Connection  con = DriverManager.getConnection("jdbc:postgresql://localhost/bdhospital","postgres",password);
	    System.out.println("connection établie sur la base de donnée ");
	    
	    String insertion = "INSERT INTO hospitaliser VALUES(?,?,?,?)";
	    Statement state= con.createStatement();
	    PreparedStatement ps = con.prepareStatement(insertion);
	    ResultSet result = state.executeQuery("SELECT * FROM hospitaliser ");
		
	    ps.setInt(1,i);
		ps.setInt(2,j);
		ps.setDate(3,d);
		ps.setDate(4,da);
		ps.executeUpdate();
		System.out.println("Insertion réussi!!!");	
	    
	    ps.close();
	    return 1;
	   
	}catch(Exception e){
		JOptionPane.showMessageDialog(null," Identifiant du lit inexistant!","Data base error", JOptionPane.WARNING_MESSAGE);
	    System.out.println("Connection échoué interner!!!");
	    System.out.println(e);	
	 return 0;
    }

}

////////////////////////*******************Fonction permettant de mettre à jour la date de sortie d'un patient

public boolean sortir(int i,java.sql.Date d)throws RemoteException{
	 
    try{ 
		
		Class.forName("org.postgresql.Driver");
		System.out.println("driver établi");
	}
	catch(Exception e){
		System.out.println("connexion driver non établie");
	}
	
	try{//************************************connexion sur la base de donnée
		
	    //Connection  conn = DriverManager.getConnection("jdbc:postgresql://192.168.0.8/bdhospital","postgres",password);
	    Connection  conn = DriverManager.getConnection("jdbc:postgresql://localhost/bdhospital","postgres",password);
	    System.out.println("connection établie sur la base de donnée ");
	    
	    String insertion = "UPDATE hospitaliser SET date_fin=? WHERE id_patient="+i;
	    Statement state= conn.createStatement();
	    PreparedStatement pes = conn.prepareStatement(insertion);
	    pes.setDate(1, d);
	    pes.executeUpdate();
	    System.out.println("M A J effectuée!!!");
	    pes.close();
	    return true; 
	}catch(Exception e){
		System.out.println("Connection échoué!!!");
		System.out.println(e);
		return false;
	  }

}

///////////////////*********************Fonctionn permettant de verifier si un patient est encore hospitaliser

public String[] sortir1(int i)throws RemoteException{
    
	String[] st = new String[3];
    try{ 
		
		Class.forName("org.postgresql.Driver");
		System.out.println("driver établi");
	}
	catch(Exception e){
		System.out.println("connexion driver non établie");
	}
	
	try{//************************************connexion sur la base de donnée
		
	    //Connection  conn = DriverManager.getConnection("jdbc:postgresql://192.168.0.8/bdhospital","bdinfo3",password);
	    Connection  conn = DriverManager.getConnection("jdbc:postgresql://localhost/bdhospital","postgres",password);
	    System.out.println("connection établie sur la base de donnée ");
	    
	    Statement state= conn.createStatement();
	    ResultSet res = state.executeQuery("SELECT * FROM hospitaliser ");
		
	    while(res.next()){

	    	if(res.getInt(1)==i && res.getDate(4).getYear()==1){
	    		
                st[0]= res.getString(2);
                st[1]= res.getString(3);
                st[2]= res.getString(4);
	    		System.out.print(res.getString(2)+"      ");
			    System.out.print(res.getString(3)+"      ");
			    System.out.println(res.getString(4)+"      ");
	    }
 }
    	res.close();
	}catch(Exception e){
		System.out.println("Connection échoué!!!");
		System.out.println(e);
	  }
	return st;

}

///////////////////////////////////////////////Fonction permettant de savoir si un lit est occupé ou pas


public boolean occuper(int id_lit)throws RemoteException{
    try{ 
		
		Class.forName("org.postgresql.Driver");
		System.out.println("driver établi");
	}
	catch(Exception e){
		System.out.println("connexion driver non établie");
	}
	
	try{//************************************connexion sur la base de donnée
		
	    //Connection  conn = DriverManager.getConnection("jdbc:postgresql://192.168.0.8/bdhospital","bdinfo3",password);
	    Connection  conn = DriverManager.getConnection("jdbc:postgresql://localhost/bdhospital","postgres",password);
	    System.out.println("connection établie sur la base de donnée ");
	    
	    Statement state= conn.createStatement();
	    ResultSet res = state.executeQuery("SELECT * FROM hospitaliser ");
		
	    while(res.next()){

	    	if(res.getInt(2)==id_lit && res.getDate(4).getYear()==1){
	    		return true;
	    }
 }
    	res.close();
	}catch(Exception e){
		System.out.println("Connection échoué!!!");
		System.out.println(e);
	  }
	return false;
	
}




//**************************fonction d'insertion d'une nouvelle prescription,s'appelle avec l'id du patient de l'examen et du personnel*********************************

public boolean InsererPrecription(int i,int j,int k)throws RemoteException{
	try{
		ResultSet k1=this.conexion().executeQuery("SELECT * FROM prescrire_exam");
		boolean v=k1.next();
		int m=0;
		while(v){
			m++;
			v=k1.next();
		}
		 m=m+1;
		  
		 ResultSet s=this.conexion().executeQuery("SELECT *FROM examen WHERE id_exam="+j);
		 boolean y=s.next();
		 String s1=s.getString(2);
		 Date d=null;
		int entre=this.conexion().executeUpdate("INSERT INTO prescrire_exam(id_patient,id_exam,id_perso,id_presc,date_presc_exam,libele,resultat,info_labo)VALUES('"+i+"','"+j+"','"+k+"','"+m+"','"+d+"','"+s1+"')");
	    
		return true;
	}
	catch(Exception e){System.out.println("erreur insertion de prescription  "+e);
	return false;
	
	}
}


//Fonction permettant d'inserer une prescription

public int prescrire(int a ,int b,int c,java.sql.Date d)throws RemoteException{
	
try{ 
		
		Class.forName("org.postgresql.Driver");
		System.out.println("driver établi");
	}
	catch(Exception e){
		System.out.println("connexion driver non établie");
	}
	
	try{//************************************connexion sur la base de donnée
		
	    //Connection  con = DriverManager.getConnection("jdbc:postgresql://192.168.0.8/bdhospital","bdinfo3",password);
	    Connection  con = DriverManager.getConnection("jdbc:postgresql://localhost/bdhospital","postgres",password);
	    System.out.println("connection établie sur la base de donnée ");
	    
	    Statement stmt= con.createStatement();
	   	    
		    ResultSet resulte= stmt.executeQuery("SELECT id_perso FROM medecin WHERE id_perso="+c);
		   
		    if(!resulte.next())return -1;
		    resulte.close();
		
		    
		    
		    String insertion = "INSERT INTO prescrire_exam VALUES(?,?,?,?,?,?,?,?)";
	
		    PreparedStatement ps = con.prepareStatement(insertion);
		    ResultSet result = stmt.executeQuery("SELECT id_presc FROM prescrire_exam ");
		    
		    boolean v=result.next();
			int m=0;
			while(v){
				m++;
				v=result.next();
			}
			 m=m+1;
			
		    ps.setInt(1,a);
			ps.setInt(2,b);
			ps.setInt(3,c);
			ps.setInt(4,m);
			ps.setDate(5,d);
			ps.setString(6,"RAS");
			ps.setString(7,"RAS");
			ps.setString(8,"RAS");
			ps.executeUpdate();
			System.out.println("Insertion réussi!!!");	
		    
		    ps.close();
		   
	
	    return m; 
	}catch(Exception e){
		System.out.println("Connection échoué!!!");
		System.out.println(e);
		return -1;
	  }
	
	
}
public boolean diagnostique(int q,int w,int e,int r,int t,Date d,int y,String u,String o)throws RemoteException	{

    try{
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		Class.forName("org.postgresql.Driver");
		 System.out.println ("driver etablie");
	}
	catch(Exception ex){
		System.out.println ("erreur:Driver int" + "rouvable"); 
	}
	try{
		//Connection conX = DriverManager.getConnection("jdbc:oracle:thin:system/manager@localhost:5432:IN3DB1");POUR POSTGRE
		
		//Connection conX = DriverManager.getConnection("jdbc:postgresql://192.168.0.8/bdhospital","bdinfo3",password);
	    Connection  conX = DriverManager.getConnection("jdbc:postgresql://localhost/bdhospital","postgres",password);
		System.out.println ("connexion etablie sur projet"); 
		
		String insertion = "INSERT INTO diagnostiquer VALUES(?,?,?,?,?,?,?,?,?)";
		Statement stmt = conX.createStatement();
		PreparedStatement ps = conX.prepareStatement(insertion);
		ResultSet res = stmt.executeQuery("SELECT * FROM diagnostiquer");
		System.out.println("prix nobel");
		ps.setInt(1, q);
		ps.setInt(2,w);
		ps.setInt(3,e);
		ps.setInt(4, r);
		ps.setInt(5,t);
		ps.setDate(6, d);
		ps.setInt(7,y);
		ps.setString(8,u);
		ps.setString(9,o);
		ps.executeUpdate();
		System.out.println("prix nobel");
		ps.close();
		return true;
	
		}catch(Exception eee){
			System.out.println("connection echoue pr diagnostique"+eee);
			return false;
		}
      }

     // affichediag permet d afficher le diagnostique preliminaire

public String[] affichediag(int i)throws RemoteException{
    
	String[] st = new String[9];
	String s1 = null,s2 = null,s3 = null,s4=null,s5 = null,s6 = null,s7 = null,s8 = null,s9 = null;
	
    try{ 
		
		Class.forName("org.postgresql.Driver");
		System.out.println("driver établi");
	}
	catch(Exception e){
		System.out.println("connexion driver non établie");
	}
	
	try{//************************************connexion sur la base de donnée
		
	    //Connection  conn = DriverManager.getConnection("jdbc:postgresql://192.168.0.8/bdhospital","bdinfo3",password);
	    Connection  conn = DriverManager.getConnection("jdbc:postgresql://localhost/bdhospital","postgres",password);
	    System.out.println("connection établie sur la base de donnée ");
	    
	    Statement state= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    ResultSet res = state.executeQuery("SELECT * FROM diagnostiquer WHERE id_patient="+i);
		
	    //res.afterLast();
	    while(res.next()){

	    	if(res.getInt(2)==i){
	    		
                s1= res.getString(1);
                s2= res.getString(2);
                s3= res.getString(3);
                s4= res.getString(4);
                s5= res.getString(5);
                s6= res.getString(6);
                s7= res.getString(7);
                s8= res.getString(8);
                s9= res.getString(9);
	    		
	    		System.out.print(res.getString(2)+"      ");
			    System.out.print(res.getString(3)+"      ");
			    System.out.println(res.getString(4)+"      ");
	    }
 }
	    st[0]=s1;
	    st[1]=s2;
	    st[2]=s3;
	    st[3]=s4;
	    st[4]=s5;
	    st[5]=s6;
	    st[6]=s7;
	    st[7]=s8;
	    st[8]=s9;
    	res.close();
	}catch(Exception e){
		System.out.println("Connection échoué!!!");
		System.out.println(e);
	  }
	return st;

}


public void recevoir(int npat, int nvacc, String date) throws RemoteException {
	try{
		
		
		Class.forName("org.postgresql.Driver");
		 System.out.println ("driver etablie");
	}
	catch(Exception e){
		System.out.println ("erreur:Driver introuvable"); 
	}
	try{
		
        this.conexion().executeUpdate ("INSERT INTO recevoir(id_patient,id_vaccin,date_prescription) VALUES ('"+npat+"','"+nvacc+"','"+date+"')");

	    System. out .println ("enregistrer");     
		}
	
	catch(Exception e){
		System.out.println ("connexion elements base non  etablie "+e); 
	}	
}


//////////////////////////////ordonance

public int inserordonance(int m,int a1 ,int b1,String c1 ,java.sql.Date dat)throws RemoteException{
	
	try{ 
			
			Class.forName("org.postgresql.Driver");
			System.out.println("driver établi");
		}
		catch(Exception e){
			System.out.println("connexion driver non établie");
		}
		
		try{//************************************connexion sur la base de donnée
			
		    //Connection  con = DriverManager.getConnection("jdbc:postgresql://192.168.0.8/bdhospital","bdinfo3",password);
		    Connection  con = DriverManager.getConnection("jdbc:postgresql://localhost/bdhospital","postgres",password);
		    System.out.println("connection établie sur la base de donnée ");
		    
		    Statement stmt= con.createStatement();
		   	    
			    ResultSet resulte= stmt.executeQuery("SELECT id_perso FROM medecin WHERE id_perso="+b1);
			   
			    if(!resulte.next()){
				  resulte.close();     
				  return -1;
			    }
			  
			    String insertion1 = ("INSERT INTO prescrire_ordonnance VALUES(?,?,?,?,?)");
		
			    PreparedStatement ps1 = con.prepareStatement(insertion1);
			    
				ps1.setInt(1,m);
			    ps1.setInt(2,a1);
				ps1.setInt(3,b1);
				ps1.setString(4,c1);
				ps1.setDate(5,dat);
				
				ps1.executeUpdate();
				System.out.println("Insertion réussie!!!");	
			    
			    ps1.close();
		
		    return 1; 
		
		}catch(Exception e){
			System.out.println("Connection échouée!!!");
			System.out.println(e);
			return -1;
		  }
		}
//************************Fonction permetant d'identifier un personnel dans la base td rdv*******************************

public boolean connection(int s) throws RemoteException{
			
			
			try{//************************************connexion sur la base de donnée
				
			   
			    ResultSet resulte= this.conexion().executeQuery("SELECT id_perso FROM personnel WHERE id_perso="+s);
			   
			    if(!resulte.next())return false;
			    resulte.close();
			    return true;
			    
			}catch(SQLException ee){
				System.out.println("votre requête ne sera jamais exécutée" +ee);
				return false;
			}
	 }


public int donnerrdv(int s ,int t,java.sql.Date d)throws RemoteException{
	
	try{ 
			
			Class.forName("org.postgresql.Driver");
			System.out.println("bonjour");
		}
		catch(Exception e){
			System.out.println("terre");
		}
		
		try{//************************************connexion sur la base de donnée
			
		    //Connection  con = DriverManager.getConnection("jdbc:postgresql://192.168.0.8/bdhospital","bdinfo3",password);
		    Connection  con = DriverManager.getConnection("jdbc:postgresql://localhost/bdhospital","postgres",password);
		    System.out.println("connection établie sur la base de donnée ");
		    
		    Statement stmt= con.createStatement();
		   	    
			    ResultSet resulte= stmt.executeQuery("SELECT id_patient FROM patient WHERE id_patient="+s);
			   
			    if(!resulte.next())return -1;
			    resulte.close();
			
			    
			    int n=2;
			    String insertion = "INSERT INTO donner_rdv VALUES(?,?,?)";
		
			    PreparedStatement rd = con.prepareStatement(insertion);
			    /*ResultSet result = stmt.executeQuery("SELECT id_perso FROM personnel ");
			    
			    boolean v=result.next();
				int n=0;
				while(v){
					n++;
					v=result.next();
				}
				 n=n+1;*/
				
			    rd.setInt(1,s);
				rd.setInt(2,t);
				rd.setDate(3,d);
				rd.executeUpdate();
				System.out.println("Insertion réussi!!!");	
			    
			    rd.close();
			   
		
		    return n; 
		}catch(Exception e){
			System.out.println("Connection échoué!!!");
			System.out.println(e);
			return -1;
		  }
		
		
	}

public String[] recupernompat(int i) throws RemoteException{
	

       NumberFormat format=NumberFormat.getInstance();

        try{//************************************connexion sur la base de donnée
    ResultSet resulte= this.conexion().executeQuery("SELECT * FROM patient WHERE id_perso="+i);
    if(resulte==null){
    	return null;
    }
    lu2=new String[15];
    int j=1;
    while(resulte.next()){
    	lu2[j-1]=resulte.getString(j);
    	lu2[j]=resulte.getString(j+1);
    	lu2[j+1]=resulte.getString(j+2);
    	lu2[j+2]=resulte.getString(j+3);
    	lu2[j+3]=resulte.getString(j+4);
    	lu2[j+4]=resulte.getString(j+5);
    	lu2[j+5]=resulte.getString(j+6);
    	lu2[j+6]=resulte.getString(j+7);
    	System.out.println(resulte.getString(1));
    	System.out.println("votre requête sera  exécutée");

    }
    
    return lu2;
}
catch(SQLException ee){
	System.out.println("votre requête ne sera jamais exécutée" +ee);
	return null;
}
//System.out.println(liste);

}

         public String[] Recuperdate(int i) throws RemoteException{
	
	try{
	    ResultSet resulte= this.conexion().executeQuery("SELECT * FROM donner_rdv WHERE id_perso="+i);
	    lu2=new String[15];
        int j=1;
        while(resulte.next()){
        	lu2[j-1]=resulte.getString(j+1);
        	lu2[j]=resulte.getString(j+2);
        	lu2[j+1]=resulte.getString(j+3);
        }
        return lu2;
	}
	catch(SQLException ee){
		System.out.println("votre requête ne sera jamais exécutée" +ee);
		return null;
		}
	}
	//System.out.println(liste);

	
}


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        