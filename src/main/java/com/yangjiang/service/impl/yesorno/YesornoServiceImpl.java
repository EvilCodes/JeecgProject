package com.yangjiang.service.impl.yesorno;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yangjiang.service.yesorno.YesornoServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("yesornoService")
@Transactional
public class YesornoServiceImpl extends CommonServiceImpl implements YesornoServiceI {
	
}