import java.rmi.*;
import java.sql.Date;
import java.util.Vector;


public interface InterfaceMoteur extends Remote {
	//les différentes méthodes de la classe moteur
	public String[] RecupereNom(int i)throws RemoteException;
	public String[][] RecupereExamensPrescrit(int i)throws RemoteException;
	public String[] RecupereExamen(String i)throws RemoteException;
	public String[] RecupereLaborantin(String i)throws RemoteException;
	public String[] RecupereMedecin(String i)throws RemoteException;
	public boolean InsererPrecription(int i,int j,int k)throws RemoteException;
	//public String[] EnregistrerDianostique(String i)throws RemoteException;
	
	//*********************Service offerts par l'onglet Hospitalisation*******************************************
	public int prescrire(int a, int b, int c, java.sql.Date d) throws RemoteException;
	public boolean connecter(int i) throws RemoteException;
	public int interner(int i,int j,java.sql.Date d)throws RemoteException;
	public boolean sortir(int i,java.sql.Date d)throws RemoteException;
    public String[] sortir1(int i)throws RemoteException;
    public boolean occuper(int id_lit)throws RemoteException;
    
    //**********************Service offerts par l'onglet diagnostique approfondir******************************************* 
      public boolean diagnostique(int q,int w,int e,int r,int t,Date d,int y,String u,String o)throws RemoteException; 
      public String[] affichediag(int i)throws RemoteException;
      public void recevoir(int npat,int nvacc, String date)throws RemoteException;
      
      
    //  public int insermedicament(int a2, int b2)throws RemoteException;
      public int inserordonance(int b,int a1 ,int b1,String c1,java.sql.Date dat)throws RemoteException;


      //********************services offerts par l'onglet rendez vous****************************************************
      public boolean connection(int s) throws RemoteException;
      public String[] recupernompat(int i) throws RemoteException;
      public String[] Recuperdate(int i) throws RemoteException;
      public int donnerrdv(int s,int t,java.sql.Date d)throws RemoteException;
      
}
