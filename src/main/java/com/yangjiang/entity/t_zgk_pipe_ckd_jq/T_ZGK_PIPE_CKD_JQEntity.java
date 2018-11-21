package com.yangjiang.entity.t_zgk_pipe_ckd_jq;

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
 * @Description: 随车胶圈
 * @author zhangdaihao
 * @date 2017-04-07 16:46:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_zgk_pipe_ckd_jq", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_ZGK_PIPE_CKD_JQEntity implements java.io.Serializable {
	/**编号*/
	private java.lang.String id;
	/**厂家*/
	private java.lang.String factory;
	/**产品编码*/
	private java.lang.String itemcode;
	/**产品名称*/
	private java.lang.String itemname;
	/**发货数量*/
	private java.lang.Integer sendnum;
	/**出库单号*/
	private java.lang.String chukudanid;
	/**派车单号*/
	private java.lang.String pcdid;
	/**发运重量*/
	private java.lang.String sendweight;
	/**名称*/
	private java.lang.String name;
	/**规格*/
	private java.lang.String readflag;
	/**厂家代码*/
	private java.lang.String factoryCode;
	/**备注*/
	private java.lang.String remark;
	/**审核标记*/
	private java.lang.String shbz;
	@Column(name ="shbz",precision=50,length=100)
	public java.lang.String getShbz() {
		return shbz;
	}

	public void setShbz(java.lang.String shbz) {
		this.shbz = shbz;
	}
	@Column(name ="shr",nullable=true,precision=50,length=100)
	public java.lang.String getShr() {
		return shr;
	}

	public void setShr(java.lang.String shr) {
		this.shr = shr;
	}
	@Column(name ="shsj",nullable=true,precision=50,length=100)
	public java.util.Date getShsj() {
		return shsj;
	}

	public void setShsj(java.util.Date shsj) {
		this.shsj = shsj;
	}

	/**审核人*/
	private java.lang.String shr;
	
	/**审核时间*/
	private java.util.Date shsj;
	@Column(name ="remark",nullable=true,precision=50,length=100)
	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	@Column(name ="factoryCode",nullable=true,precision=50,length=100)
	public java.lang.String getFactoryCode() {
		return factoryCode;
	}

	public void setFactoryCode(java.lang.String factoryCode) {
		this.factoryCode = factoryCode;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
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
	 *@param: java.lang.String  编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  厂家
	 */
	@Column(name ="FACTORY",nullable=true,precision=50,length=100)
	public java.lang.String getFactory(){
		return this.factory;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  厂家
	 */
	public void setFactory(java.lang.String factory){
		this.factory = factory;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品编码
	 */
	@Column(name ="ITEMCODE",nullable=true,precision=50,length=100)
	public java.lang.String getItemcode(){
		return this.itemcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品编码
	 */
	public void setItemcode(java.lang.String itemcode){
		this.itemcode = itemcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品名称
	 */
	@Column(name ="ITEMNAME",nullable=true,precision=50,length=100)
	public java.lang.String getItemname(){
		return this.itemname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品名称
	 */
	public void setItemname(java.lang.String itemname){
		this.itemname = itemname;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  发货数量
	 */
	@Column(name ="SENDNUM",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getSendnum(){
		return this.sendnum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  发货数量
	 */
	public void setSendnum(java.lang.Integer sendnum){
		this.sendnum = sendnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出库单号
	 */
	@Column(name ="CHUKUDANID",nullable=true,precision=50,length=100)
	public java.lang.String getChukudanid(){
		return this.chukudanid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出库单号
	 */
	public void setChukudanid(java.lang.String chukudanid){
		this.chukudanid = chukudanid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  派车单号
	 */
	@Column(name ="PCDID",nullable=true,precision=50,length=100)
	public java.lang.String getPcdid(){
		return this.pcdid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派车单号
	 */
	public void setPcdid(java.lang.String pcdid){
		this.pcdid = pcdid;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  发运重量
	 */
	@Column(name ="SENDWEIGHT",nullable=true,precision=18,scale=4,length=9)
	public java.lang.String getSendweight(){
		return this.sendweight;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  发运重量
	 */
	public void setSendweight(java.lang.String sendweight){
		this.sendweight = sendweight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名称
	 */
	@Column(name ="NAME",nullable=true,precision=50,length=100)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格
	 */
	@Column(name ="readflag",nullable=true,precision=50,length=100)
	public java.lang.String getReadflag(){
		return this.readflag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格
	 */
	public void setReadflag(java.lang.String readflag){
		this.readflag = readflag;
	}
}
