package com.michaelyzh.parcel_path.mapper;
import com.michaelyzh.parcel_path.utils.Parcel;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Component
public interface ParcelMapper {
    /**
     * the function that find the all update information about the order number
     * @param orderNum
     * @return
     */
    @Select("SELECT * FROM parcel WHERE order_num = #{orderNum}")
    @Results({
            @Result(column = "order_num", property = "data",
            many = @Many(select = "com.michaelyzh.parcel_path.mapper.SubParcelMapper.findSubByParcelId")),
            @Result(property = "orderNum", column = "order_num"),
            @Result(property = "lastUpdate", column = "last_update")
    })
    Parcel find(long orderNum);

    /**
     * insert the package information with order number
     * @param parcel
     * @return
     */
    @Insert("INSERT INTO parcel(order_num, state, company, address) VALUES(#{orderNum}, #{state}, #{company}, #{address})")
    @Options(keyProperty = "orderNum", keyColumn = "order_num")
    long insert(Parcel parcel);

    /**
     * update the package information
     * @param parcel
     */
    @Update("UPDATE parcel SET state = #{state}, company = #{company}, last_update = #{lastUpdate}, address = #{address} " +
            "WHERE order_num = #{orderNum}")
    void update(Parcel parcel);

    /**
     * delete the package
     * @param OrderNum
     */
    @Delete(("DELETE FROM parcel WHERE order_num = #{orderNum}"))
    void delete(long OrderNum);

    @Select("SELECT * FROM parcel")
    @Results({
            @Result(property = "orderNum", column = "order_num"),
            @Result(property = "lastUpdate", column = "last_update")
    })
    List<Parcel> findAllParcels();
}
