package com.bbw.jk.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 泛型类，基础的DAO接口 crud操作
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-2-25
 */
public interface BaseDao<T> {
	public List<T> find(T entity);//全部
	public T get(Serializable id);//单条
	public void insert(T entity);//插入
	public void update(T entity);//更新
	public void delete(Serializable id);//单条删除
	public void deletes(Serializable[] ids);//多条删除
}
