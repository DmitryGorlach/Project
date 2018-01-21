package by.epam.hotel.logic;

import by.epam.hotel.dao.OrderDAO;
import by.epam.hotel.dao.impl.OrderDaoImpl;
import by.epam.hotel.entity.Order;
import by.epam.hotel.entity.enumeration.OrderStatus;
import by.epam.hotel.exception.DAOException;
import by.epam.hotel.exception.LogicException;
import by.epam.hotel.exception.TechnicalException;
import by.epam.hotel.manager.ConfigurationManager;

/**
 * The Class DeleteOrderLogic. All logic associated with deleting order.
 */
public class DeleteOrderLogic {
	/** The Constant PARAM_ERROR_MESSAGE. */
	public static final String PARAM_ERROR_MESSAGE = "errorMessage";

	/**
	 * Delete order.
	 * 
	 * @param idOrder
	 *            the id order
	 * @return the info messenger
	 * @throws TechnicalException
	 *             the logic level exception
	 * @throws LogicException
	 */
	public static boolean deleteOrder(String idOrder) throws TechnicalException, LogicException {
		boolean isRemoved = false;
		OrderDAO orderDAO = new OrderDaoImpl();
		if (idOrder != null) {
			try {
				Order order = orderDAO.findOrderById(Integer.parseInt(idOrder));
				if (order != null) {
					if (order.getStatus().equals(OrderStatus.CONFIRMED)) {
						throw new LogicException(ConfigurationManager.getInstance()
								.getProperty(ConfigurationManager.DELETE_CONFIRMED_ORDER_MESSAGE));
					}
					orderDAO.deleteOrderById(Integer.parseInt(idOrder));
					isRemoved = true;
				}
			} catch (DAOException e) {
				throw new TechnicalException();
			}
		} else {
			throw new LogicException(
					ConfigurationManager.getInstance().getProperty(ConfigurationManager.DELETE_ORDER_PROBLEM_MESSAGE));
		}
		return isRemoved;
	}
}
