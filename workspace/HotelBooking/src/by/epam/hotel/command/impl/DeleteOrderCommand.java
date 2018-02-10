package by.epam.hotel.command.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.hotel.command.Command;
import by.epam.hotel.entity.User;
import by.epam.hotel.exception.LogicException;
import by.epam.hotel.exception.TechnicalException;
import by.epam.hotel.logic.DeleteOrderLogic;
import by.epam.hotel.logic.FindOrderLogic;
import by.epam.hotel.manager.ConfigurationManager;

/**
 * The Class DeleteOrderCommand. Command for deleting order.
 */
public class DeleteOrderCommand implements Command {

	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(DeleteOrderCommand.class);

	/** The Constant PARAM_CLIENT_ORDER. */
	private static final String PARAM_CLIENT_ORDER = "clientOrder";

	/** The Constant PARAM_ORDER_ID. */
	private static final String PARAM_ORDER_ID = "id_order";

	/** The Constant PARAM_USER. */
	private static final String PARAM_USER = "user";

	/** The Constant PARAM_ERROR_MESSAGE. */
	private static final String PARAM_ERROR_MESSAGE = "errorMessage";

	/** The Constant PARAM_ACTION_MESSAGE. */
	private static final String PARAM_ACTION_MESSAGE = "actionMessage";

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.epam.hotel.command.ICommand#execute(javax.servlet.http.
	 * HttpServletRequest )
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		String idOrder = request.getParameter(PARAM_ORDER_ID);
		try {
			boolean removed = DeleteOrderLogic.deleteOrder(idOrder);
			page = refreshWithChanges(request);
			if (removed) {
				request.setAttribute(PARAM_ACTION_MESSAGE, ConfigurationManager.
						getProperty(ConfigurationManager.DELETE_ORDER_SUCCESS_MESSAGE));
			}
		} catch (TechnicalException e) {
			LOG.error("Something goes wrong, redirect to error page.", e);
			request.setAttribute(PARAM_ERROR_MESSAGE,
					ConfigurationManager.getProperty(ConfigurationManager.LOGIC_EXCEPTION_ERROR_MESSAGE));
			page = ConfigurationManager.getProperty(ConfigurationManager.ERROR_PAGE_PATH);
		} catch (LogicException e) {
			LOG.error("Something goes wrong with deleting order.", e);
			request.setAttribute(PARAM_ERROR_MESSAGE, e);
			page = refreshWithChanges(request);
		}
		return page;
	}

	private String refreshWithChanges(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(PARAM_USER);
		try {
			request.setAttribute(PARAM_CLIENT_ORDER, FindOrderLogic.findClientOrder(user.getId()));
		} catch (TechnicalException e) {
			LOG.error("Something goes wrong, redirect to error page.", e);
			request.setAttribute(PARAM_ERROR_MESSAGE,
					ConfigurationManager.getProperty(ConfigurationManager.LOGIC_EXCEPTION_ERROR_MESSAGE));
			return ConfigurationManager.getProperty(ConfigurationManager.ERROR_PAGE_PATH);
		}
		return ConfigurationManager.getProperty(ConfigurationManager.CLIENT_ORDER_LIST_PATH);
	}
}
