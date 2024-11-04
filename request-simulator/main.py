from request.HotelRequestController import HotelRequestController


if __name__ == "__main__":
    hotelRequestController = HotelRequestController("C:\\Users\\acguc\\Data\\Hotel")
    hotelRequestController.open()
    for i in range(10):
        hotelRequestController.next_request()
    hotelRequestController.close()