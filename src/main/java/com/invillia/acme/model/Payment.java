package com.invillia.acme.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.invillia.acme.model.enumeration.PaymentStatus;

@Entity
@Table(name = "PAY_PAYMENT")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAY_ID", nullable = false, updatable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY) 	 
	@JoinColumns({						
		@JoinColumn(name = "STR_ID", referencedColumnName = "STR_ID", updatable = false),
		@JoinColumn(name = "ORD_DATE_TIME", referencedColumnName = "ORD_DATE_TIME", updatable = false) })
	private Order order;
	
	@Enumerated(EnumType.ORDINAL)
    @Column(name="PAY_STATUS", length = 1, nullable = false)
	private PaymentStatus status;
	
	@Column(name = "PAY_CARD_NUMBER", nullable = false)
	private String cardNumber;
	
	@Column(name = "PAY_DATE_TIME", nullable = false)
	private Date payDate;
	
	@Column(name = "PAY_TOTAL_PAYMENT", nullable = false)
	private BigDecimal totalPayment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public BigDecimal getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(BigDecimal totalPayment) {
		this.totalPayment = totalPayment;
	}
}
