package com.michaelyzh.parcel_path;

import com.michaelyzh.parcel_path.mapper.ParcelMapper;
import com.michaelyzh.parcel_path.utils.SubParcel;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.michaelyzh.parcel_path.mapper")
public class ParcelPathApplication {
	public static void main(String[] args) {
		SpringApplication.run(ParcelPathApplication.class, args);
	}


}
