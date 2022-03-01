package demo.database;

import org.hibernate.dialect.MySQL8Dialect;

public class MyDatabaseDialect extends MySQL8Dialect{

	public String getTableTypeString() {
		return "engine=InnoDB DEFAULT CHARSET=utf8mb4";
	}
}
