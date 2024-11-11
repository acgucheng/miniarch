import csv
from request.ListingRequest import ListingRequest
from request.ReviewRequest import ReviewRequest
import threading
import random

class HotelRequestController:


    def __init__(self, data_path):
        self.max_listing_id = 0
        self.review_listing_id = 0
        self.data_path = data_path
        self.listingRequest = ListingRequest()
        self.reviewRequest = ReviewRequest()
        self.lock = threading.Lock()
        self.lock2 = threading.Lock()
        self.review_lock = threading.Lock()
        self.request_total = 0;

    def open(self):
        self.listing_file = open(f"{self.data_path}/listings.csv", encoding="utf-8")
        self.review_file = open(f"{self.data_path}/reviews.csv", encoding="utf-8")
        self.calendar_file = open(f"{self.data_path}/calendar.csv", encoding="utf-8")
        self.listing_reader = csv.reader(self.listing_file)
        self.review_reader = csv.reader(self.review_file)
        next(self.listing_reader)
        next(self.review_reader)
    def close(self):
        self.listing_file.close()
        self.review_file.close()

    def get_next_listing(self):
        with self.lock:
            row = next(self.listing_reader)
        print(row[0])
        return row
    def get_next_review(self):
        with self.review_lock:
            row = next(self.review_reader)
            return row

    def get_next_calendar(self):
        pass

    def get_next_query(self):
        pass

    def update_max_listing_id(self, now):
        with self.lock2:
            if now > self.max_listing_id:
                print(f"maxlisting:{now}")
                self.max_listing_id = now

    async def next_request(self):
        probability = random.random()
        if probability < 0.015:
            self.request_total += 1
            #print(self.request_total)
            lrow = self.get_next_listing()
            self.listingRequest.post(lrow[0], lrow[1], lrow[2], lrow[3],
                                    lrow[4], lrow[5], lrow[6], lrow[7],
                                    lrow[8], lrow[9], lrow[10], lrow[11],
                                    lrow[12], lrow[13], lrow[14], lrow[15],
                                lrow[16], lrow[17])
        else:
            self.request_total += 1
            #print(self.request_total)
            rrow = self.get_next_review()
            self.reviewRequest.post(
                rrow[0], rrow[1], rrow[2], rrow[3], rrow[4], rrow[5]
            )