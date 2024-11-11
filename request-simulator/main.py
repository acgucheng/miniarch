from request.HotelRequestController import HotelRequestController
import asyncio


async def batch_send_requests(qps):
    hotelRequestController = HotelRequestController("C:\\Users\\acguc\\Data\\Hotel")
    hotelRequestController.open()
    time_interval = 1.0 / qps
    tasks = []
    for i in range(20000):
        tasks.append(asyncio.create_task(hotelRequestController.next_request()))
        await asyncio.sleep(time_interval)
    hotelRequestController.close()


if __name__ == "__main__":
    asyncio.run(batch_send_requests(qps=20))
    print("finish")
    
    
    