# *LifeUp* App Privacy Terms & Policy

?> The following description of the application server does not apply to the Lite version. The Lite version does not have any interaction with the application server.

LifeUp is an app that helps you improve your life. We respect your privacy and we are committed to protecting your personal information. This privacy policy explains how we collect, use, share and delete your personal information when you use our app.

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

##### Dropbox

After you authorize Dropbox, **the relevant information will only be kept on your device for backup.
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

We may only request the application server for the latest announcements and updates, which do not involve information submissions.

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

**The application is an offline-first application and does not have a built-in online
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

#### 1.5 Data Deletion Request for *LifeUp Lite*

##### 1. Data Storage and Deletion

LifeUp Lite, the free version of LifeUp, primarily stores data on the user's device. We value your privacy and autonomy. In LifeUp Lite, since user accounts are not created, all personal data is stored locally on your device.

**To delete this data, simply uninstall the LifeUp Lite application from your device. Upon uninstallation, all locally stored data will be permanently removed.**

##### 2. Third-Party Services

LifeUp Lite integrates with third-party services such as Firebase and Admob for functionality and advertising purposes. Please note that the data collected by these services does not include personal information linked to your identity and is used in compliance with their respective privacy policies. This data is automatically deleted after a certain period as per the policies of these services.

##### 3. Assistance with Data Deletion

If you require assistance or have any questions regarding the deletion of your data, please feel free to contact us at lifeup@ulives.io. Our team is committed to assisting you with any queries or concerns related to your data privacy and will guide you through the process if needed.

##### 4. Compliance and Updates

We continuously review and update our practices to ensure compliance with the latest regulations and industry standards. This section of the Privacy Policy will be updated as necessary to reflect any changes in our data management and deletion processes.


#### 1.6 Data Deletion Request for *LifeUp Pro*

##### 1. Data Deletion in LifeUp Pro

LifeUp Pro users have the ability to delete their data independently within the app.

As LifeUp Pro is primarily an offline application, you can manage your data directly on your device. 

To delete your data, please follow these steps:

1. Go to the 'Settings - Data Backup/Restore/Clear' page in the LifeUp Pro app.
2. Choose the specific data you wish to delete, such as tasks, item rewards, local thoughts, and offline mode data.
3. Confirm your action to permanently delete the selected data.

**Alternatively, uninstalling the LifeUp Pro app from your device will also result in the deletion of all locally stored data.**



##### 2. Account Deletion in LifeUp Pro

Deleting your account in LifeUp Pro is a separate process from data deletion.

When you delete your account, it will remove:

- Your public posts, such as teams and updates, published on our servers.
- Your nickname and other personal information associated with your account.
- OAuth associations linked to your account.

**To delete your LifeUp Pro account, please follow the previously outlined steps:**

1. Navigate to the 'Settings - Data Backup/Restore/Clear' page.
2. Tap on the 'Delete Account' button at the bottom of the page.
3. Confirm your action to permanently delete your account and all associated information.

<br/>

**If you are no longer using the LifeUp Pro app but wish to delete your account and personal data, please contact us at [lifeup@ulives.io](mailto:lifeup@ulives.io).**

Provide us with the necessary details related to your account, and our team will assist you with the deletion process.

We are committed to ensuring your privacy and will handle your request with the utmost care and confidentiality.



##### 3. Third-Party Services

Similar to LifeUp Lite, LifeUp Pro integrates with third-party services such as Firebase for enhanced functionality. The data collected by these services is not personally identifiable and is managed in accordance with their privacy policies. This data is automatically scheduled for deletion after a certain period as per the third-party service policies.



##### 4. Updates and Compliance

We continuously monitor and update our practices to align with the latest privacy laws and industry standards. This section of the Privacy Policy will be amended as necessary to accurately reflect our data management and deletion processes for LifeUp Pro users.


### 2. Agreement

By using this application you agree to the terms of this privacy policy.

You agree that you are responsible for your own data.

We are not responsible in any way for any loss of data caused by or in connection with use of this app since this is an offline-first application. 