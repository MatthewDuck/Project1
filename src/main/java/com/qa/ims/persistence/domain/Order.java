package com.qa.ims.persistence.domain;

public class Order {

	private Long id;
	private Long customerId;
	private Item items;

	public Order(Long id, Long customerId) {
		this.id = id;
		this.customerId = customerId;
	}

	public Order(Long customerId) {
		this.customerId = customerId;
	}

	public Order(Long id, Item items) {
		this.id = id;
		this.items = items;
	}

	public Order(Long id, Long customerId, Item item) {
		this.id = id;
		this.customerId = customerId;
		this.items = item;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Item getItems() {
		return items;
	}

	public void setItems(Item items) {
		this.items = items;
	}

	

	@Override
	public String toString() {
		if(items != null) {
			return "Order [id=" + id + ", customerId=" + customerId + ", items=" + items + "]";
		}else {
			return "Order [id=" + id + ", customerId=" + customerId + "]";
		}
		
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Order other = (Order) obj;
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (items == null) {
			if (other.items != null) {
				return false;
			}
		} else if (!items.equals(other.items)) {
			return false;
		}
		return true;
	}
	
	





}
