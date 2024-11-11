import requests

class ListingRequest:
    
    def __init__(self):
        self.base_url = "http://172.26.1.101/listing"

    def post(self, id, name, host_id, host_name, neighbourhood_group, 
             neighbourhood, latitude, longtitude, room_type,
             price, minimum_nights, number_of_reviews, last_review,
             reviews_per_month, calculated_host_listings_count,
             availability365, number_of_reviews_ltm, license):
        data = {
            "id": id,
            "name": name,
            "hostId": host_id,
            "hostName": host_name,
            "neighbourhoodGroup": neighbourhood_group,
            "neighbourhood": neighbourhood,
            "latitude": latitude,
            "longtitude": longtitude,
            "roomType": room_type,
            "price": price,
            "minimumNights":minimum_nights,
            "numberOfReviews":number_of_reviews,
            "lastReview":last_review,
            "reviewsPerMonth":reviews_per_month,
            "calculatedHostListingsCount":calculated_host_listings_count,
            "availability365":availability365,
            "numberOfReviewsLtm":number_of_reviews_ltm,
            "license":license
        }
        response = requests.post(self.base_url, json=data)
        print(response.status_code)

    def get(self, listing_id):
        url = self.base_url + f"/{listing_id}"
        response = requests.get(url)