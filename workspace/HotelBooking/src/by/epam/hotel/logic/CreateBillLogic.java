package by.epam.hotel.logic;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.hotel.dao.BillDAO;
import by.epam.hotel.dao.OrderDAO;
import by.epam.hotel.dao.RoomDAO;
import by.epam.hotel.dao.impl.BillDaoImpl;
import by.epam.hotel.dao.impl.OrderDaoImpl;
import by.epam.hotel.dao.impl.RoomDaoImpl;
import by.epam.hotel.entity.Bill;
import by.epam.hotel.entity.BillStatus;
import by.epam.hotel.entity.Order;
import by.epam.hotel.entity.RoomStatus;
import by.epam.hotel.exception.DAOException;
import by.epam.hotel.exception.TechnicalException;

/**
 * The Class CreateBillLogic. All logic associated with creating bill.
 */
public class CreateBillLogic {
	
	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(CreateBillLogic.class);

	/**
	 * Creates the bill.
	 * 
	 * @param idOrder
	 *            the id order
	 * @throws TechnicalException
	 *             the logic level exception
	 */
	public static void createBill(String idOrder) throws TechnicalException {
		try {
			BillDAO billDAO = new BillDaoImpl();
			OrderDAO orderDAO = new OrderDaoImpl();
			Bill bill = new Bill();
			Order order = orderDAO.findOrderById(Integer.parseInt(idOrder));
			bill.setBillDate(new Date());
			bill.setOrder(order);
			bill.setStatus(BillStatus.UNPAID);
			bill.setTotalCost(calculateTotalSum(order));
			setBusyRoom(order.getRoom().getId());
			billDAO.createBill(bill);
		} catch (DAOException e) {
			throw new TechnicalException(e);
		}
		LOG.info("Creating bill is successful");
	}

	/**
	 * Sets the busy room.
	 * 
	 * @param id
	 *            the new busy room
	 * @throws DAOException
	 *             the DAO level exception
	 */
	private static void setBusyRoom(int id) throws DAOException {
		RoomDAO roomDAO = new RoomDaoImpl();
		roomDAO.changeRoomStatus(id, RoomStatus.BUSY);
	}

	/**
	 * Calculate total sum.
	 * 
	 * @param order
	 *            the order
	 * @return the int
	 */
	private static int calculateTotalSum(Order order) {
		 int hourInDay = 24;
	        int minuteInHour = 60;
	        int secondInMinute = 60;
	        int millisecInSecond = 1000;
	        int sumOfDay = (int)(order.getDateOut().getTime() - order.getDateIn()
	        .getTime()) / (hourInDay * minuteInHour *secondInMinute *millisecInSecond); // волшебные числа
	        int totalSum = sumOfDay *order.getRoom().getCostPerDay();
	        return  totalSum;
	    }
}
