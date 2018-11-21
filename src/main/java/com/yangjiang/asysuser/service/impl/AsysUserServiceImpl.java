package com.yangjiang.asysuser.service.impl;
import com.yangjiang.asysuser.service.AsysUserServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.yangjiang.asysuser.entity.AsysUserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("asysUserService")
@Transactional
public class AsysUserServiceImpl extends CommonServiceImpl implements AsysUserServiceI {

	
 	public void delete(AsysUserEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(AsysUserEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(AsysUserEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(AsysUserEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(AsysUserEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(AsysUserEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(AsysUserEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("user_id", t.getUserId());
		map.put("loginname", t.getLoginname());
		map.put("loginpwd", t.getLoginpwd());
		map.put("fullname", t.getFullname());
		map.put("email", t.getEmail());
		map.put("phone", t.getPhone());
		map.put("enabled", t.getEnabled());
		map.put("pwderrorcount", t.getPwderrorcount());
		map.put("logincount", t.getLogincount());
		map.put("registertime", t.getRegistertime());
		map.put("lastlogintime", t.getLastlogintime());
		map.put("identitycode", t.getIdentitycode());
		map.put("createid", t.getCreateid());
		map.put("createby", t.getCreateby());
		map.put("createtime", t.getCreatetime());
		map.put("modifyid", t.getModifyid());
		map.put("modifyby", t.getModifyby());
		map.put("modifytime", t.getModifytime());
		map.put("isdeleted", t.getIsdeleted());
		map.put("displayname", t.getDisplayname());
		map.put("danwei", t.getDanwei());
		map.put("bumen", t.getBumen());
		map.put("danweiid", t.getDanweiid());
		map.put("bumenid", t.getBumenid());
		return map;
	}
 	
 	/**
	 * 
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 *
	 */
 	public String replaceVal(String sql,AsysUserEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{loginname}",String.valueOf(t.getLoginname()));
 		sql  = sql.replace("#{loginpwd}",String.valueOf(t.getLoginpwd()));
 		sql  = sql.replace("#{fullname}",String.valueOf(t.getFullname()));
 		sql  = sql.replace("#{email}",String.valueOf(t.getEmail()));
 		sql  = sql.replace("#{phone}",String.valueOf(t.getPhone()));
 		sql  = sql.replace("#{enabled}",String.valueOf(t.getEnabled()));
 		sql  = sql.replace("#{pwderrorcount}",String.valueOf(t.getPwderrorcount()));
 		sql  = sql.replace("#{logincount}",String.valueOf(t.getLogincount()));
 		sql  = sql.replace("#{registertime}",String.valueOf(t.getRegistertime()));
 		sql  = sql.replace("#{lastlogintime}",String.valueOf(t.getLastlogintime()));
 		sql  = sql.replace("#{identitycode}",String.valueOf(t.getIdentitycode()));
 		sql  = sql.replace("#{createid}",String.valueOf(t.getCreateid()));
 		sql  = sql.replace("#{createby}",String.valueOf(t.getCreateby()));
 		sql  = sql.replace("#{createtime}",String.valueOf(t.getCreatetime()));
 		sql  = sql.replace("#{modifyid}",String.valueOf(t.getModifyid()));
 		sql  = sql.replace("#{modifyby}",String.valueOf(t.getModifyby()));
 		sql  = sql.replace("#{modifytime}",String.valueOf(t.getModifytime()));
 		sql  = sql.replace("#{isdeleted}",String.valueOf(t.getIsdeleted()));
 		sql  = sql.replace("#{displayname}",String.valueOf(t.getDisplayname()));
 		sql  = sql.replace("#{danwei}",String.valueOf(t.getDanwei()));
 		sql  = sql.replace("#{bumen}",String.valueOf(t.getBumen()));
 		sql  = sql.replace("#{danweiid}",String.valueOf(t.getDanweiid()));
 		sql  = sql.replace("#{bumenid}",String.valueOf(t.getBumenid()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute(data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}