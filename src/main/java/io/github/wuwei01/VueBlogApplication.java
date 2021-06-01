package io.github.wuwei01;

import com.github.tobato.fastdfs.FdfsClientConfig;
import com.mzt.logapi.starter.annotation.EnableLogRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@SpringBootApplication
@EnableLogRecord(tenant = "io.github.wuwei01")
public class VueBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(VueBlogApplication.class,args);
    }
}
