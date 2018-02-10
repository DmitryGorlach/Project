package by.epam.hotel.entity;

import java.util.Date;

/**
 * The Class Bill.
 */
public class Bill extends Entity{

	/** The Constant serialVersionUID. */
	
	private static final long serialVersionUID = -1969181218432740736L;

	
	/** The status. */
	private BillStatus status;
	
	/** The order. */
	private Order order;
	
	/** The total cost. */
	private int totalCost;
	
	/** The bill date. */
	private Date billDate;

	/**
	 * Instantiates a new bill.
	 */
	public Bill() {
	
	}

	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Override
	public int getId() {
		return super.getId();
	}


	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	@Override
	public void setId(int id) {
		super.setId(id);
	}


	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public BillStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(BillStatus status) {
		this.status = status;
	}

	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 *
	 * @param order the new order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * Gets the total cost.
	 *
	 * @return the total cost
	 */
	public int getTotalCost() {
		return totalCost;
	}

	/**
	 * Sets the total cost.
	 *
	 * @param totalCost the new total cost
	 */
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * Gets the bill date.
	 *
	 * @return the bill date
	 */
	public Date getBillDate() {
		return billDate;
	}

	/**
	 * Sets the bill date.
	 *
	 * @param billDate the new bill date
	 */
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Bill bill = (Bill) super.clone();
		bill.order = (Order) order.clone();
		return bill;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((billDate == null) ? 0 : billDate.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + totalCost;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		if (billDate == null) {
			if (other.billDate != null)
				return false;
		} else if (!billDate.equals(other.billDate))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (status != other.status)
			return false;
		if (totalCost != other.totalCost)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Bill [status=" + status + ", order=" + order + ", totalCost=" + totalCost + ", billDate=" + billDate
				+ "]";
	}


	
}
