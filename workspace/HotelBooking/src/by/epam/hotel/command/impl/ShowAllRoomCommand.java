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
 * The Class ShowAllRoomCommand. Command for forward to room administration
 * page.
 */
public class ShowAllRoomCommand implements Command {

	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(ShowAllRoomCommand.class);
	/** The Constant PARAM_LIST_ROOM. */
	private static final String PARAM_LIST_ROOM = "roomList";

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
		List<Room> listRoom = null;
		try {
			listRoom = FindRoomLogic.findAllRoom();
			request.setAttribute(PARAM_LIST_ROOM, listRoom);
			page = ConfigurationManager.getProperty(
					ConfigurationManager.ROOM_ADMINISTRATION_PATH);
			LOG.info("Show all rooms'...");
		} catch (TechnicalException e) {
			LOG.error("Something goes wrong, redirect to error page.", e);
			request.setAttribute(
					PARAM_ERROR_MESSAGE,
					ConfigurationManager.getProperty(
							ConfigurationManager.LOGIC_EXCEPTION_ERROR_MESSAGE));
			page = ConfigurationManager.getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
		}
		return page;
	}

}
