package com.yangjiang.entity.t_zgk_pipe_hckd;

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
 * @Description: 火车装车
 * @author zhangdaihao
 * @date 2017-03-28 17:32:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_ZGK_PIPE_HCKD", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_ZGK_PIPE_HCKDEntity implements java.io.Serializable {
	/**chukudanid*/
	private java.lang.String chukudanid;
	/**dn*/
	private java.lang.String dn;
	/**batchFull*/
	private java.lang.String batchFull;
	/**pipeSerial*/
	private java.lang.String pipeSerial;
	/**packageid*/
	private java.lang.String packageid;
	/**productPlanNo*/
	private java.lang.String productPlanNo;
	/**itemCode*/
	private java.lang.String itemCode;
	/**itemCname*/
	private java.lang.String itemCname;
	/**expFlag*/
	private java.lang.String expFlag;
	/**specialDesc*/
	private java.lang.String specialDesc;
	/**pipenum*/
	private java.lang.Integer pipenum;
	/**productLine*/
	private java.lang.String productLine;
	/**id*/
	private java.lang.String id;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chukudanid
	 */
	@Column(name ="CHUKUDANID",nullable=false,precision=20,length=20)
	public java.lang.String getChukudanid(){
		return this.chukudanid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  chukudanid
	 */
	public void setChukudanid(java.lang.String chukudanid){
		this.chukudanid = chukudanid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  dn
	 */
	@Column(name ="DN",nullable=true,precision=10,length=10)
	public java.lang.String getDn(){
		return this.dn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  dn
	 */
	public void setDn(java.lang.String dn){
		this.dn = dn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  batchFull
	 */
	@Column(name ="BATCH_FULL",nullable=true,precision=10,length=10)
	public java.lang.String getBatchFull(){
		return this.batchFull;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  batchFull
	 */
	public void setBatchFull(java.lang.String batchFull){
		this.batchFull = batchFull;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  pipeSerial
	 */
	@Column(name ="PIPE_SERIAL",nullable=true,precision=10,length=10)
	public java.lang.String getPipeSerial(){
		return this.pipeSerial;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  pipeSerial
	 */
	public void setPipeSerial(java.lang.String pipeSerial){
		this.pipeSerial = pipeSerial;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  packageid
	 */
	@Column(name ="PACKAGEID",nullable=true,precision=20,length=20)
	public java.lang.String getPackageid(){
		return this.packageid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  packageid
	 */
	public void setPackageid(java.lang.String packageid){
		this.packageid = packageid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  productPlanNo
	 */
	@Column(name ="PRODUCT_PLAN_NO",nullable=true,precision=20,length=20)
	public java.lang.String getProductPlanNo(){
		return this.productPlanNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  productPlanNo
	 */
	public void setProductPlanNo(java.lang.String productPlanNo){
		this.productPlanNo = productPlanNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  itemCode
	 */
	@Column(name ="ITEM_CODE",nullable=true,precision=20,length=20)
	public java.lang.String getItemCode(){
		return this.itemCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  itemCode
	 */
	public void setItemCode(java.lang.String itemCode){
		this.itemCode = itemCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  itemCname
	 */
	@Column(name ="ITEM_CNAME",nullable=true,precision=200,length=200)
	public java.lang.String getItemCname(){
		return this.itemCname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  itemCname
	 */
	public void setItemCname(java.lang.String itemCname){
		this.itemCname = itemCname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  expFlag
	 */
	@Column(name ="EXP_FLAG",nullable=true,precision=4,length=8)
	public java.lang.String getExpFlag(){
		return this.expFlag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  expFlag
	 */
	public void setExpFlag(java.lang.String expFlag){
		this.expFlag = expFlag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  specialDesc
	 */
	@Column(name ="SPECIAL_DESC",nullable=true,precision=30,length=30)
	public java.lang.String getSpecialDesc(){
		return this.specialDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  specialDesc
	 */
	public void setSpecialDesc(java.lang.String specialDesc){
		this.specialDesc = specialDesc;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  pipenum
	 */
	@Column(name ="PIPENUM",nullable=true,precision=5,scale=0,length=2)
	public java.lang.Integer getPipenum(){
		return this.pipenum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  pipenum
	 */
	public void setPipenum(java.lang.Integer pipenum){
		this.pipenum = pipenum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  productLine
	 */
	@Column(name ="PRODUCT_LINE",nullable=true,precision=20,length=20)
	public java.lang.String getProductLine(){
		return this.productLine;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  productLine
	 */
	public void setProductLine(java.lang.String productLine){
		this.productLine = productLine;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="id",nullable=true,precision=36,length=72)
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
