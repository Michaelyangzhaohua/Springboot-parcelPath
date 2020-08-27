package com.michaelyzh.parcel_path.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * The record of the package
 */
public class Parcel {
    //0:error, 1:on the way, 2:delivered
    private int state;

    private String company;

    private long orderNum;

    private List<SubParcel> data;

//    @JsonFormat(locale="dallas", timezone="GMT-5", pattern="yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String lastUpdate;

    private String address;

    public void setUpdate(SubParcel subParcel){
        this.lastUpdate = "last update: " + subParcel.getDate().toString() + " " + subParcel.getContext();
    }
}
