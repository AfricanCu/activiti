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
		Deployment deploy = processEngine.getRepositoryService()	//��ȡ�����̶���Ͳ�����ص�service
										.createDeployment()			//����һ���������
										.name("hello_world")
										.addClasspathResource("diagrams/helloworld.bpmn")	//��classpath����Դ�м��أ�һ��ֻ�ܼ���һ���ļ�
										.addClasspathResource("diagrams/helloworld.png")
										.deploy();	//��ɲ���
		System.out.println(deploy.getId());
		System.out.println(deploy.getName());

	}
	
	@Test
	public void startProcessInstance() {
		ProcessInstance pi = processEngine.getRuntimeService()
					.startProcessInstanceByKey("helloworld");		//ʹ�����̶����key��������ʵ��
		
		System.out.println(pi.getId());
		System.out.println(pi.getProcessDefinitionId());
		
	}

}
