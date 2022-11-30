package com.revature.models;

import java.util.Objects;

public class Reimbursements {

	private int reimbId;
	private int amount;
	private String dateSubmitted;
	private String dateResolved;
	private String description;
	private String author;
	private String resolver;
	private int status;
	
	public Reimbursements() {
		super();
	}

	public Reimbursements(int reimbId, int amount, String dateSubmitted, String dateResolved, String description,
			String author, String resolver, int status) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.dateSubmitted = dateSubmitted;
		this.dateResolved = dateResolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
	}

	public Reimbursements(int amount, String dateSubmitted, String dateResolved, String description, String author,
			String resolver, int status) {
		super();
		this.amount = amount;
		this.dateSubmitted = dateSubmitted;
		this.dateResolved = dateResolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, author, dateResolved, dateSubmitted, description, reimbId, resolver, status);
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
				&& Objects.equals(dateResolved, other.dateResolved)
				&& Objects.equals(dateSubmitted, other.dateSubmitted) && Objects.equals(description, other.description)
				&& reimbId == other.reimbId && Objects.equals(resolver, other.resolver) && status == other.status;
	}

	@Override
	public String toString() {
		return "Reimbursements [reimbId=" + reimbId + ", amount=" + amount + ", dateSubmitted=" + dateSubmitted
				+ ", dateResolved=" + dateResolved + ", description=" + description + ", author=" + author
				+ ", resolver=" + resolver + ", status=" + status + "]";
	}

	
	
	
	
	
	
}
