package com.loop.backend.repo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.loop.backend.dto.HotelInfo;
import com.loop.backend.pojo.HotelChain;

import com.loop.backend.pojo.*;

@Component("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService{

		private final HotelRepo hotelRepository;


		public HotelServiceImpl(HotelRepo hotelRepository) {
			this.hotelRepository = hotelRepository;
		}

		@Override
		public HotelChain getHotel(Hotel city, String name) {
			Assert.notNull(city, "City must not be null");
			Assert.hasLength(name, "Name must not be empty");
			return null;
		}

}
