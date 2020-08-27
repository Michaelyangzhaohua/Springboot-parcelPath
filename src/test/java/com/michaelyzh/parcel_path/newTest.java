package com.michaelyzh.parcel_path;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.michaelyzh.parcel_path.mapper.ParcelMapper;
import com.michaelyzh.parcel_path.mapper.SubParcelMapper;
import com.michaelyzh.parcel_path.rabbitMQ.TopicSender;
import com.michaelyzh.parcel_path.redis.RedisClient;
import com.michaelyzh.parcel_path.service.ParcelService;
import com.michaelyzh.parcel_path.service.SubParcelService;
import com.michaelyzh.parcel_path.utils.JsonUtils;
import com.michaelyzh.parcel_path.utils.Parcel;
import com.michaelyzh.parcel_path.utils.SubParcel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ParcelPathApplication.class})
public class newTest {
    @Autowired
    ParcelService parcelService;

    @Autowired
    SubParcelService subParcelService;

    @Autowired
    RedisClient redisClient;

    @Autowired
    private TopicSender sender;


    @Test
    public void topic1() throws Exception {
        sender.send1();
    }

    @Test
    public void topic2() throws Exception {
        sender.send2();
    }
}
