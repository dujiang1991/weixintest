package com.weixin.demo1.media;


import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.InputStream;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MediaKitTest {
    @Test
    public void getMedia() throws Exception {
        MediaKit.getMedia("Q2aZRQMQ0KTRbItiM3bEE2VRF6nYjtD9vLD8WUpuMo3Et6fG8Z8338d4unMKVVfz",new File("e:/aa.jpg"));
    }

    @Test
    public void postMedia() throws Exception {
        String image = MediaKit.postMedia("E:\\image\\u=1144405335,2029061999&fm=27&gp=0.jpg", "image");
        System.out.println(image);

    }

}