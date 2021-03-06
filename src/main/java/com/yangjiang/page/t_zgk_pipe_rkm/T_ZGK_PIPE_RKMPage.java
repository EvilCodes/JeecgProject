package com.yangjiang.page.t_zgk_pipe_rkm;

import java.util.ArrayList;
import java.util.List;

import com.yangjiang.entity.t_zgk_pipe_rkd.T_ZGK_PIPE_RKDEntity;



/**   
 * @Title: Entity
 * @Description: 铸管库入库单
 * @author zhangdaihao
 * @date 2018-09-15 09:28:30
 * @version V1.0   
 *
 */
@SuppressWarnings("serial")
public class T_ZGK_PIPE_RKMPage implements java.io.Serializable {
	/**保存-铸管库入库单明细*/
	private List<T_ZGK_PIPE_RKDEntity> t_ZGK_PIPE_RKDList = new ArrayList<T_ZGK_PIPE_RKDEntity>();
	public List<T_ZGK_PIPE_RKDEntity> getT_ZGK_PIPE_RKDList() {
		return t_ZGK_PIPE_RKDList;
	}
	public void setT_ZGK_PIPE_RKDList(List<T_ZGK_PIPE_RKDEntity> t_ZGK_PIPE_RKDList) {
		this.t_ZGK_PIPE_RKDList = t_ZGK_PIPE_RKDList;
	}


	/**主键*/
	private java.lang.String id;
	/**入库单编号*/
	private java.lang.String rukudanid;
	/**日期*/
	private java.util.Date riqi;
	/**管库名称*/
	private java.lang.String storeName;
	/**保管员*/
	private java.lang.String baoguanyuan;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入库单编号
	 */
	public java.lang.String getRukudanid(){
		return this.rukudanid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入库单编号
	 */
	public void setRukudanid(java.lang.String rukudanid){
		this.rukudanid = rukudanid;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  日期
	 */
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
	 *@return: java.lang.String  管库名称
	 */
	public java.lang.String getStoreName(){
		return this.storeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管库名称
	 */
	public void setStoreName(java.lang.String storeName){
		this.storeName = storeName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  保管员
	 */
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
}
