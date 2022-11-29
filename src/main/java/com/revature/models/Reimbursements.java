package com.revature.models;

import java.util.Objects;

public class Reimbursements {

	private int reimbId;
	private int amount;
	private String dateSubmitted;
	private String dateResolved;
	private String description;
	private int receipt;
	private int author;
	private int status;
	
	public Reimbursements() {
		super();
	}

	public Reimbursements(int reimbId, int amount, String dateSubmitted, String dateResolved, String description,
			int receipt, int author, int status) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.dateSubmitted = dateSubmitted;
		this.dateResolved = dateResolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.status = status;
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

	public String getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(String dateResolved) {
		this.dateResolved = dateResolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReceipt() {
		return receipt;
	}

	public void setReceipt(int receipt) {
		this.receipt = receipt;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, author, dateResolved, dateSubmitted, description, receipt, reimbId, status);
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
		return amount == other.amount && author == other.author && Objects.equals(dateResolved, other.dateResolved)
				&& Objects.equals(dateSubmitted, other.dateSubmitted) && Objects.equals(description, other.description)
				&& receipt == other.receipt && reimbId == other.reimbId && status == other.status;
	}

	@Override
	public String toString() {
		return "Reimbursements [reimbId=" + reimbId + ", amount=" + amount + ", dateSubmitted=" + dateSubmitted
				+ ", dateResolved=" + dateResolved + ", description=" + description + ", receipt=" + receipt
				+ ", author=" + author + ", status=" + status + "]";
	}
	
	
	
	
	
}
