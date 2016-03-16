Java ovh-api
==========
This project is a free java implementation of OVH Restfull API.
It cover for the moment only feew OVH services but it will grow over the time.

##How to use it
Before you can use the api you must create an application in your OVH Account. This can be donne on this URL

https://eu.api.ovh.com/createToken/

This URL allow you to create an application and give you the possibility to add credentials on services.

For sample, if you want to allow the application to send SMS you have to add [these credentials](https://eu.api.ovh.com/createToken/?GET=/sms/*&POST=/sms/*&PUT=/sms/*&DELETE=/sms/* "OVH Credentials for SMS")

You have to fill login and password of your OVH Account and you have to give a name to your application, a description and a validity period.

If all informations are right, OVH will give you three token:

 - application key
 - application secret
 - consumer key

There tokens are to put in Credential object of the api like this.

```java
...
String applicationKey = "AAAAA";
String applicationSecret = "BBBB";
String consumerKey = "CCC";
Credential smsCredential = new Credential(applicationKey, applicationSecret, consumerKey);
...
```

The credential objet must be put in all api object creation.

```java
...
Credential smsCredential = new Credential(applicationKey, applicationSecret, consumerKey);

SMSService smsService = new SMSService(smsCredential);
smsService.get...
...
```
