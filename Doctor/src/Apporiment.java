import java.awt.Button;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Apporiment extends Frame {
	
	String cat[]= {"ortho","gayco","Dentiest","Nurologiest"};
	String ortho[]= {"jay","Bhavesh","kapil","Dinesh","Joy"};
	String gayco[]= {"jam","sejal","tanmay","den","Jai"};
	String Dentiest[]= {"jocker","vishal","jagdish","veeru","Jolu"};
	String Nurologiest[]= {"PSR","PYT","Micale","Din","Jo"};
	 String res; 
	 int i;
	public Choice dh;
	TextField name,dises,mobile;
	public Apporiment() {
		
		
		
		setSize(800,800);
		setLayout(null);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				super.windowClosing(arg0);
				dispose();
			}
		});
		
		Label title=new Label("Universal Clinic");
		title.setBounds(300, 50,200 ,50);
		title.setFont(new Font("ARIAL",Font.BOLD,25));
		add(title);
		
		Choice ch= new Choice();
		ch.add("Choose Category");
		for(int i=0;i<cat.length;i++)
		{
			
			ch.add(cat[i]);
		}
		ch.setBounds(200,100,200,40);
		add(ch);
		
		dh = new Choice();
		dh.add("Choose Doctor");
		//dh.setBounds(200,200,200,40);
		ch.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				dh.removeAll();
				if(ch.getSelectedIndex()==1)
				{
					for( i=0;i<ortho.length;i++)
					{
						dh.add(ortho[i]);
					}
						dh.setBounds(200,200,200,40);
						add(dh);
						
				}
				if(ch.getSelectedIndex()==2)
				{
					for( i=0;i<gayco.length;i++)
					{
						dh.add(gayco[i]);
					}
						dh.setBounds(200,200,200,40);
						remove(dh);
						add(dh);
				}
				if(ch.getSelectedIndex()==3)
				{
					for( i=0;i<Dentiest.length;i++)
					{
						dh.add(Dentiest[i]);
					}
						dh.setBounds(200,200,200,40);
						remove(dh);
						add(dh);
				}
				if(ch.getSelectedIndex()==4)
				{
					for( i=0;i<Nurologiest.length;i++)
					{
						dh.add(Nurologiest[i]);
					}
						dh.setBounds(200,200,200,40);
						remove(dh); 
						add(dh);
				}
				
			}
		});
		Label na=new Label("Pesent Name");
		na.setBounds(100, 300,200 ,30);
		na.setFont(new Font("ARIAL",Font.BOLD,20));
		add(na);
		
		Label di=new Label("Enter Dises");
		di.setBounds(100, 350,200 ,30);
		di.setFont(new Font("ARIAL",Font.BOLD,20));
		add(di);
		
		Label mb=new Label("mobile number");
		mb.setBounds(100, 400,200 ,20);
		mb.setFont(new Font("ARIAL",Font.BOLD,20));
		add(mb);
		
		name= new TextField();
		name.setBounds(350,300,250,30);
		name.setFont(new Font("ARIAL",Font.BOLD,15));
		add(name);
		
		dises= new TextField();
		dises.setBounds(350,350,250,30);
		dises.setFont(new Font("ARIAL",Font.BOLD,15));
		add(dises);
		
		mobile= new TextField();
		mobile.setBounds(350,400,250,30);
		mobile.setFont(new Font("ARIAL",Font.BOLD,15));
		add(mobile);
		
Button btn= new Button("SUMBIT");
		
		btn.setBounds(350, 550,200,50);
		
		add(btn);
		
			
	 		

		
btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Label end=new Label("THANK YOU FOR REGISTRATION");
				end.setBounds(195,650,400,50);
				end.setFont(new Font("ARIAL",Font.BOLD,25));
				add(end);
			////////////////////////////////////////////////////
				String msg="Name-"+name.getText()+" Mobile-"+mobile.getText()+" Disease-"+dises.getText();
				send("peshwashubham1234@gmail.com", "shubham2000", "snehasoni998@gmail.com", "Appointment", msg);
				
				
		/////////////////////////////////////////////////////////////////
				
				 
				 
				 
				 
				
			}
		});
		
	
			
		}
			
		
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Apporiment();

	}
	
	public  void send(String from,String password,String to,String sub,String msg){  
        //Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
         message.setSubject(sub);    
         message.setText(msg);    
         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully");    
        } catch (MessagingException e) {throw new RuntimeException(e);}    
           
  }  

}
