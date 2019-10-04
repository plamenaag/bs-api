package com.bookstore.api.dao.error;

import com.bookstore.api.Constants;

public enum ErrorEnum {

    ERROR_OK(Constants.NO_ERRORS),
    ERROR_ENTITY_PK_IS_INVALID("Entity primary key is invalid"),
    ERROR_ENTITY_EXISTS("Entity already exists."),
    ERROR_ENTITY_DOES_NOT_EXIST("Entity does not exist."),
    ERROR_ENTITY_INVALID_ARGUMENT("Invalid entity parameter."),
    ERROR_ENTITY_NO_RESULTS("Cannot find any entity."),
    ERROR_FOUND_WITH_ACCOMMODATIONS("Error found with accommodations"),
    ERROR_FOUND_WITH_BOOKINGS("Error found with booking"),
    ERROR_NOT_ENOUGH_FREE_ROOMS_TO_CREATE_BOOKING("Not enough free rooms to create booking"),
    ERROR_NOT_ENOUGH_FREE_ROOMS_TO_CREATE_ACCOMMODATION("Not enough free rooms to create booking"),
    ERROR_DATE_IS_NOT_CORRECT_PARSE_ERROR("Date is not corect"),
    ERROR_ARCHIVE_POSIBLE_ONLY_BEFORE_SYSTEM_DATE("Arhive is posible only before system date."),
    ERROR_USER_EXIST("User already exists."),
    ERROR_JASPER_EX("Jasper exception"),
    ERROR_JASPER_FILE_EXTENSION_INVALID("Jasper file extension invalid"),
    ERROR_REPORT_DIR_DOES_NOT_EXIST("Report div does not EXIST"),
    ERROR_PDF_EXTENSION_INVALID("Pdf extension invalid"),
    ERROR_ARRIVAL_DATE_CAN_NOT_BE_CHANGED_AFTER_THE_GUEST_IS_ACCOMMODATED("Arrival date can not be changed"),
    ERROR_ARRIVAL_DATE_CAN_NOT_BE_BEFORE_SYSTEM_DATE("Arrival date can not be before system date"),
    ERROR_CLIENTS_WITH_THE_SAME_EGN_CAN_NOT_EXIST("Client with the same egn can not exist"),
    ERROR_CLIENT_MUST_HAVE_NAME("Client must have name"),
    ERROR_CHARGE_ROOM_TO_CAN_NOT_BE_EMPTY("Charge room to can not be empty"),
    ERROR_CHARGE_SERVICE_TO_CAN_NOT_BE_EMPTY("Charge service to can not be empty"),
    ERROR_PAYMENT_PLAN_CAN_NOT_BE_EMPTY("Payment plan can not be empty"),
    ERROR_PAYMENT_PLAN_DOES_NOT_EXIST("Payment plan does not exist"),
    ERROR_BOARDING_PLAN_CAN_NOT_BE_EMPTY("Boarding plan can not be empty"),
    ERROR_BOARDING_PLAN_DOES_NOT_EXIST("Boarding plan does not exist"),
    ERROR_BOOKING_GUEST_CAN_NOT_BE_EMPTY("Booking guest can not be empty"),
    ERROR_ROOM_CAN_NOT_BE_LEFT_BEFORE_PAID("Room can not be left berofe it is paid"),
    ERROR_BILL_DOCUMENT_TYPE_MUST_HAVE_COUNTER("Bill document type must have counter"),
    ERROR_BILL_DOCUMENT_TYPE_MUST_HAVE_TEMPLATE("Bill document type must have template"),
    ERROR_CHARACTERISTIC_WITH_THIS_CODE_EXISTS("Characteristic with this name already exists."),
    ERROR_GUEST_CAN_NOT_ARRIVED_BEFORE_ARRIVAL_DATE("Guest can not arrived before arrival date."),
    ERROR_GUEST_CAN_NOT_LEAVE_BEFORE_DEPARTURE_DATE("Guest can not leave before departure date."),
    ERROR_GUEST_CAN_NOT_BE_CHANGED_OR_REMOVED_AFTER_HE_IS_ARRIVED("Guest can not be changed or removed after he is arrived"),
    ERROR_ROOM_STATUS_CAN_NOT_BE_DETERMINED("Room status can not be determined"),
    ERROR_ROOM_WITH_THIS_NUMBER_EXIST("Room with this number exist"),
    ERROR_ROOM_WITH_THIS_NAME_EXIST("Room with this name exist"),
    ERROR_CHECK_ACCOMMODATIONS_BEFORE_FINISHING_DAILY_REPORT("Check accommodations before finishing daily report."),
    ERROR_ACCOMMODATION_CAN_NOT_BE_REMOVED_IF_NOT_FOR_ACCOMMODATION("Accommodation can not be removed"),
    ERROR_ACCOMMODATION_DATES_OUTSIDE_BOOKING_DATES("Accommodation dates outside booking dates"),
    ERROR_ACCOMMODATION_CLIENT_DATES_OUTSIDE_ACCOMMODATION_DATES("Accommodation client dates outside ACCOMMODATION dates"),
    ERROR_ACCOMMODATION_CLIENT_CAN_NOT_BE_REMOVED_AFTER_ARRIVED_OR_LEFT("Accommodation client can not be removed"),
    ERROR_ACCOMMODATION_ARRIVAL_DATE_IS_NOT_CORRECT("Accommodation arrical date is not correct"),
    ERROR_ROOM_IS_NOT_CLEANED("Room is not cleaned"),
    ERROR_ACCOMMODATION_STATUS_CAN_NOT_BE_CHANGED_BACK_TO_EXPECTED("Accommodation status can not be changed back to expoexted"),
    ERROR_ACCOMMODATION_ROOM_CAN_NOT_BE_EMPTY("Accommodation room can not be empty"),
    ERROR_ACCOMMODATION_MUST_HAVE_ROOM_TYPE("Accommodation must have room type"),
    ERROR_ACCOMMODATION_CLIENT_GUEST_CAN_NOT_BE_EMPTY("Accommodation client guest can not be empty"),
    ERROR_ACCOMMODATION_CLIENT_PAYMENT_PLAN_NOT_BE_EMPTY("Accommodation client payment plan can not be empty"),
    ERROR_ROOM_CAN_NOT_BE_CREATED_VIA_ACCOMMODATION("Room can not be create via accommodation"),
    ERROR_ROOM_IS_BOOKED_FOR_THIS_PERIOD("Room is booked for this period"),
    ERROR_ROOM_IS_NOT_FREED("Room is not freed"),
    ERROR_GUEST_IS_ACCOMMODATED_FOR_THIS_PERIOD("Guest is accommodated for this period"),
    ERROR_ROOM_CAN_NOT_BE_CHANGED("Room can not be changed"),
    ERROR_ACCOMMODATION_CLIENT_MUST_HAVE_GUEST("Accommodation client must have guest."),
    ERROR_ACCOMMODATION_TO_MOVE_MUST_BE_INCLUDED("Accommodation to move must be included."),
    ERROR_INVALID_ARGUMENTS("Invalid arguments."),
    ERROR_PAYMENT_PLAN_DOES_NOT_EXISTS("Payment plan does not exist"),
    ERROR_OPERATION_IS_NOT_SUPPORTED("The operation is not supported"),
    ERROR_TRANSACTION_TIMEOUT(Constants.TRANSACTION_TIMEOUT),
    ERROR_REFUND_GUEST_NIGHTS("Refund guest nights"),
    ERROR_RESOURCE_BOOKING_DATE_MUST_BE_AFTER_SYSTEM_DATE("Resource booking date must be after system date"),
    ERROR_RESOURCE_BOOKING_MUST_HAVE_START_END("Resource booking must have start end"),
    ERROR_RESOURCE_BOOKING_MUST_HAVE_RESOURCE("Resource booking must have resource"),
    ERROR_RESOURCE_BOOKING_MUST_HAVE_SLOT_INDEX("Resource booking must have slot index"),
    ERROR_RESOURCE_BOOKING_EXIST_FOR_THIS_TIME("Resource booking exist for this time"),
    ERROR_GENERATING_PDF_EXCEPTION("Error generating pdf exception"),
    ERROR_DAILY_REPORT_GENERATION_EXCEPTION("Daily Report generation exception"),
    ERROR_REPORT_GENERATION_EXCEPTION("Report generation exception"),
    ERROR_ADDRESS_CARD_GENERATION_EXCEPTION("Address card exception"),
    ERROR_JASPER_REPORT_DATA_EXTRACTION_EXCEPTION("Jasper report data extraction exception"),
    ERROR_ACCOMMODATION_CLIENT_STATUS_CAN_NOT_BE_NULL("Accommodation Client status can not be null"),
    ERROR_BOOKING_STATUS_CAN_NOT_BE_NULL("Booking status can not be null"),
    ERROR_BOOKING_MUST_HAVE_AT_LEAST_ONE_ACCOMMODATION("Booking must have at least one accommodation"),
    ERROR_ARRIVAL_DEPARTURE_DATES_ARE_REQUIRED("Arrival and departure dates are required"),
    ERROR_ARRIVAL_DATE_CAN_NOT_BE_AFTER_DEPARTURE_DATE("Arrival date can not be after departure date"),
    ERROR_ARRIVAL_DATE_CAN_NOT_BE_THE_SAME_AS_DEPARTURE_DATE("Arrival date can not be the same as departure date"),
    ERROR_CLIENT_DOCUMENT_MUST_HAVE_VALID_TYPE("Client document must have valid type"),
    ERROR_CREDIT_CARD_MUST_HAVE_VALID_TYPE("Credit card must have valid type"),
    ERROR_BOOKING_ARRIVAL_DATE_NOT_OK("Booking arrival date not ok"),
    ERROR_BOOKING_DEPARTURE_DATE_NOT_OK("Booking departure date not ok"),
    ERROR_ACCOMMODATION_ARRIVAL_DATE_NOT_OK("Accommodation arrival date not ok"),
    ERROR_ACCOMMODATION_DEPARTURE_DATE_NOT_OK("Accommodation departure date not ok"),
    ERROR_LICENSE_NOT_ACTIVE("License not active"),
    ERROR_LICENSE_HW_MISMATCH("License hardware mismatch"),
    ERROR_LICENSE_EXPIRED("License expired"),
    ERROR_LICENSE_CORRUPTED("License corrupted"),
    ERROR_USER_DOES_NOT_EXIST("User does not exist."),
    ERROR_WRONG_USERNAME_OR_PASSWORD("Wrong username or password."),
    ERROR_SETTING_EXISTS("Setting exists"),
    ERROR_SYSTEM_DATE_TIME_CAN_NOT_BU_CHANGE_BACK("System date time can not be change back"),
    ERROR_SYSTEM_DATE_TIME("System date time missing");

    private final String internalMessage;

    private ErrorEnum(String internalMessage) {
        this.internalMessage = internalMessage;
    }

    public final String getInternalMessage() {
        return this.internalMessage;
    }

    @Override
    public String toString() {
        return internalMessage;
    }
}
