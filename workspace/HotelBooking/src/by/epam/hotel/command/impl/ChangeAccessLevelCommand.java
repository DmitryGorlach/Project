package by.epam.hotel.command.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.hotel.command.Command;
import by.epam.hotel.entity.User;
import by.epam.hotel.exception.LogicException;
import by.epam.hotel.exception.TechnicalException;
import by.epam.hotel.logic.ChangeAccessUserLogic;
import by.epam.hotel.logic.FindUserLogic;
import by.epam.hotel.manager.ConfigurationManager;

/**
 * The Class ChangeAccessLevelCommand. Command for change access level.
 */
public class ChangeAccessLevelCommand implements Command {

	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(ChangeAccessLevelCommand.class);

	/** The Constant PARAM_USER_LIST. */
	private static final String PARAM_USER_LIST = "userList";

	/** The Constant PARAM_USER_ID. */
	private static final String PARAM_USER_ID = "id_user";

	/** The Constant PARAM_ACCESS_LEVEL. */
	private static final String PARAM_ACCESS_LEVEL = "accessLevel";

	/** The Constant PARAM_ERROR_MESSAGE. */
	private static String PARAM_ERROR_MESSAGE = "errorMessage";

	/** The Constant PARAM_ACTION_MESSAGE. */
	private static final String PARAM_ACTION_MESSAGE = "actionMessage";

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

		String idUser = request.getParameter(PARAM_USER_ID);
		String accessLevel = request.getParameter(PARAM_ACCESS_LEVEL);
		try {
			ChangeAccessUserLogic.changeAccessLevel(idUser, accessLevel);
			page = refreshWithChanges(request);
			request.setAttribute(
					PARAM_ACTION_MESSAGE,
					ConfigurationManager.getProperty(
							ConfigurationManager.CHANGE_STATUS_SUCCESS_MESSAGE));
		} catch (TechnicalException e) {
			LOG.error("Something goes wrong, redirect to error page.", e);
			request.setAttribute(
					PARAM_ERROR_MESSAGE,
					ConfigurationManager.getProperty(
							ConfigurationManager.LOGIC_EXCEPTION_ERROR_MESSAGE));
			page = ConfigurationManager.getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
		} catch (LogicException e) {
			LOG.error("Something goes wrong with changing user access level.",
					e);
			request.setAttribute(PARAM_ERROR_MESSAGE, e);
			page = refreshWithChanges(request);
		}
		return page;
	}

	private String refreshWithChanges(HttpServletRequest request) {
		List<User> userList;
		try {
			userList = FindUserLogic.findAllUser();
			request.setAttribute(PARAM_USER_LIST, userList);
			return ConfigurationManager.getProperty(
					ConfigurationManager.USER_ADMINISTRATION_PATH);
		} catch (TechnicalException e) {
			LOG.error("Something goes wrong, redirect to error page.", e);
			request.setAttribute(
					PARAM_ERROR_MESSAGE,
					ConfigurationManager.getProperty(
							ConfigurationManager.LOGIC_EXCEPTION_ERROR_MESSAGE));
			return ConfigurationManager.getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
		}
	}
}
