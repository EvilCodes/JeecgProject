package com.yangjiang.asysuser.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 大系统用户信息
 * @author onlineGenerator
 * @date 2016-10-24 22:43:55
 * @version V1.0   
 *
 */
@Entity
@Table(name = "a10_user", schema = "")
@SuppressWarnings("serial")
public class AsysUserEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**userId*/
	@Excel(name="userId")
	private java.lang.String userId;
	/**loginname*/
	@Excel(name="loginname")
	private java.lang.String loginname;
	/**loginpwd*/
	@Excel(name="loginpwd")
	private java.lang.String loginpwd;
	/**fullname*/
	@Excel(name="fullname")
	private java.lang.String fullname;
	/**email*/
	@Excel(name="email")
	private java.lang.String email;
	/**phone*/
	@Excel(name="phone")
	private java.lang.String phone;
	/**enabled*/
	@Excel(name="enabled")
	private java.lang.String enabled;
	/**pwderrorcount*/
	@Excel(name="pwderrorcount")
	private java.lang.Integer pwderrorcount;
	/**logincount*/
	@Excel(name="logincount")
	private java.lang.Integer logincount;
	/**registertime*/
	@Excel(name="registertime",format = "yyyy-MM-dd")
	private java.util.Date registertime;
	/**lastlogintime*/
	@Excel(name="lastlogintime",format = "yyyy-MM-dd")
	private java.util.Date lastlogintime;
	/**identitycode*/
	@Excel(name="identitycode")
	private java.lang.String identitycode;
	/**createid*/
	@Excel(name="createid")
	private java.lang.Integer createid;
	/**createby*/
	@Excel(name="createby")
	private java.lang.String createby;
	/**createtime*/
	@Excel(name="createtime",format = "yyyy-MM-dd")
	private java.util.Date createtime;
	/**modifyid*/
	@Excel(name="modifyid")
	private java.lang.Integer modifyid;
	/**modifyby*/
	@Excel(name="modifyby")
	private java.lang.String modifyby;
	/**modifytime*/
	@Excel(name="modifytime",format = "yyyy-MM-dd")
	private java.util.Date modifytime;
	/**isdeleted*/
	@Excel(name="isdeleted")
	private java.lang.String isdeleted;
	/**displayname*/
	@Excel(name="displayname")
	private java.lang.String displayname;
	/**danwei*/
	@Excel(name="danwei")
	private java.lang.String danwei;
	/**bumen*/
	@Excel(name="bumen")
	private java.lang.String bumen;
	/**danweiid*/
	@Excel(name="danweiid")
	private java.lang.Integer danweiid;
	/**bumenid*/
	@Excel(name="bumenid")
	private java.lang.Integer bumenid;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID",nullable=false,length=4)
	public java.lang.Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  id
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  userId
	 */
	@Column(name ="USER_ID",nullable=false,length=20)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  userId
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  loginname
	 */
	@Column(name ="LOGINNAME",nullable=true,length=100)
	public java.lang.String getLoginname(){
		return this.loginname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  loginname
	 */
	public void setLoginname(java.lang.String loginname){
		this.loginname = loginname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  loginpwd
	 */
	@Column(name ="LOGINPWD",nullable=true,length=100)
	public java.lang.String getLoginpwd(){
		return this.loginpwd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  loginpwd
	 */
	public void setLoginpwd(java.lang.String loginpwd){
		this.loginpwd = loginpwd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fullname
	 */
	@Column(name ="FULLNAME",nullable=true,length=100)
	public java.lang.String getFullname(){
		return this.fullname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fullname
	 */
	public void setFullname(java.lang.String fullname){
		this.fullname = fullname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  email
	 */
	@Column(name ="EMAIL",nullable=true,length=200)
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  email
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  phone
	 */
	@Column(name ="PHONE",nullable=true,length=40)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  phone
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  enabled
	 */
	@Column(name ="ENABLED",nullable=false,length=1)
	public java.lang.String getEnabled(){
		return this.enabled;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  enabled
	 */
	public void setEnabled(java.lang.String enabled){
		this.enabled = enabled;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  pwderrorcount
	 */
	@Column(name ="PWDERRORCOUNT",nullable=false,length=4)
	public java.lang.Integer getPwderrorcount(){
		return this.pwderrorcount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  pwderrorcount
	 */
	public void setPwderrorcount(java.lang.Integer pwderrorcount){
		this.pwderrorcount = pwderrorcount;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  logincount
	 */
	@Column(name ="LOGINCOUNT",nullable=false,length=4)
	public java.lang.Integer getLogincount(){
		return this.logincount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  logincount
	 */
	public void setLogincount(java.lang.Integer logincount){
		this.logincount = logincount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  registertime
	 */
	@Column(name ="REGISTERTIME",nullable=true,length=8)
	public java.util.Date getRegistertime(){
		return this.registertime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  registertime
	 */
	public void setRegistertime(java.util.Date registertime){
		this.registertime = registertime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  lastlogintime
	 */
	@Column(name ="LASTLOGINTIME",nullable=true,length=8)
	public java.util.Date getLastlogintime(){
		return this.lastlogintime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  lastlogintime
	 */
	public void setLastlogintime(java.util.Date lastlogintime){
		this.lastlogintime = lastlogintime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  identitycode
	 */
	@Column(name ="IDENTITYCODE",nullable=true,length=32)
	public java.lang.String getIdentitycode(){
		return this.identitycode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  identitycode
	 */
	public void setIdentitycode(java.lang.String identitycode){
		this.identitycode = identitycode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  createid
	 */
	@Column(name ="CREATEID",nullable=true,length=4)
	public java.lang.Integer getCreateid(){
		return this.createid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  createid
	 */
	public void setCreateid(java.lang.Integer createid){
		this.createid = createid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  createby
	 */
	@Column(name ="CREATEBY",nullable=true,length=100)
	public java.lang.String getCreateby(){
		return this.createby;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  createby
	 */
	public void setCreateby(java.lang.String createby){
		this.createby = createby;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createtime
	 */
	@Column(name ="CREATETIME",nullable=true,length=8)
	public java.util.Date getCreatetime(){
		return this.createtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  createtime
	 */
	public void setCreatetime(java.util.Date createtime){
		this.createtime = createtime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  modifyid
	 */
	@Column(name ="MODIFYID",nullable=true,length=4)
	public java.lang.Integer getModifyid(){
		return this.modifyid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  modifyid
	 */
	public void setModifyid(java.lang.Integer modifyid){
		this.modifyid = modifyid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  modifyby
	 */
	@Column(name ="MODIFYBY",nullable=true,length=100)
	public java.lang.String getModifyby(){
		return this.modifyby;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  modifyby
	 */
	public void setModifyby(java.lang.String modifyby){
		this.modifyby = modifyby;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  modifytime
	 */
	@Column(name ="MODIFYTIME",nullable=true,length=8)
	public java.util.Date getModifytime(){
		return this.modifytime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  modifytime
	 */
	public void setModifytime(java.util.Date modifytime){
		this.modifytime = modifytime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  isdeleted
	 */
	@Column(name ="ISDELETED",nullable=true,length=1)
	public java.lang.String getIsdeleted(){
		return this.isdeleted;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  isdeleted
	 */
	public void setIsdeleted(java.lang.String isdeleted){
		this.isdeleted = isdeleted;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  displayname
	 */
	@Column(name ="DISPLAYNAME",nullable=true,length=100)
	public java.lang.String getDisplayname(){
		return this.displayname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  displayname
	 */
	public void setDisplayname(java.lang.String displayname){
		this.displayname = displayname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  danwei
	 */
	@Column(name ="DANWEI",nullable=true,length=100)
	public java.lang.String getDanwei(){
		return this.danwei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  danwei
	 */
	public void setDanwei(java.lang.String danwei){
		this.danwei = danwei;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  bumen
	 */
	@Column(name ="BUMEN",nullable=true,length=100)
	public java.lang.String getBumen(){
		return this.bumen;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  bumen
	 */
	public void setBumen(java.lang.String bumen){
		this.bumen = bumen;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  danweiid
	 */
	@Column(name ="DANWEIID",nullable=true,length=4)
	public java.lang.Integer getDanweiid(){
		return this.danweiid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  danweiid
	 */
	public void setDanweiid(java.lang.Integer danweiid){
		this.danweiid = danweiid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  bumenid
	 */
	@Column(name ="BUMENID",nullable=true,length=4)
	public java.lang.Integer getBumenid(){
		return this.bumenid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  bumenid
	 */
	public void setBumenid(java.lang.Integer bumenid){
		this.bumenid = bumenid;
	}
}
