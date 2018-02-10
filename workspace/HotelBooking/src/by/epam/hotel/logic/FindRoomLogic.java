package by.epam.hotel.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.hotel.dao.RoomDAO;
import by.epam.hotel.dao.impl.RoomDaoImpl;
import by.epam.hotel.entity.Room;
import by.epam.hotel.entity.RoomStatus;
import by.epam.hotel.exception.DAOException;
import by.epam.hotel.exception.TechnicalException;

/**
 * The Class RoomLogic. All logic associated with finding room.
 */
public class FindRoomLogic {
	
	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(FindRoomLogic.class);

	/**
	 * Gets the free room.
	 * 
	 * @return the free room
	 * @throws TechnicalException
	 *             the logic level exception
	 */
	public static List<Room> findFreeRoom() throws TechnicalException {
		LOG.info("Find free 'Room'...");
		RoomDAO roomDAO = new RoomDaoImpl();
		List<Room> freeRoom = new ArrayList<Room>();
		try {
			for (Room room : roomDAO.findAllRoom()) {
				if (room.getStatus().equals(RoomStatus.FREE))
					freeRoom.add(room);
			}
		} catch (DAOException e) {
			throw new TechnicalException(e);
		}
		
		return freeRoom;
	}

	/**
	 * Gets the all room.
	 * 
	 * @return the all room
	 * @throws TechnicalException
	 *             the logic level exception
	 */
	public static List<Room> findAllRoom() throws TechnicalException {
		RoomDAO roomDAO = new RoomDaoImpl();
		List<Room> listRoom = new ArrayList<Room>();
		try {
			listRoom = roomDAO.findAllRoom();
		} catch (DAOException e) {
			throw new TechnicalException(e);
		}
		return listRoom;
	}
}
