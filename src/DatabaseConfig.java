import  java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfig {

    private String url ;
    private  String user;
    private String password;

    public DatabaseConfig() throws  IOException{
        Properties properties = new Properties();

        FileInputStream fs = new FileInputStream("dbConfig.properties");
        properties.load(fs);

        url = properties.getProperty("db.url");
        user = properties.getProperty("db.user");
        password = properties.getProperty("db.password");


        fs.close();
    }

    public String getUrl(){
        return url;
    }

    public String getUser(){
        return user;
    }

    public String getPassword(){
        return password;
    }
}
