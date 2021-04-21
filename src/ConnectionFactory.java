import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection createConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/cursojdbcjava?useTimezone=true&serverTimezone=UTC"; //Nome da base de dados
		String user = "development"; //nome do usuário do MySQL
		String password = "development"; //senha do MySQL

		Connection conexao = null;
		
		conexao = DriverManager.getConnection(url, user, password);
		
		return conexao;
	}
}