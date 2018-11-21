package com.yangjiang.asysuser.service;
import com.yangjiang.asysuser.entity.AsysUserEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AsysUserServiceI extends CommonService{
	
 	public void delete(AsysUserEntity entity) throws Exception;
 	
 	public Serializable save(AsysUserEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AsysUserEntity entity) throws Exception;
 	
}
