package com.revature.models;

import java.util.Objects;

public class Reimbursements {

	private int reimbId;
	private int amount;
	private String description;
	private int status;
	private String author;
	
	public Reimbursements() {
		super();
	}

	public Reimbursements(int reimbId, int amount, String description, int status, String author) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.author = author;
	}

	public Reimbursements(int amount, String description, int status, String author) {
		super();
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.author = author;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, reimbId, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursements other = (Reimbursements) obj;
		return amount == other.amount && Objects.equals(author, other.author)
				&& Objects.equals(description, other.description) && reimbId == other.reimbId && status == other.status;
	}

	@Override
	public String toString() {
		return "Reimbursements [reimbId=" + reimbId + ", amount=" + amount + ", description=" + description
				+ ", status=" + status + ", author=" + author + "]";
	}

	
	
	
	
	
	
}
