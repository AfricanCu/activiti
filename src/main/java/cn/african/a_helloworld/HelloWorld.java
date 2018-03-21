package cn.african.a_helloworld;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

public class HelloWorld {
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void deploymentProcessDefinition() {
		Deployment deploy = processEngine.getRepositoryService()	//获取与流程定义和部署相关的service
										.createDeployment()			//创建一个部署对象
										.name("hello_world")
										.addClasspathResource("diagrams/helloworld.bpmn")	//从classpath的资源中加载，一次只能加载一个文件
										.addClasspathResource("diagrams/helloworld.png")
										.deploy();	//完成部署
		System.out.println(deploy.getId());
		System.out.println(deploy.getName());

	}
	
	@Test
	public void startProcessInstance() {
		ProcessInstance pi = processEngine.getRuntimeService()
					.startProcessInstanceByKey("helloworld");		//使用流程定义的key启动流程实例
		
		System.out.println(pi.getId());
		System.out.println(pi.getProcessDefinitionId());
		
	}

}
