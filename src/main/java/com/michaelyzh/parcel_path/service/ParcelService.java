package com.michaelyzh.parcel_path.service;

import com.michaelyzh.parcel_path.utils.Parcel;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * service for CRUD the parcel
 */
public interface ParcelService {
    /**
     * add parcel
     * @param parcel
     * @return
     */
    public long add(Parcel parcel);

    /**
     * get parcel by orderNum
     * @param orderNum
     * @return
     */
    public Parcel get(long orderNum);

    /**
     * update the parcel by object
     * @param parcel
     * @return
     */
    public Parcel update(Parcel parcel);

    /**
     * delete parcel by orderNum
     * @param orderNum
     */
    public void delete(long orderNum);

    /**
     * find all parcels
     * @return
     */
    public List<Parcel> finAllParcels();
}
