package com.yangjiang.entity.t_zgk_pipe_tkm;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 退库主表
 * @author zhangdaihao
 * @date 2016-11-25 17:58:12
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_ZGK_PIPE_TKM", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_ZGK_PIPE_TKMEntity implements java.io.Serializable {
	/**入库单号*/
	private java.lang.String tuikudanid;
	/**退库时间*/
	private java.util.Date riqi;
	/**库房名称*/
	private java.lang.String storeName;
	/**保管员*/
	private java.lang.String baoguanyuan;
	/**收货单位*/
	private java.lang.String consignee;
	/**编号*/
	private java.lang.String id;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入库单号
	 */
	@Column(name ="TUIKUDANID",nullable=false,precision=20,length=20)
	public java.lang.String getTuikudanid(){
		return this.tuikudanid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入库单号
	 */
	public void setTuikudanid(java.lang.String tuikudanid){
		this.tuikudanid = tuikudanid;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  退库时间
	 */
	@Column(name ="RIQI",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getRiqi(){
		return this.riqi;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  退库时间
	 */
	public void setRiqi(java.util.Date riqi){
		this.riqi = riqi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  库房名称
	 */
	@Column(name ="STORE_NAME",nullable=true,precision=10,length=10)
	public java.lang.String getStoreName(){
		return this.storeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  库房名称
	 */
	public void setStoreName(java.lang.String storeName){
		this.storeName = storeName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  保管员
	 */
	@Column(name ="BAOGUANYUAN",nullable=true,precision=10,length=10)
	public java.lang.String getBaoguanyuan(){
		return this.baoguanyuan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  保管员
	 */
	public void setBaoguanyuan(java.lang.String baoguanyuan){
		this.baoguanyuan = baoguanyuan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货单位
	 */
	@Column(name ="CONSIGNEE",nullable=true,precision=20,length=20)
	public java.lang.String getConsignee(){
		return this.consignee;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货单位
	 */
	public void setConsignee(java.lang.String consignee){
		this.consignee = consignee;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=true,precision=50,length=50)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
}
