package by.epam.hotel.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.hotel.dao.OrderDAO;
import by.epam.hotel.dao.impl.OrderDaoImpl;
import by.epam.hotel.entity.Order;
import by.epam.hotel.exception.DAOException;
import by.epam.hotel.exception.TechnicalException;

/**
 * The Class FindOrderLogic. All logic associated with finding order.
 */
public class FindOrderLogic {
	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(FindOrderLogic.class);

	/**
	 * Gets the client order.
	 * 
	 * @param idUser
	 *            the id user
	 * @return the client order
	 * @throws TechnicalException
	 *             the logic level exception
	 */
	public static List<Order> findClientOrder(int idUser)
			throws TechnicalException {
		LOG.info("Find all 'Order'...");
		OrderDAO orderDAO = new OrderDaoImpl();
		List<Order> orderList = new ArrayList<Order>();
		try {
			for (Order order : orderDAO.findUserOrders(idUser)) {
				orderList.add(order);
			}
		} catch (DAOException e) {
			throw new TechnicalException(e);
		}
		return orderList;
	}

	/**
	 * Gets the all order.
	 * 
	 * @return the all order
	 * @throws TechnicalException
	 *             the logic level exception
	 */
	public static List<Order> findAllOrder() throws TechnicalException {
		OrderDAO orderDAO = new OrderDaoImpl();
		try {
			return orderDAO.findAllOrders();
		} catch (DAOException e) {
			throw new TechnicalException(e);
		}
	}
}
