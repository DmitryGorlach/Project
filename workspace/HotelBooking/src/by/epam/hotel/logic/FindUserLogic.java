package by.epam.hotel.logic;

import java.util.ArrayList;

import by.epam.hotel.dao.UserDAO;
import by.epam.hotel.dao.impl.UserDaoImpl;
import by.epam.hotel.entity.User;
import by.epam.hotel.exception.DAOException;
import by.epam.hotel.exception.TechnicalException;

/**
 * The Class FindUserLogic. All logic associated with finding user.
 */
public class FindUserLogic {
	/**
	 * Find all user.
	 * 
	 * @return the array list
	 * @throws TechnicalException
	 *             the logic level exception
	 */
	public static ArrayList<User> findAllUser() throws TechnicalException {
		ArrayList<User> userList = new ArrayList<User>();
		UserDAO userDAO = new UserDaoImpl();
		try {
			userList = userDAO.findAllUser();
		} catch (DAOException e) {
			throw new TechnicalException();
		}
		return userList;
	}
}
