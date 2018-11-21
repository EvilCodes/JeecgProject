package com.yangjiang.entity.t_zgk_pipe_fcm;

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
 * @Description: 返厂主表
 * @author zhangdaihao
 * @date 2016-12-06 11:29:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_ZGK_PIPE_FCM", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_ZGK_PIPE_FCMEntity implements java.io.Serializable {
	/**返厂单号*/
	private java.lang.String fankudanid;
	/**日期*/
	private java.util.Date riqi;
	/**仓库名称*/
	private java.lang.String storeName;
	/**保管员*/
	private java.lang.String baoguanyuan;
	/**承运公司编码*/
	private java.lang.String carryCompanyCode;
	/**承运公司*/
	private java.lang.String carryCompanyName;
	/**运输方式*/
	private java.lang.String trnpMode;
	/**车号*/
	private java.lang.String carNo;
	/**id*/
	private java.lang.String id;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  返厂单号
	 */
	@Column(name ="FANKUDANID",nullable=false,precision=20,length=20)
	public java.lang.String getFankudanid(){
		return this.fankudanid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  返厂单号
	 */
	public void setFankudanid(java.lang.String fankudanid){
		this.fankudanid = fankudanid;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  日期
	 */
	@Column(name ="RIQI",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getRiqi(){
		return this.riqi;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  日期
	 */
	public void setRiqi(java.util.Date riqi){
		this.riqi = riqi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库名称
	 */
	@Column(name ="STORE_NAME",nullable=true,precision=10,length=10)
	public java.lang.String getStoreName(){
		return this.storeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库名称
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
	 *@return: java.lang.String  承运公司编码
	 */
	@Column(name ="CARRY_COMPANY_CODE",nullable=true,precision=10,length=10)
	public java.lang.String getCarryCompanyCode(){
		return this.carryCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承运公司编码
	 */
	public void setCarryCompanyCode(java.lang.String carryCompanyCode){
		this.carryCompanyCode = carryCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  承运公司
	 */
	@Column(name ="CARRY_COMPANY_NAME",nullable=true,precision=20,length=20)
	public java.lang.String getCarryCompanyName(){
		return this.carryCompanyName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承运公司
	 */
	public void setCarryCompanyName(java.lang.String carryCompanyName){
		this.carryCompanyName = carryCompanyName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输方式
	 */
	@Column(name ="TRNP_MODE",nullable=true,precision=10,length=10)
	public java.lang.String getTrnpMode(){
		return this.trnpMode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输方式
	 */
	public void setTrnpMode(java.lang.String trnpMode){
		this.trnpMode = trnpMode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车号
	 */
	@Column(name ="CAR_NO",nullable=true,precision=20,length=20)
	public java.lang.String getCarNo(){
		return this.carNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车号
	 */
	public void setCarNo(java.lang.String carNo){
		this.carNo = carNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=true,precision=50,length=100)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
}
