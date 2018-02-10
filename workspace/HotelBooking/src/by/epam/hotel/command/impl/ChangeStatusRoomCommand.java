package by.epam.hotel.command.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.hotel.command.Command;
import by.epam.hotel.entity.Room;
import by.epam.hotel.exception.LogicException;
import by.epam.hotel.exception.TechnicalException;
import by.epam.hotel.logic.ChangeStatusRoomLogic;
import by.epam.hotel.logic.FindRoomLogic;
import by.epam.hotel.manager.ConfigurationManager;

/**
 * The Class ChangeStatusRoomCommand. Command for change status room.
 */
public class ChangeStatusRoomCommand implements Command {

	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(ChangeStatusRoomCommand.class);
	
	/** The Constant PARAM_ERROR_MESSAGE. */
	private static final String PARAM_ERROR_MESSAGE = "errorMessage";

	/** The Constant PARAM_ACTION_MESSAGE. */
	private static final String PARAM_ACTION_MESSAGE = "actionMessage";

	/** The Constant PARAM_ROOM_LIST. */
	private static final String PARAM_ROOM_LIST = "roomList";

	/** The Constant PARAM_ROOM_ID. */
	private static final String PARAM_ROOM_ID = "id_room";

	/** The Constant PARAM_ROOM_STATUS. */
	private static final String PARAM_ROOM_STATUS = "statusRoom";

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

		String idRoom = request.getParameter(PARAM_ROOM_ID);
		String statusRoom = request.getParameter(PARAM_ROOM_STATUS);

		try {
			ChangeStatusRoomLogic.changeRoomStatus(idRoom, statusRoom);
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
			LOG.error("Something goes wrong with changing status room.", e);
			request.setAttribute(PARAM_ERROR_MESSAGE, e);
			page = refreshWithChanges(request);
		}
		return page;
	}

	private String refreshWithChanges(HttpServletRequest request) {
		List<Room> listRoom;
		try {
			listRoom = FindRoomLogic.findAllRoom();
			request.setAttribute(PARAM_ROOM_LIST, listRoom);
		} catch (TechnicalException e) {
			LOG.error("Something goes wrong, redirect to error page.", e);
			request.setAttribute(
					PARAM_ERROR_MESSAGE,
					ConfigurationManager.getProperty(
							ConfigurationManager.LOGIC_EXCEPTION_ERROR_MESSAGE));
			return ConfigurationManager.getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
		}
		return ConfigurationManager.getProperty(
				ConfigurationManager.ROOM_ADMINISTRATION_PATH);
	}

}
