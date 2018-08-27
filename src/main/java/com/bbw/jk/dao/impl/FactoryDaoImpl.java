package com.bbw.jk.dao.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bbw.jk.dao.FactoryDao;
import com.bbw.jk.domain.Factory;



/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-3-12
 */
@Repository
public class FactoryDaoImpl extends BaseDaoImpl<Factory> implements FactoryDao{
	public FactoryDaoImpl() {
		this.setNs("cn.itcast.jk.mapper.FactoryMapper.");			//设置命名空间
	}
	
	public void changeState(Map<String, Object> map) {
		this.getSqlSession().update(this.getNs() + "changeState", map);
	}

	/* (non-Javadoc)
	 * @see com.bbw.jk.dao.BaseDao#deletes(java.io.Serializable[])
	 */
	@Override
	public void deletes(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}
}
