# *LifeUp* App Privacy Terms & Policy

?> The following description of the application server does not apply to the Lite version. The Lite version does not have any interaction with the application server.

LifeUp is an app that helps you improve your lifes. We respect your privacy and we are committed to protecting your personal information. This privacy policy explains how we collect, use, share and delete your personal information when you use our app.

### 1. Personal Information

LifeUp is an offline-first app. We do not actively collect user data, for example your name, email
address. You can optionally provide some data to authorize login to access the world module,
authorize Google Drive or Dropbox to obtain cloud backup capabilities, etc.

We use Google Firebase and Sentry to collect problem reports and performance data only for
analytical purposes.

Here are some data summaries:

- **Nickname, Avatar, Gender**
  Optional, used for the login function to access the "World" module, will be transferred to the server for storage, but can be changed and deleted
- **Email**
  Optional, for Google Drive sync, local storage, not transmitted to server
- **WebDAV URL, Account and Password**
  Optional, for WebDAV sync, local encrypted storage, not transmitted to server
- **Crash information, performance data**
  Transmitted to service providers (Google Firebase, Sentry) for problem and performance analysis, but never bound to user or device identifiers, nor contain user data

The detailed data collection and processing methods for each function are shown below.

#### 1.1 User information (third-party authorization)

##### Google/Facebook Sign In

**Only after you confirm the authorization to log in,** we will create an account with the nickname
and profile picture you authorized to provide (and will not include information such as email
accounts).

##### Google Drive

Since Google Drive backups depend on email addresses, *LifeUp* will apply for email address
permission when you authorize Google Drive. **But this address will only be used locally, *LifeUp*
will not pass it to the application server and storage.**

And *LifeUp* only applies for app-specific storage, which means we don't have permission to access
your private files.

##### DropBox

After you authorize DropBox, **the relevant information will only be kept on your device for backup.
and is not passed to the application server.**

And *LifeUp* only applies **for app-specific storage, which means we don't have permission to access
your private files.**

##### WebDAV Server

**Your WebDAV URL, account, and password information will only be stored locally and will not be
sent to the application server.** And the password is stored encrypted in the database.

##### Offline Mode

***LifeUp* is also fully allowed in offline mode, just it can not access to the "world" module.**

In offline mode,**you do not need to submit any information to our application server.**
**Your nickname, avatar and other information will be stored and available locally.**

We may only request the application server for the latest announcements and updates, which do not involve infomation submissions.

Your interactions with other SDKs like Dropbox, Google Drive, Facebook. These requests will respond normally under your active use.

In offline use, we may still use Google Firebase, Sentry to collect crash and problem reports, but as explained below, **this information does not contain user data and is not tied to user information. For performance analysis and crash resolution only, and only temporarily stored.**

We will also communicate with Google Play Services to verify your license based on Google Play's request.

If you want to deny all of the above communication, you can directly disable LifeUp's network request permission. This does not affect the use of LifeUp itself, but may affect the functionality of SDKs such as Google Drive.


#### 1.2 Permissions

#### Storage

The application **will not apply for storage space read permission**, so it will not read any files that are not authorized by you.

The application has applied for the camera permission to facilitate the user to use image attachments, upload avatars and other functions, and **will be able to call the camera only after the user granted the permissions.**

For example, when you select an attached image, we directly call the system's file storage framework to access it.

It will only authorize *LifeUp* the single file you select, we will not have permission to read other files.

At the same time, unless you actively share files outside the world module, they will only be stored locally and will not pass through the server.

#### Network

The network access permission is for access to the "WORLD" module, authorized login, and optional Dropbox/WebDAV synchronization and other functions.

#### Calendar

The application also provides the function of writing events to the system calendar application to remind you. 

**This function will require calendar read and write permissions, And this permission will require user authorization only when the user uses the corresponding function. And *LifeUp* will only read events written by the application itself.**

#### 1.3 Data Storage

**The application is an offline first application and does not have an build-in online
synchronization function, so most of the data is stored locally on the user's mobile phone.**

For example, all the local tasks you created, all the feelings recorded, the achievements you
designed, and the shop items.

**Only the content you actively share publicly in the "World" module will be stored on the server.
And these contents all support deletion and destruction operations.**

For example, the team you created in the "World" module, the activities you published after
completing the team tasks, the shop items that are actively shared, and so on.

At the same time, the vast majority of requests within the application will be transmitted in
encrypted form.

#### 1.4 Performance data and crash reports

We use [Google Firebase](https://firebase.google.com/) and [Sentry](https://sentry.io/) to collect user performance data and crash reports to track and fix issues.

This performance data may include your device model, network status, instance ID, when the problem occurred, and related pages, **but this data will not be associated with your user data** (Does not include your nickname, user id, email address and any contact information, and will not collect the content you enter and create) and will only be used to analyze the problem and improve performance.

And this data is only temporarily stored by Firebase and Sentry for a period of time, **and we will**
**not share/sell/rent it with third parties.**

#### 1.5 Data deletion

You can delete your account and personal information at any time by following these steps:

- Go to Settings - Data Backup/Restore/Clear page in the app
- Scroll down to the bottom and tap on Delete Account button
- Confirm your action

Alternatively, you can also contact us at our email address (kei.ayagi@gmail.com) and request us to delete your personal information. We will respond to your request within 30 days.

Please note that deleting your account and personal information will result in the loss of all your cloud data and progress in the app. You will not be able to access or restore your account or data after deletion. We may also retain some of your personal information for legal or operational purposes, such as complying with tax laws or resolving disputes.


### 2. Agreement

By using this application you agree to the terms of this privacy policy.

You agree that you are responsible for your own data.

We are not responsible in any way for any loss of data caused by or in connection with use of this
app since this is an offline-first application. 