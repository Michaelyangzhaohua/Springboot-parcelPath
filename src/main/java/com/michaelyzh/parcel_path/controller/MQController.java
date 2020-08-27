package com.michaelyzh.parcel_path.controller;

import com.michaelyzh.parcel_path.service.ParcelService;
import com.michaelyzh.parcel_path.service.SubParcelService;
import com.michaelyzh.parcel_path.utils.JsonUtils;
import com.michaelyzh.parcel_path.utils.Parcel;
import com.michaelyzh.parcel_path.utils.SubParcel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * the controller that simulate the updating parcel information bullets process, the package tracking api can come in here
 */
@RestController
@RequestMapping("update")
public class MQController {
    @Autowired
    SubParcelService subParcelService;

    @Autowired
    ParcelService parcelService;

    @Autowired
    private AmqpTemplate rabbitTemplate;


    @RequestMapping("insertSubParcel")
    public Object insertSubParcel(@RequestBody SubParcel subParcel){
        String msg = JsonUtils.obj2String(subParcel);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.insertSubParcel", msg);
        return "success";
    }
}
