1- crawlAPI with seed_url, flag (look-up cached or not), depth = 2
  -> return unique_token
 -> if you want in-between result or Partial result please hit with x api with unique token

-> status (In progress and Finished)
2- if process finished then we have to cached the list and return back the list for same seed_url
3- looking urls which is based on based on some depth level like search till 2nd level only

**Implementation:**
1- use html parser which extract all the links from that
2- we need httpclient to get response
3- we need to run thread (ExecutorService)