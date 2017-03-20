# FluentLenium Issue

## Description
We're having issues getting FluentLenium to pick up a new element in an array of elements populated by the FindBy annotation. The new element, in this case, is populated as a result of an async call to a REST API. 

I've produced an example project to illustrate the issue, which has two tests in - both are behaviourally identical, however one uses await() and the other Thread.sleep(). The one using Thread.sleep() works, however the await() one fails, which is what we're seeing in our main project. 

In the example, we're using the following FindBy annotation: 

```
@FindBy(css = ".alert")
List<FluentWebElement> alerts;
```

Where one alert already exists on page load: 

```
<div class="alert alert-success">
This is an alert that exists on page load
</div>
```

We then have a Javascript method, associated with a button click, that performs an AJAX GET request to a slow (~3 seconds) service. Once this completes, it adds another button to the DOM under the first alert. It's this second alert that never gets found when using: 

```
await().atMost(10, TimeUnit.SECONDS).until(alerts).size(2);
```

However this succeeds using the following: 

```
Thread.sleep(6000);
assertThat(alerts.size()).isEqualTo(2);
```


## Running the tests
```
mvn test
```

