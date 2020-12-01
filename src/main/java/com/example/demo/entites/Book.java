package com.example.demo.entites;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Book {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idbook;
	@Column
	private String title;
	@Column
	private String author;
	@Column
	private double price;
	@Column
	private Date releaseDate;
	public Book(int idbook, String title, String author, double price, Date releaseDate) {
		super();
		this.idbook = idbook;
		this.title = title;
		this.author = author;
		this.price = price;
		this.releaseDate = releaseDate;
	}
	public int getIdbook() {
		return idbook;
	}
	public void setIdbook(int idbook) {
		this.idbook = idbook;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	

}
