package by.epam.hotel.logic;

import by.epam.hotel.dao.RoomDAO;
import by.epam.hotel.dao.impl.RoomDaoImpl;
import by.epam.hotel.entity.RoomStatus;
import by.epam.hotel.exception.DAOException;
import by.epam.hotel.exception.LogicException;
import by.epam.hotel.exception.TechnicalException;
import by.epam.hotel.manager.ConfigurationManager;

/**
 * The Class ChangeStatusRoomLogic.All logic associated with changing room
 * status.
 */
public class ChangeStatusRoomLogic {

	/** The Constant PARAM_STATUS_EMPTY. */
	private static final String PARAM_STATUS_EMPTY = "empty";

	/**
	 * Change room status.
	 * 
	 * @param idRoom
	 *            the id room
	 * @param statusRoom
	 *            the status room
	 * @return the info messenger
	 * @throws TechnicalException
	 *             the logic level exception
	 * @throws LogicException
	 */
	public static void changeRoomStatus(String idRoom, String statusRoom)
			throws TechnicalException, LogicException {

		RoomDAO roomDAO = new RoomDaoImpl();
		if (idRoom != null) {
			if (PARAM_STATUS_EMPTY.equals(statusRoom)) {
				throw new LogicException(
						ConfigurationManager.getProperty(ConfigurationManager.CHOOSE_ACTION_ERROR_MESSAGE));
			}
			try {
				roomDAO.changeRoomStatus(Integer.parseInt(idRoom),
						RoomStatus.valueOf(statusRoom));
			} catch (DAOException e) {
				throw new TechnicalException(e);
			}
		} else {
			throw new LogicException(
					ConfigurationManager.getProperty(ConfigurationManager.CHANGE_ROOM_STATUS_ERROR_MESSAGE));
		}
	}
}
