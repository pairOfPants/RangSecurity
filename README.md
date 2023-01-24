<h1 style="font-size:60px;"> Rang - Security for Everyone </h1>
<i>Note: This project is unfinished. It was originally created by four high school students at a local hackathon, and further development is now being implemented.</i> <br>
Estimated Completion Date: <b>TBD</b>
<h2 style="font-size:30px;"> Project Description </h2>
Rang aims to take something that is overpriced and exploited, and make it accessible to everyone. Here at Rang, our mission is to help make information available and accessible to everyone, while doing so at an affordable price. We draw our inspirations from Ring Doorbells, and with our app, you can have equivalent power for a fraction of the cost.
<br> <br>
Rang Cameras are an affordable security feature that have built in motion detection and human verification systems that can access and capture your computer's camera(s) when any motion is detected. When our app is active, it will be able to send you a text message or email informing you of the security breach at your computer and let you see it in real time. Additional features include the ability to start and stop the feed, capture a photo, and toggle our security mode. Every Photo you take can be accessed locally and will *hopefully* be accessable from the cloud in the future.
<br>
<h4> Challenges Faced </h4>
<ul>
  <li>Utilizing Amazon Web Services API for cloud storage</li>
  <li>Connecting Multiple Cameras through Bluetooth</li>
  <li>Encrypting Information In Cloud</li>
</ul>
<h2 style="font-size:45px;"> Table of Contents </h2>
<ul>
  <li><small><i><a href='https://github.com/simon-kowerski/RangSecurity/blob/main/README.md#-project-description-'>Product Description</a></i></small></li>
  <li><small><i><a href='https://github.com/simon-kowerski/RangSecurity/blob/main/README.md#-image-gallery'>Image Gallery</a></i></small></li>
  <li><small><i><a href='https://github.com/simon-kowerski/RangSecurity/blob/main/README.md#-downloads-and-installation'>Downloads and Installation</a></i></small></li>
 <ol padding-bottom: 0;">
  <li style="margin-left:2em"><small><i><a href='https://github.com/simon-kowerski/RangSecurity/blob/main/README.md#-downlad-'>Download</a></i></small></li>
  <li style="margin-left:2em; padding-bottom: 0;"><small><i><a href='https://github.com/simon-kowerski/RangSecurity/blob/main/README.md#-install-'>Install</a></i></small></li>
  </ol>
  </li>
  <li><small><i><a href='https://github.com/simon-kowerski/RangSecurity/blob/main/README.md#-how-to-use-'>How to Use</a></i></small></li>
 <li><small><i><a href='https://github.com/simon-kowerski/RangSecurity/blob/main/README.md#-connecting-additional-cameras-'>Connecting Additional Cameras</a></i></small></li>
 <li><small><i><a href='https://github.com/simon-kowerski/RangSecurity/blob/main/README.md#-other-settings-'>Other Settings</a></i></small></li>
 <li><small><i><a href='https://github.com/simon-kowerski/RangSecurity/blob/main/README.md#-how-to-contribute-'>How to Contribute</a></i></small></li>
 <li><small><i><a href='https://github.com/simon-kowerski/RangSecurity/blob/main/README.md#-license-'>License</a></i></small></li>
 </ul>
 <h2> Image Gallery</h2>
 <h2> Downloads and Installation</h2>
 <h3> Downlad </h3>
 Here is the .zip file for you to download and add to any eclipse workspace. Eventually the final version of this project will be in a .exe format and will be found on Rang's company website (still in development)
 <br>Download File: <i>not working currently </i>
 <h3> Install </h3>
 The first thing to do, once the zip is download, is to import all the external libraries, I have done this through maven. Attatched is the pom file, feel free to copy it. I will also attatch everything here:
 <h4> Maven </h4>
 <h2> How to Use </h2>
 Once the application is downloaded and installed, just run the program and everything should be self-explanatory. You will need to create a directory to store photos and videos on, I reccomend an external hard drive but any directory will do. We also ask for your phone number and email which are used to send texts and emails accordingly when security mode is on and there is an alert, but know that Rang does not store this information and these contacts will be stored locally on text files inside the project directory. 
<br> Here is a brief overviw of each of the functions, as they stand in current development:
 <ol> 
 <li> Capture Photo: Takes a photo from your camera's webcam and stores it inside capture directory </li>
 <li> Start/Stop Video: Takes a video (bursts of photos) from the duration the start button is hit until the stop button is hit </li>
 <li> Security Mode: Off means that you will not recieve alerts, on means that every time motion is detected the program will record a 40 second video, save it, and email it out to you (assuming you elect to have emails)</li>
<li> Settings: <i>Still in development</i></li>
<li> Multi-Camera Arrangement: <i>Still in development</i></li>
 <h2> Connecting Additional Cameras </h2>
 <b> To Be Implemented </b>
 <h2> Other Settings </h2>
 Other settings thus far include the ability to control the arrangement of your computer's webcams, if multiple are installed, the ability to choose push notifications, the ability to add and remove cameras from the system, and the ability to change the directory of where the videos are stored, or even store them in the cloud. <br> Settings to be incoorporated include the ability to capture a screen recording during security mode in addition to camera recording, the option to record audio, and the ability to change the length and quality of the security mode videos, for file size and performance purposes.
 <h2> How to Contribute </h2>
 <b> To Be Implemented </b>
 <h2> License </h2>
This project is protected under the Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International Public License. <br>In short, anyone can edit, download, and use our code as long as any modification is republished back to this repository and our code is not used for your own financial gain. To read the full license, click <small><i><a href='https://github.com/simon-kowerski/RangSecurity/blob/main/LICENSE'>HERE</a></i></small>
