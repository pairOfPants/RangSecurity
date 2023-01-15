@authors Mantis Cacioppo, Aidan Denham, Simon Kowerski, Serene Siu
Created for the 2023 HackFree Hackathon
https://devpost.com/software/rang-security-for-all

##Inspiration##
Rang aims to take something that is overpriced and exploited, and make it accessible to everyone. Here at Rang, our mission is to help make information available and accessible to everyone, while doing so at an affordable price. That being so, Ring Doorbells are known for selling your data on the internet, being easily hackable, and extremely overpriced. So we draw our inspirations from Ring Doorbells. With our app, you can have equivalent power for a fraction of the cost.

##What it does##
Rang Cameras are an affordable security feature that have a built in motion detection system that can access and capture your computer's camera when any motion is detected. When our app is active, it will be able to send you a text message informing you of the security breach at your computer and let you see it in real time. Additional features include the ability to start and stop the feed, capture a photo, and toggle our security mode. Every Photo you take can be accessed via the cloud.

##How we built it##
It all starts in Java. When doing research I found out that there is an external library that can give coders access to their computer's web-camera in Java. Our team built a script that allows the user to take photos, videos, and toggle a motion detection system that, when online, will record a one-minute video and output it somewhere. The next question was pretty obvious, where was that somewhere? Google drive. Everyone uses drive and Google has an API that allows compatibility in Java using their cloud software. Now, we also wanted to let the users know when the security camera goes off, so a silent alarm will be tripped and the users will be texted (using Twilio) and will be sent a copy of the one-minute video. Finally, we created a website to represent our product using Wix, and voila, a complete app.

##Challenges we ran into##
Learning HTML and Javascript with no experience was definitely a challenge. Another big one was learning how to import external libraries, and this caused a four-hour delay in production as the libraries could not be imported properly. However, the biggest setback, would be Google's complicated API as it was extremely hard to use and Google's tutorial was far from easily to follow.

##Accomplishments that we're proud of##
The whole thing. This is easily the biggest project any of us had done and we could not be more proud of it.

##What we learned##
We have learned how to work with a web camera and to be able to capture/record a live feed. As well as the new languages required, we were able to look through complicated documentation and lackluster tutorials in order to learn the languages required for what we wanted to do. We also learned how to use new external platforms such as Twilio and Wix

##What's next for Rang: Security for All##
Next on our list is to find a way to make the cameras wireless, so that one could theoretically arm their whole house with webcameras and use our service.

Built With:
eclipse
html
java
maven
twilio
wix
