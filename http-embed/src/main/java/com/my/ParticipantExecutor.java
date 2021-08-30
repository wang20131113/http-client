package com.my;

import java.util.concurrent.ExecutionException;
/**
 * 分布式事务执行器
 * @author davy wang
 * @since 2021-08-23
 */


/**
 * 本项目主要解决努力尝试型分布式业务。业务的特点是，
 * 服务无先后顺序，
 * 微服务努力尝试失败后，业务数据仍然保持一致性。
 * 
 * 
 * 需要执行的微服务类，具有回滚方法（采用接口约束方式）
 * 执行的方式，由分布式框架提供。本项目提供抽象的执行方式类
 * 
 * 限制：
 * 暂时先实现缓存保持微服务失败后重复执行方式。 由业务系统与缓存系统共同维护重试业务，可靠性已经非常高了。
 * 
 * @author 
 */
public class ParticipantExecutor {
	/**
	 * processor
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static boolean execute(ParticipantServiceProxy participantServiceProxy) throws InterruptedException, ExecutionException{
		//TODO
		participantServiceProxy.striveDo(null);
		return true;
	}

	
}
