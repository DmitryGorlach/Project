package by.epam.hotel.dao;

import java.util.List;

import by.epam.hotel.entity.Room;
import by.epam.hotel.entity.RoomStatus;
import by.epam.hotel.exception.DAOException;

/**
 * The Interface IRoomDAO.
 */
public interface RoomDAO {

	/**
	 * Find all room.
	 * 
	 * @return the array list
	 * @throws DAOException
	 *             the DAO level exception
	 */
	List<Room> findAllRoom() throws DAOException;

	/**
	 * Find room by id.
	 * 
	 * @param parseInt
	 *            the parse int
	 * @return the room
	 * @throws DAOException
	 *             the DAO level exception
	 */
	Room findRoomById(int parseInt) throws DAOException;

	/**
	 * Change room status.
	 * 
	 * @param id
	 *            the id
	 * @param status
	 *            the status
	 * @throws DAOException
	 *             the DAO level exception
	 */
	void changeRoomStatus(int id, RoomStatus status) throws DAOException;

}
