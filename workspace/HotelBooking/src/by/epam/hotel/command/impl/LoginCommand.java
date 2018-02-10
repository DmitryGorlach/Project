package by.epam.hotel.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.hotel.command.Command;
import by.epam.hotel.entity.AccessLevel;
import by.epam.hotel.entity.User;
import by.epam.hotel.exception.TechnicalException;
import by.epam.hotel.logic.LoginLogic;
import by.epam.hotel.manager.ConfigurationManager;

/**
 * The Class LoginCommand. Command for authorization.
 */
public class LoginCommand implements Command {

	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(LoginCommand.class);
	
	/** The Constant PARAM_USER. */
	private static final String PARAM_USER = "user";

	/** The Constant PARAM_LOGIN. */
	private static final String PARAM_LOGIN = "login";

	/** The Constant PARAM_PASSWORD. */
	private static final String PARAM_PASSWORD = "password";

	/** The Constant PARAM_ERROR_MESSAGE. */
	private static final String PARAM_ERROR_MESSAGE = "errorMessage";

		/** The Constant LOGIN_ERROR_MESSAGE. */
	private static final String LOGIN_ERROR_MESSAGE = "login.error.message";
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * by.epam.hotel.command.ICommand#execute(javax.servlet.http.HttpServletRequest
	 * )
	 */
	@Override
	public String execute(HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		String page = null;
		User user = null;
		String login = request.getParameter(PARAM_LOGIN);
		String password = request.getParameter(PARAM_PASSWORD);
		try {
			if ((user = LoginLogic.checkLogin(login, password)) != null) {
				LOG.info("Add to session user.");
				session.setAttribute(PARAM_USER, user);
				page = checkAccessLevel(user.getAccess(), request);
			} else {
				request.setAttribute(PARAM_ERROR_MESSAGE,
						ConfigurationManager.getProperty(LOGIN_ERROR_MESSAGE));
				
				page = ConfigurationManager.getProperty(ConfigurationManager.LOGIN_PAGE_PATH);
			}
		} catch (TechnicalException e) {
			LOG.error("Something goes wrong, redirect to error page.", e);
			request.setAttribute(PARAM_ERROR_MESSAGE,
					ConfigurationManager.getProperty(ConfigurationManager.LOGIC_EXCEPTION_ERROR_MESSAGE));
			
			page = ConfigurationManager.getProperty(ConfigurationManager.ERROR_PAGE_PATH);
		}
		return page;
	}

	/**
	 * Check user access level.
	 * 
	 * @param access
	 *            the access
	 * @param request
	 *            the request
	 * @return the string
	 */
	private String checkAccessLevel(AccessLevel access,
			HttpServletRequest request) {
		AccessLevel check = access;
		if (check != null) {
			switch (check) {
			case ADMIN:
				return ConfigurationManager.getProperty(ConfigurationManager.ADMIN_PAGE_PATH);
			case CLIENT:
				return ConfigurationManager.getProperty(ConfigurationManager.CLIENT_PAGE_PATH);
			case GUEST:
				request.setAttribute(PARAM_ERROR_MESSAGE,
						ConfigurationManager.getProperty(ConfigurationManager.BANNED_MESSAGE));
				
				return ConfigurationManager.getProperty(ConfigurationManager.INDEX_PAGE_PATH);
			}
		}
		return ConfigurationManager.getProperty(ConfigurationManager.ERROR_PAGE_PATH);

	}
}
