package com.bayban.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.bayban.dbconnection.DBConnection;
import com.bayban.exception.GenericException;
import com.bayban.mapper.RegistrationSQL;
import com.bayban.model.User;
import com.bayban.util.DateFormater;

/**
 * Servlet implementation class RegistrationAuthServlet
 */
@WebServlet("/RegistrationAuthServlet")
public class RegistrationAuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get param from jsp
		String mobilePhone = request.getParameter("mobileNumber");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dob = request.getParameter("dateOfBirth");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");

		// create connection to db
		SqlSession sqlSession = DBConnection.getSqlSession(RegistrationSQL.class);
		RegistrationSQL reqistrationSQL = sqlSession.getMapper(RegistrationSQL.class);

		try {
			// get numeric value of indonesian phone number
			String mobileNumber = mobilePhone.substring(1);

			// validate mobile phone
			User dataUser = new User();
			dataUser = reqistrationSQL.selectARegristationWhereMobilePhone(new BigDecimal(mobilePhone));
			if (null != dataUser) {
				throw new GenericException("ERR-01 : mobile phone already registered");
			}

			// validate email
			dataUser = reqistrationSQL.selectARegristationWhereEmail(email);
			if (null != dataUser) {
				throw new GenericException("ERR-02 : email already registered");
			}

			// if dob null or empty
			Date dateOfBirth = null;
			if ("".equalsIgnoreCase(dob) || null == dob) {
				dateOfBirth = DateFormater.stringToDate("00-00-0000", "dd-MM-yyyy");
			} else {
				dateOfBirth = DateFormater.stringToDate(dob, "dd-MM-yyyy");
			}

			// inserting data if no issue
			reqistrationSQL.insertARegristation(new BigDecimal(mobileNumber), "+62", firstName, lastName, dateOfBirth,
					gender, email);

			// remove session attr
			request.getSession().removeAttribute("mobileNumber");
			request.getSession().removeAttribute("firstName");
			request.getSession().removeAttribute("lastName");
			request.getSession().removeAttribute("dob");
			request.getSession().removeAttribute("gender");
			request.getSession().removeAttribute("email");

			request.getSession().removeAttribute("errorValidate");

			// set true processing
			request.getSession().setAttribute("registerProcess", "SUCCESS");

			// commit when success
			commit(sqlSession);
		} catch (Exception e) {
			// set session attr
			request.getSession().setAttribute("mobileNumber", mobilePhone);
			request.getSession().setAttribute("firstName", firstName);
			request.getSession().setAttribute("lastName", lastName);
			request.getSession().setAttribute("dob", dob);
			request.getSession().setAttribute("gender", gender);
			request.getSession().setAttribute("email", email);

			// passing error when failed
			if (e instanceof GenericException) {
				request.getSession().setAttribute("errorValidate", ((GenericException) e).getCode());
			} else {
				request.getSession().setAttribute("errorValidate", "failed to register");
			}

		} finally {
			close(sqlSession);
			forwardTo(request, response, "./registration.jsp");

		}

	}

	void forwardTo(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void close(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.rollback(true);

			sqlSession.close();
		}
	}

	protected void commit(SqlSession sqlSession) {
		sqlSession.commit();
	}

}
