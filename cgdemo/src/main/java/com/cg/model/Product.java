package com.cg.model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;


import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = 89086748L;

	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productID;

	@Column(name="product_uid")
	private String productUID;

	@Column(name = "product_userid")
	private String productUserId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "color")
	private String color;

	@Column(name = "product_desc")
	private String productDesc;

	@Column(name = "pic_byte")
	private byte[] picByte;

	@Column(name = "size")
	private String size;

	@Column(name = "product_rating")
	private int productRating;

	@Column(name = "price")
	private double pricePerUnit;

	@Column(name = "totalPrice")
	private double totalPrice;

	@Version
	@Column(name="update_ts")
	private Calendar updatedTimeStamp;

	@Column(name="creation_ts", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
	private Calendar creationTimeStamp;

	@JsonIgnore
	@ManyToOne
	@JoinColumn( name = "category_id")
	private Category category;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name ="order_id")
	private OrderInfo order;

	@Column(name ="publisher")
    private String publisher;

	@Column(name ="publication_date")
    private String publicationDate;

	@Column(name ="isbn")
    private String isbn;

	@Column(name ="shipping_weight")
    private double shippingWeight;

	@Column(name ="product_active")
    private boolean IsProductActive=true;

	@Column(name ="instock_number")
    private int inStockNumber;
    
    @Transient
    private MultipartFile foodImage;

	@Column(name ="product_feedback")
    private String productFeedback;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductToCart> foodToCartList;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductToOrder> foodToOrderList;

	public Product() {
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getProductUID() {
		return productUID;
	}

	public void setProductUID(String productUID) {
		this.productUID = productUID;
	}

	public String getProductUserId() {
		return productUserId;
	}

	public void setProductUserId(String productUserId) {
		this.productUserId = productUserId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getProductRating() {
		return productRating;
	}

	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Calendar getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	public void setUpdatedTimeStamp(Calendar updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}

	public Calendar getCreationTimeStamp() {
		return creationTimeStamp;
	}

	public void setCreationTimeStamp(Calendar creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public OrderInfo getOrder() {
		return order;
	}

	public void setOrder(OrderInfo order) {
		this.order = order;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getShippingWeight() {
		return shippingWeight;
	}

	public void setShippingWeight(double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}

	public boolean isProductActive() {
		return IsProductActive;
	}

	public void setProductActive(boolean productActive) {
		IsProductActive = productActive;
	}

	public int getInStockNumber() {
		return inStockNumber;
	}

	public void setInStockNumber(int inStockNumber) {
		this.inStockNumber = inStockNumber;
	}

	public MultipartFile getFoodImage() {
		return foodImage;
	}

	public void setFoodImage(MultipartFile foodImage) {
		this.foodImage = foodImage;
	}

	public String getProductFeedback() {
		return productFeedback;
	}

	public void setProductFeedback(String productFeedback) {
		this.productFeedback = productFeedback;
	}

	public List<ProductToCart> getFoodToCartList() {
		return foodToCartList;
	}

	public void setFoodToCartList(List<ProductToCart> foodToCartList) {
		this.foodToCartList = foodToCartList;
	}

	public List<ProductToOrder> getFoodToOrderList() {
		return foodToOrderList;
	}

	public void setFoodToOrderList(List<ProductToOrder> foodToOrderList) {
		this.foodToOrderList = foodToOrderList;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productID=" + productID +
				", productUID='" + productUID + '\'' +
				", productUserId='" + productUserId + '\'' +
				", productName='" + productName + '\'' +
				", quantity=" + quantity +
				", color='" + color + '\'' +
				", productDesc='" + productDesc + '\'' +
				", picByte=" + Arrays.toString(picByte) +
				", size='" + size + '\'' +
				", productRating=" + productRating +
				", pricePerUnit=" + pricePerUnit +
				", totalPrice=" + totalPrice +
				", updatedTimeStamp=" + updatedTimeStamp +
				", creationTimeStamp=" + creationTimeStamp +
				", category=" + category +
				", order=" + order +
				", publisher='" + publisher + '\'' +
				", publicationDate='" + publicationDate + '\'' +
				", isbn='" + isbn + '\'' +
				", shippingWeight=" + shippingWeight +
				", IsProductActive=" + IsProductActive +
				", inStockNumber=" + inStockNumber +
				", foodImage=" + foodImage +
				", productFeedback='" + productFeedback + '\'' +
				", foodToCartList=" + foodToCartList +
				", foodToOrderList=" + foodToOrderList +
				'}';
	}
}
