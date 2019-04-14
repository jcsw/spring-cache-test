from locust import HttpLocust, TaskSet, task
from random import randint

class UserBehavior(TaskSet):
    @task
    def get_by_isbn(self):
        isbn = randint(1,1001)

        headers = {'content-type': 'application/json'}

        response = self.client.get("/books/" + str(isbn),  headers=headers)

class WebsiteUser(HttpLocust):
    task_set = UserBehavior
    min_wait = 500
    max_wait = 500