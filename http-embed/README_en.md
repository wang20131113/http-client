In java project, the best-effort execution mode is adopted for micro-services. On the other hand, when the best-effort execution is still unsuccessful, the operation processing is reversed. Otherwise, you can customize the service execution interval and times by yourself.

# How to use it

The microservice processing class implements the ParticipantService interface, forward execution method and backward method.

```
public class ParticipantServiceImpl implements ParticipantService
```

The proxy service class inherits the ParticipantServiceProxy class and determines the type of the service class.

```
public class ParticipantServiceProxyImpl extends ParticipantServiceProxy
```

run

```
this.participantServiceProxyImpl.striveDo(serviceData); //serviceData is the parameter of business method
```



# Customize the execution interval and times

Create a new generator class and implement the CountGenerator interface. The specific implementation refers to the DefaultCountGenerator class

```
public class ConcreteCountGenerator implements CountGenerator
```

In the springboot configuration class file, configure your own generator. The configuration takes effect.

```
@Bean
@Primary
CountGenerator countGenerator(){
return new ConcreteCountGenerator();
}
```

This project has not been completed yet and will be completed one after another. Please understand. At the same time, developers are expected to participate in the development work and put forward suggestions for improvement.

best regards.