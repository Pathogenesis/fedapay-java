package com.fedapay.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.collections.InvoiceCollection;
import com.fedapay.net.All;

/**
 * Class Invoice
 *
 * @property int id
 * @property int number
 * @property String reference
 * @property String status
 * @property int tax
 * @property String discount_type
 * @property int discount_amount
 * @property int ttc
 * @property int sub_total
 * @property int discount
 * @property int before_tax
 * @property int tax_amount
 * @property int total_amount_paid
 * @property String notes
 * @property int invoice_products_count
 * @property String due_at
 * @property String sent_at
 * @property array paid_at
 * @property String partially_paid_at
 * @property int customer_id
 * @property int currency_id
 * @property int account_id
 * @property String created_at
 * @property String updated_at
 * @property String deleted_at
 *
 * @package com.fedapay.model
 */

public class Invoice {

	private String id;
	private String number;
	private String reference;
	private String status;
	private String tax;
	@JsonProperty("discount_type")
	private String discountType;
	@JsonProperty("discount_amount")
	private String discountAmount;
	private String ttc;
	@JsonProperty("sub_total")
	private String subTotal;
	private String discount;
	@JsonProperty("before_tax")
	private String beforeTax;
	@JsonProperty("taxAmount")
	private String tax_amount;
	@JsonProperty("total_amount_paid")
	private String totalAmountPaid;
	private String notes;
	@JsonProperty("invoice_products_count")
	private String invoiceProductsCount;
	@JsonProperty("due_at")
	private String dueAt;
	@JsonProperty("sent_at")
	private String sentAt;
	@JsonProperty("paid_at")
	private Map<String, Object> paidAt;
	@JsonProperty("partially_paid_at")
	private String partiallyPaidAt;
	@JsonProperty("customer_id")
	private String customerId;
	@JsonProperty("currency_id")
	private String currencyId;
	@JsonProperty("account_id")
	private String accountId;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("deleted_at")
	private String deletedAt;
	
	public Invoice() {
		super();
	}

	public Invoice(String id, String number, String reference, String status, String tax, String discountType,
			String discountAmount, String ttc, String subTotal, String discount, String beforeTax, String tax_amount,
			String totalAmountPaid, String notes, String invoiceProductsCount, String dueAt, String sentAt,
			Map<String, Object> paidAt, String partiallyPaidAt, String customerId, String currencyId, String accountId,
			String createdAt, String updatedAt, String deletedAt) {
		super();
		this.id = id;
		this.number = number;
		this.reference = reference;
		this.status = status;
		this.tax = tax;
		this.discountType = discountType;
		this.discountAmount = discountAmount;
		this.ttc = ttc;
		this.subTotal = subTotal;
		this.discount = discount;
		this.beforeTax = beforeTax;
		this.tax_amount = tax_amount;
		this.totalAmountPaid = totalAmountPaid;
		this.notes = notes;
		this.invoiceProductsCount = invoiceProductsCount;
		this.dueAt = dueAt;
		this.sentAt = sentAt;
		this.paidAt = paidAt;
		this.partiallyPaidAt = partiallyPaidAt;
		this.customerId = customerId;
		this.currencyId = currencyId;
		this.accountId = accountId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getTtc() {
		return ttc;
	}

	public void setTtc(String ttc) {
		this.ttc = ttc;
	}

	public String getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getBeforeTax() {
		return beforeTax;
	}

	public void setBeforeTax(String beforeTax) {
		this.beforeTax = beforeTax;
	}

	public String getTax_amount() {
		return tax_amount;
	}

	public void setTax_amount(String tax_amount) {
		this.tax_amount = tax_amount;
	}

	public String getTotalAmountPaid() {
		return totalAmountPaid;
	}

	public void setTotalAmountPaid(String totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getInvoiceProductsCount() {
		return invoiceProductsCount;
	}

	public void setInvoiceProductsCount(String invoiceProductsCount) {
		this.invoiceProductsCount = invoiceProductsCount;
	}

	public String getDueAt() {
		return dueAt;
	}

	public void setDueAt(String dueAt) {
		this.dueAt = dueAt;
	}

	public String getSentAt() {
		return sentAt;
	}

	public void setSentAt(String sentAt) {
		this.sentAt = sentAt;
	}

	public Map<String, Object> getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(Map<String, Object> paidAt) {
		this.paidAt = paidAt;
	}

	public String getPartiallyPaidAt() {
		return partiallyPaidAt;
	}

	public void setPartiallyPaidAt(String partiallyPaidAt) {
		this.partiallyPaidAt = partiallyPaidAt;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	public static InvoiceCollection all() throws Exception {
		return All.all(new InvoiceCollection(), "/invoices");
	}
}
