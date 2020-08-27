package com.michaelyzh.parcel_path.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * The update information bullet in the parcel info
 */
public class SubParcel {

    private long id;

    private String context;

    @JsonFormat(locale="dallas", timezone="GMT-5", pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;

    //reference to the parcel id
    private long parcelNum;
}
