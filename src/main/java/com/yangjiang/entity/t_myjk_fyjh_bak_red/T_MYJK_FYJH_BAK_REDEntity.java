package com.yangjiang.entity.t_myjk_fyjh_bak_red;

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
 * @Description: 被动红冲
 * @author zhangdaihao
 * @date 2017-03-14 17:33:02
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_MYJK_FYJH_BAK_RED", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_MYJK_FYJH_BAK_REDEntity implements java.io.Serializable {
	/**billNoticeNo*/
	private java.lang.String billNoticeNo;
	/**billLadingNoItem*/
	private java.lang.String billLadingNoItem;
	/**sendNo*/
	private java.lang.String sendNo;
	/**outStorehouseName*/
	private java.lang.String outStorehouseName;
	/**shbz*/
	private java.lang.String shbz;
	/**shr*/
	private java.lang.String shr;
	/**shsj*/
	private java.util.Date shsj;
	/**insertDate*/
	private java.util.Date insertDate;
	
	/**id*/
	private java.lang.String id;
	/**id*/
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,precision=36,length=36)
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  billNoticeNo
	 */
	@Column(name ="BILL_NOTICE_NO",nullable=false,precision=20,length=20)
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
	@Column(name ="BILL_LADING_NO_ITEM",nullable=false,precision=20,length=20)
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
	@Column(name ="SEND_NO",nullable=false,precision=20,length=20)
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
	 *@return: java.lang.String  outStorehouseName
	 */
	@Column(name ="OUT_STOREHOUSE_NAME",nullable=true,precision=50,length=50)
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
	 *@return: java.lang.String  shbz
	 */
	@Column(name ="SHBZ",nullable=false,precision=1,length=1)
	public java.lang.String getShbz(){
		return this.shbz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shbz
	 */
	public void setShbz(java.lang.String shbz){
		this.shbz = shbz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shr
	 */
	@Column(name ="SHR",nullable=true,precision=20,length=20)
	public java.lang.String getShr(){
		return this.shr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shr
	 */
	public void setShr(java.lang.String shr){
		this.shr = shr;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  shsj
	 */
	@Column(name ="SHSJ",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getShsj(){
		return this.shsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  shsj
	 */
	public void setShsj(java.util.Date shsj){
		this.shsj = shsj;
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
	
}
