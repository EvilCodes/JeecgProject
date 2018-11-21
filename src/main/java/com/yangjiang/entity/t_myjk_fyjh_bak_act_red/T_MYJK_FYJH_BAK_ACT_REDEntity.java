package com.yangjiang.entity.t_myjk_fyjh_bak_act_red;

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
 * @Description: 数据红冲
 * @author zhangdaihao
 * @date 2017-03-09 16:28:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_MYJK_FYJH_BAK_ACT_RED", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_MYJK_FYJH_BAK_ACT_REDEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**billNoticeNo*/
	private java.lang.String billNoticeNo;
	/**billLadingNoItem*/
	private java.lang.String billLadingNoItem;
	/**sendNo*/
	private java.lang.String sendNo;
	/**readFlag*/
	private java.lang.String readFlag;
	/**insertDate*/
	private java.util.Date insertDate;
	/**sendDate*/
	private java.util.Date sendDate;
	/**outStorehouseName*/
	private java.lang.String outStorehouseName;
	/**lrr*/
	private java.lang.String lrr;
	/**lrr*/
	private java.lang.String transMode;
	
	@Column(name ="transMode",nullable=false,precision=20,length=40)
	public java.lang.String getTransMode() {
		return transMode;
	}

	public void setTransMode(java.lang.String transMode) {
		this.transMode = transMode;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,precision=50,length=100)
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  billNoticeNo
	 */
	@Column(name ="BILL_NOTICE_NO",nullable=false,precision=20,length=40)
	public java.lang.String getBillNoticeNo(){
		return this.billNoticeNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  billNoticeNo
	 */
	public void setBillNoticeNo(java.lang.String billNoticeNo){
		this.billNoticeNo = billNoticeNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  billLadingNoItem
	 */
	@Column(name ="BILL_LADING_NO_ITEM",nullable=false,precision=20,length=40)
	public java.lang.String getBillLadingNoItem(){
		return this.billLadingNoItem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  billLadingNoItem
	 */
	public void setBillLadingNoItem(java.lang.String billLadingNoItem){
		this.billLadingNoItem = billLadingNoItem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sendNo
	 */
	@Column(name ="SEND_NO",nullable=false,precision=20,length=40)
	public java.lang.String getSendNo(){
		return this.sendNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sendNo
	 */
	public void setSendNo(java.lang.String sendNo){
		this.sendNo = sendNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  readFlag
	 */
	@Column(name ="READ_FLAG",nullable=false,precision=2,length=4)
	public java.lang.String getReadFlag(){
		return this.readFlag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  readFlag
	 */
	public void setReadFlag(java.lang.String readFlag){
		this.readFlag = readFlag;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  insertDate
	 */
	@Column(name ="INSERT_DATE",nullable=false,precision=23,scale=3,length=8)
	public java.util.Date getInsertDate(){
		return this.insertDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  insertDate
	 */
	public void setInsertDate(java.util.Date insertDate){
		this.insertDate = insertDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  sendDate
	 */
	@Column(name ="SEND_DATE",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getSendDate(){
		return this.sendDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  sendDate
	 */
	public void setSendDate(java.util.Date sendDate){
		this.sendDate = sendDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  outStorehouseName
	 */
	@Column(name ="OUT_STOREHOUSE_NAME",nullable=true,precision=50,length=100)
	public java.lang.String getOutStorehouseName(){
		return this.outStorehouseName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  outStorehouseName
	 */
	public void setOutStorehouseName(java.lang.String outStorehouseName){
		this.outStorehouseName = outStorehouseName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  lrr
	 */
	@Column(name ="LRR",nullable=true,precision=20,length=20)
	public java.lang.String getLrr(){
		return this.lrr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  lrr
	 */
	public void setLrr(java.lang.String lrr){
		this.lrr = lrr;
	}
}
