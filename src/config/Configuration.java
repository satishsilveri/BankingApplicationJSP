package config;

public class Configuration {

	public static final String driver="com.mysql.cj.jdbc.Driver";
	public static final String database_ip="localhost";
	public static final String database_port="3306";
	public static final String database="bank";
	public static final String database_url = "jdbc:mysql://"+database_ip+":"+database_port+"/"+database;
	public static final String username = "app";
	public static final String password = "app@123";

}
