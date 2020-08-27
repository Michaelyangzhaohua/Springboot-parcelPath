package com.michaelyzh.parcel_path.mapper;

import com.michaelyzh.parcel_path.utils.SubParcel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SubParcelMapper {

    /**
     * find all update bullets of the package with parcelNum
     * @param parcelNum
     * @return
     */
    @Select("Select * FROM sub_parcel WHERE parcel_num = #{parcelNum}")
    @Results({
        @Result(property = "parcelNum", column = "parcel_num")
    })
    List<SubParcel> findSubByParcelId(long parcelNum);

    /**
     * insert the update bullet of the package with parcelNum
     * @param subParcel
     * @return
     */
    @Insert("INSERT INTO sub_parcel(context, date, parcel_num) VALUES(#{context}, #{date}, #{parcelNum})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public long add(SubParcel subParcel);
}
