# MUSIC LIVE
## Table of Contents
1. [Overview] (#Overview)
2. [Product Spec](#Product Spec)
3. [Wireframes] (#Wireframes)
4. [Schemas] (#Schema)

## Overview
### Description

Music Live is a Haitian music app on which underground artist from all over the country
 can contact us to upload their songs on the app via this Email: "musiclive362@gmail.com"

This app is made for underground artists who are recording good music (lyrics, sound), but unfortunately 
their music doesn't play in any radio station, in any party but only their family, friends and some other people because they are unpopular artist.
so we create this app to help them share their music, so people listen to them, discover thier talents, their masterpiece.


### App Evaluation
- **Category:** Music
- **Mobile:** This app would be primarily developed for mobile but would perhaps be just as viable on a computer, such as tinder or other similar apps. Functionality wouldn’t be limited to mobile devices, however mobile version could potentially have more features.
- **Story:** Music Live Allows users  to see all the artists we have in the app and find their musics, it also allows users to listen to musics, to create his own playlists, to like a music, to comment under a music.
- **Market:** Any individual could choose to use this app, and to keep it a safe environment.
- **Habit:** This app could be used as often or unoften as the user wanted depending on how deep their social life is, and what exactly they're looking for, and also depending on how passionate they are about good musics.
- **Scope:** First we would start with listing all the artists and the user will choose which music he would like to listen to. He can even create his own playlist.

## Product Spec
### 1. User Stories (Required and Optional)
**Required Must-have Stories**
with this app User can 
- [x] log in 
- [x] Create new account 
- [x] Log out
- [x] view all artists and all songs belong to each artist
- [x] play a song from a list of song
- [x] view his profile
- [x] create  playlist.
- [x] Search and Discover music from the App.

**Optional Nice-to-have Stories**
- [ ] comment several times under a music.
- [ ] like or dislike a song.
- [ ] Play audio in the background.
	Continues playing while the screen is off or the app is in the background
- [ ] download music.

### 2. Screen Archetypes
* Welcome
	* It's like a splash screen, it will be displayed during 3 seconds
* Login
   	* User can login to account 
* Sign Up
	* User can create an account
* Home 
	* User can see all the artists in the app
* Search
	* User can search for a music by the title, by the artist name
* Results
	* When user makes a search, he will have a list of music showing up in a screen as result*
* PlayList 
	* User can create his own playlist based on what he prefers to listen to
* Artist songs 
	* It displays all the songs of the artist.
* Play Song
	* It display a play controller of the playing song, it allows users to like song or to add it in his playlist
* Profile
	* It allow users to see his profile and to update some content like his profile photo

## 3. Navigation
**Tab Navigation** (Tab to Screen)

 * Home
 * Search
 * Playlist
 * Profile

**Flow Navigation** (Screen to Screen)
* Welcome -> it sends user to the Login Screen in a few seconds
* Login	-> it sends users to the Home Screen or The Sign up screen
* Sign Up -> Create account and send user to the home Screen
* Home Screen -> Show a list of all the artists, when you click on a artist it sends you to the Artists songs which contain all the songs of that artist.

* Search
	* it displays a list of song based on what you are looking for.
* Playlist
 	* it displays a list of choosen song by the user
* Profile
	* It displays information about the user
 
## Wireframes
<img src="https://github.com/Best-Haitian-Music/MusicLive/blob/master/wireframes.jpeg" width=800><br> 

### [BONUS] Digital Wireframes & Mockups
<span><img src="https://github.com/Best-Haitian-Music/MusicLive/blob/master/signUp.png" height=200>
<img src="https://github.com/Best-Haitian-Music/MusicLive/blob/master/login.png" height=200>
<img src="https://github.com/Best-Haitian-Music/MusicLive/blob/master/home.png" height=200>
<img src="https://github.com/Best-Haitian-Music/MusicLive/blob/master/play%20song.png" height=200>
</span><br>
This is the figma's link "https://www.figma.com/proto/sED6oJWXK3kuV1nof74XRq/Untitled?node-id=10%3A4&scaling=min-zoom"


Schema 

Models

## User

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | objectId      | String   | unique id for the user (default field) |
   | name          | String   | name of the user  |
   | phone         | number   | The phone number of the user|
   | email         | String   | email for an user |
   | adress        | String   | Address of the user  |
   | image         | File     | profile image for an user  |
   | username      | String   | username for an user |
   | password      | String   | Password of the user                  |
   | createdAt     | DateTime | date when user is created (default field) |
   | updatedAt     | DateTime | date when user is last updated (default field) | 
   

## Song 

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | objectId      | String   | unique id for the song(default field) |
   | mp3           | File     | song of the artist |
   | cover         | File     | image cover for the song |
   | albumTitle    | String   | album title of the music  |
   | artist        | Pointer to Artist| song of artist |
   | title         | String   | song title |
   | genre         | String   | genre of the song |
   | commentsCount | Number   | number of comments that has been posted to an image |
   | likesCount    | Number   | number of likes for the post |
   | createdAt     | DateTime | date when post is created (default field) |
   | updatedAt     | DateTime | date when post is last updated (default field) |
   
   ## Artist 
   
   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | objectId      | String   | unique id for the user post (default field) |
   | image         | File     | Profile image for the artist|
   | name          | String   | name of the artist  |
   | phone         | number   | The phone number of the artist|
   | email         | String   | email for an artist |
   | SongsCount    | Number   | number of song that has been posted on the app |
   | createdAt     | DateTime | date when post is created (default field) |
   | updatedAt     | DateTime | date when post is last updated (default field) |
   
   
Networking

## Log in
(Read/GET) Query logged in user object

## Sign up
(Create/POST) create a new user 

## Home 
(Read/GET) query all artists

(Create/POST) Create a new like on a song

(Delete) Delete existing like

(Create/POST) Create a new comment on a song

(Delete) Delete existing comment

## Results 
(Read/Get) query all the songs related to the search of the user 

## Artist songs 
(Read/GET) query all the songs of the artist 

## Profile 
(Read/GET) Query logged in user object
(Update/PUT) Update user profile image 

## PlayList 
(Read/GET) Query all the songs that the user liked. 

[Create basic snippets for each Parse network request]
[OPTIONAL: List endpoints if using existing API such as Yelp]
