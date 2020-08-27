package com.michaelyzh.parcel_path.service.impl;

import com.michaelyzh.parcel_path.mapper.SubParcelMapper;
import com.michaelyzh.parcel_path.redis.RedisClient;
import com.michaelyzh.parcel_path.service.ParcelService;
import com.michaelyzh.parcel_path.service.SubParcelService;
import com.michaelyzh.parcel_path.utils.JsonUtils;
import com.michaelyzh.parcel_path.utils.Parcel;
import com.michaelyzh.parcel_path.utils.SubParcel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubParcelServiceImpl implements SubParcelService{
    @Autowired
    SubParcelMapper subParcelMapper;

    @Autowired
    RedisClient redisClient;

    @Autowired
    ParcelService parcelService;

    @Autowired
    private AmqpTemplate rabbitTemplate;
    /**
     * add information bullet about the parcel number
     * @param subParcel
     * @return
     */
    @Override
    public long add(SubParcel subParcel) {
        String key = "parcel_" + subParcel.getParcelNum();
        if(redisClient.hasKey(key)){
            redisClient.delete(key);
        }

        Parcel parcel = parcelService.get(subParcel.getParcelNum());
        parcel.setUpdate(subParcel);
        parcelService.update(parcel);
        subParcelMapper.add(subParcel);

        String msg = parcel.getLastUpdate();
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.SMS", msg);
        return subParcel.getId();
    }


    /**
     * find all information bullet about the parcel number
     * @param parcelNum
     * @return
     */
//    @Override
//    public List<SubParcel> findAllByParcelNum(long parcelNum) {
//        return subParcelMapper.findSubByParcelId(parcelNum);
//    }
}
