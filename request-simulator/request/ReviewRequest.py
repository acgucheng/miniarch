import requests

class ReviewRequest:

    def __init__(self):
        self.base_url = "http://172.26.1.101/review"

    def post(self, listing_id, id, date, reviewer_id, reviewer_name, comments):
        data = {
            "listingId":listing_id,
            "id":id,
            "date":date,
            "reviewerId":reviewer_id,
            "reviewerName":reviewer_name,
            "comments":comments
        }
        response= requests.post(self.base_url, json=data)
        print(response.status_code)