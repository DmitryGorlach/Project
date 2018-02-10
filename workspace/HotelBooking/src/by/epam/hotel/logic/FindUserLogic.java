package by.epam.hotel.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.hotel.dao.UserDAO;
import by.epam.hotel.dao.impl.UserDaoImpl;
import by.epam.hotel.entity.User;
import by.epam.hotel.exception.DAOException;
import by.epam.hotel.exception.TechnicalException;

/**
 * The Class FindUserLogic. All logic associated with finding user.
 */
public class FindUserLogic {
	

	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(User.class);

	/**
	 * Find all user.
	 * 
	 * @return the array list
	 * @throws TechnicalException
	 *             the logic level exception
	 */
	public static List<User> findAllUser() throws TechnicalException {
		LOG.info("Find users...");
		List<User> userList = new ArrayList<User>();
		UserDAO userDAO = new UserDaoImpl();
		try {
			userList = userDAO.findAllUser();
		} catch (DAOException e) {
			throw new TechnicalException(e);
		}
		return userList;
	}
}
