# Isolated Testing - using Stubs and Mocks

# Table of Contents
1. [Task 1 - Testing with Stubs](#task1)
2. [Task 2 - Testing with Mocks](#task2)
3. [Task 3 - Class Design for Test Isolation](#task3)
4. [Task 4 - Task 4 - Deepen and Consolidate Mock Knowlegde (optional)](#task4)


The Java Project "jukebox" is a simple implementation of a jukebox application, that can play selected songs. In this exercise you will practice isolated testing using the two concepts of Stubs and Mocks. The following diagram shows the important interfaces and classes.

The intention is to test the `MusicJukeBox' ` class independent of the implementation of the Song interface (the implementation does not yet exist). That means, you will just use the Song-Interface and simulate the behavior as needed for the tests.   

![Class Diagram for Stubbing](./doc/stub-diagram.png)

## Task 1 - Testing with Stubs <a name="task1"></a>

In this first task you will practice testing with simple Stubs.  
For test purposes the project already contains the class `JukeBoxStubTest` in the test folder, however there is no `SongStub` class yet. 

*Note: When you import/load the maven project it will not compile (yet), since the SongStub class is missing.*

### Introduction

The test class contains the following four tests:
1.	testPlayOfNonExistingSong tries to play a non-existing song. The MusicJukeBox should generate an exception in this case and verify the correct exception message.
2.	testGetPlayList adds two new songs to the MusicJukeBox and checks if the play list is not empty and the songs are in the list.
3.	testPlaySongs adds a new song to the MusicJukeBox and tries to play it. It also retrieves the current song and verifies if it is currently played.
4.	testPlayOfAlreadyPlayingSong adds a new song to the MusicJukeBox and tries to start the song two times. The second start of the already playing song should generate an exception caused by the Song class.

### Tasks

1. Add a minimal implementation of the stub class SongStub, meaning all methods return a hardcoded value. 

   *Before you start: In which directory do you store the file SongStub.java?*

   Can you make all tests pass by setting appropriate hardcoded return values?

2. Can you produce more green tests by adding additional stub classes?
 
3. Can you make all tests green with additional stub classes?

   Change the implementation of your stub classes such that all four tests pass. Still go for a minimal implementation. 
   
   Can you make a stateless implementation of SongStub?
   
   Do you have to store states in the SongStub class? If yes, which one? 


## Task 2 - Testing with Mocks<a name="task2"></a>

Stubs are very simplistic and should be used only for very simple tests. To implement thorough testing you rather there is a much more flexible approach - Mock-Objects.
Use Mock-Objects to simulate non-existing or complex objects. The following tasks will  demonstrate this.

You will use the Mockito-Framework for the mock-testing. First you have to include the newest stable version of the Mockito framework in the dependencies section of your pom-file. 

### Tasks

1. First; create a new test class JukeBoxMockTest to implement the following tests.
2. Lets start with the testGetPlayList() but now using Mock-Objects. 

   *Hint: Just copy paste the test code for this method from the JukeBoxStubTest class. What do you have to change to work with mocks?*
   
   Reflect about the differences between a mock vs stub vs CUT?
   
   Now extend the test so that it also tests if the song is added at most once to a playlist; even if it is added multiple times with addSong().
3. Now implement the method testPlayOfAlreadyPlayingSong() in which you verify that an exception is thrown, when an already playing song is started again with the playTitle() method. 
   Make sure the start() and getTitle()-methods were called in the correct frequencies. 
   
4. Create also the test method testPlaySong as in task 1. 
   Extend the test to solve the following problem: 
   
   How do you assure, that the MusicJukeBox is calling the Song objects in the correct order? I.e. that getTitle() is called before start() is called? 
5. Now implement a new test testActualSong-method in which you create a Song mock object. Test if the expected calls occur as follows:

When the method playTitle() is called on a MusicJukeBox, we expect that it looks for the Song object and starts it when found. This means, we expect at least one call of the method start().

## Task 3 - class design for test isolation<a name="task3"></a>

The current MusicJukeBox got its songs simply by calling the `addSong()` method. To broaden the song supply, we now connect our song service to a streaming service, to be able to download songs from the internet. A first draft was implemented and put up for discussion here: 

```java
public class SpotifyJukeBoxLoader {
    private SongService service = new SpotifySongService();
    private JukeBox jukebox = new MusicJukeBox();
    
    public SpotifyJukeBoxLoader(String spotifyID){
        for (Song song: service.getPlaylist(spotifyID)) {
            jukebox.addSong(song);
        }
    }
}
```

The class `SpotifySongService` shall download a playlist from Spotify and add the songs to our jukebox.

### Tasks
1. You immediately recognize the problem that arises when `SpotifyJukeBoxLoader` should be tested in isolation. Explain!
2. How can you test the class `SpotifyJukeBoxLoader` anyway? Make suggestions on how to change the Code to enable test isolation.

The implementation is left to the astute student :-)
You might want to have a look at [Spotify's Web-API](https://developer.spotify.com/documentation/web-api/)

##  Task 4 - Deepen and Consolidate Mock Knowlegde  (optional)<a name="task4"></a>
Work through the tutorials 1-3 and 5 of the tutorial serie https://www.softwaretestinghelp.com/mockito-tutorial/  

Some Notes:
- While we do not work with spys (they are not used very often), you should understand their purpose
- If you feel the need to mock private or static methods, read the first three paragraphs of tutorial 4: 

```
If the need arises to mock private and static methods/classes, it indicates 
poorly refactored code and is not really a testable code and is most likely 
that some legacy code which was not used to be very unit test friendly.
```


### More Resources

Martin Fowler on Mocks and Stubs:

https://martinfowler.com/articles/mocksArentStubs.html

Short Mockito Tutorial: 

https://www.vogella.com/tutorials/Mockito/article.html

Extensive Mockito Tutorial:

https://www.javacodegeeks.com/mockito-tutorials