在java项目中，对于微服务的处理方式采用尽力执行方式，另一方面，尽力执行仍然无法成功的时候，回退操作处理。同时，可以自行定制服务执行间隔和次数。

# 使用方式

微服务处理类实现ParticipantService接口，实现正向执行方法以及回退方法。

```
public class ParticipantServiceImpl implements ParticipantService 
```

代理服务类继承ParticipantServiceProxy类，确定服务类的类型。

```
public class ParticipantServiceProxyImpl extends ParticipantServiceProxy<ParticipantService> 
```

执行方式

```
this.participantServiceProxyImpl.striveDo(serviceData);   //serviceData为业务方法的参数
```



# 自定制执行间隔和次数

新建生成器类，实现CountGenerator接口。具体实现参考DefaultCountGenerator类

```
public class ConcreteCountGenerator implements CountGenerator
```

在springboot配置类文件中，配置自有生成器。配置即可生效。

```
@Bean
@Primary
CountGenerator countGenerator(){
return new ConcreteCountGenerator();
}
```
本项目暂未完成，后续会陆续完成，敬请谅解。同时，希望开发者参与开发工作，以及提出改进意见。
谢谢。