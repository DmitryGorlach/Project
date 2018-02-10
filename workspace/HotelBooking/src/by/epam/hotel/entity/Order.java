package by.epam.hotel.entity;

import java.util.Date;

/**
 * The Class Order.
 */
public class Order extends Entity {

	/**
	 * The Constant serialVersionUID. 
	 */
	private static final long serialVersionUID = 5426855861483793288L;


		/** The date order. */
	private Date dateOrder;
	
	/** The date in. */
	private Date dateIn;
	
	/** The date out. */
	private Date dateOut;
	
	/** The room. */
	private Room room;
	
	/** The user. */
	private User user;
	
	/** The description. */
	private String description;
	
	/** The status. */
	private OrderStatus status;

	/**
	 * Instantiates a new order.
	 */
	public Order() {
		
	}


	/**
	 * Gets the date order.
	 *
	 * @return the date order
	 */
	public Date getDateOrder() {
		return dateOrder;
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
	 * Sets the date order.
	 *
	 * @param dateOrder the new date order
	 */
	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	/**
	 * Gets the date in.
	 *
	 * @return the date in
	 */
	public Date getDateIn() {
		return dateIn;
	}

	/**
	 * Sets the date in.
	 *
	 * @param dateIn the new date in
	 */
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	/**
	 * Gets the date out.
	 *
	 * @return the date out
	 */
	public Date getDateOut() {
		return dateOut;
	}

	/**
	 * Sets the date out.
	 *
	 * @param dateOut the new date out
	 */
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	/**
	 * Gets the room.
	 *
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * Sets the room.
	 *
	 * @param room the new room
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public OrderStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Order order = (Order) super.clone();
		order.room = (Room) room.clone();
		order.user = (User) user.clone();
		return order;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateIn == null) ? 0 : dateIn.hashCode());
		result = prime * result + ((dateOrder == null) ? 0 : dateOrder.hashCode());
		result = prime * result + ((dateOut == null) ? 0 : dateOut.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Order other = (Order) obj;
		if (dateIn == null) {
			if (other.dateIn != null)
				return false;
		} else if (!dateIn.equals(other.dateIn))
			return false;
		if (dateOrder == null) {
			if (other.dateOrder != null)
				return false;
		} else if (!dateOrder.equals(other.dateOrder))
			return false;
		if (dateOut == null) {
			if (other.dateOut != null)
				return false;
		} else if (!dateOut.equals(other.dateOut))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (status != other.status)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Order [dateOrder=" + dateOrder + ", dateIn=" + dateIn + ", dateOut=" + dateOut + ", room=" + room
				+ ", user=" + user + ", description=" + description + ", status=" + status + "]";
	}

	
	
}
