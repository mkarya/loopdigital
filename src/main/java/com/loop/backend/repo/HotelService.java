package com.loop.backend.repo;

import com.loop.backend.pojo.Hotel;
import com.loop.backend.pojo.HotelChain;

public interface HotelService {

	HotelChain getHotel(Hotel city, String name);



}
