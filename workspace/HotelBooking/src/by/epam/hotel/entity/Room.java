package by.epam.hotel.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.hotel.entity.enumeration.AppartmentCategory;
import by.epam.hotel.entity.enumeration.RoomStatus;

/**
 * The Class Room.
 */
public class Room extends Entity {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -5643467530708922243L;


	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(Room.class);
	
	
	/** The room number. */
	private int roomNumber;
	
	/** The place for sleep. */
	private int placeForSleep;
	
	/** The category. */
	private AppartmentCategory category;
	
	/** The cost per day. */
	private int costPerDay;
	
	/** The status. */
	private RoomStatus status;
	
	/** The description. */
	private String description;

	/**
	 * Instantiates a new room.
	 */
	public Room() {
		LOG.info("Create 'Room' object.");
	}
	/**
	 * Gets the room number.
	 *
	 * @return the room number
	 */
	public int getRoomNumber() {
		return this.roomNumber;
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
	 * Sets the room number.
	 *
	 * @param roomNumber the new room number
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * Gets the place for sleep.
	 *
	 * @return the place for sleep
	 */
	public int getPlaceForSleep() {
		return placeForSleep;
	}

	/**
	 * Sets the place for sleep.
	 *
	 * @param placeForSleep the new place for sleep
	 */
	public void setPlaceForSleep(int placeForSleep) {
		this.placeForSleep = placeForSleep;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public AppartmentCategory getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(AppartmentCategory category) {
		this.category = category;
	}

	/**
	 * Gets the cost per day.
	 *
	 * @return the cost per day
	 */
	public int getCostPerDay() {
		return costPerDay;
	}

	/**
	 * Sets the cost per day.
	 *
	 * @param costPerDay the new cost per day
	 */
	public void setCostPerDay(int costPerDay) {
		this.costPerDay = costPerDay;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public RoomStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(RoomStatus status) {
		this.status = status;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + costPerDay;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + placeForSleep;
		result = prime * result + roomNumber;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Room other = (Room) obj;
		if (category != other.category)
			return false;
		if (costPerDay != other.costPerDay)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (placeForSleep != other.placeForSleep)
			return false;
		if (roomNumber != other.roomNumber)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", placeForSleep=" + placeForSleep + ", category=" + category
				+ ", costPerDay=" + costPerDay + ", status=" + status + ", description=" + description + "]";
	}

	
}
