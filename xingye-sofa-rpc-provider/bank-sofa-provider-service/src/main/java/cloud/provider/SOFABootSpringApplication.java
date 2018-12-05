package cloud.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath*:META-INF/xingye-sofa-rpc-provider/*.xml"})
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SOFABootSpringApplication {

    private static final Logger logger = LoggerFactory.getLogger(SOFABootSpringApplication.class);

    public static void main(String[] args){

        SpringApplication springApplication = new SpringApplication(SOFABootSpringApplication.class);
        ApplicationContext applicationContext = springApplication.run(args);
        cloud.provider.facade.CallerService callerService = applicationContext.getBean(cloud.provider.facade.CallerService.class);

        if (logger.isInfoEnabled()){
            logger.info("Sample Service Result = " + callerService.message());
            logger.info("Current Application Context : " + applicationContext);
        }
        
        System.out.println("......" + callerService.message());
    }
}
