package com.yangjiang.entity.t_zgk_fyjh_pcd;

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
 * @Description: 派车单
 * @author zhangdaihao
 * @date 2016-11-01 09:36:22
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_ZGK_FYJH_PCD", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_ZGK_FYJH_PCDEntity implements java.io.Serializable {
	/**派车单*/
	private java.lang.String sendCarNo;
	/**派车单明细序号*/
	private java.lang.Integer number;
	/**运号*/
	private java.lang.String carryNo;
	/**发货通知单号*/
	private java.lang.String billNoticeNo;
	/**发货通知单明细号*/
	private java.lang.String billNoticeNoItem;
	/**产品代码*/
	private java.lang.String itemCode;
	/**产品名称*/
	private java.lang.String itemName;
	/**库房代码*/
	private java.lang.String outStorehouseCode;
	/**库房名称*/
	private java.lang.String outStorehouseName;
	/**承运商代码*/
	private java.lang.String carryCompanyCode;
	/**承运商名称*/
	private java.lang.String carryCompanyName;
	/**承运数量*/
	private java.lang.Integer carryNum;
	/**承运重量*/
	private BigDecimal carryWt;
	/**运输方式名称*/
	private java.lang.String trnpMode;
	/**车牌号*/
	private java.lang.String carNo;
	/**司机姓名*/
	private java.lang.String driverName;
	/**司机电话*/
	private java.lang.String driverTel;
	/**司机身份证号*/
	private java.lang.String idNumber;
	/**状态标记*/
	private java.lang.String delFlag;
	/**修改人*/
	private java.lang.String edituser;
	/**修改IP*/
	private java.lang.String editip;
	/**修改时间*/
	private java.util.Date edittime;
	/**编号*/
	private java.lang.String id;
	/**销售公司*/
	private java.lang.String orgName;
	/**收货公司*/
	private java.lang.String consignCname;
	/**收货地址*/
	private java.lang.String recAdd;
	
	/**特殊合同描述*/
	private java.lang.String specialDesc;
	
	/**内外销标志*/
	private java.lang.String expFlag;
	
	private java.lang.Integer ifzc;
	
	@Column(name ="specialDesc",nullable=false,precision=20,length=20)
	public java.lang.String getSpecialDesc() {
		return specialDesc;
	}

	public void setSpecialDesc(java.lang.String specialDesc) {
		this.specialDesc = specialDesc;
	}
	@Column(name ="expFlag",nullable=false,precision=20,length=20)
	public java.lang.String getExpFlag() {
		return expFlag;
	}

	public void setExpFlag(java.lang.String expFlag) {
		this.expFlag = expFlag;
	}

	@Column(name ="org_name",nullable=false,precision=20,length=20)
	public java.lang.String getOrgName() {
		return orgName;
	}

	public void setOrgName(java.lang.String orgName) {
		this.orgName = orgName;
	}

	@Column(name ="consign_cname",nullable=false,precision=20,length=20)
	public java.lang.String getConsignCname() {
		return consignCname;
	}

	public void setConsignCname(java.lang.String consignCname) {
		this.consignCname = consignCname;
	}
	@Column(name ="rec_add",nullable=false,precision=20,length=20)
	public java.lang.String getRecAdd() {
		return recAdd;
	}

	public void setRecAdd(java.lang.String recAdd) {
		this.recAdd = recAdd;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  派车单
	 */
	@Column(name ="SEND_CAR_NO",nullable=false,precision=20,length=20)
	public java.lang.String getSendCarNo(){
		return this.sendCarNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派车单
	 */
	public void setSendCarNo(java.lang.String sendCarNo){
		this.sendCarNo = sendCarNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  派车单明细序号
	 */
	@Column(name ="NUMBER",nullable=true,precision=5,scale=0,length=2)
	public java.lang.Integer getNumber(){
		return this.number;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  派车单明细序号
	 */
	public void setNumber(java.lang.Integer number){
		this.number = number;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运号
	 */
	@Column(name ="CARRY_NO",nullable=true,precision=20,length=20)
	public java.lang.String getCarryNo(){
		return this.carryNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运号
	 */
	public void setCarryNo(java.lang.String carryNo){
		this.carryNo = carryNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发货通知单号
	 */
	@Column(name ="BILL_NOTICE_NO",nullable=true,precision=20,length=20)
	public java.lang.String getBillNoticeNo(){
		return this.billNoticeNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货通知单号
	 */
	public void setBillNoticeNo(java.lang.String billNoticeNo){
		this.billNoticeNo = billNoticeNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发货通知单明细号
	 */
	@Column(name ="BILL_NOTICE_NO_ITEM",nullable=true,precision=30,length=30)
	public java.lang.String getBillNoticeNoItem(){
		return this.billNoticeNoItem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货通知单明细号
	 */
	public void setBillNoticeNoItem(java.lang.String billNoticeNoItem){
		this.billNoticeNoItem = billNoticeNoItem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品代码
	 */
	@Column(name ="ITEM_CODE",nullable=true,precision=20,length=20)
	public java.lang.String getItemCode(){
		return this.itemCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品代码
	 */
	public void setItemCode(java.lang.String itemCode){
		this.itemCode = itemCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品名称
	 */
	@Column(name ="ITEM_NAME",nullable=true,precision=200,length=200)
	public java.lang.String getItemName(){
		return this.itemName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品名称
	 */
	public void setItemName(java.lang.String itemName){
		this.itemName = itemName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  库房代码
	 */
	@Column(name ="OUT_STOREHOUSE_CODE",nullable=true,precision=20,length=20)
	public java.lang.String getOutStorehouseCode(){
		return this.outStorehouseCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  库房代码
	 */
	public void setOutStorehouseCode(java.lang.String outStorehouseCode){
		this.outStorehouseCode = outStorehouseCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  库房名称
	 */
	@Column(name ="OUT_STOREHOUSE_NAME",nullable=true,precision=30,length=30)
	public java.lang.String getOutStorehouseName(){
		return this.outStorehouseName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  库房名称
	 */
	public void setOutStorehouseName(java.lang.String outStorehouseName){
		this.outStorehouseName = outStorehouseName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  承运商代码
	 */
	@Column(name ="CARRY_COMPANY_CODE",nullable=true,precision=20,length=20)
	public java.lang.String getCarryCompanyCode(){
		return this.carryCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承运商代码
	 */
	public void setCarryCompanyCode(java.lang.String carryCompanyCode){
		this.carryCompanyCode = carryCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  承运商名称
	 */
	@Column(name ="CARRY_COMPANY_NAME",nullable=true,precision=30,length=60)
	public java.lang.String getCarryCompanyName(){
		return this.carryCompanyName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承运商名称
	 */
	public void setCarryCompanyName(java.lang.String carryCompanyName){
		this.carryCompanyName = carryCompanyName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  承运数量
	 */
	@Column(name ="CARRY_NUM",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getCarryNum(){
		return this.carryNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  承运数量
	 */
	public void setCarryNum(java.lang.Integer carryNum){
		this.carryNum = carryNum;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  承运重量
	 */
	@Column(name ="CARRY_WT",nullable=true,precision=13,scale=6,length=9)
	public BigDecimal getCarryWt(){
		return this.carryWt;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  承运重量
	 */
	public void setCarryWt(BigDecimal carryWt){
		this.carryWt = carryWt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输方式名称
	 */
	@Column(name ="TRNP_MODE",nullable=true,precision=20,length=20)
	public java.lang.String getTrnpMode(){
		return this.trnpMode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输方式名称
	 */
	public void setTrnpMode(java.lang.String trnpMode){
		this.trnpMode = trnpMode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车牌号
	 */
	@Column(name ="CAR_NO",nullable=true,precision=20,length=20)
	public java.lang.String getCarNo(){
		return this.carNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车牌号
	 */
	public void setCarNo(java.lang.String carNo){
		this.carNo = carNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  司机姓名
	 */
	@Column(name ="DRIVER_NAME",nullable=true,precision=10,length=10)
	public java.lang.String getDriverName(){
		return this.driverName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  司机姓名
	 */
	public void setDriverName(java.lang.String driverName){
		this.driverName = driverName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  司机电话
	 */
	@Column(name ="DRIVER_TEL",nullable=true,precision=20,length=20)
	public java.lang.String getDriverTel(){
		return this.driverTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  司机电话
	 */
	public void setDriverTel(java.lang.String driverTel){
		this.driverTel = driverTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  司机身份证号
	 */
	@Column(name ="ID_NUMBER",nullable=true,precision=20,length=20)
	public java.lang.String getIdNumber(){
		return this.idNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  司机身份证号
	 */
	public void setIdNumber(java.lang.String idNumber){
		this.idNumber = idNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态标记
	 */
	@Column(name ="DEL_FLAG",nullable=true,precision=1,length=1)
	public java.lang.String getDelFlag(){
		return this.delFlag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态标记
	 */
	public void setDelFlag(java.lang.String delFlag){
		this.delFlag = delFlag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人
	 */
	@Column(name ="EDITUSER",nullable=true,precision=10,length=10)
	public java.lang.String getEdituser(){
		return this.edituser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人
	 */
	public void setEdituser(java.lang.String edituser){
		this.edituser = edituser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改IP
	 */
	@Column(name ="EDITIP",nullable=true,precision=20,length=20)
	public java.lang.String getEditip(){
		return this.editip;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改IP
	 */
	public void setEditip(java.lang.String editip){
		this.editip = editip;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */
	@Column(name ="EDITTIME",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getEdittime(){
		return this.edittime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setEdittime(java.util.Date edittime){
		this.edittime = edittime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=true,precision=36,length=72)
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
	
	@Column(name ="ifzc",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getIfzc(){
		return this.ifzc;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  承运数量
	 */
	public void setIfzc(java.lang.Integer Ifzc){
		this.ifzc = Ifzc;
	}
}
