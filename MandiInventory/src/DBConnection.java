
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.swing.JOptionPane;


public class DBConnection {
    static Connection connection = null;
    public static Connection getConnection(){
       
        try{
            Properties props = new Properties();
            props.load(new FileInputStream("connector.properties"));
            
            String theUser = props.getProperty("user");
            String thePassword = props.getProperty("password");
            String theDBUrl = props.getProperty("dburl");
            
            System.out.println("connecting to database");
            System.out.println("Database URL : "+theDBUrl);
            System.out.println("User : "+theUser);
            
            Class.forName("com.mysql.jdbc.Driver");
            //connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mandi","root","");
            connection=DriverManager.getConnection(theDBUrl,theUser,thePassword);
            System.out.println("Connection Success...");
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
       return connection; 
    }
    
}
