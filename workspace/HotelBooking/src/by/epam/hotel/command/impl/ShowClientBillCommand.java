package by.epam.hotel.command.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.hotel.command.Command;
import by.epam.hotel.entity.Bill;
import by.epam.hotel.entity.User;
import by.epam.hotel.exception.TechnicalException;
import by.epam.hotel.logic.FindBillLogic;
import by.epam.hotel.manager.ConfigurationManager;

/**
 * The Class ShowClientBillCommand. Command for forward to client bills page.
 */
public class ShowClientBillCommand implements Command {

	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(ShowClientBillCommand.class);
			

	/** The Constant PARAM_CLIENT_BILL. */
	private static final String PARAM_CLIENT_BILL = "clientBill";

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
		List<Bill> clientBill = null;
		User user = (User) request.getSession().getAttribute(PARAM_USER);
		try {
			clientBill = FindBillLogic.findClientBill(user.getId());
			if (clientBill.size() != 0) {
				request.setAttribute(PARAM_CLIENT_BILL, clientBill);
			} else {
				request.setAttribute(
						PARAM_ERROR_MESSAGE,
						ConfigurationManager.getProperty(ConfigurationManager.DOES_NOT_HAVE_BILL_MESSAGE));
			}
			page = ConfigurationManager.getProperty(ConfigurationManager.BILL_LIST_PATH);
			LOG.info("Show clients bills...");
		} catch (TechnicalException e) {
			LOG.error("Something goes wrong, redirect to error page.", e);
			request.setAttribute(PARAM_ERROR_MESSAGE,
					ConfigurationManager.getProperty(ConfigurationManager.LOGIC_EXCEPTION_ERROR_MESSAGE));
			
			page = ConfigurationManager.getProperty(ConfigurationManager.ERROR_PAGE_PATH);
		}
		return page;
	}

}
