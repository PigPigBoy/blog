package group7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RefreshScope
public class ThirdPartyStarter_6000 {

    public static void main(String[] args) {
        SpringApplication.run(ThirdPartyStarter_6000.class, args);
    }

}
