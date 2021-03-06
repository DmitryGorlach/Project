package by.epam.hotel.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.hotel.command.Command;
import by.epam.hotel.manager.ConfigurationManager;

/**
 * The Class LogOutCommand. Command for log out.
 */
public class LogOutCommand implements Command {

	/** The Constant LOG. */
	private static final Logger LOG = LogManager
			.getLogger(LogOutCommand.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * by.epam.hotel.command.ICommand#execute(javax.servlet.http.HttpServletRequest
	 * )
	 */
	@Override
	public String execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LOG.info("Invalidate sesssion.");
		session.invalidate();
		return ConfigurationManager.getProperty(
				ConfigurationManager.INDEX_PAGE_PATH);
	}
}
