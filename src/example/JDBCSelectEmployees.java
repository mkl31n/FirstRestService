package example;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
*
*@author Eric Knapp
*
*/
public class JDBCSelectEmployees {

public Map runSample() {

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
    Map<String, String> map = new HashMap<String, String>();
    String employeeId = null;

try {
Class.forName("com.mysql.jdbc.Driver");

connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/sample", "root", "");

statement = connection.createStatement();

String queryString = "SELECT *"
+ "FROM user_roles";

System.out.println("queryString: " + queryString);

resultSet = statement.executeQuery(queryString);

System.out.println();

while (resultSet.next()) {
employeeId = resultSet.getString("user_name");
String firstName = resultSet.getString("role_name");
System.out.println(" Row: " + employeeId + " "
+ firstName);
    map.put(employeeId, firstName);
}

System.out.println();

} catch (ClassNotFoundException classNotFound) {
System.err.println("Cannot find database driver ");
classNotFound.printStackTrace();
} catch (SQLException sqlException) {
System.err.println("Error in connection.ecting to database "
+ sqlException);
sqlException.printStackTrace();
} catch (Exception exception) {
System.err.println("General Error");
exception.printStackTrace();
} finally {
try {
if (resultSet != null) {
resultSet.close();
}

if (statement != null) {
statement.close();
}

if (connection != null) {
connection.close();
}
} catch (SQLException sqlException) {
System.err.println("Error in connection.ecting to database "
+ sqlException);
sqlException.printStackTrace();
} catch (Exception exception) {
System.err.println("General Error");
exception.printStackTrace();
}
}
    return map;
}

/**
* The main program for the JDBCSelectWhereExample class
*
*@param args The command line arguments
*
*@since
*

public static void main(String[] args) {

JDBCSelectEmployees employees = new JDBCSelectEmployees();

employees.runSample();

}
*/
}
