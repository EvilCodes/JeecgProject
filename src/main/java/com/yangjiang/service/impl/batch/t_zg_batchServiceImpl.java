package com.yangjiang.service.impl.batch;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yangjiang.service.batch.t_zg_batchServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("t_zg_batchService")
@Transactional
public class t_zg_batchServiceImpl extends CommonServiceImpl implements t_zg_batchServiceI {
	
}