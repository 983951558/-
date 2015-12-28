package com.vanroid.gduf.service.jwc;



import java.util.List;

import com.vanroid.gduf.jwc.models.Model;



/**
 *处理HTML抽象类
 * @author CGZ
 *
 */
public abstract class HandlerHTML {
	//返回Model的列表
	abstract public List<? extends Model> execute(String code);
	abstract public String getContent(String code);
}
