package by.epam.hotel.command.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.hotel.command.Command;
import by.epam.hotel.entity.Room;
import by.epam.hotel.exception.TechnicalException;
import by.epam.hotel.logic.FindRoomLogic;
import by.epam.hotel.manager.ConfigurationManager;

/**
 * The Class ShowFreeRoomCommand. Command to forward to creating order page.
 */
public class ShowFreeRoomCommand implements Command {

	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(ShowFreeRoomCommand.class);
	
	/** The Constant PARAM_FREE_ROOM. */
	private static final String PARAM_FREE_ROOM = "freeRoom";

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
		List<Room> freeRoom = null;
		try {
			freeRoom = FindRoomLogic.findFreeRoom();
			if (freeRoom.size() != 0) {
				request.setAttribute(PARAM_FREE_ROOM, freeRoom);
			} else {
				request.setAttribute(
						PARAM_ERROR_MESSAGE,
						ConfigurationManager.getProperty(ConfigurationManager.DOES_NOT_HAVE_FREE_ROOM_MESSAGE));
			}
			page = ConfigurationManager.getProperty(ConfigurationManager.CREATE_ORDER_PATH);
		} catch (TechnicalException e) {
			LOG.error("Something goes wrong, redirect to error page.", e);
			request.setAttribute(PARAM_ERROR_MESSAGE,
					ConfigurationManager.getProperty(ConfigurationManager.ERROR_PAGE_PATH));
		}
		return page;
	}
}
