Find the source of a blockage
Selecting transcript lines in this section will navigate to timestamp in the video
- [Instructor] You've probably been in situations where someone throws some code in front of you, and says make it go fast. Or report comes from production that this particular interaction is really slow. Before you swoop into action, pause for a bit. The first instinct of many developers when they get reports of a slowing Application is to run straight into the code and start digging. Well, I've got news for you. Performance man, or woman, you're not going to find much without using tools and asking some questions first, the tooling comes first. If you don't have a monitoring and alerting tool already tracking the resource utilization and performance of your Application. Pause this video right now and go install something that Oh, okay, okay, wait, wait, wait, maybe don't go right now. I'm sure an awesome engineer like yourself already has something in place for this. When you're trying to find the root cause of latency or throughput issues, you have two categories of tools, reactive and proactive tools. The reactive tools provide you with information, after you have suffered the impact of a slowdown, the bulk of the tooling that ships with the JDK fall into this category. These tools are great for forensic analysis and they're generally free. So, you can only use a thread dump analyzer after you've captured a thread dump. And typically you're capturing a thread dump because you already have a problem. Same thing for jcmd, jstack and Java Flight Recorder. The Flight Recorder is a little bit of both, it can give you both reactive and proactive capabilities. Proactive tools will help you find or detect performance problems that are about to start or already in progress. My favorite practice tools are the kind that give you end to end visibility of your Application. Ideally, tools like these will provide alerting capabilities so that you can achieve proactive alerts for something like a CPU utilization spike, or a transaction time-outs threshold exceeded. So your pinpoints, Datadog, Prometheus, New Relic, the Java Mission Control and even jvisualvm could be proactive tools depending on how you deploy them. Pinpoint for example, will provide tracing visualizations that show you the end to end flow of your Application. It also shows you how long specific methods and API calls take to complete execution. Pinpoint is awesome, production grade and free. Please visit their site for videos and tutorials of this awesome tool. There's also a live demo available at the link on screen, pinpoint supports alerting, Docker deployments, distributed tracing, infrastructure metrics monitoring, and a web-based GUI. Without the tooling in place, the only thing you have left is to ask probing questions and hope that kind of leads you to the general area where the bottleneck may be, then what? Then you'd probably need to guess which methods might be degrading throughput, or is it latency? This uncertainty is why I covered the usual suspects first in this course, and the absence of tooling, guesswork is really all you have. Well, that's not entirely true, you can also use static analyzers as a fallback. A static analyzer is a tool that scans your code either as a command line tool or as an IDE plugin, check out the Programming Mistake Detector or PMD. PMD is a static analyzer that you can use to find issues in your code. It comes to the command line tool, and a very good IDE integration for the popular IDEs, Then there's also FindBugs. FindBugs has a lot of overlap with PMD. One main difference is that FindBugs can analyze Java class files. PMD works only with source file, that is .Javafiles. With PMD you can find performance problems by just right clicking on your code and having it run any number of scans. All told, you'll typically find that only a small fraction of latency or through problems can be identified by just looking at the code. In many real world scenarios, you're not likely to get the benefit of asking the end user to repeat a transaction or to send you the data so you can reproduce the problem in your development machine. You'll want to have these monitoring and alerting tools in place as a standard part of your Application deployment kit. At the very least, there should always be forensic data to review.