Troubleshooting latency vs. throughput
Selecting transcript lines in this section will navigate to timestamp in the video

- [Instructor] 
    Stop me if you've heard this one before. This service can handle only 20 users at the same time. 
    Or my favorite, the web app's response is not on fleek, as the kids say. 
    Or my all time favorite, your API is slow. 

  - These are just some of the frustratingly vague complaints  we get from users, product owners, or API consumers. 
    Sometimes, the complaint comes in even fancier packaging, from the architects and the site reliability engineers 
    talking about the 99th percentile and the average response time or, quote, concurrent users. 

  - All of those descriptions are referring to two things.Throughput and latency, what are they? 
  
    Throughput is a measurement of how many tasks an application can handle concurrently over a period of time. 
  
    Latency is a measure of how long a single task takes. Imagine a kitchen in a restaurant. 
    Latency would be how long it takes for a single meal order to cook. Throughput would be the measurement of how many 
    new orders that kitchen can concurrently cook. 
  
  - In somewhat less delicious terms, in the world of service-oriented architecture, latency is a measurement of 
    how long it takes for, say, a microservice to respond to an API request. 

  - Throughput is the measurement of how many concurrent API requests that same microservice can handle. Both of these 
    metrics share a similar root risk, waiting or blocked threats. Having a threat wait to do anything, connect, 
    retrieve data, send out a notification, anything at all, can quickly become problematic.
  
   Put together, they can make or literally break your Java application. A service or website crashing under the weight 
   of volume happens to some of the biggest names in the business. Amazon, Facebook, et cetera. Even more annoyingly, 
   one problem can lead to another. 

  - When it starts taking too long to respond to a microservice request or to cook a meal, the capacity to 
  - service new microservice requests starts to diminish, and then boom, 
  - the number of requests you can concurrently handle starts to suffer. 

  - In other words, prolonged latency problems will eventually lead to throughput problems. 
  - The reverse is also possible. Even if your application starts out with the ability to complete a 
  - single request in record time, if the application is not configured or built to handle multiple 
  - concurrent requests, many clients will have to wait their turn and you've gotten yourself a 
  - throughput problem. In this course, I'll talk about some of the usual suspects when dealing 
  - with latency and throughput issues in a Java application, particularly microservices. 

  - It's by no means and exhaustive list, but it's a good start in preventing these problems or 
  - troubleshooting them when they occur. On a final note, something to bear in mind is that 
  - troubleshooting concurrency problems is part art and part science. 
  - 
  - For a technical challenge, it's not as deterministic as one would expect or like. So, there's some amount of what we can 
  - charitably call intuition, really it's guess work. 

  - As well as the sciency bits of methodical root cause analysis. Now, let's go hunt down the culprits.