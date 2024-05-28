import java.sql.*;

class Query {
    public static void main(String args[]) {
        System.out.println("Logging entry to main ...");

        String url = null;
        String password = null;
        String user = null;

        try{
            DatabaseConfig databaseConfig = new DatabaseConfig();
            url = databaseConfig.getUrl();
            password = databaseConfig.getPassword();
            user = databaseConfig.getUser();
        }catch (Exception e){
            e.printStackTrace();
        }

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();


//            if (connection != null) {
//                System.out.println("DB Connected..");
//            } else {
//                System.out.println("Connection Failed");
//            }

//            String createTable = "CREATE TABLE idandname(" +
//                    "id SERIAL PRIMARY KEY," +
//                    "name VARCHAR(255) NOT NULL)";

//            statement.executeUpdate(createTable);

//            System.out.println("Table Created ...");

//            String insertValue = "INSERT INTO idandname (name) VALUES ('example_name')";
//
//            statement.executeUpdate(insertValue);
//
//            System.out.println("Row Inserted ...");

            String display = "SELECT * from idandname";

            ResultSet resultSet = statement.executeQuery(display);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("id= "+id+" name="+name);
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
