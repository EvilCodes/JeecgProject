package com.yangjiang.entity.t_zg_analy_gp;

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
 * @Description: 光谱数据表
 * @author zhangdaihao
 * @date 2017-03-22 15:20:55
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_zg_analy_GP", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_zg_analy_GPEntity implements java.io.Serializable {
	/**分析时间*/
	private java.util.Date analydate;
	/**样子编号*/
	private java.lang.String sampleno;
	/**样子名称*/
	private java.lang.String samplename;
	/**判定结果*/
	private java.lang.String result;
	/**C*/
	private BigDecimal c;
	/**Si*/
	private BigDecimal si;
	/**Mn*/
	private BigDecimal mn;
	/**S*/
	private BigDecimal s;
	/**P*/
	private BigDecimal p;
	/**Mg*/
	private BigDecimal mg;
	/**Ni*/
	private BigDecimal ni;
	/**Cr*/
	private BigDecimal cr;
	/**Mo*/
	private BigDecimal mo;
	/**V*/
	private BigDecimal v;
	/**Ti*/
	private BigDecimal ti;
	/**Al*/
	private BigDecimal al;
	/**Pb*/
	private BigDecimal pb;
	/**Ce*/
	private BigDecimal ce;
	/**Cu*/
	private BigDecimal cu;
	/**Ceq*/
	private BigDecimal ceq;
	/**录入时间*/
	private java.util.Date inputdate;
	/**B*/
	private BigDecimal b;
	/**Sb*/
	private BigDecimal sb;
	/**As1*/
	private BigDecimal as1;
	/**Sn*/
	private BigDecimal sn;
	/**录入人*/
	private java.lang.String inputer;
	/**录入部门*/
	private java.lang.String department;
	/**编号*/
	private java.lang.String id;
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  分析时间
	 */
	@Column(name ="ANALYDATE",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getAnalydate(){
		return this.analydate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  分析时间
	 */
	public void setAnalydate(java.util.Date analydate){
		this.analydate = analydate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  样子编号
	 */
	@Column(name ="SAMPLENO",nullable=true,precision=50,length=50)
	public java.lang.String getSampleno(){
		return this.sampleno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  样子编号
	 */
	public void setSampleno(java.lang.String sampleno){
		this.sampleno = sampleno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  样子名称
	 */
	@Column(name ="SAMPLENAME",nullable=true,precision=50,length=100)
	public java.lang.String getSamplename(){
		return this.samplename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  样子名称
	 */
	public void setSamplename(java.lang.String samplename){
		this.samplename = samplename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  判定结果
	 */
	@Column(name ="RESULT",nullable=true,precision=10,length=20)
	public java.lang.String getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  判定结果
	 */
	public void setResult(java.lang.String result){
		this.result = result;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  C
	 */
	@Column(name ="C",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getC(){
		return this.c;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  C
	 */
	public void setC(BigDecimal c){
		this.c = c;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  Si
	 */
	@Column(name ="SI",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getSi(){
		return this.si;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  Si
	 */
	public void setSi(BigDecimal si){
		this.si = si;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  Mn
	 */
	@Column(name ="MN",nullable=false,precision=18,scale=8,length=9)
	public BigDecimal getMn(){
		return this.mn;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  Mn
	 */
	public void setMn(BigDecimal mn){
		this.mn = mn;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  S
	 */
	@Column(name ="S",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getS(){
		return this.s;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  S
	 */
	public void setS(BigDecimal s){
		this.s = s;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  P
	 */
	@Column(name ="P",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getP(){
		return this.p;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  P
	 */
	public void setP(BigDecimal p){
		this.p = p;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  Mg
	 */
	@Column(name ="MG",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getMg(){
		return this.mg;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  Mg
	 */
	public void setMg(BigDecimal mg){
		this.mg = mg;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  Ni
	 */
	@Column(name ="NI",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getNi(){
		return this.ni;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  Ni
	 */
	public void setNi(BigDecimal ni){
		this.ni = ni;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  Cr
	 */
	@Column(name ="CR",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getCr(){
		return this.cr;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  Cr
	 */
	public void setCr(BigDecimal cr){
		this.cr = cr;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  Mo
	 */
	@Column(name ="MO",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getMo(){
		return this.mo;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  Mo
	 */
	public void setMo(BigDecimal mo){
		this.mo = mo;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  V
	 */
	@Column(name ="V",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getV(){
		return this.v;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  V
	 */
	public void setV(BigDecimal v){
		this.v = v;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  Ti
	 */
	@Column(name ="TI",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getTi(){
		return this.ti;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  Ti
	 */
	public void setTi(BigDecimal ti){
		this.ti = ti;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  Al
	 */
	@Column(name ="AL",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getAl(){
		return this.al;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  Al
	 */
	public void setAl(BigDecimal al){
		this.al = al;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  Pb
	 */
	@Column(name ="PB",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getPb(){
		return this.pb;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  Pb
	 */
	public void setPb(BigDecimal pb){
		this.pb = pb;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  Ce
	 */
	@Column(name ="CE",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getCe(){
		return this.ce;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  Ce
	 */
	public void setCe(BigDecimal ce){
		this.ce = ce;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  Cu
	 */
	@Column(name ="CU",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getCu(){
		return this.cu;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  Cu
	 */
	public void setCu(BigDecimal cu){
		this.cu = cu;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  Ceq
	 */
	@Column(name ="CEQ",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getCeq(){
		return this.ceq;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  Ceq
	 */
	public void setCeq(BigDecimal ceq){
		this.ceq = ceq;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  录入时间
	 */
	@Column(name ="INPUTDATE",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getInputdate(){
		return this.inputdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  录入时间
	 */
	public void setInputdate(java.util.Date inputdate){
		this.inputdate = inputdate;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  B
	 */
	@Column(name ="B",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getB(){
		return this.b;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  B
	 */
	public void setB(BigDecimal b){
		this.b = b;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  Sb
	 */
	@Column(name ="SB",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getSb(){
		return this.sb;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  Sb
	 */
	public void setSb(BigDecimal sb){
		this.sb = sb;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  As1
	 */
	@Column(name ="AS1",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getAs1(){
		return this.as1;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  As1
	 */
	public void setAs1(BigDecimal as1){
		this.as1 = as1;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  Sn
	 */
	@Column(name ="SN",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getSn(){
		return this.sn;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  Sn
	 */
	public void setSn(BigDecimal sn){
		this.sn = sn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  录入人
	 */
	@Column(name ="INPUTER",nullable=true,precision=50,length=50)
	public java.lang.String getInputer(){
		return this.inputer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  录入人
	 */
	public void setInputer(java.lang.String inputer){
		this.inputer = inputer;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  录入部门
	 */
	@Column(name ="DEPARTMENT",nullable=true,precision=50,length=50)
	public java.lang.String getDepartment(){
		return this.department;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  录入部门
	 */
	public void setDepartment(java.lang.String department){
		this.department = department;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,precision=50,length=50)
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
