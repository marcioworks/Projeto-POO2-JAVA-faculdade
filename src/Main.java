import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = new ConnectionFactory().createConnection();

//		Departamento d1 = new Departamento(null,"Financeiro","859999999");

		// Gabiarra(kkkkkk) remover na proxima versão.
		int depId = 0;
		PreparedStatement stmt = con.prepareStatement("select * from departamento where id = 1");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			depId = id;
		}
		stmt.close();
//				 
		Funcionario f1 = new Funcionario("Marcio", "Contador", 3000.0, depId);
//		
		/*
		 * String sql = "insert into departamento" + " (nome,telefone)" +
		 * " values (?,?)"; PreparedStatement stmt = con.prepareStatement(sql);
		 */

		String sql = "insert into funcionario" + " (id_departamento,nome,cargo,salario)" + " values (?,?,?,?)";
		PreparedStatement stmt2 = con.prepareStatement(sql);

		stmt2.setInt(1, f1.departamento);
		stmt2.setString(2, f1.nome);
		stmt2.setString(3, f1.cargo);
		stmt2.setDouble(4, f1.salario);

		stmt2.execute();
		stmt2.close();

		System.out.println("Gravado!");

		con.close();

	}

}
