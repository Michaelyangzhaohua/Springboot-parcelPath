package com.michaelyzh.parcel_path.controller;

import com.michaelyzh.parcel_path.service.ParcelService;
import com.michaelyzh.parcel_path.service.SubParcelService;
import com.michaelyzh.parcel_path.utils.Parcel;
import com.michaelyzh.parcel_path.utils.SubParcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class ParcelController {
    @Autowired
    ParcelService parcelService;

    @Autowired
    SubParcelService subParcelService;

    @GetMapping("findParcel")
    public Object findParcel(long orderNum){
        return parcelService.get(orderNum);
    }

    @RequestMapping("insertParcel")
    public Object insertParcel(@RequestBody Parcel parcel){
        parcelService.add(parcel);
        return "success";
    }

    @GetMapping("findAll")
    public Object findAllParcels(){
        return parcelService.finAllParcels();
    }

    /**
     * set the last update information when getting the subparcel bullets
     * @param subParcel
     * @return
     */
    @RequestMapping("insertSubParcel")
    public Object insertSubParcel(@RequestBody SubParcel subParcel){
        //insert the subParcel
        subParcelService.add(subParcel);
        Parcel parcel = parcelService.get(subParcel.getParcelNum());
        parcel.setUpdate(subParcel);
        parcelService.update(parcel);
        return "success";
    }


}
