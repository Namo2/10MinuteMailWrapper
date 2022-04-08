# 10MinuteMailWrapper

<!-- Badges -->
<img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/Namo2/10MinuteMailWrapper"> <img alt="GitHub issues" src="https://img.shields.io/github/issues-raw/Namo2/10MinuteMailWrapper"> <img alt="GitHub" src="https://img.shields.io/github/license/Namo2/10MinuteMailWrapper">

A Simple Java HTTP API wrapper for <a href="https://10minutemail.net/">10minutemail.net</a>

## Installation

### Install via the Maven Central Repository
`Will Follow soon`

### Install manually
<a href="https://github.com/Namo2/10MinuteMailWrapper/releases/latest">Browse latest Github releases</a>
</br>
After the download unzip the file and add it as a library into your project.

## Getting started

```java
TenMinuteMailDotNet tenMinuteMail = new TenMinuteMailDotNet();
        
// fetch the current mail
MailResponse mail = tenMinuteMail.getEmail();

// print the mail address
System.out.println(mail.getAddress());

// extend the expiration time to 100 Minutes
tenMinuteMail.resetTo100Minutes();

// fetch the latest email
MailContent latestEmail = tenMinuteMail.getLastEmailContent();
        
// create a new mail address
tenMinuteMail.generateNewEmailAddress();

// fetch the new generated email
MailResponse newMail = tenMinuteMail.getEmail();
```

## References

This project is based on the <a href="https://github.com/Zaczero/10MinuteMail.net">10MinuteMail.net Wrapper</a> from <a href="https://github.com/Zaczero/10MinuteMail.net/commits?author=Zaczero">Zaczero</a>, which was orginally written in C#
