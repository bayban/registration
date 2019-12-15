package com.bayban.dbconnection;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.bayban.mapper.RegistrationSQL;

public class DBConnection {

	public static SqlSession getSqlSession(@SuppressWarnings("rawtypes") Class clazz) {

		String user = "postgres";
		String password = "bayban83";
		String databasenameURL = "jdbc:postgresql://localhost:5432/ithildin";
		String dbDriver = "org.postgresql.Driver";

		DataSource dataSource = new org.apache.ibatis.datasource.pooled.PooledDataSource(dbDriver, databasenameURL,
				user, password);
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

		sqlSessionFactory.getConfiguration().addMapper(RegistrationSQL.class);
		SqlSession sqlSession = sqlSessionFactory.openSession();

		return sqlSession;
	}

	public static void main(String[] args) {
		// connectToDB();
		// SqlSessionFactory sql = getSqlSession();
		// System.out.println(sql.openSession());
	}
}
