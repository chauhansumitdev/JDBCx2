import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *  ref file The file that is in use is the query.java file. --
 */

class Main {
    public static void main(String args[]) {
        System.out.println("Logging entry to main ...");

        String url = "jdbc:postgresql://dpg-cpaeo3sf7o1s73afs4m0-a.singapore-postgres.render.com:5432/jdbc_rsfc";
        String password = "KDnI9UiC5AJQy29LaQAz8yMaF1Gbopjz";
        String user = "jdbc";

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("DB Connected..");
            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally{
            if(connection != null){
                try{
                    connection.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
