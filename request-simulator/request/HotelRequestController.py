import csv
from request.ListingRequest import ListingRequest

class HotelRequestController:

    def __init__(self, data_path):
        self.max_listing_id = 0
        self.data_path = data_path
        self.listingRequest = ListingRequest()

    def open(self):
        self.listing_file = open(f"{self.data_path}/listings.csv", encoding="utf-8")
        self.listing_reader = csv.reader(self.listing_file)
        next(self.listing_reader)
    
    def close(self):
        self.listing_file.close()

    def next_request(self):
        row = next(self.listing_reader)
        self.listingRequest.post(row[0], row[1], row[2], row[3],
                                 row[4], row[5], row[6], row[7],
                                 row[8], row[9], row[10], row[11],
                                 row[12], row[13], row[14], row[15],
                                 row[16], row[17])