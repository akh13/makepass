# makepass
This is a java-based command-line utility used to generate secure, encrypted passwords using AES.

# How Do I Use This?

The first thing you need to do is make sure that you get the extended security jar files for your particular version of Java from Oracle.
Due to US restrictions on cryptography, stronger forms of encryption cannot be exported. For this reason you must download a few files:

[Oracle](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html)

I feel bad for the NSA agent tasked with following me. They probably think, "Wow, where does someone keep all of those NES games and bottles of Diet Dr Pepper."

If you ever see an invalidkeyexception, that's what is likely the cause. If you use these two .jar files and still get an invalidkeyexception,
this is likely because your key is...invalid. Make it divisible by two, and at least 64 characters in length.

The .class is there for demonstration purposes only. To run this thing from the command line:

> warhammer$ java Makepass

Type a decent password. '12345' is not a good idea. The utility will then return your encrypted key:

> F71CA771F5F913A44FD42A9BD2C6B943

> Here's the crypto key you asked for! Keep it safe.

Please keep in mind, the .class here was put together with an AES_KEY of 0-10 a bunch of times. **Do not use it without changing the AES_KEY variable.**
Once you change the key, save it and run `javac` over the .java file to make a version that can run as above.


