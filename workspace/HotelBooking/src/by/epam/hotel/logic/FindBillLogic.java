package by.epam.hotel.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.hotel.dao.BillDAO;
import by.epam.hotel.dao.impl.BillDaoImpl;
import by.epam.hotel.entity.Bill;
import by.epam.hotel.exception.DAOException;
import by.epam.hotel.exception.TechnicalException;

/**
 * The Class FindBillLogic. All logic associated with finding bill.
 */
public class FindBillLogic {

	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(FindBillLogic.class);
	/**
	 * Gets the client bill.
	 * 
	 * @param idUser
	 *            the id user
	 * @return the client bill
	 * @throws TechnicalException
	 *             the logic level exception
	 */
	public static List<Bill> findClientBill(int idUser)
			throws TechnicalException {
		LOG.info("Find clients 'Bill' ...");
		BillDAO billDAO = new BillDaoImpl();
		List<Bill> billList = new ArrayList<Bill>();
		try {
			for (Bill bill : billDAO.findUserBills(idUser)) {
				billList.add(bill);
			}
		} catch (DAOException e) {
			throw new TechnicalException(e);
		}
		return billList;
	}

}
