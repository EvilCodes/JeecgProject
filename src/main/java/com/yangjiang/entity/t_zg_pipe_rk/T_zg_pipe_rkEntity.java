package com.yangjiang.entity.t_zg_pipe_rk;

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
 * @Description: 铸管部入库
 * @author zhangdaihao
 * @date 2016-10-13 17:27:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_zg_pipe_rk", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_zg_pipe_rkEntity implements java.io.Serializable {
	/** 编号*/
	private java.lang.String id;
	/**rukudanid*/
	private java.lang.String rukudanid;
	/**仓库名称*/
	private java.lang.String storeName;
	/**车号*/
	private java.lang.String che;
	/**数量*/
	private java.lang.Integer count;
	/**运输人*/
	private java.lang.String yunshuren;
	/**检验员*/
	private java.lang.String jianyanyuan;
	/**保管员*/
	private java.lang.String baoguanyuan;
	/**日期*/
	private java.util.Date riqi;
	/**状态*/
	private java.lang.String state;
	/**打印时间*/
	private java.util.Date printtime;
	/**编辑人*/
	private java.lang.String edituser;
	/**编辑IP地址*/
	private java.lang.String editip;
	/**编辑时间*/
	private java.util.Date edittime;
	/**方式*/
	private java.lang.Integer port;
	/**备注*/
	private java.lang.String remark;
	/**规格简述*/
	private java.lang.String dnstr;
	/**合同简述*/
	private java.lang.String aggrement;
	/**生产部门*/
	private java.lang.String dept;
	/**instoreCode*/
	private java.lang.String instoreCode;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String   编号
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
	 *@param: java.lang.String   编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  rukudanid
	 */
	@Column(name ="RUKUDANID",nullable=false,precision=20,length=20)
	public java.lang.String getRukudanid(){
		return this.rukudanid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  rukudanid
	 */
	public void setRukudanid(java.lang.String rukudanid){
		this.rukudanid = rukudanid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库名称
	 */
	@Column(name ="STORE_NAME",nullable=true,precision=20,length=20)
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
	 *@return: java.lang.String  车号
	 */
	@Column(name ="CHE",nullable=true,precision=10,length=10)
	public java.lang.String getChe(){
		return this.che;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车号
	 */
	public void setChe(java.lang.String che){
		this.che = che;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  数量
	 */
	@Column(name ="COUNT",nullable=true,precision=5,scale=0,length=2)
	public java.lang.Integer getCount(){
		return this.count;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  数量
	 */
	public void setCount(java.lang.Integer count){
		this.count = count;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输人
	 */
	@Column(name ="YUNSHUREN",nullable=true,precision=10,length=10)
	public java.lang.String getYunshuren(){
		return this.yunshuren;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输人
	 */
	public void setYunshuren(java.lang.String yunshuren){
		this.yunshuren = yunshuren;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检验员
	 */
	@Column(name ="JIANYANYUAN",nullable=true,precision=10,length=10)
	public java.lang.String getJianyanyuan(){
		return this.jianyanyuan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检验员
	 */
	public void setJianyanyuan(java.lang.String jianyanyuan){
		this.jianyanyuan = jianyanyuan;
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
	 *@return: java.lang.String  状态
	 */
	@Column(name ="STATE",nullable=true,precision=1,length=1)
	public java.lang.String getState(){
		return this.state;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setState(java.lang.String state){
		this.state = state;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  打印时间
	 */
	@Column(name ="PRINTTIME",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getPrinttime(){
		return this.printtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  打印时间
	 */
	public void setPrinttime(java.util.Date printtime){
		this.printtime = printtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编辑人
	 */
	@Column(name ="EDITUSER",nullable=true,precision=10,length=10)
	public java.lang.String getEdituser(){
		return this.edituser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编辑人
	 */
	public void setEdituser(java.lang.String edituser){
		this.edituser = edituser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编辑IP地址
	 */
	@Column(name ="EDITIP",nullable=true,precision=50,length=50)
	public java.lang.String getEditip(){
		return this.editip;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编辑IP地址
	 */
	public void setEditip(java.lang.String editip){
		this.editip = editip;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  编辑时间
	 */
	@Column(name ="EDITTIME",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getEdittime(){
		return this.edittime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  编辑时间
	 */
	public void setEdittime(java.util.Date edittime){
		this.edittime = edittime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  方式
	 */
	@Column(name ="PORT",nullable=true,precision=5,scale=0,length=2)
	public java.lang.Integer getPort(){
		return this.port;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  方式
	 */
	public void setPort(java.lang.Integer port){
		this.port = port;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,precision=500,length=500)
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
	 *@return: java.lang.String  规格简述
	 */
	@Column(name ="DNSTR",nullable=true,precision=20,length=20)
	public java.lang.String getDnstr(){
		return this.dnstr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格简述
	 */
	public void setDnstr(java.lang.String dnstr){
		this.dnstr = dnstr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同简述
	 */
	@Column(name ="AGGREMENT",nullable=true,precision=30,length=30)
	public java.lang.String getAggrement(){
		return this.aggrement;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同简述
	 */
	public void setAggrement(java.lang.String aggrement){
		this.aggrement = aggrement;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产部门
	 */
	@Column(name ="DEPT",nullable=true,precision=20,length=20)
	public java.lang.String getDept(){
		return this.dept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产部门
	 */
	public void setDept(java.lang.String dept){
		this.dept = dept;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  instoreCode
	 */
	@Column(name ="INSTORE_CODE",nullable=false,precision=32,length=32)
	public java.lang.String getInstoreCode(){
		return this.instoreCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  instoreCode
	 */
	public void setInstoreCode(java.lang.String instoreCode){
		this.instoreCode = instoreCode;
	}
}
