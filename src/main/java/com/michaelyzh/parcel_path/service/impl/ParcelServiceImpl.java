package com.michaelyzh.parcel_path.service.impl;

import com.michaelyzh.parcel_path.mapper.ParcelMapper;
import com.michaelyzh.parcel_path.redis.RedisClient;
import com.michaelyzh.parcel_path.service.ParcelService;
import com.michaelyzh.parcel_path.utils.JsonUtils;
import com.michaelyzh.parcel_path.utils.Parcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@Service
public class ParcelServiceImpl implements ParcelService {
    @Autowired
    private ParcelMapper parcelMapper;

    @Autowired
    private RedisClient redisClient;

    /**
     * add service of parcel information
     * @param parcel
     * @return
     */
    @Override
    public long add(Parcel parcel) {
        String key = "parcel_" + parcel.getOrderNum();
        String value = JsonUtils.obj2String(parcel);
        String keyOfAll = "parcel_all";
        if(redisClient.hasKey(key)){
            redisClient.delete(key);
        }
        if(redisClient.hasKey(keyOfAll)){
            redisClient.delete(keyOfAll);
        }
        parcelMapper.insert(parcel);
        return parcel.getOrderNum();
    }

    /**
     * get service of parcel information
     * @param orderNum
     * @return
     */
    @Override
    public Parcel get(long orderNum) {
        String key = "parcel_" + orderNum;
        if(redisClient.hasKey(key)){
            return JsonUtils.string2Obj(redisClient.get(key), Parcel.class);
        }else{
            Parcel parcel = parcelMapper.find(orderNum);
            redisClient.set(key, JsonUtils.obj2String(parcel));
            return parcel;
        }
    }

    /**
     * update service
     * @param parcel
     * @return
     */
    @Override
    public Parcel update(Parcel parcel) {
        String key = "parcel_" + parcel.getOrderNum();
        String value = JsonUtils.obj2String(parcel);
        String keyOfAll = "parcel_all";
        if(redisClient.hasKey(key)){
            redisClient.delete(key);
        }
        if(redisClient.hasKey(keyOfAll)){
            redisClient.delete(keyOfAll);
        }
        parcelMapper.update(parcel);
        return parcel;
    }

    /**
     * delete service
     * @param orderNum
     */
    @Override
    public void delete(long orderNum) {
        String key = "parcel_" + orderNum;
        String keyOfAll = "parcel_all";
        if(redisClient.hasKey(key)){
            redisClient.delete(key);
        }
        if(redisClient.hasKey(keyOfAll)){
            redisClient.delete(keyOfAll);
        }
        parcelMapper.delete(orderNum);
    }

    /**
     * find all parcels
     * @return
     */
    @Override
    public List<Parcel> finAllParcels() {
        String key = "parcel_all";
        if(redisClient.hasKey(key)){
            return JsonUtils.string2Obj(redisClient.get(key), List.class);
        }else{
            List<Parcel> list = parcelMapper.findAllParcels();
            redisClient.set("parcel_all", JsonUtils.obj2String(list));
            return list;
        }
    }
}
