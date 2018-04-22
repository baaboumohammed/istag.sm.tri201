import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.*;
import javax.swing.*;

//import com.sun.java.util.jar.pack.Package.File;

/**
 * 
 *
 */

public class Fenetre extends JFrame  implements ActionListener{
	
	//Declaration des differents champs
	NumberFormat format=NumberFormat.getInstance();
	public static InterfaceMoteur hello;
	public static JFrame maFenetre;
	public JPanel pan_fenetre, pan_consult, pan_diag, pan_presc_test,pan_exam, pan_presc_ordo, pan_resul_exam, pan_hospi,pan_plani, pan_ren_vous,pan_propos ;
	public JLabel labpropos,id_p_cons,id_p_hospi1,id_p_diag,date_e,id_lit,id_svce,id_p_hospi2,date_s,diag_mal,diag_pers,diag_pds,diag_tem,diag_date,diag_pres,diag_gly,diag_sym,id_p_exam,id_exam,exam_pers,date_presc,id_p_resul,id_ord,ord_med,ord_pers,ord_pos,ord_nom,ord_prix,ord_date,plan_vac,id_p_rdv,rdv_date,rdv_pat,idvaccpat,nvacc,datevacc;
	public JTextField textdos,txtid_p1,txtdate_e,txtid_lit,txtid_svce,txtdate_s,txtid_p2,txtdiag,textmal,textpat,textpers,textpds,texttem,textdate,textpres,textgly,textsym,textexam,textexam1,textexam_pers,textres,textord,textord_med,textord_pers,textord_pos,textord_date,textord_nom,textord_prix,textrdv,textrdv_date,textrdv_pat,textvaccpat,textnvacc,textdatevacc;
	public JButton  butapropos2,butapropos1,butapropos,butquit,butban,butdos,butdiag,but_diag_enrg,but_diag_eff,butexam,butexam1,butexam2,butres,butord,butord_enrg,butord_clr, butnouv, butsort,buthospi_ok1,buthospi_eff1,buthospi_ok2,buthospi_eff2,buthosp_con,butrdv,butrdv_enrg,butrdv_clr,butrdv_cons,butrdv_ajout,butvacc0,butvacc;
	public JTabbedPane onglets;
	public JCheckBox  check,check1,check2,check3,check4,check5 ;
	public JComboBox combo,combo1,combo2;
	private Font font;
	public JTextArea areapropos12,areapropos1,areapropos,area,areados,areaexam,areadiag,areares,areares1,areaord,areahospi,areaplan1,areaplan,areardv,areardv1;
	public JScrollPane scrolldos,scrollres,scrollplan,scrollrdv,scrollpropos;
	public JButton icondos,icondiag,iconexam,iconres,iconord,iconhosp,iconplan,iconrdv;
	public static int id,n,a,b,ja,g,s,r1,id1,a3;
	public int a1,id_ex,i;
	//private  File file=null;
    public  JFileChooser fileChooser = new JFileChooser("cas/");
	
	//Definition des methodes. 
	
	public Fenetre(String service){
		 
		super (service);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(fileChooser);
		} catch (final Exception e) {
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//initialisation font
		
	    font = new Font("Cambria",Font.ITALIC,13);
	    
	    
	    //initialisation images
	    
	    
	    
	    icondos = new JButton(new ImageIcon("Images/icondos.png"));
	    icondos.setBounds(5, 5, 32, 50);
	    icondos.setBorderPainted(false);
	    
	    icondiag = new JButton(new ImageIcon("Images/icondiag.png"));
	    icondiag.setBounds(5, 5, 32, 50);
	    icondiag.setBorderPainted(false);
	    
	    iconexam = new JButton(new ImageIcon("Images/iconexam.png"));
	    iconexam.setBounds(5, 5, 32, 50);
	    iconexam.setBorderPainted(false);
	    
	    iconres = new JButton(new ImageIcon("Images/iconres.png"));
	    iconres.setBounds(5, 5, 32, 50);
	    iconres.setBorderPainted(false);
	    
	    iconord = new JButton(new ImageIcon("Images/iconord.png"));
	    iconord.setBounds(5, 5, 32, 50);
	    iconord.setBorderPainted(false);
	    
	    iconhosp = new JButton(new ImageIcon("Images/iconhosp.jpg"));
	    iconhosp.setBounds(5, 5, 60, 50);
	    iconhosp.setBorderPainted(false);
	    
	    iconplan = new JButton(new ImageIcon("Images/iconplan.png"));
	    iconplan.setBounds(5, 5, 32, 50);
	    iconplan.setBorderPainted(false);
	    
	    iconrdv = new JButton(new ImageIcon("Images/iconrdv.png"));
	    iconrdv.setBounds(5, 5, 32, 50);
	    iconrdv.setBorderPainted(false);
	    

	    // initialisation panneau
	    
	    pan_fenetre = new JPanel();
	    pan_consult = new JPanel();
	    pan_diag = new JPanel();
	    pan_presc_test = new JPanel();
	    pan_resul_exam =new JPanel();
        pan_presc_ordo = new JPanel();    
	    pan_hospi = new JPanel();
	    pan_plani = new JPanel();
	    pan_ren_vous = new JPanel();
	    pan_propos = new JPanel();
	    pan_exam = new JPanel();
	    
	    
	    
	    //initialisation des textfield
	    
	    textdos = new JTextField();
	    textdos.setVisible(true);
	    textdos.setBounds(200, 85, 200, 25);
	    

	    txtdiag = new  JTextField();
	    txtdiag.setEditable(true);
	    txtdiag.setBounds(200, 85, 200, 25);
	    
	    textmal= new  JTextField();
	    textmal.setBounds(190, 173, 150, 22);
	    textmal.setEditable(false);
	    
	    textpers = new  JTextField();
	    textpers.setBounds(570, 173, 150, 22);
	    textpers.setEditable(false);
	    
        textpds = new  JTextField();
	    textpds.setBounds(190, 212, 150, 22);
	    textpds.setEditable(false);
	    
        texttem = new  JTextField();
        texttem.setBounds(570, 212, 150, 22);
        texttem.setEditable(false);
        
	    textdate = new  JTextField();
	    textdate.setBounds(190, 253, 150, 22);
	    textdate.setEditable(false);
	    
	    textpres = new  JTextField();
	    textpres.setBounds(570, 253, 150, 22);
	    textpres.setEditable(false);
	    
	    textgly = new  JTextField();
	    textgly.setBounds(190, 292, 150, 22);
	    textgly.setEditable(false);
	    
	    textsym = new  JTextField();
	    textsym.setBounds(570, 292, 150, 22);
	    textsym.setEditable(false);
	    
	  
	    textexam = new JTextField();
	    textexam.setVisible(true);
	    textexam.setBounds(200, 85, 200, 25);
	    
	    textexam1= new  JTextField();
	    textexam1.setBounds(190, 205, 150, 22);
	    textexam1.setEditable(false);
	    textexam1.setText("Année-Jour-Mois");
	    
	    textexam_pers = new  JTextField();
	    textexam_pers.setBounds(570, 175, 150, 22);
	    textexam_pers.setEditable(false);
	    
	    
	    textres = new JTextField();
	    textres.setVisible(true);
	    textres.setBounds(200, 85, 200, 25);
	    
	    textord = new JTextField();
	    textord.setVisible(true);
	    textord.setBounds(200, 85, 200, 25);
	    
	    textord_med = new  JTextField();
	    textord_med.setBounds(190, 174, 150, 22);
	    textord_med.setEditable(false);
	    
	    textord_pers = new  JTextField();
	    textord_pers.setBounds(570, 174, 150, 22);
	    textord_pers.setEditable(false);
	    
	    textord_pos = new  JTextField();
	    textord_pos.setBounds(190, 213, 150, 22);
	    textord_pos.setEditable(false);
	    
	    textord_nom = new  JTextField();
	    textord_nom.setBounds(190, 252, 150, 22);
	    textord_nom.setEditable(false);
	    
	    textord_date = new  JTextField();
	    textord_date.setBounds(570, 213, 150, 22);
	    textord_date.setEditable(false);
	    
	    textord_prix = new  JTextField();
	    textord_prix.setBounds(570, 252, 150, 22);
	    textord_prix.setEditable(false);
	    
	    
	    txtid_p1 = new JTextField();
	    txtid_p1.setBounds(200, 85, 150, 25);
	    
	    txtdate_e = new JTextField();
	    txtdate_e.setBounds(190, 213, 150, 22);
	    txtdate_e.setEditable(false);
	    txtdate_e.setText("Année-Jour-Mois");
	    
	    txtid_lit = new JTextField();
	    txtid_lit.setBounds(570, 174, 150, 22);
	    txtid_lit.setEditable(false);
	    
	    txtid_svce = new JTextField();
	    txtid_svce.setBounds(190, 174, 150, 22);
	    txtid_svce.setEditable(false);
	    
	    txtdate_s = new JTextField();
	    txtdate_s.setBounds(570, 213, 150, 22);
	    txtdate_s.setEditable(false);
	    txtdate_s.setText("Année-Jour-Mois");
	    
	    
	    textrdv = new JTextField();
	    textrdv.setVisible(true);
	    textrdv.setBounds(210, 85, 200, 25);
	    
	    textrdv_pat = new JTextField();
	    textrdv_pat.setVisible(true);
	    textrdv_pat.setBounds(200, 124, 150, 22);
	    textrdv_pat.setEditable(false);
	    
	    textrdv_date = new JTextField();
	    textrdv_date.setVisible(true);
	    textrdv_date.setBounds(450, 124, 150, 22);
	    textrdv_date.setText("Année-Jour-Mois");
	    textrdv_date.setEditable(false);
	    
	    textvaccpat = new JTextField();
	    textvaccpat.setBounds(200, 90, 150, 18);
	    textvaccpat.setVisible(true);



	    
	    // initialisation jlabel
	    
	    id_p_cons = new JLabel("Identifiant du patient: ");
	    id_p_cons.setFont(new Font ("Cambria",Font.BOLD,14));
	    id_p_cons.setBounds(40, 90, 150, 18);
	    id_p_cons.setVisible(true);

	    
	    id_p_resul = new JLabel("Identifiant du patient: ");
	    id_p_resul.setFont(new Font ("Cambria",Font.BOLD,14));
	    id_p_resul.setBounds(40, 90, 150, 18);
	    id_p_resul.setVisible(true);
	    
	    
	    id_p_hospi1 = new JLabel("Identifiant du patient: ");
	    id_p_hospi1.setFont(new Font ("Cambria",Font.BOLD,14));
	    id_p_hospi1.setBounds(40, 90, 150, 18);
	    
	    date_e = new JLabel("Patient numero ");
	    date_e.setFont(new Font ("Cambria",Font.BOLD,14));
	    date_e.setBounds(40, 180, 150, 18);
	    
	    id_lit = new JLabel("Identifiant du lit: ");
	    id_lit.setFont(new Font ("Cambria",Font.BOLD,14));
	    id_lit.setBounds(400, 180, 150, 18);
	    
	    id_svce = new JLabel("Date d'entrée: ");
	    id_svce.setFont(new Font ("Cambria",Font.BOLD,14));
	    id_svce.setBounds(40, 220, 150, 18);
	    
	    date_s = new JLabel("Date de sortie: ");
	    date_s.setFont(new Font ("Cambria",Font.BOLD,14));
	    date_s.setBounds(400,220, 150, 18);



	    
	    id_p_diag = new JLabel("Identifiant du patient: ");
	    id_p_diag.setFont(new Font ("Cambria",Font.BOLD,14));
	    id_p_diag.setBounds(40, 90, 150, 18);
	    id_p_diag.setVisible(true); 
	    
	    diag_mal = new JLabel("Identifiant maladie:  ");
	    diag_mal.setFont(new Font ("Cambria",Font.BOLD,14));
	    diag_mal.setBounds(40, 180, 150, 18);
	    
	    diag_pers = new JLabel("Identifiant du personnel:  ");
	    diag_pers.setFont(new Font ("Cambria",Font.BOLD,14));
	    diag_pers.setBounds(400, 180, 170, 18);
	    
	    diag_pds = new JLabel("Poids:  ");
	    diag_pds.setFont(new Font ("Cambria",Font.BOLD,14));
	    diag_pds.setBounds(40, 220, 150, 18);
	    
	    diag_tem = new JLabel("Temperature:  ");
	    diag_tem.setFont(new Font ("Cambria",Font.BOLD,14));
	    diag_tem.setBounds(400, 220, 150, 18);
	    
	    diag_date = new JLabel("Date diagnostique: ");
	    diag_date.setFont(new Font ("Cambria",Font.BOLD,14));
	    diag_date.setBounds(40, 260, 150, 18);
	    
	    diag_pres = new JLabel("Pression: ");
	    diag_pres.setFont(new Font ("Cambria",Font.BOLD,14));
	    diag_pres.setBounds(400, 260, 150, 18);
	    
	    diag_gly = new JLabel("Taux de glycemie: ");
	    diag_gly.setFont(new Font ("Cambria",Font.BOLD,14));
	    diag_gly.setBounds(40, 300, 150, 18);
	    
	    diag_sym = new JLabel("Symptomes: ");
	    diag_sym.setFont(new Font ("Cambria",Font.BOLD,14));
	    diag_sym.setBounds(400, 300, 150, 18);
	    
	    
	    id_p_exam = new JLabel("Identifiant du patient: ");
	    id_p_exam.setFont(new Font ("Cambria",Font.BOLD,14));
	    id_p_exam.setBounds(40, 90, 150, 18);
	    id_p_exam.setVisible(true);
	    
	    ord_nom = new JLabel("Nom medicament : ");
	    ord_nom.setFont(new Font ("Cambria",Font.BOLD,14));
	    ord_nom.setBounds(40, 255, 150, 18);
	    ord_nom.setVisible(true);
	    
	    
	    
	    id_exam = new JLabel("Nom examen: ");
	    id_exam.setFont(new Font ("Cambria",Font.BOLD,14));
	    id_exam.setBounds(40, 180, 150, 18);
	    
	    exam_pers = new JLabel("Identifiant personnel: ");
	    exam_pers.setFont(new Font ("Cambria",Font.BOLD,14));
	    exam_pers.setBounds(400, 180, 150, 18);
	    
	    date_presc = new JLabel("Date prescription: ");
	    date_presc.setFont(new Font ("Cambria",Font.BOLD,14));
	    date_presc.setBounds(40, 210, 150, 18);
	    
	    
	    id_ord = new JLabel("Identifiant du patient: ");
	    id_ord.setFont(new Font ("Cambria",Font.BOLD,14));
	    id_ord.setBounds(40, 90, 150, 18);
	    id_ord.setVisible(true);
	    
	    ord_med = new JLabel("Numero medicament: ");
	    ord_med.setFont(new Font ("Cambria",Font.BOLD,14));
	    ord_med.setBounds(40, 180, 150, 18);
	    
	    ord_pers = new JLabel("Identifiant personnel: ");
	    ord_pers.setFont(new Font ("Cambria",Font.BOLD,14));
	    ord_pers.setBounds(400, 180, 150, 18);
	    
	    ord_pos = new JLabel("Posologie: ");
	    ord_pos.setFont(new Font ("Cambria",Font.BOLD,14));
	    ord_pos.setBounds(40, 220, 150, 18);
	    
	    ord_date = new JLabel("Date de prescription: ");
	    ord_date.setFont(new Font ("Cambria",Font.BOLD,14));
	    ord_date.setBounds(400,220, 150, 18);
	    
	    
	    
	    
	    id_p_rdv = new JLabel("Identifiant du personnel: ");
	    id_p_rdv.setFont(new Font ("Cambria",Font.BOLD,14));
	    id_p_rdv.setBounds(40, 90, 170, 18);
	    id_p_rdv.setVisible(true);
	    
	    rdv_pat = new JLabel("Identifiant du patient: ");
	    rdv_pat.setFont(new Font ("Cambria",Font.BOLD,14));
	    rdv_pat.setBounds(40, 130, 170, 18);
	    rdv_pat.setVisible(true);
	    
	    rdv_date = new JLabel("date : ");
	    rdv_date.setFont(new Font ("Cambria",Font.BOLD,14));
	    rdv_date.setBounds(400, 130, 170, 18);
	    rdv_date.setVisible(true);
	    
	    idvaccpat = new JLabel("Identifiant du patient: ");
	    idvaccpat.setFont(new Font ("Cambria",Font.BOLD,14));
	    idvaccpat.setBounds(40, 90, 150, 18);
	    idvaccpat.setVisible(true);
	    
	    datevacc = new JLabel("date de prise : ");
	    datevacc.setFont(new Font ("Cambria",Font.BOLD,14));
	    datevacc.setBounds(40, 150, 150, 18);
	    datevacc.setVisible(true);
	    
	    
	    nvacc = new JLabel(" vaccin : ");
	    nvacc.setFont(new Font ("Cambria",Font.BOLD,14));
	    nvacc.setBounds(40, 120, 150, 18);
	    nvacc.setVisible(true);





	    
	    //initialisation jtextarea
	    
	    area= new JTextArea();
	    area.setFont(new Font ("Cambria",Font.BOLD,14));
	    area.setText("                  Dossier \n");
	    area.append("   Le module Dossier permet de consulter le dossier d'un patient en entrant son numero d'identification.");   
	    area.setEditable(false);
	    area.setBackground(Color.white);
	    area.setBounds(37,5,747,50);
	      
	    areados= new JTextArea();
	    areados.setEditable(false);
	    areados.setFont(new Font ("Cambria",Font.ITALIC,14)); 
	    areados.setBackground(Color.white);
	    areados.setVisible(true);
	    
	    
	    areadiag= new JTextArea();
	    areadiag.setFont(new Font ("Cambria",Font.BOLD,14));
	    areadiag.setText("              Diagnostique \n");
	    areadiag.append("   Le module Diagnostique permet d'etablir le  diagnostique d'un patient en entrant son numero d'identification.");   
	    areadiag.setEditable(false);
	    areadiag.setBackground(Color.white);
	    areadiag.setBounds(37,5,747,50);
	    
	    areapropos= new JTextArea();
	    areapropos.setFont(new Font ("Cambria",Font.BOLD,14));
	    areapropos.setText("              A propos \n");
	    areapropos.append("   Cette rubrique présente les membres du groupe de conception du module et leur quotta de participation au travail .");   
	    areapropos.setEditable(false);
	    areapropos.setBackground(Color.white);
	    areapropos.setBounds(37,5,747,50);
	    
	    areapropos12= new JTextArea();
	    areapropos12.setEditable(false);
	    areapropos12.setFont(new Font ("Cambria",Font.ITALIC,14));
	    areapropos12.setText("NOMS ET PRENOMS                                                                                                              MATRICULE           ");
	    areapropos12.append("\n\n\n1)    FOKO SINDJOUNG MIGUEL LANDRY                                                                      CM04 - O9SCI0030");
	    areapropos12.append("\n\n  2)    NOUDEM TIOFOUET AURELIE	                                                         CM04 – 08SCI0413");
	    areapropos12.append("\n\n  3)    NGUEFACK BRICE	                                                                                        CM04 – 09SCI0055");
	    areapropos12.append("\n\n  4)    DJOUAZONG TENE CELESTINE	                                                          CM04 – 09SCI0053");
	    areapropos12.append("\n\n  5)    BIEMEWOU YONTA JEAN	                                                            CM04 – 08SCI0503");
	    areapropos12.append("\n\n  6)    DJITEU TANFACK DIANE	                                                                                        CM04 – 09SCI0015");
	    areapropos12.append("\n\n  7)    FOTSO SADO ALEX YVAN	                                                           CM04 – 08SCI1571");
	    areapropos12.append("\n\n  8)    KAMENI SITCHEU MICHELLE CARINE	                                                          CM04 – 08SCI0397");
	    areapropos12.append("\n\n  9)    KENGNE NADINE ZAZINE	                                                         CM04 – 09SCI0010");
	    areapropos12.append("\n\n  10)   FONKOU KENGNI  MICHEL  F.	                                                         CM04 – 09SCI0812");
	    areapropos12.append("\n\n  11)   DJITSOP MICHAEL	                                                                                     CM04 – 09SCI1600");

	    areapropos12.setBackground(Color.white);
	    areapropos12.setVisible(false);
	    
	    
	    areaexam= new JTextArea();
	    areaexam.setFont(new Font ("Cambria",Font.BOLD,14));
	    areaexam.setText("              Examens \n");
	    areaexam.append("   Le module Examens vous permet choisir les examens à faire passer à un patient.");   
	    areaexam.setEditable(false);
	    areaexam.setBackground(Color.white);
	    areaexam.setBounds(37,5,747,50);
	    
	    
	    areares= new JTextArea();
	    areares.setFont(new Font ("Cambria",Font.BOLD,14));
	    areares.setText("              Resultat \n");
	    areares.append("   Le module Resultat permet de connaître les différents résultats d'examen du patient.");
	    areares.setEditable(false);
	    areares.setBackground(Color.white);
	    areares.setBounds(37,5,747,50);
	      
	    areares1= new JTextArea();
	    areares1.setEditable(false);
	    areares1.setFont(new Font ("Cambria",Font.ITALIC,14)); 
	    areares1.setBackground(Color.white);
	    areares1.setVisible(true);
	    
	    
	    areaord= new JTextArea();
	    areaord.setFont(new Font ("Cambria",Font.BOLD,14));
	    areaord.setText("              Ordonnance \n");
	    areaord.append("   Le module Ordonnance permet d'etablir une ordonnance qui sera remis au patient.");
	    areaord.setEditable(false);
	    areaord.setBackground(Color.white);
	    areaord.setBounds(37,5,747,50);
	    
	    
	    areahospi= new JTextArea();
	    areahospi.setFont(new Font ("Cambria",Font.BOLD,14));
	    areahospi.setText("              Hospitalisation \n");
	    areahospi.append("   Le module hospitalisation permet d'enregistrer les patients internés ou de mettre à jour leur date de sortie.");   
	    areahospi.setEditable(false);
	    areahospi.setBackground(Color.white);
	    areahospi.setBounds(65,5,719,50);
	    
	    
	    areaplan= new JTextArea();
	    areaplan.setFont(new Font ("Cambria",Font.BOLD,14));
	    areaplan.setText("              Planning vaccination \n");
	    areaplan.append("   Le module Planning vaccination permet d'enregistrer les horaires de vaccination d'un nouveau ne.");   
	    areaplan.setEditable(false);
	    areaplan.setBackground(Color.white);
	    areaplan.setBounds(37,5,747,50);
	    
	    areaplan1= new JTextArea();
	    areaplan1.setEditable(false);
	    areaplan1.setFont(new Font ("Cambria",Font.ITALIC,14));
	    areaplan1.setBackground(new Color(172,172,172));
	    areaplan1.setVisible(true);
	    
	    
	    areardv= new JTextArea();
	    areardv.setFont(new Font ("Cambria",Font.BOLD,14));
	    areardv.setText("              Rendez-vous \n");
	    areardv.append("   Le module Rendez-vous permet au personnel medical de consulter ses rendez-vous et d'enregistrer d'autres.");   
	    areardv.setEditable(false);
	    areardv.setBackground(Color.white);
	    areardv.setBounds(37,5,747,50);
	    
	    areardv1= new JTextArea();
	    areardv1.setEditable(false);
	    areardv1.setFont(new Font ("Cambria",Font.ITALIC,14));
	    areardv1.setEditable(false);
	    areardv1.setBackground(Color.white);
	    areardv1.setVisible(true);
	    areardv1.setBounds(37,220,745,130);
	    
	    
	    //initialisation bouton
	    
	     
	    butban = new JButton(new ImageIcon("Images/Banniere.png"));
	    butban.setBounds(0, 0,840 , 112);
	    butban.setBorderPainted(false); 
	    
	    butapropos = new JButton(new ImageIcon("Images/icondos.png"));
	    butapropos.setBounds(5, 5, 32, 50);
	    butapropos.setBorderPainted(false);
	    
	    butdos = new JButton("Valider ");
        butdos.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butdos.setBounds(425, 85,105 ,25);
	    butdos.setCursor(new Cursor(12));

	    butdiag = new JButton("Connection");
        butdiag.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butdiag.setBounds(425, 85,105 ,25);
	    butdiag.setCursor(new Cursor(12));
	    
	    but_diag_enrg = new JButton("Enregistrer");
	    but_diag_enrg.setFont(new Font ("Cambria",Font.ITALIC,13));
	    but_diag_enrg.setBounds(400, 335,95 ,25);
	    but_diag_enrg.setEnabled(false);
	    but_diag_enrg.setCursor(new Cursor(12));
	    
	    but_diag_eff = new JButton("Annuler");
	    but_diag_eff.setFont(new Font ("Cambria",Font.ITALIC,13));
	    but_diag_eff.setBounds(570, 335,95 ,25);
	    but_diag_eff.setEnabled(false);
	    but_diag_eff.setCursor(new Cursor(12));
	    
	    
	    butexam = new JButton("Connection");
        butexam.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butexam.setBounds(425, 85,105 ,25);
	    butexam.setCursor(new Cursor(12));
	    
	    butexam1 = new JButton("Enregistrer");
        butexam1.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butexam1.setBounds(255, 280,95 ,25);
	    butexam1.setEnabled(false);
	    butexam1.setCursor(new Cursor(12));
	    
	    butexam2 = new JButton("Annuler");
        butexam2.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butexam2.setBounds(445, 280,95 ,25);
	    butexam2.setEnabled(false);
	    butexam2.setCursor(new Cursor(12));
	    
	    
	    butres = new JButton("Connection");
        butres.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butres.setBounds(425, 85,105 ,25);
	    butres.setCursor(new Cursor(12));
	    
	    butapropos1 = new JButton("liste des membres");
	    butapropos1.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butapropos1.setBounds(425, 85,205 ,25);
	    butapropos1.setCursor(new Cursor(12));
	    
	    butapropos2 = new JButton("volume horaire");
	    butapropos2.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butapropos2.setBounds(125, 85,205 ,25);
	    butapropos2.setCursor(new Cursor(12));
	    
        
	    butord = new JButton("Connection");
        butord.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butord.setBounds(425, 85,105 ,25);
	    butord.setCursor(new Cursor(12));
	    
	    butord_enrg = new JButton("Enregistrer");
	    butord_enrg.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butord_enrg.setBounds(255, 285,95 ,25);
	    butord_enrg.setEnabled(false);
	    butord_enrg.setCursor(new Cursor(12));
	    
	    butord_clr = new JButton("Annuler");
	    butord_clr.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butord_clr.setBounds(445, 285,95 ,25);
	    butord_clr.setEnabled(false);
	    butord_clr.setCursor(new Cursor(12));
	    
	    
	    butquit = new JButton();
	    butquit.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butquit.setText("Quitter");
	    butquit.setBounds(700, 530,95 ,25);
	    butquit.setBorderPainted(true);
	    butquit.setMnemonic('q');
	    butquit.setCursor(new Cursor(12));
	    
	    
	    buthosp_con = new JButton("Connection");
	    buthosp_con.setFont(new Font ("Cambria",Font.ITALIC,13));
	    buthosp_con.setBounds(380, 85, 105, 25);
	    buthosp_con.setCursor(new Cursor(12));
	    
	    butnouv = new JButton("Interner");
	    butnouv.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butnouv.setBounds(520, 85, 95, 25);
	    butnouv.setMnemonic('i');
	    butnouv.setEnabled(false);
	    butnouv.setCursor(new Cursor(12));
	    
	    butsort = new JButton("Sortie");
	    butsort.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butsort.setBounds(655, 85, 95, 25);
	    butsort.setMnemonic('s');
	    butsort.setEnabled(false);
	    butsort.setCursor(new Cursor(12));
	    
	    buthospi_ok1 = new JButton("Enregistrer");
        buthospi_ok1.setFont(new Font ("Cambria",Font.ITALIC,13));
	    buthospi_ok1.setBounds(255, 285,95 ,25);
	    buthospi_ok1.setEnabled(false);
	    buthospi_ok1.setCursor(new Cursor(12));
	    
	    buthospi_eff1 = new JButton("Annuler");
        buthospi_eff1.setFont(new Font ("Cambria",Font.ITALIC,13));
	    buthospi_eff1.setBounds(445, 285,95 ,25);
	    buthospi_eff1.setEnabled(false);
	    buthospi_eff1.setCursor(new Cursor(12));
	    
	    
	    
	    butrdv = new JButton("Connection");
	    butrdv.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butrdv.setBounds(425, 85,105 ,25);
	    butrdv.setCursor(new Cursor(12));

	    butrdv_enrg = new JButton("Enregistrer");
	    butrdv_enrg.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butrdv_enrg.setBounds(255, 170,95 ,25);
	    butrdv_enrg.setEnabled(false);
	    butrdv_enrg.setCursor(new Cursor(12));
	    
	    butrdv_clr = new JButton("Annuler");
	    butrdv_clr.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butrdv_clr.setBounds(445, 170,95 ,25);
	    butrdv_clr.setEnabled(false);
	    butrdv_clr.setCursor(new Cursor(12));
	    
	    butrdv_cons = new JButton("Consulter");
	    butrdv_cons.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butrdv_cons.setBounds(555, 85,95 ,25);
	    butrdv_cons.setEnabled(false);
	    butrdv_cons.setMnemonic('c');
	    butrdv_cons.setCursor(new Cursor(12));
	    
	    butrdv_ajout = new JButton("Ajouter");
	    butrdv_ajout.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butrdv_ajout.setBounds(675, 85,95 ,25);
	    butrdv_ajout.setEnabled(false);
	    butrdv_ajout.setMnemonic('a');
	    butrdv_ajout.setCursor(new Cursor(12));
	    
	    butvacc = new JButton("enregistrer");
        butvacc.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butvacc.setBounds(400, 120, 150, 18);
	    butvacc.setEnabled(false);
	    
	    butvacc0 = new JButton("connection");
	    butvacc0.setFont(new Font ("Cambria",Font.ITALIC,13));
	    butvacc0.setBounds(400, 90, 150, 18);



	    
	    //initialisation des scroll
	    
	    scrolldos = new JScrollPane(areados);
	    scrolldos.setBounds(10, 130, 780, 220);
	    
	    scrollres = new JScrollPane(areares1);
	    scrollres.setBounds(10, 130, 780, 220);
	    
	    scrollplan = new JScrollPane(areaplan1);
	    scrollplan.setBounds(10, 130, 780, 220);
	    scrollplan.setBackground(new Color(172,172,172));
	    
	    scrollrdv = new JScrollPane(areardv1);
	    scrollrdv.setBounds(10, 130, 780, 220);
	    scrollrdv.setVisible(false);
	    
	    scrollpropos = new JScrollPane(areapropos12);
	    scrollpropos.setBounds(10, 130, 780, 220);
	    scrollpropos.setVisible(false);
	    
	    //initialisation des JComboBox
	    
	    /*textexam1= new  JTextField();
	    textexam1.setBounds(190, 175, 150, 22);
	    textexam1.setEditable(false);*/
	    
	    combo = new JComboBox();
	    combo.addItem("Goutte épaisse");
	    combo.addItem("Examen des selles");
	    combo.addItem("Examen d'urine");
	    combo.addItem("Radiographie");
	    combo.addItem("Echographie");
	    combo.addItem("Widal");
	    combo.addItem("Test de VIH");
	    combo.addItem("Examen de crasha");
	    combo.addItem("Glycémie");
	    combo.addItem("Examen de Ca,Mg,K");
	    combo.addItem("Felix");
	    combo.setBackground(Color.white);
	    combo.setBounds(190, 175, 150, 22);
	    combo.setSelectedIndex(2);
	    combo.setEditable(false);
	    
	    combo1 = new JComboBox();
	    combo1.addItem("BCG");
	    combo1.addItem("POLIO 0");
	    combo1.addItem("DTCOQ 1");
	    combo1.addItem("HEP B1");
	    combo1.addItem("POLIO 2");
	    combo1.addItem("DTCOQ 2");
	    combo1.addItem("HEP B2");
	    combo1.addItem("PLOLIO 3");
	    combo1.addItem("DTCOQ 3");
	    combo1.addItem("HEP B3");
	    combo1.addItem("VAR");
	    combo1.addItem("VAA");
	    combo1.addItem("VIT A");
	    combo1.setBackground(Color.white);
	    combo1.setBounds(200, 120, 150, 18);
	    combo1.setSelectedIndex(2);
	    combo1.setEditable(false);
	    
	    combo2 = new JComboBox();
	    combo2.addItem("à la naissance");
	    combo2.addItem("à 6 semaines");
	    combo2.addItem("à 10 semaines");
	    combo2.addItem("à 14 semaines");
	    combo2.addItem("à 9 mois");
	    combo2.setBackground(Color.white);
	    combo2.setBounds(200, 150, 150, 18);
	    combo2.setSelectedIndex(2);
	    combo2.setEditable(false);
	 

	    
	    //ajout ds les panneaux
	    
	    pan_fenetre.setLayout(null);
	    pan_fenetre.setBackground(new Color(255,255,255));
	    pan_fenetre.setBorder(BorderFactory.createLineBorder(Color.black, 0));
	    
	    pan_consult.setLayout(null);
	    pan_consult.setBounds(7, 110, 800, 400);
	    pan_consult.setBackground(new Color(172,172,172));
	    pan_consult.add(area);
	    pan_consult.add(id_p_cons);
	    pan_consult.add(textdos);
	    pan_consult.add(butdos);
	    pan_consult.add(scrolldos);
	    pan_consult.add(icondos);
	    
	        
	    pan_diag.setLayout(null);
	    pan_diag.setBounds(7, 110, 800, 400);
	    pan_diag.setBackground(new Color(172,172,172));
	    pan_diag.add(areadiag);
	    pan_diag.add(id_p_diag);
	    pan_diag.add(txtdiag);
	    pan_diag.add(butdiag);
	    pan_diag.add(diag_mal);
	    pan_diag.add(diag_pers);
	    pan_diag.add(diag_pds);
	    pan_diag.add(diag_tem);
	    pan_diag.add(diag_date);
	    pan_diag.add(diag_pres);
	    pan_diag.add(diag_gly);
	    pan_diag.add(diag_sym);
	    pan_diag.add(textmal);
	    pan_diag.add(textpers);
	    pan_diag.add(textpds);
	    pan_diag.add(texttem);
	    pan_diag.add(textdate);
	    pan_diag.add(textpres);
	    pan_diag.add(textgly);
	    pan_diag.add(textsym);
	    pan_diag.add(but_diag_enrg);
	    pan_diag.add(but_diag_eff);
	    pan_diag.add(icondiag);
	    
	    
	    pan_presc_test.setLayout(null);
	    pan_presc_test.setBounds(7, 110, 800, 400);
	    pan_presc_test.setBackground(new Color(172,172,172));
	    pan_presc_test.add(areaexam);
	    pan_presc_test.add(id_p_exam);
	    pan_presc_test.add(textexam);
	    pan_presc_test.add(butexam);
	    pan_presc_test.add(textexam1);
	    pan_presc_test.add(combo);
	    pan_presc_test.add(textexam_pers);
	    pan_presc_test.add(date_presc);
        pan_presc_test.add(exam_pers);
        pan_presc_test.add(id_exam);
	    pan_presc_test.add(butexam1);
	    pan_presc_test.add(butexam2);
	    pan_presc_test.add(iconexam);
	    
	    
	    pan_resul_exam.setLayout(null);
	    pan_resul_exam.setBounds(7, 110, 800, 400);
	    pan_resul_exam.setBackground(new Color(172,172,172));
	    pan_resul_exam.add(areares);
	    pan_resul_exam.add(id_p_resul);
	    pan_resul_exam.add(textres);
	    pan_resul_exam.add(butres);
	    pan_resul_exam.add(scrollres);
	    pan_resul_exam.add(iconres);
	    
	    
	    pan_presc_ordo.setLayout(null);
	    pan_presc_ordo.setBounds(7, 110, 800, 400);
	    pan_presc_ordo.setBackground(new Color(172,172,172));
	    pan_presc_ordo.add(areaord);
	    pan_presc_ordo.add(id_ord);
	    pan_presc_ordo.add(textord);
	    pan_presc_ordo.add(butord);
	    pan_presc_ordo.add(textord_med);
	    pan_presc_ordo.add(textord_pers);
	    pan_presc_ordo.add(textord_pos);
	    pan_presc_ordo.add(textord_date);
	    pan_presc_ordo.add(ord_med);
	    pan_presc_ordo.add(ord_pers);
	    pan_presc_ordo.add(ord_pos);
	    pan_presc_ordo.add(ord_date);
	    pan_presc_ordo.add(butord_enrg);
	    pan_presc_ordo.add(butord_clr);
	    pan_presc_ordo.add(iconord);
	    //pan_presc_ordo.add(textord_nom);
	    //pan_presc_ordo.add(textord_prix);
	    pan_presc_ordo.add(textord_med);
	    //pan_presc_ordo.add(ord_nom);
	    
	    
	    pan_hospi.setLayout(null);
	    pan_hospi.setBounds(7, 110, 800, 400);
	    pan_hospi.setBackground(new Color(172,172,172));
	    pan_hospi.add(areahospi);
	    pan_hospi.add(butnouv);
	    pan_hospi.add(butsort);
	    pan_hospi.add(id_p_hospi1);
	    pan_hospi.add(date_e);
	    pan_hospi.add(id_lit);
	    pan_hospi.add(id_svce);
	    pan_hospi.add(txtid_p1);
	    pan_hospi.add(txtdate_e);
	    pan_hospi.add(txtid_lit);
	    pan_hospi.add(txtid_svce);
	    pan_hospi.add(buthospi_ok1);
	    pan_hospi.add(buthospi_eff1);
	    pan_hospi.add(date_s);
	    pan_hospi.add(txtdate_s);
	    pan_hospi.add(iconhosp);
	    pan_hospi.add(buthosp_con);
	    
	    
	    pan_plani.setLayout(null);
	    pan_plani.setBounds(7, 110, 800, 400);
	    pan_plani.setBackground(new Color(172,172,172));
	    pan_plani.add(areaplan);
	    pan_plani.add(iconplan);
	    pan_plani.add(butvacc);
	    pan_plani.add(butvacc0);
	    pan_plani.add(idvaccpat);
	    pan_plani.add(textvaccpat);
	    pan_plani.add(nvacc);
	    pan_plani.add(datevacc);
	    pan_plani.add(combo1);
	    pan_plani.add(combo2);
	    
	    
	    
	    pan_ren_vous.setLayout(null);
	    pan_ren_vous.setBounds(7, 110, 800, 400);
	    pan_ren_vous.setBackground(new Color(172,172,172));
	    pan_ren_vous.add(areardv);
	    pan_ren_vous.add(areardv1);
	    pan_ren_vous.add(id_p_rdv);
	    pan_ren_vous.add(scrollrdv);
	    pan_ren_vous.add(butrdv);
	    pan_ren_vous.add(butrdv_clr);
	    pan_ren_vous.add(butrdv_enrg);
	    pan_ren_vous.add(textrdv);
	    pan_ren_vous.add(butrdv_cons);
	    pan_ren_vous.add(butrdv_ajout);
	    pan_ren_vous.add(rdv_pat);
	    pan_ren_vous.add(rdv_date);
	    pan_ren_vous.add(textrdv_date);
	    pan_ren_vous.add(textrdv_pat);
	    pan_ren_vous.add(iconrdv);
	    
	   
	    pan_propos.setLayout(null);
	    pan_propos.setBounds(7, 110, 800, 400);
	    pan_propos.setBackground(new Color(172,172,172));
	    pan_propos.add(areapropos);
	    
        pan_propos.add(butapropos);
        pan_propos.add(butapropos1);
        pan_propos.add(butapropos2);
        pan_propos.add(butapropos);
        pan_propos.add(scrollpropos);
        //Ajout du gestionnaire des évènements
	    
        butdos.addActionListener(this);
	    buthosp_con.addActionListener(this);
	    butquit.addActionListener(this);
	    butnouv.addActionListener(this);
	    butsort.addActionListener(this);
	    buthospi_eff1.addActionListener(this);
	    buthospi_ok1.addActionListener(this);
	    butres.addActionListener(this);
	    butexam.addActionListener(this);
	    butexam1.addActionListener(this);
	    butexam2.addActionListener(this);
	    butapropos1.addActionListener(this);
	    butapropos2.addActionListener(this);
	    butdiag.addActionListener(this);
	    but_diag_enrg.addActionListener(this);
	    but_diag_eff.addActionListener(this);
	    butvacc0.addActionListener(this);
	    butvacc.addActionListener(this);
	    butord.addActionListener(this);
	    butord_enrg.addActionListener(this);
	    butord_clr.addActionListener(this);
	    butrdv_enrg.addActionListener(this);
		butrdv.addActionListener(this);
		butrdv_cons.addActionListener(this);
	    butrdv_clr.addActionListener(this);
	    butrdv_ajout.addActionListener(this);
	   
	    
	   
	    
	    //initialisation des onglets
	    
	    onglets = new JTabbedPane();
	    onglets.addTab("Dossier", pan_consult);
	    onglets.addTab("Diagnostiques", pan_diag);
	    onglets.addTab("Examens", pan_presc_test);
	    onglets.addTab("Resultats", pan_resul_exam);
	    onglets.addTab("Ordonnance", pan_presc_ordo);
	    onglets.addTab("Hospitalisation", pan_hospi);
	    onglets.addTab("Planning vaccination", pan_plani);
	    onglets.addTab("Rendez-vous", pan_ren_vous);
	    onglets.addTab("A propos", pan_propos);
	    
	    onglets.setBounds(7, 110, 800, 400);
	    onglets.setOpaque(false);
	    onglets.setAutoscrolls(true);
	    onglets.setFont(font);
	    onglets.setBackground(Color.white);
	    this.setSize(822, 600);
	    
	    
	    pan_fenetre.add(onglets);
	    pan_fenetre.add(butban);
	    pan_fenetre.add(butquit);
	    this.getContentPane().add(pan_fenetre);
	    this.setVisible(true);
	    this.setLocation(125,80);
	    this.setResizable(false);
	    
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source= e.getSource();
		
		if( source == butvacc0){
			try {
				try {
					a1= format.parse(this.textvaccpat.getText(),new ParsePosition(0)).intValue();
				} catch (RuntimeException e1) {
					 JOptionPane.showMessageDialog(null," l\'identifiant entré est incorecte", "Message d'alerte", JOptionPane.WARNING_MESSAGE);

				}
				n = format.parse(textvaccpat.getText(),new ParsePosition(0)).intValue();
				//JOptionPane.showMessageDialog(null,"l'identifiant pris en compte est "+n,": l'identifiant doit etre un entier", JOptionPane.WARNING_MESSAGE);
				System.out.println("pas mal");
				if(hello.connecter(n)){
					butvacc.setEnabled(true);

					//butsort.setEnabled(true);
					
				}
				
				else{
					JOptionPane.showMessageDialog(null," l\'identifiant entré est incorecte", "Message d'alerte", JOptionPane.WARNING_MESSAGE);
					textvaccpat.setText("");
				}
			}
			
			
			catch(Exception ke){
				
                   System.out.println("erreur vaccin "+ke);
                   textvaccpat.setText("");
			}
		    
		
		}
				

	
	if (source==butvacc){
		try{
			 String q=this.textvaccpat.getText();
			 int n = format.parse(q, new ParsePosition(0)).intValue();
		int b=combo1.getSelectedIndex();
		int j=b+1;
		String ch= (String)combo2.getSelectedItem();
		hello.recevoir(n,j,ch);
		textvaccpat.setText("");
		 JOptionPane.showMessageDialog(null,"ENREGISTREMENT EFFECTUE ", "Message d'alerte", JOptionPane.WARNING_MESSAGE);
	    butvacc.setBounds(400, 120, 150, 18);
		}
		catch(Exception ex){
			System.out.println("erreur"+ex);
		}
	}

		try{
			
			if(source==butdos){
				//conversion de mon argument en entier

   			 try {
					a1= format.parse(this.textdos.getText(),new ParsePosition(0)).intValue();
				} catch (RuntimeException e1) {
					 JOptionPane.showMessageDialog(null," l\'identifiant entré est incorecte", "Message d'alerte", JOptionPane.WARNING_MESSAGE);

				}
				String q=this.textdos.getText();
				 int n = format.parse(q, new ParsePosition(0)).intValue();
				 if (!hello.connecter(n)){
					 JOptionPane.showMessageDialog(null," ce patient n\'existe pas da\n cet hopital", "Message d'alerte", JOptionPane.WARNING_MESSAGE);

				}
				else{
				 
				String[] s1= hello.RecupereNom(n);
				String[][] s2= hello.RecupereExamensPrescrit(n);
			    if(s2[4]!=null){
				    areados.setText("NOM DU PATIENT:  "+s1[2]+"   \n\nPRENOM: "+s1[3]+"  "+"   \n\n DATE DE NAISSANCE:    "+s1[4]+" - "+s1[5]+" - "+s1[6]);
		            int i=0,j=0;
				    String[] s3=hello.RecupereExamen(s2[i][1]);
				    String[] s4=hello.RecupereLaborantin(s2[i][1]);
				    String[] s5=hello.RecupereMedecin(s2[i][1]);
				    int z=1;
			    	while(!s2[i][j].equals(null)){
			       	    System.out.println("dutout1");
				   	    areados.setBackground( Color.white);
				        areados.append("\n\n\n                                                    EXAMEN N°"+z+":   "+s3[0]+"\n\n DATE DE PRESCRIPTION:    "+s2[i][4]+"\n\nMEDECIN PRESCRIPTEUR:  "+s5[4]+s5[5]+"\n\nSPECIALISE EN: "+s5[3]+"\n\nEXAMEN EFFECTIVEMENT EFFECTUE DANS LE LABO  "+s2[i][7]);
				        areados.append("\n\nPAR LE LABORANTIN:  "+s4[4]+""+s4[5]+"\n\nEN SA QUALITE DE: "+s4[6]+"\n\nET POUR GRADE:  "+s4[7]+"\n\nRESULTAT DUDIT EXAMEN: "+s2[i][6]);
				        System.out.println(s1[1]);
				        areados.setVisible(true); 
				        z++;
				        i++;
			    	}
			    }
				  else{
						 JOptionPane.showMessageDialog(null,"le dossier de ce patient est encore vide", "Message d'alerte", JOptionPane.WARNING_MESSAGE);

				  }
			  }
			}
			
			if(source == butquit){
				System.exit(0);
				}
    		
            ////////////////////////Gestion du bouton interner
			
			if(source == butnouv){
    			
				String[] st=new String[3];
				st=hello.sortir1(n);
				if(st[0]==null){
					buthospi_ok1.setEnabled(true);
					buthospi_eff1.setEnabled(true);
    			    txtdate_e.setEditable(true);
    			    txtid_lit.setEditable(true);
    			    txtdate_s.setEditable(false);
    			    txtid_svce.setText("   "+n);
    			    txtid_p1.setEditable(false);
    			    buthosp_con.setEnabled(false);
    		        ja=1;
				}
				else{
    				JOptionPane.showMessageDialog(null,	"Patient encore en salle d'hospitalisation", "Hospitalisation", JOptionPane.WARNING_MESSAGE);
    				butsort.setEnabled(false);
   	    		    buthospi_ok1.setEnabled(false);
   	    		    buthosp_con.setEnabled(true);
   	    		    txtdate_e.setEditable(false);
   	    		    txtdate_e.setText("Année-mois-jour");
   	    		    txtid_lit.setEditable(false);
   	    		    txtid_lit.setText("");
   	    		    txtdate_s.setEditable(false);
   	    		    txtdate_s.setText("Année-mois-jour");
   	    		    txtid_svce.setEditable(false);
   	    		    txtid_svce.setText("");
   	    		    txtid_p1.setEditable(true);
   	    		    txtid_p1.setText("");
   	    		    butnouv.setEnabled(false);
   	    		    buthospi_eff1.setEnabled(false);
				}
    			
    			
    		}
			///////////////////gestion du paneau a propos
			if(source==butapropos1 ){
				try{
					scrollpropos.setVisible(true);
					areapropos12.setVisible(true);
					
				}catch(Exception ed){}
			}
    		
//////////////////////////Gestion du bouton sortant
    		
            if(source == butsort){
            	
    			String[] st=new String[3];
    			
    			st = hello.sortir1(n);
    			
    			if(st[0]==null){
    				JOptionPane.showMessageDialog(null,	"Patient déjà sorti de la salle d'hospitalisation", "Hospitalisation", JOptionPane.WARNING_MESSAGE);
    				butsort.setEnabled(false);
	    			buthospi_ok1.setEnabled(false);
	    			buthosp_con.setEnabled(true);
	    			txtdate_e.setEditable(false);
	    			txtdate_e.setText("Année-mois-jour");
	    			txtid_lit.setEditable(false);
	    			txtid_lit.setText("");
	    			txtdate_s.setEditable(false);
	    			txtdate_s.setText("Année-mois-jour");
	    			txtid_svce.setEditable(false);
	    			txtid_svce.setText("");
	    			txtid_p1.setEditable(true);
	    			txtid_p1.setText("");
	    			butnouv.setEnabled(false);
	    			buthospi_eff1.setEnabled(false);
    			}
    			else{
    				buthospi_ok1.setEnabled(true);
    			    buthospi_eff1.setEnabled(true);
    			    butnouv.setEnabled(false);
    			    txtdate_e.setEditable(false);
    			    txtid_lit.setEditable(false);
    			    txtdate_s.setEditable(true);
    			    txtid_svce.setEditable(false);
    			    txtid_p1.setEditable(false);
    			    buthosp_con.setEnabled(false);

    				txtdate_e.setText(st[1]);
    				txtid_lit.setText(st[0]);
		    		txtid_svce.setText("    "+n);
	    			ja=0;
    			}
	    		
    		}
            
         	//////////////////////Gestion du bouton annuler
			 
			 if(source == buthospi_eff1){
				 butsort.setEnabled(false);
	    		 buthospi_ok1.setEnabled(false);
	    		 buthosp_con.setEnabled(true);
	    		 txtdate_e.setEditable(false);
	    		 txtdate_e.setText("Année-mois-jour");
	    		 txtid_lit.setEditable(false);
	    		 txtid_lit.setText("");
	    		 txtdate_s.setEditable(false);
	    		 txtdate_s.setText("Année-mois-jour");
	    		 txtid_svce.setEditable(false);
	    		 txtid_svce.setText("");
	    		 txtid_p1.setEditable(true);
	    		 txtid_p1.setText("");
	    		 butnouv.setEnabled(false);
	    		 buthospi_eff1.setEnabled(false);
			 }
             
			 //recupération du résultat du patient
			 if(source==butres){
				 try{
					 try{
					     a1= format.parse(this.textres.getText(),new ParsePosition(0)).intValue();
					    
					 } catch (RuntimeException e1) {
						 JOptionPane.showMessageDialog(null,"L'IDENTIFIANT  "+this.textres.getText()+"  EST INCORECT", "Message d'alerte", JOptionPane.WARNING_MESSAGE);

						   
					 }
					 String q=this.textres.getText();
					 int n = format.parse(q, new ParsePosition(0)).intValue();
					 
					if (!hello.connecter(n)){
						 JOptionPane.showMessageDialog(null,"IL N'EXISTE AUCUN PATIENT AYANT POUR NUMERO D'IDENTIFIANT  "+this.textres.getText()+"  DANS CET HOPITAL", "Message d'alerte", JOptionPane.WARNING_MESSAGE);

						 
					}
					 else{
						 String[] s11= hello.RecupereNom(n);
						 String[][] s2=hello.RecupereExamensPrescrit(n);
						 if(s2[5]==null){
							 JOptionPane.showMessageDialog(null,"LE PATIENT NOME "+s11[3]+" N\'A PAS ENCORE RECU DE PRESCRIPTION D'EXAMEN DANS CET HOPITAL", "Message d'alerte", JOptionPane.WARNING_MESSAGE);
						 }
						 else{
						    areares1.setBackground(Color.white);
						    areares1.setText("NOM DU PATIENT:  "+s11[2]+"\n\nPRENOM:  "+s11[3]);
						    int f=0;int u=0;int m=1;
						    while(!s2[i][u].equals(null)){
						         areares1.append("\n\n \n                                                                                                              EXAMEN n°"+m+"\n\n\nINTITULE EXAMEN:  "+s2[i+1][5]+"\n\nRESULTAT:  "+s2[i+1][6]+"\n\nDATE PRESCRIPTION:  "+s2[i+1][4]);
						         i++;
						         m++;
						    }
						 }
					
					 }
				 }catch(Exception eV){
					 System.out.println(" prescription non faite");
				 }
			 }
			
			 
//////////////////////////Gestion du bouton enregister (interner)
             
             if(source == buthospi_ok1){
             	
             	if(ja==1){
             		
             	int z=1;
	   			    Date date = null; 
	   			    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 

	   			    try{
	   				 date = date.valueOf(this.txtdate_e.getText());
	   			        } catch (Exception ke) { 
		 					JOptionPane.showMessageDialog(null,	"Format de date incorrect", "Date", JOptionPane.WARNING_MESSAGE);
		 				date=null;	
	   		         } 
	    			
	    			 
	   			     try {
		 					b= format.parse(this.txtid_lit.getText(),new ParsePosition(0)).intValue();
		 				} catch (RuntimeException e1) {
		 					// TODO Auto-generated catch block
		 					b=0;
		 				    }
		 				
		 				if( !hello.occuper(b)){
		 					if( b!=0 && date!=null){
		 					int i=hello.interner(n,b,date);
		 					if(i==1){
							    butsort.setEnabled(false);
		    			        buthospi_ok1.setEnabled(false);
		    			        buthosp_con.setEnabled(true);
		    			        txtdate_e.setEditable(false);
		    			        txtdate_e.setText("Année-mois-jour");
		    			        /*combo_hospi_jj1.setEnabled(false);
		    			        combo_hospi_mm1.setEnabled(false);
		    			        combo_hospi_aaaa1.setEnabled(false);
		    			        txtid_lit.setEditable(false);*/
		    			        txtid_lit.setText("");
		    			        txtdate_s.setEditable(false);
		    			        txtdate_s.setText("Année-mois-jour");
		    			        /*combo_hospi_jj2.setEnabled(false);
		     	    			combo_hospi_mm2.setEnabled(false);
		     	    			combo_hospi_aaaa2.setEnabled(false);*/

		    			        txtid_svce.setEditable(false);
		    			        txtid_svce.setText("");
		    			        txtid_p1.setEditable(true);
		    			        txtid_p1.setText("");
		    			        butnouv.setEnabled(false);
		    			        buthospi_eff1.setEnabled(false);
		 						JOptionPane.showMessageDialog(null,"Patient enregistré","Enregistrement", JOptionPane.INFORMATION_MESSAGE);
		 					}
		 					else 
			 					JOptionPane.showMessageDialog(null,	"Date incorrect", "Date", JOptionPane.WARNING_MESSAGE);
		 				}
						
						else{
							JOptionPane.showMessageDialog(null,"Identifiant du lit incorrect!!","Identifiant Incorrect", JOptionPane.WARNING_MESSAGE);
		 				    buthospi_ok1.setEnabled(true);
		    			    buthospi_eff1.setEnabled(true);
		    			    txtdate_e.setEditable(true);
		    			    /*combo_hospi_jj1.setEnabled(true);
		    			    combo_hospi_mm1.setEnabled(true);
		    			    combo_hospi_aaaa1.setEnabled(true);
		    			    txtid_lit.setEditable(true);*/
		    			    txtdate_s.setEditable(false);
		    			    /*combo_hospi_jj2.setEnabled(false);
	     	    			combo_hospi_mm2.setEnabled(false);
	     	    			combo_hospi_aaaa2.setEnabled(false);*/

		    			    txtid_svce.setEditable(false);
		    			    txtid_p1.setEditable(false);
		    			    buthosp_con.setEnabled(false);
						}
						
		 				}
		 				else
	 						JOptionPane.showMessageDialog(null,"Lit deja occupé par un patient","Enregistrement", JOptionPane.INFORMATION_MESSAGE);
		 				
	             }
	             if(ja==0){
             	
             	Date date = null;
             	
             	try{
             		date = date.valueOf(this.txtdate_s.getText());
             		
             		
             		if(hello.sortir(n,date)){
                 		JOptionPane.showMessageDialog(null,	"Date de sortie mis à jour!!", "Mis à jour de la base", JOptionPane.WARNING_MESSAGE);
                 		butsort.setEnabled(false);
     	    			buthospi_ok1.setEnabled(false);
     	    			buthosp_con.setEnabled(true);
     	    			txtdate_e.setEditable(false);
     	    			txtdate_e.setText("Année-mois-jour");
     	    			txtid_lit.setEditable(false);
     	    			txtid_lit.setText("");
     	    			txtdate_s.setEditable(false);
     	    			txtdate_s.setText("Année-mois-jour");
     	    			txtid_svce.setEditable(false);
     	    			txtid_svce.setText("");
     	    			txtid_p1.setEditable(true);
     	    			txtid_p1.setText("");
     	    			butnouv.setEnabled(false);
     	    			buthospi_eff1.setEnabled(false);
             		}
             		else{
             			JOptionPane.showMessageDialog(null,	"Problème rencontré lors de la mis à jour!!", "Mis à jour de la base", JOptionPane.WARNING_MESSAGE);
             			buthospi_ok1.setEnabled(true);
 	    			    buthospi_eff1.setEnabled(true);
 	    			    txtdate_e.setEditable(true);
 	    			    txtid_lit.setEditable(true);
 	    			    txtdate_s.setEditable(false);
 	    			    txtid_svce.setEditable(false);
 	    			    txtid_p1.setEditable(false);
 	    			    buthosp_con.setEnabled(false);
 	    			    txtdate_e.setText("Année-mois-jour");
 	    			    txtid_lit.setText("");
 	    			    txtid_svce.setText("");
             		}

             	}
             	catch (Exception ke) {
             		JOptionPane.showMessageDialog(null,	"Format de date incorrect", "Date", JOptionPane.WARNING_MESSAGE);
		 				date=null;	
	   		         } 
             }
	    	}
             	
             	
             	
             
             
	    		if(source == buthosp_con){
	    			
	    			try {
						n = format.parse(txtid_p1.getText(),new ParsePosition(0)).intValue();
		
						if(hello.connecter(n)==true){
							
							butnouv.setEnabled(true);
							butsort.setEnabled(true);
							
						}
						
						else{
							JOptionPane.showMessageDialog(null,"Aucun patient ne correspond à cet identifiant!","Identifiant Incorrect", JOptionPane.WARNING_MESSAGE);
						}
	    			
	    			}
	    			catch(Exception ke){
	    				
	    				JOptionPane.showMessageDialog(null,"Identifiant incorrect veillez reprendre la saisie","Identifiant Incorrect", JOptionPane.WARNING_MESSAGE);
	    				txtid_p1.setText("");
	    		    }
	    		}
	
			 //Gestion de la connexion
			 
	    		if(source == butexam){
	    			
	    			try {
						n = format.parse(textexam.getText(),new ParsePosition(0)).intValue();//Conversion en integer
						
						if(hello.connecter(n)==true){
							
							butexam.setEnabled(false);
							butexam1.setEnabled(true);
							butexam2.setEnabled(true);
							textexam1.setEditable(true);
							textexam_pers.setEditable(true);
							
						}
						
						else{
							JOptionPane.showMessageDialog(null,"Cet identifiant ne correspond à aucun patient de cet hopital!","Identifiant Incorrect", JOptionPane.WARNING_MESSAGE);
						}
	    			
	    			}
	    			catch(Exception ke){
	    				
	    				JOptionPane.showMessageDialog(null,"Identifiant incorrect veuillez reprendre la saisie","Identifiant Incorrect", JOptionPane.WARNING_MESSAGE);
	    				textexam.setText("");
	    		    }
	    		}
				
	    		
	    		//Gestion de la prescription
	    		
	    		if(source==butexam1){
	    			try{
	    				g = format.parse(textexam.getText(),new ParsePosition(0)).intValue();
	    				id = format.parse(textexam_pers.getText(),new ParsePosition(0)).intValue();//Conversion en integer
	    			    id_ex=combo.getSelectedIndex();
	    			    i=id_ex+1;
	    			    Date date = null;
	    			    try{
	                 		date = date.valueOf(this.textexam1.getText());
	                 		int ret=hello.prescrire(g,i,id,date);
	                 		if(ret!=-1){
	                 			JOptionPane.showMessageDialog(null,	"Le numéro de prescription est"+ret, "Numéro de prescription", JOptionPane.WARNING_MESSAGE);
	                 			butexam.setEnabled(true);
	                 			butexam1.setEnabled(false);
								butexam2.setEnabled(false);
								textexam.setText("");
								//textexam1.setText("");
								textexam_pers.setText("");
								textexam.setEditable(true);
								textexam1.setEditable(false);
								textexam_pers.setEditable(false);
	                 		}
							else{
								JOptionPane.showMessageDialog(null,	"Vérifiez l'identifiant du médécin!", "Imposteur!!!", JOptionPane.WARNING_MESSAGE);
								butexam.setEnabled(true);
	                 			butexam1.setEnabled(false);
								butexam2.setEnabled(false);
								textexam.setText("");
								//textexam1.setText("");
								textexam_pers.setText("");
								textexam.setEditable(true);
								textexam1.setEditable(false);
								textexam_pers.setEditable(false);
							}
	                
	    			    }
	    			    catch(Exception me){
	    			    	JOptionPane.showMessageDialog(null,	"La prescription a échoué, saisir date!!!", "Alerte!", JOptionPane.WARNING_MESSAGE);
	    			    	System.out.println("null"+me);
	    			    }
	    			    }
	    			
	    			
	    		catch(Exception ex){
	    			JOptionPane.showMessageDialog(null,	"Bien vouloir saisir conformément les champs!", "Imposteur!!!", JOptionPane.WARNING_MESSAGE);
	    			butexam.setEnabled(true);
	    			System.out.println("erreur fenetre  "+ex);
	    			}
	    		
	    		}

	    		//Annulation des champs
	    		
	    		if(source==butexam2){
    				try{
    					
    					JOptionPane.showMessageDialog(null,	"Annulation sure!", "refresh!!!", JOptionPane.WARNING_MESSAGE);
						butexam.setEnabled(true);
             			butexam1.setEnabled(false);
						butexam2.setEnabled(false);
						textexam.setText("");
						//textexam1.setText("");
						textexam_pers.setText("");
						textexam.setEditable(true);
						textexam1.setEditable(false);
						textexam_pers.setEditable(false);
    					
    				}
    				catch(Exception don){
    					System.out.println("nase"+don);
    					
    				}
	    		}
             	
		     
		}
		
		catch(Exception exee){
			System.out.println("erreur fenetre  "+exee);
		}
		

		if(source==butdiag){
			
			try {
				

				try {
					a1= format.parse(this.txtdiag.getText(),new ParsePosition(0)).intValue();
				} catch (RuntimeException e1) {
					 JOptionPane.showMessageDialog(null," l\'identifiant entré est incorecte", "Message d'alerte", JOptionPane.WARNING_MESSAGE);

				}
				n= format.parse(this.txtdiag.getText(),new ParsePosition(0)).intValue();

				String[] sd=new String[9];
				
				if(hello.connecter(n)==true){
					
					txtdiag.setEditable(true);
					textmal.setEditable(true);			    
				    textpers.setEditable(true);				    
				    textpds.setEditable(true);			
				    texttem.setEditable(true);       
				    textdate.setEditable(true);
				    textpres.setEditable(true);
				    textgly.setEditable(true);					    
				    textsym.setEditable(true);
				    but_diag_enrg.setEnabled(true);
				    but_diag_eff.setEnabled(true);
				    
				    sd = hello.affichediag(n);
					
	    			if(sd[0]!=null){
	    			 txtdiag.setText(sd[0]);	
	    			  textmal.setText(sd[1]);
	    			  textpers.setText(sd[2]);
	    			  textpds.setText(sd[3]);
	    			  texttem.setText(sd[4]);
	    			  textdate.setText(sd[5]);
	    			  textpres.setText(sd[6]);
	    			  textgly.setText(sd[7]);
	    			  textsym.setText(sd[8]);
	    			
	    			}
	    		
					}
				else {
					JOptionPane.showMessageDialog(null, " Identifiant inexistant dans la base", "Message d'alerte", JOptionPane.WARNING_MESSAGE);}
			
			}catch(Exception t){
				System.out.println("Error connection diagnostique.");}
		}
		
		
		////////////////////////////////ordo 1
   		
		//gestion du bouton connection
if(source==butord){
    //conversion de l'id du patient en entier
  try{
   try {
	      @SuppressWarnings("unused")
	  int b1= format.parse(this.textord.getText(),new ParsePosition(0)).intValue();
		
    } catch (RuntimeException e1) {
					 JOptionPane.showMessageDialog(null," l\'identifiant entré est incorrecte", "Message d'alerte", JOptionPane.WARNING_MESSAGE);
				} 
    
		 String q1=this.textord.getText();
	 int n1 = format.parse(q1, new ParsePosition(0)).intValue();
	 
	 if (!hello.connecter(n1)){
		 JOptionPane.showMessageDialog(null," ce patient n\'existe pas da\n cet hopital", "Message d'alerte", JOptionPane.WARNING_MESSAGE);
	}		
	else{ 
	 
	     textdos.setEditable(false);
		 butord_enrg.setEnabled(true);
		 butord_clr.setEnabled(true);
		 textord_med.setEditable(true);
		 textord_pers.setEditable(true);
		 textord_pos.setEditable(true);
		 textord_nom.setEditable(true);
		 textord_date.setEditable(true);
		 textord_prix.setEditable(true);
	} 
    }
    catch(Exception es){System.out.println("va chier");}	
}
	 
     //gestion du bouton enregistrer de ordonnance
	 
	 if(source==butord_enrg){
			int b1,b2,b3,b4;
		try{
			 Date date1 = null;
		 try{
			   b1= format.parse(this.textord_med.getText(),new ParsePosition(0)).intValue();
			   b2= format.parse(this.textord_pers.getText(),new ParsePosition(0)).intValue();
			 //  b3= format.parse(this.textord_pos.getText(),new ParsePosition(0)).intValue();
			   b4= format.parse(this.textord.getText(),new ParsePosition(0)).intValue();
		 
		 
		 SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy"); 
				 date1 = date1.valueOf(this.textord_date.getText());
			        } catch (Exception ke) { 
 					JOptionPane.showMessageDialog(null,	"Format de date incorrect", "Date", JOptionPane.WARNING_MESSAGE);
 				//date1=null;	
		         }
			        
			        b1= format.parse(this.textord_med.getText(),new ParsePosition(0)).intValue();
					   b2= format.parse(this.textord_pers.getText(),new ParsePosition(0)).intValue();
					 //  b3= format.parse(this.textord_pos.getText(),new ParsePosition(0)).intValue();
					   b4= format.parse(this.textord.getText(),new ParsePosition(0)).intValue();
					   System.out.println("errare");
			        int h=hello.inserordonance(b1,b4, b2,this.textord_pos.getText(), date1);
		}catch(Exception es){System.out.println("errar");}
	 }
	 
	 //gestion du bouton annuler de ordonnance
		 if(source==butord_clr){
	  try{
			 textdos.setEditable(false);
		 butord_enrg.setEnabled(true);
		 butord_clr.setEnabled(true);
		 textord_med.setEditable(true);
		 textord_med.setText("");
		 textord_pers.setEditable(true);
		 textord_pers.setText("");
		 textord_pos.setEditable(true);
		 textord_pos.setText("");
		 textord_nom.setEditable(true);
		 textord_nom.setText("");
		 textord_date.setText("");
		 textord_prix.setEditable(true);
			 }catch(Exception es){System.out.println("va encore chier");}
	   }	
	 
		
			
	//*****************************appel du bouton enregistrer diagnostique******************************************************************
	
	if(source==but_diag_enrg){
						
		boolean s=true; 	
		
		int q = 0,w = 0,l = 0,r = 0,t = 0;
	    Date d=null;
	    String u=null,o = null;
		   
	   try{
		   
		   u=this.textgly.getText();
		   o=this.textsym.getText();
		   d=d.valueOf(this.textdate.getText());
		   q = format.parse(this.textmal.getText(),new ParsePosition(0)).intValue();
		   w = format.parse(this.textpers.getText(),new ParsePosition(0)).intValue();
		   l = format.parse(this.textpds.getText(),new ParsePosition(0)).intValue();
		   r = format.parse(this.texttem.getText(),new ParsePosition(0)).intValue();
		   t = format.parse(textpres.getText(),new ParsePosition(0)).intValue();
	   }catch(Exception f){
		   JOptionPane.showMessageDialog(null,"Champs de texte incorrect", "Message d'alerte", JOptionPane.WARNING_MESSAGE);} 
	  
	   try {
		s=hello.diagnostique(q, n, w, l, r, d, t, u, o);
	} 
	   catch (Exception e1) {
		//e1.printStackTrace();
	}
	   
	   if(s==true){
		   
		  // mettre tous les boutons et textfields inutilisables ensuite rendre connection et son textfield visibles
		 
		   
		     textmal.setEditable(false);
		     textmal.setText("");
		    textpers.setEditable(false);
		    textpers.setText("");
		    textpds.setEditable(false);
		    textpds.setText("");
		    texttem.setEditable(false);
		    texttem.setText("");
		    textdate.setEditable(false);
		    textdate.setText("Année-mois-jour");
		    textpres.setEditable(false);
		    textpres.setText("");
		    textgly.setEditable(false);
		    textgly.setText("");
		    textsym.setEditable(false);
		    textsym.setText("");
		    but_diag_enrg.setEnabled(false);			
		    but_diag_eff.setEnabled(false);
		    
		    
		   
		   
		   JOptionPane.showMessageDialog(null,"Diagnostique enregistre", "Diagnostique", JOptionPane.INFORMATION_MESSAGE);
		}
			
	   else JOptionPane.showMessageDialog(null,"mettre a jour la date", "Message d'alerte", JOptionPane.WARNING_MESSAGE);
     }
	if(source==but_diag_eff){
		
		 textmal.setEditable(false);
	     textmal.setText("");
	    textpers.setEditable(false);
	    textpers.setText("");
	    textpds.setEditable(false);
	    textpds.setText("");
	    texttem.setEditable(false);
	    texttem.setText("");
	    textdate.setEditable(false);
	    textdate.setText("Année-mois-jour");
	    textpres.setEditable(false);
	    textpres.setText("");
	    textgly.setEditable(false);
	    textgly.setText("");
	    textsym.setEditable(false);
	    textsym.setText("");
	    but_diag_enrg.setEnabled(false);			
	    but_diag_eff.setEnabled(false);
		
	}
	
	////////////////////////:ordonnance
  
	
	
	    
 ///**************gestion des boutons de rendez-vous
	
	if(source == butrdv){
		    			
		    			try {
							s = format.parse(textrdv.getText(),new ParsePosition(0)).intValue();
				
							if(hello.connection(s)==true){
								
								butrdv_cons.setEnabled(true);
								butrdv_ajout.setEnabled(true);
							}
							else{
								JOptionPane.showMessageDialog(null,"Aucun personnel ne correspond à cet identifiant!","Identifiant Incorrect", JOptionPane.WARNING_MESSAGE);
							}
							
		    			}
		    			catch(Exception ke){
		    				
		    				JOptionPane.showMessageDialog(null,"Identifiant incorrect veillez reprendre la saisie","Identifiant Incorrect", JOptionPane.WARNING_MESSAGE);
		    				textrdv.setText("");
		    		    }
		    		}
	 if(source==butrdv_cons){
		 try{
			 
				 String[] s12= hello.recupernompat(a3);
				 String[] s3=hello.Recuperdate(a3);
				 /*if(s3[2]==null){
					 JOptionPane.showMessageDialog(null,"LE PATIENT NOME "+s12[3]+" N\'A PAS DE RENDEZ-VOUS DANS CET HOPITAL", "Message d'alerte", JOptionPane.WARNING_MESSAGE);
				 }
				 else{*/
				    areardv1.setBackground(new Color(65,153,53));
				    areardv1.setText("NOM DU PATIENT:  "+s12[3]+"\n\nPRENOM:  "+s12[4]+"\n\n\n\nDATE:  "+s3[2]);
				 
			
			 //}
		 }
		 catch(Exception eV){
			 System.out.println(" prescription non faite");
		 }
	 
	 }
		    		if(source==butrdv_ajout){
	                    try{
	                             butrdv_enrg.setEnabled(true);
	                             butrdv_clr.setEnabled(true);
	                             textrdv_pat.setEditable(true);
	                             textrdv_date.setEditable(true);
	                             }
		    		catch(Exception eV){
						 System.out.println(" ajout d'un elt");
					 }
				 }
		    		
	                    if(source==butrdv_enrg){
			    			       try{
		                               r1 = format.parse(textrdv.getText(),new ParsePosition(0)).intValue();
			    			         
			    				id1 = format.parse(textrdv_pat.getText(),new ParsePosition(0)).intValue();//Conversion en integer
			    			    Date date = null;
			    			    try{
			                 		date = date.valueOf(this.textrdv_date.getText());
			                 		int ret=hello.donnerrdv(id1,r1,date);
			                 		if(ret==2){
			                 			JOptionPane.showMessageDialog(null,	"Rendez-vous noter", "Donner Rendez-vous!!!", JOptionPane.WARNING_MESSAGE);
			                 			butrdv.setEnabled(true);
			                 			butrdv_enrg.setEnabled(false);
										butrdv_clr.setEnabled(false);
										textrdv.setText("");
										textrdv_date.setText("Année-Jour-Mois");
										textrdv_pat.setText("");
										textrdv.setEditable(true);
										textrdv_date.setEditable(false);
										textrdv_pat.setEditable(false);
			                 		}
									else{
										JOptionPane.showMessageDialog(null,	"Vérifiez l'identifiant du personnel!", "merci!!!", JOptionPane.WARNING_MESSAGE);
										butrdv.setEnabled(true);
			                 			butrdv_enrg.setEnabled(false);
										butrdv_clr.setEnabled(false);
										textrdv_pat.setText("");
										textrdv_date.setText("Année-Jour-Mois");
										textrdv.setText("");
										textrdv_pat.setEditable(true);
										textrdv_date.setEditable(false);
										textrdv.setEditable(false);
									}
			                
			    			    }
			    			    catch(Exception me){
			    			    	JOptionPane.showMessageDialog(null,	"L'enregistrement a echoué, saisir date!!!", "Alerte!", JOptionPane.WARNING_MESSAGE);
			    			    	System.out.println("null"+me);
			    			    }
			    			    }
			    			
			    			
			    		catch(Exception ex){
			    			JOptionPane.showMessageDialog(null,	"Bien vouloir saisir conformément les champs!", "merci!!!", JOptionPane.WARNING_MESSAGE);
			    			butrdv.setEnabled(true);
			    			System.out.println("erreur fenetre1  "+ex);
			    			}
			    		
			    		}

		if(source==butrdv_clr)  {
		    				try{
		    					
		    					JOptionPane.showMessageDialog(null,	"Annulation sure!", "refresh!!!", JOptionPane.WARNING_MESSAGE);
								butrdv.setEnabled(true);
		             			butrdv_enrg.setEnabled(false);
								butrdv_clr.setEnabled(false);
								textrdv.setText("");
								textrdv_pat.setText("");
								textrdv_date.setText("Année-Jour-Mois");
								textrdv_date.setEditable(false);
								textrdv.setEditable(true);
								textrdv_pat.setEditable(false);
		    					
		    				}
		    				catch(Exception don){
		    					System.out.println("nase"+don);
		    					
		    				}
		}   
	
	 }
	
	
		
		
	public static void main(String[] ar){
			
			try{
				hello=(InterfaceMoteur)Naming.lookup("rmi://localhost/autre");
				
				   
			    	
				Fenetre inter=new Fenetre("Consultation Générale");
				
			}
			catch(Exception e){ System.out.println("erreur affichage "+e);}
		}
		
	}
