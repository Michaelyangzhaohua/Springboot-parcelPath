package com.michaelyzh.parcel_path.service;

import com.michaelyzh.parcel_path.utils.SubParcel;

import java.util.List;

/**
 * CRUD services of parcel information bullets
 */
public interface SubParcelService {

    /**
     * add information bullets
     * @param subParcel
     * @return
     */
    public long add(SubParcel subParcel);

    /**
     * get all information bullets by parcelNum
     * @param parcelNum
     * @return
     */
//    public List<SubParcel> findAllByParcelNum(long parcelNum);
}
