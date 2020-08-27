package com.michaelyzh.parcel_path.rabbitMQ;

import com.michaelyzh.parcel_path.service.ParcelService;
import com.michaelyzh.parcel_path.service.SubParcelService;
import com.michaelyzh.parcel_path.utils.JsonUtils;
import com.michaelyzh.parcel_path.utils.Parcel;
import com.michaelyzh.parcel_path.utils.SubParcel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.insertSubParcel")
public class InsertSubParcelReceiver {
    @Autowired
    private SubParcelService subParcelService;

    @Autowired
    private ParcelService parcelService;


    /**
     * the receiver that handle update bullets, including update the lastupdate information and add into database
     * @param message
     */
    @RabbitHandler
    public void process(String message) {

        SubParcel subParcel = JsonUtils.string2Obj(message, SubParcel.class);
        subParcelService.add(subParcel);

        //update the last update infor for the corresponding Parcel
        Parcel parcel = parcelService.get(subParcel.getParcelNum());
        parcel.setUpdate(subParcel);
        parcelService.update(parcel);
    }
}
