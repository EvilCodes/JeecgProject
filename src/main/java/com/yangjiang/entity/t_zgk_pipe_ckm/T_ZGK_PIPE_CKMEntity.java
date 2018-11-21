package com.yangjiang.entity.t_zgk_pipe_ckm;

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
 * @Description: 出库单主表
 * @author zhangdaihao
 * @date 2016-10-31 09:51:55
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_ZGK_PIPE_CKM", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_ZGK_PIPE_CKMEntity implements java.io.Serializable {
	/**出库单号*/
	private java.lang.String chukudanid;
	/**出库日期*/
	private java.util.Date riqi;
	/**库名*/
	private java.lang.String storeName;
	/**保管员*/
	private java.lang.String baoguanyuan;
	/**派车单*/
	private java.lang.String sendCarNo;
	/**发货通知单号*/
	private java.lang.String billNoticeNo;
	/**承运商代码*/
	private java.lang.String carryCompanyCode;
	/**承运商名称*/
	private java.lang.String carryCompanyName;
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
	/**组织机构名称*/
	private java.lang.String orgName;
	/**收货单位名称*/
	private java.lang.String consignCname;
	/**交货地点名称*/
	private java.lang.String delivyPlaceName;
	/**专用线名称*/
	private java.lang.String privateRouteName;
	/**id*/
	private java.lang.String id;
	/**发货通知单明细号*/
	private java.lang.String billLadingNoItem;
	/**车厢型号编码*/
	private java.lang.String blockSize;
	/**车厢型号名称*/
	private java.lang.String blockSizeName;	
	/**车厢名*/
	private java.lang.String blockNo;
	/**短尺标记*/
	private java.lang.String noSameMark;
	/**样品管标记*/
	private java.lang.String sample;
	/**集装箱号*/
	private java.lang.String boxNo;
	/**审核人*/
	private java.lang.String shr;
	/**审核时间*/
	private java.lang.String shsj;
	/**审核标记*/
	private java.lang.String shbz;
	/**读取标记*/
	private java.lang.String readFlag;
	/**备注*/
	private java.lang.String remark;
	/**作废*/
	private java.lang.String conceal;
	
	
	@Column(name ="conceal",nullable=false,precision=20,length=20)
	public java.lang.String getConceal() {
		return conceal;
	}

	public void setConceal(java.lang.String conceal) {
		this.conceal = conceal;
	}

	@Column(name ="BLOCK_SIZE_NAME",nullable=false,precision=20,length=20)
	public java.lang.String getBlockSizeName() {
		return blockSizeName;
	}

	public void setBlockSizeName(java.lang.String blockSizeName) {
		this.blockSizeName = blockSizeName;
	}
	@Column(name ="bill_lading_no_item",nullable=false,precision=20,length=20)
	public java.lang.String getBillLadingNoItem() {
		return billLadingNoItem;
	}

	public void setBillLadingNoItem(java.lang.String billLadingNoItem) {
		this.billLadingNoItem = billLadingNoItem;
	}
	@Column(name ="BLOCK_SIZE",nullable=false,precision=20,length=20)
	public java.lang.String getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(java.lang.String blockSize) {
		this.blockSize = blockSize;
	}
	@Column(name ="BLOCK_NO",nullable=false,precision=20,length=20)
	public java.lang.String getBlockNo() {
		return blockNo;
	}

	public void setBlockNo(java.lang.String blockNo) {
		this.blockNo = blockNo;
	}
	@Column(name ="NO_SAME_MARK",nullable=false,precision=20,length=20)
	public java.lang.String getNoSameMark() {
		return noSameMark;
	}

	public void setNoSameMark(java.lang.String noSameMark) {
		this.noSameMark = noSameMark;
	}
	@Column(name ="SAMPLE",nullable=false,precision=20,length=20)
	public java.lang.String getSample() {
		return sample;
	}

	public void setSample(java.lang.String sample) {
		this.sample = sample;
	}
	@Column(name ="BOX_NO",nullable=false,precision=20,length=20)
	public java.lang.String getBoxNo() {
		return boxNo;
	}

	public void setBoxNo(java.lang.String boxNo) {
		this.boxNo = boxNo;
	}
	@Column(name ="SHR",nullable=false,precision=20,length=20)
	public java.lang.String getShr() {
		return shr;
	}

	public void setShr(java.lang.String shr) {
		this.shr = shr;
	}
	@Column(name ="SHSJ",nullable=false,precision=20,length=20)
	public java.lang.String getShsj() {
		return shsj;
	}

	public void setShsj(java.lang.String shsj) {
		this.shsj = shsj;
	}
	@Column(name ="SHBZ",nullable=false,precision=20,length=20)
	public java.lang.String getShbz() {
		return shbz;
	}

	public void setShbz(java.lang.String shbz) {
		this.shbz = shbz;
	}
	@Column(name ="READ_FLAG",nullable=false,precision=20,length=20)
	public java.lang.String getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(java.lang.String readFlag) {
		this.readFlag = readFlag;
	}
	@Column(name ="REMARK",nullable=false,precision=20,length=20)
	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出库单号
	 */
	@Column(name ="CHUKUDANID",nullable=false,precision=20,length=20)
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出库日期
	 */
	@Column(name ="RIQI",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getRiqi(){
		return this.riqi;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出库日期
	 */
	public void setRiqi(java.util.Date riqi){
		this.riqi = riqi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  库名
	 */
	@Column(name ="STORE_NAME",nullable=true,precision=10,length=10)
	public java.lang.String getStoreName(){
		return this.storeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  库名
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
	 *@return: java.lang.String  派车单
	 */
	@Column(name ="SEND_CAR_NO",nullable=true,precision=20,length=20)
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
	 *@return: java.lang.String  承运商代码
	 */
	@Column(name ="CARRY_COMPANY_CODE",nullable=true,precision=10,length=10)
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
	@Column(name ="CARRY_COMPANY_NAME",nullable=true,precision=16,length=16)
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
	@Column(name ="DRIVER_NAME",nullable=true,precision=20,length=20)
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
	@Column(name ="DRIVER_TEL",nullable=true,precision=30,length=30)
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
	@Column(name ="ID_NUMBER",nullable=true,precision=30,length=30)
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
	 *@return: java.lang.String  组织机构名称
	 */
	@Column(name ="ORG_NAME",nullable=true,precision=20,length=20)
	public java.lang.String getOrgName(){
		return this.orgName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组织机构名称
	 */
	public void setOrgName(java.lang.String orgName){
		this.orgName = orgName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货单位名称
	 */
	@Column(name ="CONSIGN_CNAME",nullable=true,precision=80,length=80)
	public java.lang.String getConsignCname(){
		return this.consignCname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货单位名称
	 */
	public void setConsignCname(java.lang.String consignCname){
		this.consignCname = consignCname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交货地点名称
	 */
	@Column(name ="DELIVY_PLACE_NAME",nullable=true,precision=80,length=80)
	public java.lang.String getDelivyPlaceName(){
		return this.delivyPlaceName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交货地点名称
	 */
	public void setDelivyPlaceName(java.lang.String delivyPlaceName){
		this.delivyPlaceName = delivyPlaceName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专用线名称
	 */
	@Column(name ="PRIVATE_ROUTE_NAME",nullable=true,precision=80,length=80)
	public java.lang.String getPrivateRouteName(){
		return this.privateRouteName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专用线名称
	 */
	public void setPrivateRouteName(java.lang.String privateRouteName){
		this.privateRouteName = privateRouteName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=true,precision=36,length=36)
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
