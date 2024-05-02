package org.example.specification;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SupportedSortValues {

  public static final String ASC = "asc";
  public static final String DESC = "desc";
  public static final String SEPARATOR = ",";

  public static final class RoomClass {

    public static final String ROOM_CLASS_NAME = "roomClassName";
    public static final String ROOM_CLASS_NAME_ASC = ROOM_CLASS_NAME + SEPARATOR + ASC;
    public static final String ROOM_CLASS_NAME_DESC = ROOM_CLASS_NAME + SEPARATOR + DESC;

    public static final String ROOM_CATEGORY_NAME = "roomCategory";
    public static final String ROOM_CATEGORY_NAME_ASC = ROOM_CATEGORY_NAME + SEPARATOR + ASC;
    public static final String ROOM_CATEGORY_NAME_DESC = ROOM_CATEGORY_NAME + SEPARATOR + DESC;

    public static final String ROOM_TYPE_NAME = "roomType";
    public static final String ROOM_TYPE_NAME_ASC = ROOM_TYPE_NAME + SEPARATOR + ASC;
    public static final String ROOM_TYPE_NAME_DESC = ROOM_TYPE_NAME + SEPARATOR + DESC;

  }

  public static final class HotelService {

    public static final String HOTEL_SERVICE_NAME = "serviceName";
    public static final String HOTEL_SERVICE_NAME_ASC = HOTEL_SERVICE_NAME + SEPARATOR + ASC;
    public static final String HOTEL_SERVICE_NAME_DESC = HOTEL_SERVICE_NAME + SEPARATOR + DESC;

  }

  public static final class Room {

    public static final String ROOM_CODE = "roomCode";
    public static final String ROOM_CODE_ASC = ROOM_CODE + SEPARATOR + ASC;
    public static final String ROOM_CODE_DESC = ROOM_CODE + SEPARATOR + DESC;

  }

  public static final class BookingCard {

    public static final String ID = "id";
    public static final String ID_ASC = ID + SEPARATOR + ASC;
    public static final String ID_DESC = ID + SEPARATOR + DESC;

    public static final String DATE = "bookingAtDate";
    public static final String DATE_ASC = DATE + SEPARATOR + ASC;
    public static final String DATE_DESC = DATE + SEPARATOR + DESC;

  }

  public static final class Refund {

    public static final String ID = "id";
    public static final String ID_ASC = ID + SEPARATOR + ASC;
    public static final String ID_DESC = ID + SEPARATOR + DESC;

    public static final String DATE = "cancelAtDate";
    public static final String DATE_ASC = DATE + SEPARATOR + ASC;
    public static final String DATE_DESC = DATE + SEPARATOR + DESC;

  }

  public static final class BookingCardDetail {

    public static final String QUANTITY = "quantity";
    public static final String QUANTITY_ASC = QUANTITY + SEPARATOR + ASC;
    public static final String QUANTITY_DESC = QUANTITY + SEPARATOR + DESC;

  }

  public static final class Customer {

    public static final String CMND = "cmnd";
    public static final String CMND_ASC = CMND + SEPARATOR + ASC;
    public static final String CMND_DESC = CMND + SEPARATOR + DESC;

    public static final String FIRST_NAME = "name";
    //    public static final String FIRST_NAME = "firstName";
    public static final String FIRST_NAME_ASC = FIRST_NAME + SEPARATOR + ASC;
    public static final String FIRST_NAME_DESC = FIRST_NAME + SEPARATOR + DESC;

    public static final String LAST_NAME = "lastName";
    public static final String LAST_NAME_ASC = FIRST_NAME + SEPARATOR + ASC;
    public static final String LAST_NAME_DESC = FIRST_NAME + SEPARATOR + DESC;

    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String PHONE_NUMBER_ASC = PHONE_NUMBER + SEPARATOR + ASC;
    public static final String PHONE_NUMBER_DESC = PHONE_NUMBER + SEPARATOR + DESC;

  }


}
