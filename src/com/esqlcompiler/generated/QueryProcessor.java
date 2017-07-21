package stevens.cs562.generated;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class QueryProcessor {

private List<MfStructure> mf_table = new ArrayList<MfStructure>();

	 public static void main(String[] args) {

		 QueryProcessor QP = new QueryProcessor();
		 QP.getTable();
		 QP.displayTable();

	 }
	 public void getTable() {
		 try {
		 Connection dbconnection = DatabaseConnection.getDBInstance();
		 Statement st = dbconnection.createStatement();
		 ResultSet rs = st.executeQuery("SELECT * FROM Sales  WHERE year=1997");
		 while(rs.next()) {
			 boolean isexists =false;
			 for (MfStructure current_row : mf_table){
				 if(rs.getString("prod").equals(current_row.prod) && rs.getInt("month") == current_row.month){
					 isexists = true;
				 }
			 }
			 if(isexists==false){
				 MfStructure mf_struct = new MfStructure();
				mf_struct.prod = rs.getString("prod");
				 mf_struct.month = rs.getInt("month");
				 mf_struct.sum_quant_1 = 0;
				 mf_struct.sum_quant_2 = 0;
				 mf_table.add(mf_struct);
			 }
		 }
		 rs = st.executeQuery("SELECT * FROM Sales  WHERE year=1997");
		 while(rs.next()) {
			 for (MfStructure current_row : mf_table){
					 if( rs.getString("prod").equals(current_row.prod) && rs.getInt("month") == current_row.month ){
					current_row.sum_quant_1 += rs.getInt("quant");
					 }
			 }
		 }
		 rs = st.executeQuery("SELECT * FROM Sales  WHERE year=1997");
		 while(rs.next()) {
			 for (MfStructure current_row : mf_table){
					 if( rs.getString("prod").equals(current_row.prod) ){
					current_row.sum_quant_2 += rs.getInt("quant");
					 }
			 }
		 }
		 } catch (SQLException e) {;
			 e.printStackTrace();
		 }
	 }
	public void displayTable() {
		System.out.println("prod\tmonth\tm.sum_quant_1 * 100/m.sum_quant_2\t");
		 for(MfStructure m : mf_table){
			System.out.print(m.prod+"\t");
			System.out.print(m.month+"\t");
			 System.out.print(m.sum_quant_1 * 100/m.sum_quant_2+"\t");
System.out.println();
		 }
	 }
}
