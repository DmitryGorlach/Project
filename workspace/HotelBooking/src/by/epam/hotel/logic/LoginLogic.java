package by.epam.hotel.logic;

import by.epam.hotel.dao.UserDAO;
import by.epam.hotel.dao.impl.UserDaoImpl;
import by.epam.hotel.entity.User;
import by.epam.hotel.exception.DAOException;
import by.epam.hotel.exception.TechnicalException;

/**
 * The Class UserLogic. All logic associated with authorization.
 */
public class LoginLogic {

	/**
	 * Check login.
	 * 
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 * @return the user
	 * @throws TechnicalException
	 *             the logic level exception
	 */
	public static User checkLogin(String login, String password)
			throws TechnicalException {

		UserDAO userDAO = new UserDaoImpl();
		User user = null;
		try {
			user = userDAO.findUserByLoginPassword(login, password.hashCode());
		} catch (DAOException e) {
			throw new TechnicalException(e);
		}
		return user;
	}
}
