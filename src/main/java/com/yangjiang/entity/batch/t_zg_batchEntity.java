package com.yangjiang.entity.batch;

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
 * @Description: 批号
 * @author zhangdaihao
 * @date 2016-10-09 15:41:46
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_zg_batch", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class t_zg_batchEntity implements java.io.Serializable {
	/**编号*/
	private java.lang.String id;
	/**规格*/
	private java.lang.String dn;
	/**批号全称*/
	private java.lang.String batchFull;
	/**年份*/
	private java.lang.Integer pYear;
	/**批号*/
	private java.lang.String batch;
	/**生产日期*/
	private java.lang.String productDate;
	/**铸管类别*/
	private java.lang.String pipetype;
	/**技术标准*/
	private java.lang.String standard;
	/**接口方式*/
	private java.lang.String interfaceDesc;
	/**壁厚等级*/
	private java.lang.String grade;
	/**长度*/
	private java.lang.String length;
	/**数量*/
	private java.lang.String quantity;
	/**使用时间*/
	private java.lang.String usetime;
	/**影响*/
	private java.lang.String effect;
	/**生产部门*/
	private java.lang.String productDept;
	
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
	 *@return: java.lang.String  规格
	 */
	@Column(name ="DN",nullable=false,precision=32,length=32)
	public java.lang.String getDn(){
		return this.dn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格
	 */
	public void setDn(java.lang.String dn){
		this.dn = dn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  批号全称
	 */
	@Column(name ="BATCH_FULL",nullable=false,precision=64,length=64)
	public java.lang.String getBatchFull(){
		return this.batchFull;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  批号全称
	 */
	public void setBatchFull(java.lang.String batchFull){
		this.batchFull = batchFull;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年份
	 */
	@Column(name ="P_YEAR",nullable=true,precision=5,scale=0,length=2)
	public java.lang.Integer getPYear(){
		return this.pYear;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年份
	 */
	public void setPYear(java.lang.Integer pYear){
		this.pYear = pYear;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  批号
	 */
	@Column(name ="BATCH",nullable=false,precision=32,length=32)
	public java.lang.String getBatch(){
		return this.batch;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  批号
	 */
	public void setBatch(java.lang.String batch){
		this.batch = batch;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产日期
	 */
	@Column(name ="PRODUCT_DATE",nullable=false,precision=32,length=32)
	public java.lang.String getProductDate(){
		return this.productDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产日期
	 */
	public void setProductDate(java.lang.String productDate){
		this.productDate = productDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  铸管类别
	 */
	@Column(name ="PIPETYPE",nullable=false,precision=32,length=32)
	public java.lang.String getPipetype(){
		return this.pipetype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  铸管类别
	 */
	public void setPipetype(java.lang.String pipetype){
		this.pipetype = pipetype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  技术标准
	 */
	@Column(name ="STANDARD",nullable=false,precision=32,length=32)
	public java.lang.String getStandard(){
		return this.standard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  技术标准
	 */
	public void setStandard(java.lang.String standard){
		this.standard = standard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  接口方式
	 */
	@Column(name ="INTERFACE_DESC",nullable=true,precision=32,length=32)
	public java.lang.String getInterfaceDesc(){
		return this.interfaceDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  接口方式
	 */
	public void setInterfaceDesc(java.lang.String interfaceDesc){
		this.interfaceDesc = interfaceDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  壁厚等级
	 */
	@Column(name ="GRADE",nullable=true,precision=32,length=32)
	public java.lang.String getGrade(){
		return this.grade;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  壁厚等级
	 */
	public void setGrade(java.lang.String grade){
		this.grade = grade;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  长度
	 */
	@Column(name ="LENGTH",nullable=true,precision=32,length=32)
	public java.lang.String getLength(){
		return this.length;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  长度
	 */
	public void setLength(java.lang.String length){
		this.length = length;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数量
	 */
	@Column(name ="QUANTITY",nullable=true,precision=32,length=32)
	public java.lang.String getQuantity(){
		return this.quantity;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数量
	 */
	public void setQuantity(java.lang.String quantity){
		this.quantity = quantity;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  使用时间
	 */
	@Column(name ="USETIME",nullable=true,precision=32,length=32)
	public java.lang.String getUsetime(){
		return this.usetime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  使用时间
	 */
	public void setUsetime(java.lang.String usetime){
		this.usetime = usetime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  影响
	 */
	@Column(name ="EFFECT",nullable=true,precision=32,length=32)
	public java.lang.String getEffect(){
		return this.effect;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  影响
	 */
	public void setEffect(java.lang.String effect){
		this.effect = effect;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产部门
	 */
	@Column(name ="PRODUCT_DEPT",nullable=true,precision=32,length=64)
	public java.lang.String getProductDept(){
		return this.productDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产部门
	 */
	public void setProductDept(java.lang.String productDept){
		this.productDept = productDept;
	}
}
