package io.github.wuwei01;

import io.github.wuwei01.utils.FastDFSClientUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileClientApplicationTests {
    @Test
    public void Upload() {
        String fileUrl = this.getClass().getResource("/test.jpg").getPath();
        File file = new File(fileUrl);
        String str = FastDFSClientUtils.uploadFile(file);
        FastDFSClientUtils.getResAccessUrl(str);
    }

    @Test
    public void Delete() {
        FastDFSClientUtils.deleteFile("group1/M00/00/00/rBEAClu8OiSAFbN_AAbhXQnXzvw031.jpg");
    }
}
