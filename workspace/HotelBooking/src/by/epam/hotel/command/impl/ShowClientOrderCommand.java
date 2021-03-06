package by.epam.hotel.command.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.hotel.command.Command;
import by.epam.hotel.entity.Order;
import by.epam.hotel.entity.User;
import by.epam.hotel.exception.TechnicalException;
import by.epam.hotel.logic.FindOrderLogic;
import by.epam.hotel.manager.ConfigurationManager;

/**
 * The Class ShowClientOrderCommand. Command for forward to client orders page.
 */
public class ShowClientOrderCommand implements Command {

	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(ShowClientOrderCommand.class);

	/** The Constant PARAM_CLIENT_ORDER. */
	private static final String PARAM_CLIENT_ORDER = "clientOrder";

	/** The Constant PARAM_USER. */
	private static final String PARAM_USER = "user";

	/** The Constant PARAM_ERROR_MESSAGE. */
	private static final String PARAM_ERROR_MESSAGE = "errorMessage";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * by.epam.hotel.command.ICommand#execute(javax.servlet.http.HttpServletRequest
	 * )
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		List<Order> clientOrder = null;
		User user = (User) request.getSession().getAttribute(PARAM_USER);
		try {
			clientOrder = FindOrderLogic.findClientOrder(user.getId());
			if (clientOrder.size() != 0) {
				request.setAttribute(PARAM_CLIENT_ORDER, clientOrder);
			} else {
				request.setAttribute(
						PARAM_ERROR_MESSAGE,
						ConfigurationManager.getProperty(ConfigurationManager.DOES_NOT_HAVE_CLIENT_ORDER_MESSAGE));
			}
			page = ConfigurationManager.getProperty(ConfigurationManager.CLIENT_ORDER_LIST_PATH);
		} catch (TechnicalException e) {
			LOG.error("Something goes wrong, redirect to error page.", e);
			request.setAttribute(PARAM_ERROR_MESSAGE,
					ConfigurationManager.getProperty(ConfigurationManager.LOGIC_EXCEPTION_ERROR_MESSAGE));
			
			page = ConfigurationManager.getProperty(ConfigurationManager.ERROR_PAGE_PATH);
		}
		
		return page;
	}

}
