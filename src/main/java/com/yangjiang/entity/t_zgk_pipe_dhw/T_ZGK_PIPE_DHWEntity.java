package com.yangjiang.entity.t_zgk_pipe_dhw;

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
 * @Description: 到货位
 * @author zhangdaihao
 * @date 2016-12-01 10:13:30
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_ZGK_PIPE_DHW", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_ZGK_PIPE_DHWEntity implements java.io.Serializable {
	/**日期*/
	private java.util.Date riqi;
	/**倒库单编号*/
	private java.lang.String daohuoweiid;
	/**管号*/
	private java.lang.String pipeCode;
	/**仓库名称*/
	private java.lang.String storeName;
	/**目标货位*/
	private java.lang.String afterHuowei;
	/**原层号*/
	private java.lang.Integer beforeCengci;
	/**原层内序号*/
	private java.lang.Integer beforeCengneixuhao;
	/**编辑人*/
	private java.lang.String edituser;
	/**编辑IP地址*/
	private java.lang.String editip;
	/**编辑时间*/
	private java.util.Date edittime;
	/**编号*/
	private java.lang.String id;
	/**原货位*/
	private java.lang.String beforeHuowei;
	/**目标层号*/
	private java.lang.Integer afterCengci;
	/**目标层内序号*/
	private java.lang.Integer afterCengneixuhao;
	
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
	 *@return: java.lang.String  倒库单编号
	 */
	@Column(name ="DAOHUOWEIID",nullable=false,precision=20,length=20)
	public java.lang.String getDaohuoweiid(){
		return this.daohuoweiid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  倒库单编号
	 */
	public void setDaohuoweiid(java.lang.String daohuoweiid){
		this.daohuoweiid = daohuoweiid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管号
	 */
	@Column(name ="PIPE_CODE",nullable=false,precision=50,length=50)
	public java.lang.String getPipeCode(){
		return this.pipeCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管号
	 */
	public void setPipeCode(java.lang.String pipeCode){
		this.pipeCode = pipeCode;
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
	 *@return: java.lang.String  目标货位
	 */
	@Column(name ="AFTER_HUOWEI",nullable=true,precision=10,length=10)
	public java.lang.String getAfterHuowei(){
		return this.afterHuowei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  目标货位
	 */
	public void setAfterHuowei(java.lang.String afterHuowei){
		this.afterHuowei = afterHuowei;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  原层号
	 */
	@Column(name ="BEFORE_CENGCI",nullable=true,precision=5,scale=0,length=2)
	public java.lang.Integer getBeforeCengci(){
		return this.beforeCengci;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  原层号
	 */
	public void setBeforeCengci(java.lang.Integer beforeCengci){
		this.beforeCengci = beforeCengci;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  原层内序号
	 */
	@Column(name ="BEFORE_CENGNEIXUHAO",nullable=true,precision=5,scale=0,length=2)
	public java.lang.Integer getBeforeCengneixuhao(){
		return this.beforeCengneixuhao;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  原层内序号
	 */
	public void setBeforeCengneixuhao(java.lang.Integer beforeCengneixuhao){
		this.beforeCengneixuhao = beforeCengneixuhao;
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
	@Column(name ="EDITIP",nullable=true,precision=20,length=20)
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
	@Column(name ="EDITTIME",nullable=false,precision=23,scale=3,length=8)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
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
	 *@param: java.lang.String  编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原货位
	 */
	@Column(name ="BEFORE_HUOWEI",nullable=true,precision=10,length=10)
	public java.lang.String getBeforeHuowei(){
		return this.beforeHuowei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原货位
	 */
	public void setBeforeHuowei(java.lang.String beforeHuowei){
		this.beforeHuowei = beforeHuowei;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  目标层号
	 */
	@Column(name ="AFTER_CENGCI",nullable=true,precision=5,scale=0,length=2)
	public java.lang.Integer getAfterCengci(){
		return this.afterCengci;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  目标层号
	 */
	public void setAfterCengci(java.lang.Integer afterCengci){
		this.afterCengci = afterCengci;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  目标层内序号
	 */
	@Column(name ="AFTER_CENGNEIXUHAO",nullable=true,precision=5,scale=0,length=2)
	public java.lang.Integer getAfterCengneixuhao(){
		return this.afterCengneixuhao;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  目标层内序号
	 */
	public void setAfterCengneixuhao(java.lang.Integer afterCengneixuhao){
		this.afterCengneixuhao = afterCengneixuhao;
	}
}
