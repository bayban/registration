package com.bayban.mapper;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bayban.model.User;

public interface RegistrationSQL {

	@Select("SELECT * FROM A_USER WHERE \"mobilenumber\" = #{mobilephone}")
	User selectARegristationWhereMobilePhone(@Param("mobilephone") BigDecimal mobilephone);

	@Select("SELECT * FROM A_USER WHERE \"email\" = #{email}")
	User selectARegristationWhereEmail(@Param("email") String email);

	@Insert("INSERT INTO A_USER (mobilenumber,phonearea,firstname,lastname,dob,gender,email)"
			+ " VALUES(#{mobilenumber},#{phonearea},#{firstname},#{lastname},#{dob, jdbcType=TIMESTAMP},"
			+ "#{gender, jdbcType=VARCHAR},#{email})")
	void insertARegristation(@Param("mobilenumber") BigDecimal mobilenumber, @Param("phonearea") String phonearea,
			@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("dob") Date dob,
			@Param("gender") String gender, @Param("email") String email);
}
