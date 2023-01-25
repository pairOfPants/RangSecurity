<h1 style="font-size:12px;"> Rang - Security for Everyone </h1>
<a href="https://github.com/simon-kowerski/RangSecurity/graphs/contributors" alt="Contributors">
        <img src="https://img.shields.io/github/contributors/simon-kowerski/RangSecurity" /></a>
<a href="https://img.shields.io/github/commit-activity/w/simon-kowerski/RangSecurity">
        <img src="https://img.shields.io/github/commit-activity/w/simon-kowerski/RangSecurity"></a>
<a href="https://img.shields.io/github/issues/simon-kowerski/RangSecurity">
        <img src="https://img.shields.io/github/issues/simon-kowerski/RangSecurity"></a>
<a href="https://destroybigcorporate.wixsite.com/rangrangrang">
        <img src="https://img.shields.io/website?url=https%3A%2F%2Fdestroybigcorporate.wixsite.com%2FRangRangRang"></a> 
 <a href="https://img.shields.io/github/downloads/simon-kowerski/RangSecurity/latest/total">
        <img src="https://img.shields.io/github/downloads/simon-kowerski/RangSecurity/latest/total"></a>
 <a href="https://www.paypal.com/donate/?business=7565XAPM5MC9U&no_recurring=0&item_name=All+donations+help+to+fund+RangSecurity+and+are+used+to+purchase+additional+cameras+to+help+start+the+comapny.+&currency_code=USD">
 <img src="https://img.shields.io/badge/PayPal-00457C?style=for-the-badge&logo=paypal&logoColor=white" /></a>
 <a href="https://github.com/pairOfPants">
        <img src="https://img.shields.io/github/followers/pairOfPants?style=social"></a>
 <br><i>Note: This project is unfinished. It was originally created by four high school students at a local hackathon, and further development is now being implemented.</i> <br>
Estimated Completion Date: <b>03-26-2023</b>
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
 <li><small><i><a href='https://github.com/simon-kowerski/RangSecurity/blob/main/README.md#-contributors-'>Contributors</a></i></small></li>
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
 Maven, for those who don't know, is a tool which helps import external java libraries. You don't need to download anything onto your IDE, because this project already is a maven build. All you need to do is locate the pom folder and make sure the following code is under the dependencies folder. 
                                        
     <dependencies>
        <!-- JUnit depencency for Maven Testing -->
        <dependency>
           <groupId>junit</groupId>
           <artifactId>junit</artifactId>
           <version>4.11</version>
           <scope>test</scope>
        </dependency>
 
         <!-- Webcaam Capture API for Webcam Feed -->
         <dependency>
           <groupId>com.github.sarxos</groupId>
           <artifactId>webcam-capture</artifactId>
           <version>0.3.11</version>
         </dependency>

        <!-- SLF4J depencency for Webcam Capture -->
        <dependency>
           <groupId>org.slf4j</groupId>
           <artifactId>slf4j-api</artifactId>
           <version>2.0.6</version>
        </dependency>
                                                               
        <!-- SLF4J depencency for Webcam Capture -->
        <dependency>
           <groupId>org.slf4j</groupId>
           <artifactId>slf4j-simple</artifactId>
           <version>2.0.6</version>
        </dependency>
                                                              
        <!-- Xuggle API for Creating Videos -->
        <dependency>
           <groupId>xuggle</groupId>
           <artifactId>xuggle-xuggler</artifactId>
           <version>5.4</version>
        </dependency>
                                                            
        <!-- Twilio API for Sending Texts -->
        <dependency>
            <groupId>com.twilio.sdk</groupId>
            <artifactId>twilio</artifactId>
            <version>9.2.1</version>
            <scope>compile</scope>
        </dependency>

        <!-- Dropbox API for Cloud Storage -->
        <dependency>
           <groupId>com.dropbox.core</groupId>
           <artifactId>dropbox-core-sdk</artifactId>
           <version>5.4.4</version>
        </dependency>
                                                             
        <!-- JavaMail API for Sending Emails -->
        <dependency>
          <groupId>javax.mail</groupId>
          <artifactId>javax.mail-api</artifactId>
          <version>1.6.2</version>
        </dependency>
     </dependencies>
 Note, you will also need to add the following code to your repositories folder:
 
    <repository>
        <id>xuggle repo</id>
        <url>https://files.liferay.com/mirrors/xuggle.googlecode.com/svn/trunk/repo/share/java/</url>
    </repository>
  
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
 <h2> Contributors </h2>
 Below is a list of all contributors and their roles/responsiilities in this project
 <ol>
 <li> pairOfPants - Head Developer, created the backend code for this project and systems tester </li>
 <li> simon-kowerski - Frontend Java Developer, created the GUI interface to run the backend code </li>
 <li> serene - Website Developer, made website in HTML, JavaScript, and CSS</li>
 <li> mantis - Assistant Java Backend Developer - Optimized code with Multithreading </li>
 </ol><br>
 <i>I highly reccomend visiting each individual's profile to view their other work, separate from this project.</i>
 <h2> How to Contribute </h2>
While our license prevents outside use for financial gain, feel free to contribute to this repository through pull requests. If you are looking for another way to contribute to this project, all donations to the paypal linked below are greatly appreciated, and they help speed up development astronomically.
 <br> <br>
 <a href="https://www.paypal.com/donate/?business=7565XAPM5MC9U&no_recurring=0&item_name=All+donations+help+to+fund+RangSecurity+and+are+used+to+purchase+additional+cameras+to+help+start+the+comapny.+&currency_code=USD">
 <img src="https://img.shields.io/badge/PayPal-00457C?style=for-the-badge&logo=paypal&logoColor=white" /></a>
 
<br>
 <h2> License </h2>
This project is protected under the Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International Public License. <br>In short, anyone can edit, download, and use our code as long as any modification is republished back to this repository and our code is not used for your own financial gain. To read the full license, click <small><i><a href='https://github.com/simon-kowerski/RangSecurity/blob/main/LICENSE'>HERE</a></i></small>
