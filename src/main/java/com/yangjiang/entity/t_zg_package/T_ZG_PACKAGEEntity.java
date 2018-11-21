package com.yangjiang.entity.t_zg_package;

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
 * @Description: 二铸管打包
 * @author zhangdaihao
 * @date 2016-12-14 17:48:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_zg_package", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_ZG_PACKAGEEntity implements java.io.Serializable {
	/**包号*/
	private java.lang.String packid;
	/**管数*/
	private java.lang.Integer pipecount;
	/**增加时间*/
	private java.util.Date addtime;
	/**rccode*/
	private java.lang.String rccode;
	/**计划号*/
	private java.lang.String jihuahao;
	/**入库单号*/
	private java.lang.String rukudanid;
	/**检验人*/
	private java.lang.String checkuser;
	/**打包人*/
	private java.lang.String packuser;
	/**transuser*/
	private java.lang.String transuser;
	/**备注*/
	private java.lang.String remark;
	/**维护人*/
	private java.lang.String edituser;
	/**维护时间*/
	private java.util.Date edittime;
	/**维护IP*/
	private java.lang.String editip;
	/**线别*/
	private java.lang.String xianbie;
	/**标识*/
	private java.lang.String flag;
	/**工作组*/
	private java.lang.String workgroup;
	/**是否打印*/
	private java.lang.String isprint;
	/**op*/
	private java.lang.String op;
	/**操作时间*/
	private java.util.Date optime;
	/**编号*/
	private java.lang.String id;
	/**长度变化*/
	private java.lang.String shortpipe;
	
	/**新产品编码*/
	private java.lang.String itemcode;
	/**合同描述*/
	private java.lang.String special;
	/**管序号*/
	private java.lang.String pipeserial;
	/**管号*/
	private java.lang.String pipecode;
	/**批号全称*/
	private java.lang.String batchfull;
	/**规格*/
	private java.lang.String dn;
	
	/**产品名称*/
	private java.lang.String itemname;
	public java.lang.String getItemname() {
		return itemname;
	}
	@Column(name ="itemname",nullable=false,precision=50,length=50)
	public void setItemname(java.lang.String itemname) {
		this.itemname = itemname;
	}
	
	public java.lang.String getSpecial() {
		return special;
	}
	@Column(name ="special",nullable=false,precision=80,length=80)
	public void setSpecial(java.lang.String special) {
		this.special = special;
	}
	
	
	
	
	
	
	
	public java.lang.String getPipeserial() {
		return pipeserial;
	}
	@Column(name ="pipeserial",nullable=false,precision=16,length=16)
	public void setPipeserial(java.lang.String pipeserial) {
		this.pipeserial = pipeserial;
	}
	public java.lang.String getPipecode() {
		return pipecode;
	}
	@Column(name ="pipecode",nullable=false,precision=50,length=50)
	public void setPipecode(java.lang.String pipecode) {
		this.pipecode = pipecode;
	}
	public java.lang.String getBatchfull() {
		return batchfull;
	}
	@Column(name ="batchfull",nullable=false,precision=32,length=32)
	public void setBatchfull(java.lang.String batchfull) {
		this.batchfull = batchfull;
	}
	public java.lang.String getDn() {
		return dn;
	}
	@Column(name ="dn",nullable=false,precision=32,length=32)
	public void setDn(java.lang.String dn) {
		this.dn = dn;
	}
	public java.lang.String getShortpipe() {
		return shortpipe;
	}
	@Column(name ="shortpipe",nullable=false,precision=20,length=20)
	public void setShortpipe(java.lang.String shortpipe) {
		this.shortpipe = shortpipe;
	}

	public java.lang.String getItemcode() {
		return itemcode;
	}
	@Column(name ="itemcode",nullable=false,precision=50,length=50)
	public void setItemcode(java.lang.String itemcode) {
		this.itemcode = itemcode;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  包号
	 */
	@Column(name ="PACKID",nullable=false,precision=20,length=20)
	public java.lang.String getPackid(){
		return this.packid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包号
	 */
	public void setPackid(java.lang.String packid){
		this.packid = packid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  管数
	 */
	@Column(name ="PIPECOUNT",nullable=true,precision=3,scale=0,length=1)
	public java.lang.Integer getPipecount(){
		return this.pipecount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  管数
	 */
	public void setPipecount(java.lang.Integer pipecount){
		this.pipecount = pipecount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  增加时间
	 */
	@Column(name ="ADDTIME",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getAddtime(){
		return this.addtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  增加时间
	 */
	public void setAddtime(java.util.Date addtime){
		this.addtime = addtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  rccode
	 */
	@Column(name ="RCCODE",nullable=true,precision=10,length=10)
	public java.lang.String getRccode(){
		return this.rccode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  rccode
	 */
	public void setRccode(java.lang.String rccode){
		this.rccode = rccode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计划号
	 */
	@Column(name ="JIHUAHAO",nullable=true,precision=30,length=30)
	public java.lang.String getJihuahao(){
		return this.jihuahao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计划号
	 */
	public void setJihuahao(java.lang.String jihuahao){
		this.jihuahao = jihuahao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入库单号
	 */
	@Column(name ="RUKUDANID",nullable=true,precision=30,length=30)
	public java.lang.String getRukudanid(){
		return this.rukudanid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入库单号
	 */
	public void setRukudanid(java.lang.String rukudanid){
		this.rukudanid = rukudanid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检验人
	 */
	@Column(name ="CHECKUSER",nullable=true,precision=20,length=20)
	public java.lang.String getCheckuser(){
		return this.checkuser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检验人
	 */
	public void setCheckuser(java.lang.String checkuser){
		this.checkuser = checkuser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  打包人
	 */
	@Column(name ="PACKUSER",nullable=true,precision=20,length=20)
	public java.lang.String getPackuser(){
		return this.packuser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  打包人
	 */
	public void setPackuser(java.lang.String packuser){
		this.packuser = packuser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  transuser
	 */
	@Column(name ="TRANSUSER",nullable=true,precision=20,length=20)
	public java.lang.String getTransuser(){
		return this.transuser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  transuser
	 */
	public void setTransuser(java.lang.String transuser){
		this.transuser = transuser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,precision=200,length=200)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维护人
	 */
	@Column(name ="EDITUSER",nullable=true,precision=20,length=20)
	public java.lang.String getEdituser(){
		return this.edituser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维护人
	 */
	public void setEdituser(java.lang.String edituser){
		this.edituser = edituser;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  维护时间
	 */
	@Column(name ="EDITTIME",nullable=false,precision=23,scale=3,length=8)
	public java.util.Date getEdittime(){
		return this.edittime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  维护时间
	 */
	public void setEdittime(java.util.Date edittime){
		this.edittime = edittime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维护IP
	 */
	@Column(name ="EDITIP",nullable=true,precision=20,length=20)
	public java.lang.String getEditip(){
		return this.editip;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维护IP
	 */
	public void setEditip(java.lang.String editip){
		this.editip = editip;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  线别
	 */
	@Column(name ="XIANBIE",nullable=true,precision=3,scale=0,length=1)
	public java.lang.String getXianbie(){
		return this.xianbie;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  线别
	 */
	public void setXianbie(java.lang.String xianbie){
		this.xianbie = xianbie;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  标识
	 */
	@Column(name ="FLAG",nullable=true,precision=5,scale=0,length=2)
	public java.lang.String getFlag(){
		return this.flag;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  标识
	 */
	public void setFlag(java.lang.String flag){
		this.flag = flag;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  工作组
	 */
	@Column(name ="WORKGROUP",nullable=true,precision=5,scale=0,length=2)
	public java.lang.String getWorkgroup(){
		return this.workgroup;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  工作组
	 */
	public void setWorkgroup(java.lang.String workgroup){
		this.workgroup = workgroup;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否打印
	 */
	@Column(name ="ISPRINT",nullable=true,precision=20,length=20)
	public java.lang.String getIsprint(){
		return this.isprint;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否打印
	 */
	public void setIsprint(java.lang.String isprint){
		this.isprint = isprint;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  op
	 */
	@Column(name ="OP",nullable=true,precision=1,length=1)
	public java.lang.String getOp(){
		return this.op;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  op
	 */
	public void setOp(java.lang.String op){
		this.op = op;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  操作时间
	 */
	@Column(name ="OPTIME",nullable=true,precision=8,length=8)
	public java.util.Date getOptime(){
		return this.optime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  操作时间
	 */
	public void setOptime(java.util.Date optime){
		this.optime = optime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,precision=36,length=72)
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
