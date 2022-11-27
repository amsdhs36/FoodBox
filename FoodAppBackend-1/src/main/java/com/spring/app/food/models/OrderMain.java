package com.spring.app.food.models;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;



import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity

@DynamicUpdate
public class OrderMain implements Serializable {
    private static final long serialVersionUID = -3819883511505235030L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "orderMain")
    private Set<ProductInOrder> products = new HashSet<>();

    private String buyerEmail;

    
    private String buyerName;

  
    private String buyerPhone;

  
    private String buyerAddress;

    // Total Amount
    @NotNull
    private BigDecimal orderAmount;

    /**
     * default 0: new order.
     */
    @NotNull
    @ColumnDefault("0")
    private Integer orderStatus;

    @CreationTimestamp
    private LocalDateTime createTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    public OrderMain(User user) {
        this.buyerEmail = user.getEmail();
        this.buyerName = user.getUsername();
        this.buyerPhone = user.getPhone();
        this.buyerAddress = user.getAddress();
        this.orderAmount = user.getCart().getProducts().stream().map(item -> item.getProductPrice().multiply(new BigDecimal(item.getCount())))
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal(0));
        this.orderStatus = 0;
           

    }
    public OrderMain() {
		//TODO Auto-generated constructor stub
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Set<ProductInOrder> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductInOrder> products) {
		this.products = products;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyerPhone() {
		return buyerPhone;
	}
	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}
	public String getBuyerAddress() {
		return buyerAddress;
	}
	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}
	public BigDecimal getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public OrderMain(Long orderId, Set<ProductInOrder> products, String buyerEmail, String buyerName, String buyerPhone,
			String buyerAddress, BigDecimal orderAmount, Integer orderStatus, LocalDateTime createTime,
			LocalDateTime updateTime) {
		super();
		this.orderId = orderId;
		this.products = products;
		this.buyerEmail = buyerEmail;
		this.buyerName = buyerName;
		this.buyerPhone = buyerPhone;
		this.buyerAddress = buyerAddress;
		this.orderAmount = orderAmount;
		this.orderStatus = orderStatus;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	public OrderMain(Set<ProductInOrder> products, String buyerEmail, String buyerName, String buyerPhone,
			String buyerAddress, BigDecimal orderAmount, Integer orderStatus, LocalDateTime createTime,
			LocalDateTime updateTime) {
		super();
		this.products = products;
		this.buyerEmail = buyerEmail;
		this.buyerName = buyerName;
		this.buyerPhone = buyerPhone;
		this.buyerAddress = buyerAddress;
		this.orderAmount = orderAmount;
		this.orderStatus = orderStatus;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
    
}
