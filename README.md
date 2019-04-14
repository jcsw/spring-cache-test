# Spring Cache Test #

### Test Spring Cache with Cache2k, Hazelcast ###

Build
```
./gradlew clean build
```

Run
```
./gradlew bootRun
```


Test
```
curl http://localhost:9200/books/test-inbn
```


Stress Test with Locust
```
locust -f stress-test/get-by-isbn.py --host=http://localhost:9200 --no-web -c 10 -r 1
```